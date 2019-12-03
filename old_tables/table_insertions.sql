
INSERT INTO client(name, CPF_CNPJ, city, country, UF, address, phone, email, person_type)
values ('ROBERTO', '02943047031', 'SANTA MARIA', 'BRAZIL', 'DF', 'JOAO GOULART', '53999739562', 'MENEGAIS1@GMAIL.COM',
        'FISICA');

INSERT INTO client(name, CPF_CNPJ, city, country, UF, address, phone, email, person_type)
values ('ASPIRA', '02130472121', 'SANTA MARIA', 'BRAZIL', 'DF', 'BOTINHA', '12345689098', 'ASPIRA@GMAIL.COM',
        'FISICA');

INSERT INTO supplier(name, CNPJ, city, country, UF, address, phone, email)
VALUES ('UFSM', '1233456765432', 'SANTA MARIA', 'BRAZIL', 'RS', 'RORAIMA', '992123313', 'UFSM@GMAIL.BR');

INSERT INTO SERVICE_TYPE(name)
values ('Hotel');
INSERT INTO SERVICE_TYPE(name)
values ('Aluguel de carro');
INSERT INTO SERVICE_TYPE(name)
values ('Cruzeiro');

INSERT INTO PAYMENT_METHOD(name)
VALUES ('A VISTA');

INSERT INTO SERVICE(name, price, payment_method_id, service_type_id, supplier_id)
VALUES ('Cruzeiro pelas bahamas', 200000, 1, 3, 1);
INSERT INTO SERVICE(name, price, payment_method_id, service_type_id, supplier_id)
VALUES ('Aluguel de carro no caribe', 2000, 1, 2, 1);
INSERT INTO SERVICE(name, price, payment_method_id, service_type_id, supplier_id)
VALUES ('Hospedagem em cancum', 80000, 1, 1, 1);


INSERT INTO PACKAGE(total_price, order_date, serial, client_id, service_id)
VALUES (10000, '11-12-2000', 1, 1, 1);
INSERT INTO PACKAGE(total_price, order_date, serial, client_id, service_id)
VALUES (10000, '11-12-2000', 1, 1, 2);
INSERT INTO PACKAGE(total_price, order_date, serial, client_id, service_id)
VALUES (10000, '11-12-2000', 1, 1, 3);
INSERT INTO PACKAGE(total_price, order_date, serial, client_id, service_id)
VALUES (5000, '12-12-2000', 2, 2, 1);
INSERT INTO PACKAGE(total_price, order_date, serial, client_id, service_id)
VALUES (5000, '12-12-2000', 2, 2, 3);
COMMIT;
