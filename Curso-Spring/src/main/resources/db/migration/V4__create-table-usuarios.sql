CREATE TABLE usuario(
id bigint not null auto_increment,
name VARCHAR(100)UNIQUE NOT NULL,
email VARCHAR(100) NOT NULL,
password VARCHAR(100) NOT NULL,

primary key(id)
);