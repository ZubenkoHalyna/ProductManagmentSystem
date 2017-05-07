DROP TABLE products;
create TABLE products
(
id            serial,
name          varchar(20) NOT NULL,
producer      varchar(50) NOT NULL,
description   varchar(100) NOT NULL,
price         int
);

insert into products(name, producer, price, description)
VALUES('telephone','samsung',1000,'desc'),
  ('telephone','apple',3000,'desc 2');

DROP TABLE users;
create TABLE users
(
  id            serial,
  login         varchar(20) NOT NULL,
  password      varchar(20) NOT NULL,
  role          int NOT NULL
);

insert into users(login, password, role)
VALUES('user','user',0),
  ('admin','root',1);