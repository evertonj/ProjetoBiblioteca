USE biblioteca;
CREATE TABLE `biblioteca`.`operador` (
  `idoperador` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idoperador`));