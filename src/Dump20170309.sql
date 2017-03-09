-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: tal
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `bbs_reply`
--

DROP TABLE IF EXISTS `bbs_reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bbs_reply` (
  `reply_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `topic_id` bigint(20) NOT NULL,
  `user_id` int(11) NOT NULL,
  `reply_content` longtext,
  `reply_dt` date DEFAULT NULL,
  PRIMARY KEY (`reply_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bbs_reply`
--

LOCK TABLES `bbs_reply` WRITE;
/*!40000 ALTER TABLE `bbs_reply` DISABLE KEYS */;
/*!40000 ALTER TABLE `bbs_reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bbs_topic`
--

DROP TABLE IF EXISTS `bbs_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bbs_topic` (
  `topic_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `lesson_id` int(11) DEFAULT NULL,
  `topic_name` varchar(450) NOT NULL,
  `topic_dt` date DEFAULT NULL,
  PRIMARY KEY (`topic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bbs_topic`
--

LOCK TABLES `bbs_topic` WRITE;
/*!40000 ALTER TABLE `bbs_topic` DISABLE KEYS */;
/*!40000 ALTER TABLE `bbs_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `knowledge`
--

DROP TABLE IF EXISTS `knowledge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `knowledge` (
  `id` bigint(20) NOT NULL,
  `lesson_id` int(11) DEFAULT NULL,
  `k_type` varchar(45) DEFAULT NULL,
  `title` varchar(450) DEFAULT NULL,
  `content` varchar(4000) DEFAULT NULL,
  `k_file` varchar(4000) DEFAULT NULL,
  `create_dt` date DEFAULT NULL,
  `update_dt` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `knowledge`
--

LOCK TABLES `knowledge` WRITE;
/*!40000 ALTER TABLE `knowledge` DISABLE KEYS */;
/*!40000 ALTER TABLE `knowledge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lesson`
--

DROP TABLE IF EXISTS `lesson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lesson` (
  `lesson_id` int(11) NOT NULL AUTO_INCREMENT,
  `year` varchar(45) DEFAULT NULL,
  `lesson_name` varchar(150) NOT NULL,
  `create_dt` date DEFAULT NULL,
  `lesson_desc` varchar(450) DEFAULT NULL,
  PRIMARY KEY (`lesson_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lesson`
--

LOCK TABLES `lesson` WRITE;
/*!40000 ALTER TABLE `lesson` DISABLE KEYS */;
INSERT INTO `lesson` VALUES (1,'2017','国土信息',NULL,NULL),(2,'2018','国土信息',NULL,NULL),(3,'2018','国土信息1',NULL,NULL),(4,'2018','扣扣欧文','2017-03-03',NULL),(5,'2018','国土信息2','2017-03-03',NULL),(6,'2017','国土信息','2017-03-04',NULL),(7,'2017','数字国土','2017-03-04',NULL),(8,'2017','国土安全','2017-03-04','D:\\talDoc\\国土安全'),(10,'2017','国土信息1','2017-03-04','D:\\talDoc\\国土信息1');
/*!40000 ALTER TABLE `lesson` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_lesson`
--

DROP TABLE IF EXISTS `student_lesson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_lesson` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `lesson_id` int(11) DEFAULT NULL,
  `total_score` double DEFAULT NULL,
  `answer_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_lesson`
--

LOCK TABLES `student_lesson` WRITE;
/*!40000 ALTER TABLE `student_lesson` DISABLE KEYS */;
INSERT INTO `student_lesson` VALUES (26,64,13,NULL,NULL),(27,65,13,NULL,NULL),(28,66,13,NULL,NULL),(29,67,13,NULL,NULL),(30,68,13,NULL,NULL),(31,69,13,NULL,NULL),(32,70,13,NULL,NULL),(33,71,13,NULL,NULL),(34,64,6,NULL,NULL),(35,65,6,NULL,NULL),(36,66,6,NULL,NULL),(37,67,6,NULL,NULL),(38,68,6,NULL,NULL),(39,69,6,NULL,NULL),(40,70,6,NULL,NULL),(41,71,6,NULL,NULL),(42,64,7,NULL,NULL),(43,65,7,NULL,NULL),(44,66,7,NULL,NULL),(45,67,7,NULL,NULL),(46,68,7,NULL,NULL),(47,69,7,NULL,NULL),(48,70,7,NULL,NULL),(49,71,7,NULL,NULL),(50,64,8,NULL,NULL),(51,65,8,NULL,NULL),(52,66,8,NULL,NULL),(53,67,8,NULL,NULL),(54,68,8,NULL,NULL),(55,69,8,NULL,NULL),(56,70,8,NULL,NULL),(57,71,8,NULL,NULL),(58,64,9,NULL,NULL),(59,65,9,NULL,NULL),(60,66,9,NULL,NULL),(61,67,9,NULL,NULL),(62,68,9,NULL,NULL),(63,69,9,NULL,NULL),(64,70,9,NULL,NULL),(65,71,9,NULL,NULL),(66,64,10,NULL,NULL),(67,65,10,NULL,NULL),(68,66,10,NULL,NULL),(69,67,10,NULL,NULL),(70,68,10,NULL,NULL),(71,69,10,NULL,NULL),(72,70,10,NULL,NULL),(73,71,10,NULL,NULL);
/*!40000 ALTER TABLE `student_lesson` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_work`
--

DROP TABLE IF EXISTS `student_work`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_work` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `lesson_id` int(11) DEFAULT NULL,
  `work_id` bigint(20) DEFAULT NULL,
  `score` double DEFAULT NULL,
  `work_content` mediumtext,
  `work_dt` datetime DEFAULT NULL,
  `teacher_comment` varchar(450) DEFAULT NULL,
  `work_file_path` varchar(1000) DEFAULT NULL,
  `work_file_name` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_work`
--

LOCK TABLES `student_work` WRITE;
/*!40000 ALTER TABLE `student_work` DISABLE KEYS */;
INSERT INTO `student_work` VALUES (1,NULL,NULL,16,NULL,'','2017-03-09 23:12:20',NULL,'\\课程设计\\14890723403301-YodaoDict.exe','YodaoDict.exe'),(2,63,NULL,18,NULL,'','2017-03-09 23:19:46',NULL,'D:\\talDoc\\国土安全\\第五周作业\\14890727861300-guid.dat','guid.dat'),(3,63,NULL,18,NULL,'','2017-03-09 23:20:50',NULL,'D:\\talDoc\\国土安全\\第五周作业\\14890728504301-YodaoDict.exe','YodaoDict.exe');
/*!40000 ALTER TABLE `student_work` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) COLLATE utf8_bin NOT NULL,
  `password` varchar(45) COLLATE utf8_bin NOT NULL,
  `user_no` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `contact` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `role` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` VALUES (63,'张老师','123456',NULL,NULL,NULL,'teacher'),(64,'肖龙','123456','20121004185',NULL,NULL,'student'),(65,'王韵陶','123456','20111002031',NULL,NULL,'student'),(66,'张志鹏','123456','20131000148',NULL,NULL,'student'),(67,'张金生','123456','20131000204',NULL,NULL,'student'),(68,'张恩','123456','20131000344',NULL,NULL,'student'),(69,'田颖泽','123456','20131000376',NULL,NULL,'student'),(70,'袁泽皓','123456','20131000416',NULL,NULL,'student'),(71,'冉胤敏','123456','20131000993',NULL,NULL,'student'),(72,'2','2',NULL,NULL,NULL,'system');
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_work`
--

DROP TABLE IF EXISTS `tb_work`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_work` (
  `work_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `lesson_id` int(11) NOT NULL,
  `work_tile` varchar(450) COLLATE utf8_bin DEFAULT NULL,
  `work_text1` varchar(3000) COLLATE utf8_bin DEFAULT NULL,
  `work_date1` date DEFAULT NULL,
  `complete_dt` date DEFAULT NULL,
  `work_file` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `work_path` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`work_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_work`
--

LOCK TABLES `tb_work` WRITE;
/*!40000 ALTER TABLE `tb_work` DISABLE KEYS */;
INSERT INTO `tb_work` VALUES (1,0,'项目管理的五大过程组','请详细描述','2017-02-22',NULL,NULL,NULL),(2,0,'ffageag','该挖个瓦罐gre百合花',NULL,NULL,NULL,NULL),(3,0,'房间按规划iepogjpo','噶我哥和任何徐州财政v',NULL,NULL,NULL,NULL),(4,0,'可突破今天哟机油桶','割肉很极品精品热机会让食品及','2017-02-24',NULL,NULL,NULL),(5,0,'haomflagmgleaglo 飞娃儿噶','haomflagmgleaglo 飞娃儿噶','2017-02-24',NULL,NULL,NULL),(6,0,'我是一只鱼','一只会飞的笨鱼','2017-02-28',NULL,NULL,NULL),(7,0,'我是一只鱼1','一只会飞的笨鱼2','2017-02-28',NULL,NULL,NULL),(8,0,'我是一只鱼13','一只会飞的笨鱼23','2017-02-28',NULL,NULL,NULL),(9,0,'我是一只鱼133','一只会飞的笨鱼233','2017-02-28',NULL,NULL,NULL),(10,0,'我是一只鱼1334','一只会飞的笨鱼2334','2017-02-28',NULL,NULL,NULL),(11,0,'我是一只鱼13345','一只会飞的笨鱼23345','2017-02-28',NULL,NULL,NULL),(12,0,'我是一只鱼133456','一只会飞的笨鱼233456','2017-02-28',NULL,NULL,NULL),(13,7,'第一周作业','请完成教科书P23页习题1,2,3','2017-03-04','2017-03-31',NULL,NULL),(14,8,'第三周作业','经发局噢IE奇偶IQ钢琴谱见覅偶切记','2017-03-06','2017-03-31',NULL,NULL),(16,8,'课程设计','发个阿哥','2017-03-09','2017-03-31','\\课程设计\\在线互动学习交流平台需求说明书.docx','\\课程设计'),(17,10,'课程设计','发个阿哥','2017-03-09','2017-03-31','D:\\talDoc\\国土信息1\\课程设计\\在线互动学习交流平台需求说明书.docx','D:\\talDoc\\国土信息1\\课程设计'),(18,8,'第五周作业','发个啊','2017-03-09','2017-03-18','D:\\talDoc\\国土安全\\第五周作业\\YodaoDict.exe','D:\\talDoc\\国土安全\\第五周作业');
/*!40000 ALTER TABLE `tb_work` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_lesson`
--

DROP TABLE IF EXISTS `teacher_lesson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher_lesson` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `lesson_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_lesson`
--

LOCK TABLES `teacher_lesson` WRITE;
/*!40000 ALTER TABLE `teacher_lesson` DISABLE KEYS */;
INSERT INTO `teacher_lesson` VALUES (1,63,6),(2,63,7),(3,63,8),(5,63,10);
/*!40000 ALTER TABLE `teacher_lesson` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-09 23:22:31
