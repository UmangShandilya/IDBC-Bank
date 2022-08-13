-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: idbc
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `payaccount`
--

DROP TABLE IF EXISTS `payaccount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payaccount` (
  `AccountNumber` varchar(15) NOT NULL,
  `AccountHolder` varchar(50) NOT NULL,
  `NationalID` int NOT NULL,
  `mobile` bigint DEFAULT NULL,
  `Balance` int NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`AccountNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `paytransactions`
--

DROP TABLE IF EXISTS `paytransactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paytransactions` (
  `AccountNumber` varchar(20) DEFAULT NULL,
  `TransactionId` int NOT NULL,
  `Date` date DEFAULT NULL,
  `Withdraw` int DEFAULT NULL,
  `Deposit` int DEFAULT NULL,
  `TransactionTime` time DEFAULT NULL,
  KEY `AccountNumber` (`AccountNumber`),
  CONSTRAINT `paytransactions_ibfk_1` FOREIGN KEY (`AccountNumber`) REFERENCES `payaccount` (`AccountNumber`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `savingsaccount`
--

DROP TABLE IF EXISTS `savingsaccount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `savingsaccount` (
  `AccountNumber` varchar(15) NOT NULL,
  `AccountHolder` varchar(50) NOT NULL,
  `NationalID` int NOT NULL,
  `mobile` bigint DEFAULT NULL,
  `Balance` int NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`AccountNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `savingtransactions`
--

DROP TABLE IF EXISTS `savingtransactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `savingtransactions` (
  `AccountNumber` varchar(20) DEFAULT NULL,
  `TransactionId` int NOT NULL,
  `Date` date DEFAULT NULL,
  `Withdraw` int DEFAULT NULL,
  `Deposit` int DEFAULT NULL,
  `TransactionTime` time DEFAULT NULL,
  KEY `AccountNumber` (`AccountNumber`),
  CONSTRAINT `savingtransactions_ibfk_1` FOREIGN KEY (`AccountNumber`) REFERENCES `savingsaccount` (`AccountNumber`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-13 23:10:54
