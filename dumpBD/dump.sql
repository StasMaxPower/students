-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: students
-- ------------------------------------------------------
-- Server version	8.0.37

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
-- Table structure for table `discipline`
--

DROP TABLE IF EXISTS `discipline`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `discipline` (
  `id` int NOT NULL AUTO_INCREMENT,
  `discipline` varchar(200) DEFAULT NULL,
  `status` enum('0','1') DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discipline`
--

LOCK TABLES `discipline` WRITE;
/*!40000 ALTER TABLE `discipline` DISABLE KEYS */;
INSERT INTO `discipline` VALUES (1,'Высшая математика','1'),(2,'История науки и техники','1'),(3,'Политология','1'),(4,'Информатика','1'),(5,'Теория алгоритмизации','1');
/*!40000 ALTER TABLE `discipline` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grade`
--

DROP TABLE IF EXISTS `grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grade` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_student` int NOT NULL,
  `id_term_discipline` int NOT NULL,
  `value` enum('1','2','3','4','5') NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_grade_to_student_idx` (`id_student`),
  KEY `fk_grade_to_trm_discipline_idx` (`id_term_discipline`),
  CONSTRAINT `fk_grade_to_student` FOREIGN KEY (`id_student`) REFERENCES `student` (`id`),
  CONSTRAINT `fk_grade_to_trm_discipline` FOREIGN KEY (`id_term_discipline`) REFERENCES `term_discipline` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grade`
--

LOCK TABLES `grade` WRITE;
/*!40000 ALTER TABLE `grade` DISABLE KEYS */;
INSERT INTO `grade` VALUES (1,1,1,'2'),(2,1,2,'4'),(3,1,3,'4'),(4,1,4,'5'),(5,1,5,'3'),(6,1,6,'2'),(7,2,1,'2'),(8,2,2,'3'),(9,2,3,'4'),(10,2,4,'3'),(11,2,5,'5'),(12,2,6,'5');
/*!40000 ALTER TABLE `grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groupp`
--

DROP TABLE IF EXISTS `groupp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `groupp` (
  `id` int NOT NULL AUTO_INCREMENT,
  `group` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groupp`
--

LOCK TABLES `groupp` WRITE;
/*!40000 ALTER TABLE `groupp` DISABLE KEYS */;
INSERT INTO `groupp` VALUES (1,'КТ-21'),(2,'КТ-22'),(3,'test'),(4,'testGroup'),(5,'КТ-30'),(6,'testGroup'),(7,'КТ-211'),(8,'КТ-50');
/*!40000 ALTER TABLE `groupp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Администратор'),(2,'Учитель'),(3,'Студент');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `surname` varchar(200) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `id_group` int DEFAULT NULL,
  `date` timestamp(3) NULL DEFAULT NULL,
  `status` enum('0','1') DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `fk3_idx` (`id_group`),
  CONSTRAINT `fk3` FOREIGN KEY (`id_group`) REFERENCES `groupp` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'Сидоров','Сидор',8,'2024-07-02 20:00:00.000','1'),(2,'Петров','Петр',1,'2021-08-31 21:00:00.000','1'),(3,'Иванов','Иван',1,'2021-08-31 21:00:00.000','1'),(4,'Макаречив','Андрей',1,'2021-08-31 21:00:00.000','1'),(5,'Бельгиец','Василий',1,'2021-08-31 21:00:00.000','1'),(6,'Тест','Тест',2,'2021-08-31 21:00:00.000','1'),(7,'test','test',3,'2024-07-08 20:00:00.000','1'),(8,'testt','testt',1,'2024-07-08 20:00:00.000','1'),(9,'Тестовый','Студент',1,'2023-12-31 21:00:00.000','1'),(10,'TEST','TEST',1,'2024-06-30 20:00:00.000','1'),(11,'Сидоров!','Сидор!',7,'2024-07-02 20:00:00.000','1');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `term`
--

DROP TABLE IF EXISTS `term`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `term` (
  `id` int NOT NULL AUTO_INCREMENT,
  `term` varchar(200) DEFAULT NULL,
  `duration` varchar(200) DEFAULT NULL,
  `status` enum('1','0') DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `term`
--

LOCK TABLES `term` WRITE;
/*!40000 ALTER TABLE `term` DISABLE KEYS */;
INSERT INTO `term` VALUES (1,'Семестр 1','24 недели','1'),(2,'Семестр 2','18 недель','1'),(3,'Семестр 3','20 недель','1'),(4,'Семестр 4','16 недель','1');
/*!40000 ALTER TABLE `term` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `term_discipline`
--

DROP TABLE IF EXISTS `term_discipline`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `term_discipline` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_term` int DEFAULT NULL,
  `id_discipline` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk4_idx` (`id_term`),
  KEY `fk5_idx` (`id_discipline`),
  CONSTRAINT `fk4` FOREIGN KEY (`id_term`) REFERENCES `term` (`id`),
  CONSTRAINT `fk5` FOREIGN KEY (`id_discipline`) REFERENCES `discipline` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `term_discipline`
--

LOCK TABLES `term_discipline` WRITE;
/*!40000 ALTER TABLE `term_discipline` DISABLE KEYS */;
INSERT INTO `term_discipline` VALUES (1,1,1),(2,1,2),(3,1,3),(4,2,3),(5,2,4),(6,2,5);
/*!40000 ALTER TABLE `term_discipline` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user` varchar(200) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','password'),(2,'teacher','123'),(3,'student','123'),(4,'erg','dg');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_user` int DEFAULT NULL,
  `id_role` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk1_idx` (`id_role`),
  KEY `fk2_idx` (`id_user`),
  CONSTRAINT `fk1` FOREIGN KEY (`id_role`) REFERENCES `role` (`id`),
  CONSTRAINT `fk2` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1,1),(2,1,2),(3,1,3),(4,2,2),(5,2,3),(6,3,3);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-09 15:48:37
