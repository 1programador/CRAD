create database crad;

use crad;


create table usuario(id int auto_increment primary key,
nome varchar(50) not null,
matricula varchar(15) not null,
perfil enum('ALUNO','PROFESSOR','COORDENADOR') not null
);

create table servico(id int auto_increment primary key,
descricao varchar(150) not null,
status tinyint not null default 1,
anexo tinyint not null default 0,
complemento tinyint not null default 0
);
