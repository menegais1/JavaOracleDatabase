CREATE TABLE service_type
(
    id   INTEGER GENERATED ALWAYS as IDENTITY primary key,
    name VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE payment_method
(
    id       INTEGER GENERATED ALWAYS as IDENTITY primary key,
    name     VARCHAR(100) UNIQUE NOT NULL,
    parcels  INTEGER DEFAULT 1   NOT NULL,
    due_days INTEGER DEFAULT 0   NOT NULL
);

CREATE TABLE supplier
(
    id      INTEGER GENERATED ALWAYS as IDENTITY primary key,
    name    VARCHAR(255)       NOT NULL,
    CNPJ    VARCHAR(14) UNIQUE NOT NULL,
    city    VARCHAR(100)       NOT NULL,
    country VARCHAR(100)       NOT NULL,
    UF      VARCHAR(3),
    address VARCHAR(255)       NOT NULL,
    phone   VARCHAR(14)        NOT NULL,
    email   VARCHAR(100)       NOT NULL
);

CREATE TABLE service
(
    id                INTEGER GENERATED ALWAYS as IDENTITY primary key,
    name              VARCHAR(255)   NOT NULL,
    price             DECIMAL(12, 2) NOT NULL,
    payment_method_id INTEGER        NOT NULL,
    service_type_id   INTEGER        NOT NULL,
    supplier_id       INTEGER        NOT NULL,
    FOREIGN KEY (payment_method_id) REFERENCES payment_method ON DELETE SET NULL,
    FOREIGN KEY (supplier_id) REFERENCES supplier ON DELETE CASCADE,
    FOREIGN KEY (service_type_id) REFERENCES service_type ON DELETE CASCADE
);

CREATE TABLE client
(
    id          INTEGER GENERATED ALWAYS as IDENTITY primary key,
    name        VARCHAR(255)       NOT NULL,
    CPF_CNPJ    VARCHAR(14) UNIQUE NOT NULL,
    city        VARCHAR(100)       NOT NULL,
    country     VARCHAR(100)       NOT NULL,
    UF          VARCHAR(3),
    address     VARCHAR(255)       NOT NULL,
    phone       VARCHAR(14)        NOT NULL,
    email       VARCHAR(100)       NOT NULL,
    person_type VARCHAR(10) CHECK ( person_type in ('FISICA', 'JURIDICA'))
);

CREATE TABLE package
(
    id                INTEGER GENERATED ALWAYS as IDENTITY primary key,
    total_price       DECIMAL(12, 2) DEFAULT 0,
    order_date        DATE           NOT NULL,
    client_id         INTEGER        NOT NULL,
    payment_method_id INTEGER,
    FOREIGN KEY (payment_method_id) REFERENCES payment_method ON DELETE SET NULL,
    FOREIGN KEY (client_id) REFERENCES client ON DELETE CASCADE
);

CREATE TABLE package_service
(
    id         INTEGER GENERATED ALWAYS as IDENTITY primary key,
    service_id INTEGER NOT NULL,
    package_id INTEGER NOT NULL,
    UNIQUE(service_id, package_id),
    FOREIGN KEY (service_id) REFERENCES service ON DELETE CASCADE,
    FOREIGN KEY (package_id) REFERENCES package ON DELETE CASCADE
);

CREATE TABLE revenue
(
    id         INTEGER GENERATED ALWAYS as IDENTITY primary key,
    parcels    INTEGER DEFAULT 1 NOT NULL,
    issue_date DATE              NOT NULL,
    due_date   DATE              NOT NULL,
    value      DECIMAL(12, 2)    NOT NULL,
    status     VARCHAR(10) CHECK (status IN ('ABERTA', 'QUITADA')),
    package_id INTEGER           NOT NULL,
    FOREIGN KEY (package_id) REFERENCES package ON DELETE set null
);

CREATE TABLE expense
(
    id          INTEGER GENERATED ALWAYS as IDENTITY primary key,
    parcels     INTEGER DEFAULT 1 NOT NULL,
    issue_date  DATE              NOT NULL,
    due_date    DATE              NOT NULL,
    value       DECIMAL(12, 2)    NOT NULL,
    status      VARCHAR(10) CHECK (status IN ('ABERTA', 'QUITADA')),
    package_id  INTEGER,
    supplier_id INTEGER,
    FOREIGN KEY (package_id) REFERENCES package ON DELETE set null,
    FOREIGN KEY (supplier_id) REFERENCES supplier ON DELETE set null
);