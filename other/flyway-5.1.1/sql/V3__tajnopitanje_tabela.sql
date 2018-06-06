/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  SOLUNAC
 * Created: June 5, 2018
 */

CREATE TABLE `secretqstn` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `opis` VARCHAR(255) NOT NULL,
  `opis_US` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;