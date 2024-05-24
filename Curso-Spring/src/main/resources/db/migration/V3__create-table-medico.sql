CREATE TABLE medico(
id bigint not null auto_increment,
nome VARCHAR(100) NOT NULL,
especialidade VARCHAR(100) NOT NULL,
crm VARCHAR(100) NOT NULL,
telefone VARCHAR(100) NOT NULL,
email VARCHAR(100) NOT NULL,
ativo boolean NOT NULL,

primary key(id)

)