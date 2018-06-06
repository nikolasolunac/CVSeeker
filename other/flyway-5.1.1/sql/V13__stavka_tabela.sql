/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  P
 * Created: May 20, 2018
 */

CREATE TABLE `stavka` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `segmentId` INT(11) NOT NULL,
  `datumOd` VARCHAR(10) NOT NULL,
  `datumDo` VARCHAR(10) DEFAULT NULL,
  `heading1` VARCHAR(255) DEFAULT NULL,
  `heading2` VARCHAR(255) DEFAULT NULL,
  `opis` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_stavka_segment` (`segmentId`),
  CONSTRAINT `FK_stavka_segment` FOREIGN KEY (`segmentId`) REFERENCES `segment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;