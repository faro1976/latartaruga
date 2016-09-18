-- MySQL Script generated by MySQL Workbench
-- 08/04/16 11:38:31
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema SENSORYTURTLES
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `SENSORYTURTLES` ;

-- -----------------------------------------------------
-- Schema SENSORYTURTLES
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `SENSORYTURTLES` DEFAULT CHARACTER SET utf8 ;
USE `SENSORYTURTLES` ;

-- -----------------------------------------------------
-- Table `SENSORYTURTLES`.`ROOM`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SENSORYTURTLES`.`ROOM` ;

CREATE TABLE IF NOT EXISTS `SENSORYTURTLES`.`ROOM` (
  `idROOM` INT NOT NULL AUTO_INCREMENT,
  `code` CHAR(2) NOT NULL,
  `descr` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idROOM`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = big5
COLLATE = big5_bin;

CREATE UNIQUE INDEX `code_UNIQUE` ON `SENSORYTURTLES`.`ROOM` (`code` ASC);


-- -----------------------------------------------------
-- Table `SENSORYTURTLES`.`DEVICE_RELAY`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SENSORYTURTLES`.`DEVICE_RELAY` ;

CREATE TABLE IF NOT EXISTS `SENSORYTURTLES`.`DEVICE_RELAY` (
  `idDEVICE` INT NOT NULL AUTO_INCREMENT,
  `code` CHAR(2) NOT NULL,
  `descr` VARCHAR(255) NOT NULL,
  `idRaspBerry` INT NOT NULL,
  `idROOM` INT NOT NULL,
  PRIMARY KEY (`idDEVICE`, `idROOM`),
  CONSTRAINT `fk_DEVICE_ROOM1`
    FOREIGN KEY (`idROOM`)
    REFERENCES `SENSORYTURTLES`.`ROOM` (`idROOM`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_DEVICE_ROOM1_idx` ON `SENSORYTURTLES`.`DEVICE_RELAY` (`idROOM` ASC);

CREATE UNIQUE INDEX `code_UNIQUE` ON `SENSORYTURTLES`.`DEVICE_RELAY` (`code` ASC);


-- -----------------------------------------------------
-- Table `SENSORYTURTLES`.`DEVICE_CONTROLLER_RGB`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SENSORYTURTLES`.`DEVICE_CONTROLLER_RGB` ;

CREATE TABLE IF NOT EXISTS `SENSORYTURTLES`.`DEVICE_CONTROLLER_RGB` (
  `idDEVICE` INT NOT NULL AUTO_INCREMENT,
  `code` CHAR(2) NOT NULL,
  `descr` VARCHAR(255) NOT NULL,
  `idRaspBerry` INT NOT NULL,
  `idROOM` INT NOT NULL,
  PRIMARY KEY (`idDEVICE`, `idROOM`),
  CONSTRAINT `fk_DEVICE_CONTROLLER_RGB_ROOM1`
    FOREIGN KEY (`idROOM`)
    REFERENCES `SENSORYTURTLES`.`ROOM` (`idROOM`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_DEVICE_CONTROLLER_RGB_ROOM1_idx` ON `SENSORYTURTLES`.`DEVICE_CONTROLLER_RGB` (`idROOM` ASC);

CREATE UNIQUE INDEX `code_UNIQUE` ON `SENSORYTURTLES`.`DEVICE_CONTROLLER_RGB` (`code` ASC);


-- -----------------------------------------------------
-- Table `SENSORYTURTLES`.`DEVICE_MULTIMEDIA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SENSORYTURTLES`.`DEVICE_MULTIMEDIA` ;

CREATE TABLE IF NOT EXISTS `SENSORYTURTLES`.`DEVICE_MULTIMEDIA` (
  `idDEVICE` INT NOT NULL AUTO_INCREMENT,
  `code` CHAR(2) NOT NULL,
  `descr` VARCHAR(255) NOT NULL,
  `path` VARCHAR(500) NOT NULL,
  `idROOM` INT NOT NULL,
  PRIMARY KEY (`idDEVICE`, `idROOM`),
  CONSTRAINT `fk_DEVICE_MULTIMEDIA_ROOM1`
    FOREIGN KEY (`idROOM`)
    REFERENCES `SENSORYTURTLES`.`ROOM` (`idROOM`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_DEVICE_MULTIMEDIA_ROOM1_idx` ON `SENSORYTURTLES`.`DEVICE_MULTIMEDIA` (`idROOM` ASC);

CREATE UNIQUE INDEX `code_UNIQUE` ON `SENSORYTURTLES`.`DEVICE_MULTIMEDIA` (`code` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
