create database biblioteca;
use biblioteca;

create table autor(
id int not null auto_increment primary key,
nome varchar(80),
sobrenome varchar(80),
datanascimento date
);
create table assunto(
id int not null auto_increment primary key,
nome varchar(80));

create table editora (
id int not null auto_increment primary key,
nome varchar(80),
telefone varchar(80),
email varchar(80),
cidade varchar(80),
rua varchar(80),
bairro varchar(80),
numero varchar(80)
);
create table obra(
id int not null auto_increment,
titulo varchar(80),
edicao varchar(80),
ano smallint,
id_editora int not null,
isbn varchar(60),
assunto varchar(60),
foto longblob,
idAssunto int not null,
foreign key (idAssunto) references assunto(id),
primary key(id),
constraint 
foreign key (id_editora)
references editora(id)
);
create table usuario(
id int not null auto_increment primary key,
nome varchar(80),
serie varchar(80),
email varchar(80),
telefone varchar(20)
);
create table obra_autor(
id int not null auto_increment primary key,
idobra int not null,
idautor int not null,
constraint foreign key (idobra) references obra(id),
constraint foreign key (idautor) references autor(id)
);

