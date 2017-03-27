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
  `reply_dt` datetime DEFAULT NULL,
  `refer_reply_id` bigint(20) DEFAULT NULL,
  `correct` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`reply_id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bbs_reply`
--

LOCK TABLES `bbs_reply` WRITE;
/*!40000 ALTER TABLE `bbs_reply` DISABLE KEYS */;
INSERT INTO `bbs_reply` VALUES (1,2,63,'user.getUserId() 是怎么回事？','2017-03-21 00:00:00',NULL,NULL),(2,3,63,'发个娃娃对对对的点点滴滴多多多多多多灌灌灌灌','2017-03-21 12:06:03',NULL,NULL),(3,4,63,'高危儿安慰发发发哥啊个安慰','2017-03-21 12:07:17',NULL,NULL),(4,6,63,'12','2017-03-21 15:59:42',NULL,NULL),(5,7,63,'12','2017-03-21 15:59:49',NULL,NULL),(6,8,63,'12','2017-03-21 15:59:54',NULL,NULL),(7,9,63,'12','2017-03-21 15:59:59',NULL,NULL),(8,10,63,'12','2017-03-21 16:00:04',NULL,NULL),(9,11,63,'12','2017-03-21 16:00:08',NULL,NULL),(10,12,63,'12','2017-03-21 16:00:14',NULL,NULL),(11,13,63,'12','2017-03-21 16:00:19',NULL,NULL),(12,14,63,'12','2017-03-21 16:00:24',NULL,NULL),(13,15,63,'12','2017-03-21 16:00:30',NULL,NULL),(14,16,63,'2','2017-03-21 16:12:52',NULL,NULL),(15,17,63,'2','2017-03-21 16:12:58',NULL,NULL),(16,18,63,'2','2017-03-21 16:13:03',NULL,NULL),(17,19,63,'2','2017-03-21 16:13:08',NULL,NULL),(18,20,63,'2','2017-03-21 16:13:13',NULL,NULL),(19,21,63,'2','2017-03-21 16:13:18',NULL,NULL),(20,22,63,'2','2017-03-21 16:13:23',NULL,NULL),(21,23,63,'2','2017-03-21 16:13:27',NULL,NULL),(22,24,63,'2','2017-03-21 16:13:32',NULL,'1'),(23,24,63,'顶顶顶顶','2017-03-21 20:06:05',NULL,NULL),(24,24,63,'why','2017-03-21 22:36:45',NULL,NULL),(25,24,63,'对对对','2017-03-21 20:22:03',NULL,NULL),(26,24,63,'对对对1','2017-03-21 20:22:07',NULL,NULL),(27,24,63,'对对对12','2017-03-21 20:22:12',NULL,NULL),(28,24,63,'对对对123','2017-03-21 20:22:15',NULL,NULL),(29,24,63,'对对对1234','2017-03-21 20:22:17',NULL,NULL),(30,24,63,'对对对12345','2017-03-21 20:22:19',NULL,NULL),(31,24,63,'对对对123456','2017-03-21 20:22:21',NULL,NULL),(32,24,63,'对对对1234567','2017-03-21 20:22:23',NULL,NULL),(33,24,63,'对对对12345678','2017-03-21 20:22:26',NULL,NULL),(34,24,63,'对对对123456789','2017-03-21 20:22:28',NULL,NULL),(35,24,63,'对对对1234567899','2017-03-21 20:22:31',NULL,NULL),(36,24,63,'','2017-03-21 21:46:30',NULL,NULL),(37,24,63,'','2017-03-21 21:46:32',NULL,NULL),(38,24,63,'','2017-03-21 21:46:34',NULL,NULL),(39,24,63,'','2017-03-21 22:23:50',NULL,NULL),(40,24,63,'','2017-03-21 22:24:21',NULL,NULL),(41,24,63,'','2017-03-21 22:24:37',NULL,NULL),(42,24,63,'','2017-03-22 10:38:28',NULL,NULL),(43,24,63,'谁啊啊啊啊啊啊啊啊啊啊啊啊啊啊','2017-03-22 10:43:11',23,NULL),(44,24,63,'我的点点滴滴多多多多多多8888888888','2017-03-22 11:04:45',43,NULL),(45,23,63,'我是yihilafjajgo\n寄过去发多多多多多\n打发个二过过或或或或\n郭德纲导入和哈哈哈','2017-03-22 12:19:05',NULL,'1'),(46,25,63,'当前，Hadoop技术发展如日中天，各种开源项目不断涌现，并且在社区的推动下蓬勃发展。越来越多的公司和企业开始利用Hadoop技术搭建自己的大数据平台并且基于大数据平台实现了各式各样的大数据应用。在实际使用过程中，很多的客户对大数据的感觉是“听起来很棒，看起来很美，用起来很难”。那么开源的软件离企业级的大数据产品到底有远呢？ 本课程带领您从另一个角度全面审视大数据平台整体技术框架，从平台管理、数据访问、数据可视化、数据安全等全新的企业级数据平台视角，以IBM商用大数据产品BigInsights为基础为您深入剖析商用大数据平台的企业级特性。','2017-03-22 17:40:27',NULL,NULL),(47,25,63,'这个 值得学习，hadoop 现在使用的越来越多了','2017-03-22 17:41:22',NULL,'1'),(48,26,64,'谁知道？','2017-03-22 21:25:27',NULL,NULL),(49,26,64,'== 是比较内存地址','2017-03-22 21:25:39',NULL,'1');
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
  `topic_dt` datetime DEFAULT NULL,
  PRIMARY KEY (`topic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bbs_topic`
--

LOCK TABLES `bbs_topic` WRITE;
/*!40000 ALTER TABLE `bbs_topic` DISABLE KEYS */;
INSERT INTO `bbs_topic` VALUES (2,63,8,'user.getUserId()','2017-03-21 00:00:00'),(3,63,8,'饭打发gay热','2017-03-21 12:06:03'),(4,63,8,'价格范围为','2017-03-21 12:07:17'),(6,63,8,'1','2017-03-21 15:59:42'),(7,63,8,'12','2017-03-21 15:59:49'),(8,63,8,'123','2017-03-21 15:59:54'),(9,63,8,'1234','2017-03-21 15:59:59'),(10,63,8,'12345','2017-03-21 16:00:04'),(11,63,8,'123456','2017-03-21 16:00:08'),(12,63,8,'1234567','2017-03-21 16:00:14'),(13,63,8,'12345678','2017-03-21 16:00:19'),(14,63,8,'123456789','2017-03-21 16:00:24'),(15,63,8,'1234567890','2017-03-21 16:00:30'),(16,63,8,'2','2017-03-21 16:12:52'),(17,63,8,'23','2017-03-21 16:12:58'),(18,63,8,'234','2017-03-21 16:13:03'),(19,63,8,'2345','2017-03-21 16:13:08'),(20,63,8,'23456','2017-03-21 16:13:13'),(21,63,8,'234567','2017-03-21 16:13:18'),(22,63,8,'2345678','2017-03-21 16:13:23'),(23,63,8,'23456789','2017-03-21 16:13:27'),(24,63,8,'234567890','2017-03-21 16:13:32'),(25,63,8,'《企业级Hadoop大数据平台实践》独立架设企业级Hadoop集群，快速搭建企业大数据平台！','2017-03-22 17:40:27'),(26,64,8,'JAVA基础? x==y?','2017-03-22 21:25:27');
/*!40000 ALTER TABLE `bbs_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chat`
--

DROP TABLE IF EXISTS `chat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `msg` varchar(1000) DEFAULT NULL,
  `dt` datetime DEFAULT NULL,
  `lesson_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat`
--

LOCK TABLES `chat` WRITE;
/*!40000 ALTER TABLE `chat` DISABLE KEYS */;
INSERT INTO `chat` VALUES (1,63,'我','2017-03-23 11:53:23',8),(2,63,'我是','2017-03-23 11:54:00',8),(3,63,'我是2','2017-03-23 11:54:56',8),(4,63,'我啊','2017-03-23 11:56:19',8),(5,63,'你是哪个？','2017-03-23 12:00:40',8),(6,63,'谁啊','2017-03-23 12:10:14',8),(7,64,'我','2017-03-23 12:11:01',8),(8,63,'肖龙好啊','2017-03-23 12:11:20',8),(9,64,'张老师好','2017-03-23 12:11:33',8),(10,64,'啊哈，，','2017-03-23 12:20:59',8),(11,64,'什么啊','2017-03-23 12:21:25',8),(12,63,'说你啊','2017-03-23 12:21:46',8),(13,63,'说你啊','2017-03-23 12:22:56',8),(14,63,'即佛阿杰','2017-03-23 12:24:53',8),(15,63,'即佛阿杰啊啊','2017-03-23 12:24:57',8),(16,63,'即佛阿杰啊啊222','2017-03-23 12:25:02',8),(17,63,'嘿','2017-03-23 12:28:23',7),(18,63,'赫尔','2017-03-23 12:29:19',7),(19,63,'弟弟','2017-03-23 12:29:37',7);
/*!40000 ALTER TABLE `chat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `knowledge`
--

DROP TABLE IF EXISTS `knowledge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `knowledge` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `lesson_id` int(11) DEFAULT NULL,
  `k_type` varchar(45) DEFAULT NULL,
  `title` varchar(450) DEFAULT NULL,
  `content` longtext,
  `k_file` varchar(4000) DEFAULT NULL,
  `create_dt` datetime DEFAULT NULL,
  `update_dt` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `knowledge`
--

LOCK TABLES `knowledge` WRITE;
/*!40000 ALTER TABLE `knowledge` DISABLE KEYS */;
INSERT INTO `knowledge` VALUES (3,8,'1,1','234567890+++','<p>2</p><p>的点点滴滴多多多多多<br/></p>','D:\\talDoc\\国土安全\\14902749800500--在线互动学习交流平台需求说明书.docx','2017-03-23 21:16:20',NULL,NULL),(4,8,'1,1','JAVA基础? x==y?1','<p>== 是比较内存地址1</p><p><img src=\"/tal/ueditor/jsp/upload/image/20170323/1490274372802083965.jpg\" title=\"1490274372802083965.jpg\" alt=\"20170309110506399.jpg\"/></p>','D:\\talDoc\\国土安全\\在线互动学习交流平台需求说明书.docx--14902743786200','2017-03-23 21:06:18',NULL,NULL),(5,8,'1','少时诵诗书所','<p>所得到的多多多多多多多多多</p><p><img src=\"/tal/ueditor/jsp/upload/image/20170323/1490275518221069857.jpg\" title=\"1490275518221069857.jpg\" alt=\"20170309110506399.jpg\"/></p>','D:\\talDoc\\国土安全\\14902755227601--在线互动学习交流平台需求说明书.docx','2017-03-23 21:25:22',NULL,63),(6,8,'1','今天是个什么日子','今天是个什么日子今天是个什么日子今天是个什么日子今天是个什么日子',NULL,'2017-03-23 21:26:54',NULL,63),(7,8,'1','奇怪了。啊。。。','对对对',NULL,'2017-03-23 21:33:11',NULL,63),(8,8,'1','水电费大概1','<p>大富大贵</p>',NULL,'2017-03-23 21:59:15',NULL,63),(11,8,'1','看四个鸳鸯蝴蝶','的点点滴滴多多多多多',NULL,'2017-03-23 22:10:36',NULL,63),(12,8,'1','少时诵诗书刚刚弟弟','<p>的点点滴滴试试<br/></p>',NULL,'2017-03-23 22:12:25',NULL,63);
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
INSERT INTO `student_lesson` VALUES (26,64,13,NULL,NULL),(27,65,13,NULL,NULL),(28,66,13,NULL,NULL),(29,67,13,NULL,NULL),(30,68,13,NULL,NULL),(31,69,13,NULL,NULL),(32,70,13,NULL,NULL),(33,71,13,NULL,NULL),(34,64,6,NULL,NULL),(35,65,6,NULL,NULL),(36,66,6,NULL,NULL),(37,67,6,NULL,NULL),(38,68,6,NULL,NULL),(39,69,6,NULL,NULL),(40,70,6,NULL,NULL),(41,71,6,NULL,NULL),(42,64,7,NULL,NULL),(43,65,7,NULL,NULL),(44,66,7,NULL,NULL),(45,67,7,NULL,NULL),(46,68,7,NULL,NULL),(47,69,7,NULL,NULL),(48,70,7,NULL,NULL),(49,71,7,NULL,NULL),(50,64,8,NULL,1),(51,65,8,NULL,NULL),(52,66,8,NULL,NULL),(53,67,8,NULL,NULL),(54,68,8,NULL,NULL),(55,69,8,NULL,NULL),(56,70,8,NULL,NULL),(57,71,8,NULL,NULL),(58,64,9,NULL,NULL),(59,65,9,NULL,NULL),(60,66,9,NULL,NULL),(61,67,9,NULL,NULL),(62,68,9,NULL,NULL),(63,69,9,NULL,NULL),(64,70,9,NULL,NULL),(65,71,9,NULL,NULL),(66,64,10,NULL,NULL),(67,65,10,NULL,NULL),(68,66,10,NULL,NULL),(69,67,10,NULL,NULL),(70,68,10,NULL,NULL),(71,69,10,NULL,NULL),(72,70,10,NULL,NULL),(73,71,10,NULL,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_work`
--

LOCK TABLES `student_work` WRITE;
/*!40000 ALTER TABLE `student_work` DISABLE KEYS */;
INSERT INTO `student_work` VALUES (1,NULL,NULL,16,NULL,'','2017-03-09 23:12:20',NULL,'\\课程设计\\14890723403301-YodaoDict.exe','YodaoDict.exe'),(2,63,NULL,18,NULL,'','2017-03-09 23:19:46',NULL,'D:\\talDoc\\国土安全\\第五周作业\\14890727861300-guid.dat','guid.dat'),(3,63,NULL,18,NULL,'','2017-03-09 23:20:50',NULL,'D:\\talDoc\\国土安全\\第五周作业\\14890728504301-YodaoDict.exe','YodaoDict.exe'),(4,63,NULL,18,NULL,'<p>法及哦啊跑几个IPO啊<br/></p>','2017-03-11 10:35:20',NULL,'D:\\talDoc\\国土安全\\第五周作业\\14891997201400-uninst.exe','uninst.exe'),(5,63,NULL,18,NULL,'','2017-03-11 10:43:23',NULL,'D:\\talDoc\\国土安全\\第五周作业\\14892002037000-InstallHelper.exe.new','InstallHelper.exe.new'),(6,63,NULL,18,NULL,'','2017-03-11 10:45:01',NULL,'D:\\talDoc\\国土安全\\第五周作业\\14892003019300-guid.dat','guid.dat'),(7,63,NULL,18,NULL,'<p>鹅鹅鹅而言一月又一月晕晕晕晕晕<br/></p>','2017-03-11 10:48:50',NULL,'D:\\talDoc\\国土安全\\第五周作业\\14892005307801-guid.dat','guid.dat'),(8,63,NULL,18,NULL,'<p>的点点滴滴多多多v 的点点滴滴多多多哈哈哈哈或或或或或或<br/></p>','2017-03-11 11:18:26',NULL,NULL,NULL),(9,63,NULL,18,NULL,'<p>的点点滴滴多多多多多多多多多多多v</p><p>酸辣粉拉倒</p><p>嘎嘎而过</p><p>大哥啊<br/></p>','2017-03-11 11:32:04',NULL,'D:\\talDoc\\国土安全\\第五周作业\\14892031244400-uninst.exe','uninst.exe'),(10,63,NULL,18,NULL,'<p>打卡机</p><p>逻辑狗</p><p>可儿姐</p><p>更接近荆防颗粒设计了几个熊<br/></p>','2017-03-11 11:44:27',NULL,NULL,NULL),(11,63,NULL,19,5,'<p><img src=\"/tal/ueditor/jsp/upload/image/20170311/1489242592987048259.jpg\" title=\"1489242592987048259.jpg\" alt=\"20170214100618577.jpg\"/></p>','2017-03-11 22:33:47','我得到的',NULL,NULL),(14,63,NULL,20,90.5,'<p>的点点滴滴</p><p>的点点滴滴</p><p><img src=\"/tal/ueditor/jsp/upload/image/20170311/1489243497065011421.jpg\" title=\"1489243497065011421.jpg\" alt=\"20170309110506399.jpg\"/></p><p>问候和哦啊好狗儿</p><p>快点看看<br/></p>','2017-03-12 19:48:43','再接再厉119我',NULL,NULL),(15,64,NULL,20,80,'<p><span style=\"font-size: 20px;\">反公告牌</span></p><p><span style=\"font-size: 20px;\">爱疯刚</span><br/></p>','2017-03-21 10:11:59','做的不错','D:\\talDoc\\国土安全\\20170312\\14900623191000-BaiduNetdisk.exe','BaiduNetdisk.exe'),(16,64,NULL,19,NULL,'打开看看扩扩扩扩扩扩扩扩扩扩扩扩扩扩扩扩扩扩','2017-03-27 21:17:37',NULL,NULL,NULL);
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
INSERT INTO `tb_user` VALUES (63,'张老师','222222',NULL,'lgclf@126.com','呼哈哈哈','teacher'),(64,'肖龙','111111','20121004185',NULL,NULL,'student'),(65,'王韵陶','111111','20111002031',NULL,NULL,'student'),(66,'张志鹏','111111','20131000148',NULL,NULL,'student'),(67,'张金生','111111','20131000204',NULL,NULL,'student'),(68,'张恩','111111','20131000344',NULL,NULL,'student'),(69,'田颖泽','111111','20131000376',NULL,NULL,'student'),(70,'袁泽皓','111111','20131000416',NULL,NULL,'student'),(71,'冉胤敏','111111','20131000993',NULL,NULL,'student'),(72,'2','111111',NULL,NULL,NULL,'system');
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
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_work`
--

LOCK TABLES `tb_work` WRITE;
/*!40000 ALTER TABLE `tb_work` DISABLE KEYS */;
INSERT INTO `tb_work` VALUES (1,0,'项目管理的五大过程组','请详细描述','2017-02-22',NULL,NULL,NULL),(2,0,'ffageag','该挖个瓦罐gre百合花',NULL,NULL,NULL,NULL),(3,0,'房间按规划iepogjpo','噶我哥和任何徐州财政v',NULL,NULL,NULL,NULL),(4,0,'可突破今天哟机油桶','割肉很极品精品热机会让食品及','2017-02-24',NULL,NULL,NULL),(5,0,'haomflagmgleaglo 飞娃儿噶','haomflagmgleaglo 飞娃儿噶','2017-02-24',NULL,NULL,NULL),(6,0,'我是一只鱼','一只会飞的笨鱼','2017-02-28',NULL,NULL,NULL),(7,0,'我是一只鱼1','一只会飞的笨鱼2','2017-02-28',NULL,NULL,NULL),(8,0,'我是一只鱼13','一只会飞的笨鱼23','2017-02-28',NULL,NULL,NULL),(9,0,'我是一只鱼133','一只会飞的笨鱼233','2017-02-28',NULL,NULL,NULL),(10,0,'我是一只鱼1334','一只会飞的笨鱼2334','2017-02-28',NULL,NULL,NULL),(11,0,'我是一只鱼13345','一只会飞的笨鱼23345','2017-02-28',NULL,NULL,NULL),(12,0,'我是一只鱼133456','一只会飞的笨鱼233456','2017-02-28',NULL,NULL,NULL),(13,7,'第一周作业','请完成教科书P23页习题1,2,3','2017-03-04','2017-03-31',NULL,NULL),(14,8,'第三周作业','经发局噢IE奇偶IQ钢琴谱见覅偶切记','2017-03-06','2017-03-31',NULL,NULL),(16,8,'课程设计','发个阿哥','2017-03-09','2017-03-31','\\课程设计\\在线互动学习交流平台需求说明书.docx','\\课程设计'),(17,10,'课程设计','发个阿哥','2017-03-09','2017-03-31','D:\\talDoc\\国土信息1\\课程设计\\在线互动学习交流平台需求说明书.docx','D:\\talDoc\\国土信息1\\课程设计'),(18,8,'第五周作业','发个啊','2017-03-09','2017-03-18','D:\\talDoc\\国土安全\\第五周作业\\YodaoDict.exe','D:\\talDoc\\国土安全\\第五周作业'),(19,8,'20170311','大动干戈','2017-03-11','2017-04-08','D:\\talDoc\\国土安全\\20170311\\数字国土成绩.xls','D:\\talDoc\\国土安全\\20170311'),(20,8,'20170312','的点点滴滴多多多多多','2017-03-11','2017-03-25',NULL,'D:\\talDoc\\国土安全\\20170312');
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

-- Dump completed on 2017-03-27 21:40:29
