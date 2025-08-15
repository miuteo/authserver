insert into users(username,password,enabled) values('teo','{bcrypt}$2a$10$a.1QLd00nUhhF7UZUS7cM.QCM9GzD63Bi0in9Sp4ibTscWp3jYU9m',true);
insert into users(username,password,enabled) values('axy','{noop}testnooppassword',true);

insert into authorities(username,authority) values('teo','ROLE_USER');
insert into authorities(username,authority) values('axy','ROLE_USER');
insert into authorities(username,authority) values('teo','ROLE_ADMIN');