create table if not exists obra_autor(
id int not null auto_increment primary key,
idobra int not null,
idautor int not null,
constraint foreign key (idobra) references obra(id),
constraint foreign key (idautor) references autor(id)
);