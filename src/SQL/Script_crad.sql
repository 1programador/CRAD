create database CRAD;

use CRAD;

create table usuario(
id int auto_increment primary key,
nome varchar(50) not null,
matricula varchar(15) not null unique,
status boolean default true,
perfil enum('ALUNO','PROFESSOR','COORDENADOR') not null) default character set utf8;

create table tipo_solicitacao(
id int auto_increment primary key,
descricao varchar(100) not null unique,
status boolean default true,
complemento boolean not null,
anexo boolean not null,
documentos varchar(20)) default character set utf8;

create table solicitacao(
id int auto_increment primary key,
status enum('PENDENTE','ANALISE','FINALIZADO') default "PENDENTE",
data_hora timestamp default current_timestamp(),
fk_tipo_solicitacao int not null,
fk_usuario int not null,
constraint fk_tipo_solicitacao foreign key (fk_tipo_solicitacao) references tipo_solicitacao (id),
constraint fk_usuario1 foreign key (fk_usuario) references usuario (id)) default character set utf8;

create table ocorrencia(
id int auto_increment primary key,
acao varchar(50) not null,
data_hora timestamp default current_timestamp(),
fk_usuario int not null,
fk_solicitacao int not null,
constraint fk_usuario2 foreign key (fk_usuario) references usuario (id),
constraint fk_solicitacao foreign key (fk_solicitacao) references solicitacao (id)) default character set utf8;
