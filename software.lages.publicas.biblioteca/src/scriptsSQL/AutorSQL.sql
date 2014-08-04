create table if not exists autor(
id int not null auto_increment primary key,
nome varchar(80),
sobrenome varchar(80),
datanascimento date
);