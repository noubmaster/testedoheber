-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.6.10 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL version:             7.0.0.4053
-- Date/time:                    2016-04-15 10:44:23
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;

-- Dumping database structure for projetopoo
DROP DATABASE IF EXISTS `projetopoo`;
CREATE DATABASE IF NOT EXISTS `projetopoo` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `projetopoo`;


-- Dumping structure for table projetopoo.marca
DROP TABLE IF EXISTS `marca`;
CREATE TABLE IF NOT EXISTS `marca` (
  `idMarca` int(10) NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) DEFAULT '0',
  `paisOrigem` varchar(40) DEFAULT '0',
  PRIMARY KEY (`idMarca`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Dumping data for table projetopoo.marca: ~5 rows (approximately)
/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
INSERT INTO `marca` (`idMarca`, `nome`, `paisOrigem`) VALUES
	(2, 'FIAT', 'ITALIA'),
	(3, 'FERRARI', 'ITALIA'),
	(4, 'FORD', 'EUA'),
	(7, 'VW', 'ALEMANHA'),
	(8, 'bmw', 'alemanha'),
	(9, 'a', 'a'),
	(10, 'b', 'b'),
	(11, 'c', 'c');
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;


-- Dumping structure for table projetopoo.modelo
DROP TABLE IF EXISTS `modelo`;
CREATE TABLE IF NOT EXISTS `modelo` (
  `idModelo` int(10) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(50) DEFAULT '0',
  `categoria` varchar(50) DEFAULT '0',
  `combustivel` varchar(50) DEFAULT '0',
  `transmissao` varchar(50) DEFAULT '0',
  `motor` varchar(50) DEFAULT '0',
  `tracao` varchar(50) DEFAULT '0',
  `idMarca` int(11) DEFAULT '0',
  PRIMARY KEY (`idModelo`),
  KEY `FK_modelo_marca` (`idMarca`),
  CONSTRAINT `FK_modelo_marca` FOREIGN KEY (`idMarca`) REFERENCES `marca` (`idMarca`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table projetopoo.modelo: ~0 rows (approximately)
/*!40000 ALTER TABLE `modelo` DISABLE KEYS */;
INSERT INTO `modelo` (`idModelo`, `descricao`, `categoria`, `combustivel`, `transmissao`, `motor`, `tracao`, `idMarca`) VALUES
	(1, 'PALIO', 'CARRO', 'FLEX', 'MANUAL', '1.0', 'DIANTEIRA', 2),
	(3, 'TORO', 'PICK-UP', 'DIESEL', 'AT', '2.0', 'INTEGRAL', 2),
	(4, 'FUSCA', 'CARRO', 'GASOLINA', 'MANUAL', '1.6', 'TRA', 7),
	(5, 'CORSA', 'Hatch Pequenos', 'Flex', 'Manual', '1.0', 'Dianteira', 4);
/*!40000 ALTER TABLE `modelo` ENABLE KEYS */;
/*!40014 SET FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
