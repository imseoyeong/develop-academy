CREATE DATABASE  IF NOT EXISTS `coupledb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `coupledb`;
-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: coupledb
-- ------------------------------------------------------
-- Server version	8.0.42

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
-- Table structure for table `couplematchtbl`
--

DROP TABLE IF EXISTS `couplematchtbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `couplematchtbl` (
  `id` int NOT NULL AUTO_INCREMENT,
  `part1` varchar(255) NOT NULL,
  `part2` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  `profileimage` varchar(255) DEFAULT NULL,
  `couplestory` tinytext,
  `part1nickname` varchar(255) DEFAULT NULL,
  `part2nickname` varchar(255) DEFAULT NULL,
  `firstday` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_part1_idx` (`part1`),
  KEY `fk_part2_idx` (`part2`,`part1`),
  CONSTRAINT `fk_part1` FOREIGN KEY (`part1`) REFERENCES `authentbl` (`username`),
  CONSTRAINT `fk_part2` FOREIGN KEY (`part2`) REFERENCES `authentbl` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `couplematchtbl`
--

LOCK TABLES `couplematchtbl` WRITE;
/*!40000 ALTER TABLE `couplematchtbl` DISABLE KEYS */;
INSERT INTO `couplematchtbl` VALUES (4,'ccc','ddd','37b5763b-0973-4037-a07f-2b344193ee5c','upload_image\\198249be-84db-4c65-868a-15b2d81680a0.jpg','야구잘하는커플','야구의신','야구의여신','2025-03-23');
/*!40000 ALTER TABLE `couplematchtbl` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-08-01 16:49:15
