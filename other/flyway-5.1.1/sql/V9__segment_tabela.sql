/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  SOLUNAC
 * Created: June 5, 2018
 */
CREATE TABLE `segment` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `profilId` INT(11) NOT NULL,
  `heading` VARCHAR(255) DEFAULT NULL,
  `opis` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_segment_profil` (`profilId`),
  CONSTRAINT `FK_segment_profil` FOREIGN KEY (`profilId`) REFERENCES `profil` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
