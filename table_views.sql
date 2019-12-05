CREATE OR REPLACE VIEW services_per_package as
SELECT p.id,
       (LISTAGG(s.name, '; ') WITHIN GROUP (ORDER BY s.name)) as services
FROM SERVICE s
         JOIN PACKAGE_SERVICE ps on ps.service_id = s.id
         JOIN PACKAGE p on p.id = ps.PACKAGE_ID
group by p.id;

CREATE OR REPLACE VIEW package_concat as
SELECT P.id,
       c.name,
       p.total_price,
       TO_CHAR(p.order_date, 'DD/MM/YYYY') as order_date,
       sp.services
FROM package p
         left JOIN CLIENT c on p.client_id = c.id
         left JOIN services_per_package sp on p.id = sp.id
ORDER BY p.ORDER_DATE;

CREATE OR REPLACE VIEW SOON_TO_EXPIRE_EXPENSE as
SELECT s.id,
       s.name,
       s.cnpj,
       TO_CHAR(e.DUE_DATE, 'DD/MM/YYYY') AS due_date,
       CEIL(DUE_DATE - CURRENT_DATE)     AS days_to_expire,
       e.VALUE,
       e.STATUS
from EXPENSE e
         JOIN SUPPLIER s ON e.SUPPLIER_ID = s.id
WHERE e.STATUS = 'ABERTA'
  AND e.DUE_DATE - CURRENT_DATE < 3
ORDER BY e.DUE_DATE;

CREATE OR REPLACE VIEW EXPIRED_EXPENSES as
SELECT s.id,
       s.name,
       s.cnpj,
       TO_CHAR(e.DUE_DATE, 'DD/MM/YYYY') as due_date,
       CEIL(CURRENT_DATE - DUE_DATE)     AS expired_days,
       e.VALUE,
       e.STATUS
from EXPENSE e
         JOIN SUPPLIER s ON e.SUPPLIER_ID = s.id
WHERE CURRENT_DATE - DUE_DATE >= 1
ORDER BY e.DUE_DATE;
