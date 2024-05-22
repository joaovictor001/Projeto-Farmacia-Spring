CREATE TABLE remedio(
id bigint not null auto_increment,
nome VARCHAR(100) NOT NULL,
via VARCHAR(100) NOT NULL,
lote VARCHAR(100) NOT NULL,
quantidade int NOT NULL,
validade VARCHAR(100) NOT NULL,
laboratorio VARCHAR(100) NOT NULL,

primary key(id)
);