/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.7.20-log : Database - nn_nst_2018
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`nn_nst_2018` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `nn_nst_2018`;

/*Table structure for table `flyway_schema_history` */

DROP TABLE IF EXISTS `flyway_schema_history`;

CREATE TABLE `flyway_schema_history` (
  `installed_rank` int(11) NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int(11) DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int(11) NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `flyway_schema_history` */

insert  into `flyway_schema_history`(`installed_rank`,`version`,`description`,`type`,`script`,`checksum`,`installed_by`,`installed_on`,`execution_time`,`success`) values (1,'1','rola tabela','SQL','V1__rola_tabela.sql',-1223355731,'root','2018-06-06 12:40:56',304,1),(2,'2','rola add','SQL','V2__rola_add.sql',-2001267897,'root','2018-06-06 12:40:56',6,1),(3,'3','tajnopitanje tabela','SQL','V3__tajnopitanje_tabela.sql',2044426434,'root','2018-06-06 12:40:56',351,1),(4,'4','tajnopitanje add','SQL','V4__tajnopitanje_add.sql',1754794202,'root','2018-06-06 12:40:56',6,1),(5,'5','korisnik tabela','SQL','V5__korisnik_tabela.sql',-1643435886,'root','2018-06-06 12:40:57',405,1),(6,'6','korisnik add','SQL','V6__korisnik_add.sql',-1145544909,'root','2018-06-06 12:40:57',80,1),(7,'7','profil tabela','SQL','V7__profil_tabela.sql',-996853395,'root','2018-06-06 12:40:57',308,1),(8,'8','profil add','SQL','V8__profil_add.sql',-1326379038,'root','2018-06-06 12:40:57',7,1),(9,'9','segment tabela','SQL','V9__segment_tabela.sql',277285667,'root','2018-06-06 12:40:58',433,1),(10,'10','segment add','SQL','V10__segment_add.sql',-1790564593,'root','2018-06-06 12:40:58',6,1),(11,'11','sifarnik tabela','SQL','V11__sifarnik_tabela.sql',1790760999,'root','2018-06-06 12:40:58',279,1),(12,'12','sifarnik add','SQL','V12__sifarnik_add.sql',1146665450,'root','2018-06-06 12:40:58',7,1),(13,'13','stavka tabela','SQL','V13__stavka_tabela.sql',2050136108,'root','2018-06-06 12:40:59',350,1),(14,'14','stavka add','SQL','V14__stavka_add.sql',1711447131,'root','2018-06-06 12:40:59',7,1),(15,'15','notifikacija tabela','SQL','V15__notifikacija_tabela.sql',-1383768041,'root','2018-06-06 12:40:59',244,1),(16,'16','notifikacija add','SQL','V16__notifikacija_add.sql',1763705141,'root','2018-06-06 12:40:59',6,1);

/*Table structure for table `korisnik` */

DROP TABLE IF EXISTS `korisnik`;

CREATE TABLE `korisnik` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(255) NOT NULL,
  `prezime` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `lock` bit(1) DEFAULT b'0',
  `qstnId` int(11) NOT NULL,
  `qstnAns` varchar(255) NOT NULL,
  `rolaId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_korisnik_rola` (`rolaId`),
  KEY `FK_korisnik_SecretQstn` (`qstnId`),
  CONSTRAINT `FK_korisnik_SecretQstn` FOREIGN KEY (`qstnId`) REFERENCES `secretqstn` (`id`),
  CONSTRAINT `FK_korisnik_rola` FOREIGN KEY (`rolaId`) REFERENCES `rola` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `korisnik` */

insert  into `korisnik`(`id`,`ime`,`prezime`,`username`,`password`,`lock`,`qstnId`,`qstnAns`,`rolaId`) values (1,'Nikola','Solunac','soki','123','\0',1,'Arsenal',1),(2,'Nemanja','Boskovic','bosko','1234567891','\0',1,'asd',2),(3,'Dusko','Leontijevic','duki','123456789','\0',1,'qwe',2);

/*Table structure for table `notifikacija` */

DROP TABLE IF EXISTS `notifikacija`;

CREATE TABLE `notifikacija` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `profil` int(11) NOT NULL,
  `valsnikProfila` int(11) NOT NULL,
  `vlasnikZahteva` int(11) NOT NULL,
  `flagPrikazana` bit(1) DEFAULT b'0',
  `flagOdobreno` bit(1) DEFAULT b'0',
  `TimeStamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `notifikacija` */

insert  into `notifikacija`(`id`,`profil`,`valsnikProfila`,`vlasnikZahteva`,`flagPrikazana`,`flagOdobreno`,`TimeStamp`) values (2,5,2,1,'\0','\0','2018-06-06 12:40:59');

/*Table structure for table `profil` */

DROP TABLE IF EXISTS `profil`;

CREATE TABLE `profil` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `korisnikId` int(11) NOT NULL,
  `datum` varchar(10) NOT NULL,
  `naziv` varchar(10) DEFAULT NULL,
  `opis` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_profil_korisnik` (`korisnikId`),
  CONSTRAINT `FK_profil_korisnik` FOREIGN KEY (`korisnikId`) REFERENCES `korisnik` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `profil` */

insert  into `profil`(`id`,`korisnikId`,`datum`,`naziv`,`opis`) values (2,3,'2018.06.06','test','test');

/*Table structure for table `rola` */

DROP TABLE IF EXISTS `rola`;

CREATE TABLE `rola` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `rola` */

insert  into `rola`(`id`,`naziv`) values (1,'ROLE_ADMIN'),(2,'ROLE_SEEKER');

/*Table structure for table `secretqstn` */

DROP TABLE IF EXISTS `secretqstn`;

CREATE TABLE `secretqstn` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `opis` varchar(255) NOT NULL,
  `opis_US` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `secretqstn` */

insert  into `secretqstn`(`id`,`opis`,`opis_US`) values (1,'Koje je ime Vaseg omiljenog fudbalskog kluba?','What\'s your favourite football team?'),(2,'U kom gradu ste rodjeni?','In which city were you born?'),(3,'Koja je Vasa omiljena boja?','Which is your favourite color ?');

/*Table structure for table `segment` */

DROP TABLE IF EXISTS `segment`;

CREATE TABLE `segment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `profilId` int(11) NOT NULL,
  `heading` varchar(255) DEFAULT NULL,
  `opis` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_segment_profil` (`profilId`),
  CONSTRAINT `FK_segment_profil` FOREIGN KEY (`profilId`) REFERENCES `profil` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `segment` */

insert  into `segment`(`id`,`profilId`,`heading`,`opis`) values (2,2,'Sifarnik{id=1, naziv=O sebi}','test');

/*Table structure for table `sifarnik` */

DROP TABLE IF EXISTS `sifarnik`;

CREATE TABLE `sifarnik` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `sifarnik` */

insert  into `sifarnik`(`id`,`naziv`) values (1,'O sebi'),(2,'Radno iskustvo'),(3,'Edukacija'),(4,'Dodatne aktivnosti'),(5,'Jezici'),(6,'Interesovanja'),(7,'Test'),(13,'asd');

/*Table structure for table `stavka` */

DROP TABLE IF EXISTS `stavka`;

CREATE TABLE `stavka` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `segmentId` int(11) NOT NULL,
  `datumOd` varchar(10) NOT NULL,
  `datumDo` varchar(10) DEFAULT NULL,
  `heading1` varchar(255) DEFAULT NULL,
  `heading2` varchar(255) DEFAULT NULL,
  `opis` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_stavka_segment` (`segmentId`),
  CONSTRAINT `FK_stavka_segment` FOREIGN KEY (`segmentId`) REFERENCES `segment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `stavka` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
