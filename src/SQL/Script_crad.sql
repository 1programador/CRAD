create database crad;

use crad;


create table usuario(id int auto_increment primary key,
nome varchar(50) not null,
matricula varchar(15) not null unique,
status boolean default true,
perfil enum('ALUNO','PROFESSOR','COORDENADOR') not null
);

create table tipo_solicitacao(id int auto_increment primary key,
descricao varchar(150) not null unique,
status boolean not null default true,
anexo boolean not null,
documentos varchar(50),
complemento boolean not null
);
