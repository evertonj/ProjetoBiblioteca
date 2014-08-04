create database biblioteca;
use biblioteca;

create table if not exists Operador(
id int not null auto_increment primary key,
nome varchar(20) not null,
senha varchar(10) not null
);