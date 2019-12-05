CREATE OR REPLACE TRIGGER update_total_price
    AFTER INSERT
    on PACKAGE_SERVICE
    FOR EACH ROW
DECLARE
    cur_price     NUMERIC(12, 2);
    new_price     NUMERIC(12, 2) DEFAULT 1;
    service_price NUMERIC(12, 2);
BEGIN
    SELECT total_price INTO cur_price FROM PACKAGE p WHERE p.id = :new.PACKAGE_ID;
    SELECT s.price INTO service_price FROM SERVICE s WHERE s.id = :new.SERVICE_ID;
    new_price := service_price + cur_price;
    UPDATE PACKAGE p SET p.TOTAL_PRICE = new_price WHERE p.id = :new.PACKAGE_ID;
END;
