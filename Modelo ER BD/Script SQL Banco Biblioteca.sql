-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema biblioteca
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
  `DataCadastro` DATE NULL DEFAULT NULL,
  `situacao` ENUM('ATIVO','INATIVO','SUSPENSO') NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
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
AUTO_INCREMENT = 3
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
-- Table `biblioteca`.`operador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`operador` (
  `idoperador` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `senha` MEDIUMTEXT NOT NULL,
  PRIMARY KEY (`idoperador`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `biblioteca`.`emprestimo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`emprestimo` (
  `exemplar_id` INT(11) NOT NULL,
  `usuario_id` INT(11) NOT NULL,
  `data_emprestimo` DATE NULL DEFAULT NULL,
  `data_devolucao` DATE NULL DEFAULT NULL,
  `foi_devolvido` BIT(1) NULL DEFAULT NULL,
  `autor_id` INT(11) NOT NULL,
  `editora_id` INT(11) NOT NULL,
  `obra_id` INT(11) NOT NULL,
  `dias_para_devolver` INT(11) NULL DEFAULT NULL,
  `operador_idoperador` INT(11) NOT NULL,
  PRIMARY KEY (`exemplar_id`, `usuario_id`, `obra_id`),
  INDEX `fk_obra_has_usuario_usuario1_idx` (`usuario_id` ASC),
  INDEX `fk_obra_has_usuario_obra1_idx` (`exemplar_id` ASC),
  INDEX `fk_emprestimo_autor1_idx` (`autor_id` ASC),
  INDEX `fk_emprestimo_editora1_idx` (`editora_id` ASC),
  INDEX `fk_emprestimo_obra1_idx` (`obra_id` ASC),
  INDEX `fk_emprestimo_operador1_idx` (`operador_idoperador` ASC),
  CONSTRAINT `fk_emprestimo_autor1`
    FOREIGN KEY (`autor_id`)
    REFERENCES `biblioteca`.`autor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_emprestimo_editora1`
    FOREIGN KEY (`editora_id`)
    REFERENCES `biblioteca`.`editora` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_emprestimo_obra1`
    FOREIGN KEY (`obra_id`)
    REFERENCES `biblioteca`.`obra` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_exemplar_has_exemplar_id`
    FOREIGN KEY (`exemplar_id`)
    REFERENCES `biblioteca`.`exemplar` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_obra_has_usuario_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `biblioteca`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_emprestimo_operador1`
    FOREIGN KEY (`operador_idoperador`)
    REFERENCES `biblioteca`.`operador` (`idoperador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `biblioteca`.`devolucao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`devolucao` (
  `exemplar_id` INT(11) NOT NULL,
  `usuario_id` INT(11) NOT NULL,
  `data_devolucao` DATE NOT NULL,
  `operador_idoperador` INT(11) NOT NULL,
  INDEX `fk_devolucao_exemplar1_idx` (`exemplar_id` ASC),
  INDEX `fk_devolucao_usuario1_idx` (`usuario_id` ASC),
  INDEX `fk_devolucao_operador1_idx` (`operador_idoperador` ASC),
  CONSTRAINT `fk_devolucao_exemplar1`
    FOREIGN KEY (`exemplar_id`)
    REFERENCES `biblioteca`.`exemplar` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_devolucao_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `biblioteca`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_devolucao_operador1`
    FOREIGN KEY (`operador_idoperador`)
    REFERENCES `biblioteca`.`operador` (`idoperador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `biblioteca`.`operador`
-- -----------------------------------------------------
START TRANSACTION;
USE `biblioteca`;
INSERT INTO `biblioteca`.`operador` (`idoperador`, `nome`, `senha`) VALUES (1, 'admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918');

COMMIT;

