

CREATE VIEW services_concat_per_package as
SELECT DISTINCT p.serial,
                (LISTAGG(name, '; ') WITHIN GROUP (ORDER BY name)) as services
from SERVICE s
         join PACKAGE p on p.service_id = s.id
group by p.serial;

CREATE VIEW package_concat as
SELECT DISTINCT p.serial,
                p.total_price,
                p.order_date,
                c.name,
                sp.services
                    as services
FROM package p
         left JOIN CLIENT c on p.client_id = c.id
         left JOIN SERVICE s on p.service_id = s.id
         left JOIN services_concat_per_package sp on sp.serial = p.serial;

