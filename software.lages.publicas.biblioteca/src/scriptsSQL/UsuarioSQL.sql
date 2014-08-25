CREATE DATABASE IF NOT EXISTS biblioteca;
USE biblioteca;

CREATE TABLE IF NOT EXISTS usuario (
  idUsuario int(11) NOT NULL AUTO_INCREMENT,
  nome varchar(45) DEFAULT NULL,
  serie varchar(45) DEFAULT NULL,
  PRIMARY KEY (idUsuario)
);

CREATE TABLE IF NOT EXISTS telefone (
  idTelefone int(11) NOT NULL AUTO_INCREMENT,
  telefone varchar(45) NOT NULL,
  idUsuario int(11) NOT NULL,
  PRIMARY KEY (idTelefone),
  FOREIGN KEY (idUsuario) REFERENCES usuario (idUsuario)
);

CREATE TABLE IF NOT EXISTS email (
  idEmail int(11) NOT NULL AUTO_INCREMENT,
  email varchar(45) NOT NULL,
  idUsuario int(11) NOT NULL,
  PRIMARY KEY (idEmail),
  FOREIGN KEY (idUsuario) REFERENCES usuario (idUsuario)
);