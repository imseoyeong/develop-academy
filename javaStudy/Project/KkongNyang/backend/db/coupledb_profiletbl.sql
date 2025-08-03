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
-- Table structure for table `profiletbl`
--

DROP TABLE IF EXISTS `profiletbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profiletbl` (
  `username` varchar(255) NOT NULL,
  `profileimage` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `couplecode` varchar(255) DEFAULT NULL,
  `firstday` date DEFAULT NULL,
  PRIMARY KEY (`username`),
  CONSTRAINT `fk_username` FOREIGN KEY (`username`) REFERENCES `authentbl` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profiletbl`
--

LOCK TABLES `profiletbl` WRITE;
/*!40000 ALTER TABLE `profiletbl` DISABLE KEYS */;
INSERT INTO `profiletbl` VALUES ('aaa','upload_image\\86af8476-a21f-4df7-9e6b-097ca726531a.jpg','미미미',NULL,NULL),('bbb','upload_image\\5d99553a-01a8-401e-b1a5-5450857a3560.jpg','바다',NULL,NULL),('ccc','upload_image\\b7449c73-8197-4be1-89bd-2c7953972b2b.jpg','창기코인','37b5763b-0973-4037-a07f-2b344193ee5c',NULL),('ddd','upload_image\\51721d1e-cc1b-4ee2-b5a7-56713dbddd3d.jpg','관우장군','37b5763b-0973-4037-a07f-2b344193ee5c',NULL);
/*!40000 ALTER TABLE `profiletbl` ENABLE KEYS */;
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
