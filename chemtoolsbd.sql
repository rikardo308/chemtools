CREATE DATABASE  IF NOT EXISTS `chemtoolsbd` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `chemtoolsbd`;
-- MySQL dump 10.13  Distrib 5.5.41, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: chemtoolsbd
-- ------------------------------------------------------
-- Server version	5.5.41-0ubuntu0.14.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `almacen`
--

DROP TABLE IF EXISTS `almacen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `almacen` (
  `idAlmacen` int(11) NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `Capacidad` int(11) DEFAULT NULL,
  `TipoAlmacen` int(11) DEFAULT NULL,
  `Direccion` varchar(45) DEFAULT NULL,
  `idDistrito` int(11) DEFAULT NULL,
  `idProvicia` int(11) DEFAULT NULL,
  `idDepartamento` int(11) DEFAULT NULL,
  `Estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idAlmacen`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `almacen`
--

LOCK TABLES `almacen` WRITE;
/*!40000 ALTER TABLE `almacen` DISABLE KEYS */;
INSERT INTO `almacen` VALUES (1,'ALMACEN1',12,1,'fe',1,1,1,1),(2,'ALMACEN2',12,1,'fe',1,1,1,1);
/*!40000 ALTER TABLE `almacen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `banco`
--

DROP TABLE IF EXISTS `banco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `banco` (
  `idBanco` int(11) NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idBanco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `banco`
--

LOCK TABLES `banco` WRITE;
/*!40000 ALTER TABLE `banco` DISABLE KEYS */;
/*!40000 ALTER TABLE `banco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contenedores`
--

DROP TABLE IF EXISTS `contenedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contenedores` (
  `idContenedores` int(11) NOT NULL,
  `Descripcion` varchar(45) DEFAULT NULL,
  `Estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idContenedores`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contenedores`
--

