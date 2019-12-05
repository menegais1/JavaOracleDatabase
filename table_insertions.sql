INSERT INTO client(name, CPF_CNPJ, city, country, UF, address, phone, email, person_type)
values ('ROBERTO', '02943047031', 'SANTA MARIA', 'BRAZIL', 'RS', 'JOAO GOULART', '53999739562', 'MENEGAIS1@GMAIL.COM',
        'FISICA');

INSERT INTO client(name, CPF_CNPJ, city, country, UF, address, phone, email, person_type)
values ('ASPIRA', '02463737038', 'SANTA MARIA', 'BRAZIL', 'RS', 'JOAO MACHADO S', '12345689098', 'ASPIRA@GMAIL.COM',
        'FISICA');

INSERT INTO client(name, CPF_CNPJ, city, country, UF, address, phone, email, person_type)
values ('SUCO DE FRUTA', '02130472424', 'BRASILIA', 'BRAZIL', 'DF', 'BOTINHA', '12345682424', 'SUCO_DE_FRUTA@GMAIL.COM',
        'FISICA');

INSERT INTO client(name, CPF_CNPJ, city, country, UF, address, phone, email, person_type)
values ('WILIAO', '02130476666', 'SANTA MARIA', 'BRAZIL', 'RS', 'BOTINHA', '12345686666', 'WILLIAO@GMAIL.COM',
        'FISICA');

INSERT INTO client(name, CPF_CNPJ, city, country, UF, address, phone, email, person_type)
values ('NATHAN', '02943049037', 'GRAMADO', 'BRAZIL', 'RS', 'AV HORTENSIAS', '51999731010', 'NATE@GMAIL.COM',
        'FISICA');

INSERT INTO client(name, CPF_CNPJ, city, country, UF, address, phone, email, person_type)
values ('THIAGO', '02463732224', 'SANTA MARIA', 'BRAZIL', 'RS', 'RUA APPEL', '51936890988', 'T_AGO@GMAIL.COM',
        'FISICA');

INSERT INTO client(name, CPF_CNPJ, city, country, UF, address, phone, email, person_type)
values ('TIJOLINHO', '03210472722', 'SANTA MARIA', 'BRAZIL', 'RS', 'BOTINHA', '55994582290', 'TIJOLANZA@GMAIL.COM',
        'FISICA');

INSERT INTO client(name, CPF_CNPJ, city, country, UF, address, phone, email, person_type)
values ('JOAO', '02130471000', 'SANTA MARIA', 'BRAZIL', 'RS', 'AV MEDIANEIRA', '55985686677', 'J_AUM@GMAIL.COM',
        'FISICA');

INSERT INTO client(name, CPF_CNPJ, city, country, UF, address, phone, email, person_type)
values ('HAVAN', '12345678900', 'SANTA MARIA', 'BRAZIL', 'RS', 'BR-258', '5532218666', 'L_HAVAN@GMAIL.COM',
        'JURIDICA');

INSERT INTO client(name, CPF_CNPJ, city, country, UF, address, phone, email, person_type)
values ('UBISOFT', '03001068000183', 'SAO PAULO', 'BRAZIL', 'SP', 'R CASA DO ATOR', '113284-2828', 'UBISOFT@GMAIL.COM',
        'JURIDICA');


INSERT INTO supplier(name, CNPJ, city, country, UF, address, phone, email)
VALUES ('UFSM', '1233456765432', 'SANTA MARIA', 'BRAZIL', 'RS', 'AV RORAIMA', '992123313', 'UFSM@INF.UFSM.BR');

INSERT INTO supplier(name, CNPJ, city, country, UF, address, phone, email)
VALUES ('DECOLAR.COM', '123345670000', 'SAO PAULO', 'BRAZIL', 'RS', 'AV PAULISTA', '992124413', 'DECOLAR_PTO_COM@GMAIL.BR');

INSERT INTO supplier(name, CNPJ, city, country, UF, address, phone, email)
VALUES ('TRIVAGO', '123345671111', 'PORTO ALEGRE', 'BRAZIL', 'RS', 'AV PANAMERICANA', '992124610', 'TRIVAGO@GMAIL.BR');

INSERT INTO supplier(name, CNPJ, city, country, UF, address, phone, email)
VALUES ('CANDEIAS', '43446434000122', 'SANTA MARIA', 'BRAZIL', 'RS', 'AV RIO BRANCO', '5532202461', 'CANDEIAS@GMAIL.BR');

INSERT INTO supplier(name, CNPJ, city, country, UF, address, phone, email)
VALUES ('CVC', '10760260000119', 'SANTA MARIA', 'BRAZIL', 'RS', 'AV FERNANDO FERRARI', '5534322556', 'CVC@GMAIL.BR');

INSERT INTO supplier(name, CNPJ, city, country, UF, address, phone, email)
VALUES ('VIAMAR', '02020620000541', 'SANTA MARIA', 'BRAZIL', 'RS', 'AV VENANCIO AIRES', '5533122416', 'TRIVAGO@GMAIL.BR');

INSERT INTO supplier(name, CNPJ, city, country, UF, address, phone, email)
VALUES ('VIP TURISMO', '20816098000167', 'TRAMANDAI', 'BRAZIL', 'RS', 'R DARCI RIBEIRO PINTO', '5136847339', 'CLUBVIPTURISMO@GMAIL.BR');

