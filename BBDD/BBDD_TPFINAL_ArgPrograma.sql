-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: equipos
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `apuestas`
--

DROP TABLE IF EXISTS `apuestas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `apuestas` (
  `nombre` varchar(100) DEFAULT NULL,
  `equipolocal` varchar(100) DEFAULT NULL,
  `equipovisitante` varchar(100) DEFAULT NULL,
  `resultado` int DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `ronda` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apuestas`
--

LOCK TABLES `apuestas` WRITE;
/*!40000 ALTER TABLE `apuestas` DISABLE KEYS */;
INSERT INTO `apuestas` VALUES ('mariana','Ecuador','Senegal',2,1,'Grupo A'),('mariana','paises bajos','catar',1,3,'Octavos'),('pedro','argentina','paises bajos',1,12,'cuartos'),('pedro','francia','inglaterra',1,13,'cuartos'),('pedro','marruecos','portugal',1,14,'cuartos'),('pedro','croacia','brasil',1,15,'cuartos'),('juan','uruguay','corea del Sur',0,16,'Grupo H'),('juan','portugal','Uruguay',1,17,'Grupo H'),('sergio','brasil','suiza',2,18,'Grupo Z'),('sergio','brasil','suiza',1,19,'Grupo H'),('mariana','paises bajos','catar',1,20,'Octavos');
/*!40000 ALTER TABLE `apuestas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partidos`
--

DROP TABLE IF EXISTS `partidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `partidos` (
  `equipolocal` varchar(100) DEFAULT NULL,
  `goleslocal` int DEFAULT NULL,
  `golesvisitante` int DEFAULT NULL,
  `equipovisitante` varchar(100) DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `ronda` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partidos`
--

LOCK TABLES `partidos` WRITE;
/*!40000 ALTER TABLE `partidos` DISABLE KEYS */;
INSERT INTO `partidos` VALUES ('Argentina',4,2,'Francia',1,'Final'),('Croacia',2,1,'Marruecos',2,'Tercer lugar'),('Argentina',3,0,'Croacia',3,'Semifinal'),('Francia ',2,0,'Marruecos',4,'Semifinal'),('Argentina',4,3,'Paises Bajos',5,'Cuartos'),('Francia',2,1,'Inglaterra',6,'Cuartos'),('Marruecos',1,0,'Portugal',7,'Cuartos'),('Croacia',4,2,'Brasil',8,'Cuartos'),('Paises Bajos',3,1,'Estados Unidos',9,'Octavos'),('Argentina',2,1,'Australia',10,'Octavos'),('Francia',3,1,'Polonia',11,'Octavos'),('Inglaterra',3,0,'Senegal',12,'Octavos'),('Japon',1,3,'Croacia',13,'Octavos'),('Brasil',4,1,'Corea del Sur',14,'Octavos'),('Marruecos ',3,0,'España',15,'Octavos'),('Portugal',6,1,'Suiza',16,'Octavos'),('Ecuador',1,2,'Senegal',17,'Grupo A'),('Paises Bajos',2,0,'Catar',18,'Grupo A'),('Iran',0,1,'Estados Unidos',19,'Grupo B'),('Gales',0,3,'Inglaterra',20,'Grupo B'),('Polonia',0,2,'Argentina',21,'Grupo C'),('Polonia',2,0,'Arabia Saudita',22,'Grupo C'),('Francia',2,1,'Dinamarca',23,'Grupo D'),('Australia',1,0,'Dinamarca',24,'Grupo D'),('Japon',2,1,'España',25,'Grupo E'),('España',7,0,'Costa Rica',26,'Grupo E'),('Croacia',4,1,'Canada',27,'Grupo F'),('Canada ',1,2,'Marruecos',28,'Grupo F'),('Serbia',2,3,'Suiza',29,'Grupo G'),('Brasil',1,0,'Suiza',30,'Grupo G'),('Portugal',2,0,'Uruguay',31,'Grupo H'),('Uruguay',0,0,'Corea del Sur',32,'Grupo H'),('Brasil',0,2,'Suiza',33,'Grupo Z');
/*!40000 ALTER TABLE `partidos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-27 15:05:05