LOCK TABLES `contenedores` WRITE;
/*!40000 ALTER TABLE `contenedores` DISABLE KEYS */;
INSERT INTO `contenedores` VALUES (1,'CONT_1',1);
/*!40000 ALTER TABLE `contenedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalleformula`
--

DROP TABLE IF EXISTS `detalleformula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalleformula` (
  `idTipoInsumo` int(11) NOT NULL,
  `idFormula` int(11) NOT NULL,
  `idTipoProducto` int(11) NOT NULL,
  `Cantidad_Insumo` int(11) DEFAULT NULL,
  `Cantidad_Producto` int(11) DEFAULT NULL,
  PRIMARY KEY (`idTipoInsumo`,`idFormula`,`idTipoProducto`),
  KEY `fk_detalleformula_formula1_idx` (`idFormula`),
  KEY `fk_detalleformula_tipoproducto1_idx` (`idTipoProducto`),
  CONSTRAINT `fk_detalleformula_formula1` FOREIGN KEY (`idFormula`) REFERENCES `formula` (`idFormula`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalleformula_tipoinsumo1` FOREIGN KEY (`idTipoInsumo`) REFERENCES `tipoinsumo` (`idTipoInsumo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalleformula_tipoproducto1` FOREIGN KEY (`idTipoProducto`) REFERENCES `tipoproducto` (`idTipoProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalleformula`
--

LOCK TABLES `detalleformula` WRITE;
/*!40000 ALTER TABLE `detalleformula` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalleformula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empresa` (
  `idEmpresa` int(11) NOT NULL,
  `RAZON_SOCIAL` varchar(45) DEFAULT NULL,
  `RUC` varchar(45) DEFAULT NULL,
  `Tipo` int(11) DEFAULT NULL,
  `Direccion` varchar(45) DEFAULT NULL,
  `idDistrito` int(11) DEFAULT NULL,
  `idProvicia` int(11) DEFAULT NULL,
  `idDepartamento` int(11) DEFAULT NULL,
  `Estado` int(11) DEFAULT NULL,
  `PaginaWeb` varchar(50) DEFAULT NULL,
  `NombreEncargado` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idEmpresa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` VALUES (1,'EMP_1','123',1,'1',1,1,1,1,'fe','fe');
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evento`
--

DROP TABLE IF EXISTS `evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evento` (
  `idEvento` int(11) NOT NULL,
  `Descripcion` varchar(45) DEFAULT NULL,
  `Estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idEvento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento`
--

LOCK TABLES `evento` WRITE;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
INSERT INTO `evento` VALUES (1,'REGISTRAR',1),(2,'CAMBIO_ALMACEN',1);
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eventoxinsumo`
--

DROP TABLE IF EXISTS `eventoxinsumo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eventoxinsumo` (
  `idEventoxinsumo` int(11) NOT NULL AUTO_INCREMENT,
  `idEvento` int(11) NOT NULL,
  `idInsumo` varchar(50) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `idAlmacen` int(11) NOT NULL,
  `Fecha_Evento` datetime DEFAULT NULL,
  PRIMARY KEY (`idEventoxinsumo`,`idEvento`,`idInsumo`,`idUsuario`,`idAlmacen`),
  KEY `fk_evento_has_insumo_evento1_idx` (`idEvento`),
  KEY `fk_eventoxinsumo_usuario1_idx` (`idUsuario`),
  KEY `fk_eventoxinsumo_almacen1_idx` (`idAlmacen`),
  KEY `fk_eventoxinsumo_insumo1_idx` (`idInsumo`),
  CONSTRAINT `fk_eventoxinsumo_almacen1` FOREIGN KEY (`idAlmacen`) REFERENCES `almacen` (`idAlmacen`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_eventoxinsumo_insumo1` FOREIGN KEY (`idInsumo`) REFERENCES `insumo` (`idInsumo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_eventoxinsumo_usuario1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_evento_has_insumo_evento1` FOREIGN KEY (`idEvento`) REFERENCES `evento` (`idEvento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventoxinsumo`
--

LOCK TABLES `eventoxinsumo` WRITE;
/*!40000 ALTER TABLE `eventoxinsumo` DISABLE KEYS */;
INSERT INTO `eventoxinsumo` VALUES (1,1,'1',1,1,'2015-04-22 00:00:00'),(11,1,'ff-123456',1,2,'2015-04-22 00:00:00'),(39,1,'ff-333333',1,1,'2015-04-22 04:59:45');
/*!40000 ALTER TABLE `eventoxinsumo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eventoxproducto`
--

DROP TABLE IF EXISTS `eventoxproducto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eventoxproducto` (
  `idEvento` int(11) NOT NULL,
  `idProducto` varchar(50) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `idAlmacen` int(11) NOT NULL,
  `Fecha_Evento` date DEFAULT NULL,
  PRIMARY KEY (`idEvento`,`idProducto`,`idUsuario`,`idAlmacen`),
  KEY `fk_evento_has_producto_evento1_idx` (`idEvento`),
  KEY `fk_eventoxproducto_usuario1_idx` (`idUsuario`),
  KEY `fk_eventoxproducto_almacen1_idx` (`idAlmacen`),
  KEY `fk_eventoxproducto_producto1_idx` (`idProducto`),
  CONSTRAINT `fk_eventoxproducto_almacen1` FOREIGN KEY (`idAlmacen`) REFERENCES `almacen` (`idAlmacen`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_eventoxproducto_producto1` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_eventoxproducto_usuario1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_evento_has_producto_evento1` FOREIGN KEY (`idEvento`) REFERENCES `evento` (`idEvento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventoxproducto`
--

LOCK TABLES `eventoxproducto` WRITE;
/*!40000 ALTER TABLE `eventoxproducto` DISABLE KEYS */;
/*!40000 ALTER TABLE `eventoxproducto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eventoxusuario`
--

DROP TABLE IF EXISTS `eventoxusuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eventoxusuario` (
  `idEvento` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `Fecha` date DEFAULT NULL,
  `Comentario` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idEvento`,`idUsuario`),
  KEY `fk_evento_has_usuario_usuario1_idx` (`idUsuario`),
  KEY `fk_evento_has_usuario_evento1_idx` (`idEvento`),
  CONSTRAINT `fk_evento_has_usuario_evento1` FOREIGN KEY (`idEvento`) REFERENCES `evento` (`idEvento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_evento_has_usuario_usuario1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventoxusuario`
--

LOCK TABLES `eventoxusuario` WRITE;
/*!40000 ALTER TABLE `eventoxusuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `eventoxusuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `factura` (
  `idFactura` varchar(30) NOT NULL,
  `Tipo_Factura` int(11) DEFAULT NULL,
  `Fecha_Emision` date DEFAULT NULL,
  `SubTotal` double DEFAULT NULL,
  `Total` double DEFAULT NULL,
  `Detraccion` double DEFAULT NULL,
  `Total_Detraccion` double DEFAULT NULL,
  `Fecha_Pago` datetime DEFAULT NULL,
  `Comentario` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idFactura`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formula`
--

DROP TABLE IF EXISTS `formula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `formula` (
  `idFormula` int(11) NOT NULL,
  `Descripcion` varchar(45) DEFAULT NULL,
  `Fecha_Creacion` date DEFAULT NULL,
  `Nombre_Creador` varchar(45) DEFAULT NULL,
  `Apellido_Creador` varchar(45) DEFAULT NULL,
  `Estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idFormula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formula`
--

LOCK TABLES `formula` WRITE;
/*!40000 ALTER TABLE `formula` DISABLE KEYS */;
/*!40000 ALTER TABLE `formula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gasto`
--

DROP TABLE IF EXISTS `gasto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gasto` (
  `idGastos` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `idBanco` int(11) NOT NULL,
  `idTipoGasto` int(11) NOT NULL,
  `Comentario` varchar(45) DEFAULT NULL,
  `Estado` int(11) DEFAULT NULL,
  `Fecha` date DEFAULT NULL,
  `Monto` int(11) DEFAULT NULL,
  `Imagen` longblob,
  PRIMARY KEY (`idGastos`),
  KEY `fk_gasto_usuario1_idx` (`idUsuario`),
  KEY `fk_gasto_banco1_idx` (`idBanco`),
  KEY `fk_gasto_tipogasto1_idx` (`idTipoGasto`),
  CONSTRAINT `fk_gasto_banco1` FOREIGN KEY (`idBanco`) REFERENCES `banco` (`idBanco`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_gasto_tipogasto1` FOREIGN KEY (`idTipoGasto`) REFERENCES `tipogasto` (`idTipoGasto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_gasto_usuario1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gasto`
--

LOCK TABLES `gasto` WRITE;
/*!40000 ALTER TABLE `gasto` DISABLE KEYS */;
/*!40000 ALTER TABLE `gasto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `insumo`
--

DROP TABLE IF EXISTS `insumo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `insumo` (
  `idInsumo` varchar(50) NOT NULL,
  `idEmpresa` int(11) NOT NULL,
  `idTipoInsumo` int(11) NOT NULL,
  `Fecha_Creacion` date DEFAULT NULL,
  `Estado` int(11) DEFAULT NULL,
  `Comentario` varchar(45) DEFAULT NULL,
  `Calidad` int(11) DEFAULT NULL,
  `Contenido` double DEFAULT NULL,
  `Fecha_Caducacion` date DEFAULT NULL,
  `Imagen` longtext,
  PRIMARY KEY (`idInsumo`),
  KEY `fk_insumo_empresa1_idx` (`idEmpresa`),
  KEY `fk_insumo_tipoinsumo1_idx` (`idTipoInsumo`),
  CONSTRAINT `fk_insumo_empresa1` FOREIGN KEY (`idEmpresa`) REFERENCES `empresa` (`idEmpresa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_insumo_tipoinsumo1` FOREIGN KEY (`idTipoInsumo`) REFERENCES `tipoinsumo` (`idTipoInsumo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insumo`
--

LOCK TABLES `insumo` WRITE;
/*!40000 ALTER TABLE `insumo` DISABLE KEYS */;
INSERT INTO `insumo` VALUES ('1',1,1,'2015-04-22',0,'Insumo_1',3,12,'1995-09-03','\niVBORw0KGgoAAAANSUhEUgAAAB8AAABYCAIAAACCkbu6AAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAANZSURBVGhD3ZnrS1RBGMbNLFetJUsKEyQMFBQySMjuFARRFHR2vZUZVKYYZCUmsihWaFQaaQUKlQZtlFEixEpamKGgoOAHBUHwhrgrXv+EDtuz21nPzNmZOdOXfpwvM+/z/j46+2DI6r/kv7dHR+VYLdmMn6P8GdYY7ZZQ+8YQG+PnfPcZa4z2yLCMNQraF7VB6e/vx5p0e9yOzKmpKaxJt6en5S8uLmJNuj0vt3JlZQVr0u011Y3Y8SLZ3tb2FTteZNqtEcrw8DB2vMi0J8TnzM3NYceLTPvxo0XLy8vY8SLTXlRYgwUfMu0N9S1Y8CHNHr7O1tn5HQs+pNm3blbGxsaw4EOaPTnx0vz8PBZ8SLOfO1Oi/RvwB2n20pI6pDVIsze/+YC0Bjn2yDBbb28f0hrk2GNjMiYmJpDWIMe+L/WK9tHwI8eek+VANBA59qrKF4gGIsfe2tqOaCAS7FaLbXBwENFAJNjjd2bOzs4iGogE++EDBWseDT8S7PlX7yOnQ4K99skr5HSYtauPhsv1DTkdZu1bopSRkRHkdJi1JyZc9Hg8yOkwaz91slj/aPgxa7918xFCJMzamxqdCJEwZbeEKt3dPxEiYcq+Pdo+Pj6OEAlT9j3JlxcWFhAiYcpuP38XCQqm7I7yeiQomLI7nV+QoCBuX1NNiYjb1Wo6PT2NBAVx+/60/KWlJSQoiNvzciswpiNuf1jThDEdYbvS3u7CmI6gXV9NiQjaE+Kz3W43xnQE7SeO3aD9ytAiaC8qrMbMEEH784a3mBkiYld/ZXR1/cDMEBH7NqtNX02JiNhTkgjVlIiI/ezpOwa/MrSI2MtKn2IQDBF7S/NHDILBbVeraV8foZoS4bbHxtgnJycxCAa3PW0vuZoS4bZfoFRTItz2e1UvccsAt/0TpZoS4bNvCleGhoZwywCffVdcFq2aEuGzHzlYyPJo+OGzX7/2AFds8Nnral/jig0Ou/podHR04ooNDrtaTUdHR3HFBoc9abdRNSXCYTeupkQ47LeLH+PMDIfduJoSYbVHrLf19PzCmRlWe9BqSoTVnpoSpJoSYbVnKGU48MBqr3A04MADq/298+9/Tdlhslsj7AMDAzjwwGRXH42ZmRkceGCyH0ovCFpNCayu/gaLD05HBZjaXQAAAABJRU5ErkJggg==\n'),('ff-123456',1,1,'2015-04-22',0,'fefe',1,34,'2015-05-01',''),('ff-333333',1,1,'2015-04-22',1,'ffeef',1,100,'2015-04-23','');
/*!40000 ALTER TABLE `insumo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `laboratorio`
--

DROP TABLE IF EXISTS `laboratorio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `laboratorio` (
  `idLaboratorio` int(11) NOT NULL,
  `RUC` varchar(45) DEFAULT NULL,
  `Razon_Social` varchar(45) DEFAULT NULL,
  `Direccion` varchar(45) DEFAULT NULL,
  `idDistrito` int(11) DEFAULT NULL,
  `idProvicia` int(11) DEFAULT NULL,
  `idDepartamento` int(11) DEFAULT NULL,
  `Nombre_Encargado` varchar(60) DEFAULT NULL,
  `Estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idLaboratorio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `laboratorio`
--

LOCK TABLES `laboratorio` WRITE;
/*!40000 ALTER TABLE `laboratorio` DISABLE KEYS */;
/*!40000 ALTER TABLE `laboratorio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medida`
--

DROP TABLE IF EXISTS `medida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medida` (
  `idMedida` int(11) NOT NULL,
  `Descripcion` varchar(45) DEFAULT NULL,
  `Estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idMedida`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medida`
--

LOCK TABLES `medida` WRITE;
/*!40000 ALTER TABLE `medida` DISABLE KEYS */;
INSERT INTO `medida` VALUES (1,'MED_1',1),(2,'MED_2',1);
/*!40000 ALTER TABLE `medida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordenproduccion`
--

DROP TABLE IF EXISTS `ordenproduccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ordenproduccion` (
  `idOrdenProduccion` int(11) NOT NULL,
  `idLaboratorio` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `fechaRegistro` datetime DEFAULT NULL,
  `comentario` varchar(60) DEFAULT NULL,
  `Imagen` longblob,
  `Estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idOrdenProduccion`),
  KEY `fk_ordenproduccion_laboratorio1_idx` (`idLaboratorio`),
  KEY `fk_ordenproduccion_usuario1_idx` (`idUsuario`),
  CONSTRAINT `fk_ordenproduccion_laboratorio1` FOREIGN KEY (`idLaboratorio`) REFERENCES `laboratorio` (`idLaboratorio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ordenproduccion_usuario1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordenproduccion`
--

LOCK TABLES `ordenproduccion` WRITE;
/*!40000 ALTER TABLE `ordenproduccion` DISABLE KEYS */;
/*!40000 ALTER TABLE `ordenproduccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permisos`
--

DROP TABLE IF EXISTS `permisos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permisos` (
  `idPermisos` int(11) NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `Estado` int(11) DEFAULT NULL,
  `URL` varchar(45) DEFAULT NULL,
  `Icono` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idPermisos`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permisos`
--

LOCK TABLES `permisos` WRITE;
/*!40000 ALTER TABLE `permisos` DISABLE KEYS */;
INSERT INTO `permisos` VALUES (1,'Insumos',1,'frm_insumo.jsf',''),(2,'Formula',1,'frm_formula.jsf',NULL);
/*!40000 ALTER TABLE `permisos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `idPersona` int(11) NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `Apellido` varchar(45) DEFAULT NULL,
  `Fecha_Nacimiento` date DEFAULT NULL,
  `DNI` int(8) DEFAULT NULL,
  `Direccion` varchar(45) DEFAULT NULL,
  `idDistrito` int(11) DEFAULT NULL,
  `idProvicia` int(11) DEFAULT NULL,
  `idDepartamento` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPersona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'RICARDO','VASQUEZ','1995-09-03',2323,'fe',1,1,1);
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `idProducto` varchar(50) NOT NULL,
  `idTipoProducto` int(11) NOT NULL,
  `idEmpresa` int(11) NOT NULL,
  `Fecha_Creacion` date DEFAULT NULL,
  `Estado` int(11) DEFAULT NULL,
  `Comentario` varchar(45) DEFAULT NULL,
  `Calidad` int(11) DEFAULT NULL,
  `Imagen` longblob,
  `Tiempo_Caducacion` date DEFAULT NULL,
  PRIMARY KEY (`idProducto`),
  KEY `fk_Producto_TipoProducto1_idx` (`idTipoProducto`),
  KEY `fk_Producto_Empresa1_idx` (`idEmpresa`),
  CONSTRAINT `fk_Producto_Empresa1` FOREIGN KEY (`idEmpresa`) REFERENCES `empresa` (`idEmpresa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Producto_TipoProducto1` FOREIGN KEY (`idTipoProducto`) REFERENCES `tipoproducto` (`idTipoProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rol` (
  `idRol` int(11) NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `Estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idRol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'ADMINISTRADOR',1);
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rolxpermisos`
--

DROP TABLE IF EXISTS `rolxpermisos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rolxpermisos` (
  `idRol` int(11) NOT NULL,
  `idPermisos` int(11) NOT NULL,
  PRIMARY KEY (`idRol`,`idPermisos`),
  KEY `fk_rol_has_permisos_permisos1_idx` (`idPermisos`),
  KEY `fk_rol_has_permisos_rol1_idx` (`idRol`),
  CONSTRAINT `fk_rol_has_permisos_permisos1` FOREIGN KEY (`idPermisos`) REFERENCES `permisos` (`idPermisos`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_rol_has_permisos_rol1` FOREIGN KEY (`idRol`) REFERENCES `rol` (`idRol`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rolxpermisos`
--

LOCK TABLES `rolxpermisos` WRITE;
/*!40000 ALTER TABLE `rolxpermisos` DISABLE KEYS */;
INSERT INTO `rolxpermisos` VALUES (1,1),(1,2);
/*!40000 ALTER TABLE `rolxpermisos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipogasto`
--

DROP TABLE IF EXISTS `tipogasto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipogasto` (
  `idTipoGasto` int(11) NOT NULL,
  `Descripcion` varchar(45) DEFAULT NULL,
  `Estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idTipoGasto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipogasto`
--

LOCK TABLES `tipogasto` WRITE;
/*!40000 ALTER TABLE `tipogasto` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipogasto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoinsumo`
--

DROP TABLE IF EXISTS `tipoinsumo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipoinsumo` (
  `idTipoInsumo` int(11) NOT NULL,
  `idContenedores` int(11) NOT NULL,
  `idMedida` int(11) NOT NULL,
  `Descripcion` varchar(45) DEFAULT NULL,
  `Estado` int(11) DEFAULT NULL,
  `Comentario` varchar(45) DEFAULT NULL,
  `Temperatura_Minima` varchar(45) DEFAULT NULL,
  `Temperatura_Maxima` varchar(45) DEFAULT NULL,
  `Tiempo_Expiracion` double DEFAULT NULL,
  PRIMARY KEY (`idTipoInsumo`),
  KEY `fk_tipoinsumo_contenedores1_idx` (`idContenedores`),
  KEY `fk_tipoinsumo_medida1_idx` (`idMedida`),
  CONSTRAINT `fk_tipoinsumo_contenedores1` FOREIGN KEY (`idContenedores`) REFERENCES `contenedores` (`idContenedores`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tipoinsumo_medida1` FOREIGN KEY (`idMedida`) REFERENCES `medida` (`idMedida`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoinsumo`
--

LOCK TABLES `tipoinsumo` WRITE;
/*!40000 ALTER TABLE `tipoinsumo` DISABLE KEYS */;
INSERT INTO `tipoinsumo` VALUES (1,1,1,'TIP_1',1,'tip','1','1',1);
/*!40000 ALTER TABLE `tipoinsumo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoproducto`
--

DROP TABLE IF EXISTS `tipoproducto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipoproducto` (
  `idTipoProducto` int(11) NOT NULL,
  `idContenedores` int(11) NOT NULL,
  `idMedida` int(11) NOT NULL,
  `Descripcion` varchar(45) DEFAULT NULL,
  `Estado` int(11) DEFAULT NULL,
  `Comentario` varchar(45) DEFAULT NULL,
  `Temperatura_Minima` varchar(45) DEFAULT NULL,
  `Temperatura_Maxima` varchar(45) DEFAULT NULL,
  `Tiempo_Expiracion` double DEFAULT NULL,
  PRIMARY KEY (`idTipoProducto`),
  KEY `fk_TipoProducto_Contenedores1_idx` (`idContenedores`),
  KEY `fk_TipoProducto_Medida1_idx` (`idMedida`),
  CONSTRAINT `fk_TipoProducto_Contenedores1` FOREIGN KEY (`idContenedores`) REFERENCES `contenedores` (`idContenedores`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_TipoProducto_Medida1` FOREIGN KEY (`idMedida`) REFERENCES `medida` (`idMedida`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoproducto`
--

LOCK TABLES `tipoproducto` WRITE;
/*!40000 ALTER TABLE `tipoproducto` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipoproducto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transformacion`
--

DROP TABLE IF EXISTS `transformacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transformacion` (
  `idFormula` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `idProducto` varchar(50) NOT NULL,
  `idInsumo` varchar(50) NOT NULL,
  `idOrdenProduccion` int(11) NOT NULL,
  `Comentario` varchar(45) DEFAULT NULL,
  `Fecha_Tansformacion` date DEFAULT NULL,
  PRIMARY KEY (`idFormula`,`idUsuario`,`idProducto`,`idInsumo`,`idOrdenProduccion`),
  KEY `fk_laboratorio_has_formula_formula1_idx` (`idFormula`),
  KEY `fk_laboratorio_has_formula_usuario1_idx` (`idUsuario`),
  KEY `fk_transformacion_ordenproduccion1_idx` (`idOrdenProduccion`),
  KEY `fk_transformacion_producto1_idx` (`idProducto`),
  KEY `fk_transformacion_insumo1_idx` (`idInsumo`),
  CONSTRAINT `fk_laboratorio_has_formula_formula1` FOREIGN KEY (`idFormula`) REFERENCES `formula` (`idFormula`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_laboratorio_has_formula_usuario1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_transformacion_insumo1` FOREIGN KEY (`idInsumo`) REFERENCES `insumo` (`idInsumo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_transformacion_ordenproduccion1` FOREIGN KEY (`idOrdenProduccion`) REFERENCES `ordenproduccion` (`idOrdenProduccion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_transformacion_producto1` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transformacion`
--

LOCK TABLES `transformacion` WRITE;
/*!40000 ALTER TABLE `transformacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `transformacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ubigeo`
--

DROP TABLE IF EXISTS `ubigeo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ubigeo` (
  `idUbigeo` int(11) NOT NULL,
  `Desc_Ubigeo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idUbigeo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ubigeo`
--

LOCK TABLES `ubigeo` WRITE;
/*!40000 ALTER TABLE `ubigeo` DISABLE KEYS */;
/*!40000 ALTER TABLE `ubigeo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL,
  `idPersona` int(11) NOT NULL,
  `Nombre_Usuario` varchar(45) DEFAULT NULL,
  `Clave` varchar(45) DEFAULT NULL,
  `Fecha_Registro` varchar(45) DEFAULT NULL,
  `Estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `fk_usuario_persona1_idx` (`idPersona`),
  CONSTRAINT `fk_usuario_persona1` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,1,'rikardo','123','1995-09-03',1),(2,1,'CUCHI','SELACOME','1995-09-03',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarioxrol`
--

DROP TABLE IF EXISTS `usuarioxrol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarioxrol` (
  `idUsuario` int(11) NOT NULL,
  `idRol` int(11) NOT NULL,
  PRIMARY KEY (`idUsuario`,`idRol`),
  KEY `fk_usuario_has_rol_rol1_idx` (`idRol`),
  KEY `fk_usuario_has_rol_usuario1_idx` (`idUsuario`),
  CONSTRAINT `fk_usuario_has_rol_rol1` FOREIGN KEY (`idRol`) REFERENCES `rol` (`idRol`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_has_rol_usuario1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarioxrol`
--

LOCK TABLES `usuarioxrol` WRITE;
/*!40000 ALTER TABLE `usuarioxrol` DISABLE KEYS */;
INSERT INTO `usuarioxrol` VALUES (1,1);
/*!40000 ALTER TABLE `usuarioxrol` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-04-22  5:20:07
