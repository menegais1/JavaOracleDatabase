CREATE VIEW services_per_package as
SELECT p.id,
       (LISTAGG(s.name, '; ') WITHIN GROUP (ORDER BY s.name)) as services
FROM SERVICE s
         JOIN PACKAGE_SERVICE ps on ps.service_id = s.id
         JOIN PACKAGE p on p.id = ps.PACKAGE_ID
group by p.id;

CREATE VIEW package_concat as
SELECT p.total_price,
       p.order_date,
       c.name,
       sp.services
FROM package p
         left JOIN CLIENT c on p.client_id = c.id
         left JOIN services_per_package sp on p.id = sp.id;

