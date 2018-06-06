/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  P
 * Created: May 20, 2018
 */

CREATE TABLE `notifikacija`(
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`profil` INT(11) NOT NULL,
	`valsnikProfila` INT(11) NOT NULL,
	`vlasnikZahteva` INT(11) NOT NULL,
	`flagPrikazana` BIT DEFAULT 0,
	`flagOdobreno` BIT DEFAULT 0,
	`TimeStamp` TIMESTAMP,
	PRIMARY KEY (`id`)
)ENGINE=INNODB AUTO_INCREMENT = 2 DEFAULT CHARSET=utf8;