INSERT INTO supplier(name, CNPJ, city, country, UF, address, phone, email)
VALUES ('EVENTUR', '080044680001 ', 'SALVADOR', 'BRAZIL', 'BA', 'AV OCEANICA', '7533122416', 'EVENTUR@BOL.COM.BR');

INSERT INTO supplier(name, CNPJ, city, country, UF, address, phone, email)
VALUES ('JURASSIC PARK', '100000000000', 'RIO BRANCO', 'BRAZIL', 'AC', 'R ESQUECIDA', '0000000001', 'JPARK@GMAIL.BR');

INSERT INTO supplier(name, CNPJ, city, country, UF, address, phone, email)
VALUES ('TRAVEL TUR', '044277290001', 'SANTA MARIA', 'BRAZIL', 'RS', 'R ANDRADAS', '5532102510', 'TRAV_TUR@GMAIL.BR');

INSERT INTO SERVICE_TYPE(name)
values ('Hotel');
INSERT INTO SERVICE_TYPE(name)
values ('Aluguel de carro');
INSERT INTO SERVICE_TYPE(name)
values ('Cruzeiro');
INSERT INTO SERVICE_TYPE(name)
values ('Passagens areas');
INSERT INTO SERVICE_TYPE(name)
values ('Pacotes turisticos');


INSERT INTO PAYMENT_METHOD(name)
VALUES ('A VISTA');
INSERT INTO PAYMENT_METHOD(name,due_days)
VALUES ('A PRAZO 30 DIAS',30);

INSERT INTO SERVICE(name, price, payment_method_id, service_type_id, supplier_id)
VALUES ('Cruzeiro pelas Bahamas',200000, 1, 3, 1);
INSERT INTO SERVICE(name, price, payment_method_id, service_type_id, supplier_id)
VALUES ('Cruzeiro pelo Mediterraneo',300000, 2, 3, 2);
INSERT INTO SERVICE(name, price, payment_method_id, service_type_id, supplier_id)
VALUES ('Cruzeiro pela Europa', 400000, 2, 3, 3);
INSERT INTO SERVICE(name, price, payment_method_id, service_type_id, supplier_id)
VALUES ('Aluguel de carro no Caribe', 2000, 1, 2, 4);
INSERT INTO SERVICE(name, price, payment_method_id, service_type_id, supplier_id)
VALUES ('Aluguel de carro no Egito', 1000, 1, 2, 4);
INSERT INTO SERVICE(name, price, payment_method_id, service_type_id, supplier_id)
VALUES ('Aluguel de carro na Inglaterra', 3000, 1, 2, 5);
INSERT INTO SERVICE(name, price, payment_method_id, service_type_id, supplier_id)
VALUES ('Hospedagem em cancum', 80000, 1, 1, 1);
INSERT INTO SERVICE(name, price, payment_method_id, service_type_id, supplier_id)
VALUES ('Hospedagem em acapulco', 10000, 1, 1, 1);
INSERT INTO SERVICE(name, price, payment_method_id, service_type_id, supplier_id)
VALUES ('Hospedagem em Paris', 10000, 2, 1, 7);
INSERT INTO SERVICE(name, price, payment_method_id, service_type_id, supplier_id)
VALUES ('Hospedagem em Roma', 10000, 2, 1, 8);

INSERT INTO PACKAGE(order_date, client_id)
VALUES ('11-12-2000', 1);
INSERT INTO PACKAGE(order_date, client_id)
VALUES ('12-12-2000', 2);
INSERT INTO PACKAGE(order_date, client_id)
VALUES ('12-12-2001', 2);
INSERT INTO PACKAGE(order_date, client_id)
VALUES ('12-12-2010', 3);
INSERT INTO PACKAGE(order_date, client_id)
VALUES ('12-11-2013', 4);
INSERT INTO PACKAGE(order_date, client_id)
VALUES ('12-10-2014', 5);
INSERT INTO PACKAGE(order_date, client_id)
VALUES ('12-09-2015', 2);
INSERT INTO PACKAGE(order_date, client_id)
VALUES ('12-01-2016', 7);
INSERT INTO PACKAGE(order_date, client_id)
VALUES ('12-12-2018', 8);
INSERT INTO PACKAGE(order_date, client_id)
VALUES ('05-01-2019', 9);

INSERT INTO PACKAGE_SERVICE(package_id, service_id)
values (1, 1);
INSERT INTO PACKAGE_SERVICE(package_id, service_id)
values (1, 2);
INSERT INTO PACKAGE_SERVICE(package_id, service_id)
values (1, 3);
INSERT INTO PACKAGE_SERVICE(package_id, service_id)
values (2, 1);
INSERT INTO PACKAGE_SERVICE(package_id, service_id)
values (2, 3);
INSERT INTO PACKAGE_SERVICE(package_id, service_id)
values (3, 2);
INSERT INTO PACKAGE_SERVICE(package_id, service_id)
values (3, 4);
INSERT INTO PACKAGE_SERVICE(package_id, service_id)
values (3, 8);
INSERT INTO PACKAGE_SERVICE(package_id, service_id)
values (2, 6);
INSERT INTO PACKAGE_SERVICE(package_id, service_id)
values (2, 2);
COMMIT;