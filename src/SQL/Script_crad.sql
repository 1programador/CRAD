create database crad;

use crad;


create table usuario(id int auto_increment primary key,
nome varchar(50) not null,
matricula varchar(15) not null unique,
perfil enum('ALUNO','PROFESSOR','COORDENADOR') not null
);

create table servico(id int auto_increment primary key,
descricao varchar(150) not null unique,
status boolean not null default true,
anexo boolean not null,
complemento boolean not null
);
