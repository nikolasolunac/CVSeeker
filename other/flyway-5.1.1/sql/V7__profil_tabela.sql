/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  SOLUNAC
 * Created: June 5, 2018
 */

CREATE TABLE `profil` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `korisnikId` INT(11) NOT NULL,
  `datum` VARCHAR(10) NOT NULL,
  `naziv` VARCHAR(10) DEFAULT NULL,
  `opis` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_profil_korisnik` (`korisnikId`),
  CONSTRAINT `FK_profil_korisnik` FOREIGN KEY (`korisnikId`) REFERENCES `korisnik` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;