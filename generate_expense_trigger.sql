CREATE OR REPLACE TRIGGER generate_expense
    AFTER INSERT
    on PACKAGE_SERVICE
    FOR EACH ROW
DECLARE
    price       NUMERIC(12, 2);
    issue_date  DATE;
    status      Varchar(10);
    parcels     INTEGER;
    due_days    INTEGER;
    due_date    DATE;
    supplier_id INTEGER;
BEGIN
    SELECT price INTO price from SERVICE s WHERE s.ID = :new.SERVICE_ID;
    SELECT SYSDATE into issue_date FROM DUAL;
    SELECT pm.parcels
    into parcels
    from SERVICE s
             JOIN PAYMENT_METHOD pm ON s.PAYMENT_METHOD_ID = pm.ID
    WHERE s.ID = :new.SERVICE_ID;
    SELECT s.supplier_id into SUPPLIER_ID from SERVICE s WHERE s.ID = :new.SERVICE_ID;
    SELECT pm.DUE_DAYS
    into DUE_DAYS
    from SERVICE s
             JOIN PAYMENT_METHOD pm ON s.PAYMENT_METHOD_ID = pm.ID
    WHERE s.ID = :new.SERVICE_ID;
    due_date := (issue_date + due_days);
    status := 'ABERTA';
    INSERT INTO EXPENSE(parcels, issue_date, due_date, value, status, package_id, supplier_id)
    VALUES (parcels, issue_date, due_date, price, status, :new.package_id, supplier_id);
END;
