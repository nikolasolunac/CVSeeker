/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  P
 * Created: May 20, 2018
 */

CREATE TABLE `korisnik` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `ime` VARCHAR(255) NOT NULL,
  `prezime` VARCHAR(255) NOT NULL,
  `username` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `lock` BIT(1) DEFAULT b'0',
  `qstnId` INT(11) NOT NULL,
  `qstnAns` VARCHAR(255) NOT NULL,
  `rolaId` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_korisnik_rola` (`rolaId`),
  KEY `FK_korisnik_SecretQstn` (`qstnId`),
  CONSTRAINT `FK_korisnik_rola` FOREIGN KEY (`rolaId`) REFERENCES `rola` (`id`),
  CONSTRAINT `FK_korisnik_SecretQstn` FOREIGN KEY (`qstnId`) REFERENCES `secretqstn` (`id`)
) ENGINE=INNODB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;