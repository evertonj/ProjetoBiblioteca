SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema biblioteca
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `biblioteca` DEFAULT CHARACTER SET utf8 ;
USE `biblioteca` ;

-- -----------------------------------------------------
-- Table `biblioteca`.`assunto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`assunto` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(80) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `biblioteca`.`autor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`autor` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(80) NULL DEFAULT NULL,
  `sobrenome` VARCHAR(80) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `biblioteca`.`editora`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`editora` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(80) NULL DEFAULT NULL,
  `telefone` VARCHAR(80) NULL DEFAULT NULL,
  `email` VARCHAR(80) NULL DEFAULT NULL,
  `cidade` VARCHAR(80) NULL DEFAULT NULL,
  `rua` VARCHAR(80) NULL DEFAULT NULL,
  `bairro` VARCHAR(80) NULL DEFAULT NULL,
  `numero` VARCHAR(80) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `biblioteca`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`usuario` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(80) NULL DEFAULT NULL,
  `serie` VARCHAR(80) NULL DEFAULT NULL,
  `foto` LONGBLOB NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `biblioteca`.`email_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`email_usuario` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(50) NULL DEFAULT NULL,
  `idUsuario` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `idUsuario` (`idUsuario` ASC),
  CONSTRAINT `email_usuario_ibfk_1`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `biblioteca`.`usuario` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `biblioteca`.`exemplar`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`exemplar` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `dataDeCadastro` DATE NULL DEFAULT NULL,
  `fornecedor` VARCHAR(80) NULL DEFAULT NULL,
  `dataDeAquisicao` DATE NULL DEFAULT NULL,
  `numero_sequencial` INT(11) NULL DEFAULT '1',
  `situacao` ENUM('EMPRESTADO','DISPONIVEL','CONSULTA_LOCAL','RESERVADO','INDISPONIVEL','BAIXADO') NOT NULL,
  `id_obra` INT(11) NULL DEFAULT NULL,
  `descricao` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `biblioteca`.`obra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`obra` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(80) NULL DEFAULT NULL,
  `edicao` VARCHAR(80) NULL DEFAULT NULL,
  `ano` SMALLINT(6) NULL DEFAULT NULL,
  `isbn` VARCHAR(60) NULL DEFAULT NULL,
  `foto` LONGBLOB NULL DEFAULT NULL,
  `id_editora` INT(11) NULL DEFAULT NULL,
  `idassunto` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `biblioteca`.`obra_autor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`obra_autor` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `idobra` INT(11) NOT NULL,
  `idautor` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `idobra` (`idobra` ASC),
  INDEX `idautor` (`idautor` ASC),
  CONSTRAINT `obra_autor_ibfk_1`
    FOREIGN KEY (`idobra`)
    REFERENCES `biblioteca`.`obra` (`id`),
  CONSTRAINT `obra_autor_ibfk_2`
    FOREIGN KEY (`idautor`)
    REFERENCES `biblioteca`.`autor` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `biblioteca`.`operador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`operador` (
  `idoperador` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idoperador`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `biblioteca`.`telefone_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`telefone_usuario` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `numero` VARCHAR(50) NULL DEFAULT NULL,
  `idUsuario` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `idUsuario` (`idUsuario` ASC),
  CONSTRAINT `telefone_usuario_ibfk_1`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `biblioteca`.`usuario` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
