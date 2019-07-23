-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema turismo_loja
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema turismo_loja
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `turismo_loja` DEFAULT CHARACTER SET utf8 ;
USE `turismo_loja` ;

-- -----------------------------------------------------
-- Table `turismo_loja`.`parish`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `turismo_loja`.`parish` (
  `idParish` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`idParish`))
ENGINE = InnoDB;

USE `turismo_loja` ;

-- -----------------------------------------------------
-- Table `turismo_loja`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `turismo_loja`.`admin` (
  `idAdmin` INT(11) NOT NULL AUTO_INCREMENT,
  `user` VARCHAR(45) NOT NULL,
  `password` VARCHAR(24) NOT NULL,
  PRIMARY KEY (`idAdmin`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `turismo_loja`.`Neighborhood`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `turismo_loja`.`Neighborhood` (
  `idNeighborhood` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `idParish` INT NOT NULL,
  PRIMARY KEY (`idNeighborhood`),
  INDEX `fk_Neighborhood_parish1_idx` (`idParish` ASC),
  CONSTRAINT `fk_Neighborhood_parish1`
    FOREIGN KEY (`idParish`)
    REFERENCES `turismo_loja`.`parish` (`idParish`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `turismo_loja`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `turismo_loja`.`category` (
  `idCat` INT(11) NOT NULL AUTO_INCREMENT,
  `categoryName` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idCat`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `turismo_loja`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `turismo_loja`.`client` (
  `idClient` INT(11) NOT NULL AUTO_INCREMENT,
  `identification` VARCHAR(10) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `names` VARCHAR(65) NOT NULL,
  `lastNames` VARCHAR(65) NOT NULL,
  `mail` VARCHAR(45) NULL DEFAULT NULL,
  `numberPhone` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idClient`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `turismo_loja`.`place`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `turismo_loja`.`place` (
  `idPlace` INT(11) NOT NULL AUTO_INCREMENT,
  `principalStreet` VARCHAR(45) NULL DEFAULT NULL,
  `secondaryStreet` VARCHAR(45) NULL DEFAULT NULL,
  `reference` VARCHAR(45) NULL DEFAULT NULL,
  `idNeighborhood` INT(11) NOT NULL,
  PRIMARY KEY (`idPlace`),
  INDEX `fk_place_Neighborhood1_idx` (`idNeighborhood` ASC),
  CONSTRAINT `fk_place_Neighborhood1`
    FOREIGN KEY (`idNeighborhood`)
    REFERENCES `turismo_loja`.`Neighborhood` (`idNeighborhood`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `turismo_loja`.`state`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `turismo_loja`.`state` (
  `idState` INT(11) NOT NULL AUTO_INCREMENT,
  `state` INT(1) NOT NULL,
  `description` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idState`, `state`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `turismo_loja`.`event`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `turismo_loja`.`event` (
  `idEvent` INT(11) NOT NULL AUTO_INCREMENT,
  `nameEvent` VARCHAR(45) NOT NULL,
  `cost` DOUBLE NULL DEFAULT NULL,
  `date` DATE NULL DEFAULT NULL,
  `hour` VARCHAR(2) NULL DEFAULT NULL,
  `minutes` VARCHAR(2) NULL DEFAULT NULL,
  `description` VARCHAR(200) NULL DEFAULT NULL,
  `idCat` INT(11) NOT NULL,
  `idPlace` INT(11) NOT NULL,
  `idClient` INT(11) NOT NULL,
  `idState` INT(11) NOT NULL,
  `idAdmin` INT(11) NOT NULL,
  PRIMARY KEY (`idEvent`),
  INDEX `fk_Event_Category_idx` (`idCat` ASC),
  INDEX `fk_Event_Place_idx` (`idPlace` ASC),
  INDEX `fk_Event_Client_idx` (`idClient` ASC),
  INDEX `fk_Event_State_idx` (`idState` ASC),
  INDEX `fk_Event_Admin_idx` (`idAdmin` ASC),
  CONSTRAINT `fk_Event_Admin`
    FOREIGN KEY (`idAdmin`)
    REFERENCES `turismo_loja`.`admin` (`idAdmin`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Event_Category`
    FOREIGN KEY (`idCat`)
    REFERENCES `turismo_loja`.`category` (`idCat`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Event_Client`
    FOREIGN KEY (`idClient`)
    REFERENCES `turismo_loja`.`client` (`idClient`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Event_Place`
    FOREIGN KEY (`idPlace`)
    REFERENCES `turismo_loja`.`place` (`idPlace`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Event_State`
    FOREIGN KEY (`idState`)
    REFERENCES `turismo_loja`.`state` (`idState`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO `turismo_loja`.`category` (`categoryName`) VALUES ('Religioso');
INSERT INTO `turismo_loja`.`category` (`categoryName`) VALUES ('Deportivo');
INSERT INTO `turismo_loja`.`category` (`categoryName`) VALUES ('Cultural');
INSERT INTO `turismo_loja`.`category` (`categoryName`) VALUES ('Artistico');
INSERT INTO `turismo_loja`.`category` (`categoryName`) VALUES ('Festival');

INSERT INTO `turismo_loja`.`state` (`state`, `description`) VALUES ('1', 'Revision');
INSERT INTO `turismo_loja`.`state` (`state`, `description`) VALUES ('2', 'Aprobado');
INSERT INTO `turismo_loja`.`state` (`state`, `description`) VALUES ('3', 'Rechazado');
INSERT INTO `turismo_loja`.`state` (`state`, `description`) VALUES ('4', 'Finalizado');

INSERT INTO `turismo_loja`.`client` (`identification`, `password`, `names`, `lastNames`, `mail`, `numberPhone`) VALUES ('1101', '1101', 'Carlos', 'Castillo', 'cc@utpl.edu.ec', '0901');
INSERT INTO `turismo_loja`.`client` (`identification`, `password`, `names`, `lastNames`, `mail`, `numberPhone`) VALUES ('1102', '1102', 'Renato', 'Balcazar', 'rb@utpl.edu.ec', '0902');
INSERT INTO `turismo_loja`.`client` (`identification`, `password`, `names`, `lastNames`, `mail`, `numberPhone`) VALUES ('1103', '1103', 'Jimmy', 'Gomez', 'jg@utpl.edu.ec', '0903');
INSERT INTO `turismo_loja`.`client` (`identification`, `password`, `names`, `lastNames`, `mail`, `numberPhone`) VALUES ('1104', '1104', 'Ximena', 'Puchaicela', 'xp@utpl.edu.ec', '0904');
INSERT INTO `turismo_loja`.`client` (`identification`, `password`, `names`, `lastNames`, `mail`, `numberPhone`) VALUES ('1105', '1105', 'Luis', 'Erazo', 'le@utpl.edu.ec', '0905');

INSERT INTO `turismo_loja`.`admin` (`user`, `password`) VALUES ('admin', 'admin');

INSERT INTO `turismo_loja`.`parish` (`name`) VALUES ('El Sagrario');
INSERT INTO `turismo_loja`.`parish` (`name`) VALUES ('Sucre');
INSERT INTO `turismo_loja`.`parish` (`name`) VALUES ('El Valle');
INSERT INTO `turismo_loja`.`parish` (`name`) VALUES ('San Sebastián');
INSERT INTO `turismo_loja`.`parish` (`name`) VALUES ('Punzara');
INSERT INTO `turismo_loja`.`parish` (`name`) VALUES ('Carigán');

INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Barrio Central', '1');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Santo Domingo', '1');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('18 de Noviembre', '1');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Juan de Salinas', '1');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('24 de Mayo', '1');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Orillas del Zamora', '1');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Perpetuo Socorro', '1');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Ramón Pinto', '1');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Gran Colombia', '2');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('San Jose', '2');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('San Vicente', '2');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Capuli Loma', '2');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('El pedestal', '2');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Clodoveo', '2');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Turunuma', '2');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Belen', '2');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Plateado', '2');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Borja', '2');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Obrapia', '2');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Menfis', '2');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Chotacruz', '2');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Bolonia', '2');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Eucaliptos', '2');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Tierras Coloradas', '2');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Celi Román', '2');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Alborada', '2');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Miraflores', '2');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('San Juan de El Valle', '3');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Las Palmas', '3');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('San Cayetano', '3');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Santiago Fernández', '3');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Jipiro', '3');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('La inmaculada', '3');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('La estancia', '3');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Chingulanchi', '3');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('La Paz', '3');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Amable María', '3');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Maximo Agustin Rodríguez', '4');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Pucara', '4');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Pradera', '4');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Yaguarcuna', '4');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Los Geranios', '4');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('El Rosal', '4');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Capuli', '4');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Zamora Huayco', '4');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('La Argelia', '5');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('San Isidro', '5');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Héroes del Cenepa', '5');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Sol de los Andes', '5');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Santa Teresita', '5');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Daniel Alvarez', '5');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Tebaida', '5');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Isidro Ayora', '5');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('San Pedro', '5');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Colinas Lojanas', '5');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Ciudad Alegria', '5');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Juan Jose Castillo', '5');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Pitas', '6');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('La Banda', '6');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Motupe', '6');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Sauces Norte', '6');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Zalapa', '6');
INSERT INTO `turismo_loja`.`neighborhood` (`name`, `idParish`) VALUES ('Carigan', '6');

INSERT INTO `turismo_loja`.`place` (`principalStreet`, `secondaryStreet`, `reference`, `idNeighborhood`) VALUES ('Mercadillo', 'Lourdes', 'Estadio \"Reina del Cisne\"', '20');
INSERT INTO `turismo_loja`.`place` (`principalStreet`, `secondaryStreet`, `reference`, `idNeighborhood`) VALUES ('Alejo Garcia', 'Diego de Rojas', 'Frente a cancha de tierra', '19');
INSERT INTO `turismo_loja`.`place` (`principalStreet`, `secondaryStreet`, `reference`, `idNeighborhood`) VALUES ('Azuay', 'Suce', 'Diagonal al Topoly', '18');
INSERT INTO `turismo_loja`.`place` (`principalStreet`, `secondaryStreet`, `reference`, `idNeighborhood`) VALUES ('Anturios', 'Crisantemos', 'Alado de Dino Pepino', '17');
INSERT INTO `turismo_loja`.`place` (`principalStreet`, `secondaryStreet`, `reference`, `idNeighborhood`) VALUES ('10 de Agosto', 'Universitario', 'Diagonal al Seguro IESS', '16');
INSERT INTO `turismo_loja`.`place` (`principalStreet`, `secondaryStreet`, `reference`, `idNeighborhood`) VALUES ('Argentina', 'Bernardo Valdivieso', 'Cerca de la Iglesia \"Divino Niño\"', '15');
INSERT INTO `turismo_loja`.`place` (`principalStreet`, `secondaryStreet`, `reference`, `idNeighborhood`) VALUES ('Imbabura', 'Antonio Calles', 'Junto a pollos \"Mago Rey\"', '14');
INSERT INTO `turismo_loja`.`place` (`principalStreet`, `secondaryStreet`, `reference`, `idNeighborhood`) VALUES ('Bolivar', 'Paris', 'Cerca de Sintetica \"Calva y Calva\"', '13');
INSERT INTO `turismo_loja`.`place` (`principalStreet`, `secondaryStreet`, `reference`, `idNeighborhood`) VALUES ('Olmedo', 'Rocafuerte', 'Frente al Zoologico', '12');
INSERT INTO `turismo_loja`.`place` (`principalStreet`, `secondaryStreet`, `reference`, `idNeighborhood`) VALUES ('Orillas del Zamora', 'Lourdes', 'Diagonal a la Casa Comunal', '11');
INSERT INTO `turismo_loja`.`place` (`principalStreet`, `secondaryStreet`, `reference`, `idNeighborhood`) VALUES ('Gallegos', '18 de Noviembre', 'Frente a la UNL', '10');
INSERT INTO `turismo_loja`.`place` (`principalStreet`, `secondaryStreet`, `reference`, `idNeighborhood`) VALUES ('Pio Jaramillo', 'Manuel Aguirre', 'Alado de cancha de tierra', '9');
INSERT INTO `turismo_loja`.`place` (`principalStreet`, `secondaryStreet`, `reference`, `idNeighborhood`) VALUES ('Cariamanga', 'Quito', 'Frente a la Iglesia', '7');
INSERT INTO `turismo_loja`.`place` (`principalStreet`, `secondaryStreet`, `reference`, `idNeighborhood`) VALUES ('8 de Diciembre', 'Macara', '2 cuadras antes de llegar a casa Comunal', '7');
INSERT INTO `turismo_loja`.`place` (`principalStreet`, `secondaryStreet`, `reference`, `idNeighborhood`) VALUES ('Argentina', 'Catacocha', 'Diagonal al UPC de las Peñas', '6');
INSERT INTO `turismo_loja`.`place` (`principalStreet`, `secondaryStreet`, `reference`, `idNeighborhood`) VALUES ('Jose Antonio Eguigure', 'Universitaria', 'Diagonal a la Iglesia \"Santa Madre\"', '5');
INSERT INTO `turismo_loja`.`place` (`principalStreet`, `secondaryStreet`, `reference`, `idNeighborhood`) VALUES ('Piedras Rojas', 'Juan Jose Peña', 'Frente a cancha sintetica', '4');
INSERT INTO `turismo_loja`.`place` (`principalStreet`, `secondaryStreet`, `reference`, `idNeighborhood`) VALUES ('Americo Bespucio', '24 de Mayo', 'Diagonal a área verde', '3');
INSERT INTO `turismo_loja`.`place` (`principalStreet`, `secondaryStreet`, `reference`, `idNeighborhood`) VALUES ('Azuay', 'Alejandrino ', 'Casa Verde 2 Pisos', '2');
INSERT INTO `turismo_loja`.`place` (`principalStreet`, `secondaryStreet`, `reference`, `idNeighborhood`) VALUES ('Mercadillo', 'Venezuela', 'Alado del UPC', '1');

INSERT INTO `turismo_loja`.`event` (`nameEvent`, `cost`, `date`, `hour`, `minutes`, `description`, `idCat`, `idPlace`, `idClient`, `idState`, `idAdmin`) VALUES ('Concierto \"Juanes\"', '10', '2019-06-30', '19', '00', 'Concierto en Vivo', '4', '1', '1', '1', '1');
INSERT INTO `turismo_loja`.`event` (`nameEvent`, `cost`, `date`, `hour`, `minutes`, `description`, `idCat`, `idPlace`, `idClient`, `idState`, `idAdmin`) VALUES ('Loja se Levanta', '1', '2019-07-01', '11', '30', 'Partido Amistoso', '2', '2', '2', '1', '1');
INSERT INTO `turismo_loja`.`event` (`nameEvent`, `cost`, `date`, `hour`, `minutes`, `description`, `idCat`, `idPlace`, `idClient`, `idState`, `idAdmin`) VALUES ('Misa Campal', '0', '2019-06-10', '07', '00', 'Fiesta de la Virgem', '2', '3', '1', '2', '1');
INSERT INTO `turismo_loja`.`event` (`nameEvent`, `cost`, `date`, `hour`, `minutes`, `description`, `idCat`, `idPlace`, `idClient`, `idState`, `idAdmin`) VALUES ('Fiesta Corpus Cristi', '3', '2019-06-11', '08', '15', 'Fiesta del espirtu santo', '2', '4', '1', '2', '1');
INSERT INTO `turismo_loja`.`event` (`nameEvent`, `cost`, `date`, `hour`, `minutes`, `description`, `idCat`, `idPlace`, `idClient`, `idState`, `idAdmin`) VALUES ('Artes Vivas', '8', '2019-06-12', '09', '30', 'Diversas artes', '2', '5', '1', '1', '1');
INSERT INTO `turismo_loja`.`event` (`nameEvent`, `cost`, `date`, `hour`, `minutes`, `description`, `idCat`, `idPlace`, `idClient`, `idState`, `idAdmin`) VALUES ('Ecuador Unido', '2', '2019-06-13', '10', '45', 'Por un mundo sin egoismo', '4', '6', '2', '2', '1');
INSERT INTO `turismo_loja`.`event` (`nameEvent`, `cost`, `date`, `hour`, `minutes`, `description`, `idCat`, `idPlace`, `idClient`, `idState`, `idAdmin`) VALUES ('Musical', '0', '2019-07-02', '11', '00', 'Artista invitado', '4', '7', '2', '2', '1');
INSERT INTO `turismo_loja`.`event` (`nameEvent`, `cost`, `date`, `hour`, `minutes`, `description`, `idCat`, `idPlace`, `idClient`, `idState`, `idAdmin`) VALUES ('Jinganas', '1', '2019-07-03', '12', '30', 'Entretenimiento', '4', '8', '2', '2', '1');
INSERT INTO `turismo_loja`.`event` (`nameEvent`, `cost`, `date`, `hour`, `minutes`, `description`, `idCat`, `idPlace`, `idClient`, `idState`, `idAdmin`) VALUES ('Ecuador Somos Todos', '5', '2019-07-04', '13', '15', 'Cuidando el medio ambiente', '1', '9', '3', '1', '1');
INSERT INTO `turismo_loja`.`event` (`nameEvent`, `cost`, `date`, `hour`, `minutes`, `description`, `idCat`, `idPlace`, `idClient`, `idState`, `idAdmin`) VALUES ('Primeras Comuniones', '6', '2019-07-05', '14', '45', 'Iglesia del barrio', '1', '10', '3', '2', '1');
INSERT INTO `turismo_loja`.`event` (`nameEvent`, `cost`, `date`, `hour`, `minutes`, `description`, `idCat`, `idPlace`, `idClient`, `idState`, `idAdmin`) VALUES ('Comida Tipica', '10', '2019-07-06', '15', '00', 'Comidas lojanas', '1', '11', '3', '1', '1');
INSERT INTO `turismo_loja`.`event` (`nameEvent`, `cost`, `date`, `hour`, `minutes`, `description`, `idCat`, `idPlace`, `idClient`, `idState`, `idAdmin`) VALUES ('Juegos Deportivos', '35', '2019-07-07', '16', '15', 'Enfrentamientos', '1', '12', '3', '1', '1');
INSERT INTO `turismo_loja`.`event` (`nameEvent`, `cost`, `date`, `hour`, `minutes`, `description`, `idCat`, `idPlace`, `idClient`, `idState`, `idAdmin`) VALUES ('Fiestas de UTPL', '20', '2019-07-08', '17', '30', '90 años', '3', '13', '4', '1', '1');
INSERT INTO `turismo_loja`.`event` (`nameEvent`, `cost`, `date`, `hour`, `minutes`, `description`, `idCat`, `idPlace`, `idClient`, `idState`, `idAdmin`) VALUES ('Congreso', '22', '2019-07-09', '18', '45', 'Redes Sociales', '3', '14', '4', '2', '1');
INSERT INTO `turismo_loja`.`event` (`nameEvent`, `cost`, `date`, `hour`, `minutes`, `description`, `idCat`, `idPlace`, `idClient`, `idState`, `idAdmin`) VALUES ('Conversatorio', '18', '2019-08-01', '19', '00', 'Sobre Medio Ambiente', '3', '15', '4', '1', '1');
INSERT INTO `turismo_loja`.`event` (`nameEvent`, `cost`, `date`, `hour`, `minutes`, `description`, `idCat`, `idPlace`, `idClient`, `idState`, `idAdmin`) VALUES ('Jornada de Induccion', '60', '2019-08-02', '20', '15', 'Cursos de induccion', '3', '16', '4', '2', '1');
INSERT INTO `turismo_loja`.`event` (`nameEvent`, `cost`, `date`, `hour`, `minutes`, `description`, `idCat`, `idPlace`, `idClient`, `idState`, `idAdmin`) VALUES ('Motocross', '5', '2019-09-01', '21', '30', 'Profesionales invitados', '5', '17', '5', '2', '1');
INSERT INTO `turismo_loja`.`event` (`nameEvent`, `cost`, `date`, `hour`, `minutes`, `description`, `idCat`, `idPlace`, `idClient`, `idState`, `idAdmin`) VALUES ('Carrera de carros de palo', '2', '2019-09-21', '22', '15', 'Competencia', '5', '18', '5', '2', '1');
INSERT INTO `turismo_loja`.`event` (`nameEvent`, `cost`, `date`, `hour`, `minutes`, `description`, `idCat`, `idPlace`, `idClient`, `idState`, `idAdmin`) VALUES ('Ciclismo', '1', '2019-07-02', '23', '45', 'Carrera', '5', '19', '5', '1', '1');
INSERT INTO `turismo_loja`.`event` (`nameEvent`, `cost`, `date`, `hour`, `minutes`, `description`, `idCat`, `idPlace`, `idClient`, `idState`, `idAdmin`) VALUES ('Natacion', '0', '2019-08-01', '07', '00', 'Cursos Vacacionales', '5', '20', '5', '1', '1');

