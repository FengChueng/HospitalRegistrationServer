-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: hospitaldb
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
-- Table structure for table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `appointment` (
  `appoint_id` varchar(255) NOT NULL,
  `appoint_date` bigint(20) DEFAULT NULL,
  `clinic_date` bigint(20) DEFAULT NULL,
  `doctor_advice` varchar(255) DEFAULT NULL,
  `doctor_id` varchar(255) DEFAULT NULL,
  `loc` varchar(255) DEFAULT NULL,
  `patient_id` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`appoint_id`),
  KEY `FKoeb98n82eph1dx43v3y2bcmsl` (`doctor_id`),
  KEY `FK4apif2ewfyf14077ichee8g06` (`patient_id`),
  CONSTRAINT `FK4apif2ewfyf14077ichee8g06` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_account`),
  CONSTRAINT `FKoeb98n82eph1dx43v3y2bcmsl` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`doctor_account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment`
--

LOCK TABLES `appointment` WRITE;
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `dept_id` varchar(255) NOT NULL,
  `create_date` bigint(20) NOT NULL,
  `dept_name` varchar(255) NOT NULL,
  `info` varchar(255) NOT NULL,
  `hospital_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dept_id`),
  UNIQUE KEY `UK_sithc0jis4uq50eg8g3efs5gp` (`dept_name`),
  KEY `FKn8lq60po1t7p42oslqbk61wnu` (`hospital_id`),
  CONSTRAINT `FKn8lq60po1t7p42oslqbk61wnu` FOREIGN KEY (`hospital_id`) REFERENCES `hospital` (`hospital_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES ('312d1da9-4202-4456-a3fa-74b7c8684d5b',1287504000000,'科室6','科室6简介','156b1ab2-afeb-4d6f-997d-c99385e67d1d'),('3cfcd401-7064-4456-abaa-8c882ec30e70',1287504000000,'科室9','科室9简介','156b1ab2-afeb-4d6f-997d-c99385e67d1d'),('3d4e8937-ac90-42ee-b525-c1299f818ab5',1287504000000,'科室0','科室0简介','156b1ab2-afeb-4d6f-997d-c99385e67d1d'),('3f74c186-34c9-4252-a1bf-edbea9ffdd46',1287504000000,'科室7','科室7简介','156b1ab2-afeb-4d6f-997d-c99385e67d1d'),('6e589c8d-c503-4d0c-b38b-2cf8834393aa',1287504000000,'科室5','科室5简介','156b1ab2-afeb-4d6f-997d-c99385e67d1d'),('7f860f2f-6bc9-41cc-ae9d-a51b61884021',1287504000000,'科室2','科室2简介','156b1ab2-afeb-4d6f-997d-c99385e67d1d'),('8e960862-9f3a-4cfe-a046-524cdd918a47',1287504000000,'科室1','科室1简介','156b1ab2-afeb-4d6f-997d-c99385e67d1d'),('a5256f50-5603-4098-b268-0e8b33f44e0d',1287504000000,'科室3','科室3简介','156b1ab2-afeb-4d6f-997d-c99385e67d1d'),('d12ecaf7-ac22-4471-a77e-28b2b14714a2',1287504000000,'科室4','科室4简介','156b1ab2-afeb-4d6f-997d-c99385e67d1d'),('d59588ac-7e60-4f5e-9b36-aace9cdb7dba',1287504000000,'科室8','科室8简介','156b1ab2-afeb-4d6f-997d-c99385e67d1d');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doctor` (
  `doctor_account` varchar(11) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `birth_day` bigint(20) DEFAULT NULL,
  `info` varchar(255) NOT NULL,
  `level` int(11) DEFAULT NULL,
  `mobile_phone` varchar(11) NOT NULL,
  `order_count` int(11) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `portraint` varchar(255) DEFAULT NULL,
  `real_name` varchar(255) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `depart_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`doctor_account`),
  KEY `FKhf4fers6a3kfhgq1tdekogqj0` (`depart_id`),
  CONSTRAINT `FKhf4fers6a3kfhgq1tdekogqj0` FOREIGN KEY (`depart_id`) REFERENCES `department` (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES ('10000000000',37,312825600000,'doctor0简介',4000,'10000000000',1,'123456','/img/code.png','doctor0',60000,'3d4e8937-ac90-42ee-b525-c1299f818ab5'),('10000000001',37,315504000000,'doctor1简介',4001,'10000000001',101,'123456','/img/code.png','doctor1',60001,'3d4e8937-ac90-42ee-b525-c1299f818ab5'),('10000000002',37,318182400000,'doctor2简介',4000,'10000000002',201,'123456','/img/code.png','doctor2',60000,'3d4e8937-ac90-42ee-b525-c1299f818ab5'),('10000000003',37,320688000000,'doctor3简介',4001,'10000000003',301,'123456','/img/code.png','doctor3',60001,'3d4e8937-ac90-42ee-b525-c1299f818ab5'),('10000000004',37,323366400000,'doctor4简介',4000,'10000000004',401,'123456','/img/code.png','doctor4',60000,'3d4e8937-ac90-42ee-b525-c1299f818ab5'),('10000000010',36,344448000000,'doctor0简介',4000,'10000000010',1,'123456','/img/code.png','doctor0',60000,'8e960862-9f3a-4cfe-a046-524cdd918a47'),('10000000011',36,347126400000,'doctor1简介',4001,'10000000011',101,'123456','/img/code.png','doctor1',60001,'8e960862-9f3a-4cfe-a046-524cdd918a47'),('10000000012',36,349804800000,'doctor2简介',4000,'10000000012',201,'123456','/img/code.png','doctor2',60000,'8e960862-9f3a-4cfe-a046-524cdd918a47'),('10000000013',36,352224000000,'doctor3简介',4001,'10000000013',301,'123456','/img/code.png','doctor3',60001,'8e960862-9f3a-4cfe-a046-524cdd918a47'),('10000000014',36,354902400000,'doctor4简介',4000,'10000000014',401,'123456','/img/code.png','doctor4',60000,'8e960862-9f3a-4cfe-a046-524cdd918a47'),('10000000020',35,375984000000,'doctor0简介',4000,'10000000020',1,'123456','/img/code.png','doctor0',60000,'7f860f2f-6bc9-41cc-ae9d-a51b61884021'),('10000000021',35,378662400000,'doctor1简介',4001,'10000000021',101,'123456','/img/code.png','doctor1',60001,'7f860f2f-6bc9-41cc-ae9d-a51b61884021'),('10000000022',35,381340800000,'doctor2简介',4000,'10000000022',201,'123456','/img/code.png','doctor2',60000,'7f860f2f-6bc9-41cc-ae9d-a51b61884021'),('10000000023',35,383760000000,'doctor3简介',4001,'10000000023',301,'123456','/img/code.png','doctor3',60001,'7f860f2f-6bc9-41cc-ae9d-a51b61884021'),('10000000024',35,386438400000,'doctor4简介',4000,'10000000024',401,'123456','/img/code.png','doctor4',60000,'7f860f2f-6bc9-41cc-ae9d-a51b61884021'),('10000000030',34,407520000000,'doctor0简介',4000,'10000000030',1,'123456','/img/code.png','doctor0',60000,'a5256f50-5603-4098-b268-0e8b33f44e0d'),('10000000031',34,410198400000,'doctor1简介',4001,'10000000031',101,'123456','/img/code.png','doctor1',60001,'a5256f50-5603-4098-b268-0e8b33f44e0d'),('10000000032',34,412876800000,'doctor2简介',4000,'10000000032',201,'123456','/img/code.png','doctor2',60000,'a5256f50-5603-4098-b268-0e8b33f44e0d'),('10000000033',34,415296000000,'doctor3简介',4001,'10000000033',301,'123456','/img/code.png','doctor3',60001,'a5256f50-5603-4098-b268-0e8b33f44e0d'),('10000000034',34,417974400000,'doctor4简介',4000,'10000000034',401,'123456','/img/code.png','doctor4',60000,'a5256f50-5603-4098-b268-0e8b33f44e0d'),('10000000040',33,439056000000,'doctor0简介',4000,'10000000040',1,'123456','/img/code.png','doctor0',60000,'d12ecaf7-ac22-4471-a77e-28b2b14714a2'),('10000000041',33,441734400000,'doctor1简介',4001,'10000000041',101,'123456','/img/code.png','doctor1',60001,'d12ecaf7-ac22-4471-a77e-28b2b14714a2'),('10000000042',33,444412800000,'doctor2简介',4000,'10000000042',201,'123456','/img/code.png','doctor2',60000,'d12ecaf7-ac22-4471-a77e-28b2b14714a2'),('10000000043',33,446918400000,'doctor3简介',4001,'10000000043',301,'123456','/img/code.png','doctor3',60001,'d12ecaf7-ac22-4471-a77e-28b2b14714a2'),('10000000044',33,449596800000,'doctor4简介',4000,'10000000044',401,'123456','/img/code.png','doctor4',60000,'d12ecaf7-ac22-4471-a77e-28b2b14714a2'),('10000000050',32,470678400000,'doctor0简介',4000,'10000000050',1,'123456','/img/code.png','doctor0',60000,'6e589c8d-c503-4d0c-b38b-2cf8834393aa'),('10000000051',32,473356800000,'doctor1简介',4001,'10000000051',101,'123456','/img/code.png','doctor1',60001,'6e589c8d-c503-4d0c-b38b-2cf8834393aa'),('10000000052',32,476035200000,'doctor2简介',4000,'10000000052',201,'123456','/img/code.png','doctor2',60000,'6e589c8d-c503-4d0c-b38b-2cf8834393aa'),('10000000053',32,478454400000,'doctor3简介',4001,'10000000053',301,'123456','/img/code.png','doctor3',60001,'6e589c8d-c503-4d0c-b38b-2cf8834393aa'),('10000000054',32,481132800000,'doctor4简介',4000,'10000000054',401,'123456','/img/code.png','doctor4',60000,'6e589c8d-c503-4d0c-b38b-2cf8834393aa'),('10000000060',31,502214400000,'doctor0简介',4000,'10000000060',1,'123456','/img/code.png','doctor0',60000,'312d1da9-4202-4456-a3fa-74b7c8684d5b'),('10000000061',31,504892800000,'doctor1简介',4001,'10000000061',101,'123456','/img/code.png','doctor1',60001,'312d1da9-4202-4456-a3fa-74b7c8684d5b'),('10000000062',31,507571200000,'doctor2简介',4000,'10000000062',201,'123456','/img/code.png','doctor2',60000,'312d1da9-4202-4456-a3fa-74b7c8684d5b'),('10000000063',31,509990400000,'doctor3简介',4001,'10000000063',301,'123456','/img/code.png','doctor3',60001,'312d1da9-4202-4456-a3fa-74b7c8684d5b'),('10000000064',31,512668800000,'doctor4简介',4000,'10000000064',401,'123456','/img/code.png','doctor4',60000,'312d1da9-4202-4456-a3fa-74b7c8684d5b'),('10000000070',30,533750400000,'doctor0简介',4000,'10000000070',1,'123456','/img/code.png','doctor0',60000,'3f74c186-34c9-4252-a1bf-edbea9ffdd46'),('10000000071',30,536428800000,'doctor1简介',4001,'10000000071',101,'123456','/img/code.png','doctor1',60001,'3f74c186-34c9-4252-a1bf-edbea9ffdd46'),('10000000072',30,539107200000,'doctor2简介',4000,'10000000072',201,'123456','/img/code.png','doctor2',60000,'3f74c186-34c9-4252-a1bf-edbea9ffdd46'),('10000000073',30,541526400000,'doctor3简介',4001,'10000000073',301,'123456','/img/code.png','doctor3',60001,'3f74c186-34c9-4252-a1bf-edbea9ffdd46'),('10000000074',30,544204800000,'doctor4简介',4000,'10000000074',401,'123456','/img/code.png','doctor4',60000,'3f74c186-34c9-4252-a1bf-edbea9ffdd46'),('10000000080',29,565286400000,'doctor0简介',4000,'10000000080',1,'123456','/img/code.png','doctor0',60000,'d59588ac-7e60-4f5e-9b36-aace9cdb7dba'),('10000000081',29,567964800000,'doctor1简介',4001,'10000000081',101,'123456','/img/code.png','doctor1',60001,'d59588ac-7e60-4f5e-9b36-aace9cdb7dba'),('10000000082',29,570643200000,'doctor2简介',4000,'10000000082',201,'123456','/img/code.png','doctor2',60000,'d59588ac-7e60-4f5e-9b36-aace9cdb7dba'),('10000000083',29,573148800000,'doctor3简介',4001,'10000000083',301,'123456','/img/code.png','doctor3',60001,'d59588ac-7e60-4f5e-9b36-aace9cdb7dba'),('10000000084',29,575827200000,'doctor4简介',4000,'10000000084',401,'123456','/img/code.png','doctor4',60000,'d59588ac-7e60-4f5e-9b36-aace9cdb7dba'),('10000000090',28,596908800000,'doctor0简介',4000,'10000000090',1,'123456','/img/code.png','doctor0',60000,'3cfcd401-7064-4456-abaa-8c882ec30e70'),('10000000091',28,599587200000,'doctor1简介',4001,'10000000091',101,'123456','/img/code.png','doctor1',60001,'3cfcd401-7064-4456-abaa-8c882ec30e70'),('10000000092',28,602265600000,'doctor2简介',4000,'10000000092',201,'123456','/img/code.png','doctor2',60000,'3cfcd401-7064-4456-abaa-8c882ec30e70'),('10000000093',28,604684800000,'doctor3简介',4001,'10000000093',301,'123456','/img/code.png','doctor3',60001,'3cfcd401-7064-4456-abaa-8c882ec30e70'),('10000000094',28,607363200000,'doctor4简介',4000,'10000000094',401,'123456','/img/code.png','doctor4',60000,'3cfcd401-7064-4456-abaa-8c882ec30e70');
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor_schedule`
--

DROP TABLE IF EXISTS `doctor_schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doctor_schedule` (
  `doctor_schedule_id` varchar(255) NOT NULL,
  `max_appointment_count` int(11) NOT NULL,
  `schedule_date` bigint(20) NOT NULL,
  `status` int(11) NOT NULL,
  `doctor_id` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`doctor_schedule_id`),
  KEY `FKrresxag4ex638q3fincrya0wr` (`doctor_id`),
  CONSTRAINT `FKrresxag4ex638q3fincrya0wr` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`doctor_account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor_schedule`
--

LOCK TABLES `doctor_schedule` WRITE;
/*!40000 ALTER TABLE `doctor_schedule` DISABLE KEYS */;
INSERT INTO `doctor_schedule` VALUES ('000bacf1-a6fe-4e7d-b47d-9beb2c73e895',30,1597852800095,3001,'10000000033'),('043915ae-eb22-436e-b723-c07245c1e015',30,1600704000100,3001,'10000000034'),('045cf370-1f01-4377-9d6b-e14943e4193f',30,1600617600100,3001,'10000000034'),('07d565a6-4420-4bc7-9878-73096b9e884e',30,1726934400104,3001,'10000000074'),('0952a59a-c8e5-4010-9240-e0431829ff98',30,1747843200104,3001,'10000000080'),('0ae22a47-63b0-497c-89d3-a648c15215dd',30,1624204800100,3001,'10000000041'),('0c94e983-9379-414a-bd50-ba6835693820',30,1621612800100,3001,'10000000040'),('0f0dedbc-7166-4e3c-94d7-45b67b0ff465',30,1561046400090,3001,'10000000021'),('124604eb-4ffd-456f-994c-939bd4054475',30,1505836800084,3001,'10000000004'),('12a67f92-7e7e-47c9-a7e9-23b278701afa',30,1595174400095,3001,'10000000032'),('139ce65b-8ba7-44eb-bf37-893ca6e547af',30,1592668800094,3001,'10000000031'),('14ed864c-7f45-4a5d-b1a2-d38c15b04382',30,1747756800104,3001,'10000000080'),('19102801-dd08-47cd-8493-0ba2f9377a7c',30,1790006400106,3001,'10000000094'),('1960ce38-b86c-4468-8bcf-418899ca13ca',30,1598025600095,3001,'10000000033'),('1c3a1cfe-8b34-4856-8729-83f5946b810a',30,1566230400093,3001,'10000000023'),('21a684dc-ffe2-495f-8f23-028f6109d913',30,1560960000090,3001,'10000000021'),('2220a618-5dee-4913-b0fb-be9a03a00d70',30,1653148800101,3001,'10000000050'),('24596597-9de6-43a6-9d50-e49a166f867b',30,1532188800088,3001,'10000000012'),('2686b85f-ae1e-4296-a7bc-003e86aed3fe',30,1695139200103,3001,'10000000064'),('28bf487b-b7a9-4652-99a9-c3a308de5f30',30,1624118400100,3001,'10000000041'),('2cb931e9-8e8d-4c0d-90fc-148877d9a313',30,1663603200102,3001,'10000000054'),('2d6759b0-1ebd-4734-9ae8-882b17403ef3',30,1784476800106,3001,'10000000092'),('2df51d3c-eec2-4e18-9411-c9807333c377',30,1718985600103,3001,'10000000071'),('300d7c49-32fe-4e6e-9259-7117b58ecb8f',30,1595347200095,3001,'10000000032'),('3217c5a7-5099-4952-9c97-bf2992219526',30,1789833600106,3001,'10000000094'),('32ea6a9f-aa6f-4454-94b9-c4a65fc83b7b',30,1721491200104,3001,'10000000072'),('34173f14-38af-46a5-ac2a-bfdc93afc8b1',30,1784563200106,3001,'10000000092'),('34c241fd-0041-4797-a025-b7ec061a981d',30,1695225600103,3001,'10000000064'),('3513742b-2814-43e1-8869-9b30e4331be0',30,1779292800105,3001,'10000000090'),('3582a43c-87e5-4d4e-99d1-b76f09b7cbfd',30,1629388800101,3001,'10000000043'),('36751cc3-12b6-42f0-b1e8-e9b075867a4f',30,1534694400089,3001,'10000000013'),('38b863a2-069e-4806-8b0f-1d6bfd68aa86',30,1495209600080,3001,'10000000000'),('3986221a-c10b-4890-8e3f-87f8f3986c12',30,1529424000087,3001,'10000000011'),('3a7c81d4-1aa0-4ef4-b1e2-6bd0aef2e839',30,1534867200089,3001,'10000000013'),('3d7fd134-a9a0-4eb0-8976-1d842211e441',30,1568908800093,3001,'10000000024'),('409b9905-3d28-4c1c-ac2a-78f7f694962c',30,1721404800104,3001,'10000000072'),('41442ba6-0a95-4dae-9c5b-13a2720603a4',30,1753113600105,3001,'10000000082'),('42455355-3e01-4375-b55a-074d4022dbde',30,1503244800083,3001,'10000000003'),('4324dfdd-889e-47e3-bb58-6aa75da73f00',30,1758384000105,3001,'10000000084'),('4515e6bc-897d-4c44-817f-58275aaac579',30,1558281600090,3001,'10000000020'),('47aeb72d-4b6c-44cc-8221-d2d3020fae92',30,1500652800083,3001,'10000000002'),('4dfd571f-c4b6-4fa5-a990-5444064a5bb6',30,1563724800091,3001,'10000000022'),('4f6c0a67-827b-4c8c-820d-4fe286acc089',30,1787328000106,3001,'10000000093'),('501522fa-b025-4276-8c3f-ee0b600ab676',30,1716134400103,3001,'10000000070'),('50ec274b-3785-49ec-9d84-0cd1de4cc9a8',30,1716307200103,3001,'10000000070'),('5434d9ba-e7e1-4bc1-b2d8-bc25d23dca0c',30,1505923200084,3001,'10000000004'),('54c85c73-15bb-4cf6-8fd3-f8f0cdddcdd6',30,1787241600106,3001,'10000000093'),('571751e7-df74-43c5-8a38-b58d0f574086',30,1689868800103,3001,'10000000062'),('57554a9c-294f-4457-8e15-798ca29d26f9',30,1687363200102,3001,'10000000061'),('5796f328-adce-411d-bbf9-dce7533ce4eb',30,1724169600104,3001,'10000000073'),('58d40568-8e71-495e-b62c-91b7e1de7d41',30,1789920000106,3001,'10000000094'),('59860f83-8236-41d8-a6f6-5f7457f123ca',30,1537372800089,3001,'10000000014'),('5a971118-873c-4dc3-be45-a7ac56bdbe67',30,1755705600105,3001,'10000000083'),('5ad27f42-f1c2-4464-8925-4673a77c46aa',30,1655740800101,3001,'10000000051'),('5c7587b2-0fea-49de-a5f6-259bd0aafa17',30,1558454400090,3001,'10000000020'),('5ee50869-f9a2-41ab-af57-27760ae1c0d7',30,1726761600104,3001,'10000000074'),('5f970a5f-9aa2-4bf8-80d3-4f4edb01d024',30,1558368000090,3001,'10000000020'),('60c582af-6d02-4cab-9581-9c1cd5c9e1ba',30,1624291200100,3001,'10000000041'),('644a1f52-5496-4c26-92e1-92788ad43289',30,1500566400083,3001,'10000000002'),('66d7ea84-c41b-4e5d-ad25-e93f7c8fe715',30,1655827200101,3001,'10000000051'),('6922d082-595c-4ede-8f6e-377f3ef55a3d',30,1653062400101,3001,'10000000050'),('6ac4be0c-f17f-4aa6-9420-a4cf37074a7c',30,1661097600102,3001,'10000000053'),('6b2497f0-5a2d-45de-a570-b0e28409380b',30,1503158400083,3001,'10000000003'),('6b34cbc9-8459-476c-b73e-d10bb077eca2',30,1684684800102,3001,'10000000060'),('6b8a8ee9-2ea4-4fcd-b3be-7357a0bc93ed',30,1600531200100,3001,'10000000034'),('6c476e8b-b62b-4b28-97e3-1f51b8400dba',30,1752940800105,3001,'10000000082'),('6fd06426-dbdb-430c-8a6b-245cd6e5c0ce',30,1495296000080,3001,'10000000000'),('6fe44cd6-0213-42e6-ad3a-fb112544b326',30,1753027200105,3001,'10000000082'),('71758622-9964-45d4-a061-b7053a491b57',30,1684598400102,3001,'10000000060'),('74b6da8c-3571-4a72-83e8-34b311020692',30,1687276800102,3001,'10000000061'),('74e67d97-4757-4827-a12e-1e4b2f52edc2',30,1663776000102,3001,'10000000054'),('7664fae9-be4d-4f81-888f-ac38c960acef',30,1663689600102,3001,'10000000054'),('78d3c83c-52ce-4720-996f-321093acb229',30,1592582400094,3001,'10000000031'),('7c7bfe52-a91e-475f-99ed-da4706eb21c8',30,1626883200100,3001,'10000000042'),('7d1b2cbc-bd99-4e01-a70a-8c052e701d41',30,1526918400087,3001,'10000000010'),('7d922f23-20ce-47ae-80f0-108788cb37b4',30,1689955200103,3001,'10000000062'),('7dd6ab34-138a-413f-9186-dda1055a757f',30,1784649600106,3001,'10000000092'),('7f9c2b02-e6fc-400b-8dbd-6578e92ab694',30,1626710400100,3001,'10000000042'),('80d3b2ac-2f15-4e66-831f-68efffad266e',30,1632153600101,3001,'10000000044'),('810070e5-741e-4f7a-b707-4d1e03ecd9f1',30,1589904000094,3001,'10000000030'),('84ec8217-f1c2-4938-85f1-b8812151ccb0',30,1721577600104,3001,'10000000072'),('85b91b5e-637b-468c-a67e-42f6c89b987f',30,1658419200101,3001,'10000000052'),('877148b9-c771-43d2-9802-66c0ca9240fd',30,1750435200104,3001,'10000000081'),('8b417d43-203d-43fb-8f84-4be6a5dbfe3f',30,1561132800090,3001,'10000000021'),('8b5c0922-2405-418b-a191-58d371d120e1',30,1497888000081,3001,'10000000001'),('8e016f97-e183-4250-a0f8-1d8529cb4ed5',30,1569081600093,3001,'10000000024'),('90dca54c-340d-4a0b-8de8-7c6529b5ba26',30,1534780800089,3001,'10000000013'),('947e07dc-e71b-4a10-8f1f-df70a6dc8872',30,1563638400091,3001,'10000000022'),('9af55b0d-d3a9-4af4-a34c-26ddf93a8d0a',30,1692633600103,3001,'10000000063'),('9d90811b-b98b-4387-a0b8-6faebcd24ad6',30,1787155200106,3001,'10000000093'),('a20a49af-4c14-4d1e-be11-cc6cb24c2b0c',30,1589990400094,3001,'10000000030'),('a3aad2da-6f81-43de-a95f-071f7c52a33a',30,1632067200101,3001,'10000000044'),('a4e38b13-b0bd-4d8d-9240-f2c6f0dc7e33',30,1632240000101,3001,'10000000044'),('ab199813-d08b-4886-84bd-14367d053684',30,1692460800103,3001,'10000000063'),('ac9a1065-6d9c-456f-b768-f8d05c79734a',30,1724083200104,3001,'10000000073'),('ac9f5571-2c60-4388-b5f4-cd34743dc4a0',30,1563552000091,3001,'10000000022'),('aef966dd-a9fc-4849-bf58-6dff8304008c',30,1750348800104,3001,'10000000081'),('b1627eb7-6646-4a70-93eb-0619e90da667',30,1758297600105,3001,'10000000084'),('b1f61f18-9067-47a0-985c-572056e996fb',30,1684512000102,3001,'10000000060'),('b5697d21-3c28-4d3b-b6ac-3dafbb8176c4',30,1655654400101,3001,'10000000051'),('b56debf0-166a-4ec4-bb13-d28ce2950b8f',30,1718812800103,3001,'10000000071'),('b5fbd2b4-b837-4a0e-92ad-903f1dfb2638',30,1495382400081,3001,'10000000000'),('b779c04d-b377-455c-9ce7-e124b8cbfc35',30,1779206400105,3001,'10000000090'),('b7e50934-f3b0-436f-8940-358c30f58574',30,1590076800094,3001,'10000000030'),('ba31b000-a0f7-4ab9-a312-65f62bef9c38',30,1529596800088,3001,'10000000011'),('bbf1893d-fea7-4bd3-b45b-ad9e43240c99',30,1537545600089,3001,'10000000014'),('bc35fc7e-36f4-480f-baaa-5a955c5e6d3c',30,1621440000100,3001,'10000000040'),('bcedeb43-d2e7-4947-b740-a76678699320',30,1537459200089,3001,'10000000014'),('c23a353d-2488-41cb-b33c-b47ba4bef688',30,1529510400088,3001,'10000000011'),('c2d2468c-9701-4d18-acbc-4ab6d09ce838',30,1781971200105,3001,'10000000091'),('c2f0630f-217c-4f77-9516-52c4477af890',30,1597939200095,3001,'10000000033'),('c5f5ce2f-6c28-4007-8984-746760e17789',30,1566316800093,3001,'10000000023'),('c6e596fb-7e39-4197-ab28-56d6ac3a8ef9',30,1747670400104,3001,'10000000080'),('c7a0d2c2-ab20-4456-8571-022e4983e9b4',30,1692547200103,3001,'10000000063'),('c7d4c1a6-7138-41a0-ae06-628a46ffc90a',30,1629561600101,3001,'10000000043'),('c7fefc1d-2405-4102-a9f6-06bf1d2fbd32',30,1782057600105,3001,'10000000091'),('cac0611b-2593-4df5-86fb-50d02523ba0a',30,1661011200102,3001,'10000000053'),('cb737caf-1f53-45d2-8748-b7cc60687beb',30,1689782400103,3001,'10000000062'),('cbfd369f-4541-41c8-8c68-4089d6c5ce15',30,1532102400088,3001,'10000000012'),('d0c849af-cdab-4894-823c-0793f875a1eb',30,1781884800105,3001,'10000000091'),('d14ee8db-38ec-407c-96c4-ae7674409f5e',30,1652976000101,3001,'10000000050'),('d3ff1458-3bd7-4631-9d0b-3463ec5f6fbb',30,1695312000103,3001,'10000000064'),('d52ee49b-6abe-46ec-9ad9-8f5d96506b80',30,1660924800102,3001,'10000000053'),('d5369484-5943-4557-8768-a3af374652a1',30,1500480000082,3001,'10000000002'),('dc06182b-ca74-48b5-a127-ebd8d918471d',30,1658246400101,3001,'10000000052'),('dccc7053-b4ed-427a-9afb-7cca26216107',30,1779379200105,3001,'10000000090'),('dd607dc3-70d8-4dd0-a15c-148dfd7e44c8',30,1726848000104,3001,'10000000074'),('deff9a08-1816-4a26-907b-1804decf83a9',30,1526745600087,3001,'10000000010'),('e0144da3-82c5-4a75-9935-51bc770da402',30,1755792000105,3001,'10000000083'),('e0a3c1b4-d144-45b0-b888-a6dfa42eec88',30,1626796800100,3001,'10000000042'),('e2591878-c7c7-4e1a-8b50-36a89ec4a23c',30,1724256000104,3001,'10000000073'),('e2a165ff-7b57-446f-a158-48909ad75e00',30,1621526400100,3001,'10000000040'),('e34b8a71-29c4-4a30-8a39-ece162b66301',30,1687190400102,3001,'10000000061'),('e3eb3053-ad2d-4cff-a95d-81c98a24c2b8',30,1592755200094,3001,'10000000031'),('e942860a-c18c-4b66-9fc3-72cc68110f18',30,1658332800101,3001,'10000000052'),('e971269f-ad0e-4634-bacd-2125de2b2e75',30,1568995200093,3001,'10000000024'),('e97fffa6-d5fc-402e-a45c-eb12e29479a7',30,1629475200101,3001,'10000000043'),('ebbfda89-4e4b-4ffb-81b5-1480406ae053',30,1526832000087,3001,'10000000010'),('ec8649ac-d656-4d1e-9571-65221bdb0624',30,1716220800103,3001,'10000000070'),('eda6b8b4-deed-4251-822b-83a945730e95',30,1595260800095,3001,'10000000032'),('f08bfd60-f3b0-425a-83c1-03d06d4479ce',30,1506009600084,3001,'10000000004'),('f22d07fd-3fb1-473b-8815-bab364ee583f',30,1503331200083,3001,'10000000003'),('f2d664ca-b4e5-465a-89f3-adbdafe47c68',30,1750521600104,3001,'10000000081'),('f45d6bb0-ca25-4df6-a6e6-92c1fc365fb7',30,1566403200093,3001,'10000000023'),('f5edca05-2bed-4376-a256-f69d24852629',30,1498060800081,3001,'10000000001'),('fcfaddb2-15b4-415e-ac1d-32a4bcd541c6',30,1758470400105,3001,'10000000084'),('fdcf57dc-2e70-4584-ad1e-4ff38b17d6f6',30,1497974400081,3001,'10000000001'),('fe8f5964-c1ed-48bd-a485-5aab0f433428',30,1718899200103,3001,'10000000071'),('fee97170-3b98-4643-b3c6-efa6c8a89e06',30,1755619200105,3001,'10000000083'),('ff3ff205-3abe-46ba-a6c6-19052a39e72f',30,1532016000088,3001,'10000000012');
/*!40000 ALTER TABLE `doctor_schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hospital`
--

DROP TABLE IF EXISTS `hospital`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hospital` (
  `hospital_id` varchar(255) NOT NULL,
  `create_date` bigint(20) NOT NULL,
  `hospital_name` varchar(255) NOT NULL,
  `img` varchar(255) DEFAULT NULL,
  `info` varchar(255) NOT NULL,
  `latitude` float DEFAULT NULL,
  `level` int(11) NOT NULL,
  `loc` varchar(255) DEFAULT NULL,
  `longitude` float DEFAULT NULL,
  PRIMARY KEY (`hospital_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospital`
--

LOCK TABLES `hospital` WRITE;
/*!40000 ALTER TABLE `hospital` DISABLE KEYS */;
INSERT INTO `hospital` VALUES ('156b1ab2-afeb-4d6f-997d-c99385e67d1d',1287504000000,'绵阳精神病院',NULL,'hello word',30.123,5008,'四川成都',10.123);
/*!40000 ALTER TABLE `hospital` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient` (
  `patient_account` varchar(11) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `birth_day` bigint(20) DEFAULT NULL,
  `mobile_phone` varchar(11) NOT NULL,
  `password` varchar(255) NOT NULL,
  `portraint` varchar(255) DEFAULT NULL,
  `real_name` varchar(255) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  PRIMARY KEY (`patient_account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES ('18380586504',21,812131200000,'18380586504','123456','/img/code.png','张应龙',60000);
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-19 15:06:24
