create database biblioteca;
use biblioteca;
create table obra(
id int not null auto_increment,
titulo varchar(80),
edicao varchar(80),
ano smallint,
id_editora int not null,
isbn varchar(60),
assunto varchar(60),
foto longblob,
primary key(id),
constraint 
foreign key (id_editora)
references editora(id)
);