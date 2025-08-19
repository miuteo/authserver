CREATE TABLE users_temp (
    username VARCHAR(50) NOT NULL PRIMARY KEY,
    password VARCHAR(500) NOT NULL,
    enabled BOOLEAN NOT NULL
);

CREATE TABLE authorities_temp (
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    CONSTRAINT fk_authorities_users_temp FOREIGN KEY(username) REFERENCES users_temp(username)
);

INSERT INTO users_temp (username, password, enabled)
SELECT username, password, enabled FROM users;

INSERT INTO authorities_temp (username, authority)
SELECT username, authority FROM authorities;

drop table authorities;
drop table users;

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(500) NOT NULL,
    enabled BOOLEAN NOT NULL
);

CREATE TABLE authorities (
    id SERIAL PRIMARY KEY,
    username_id INTEGER NOT NULL,
    authority VARCHAR(50) NOT NULL,
    CONSTRAINT fk_authorities_users 
        FOREIGN KEY(username_id) 
        REFERENCES users(id) 
        ON DELETE CASCADE,
    CONSTRAINT ix_auth_username UNIQUE (username_id, authority)
);


INSERT INTO users (username, password, enabled)
SELECT username, password, enabled FROM users_temp;


INSERT INTO authorities (username_id, authority)
SELECT  ut.id, at.authority
FROM authorities_temp as at
         join users as ut on at.username = ut.username;

drop table authorities_temp;
drop table users_temp;