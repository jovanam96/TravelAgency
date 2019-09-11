/*
SQLyog Community v12.5.0 (64 bit)
MySQL - 10.1.28-MariaDB : Database - travel_agency_test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`travel_agency_test` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `travel_agency_test`;

/*Table structure for table `city` */

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `city_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `state_state_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`city_id`),
  KEY `FKkp1bi67hevapdy6800ilvi7t9` (`state_state_id`),
  CONSTRAINT `FKkp1bi67hevapdy6800ilvi7t9` FOREIGN KEY (`state_state_id`) REFERENCES `state` (`state_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `city` */

insert  into `city`(`city_id`,`name`,`state_state_id`) values 
(1,'Barcelona',1),
(2,'Paris',2),
(3,'Madrid',1),
(4,'Rome',3);

/*Table structure for table `confirmation_token` */

DROP TABLE IF EXISTS `confirmation_token`;

CREATE TABLE `confirmation_token` (
  `token_id` int(11) NOT NULL AUTO_INCREMENT,
  `confirmation_token` varchar(255) DEFAULT NULL,
  `creation_date` date DEFAULT NULL,
  `user_profile_user_profile_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`token_id`),
  KEY `FKiun6etmiyteokvtgodb8n87w2` (`user_profile_user_profile_id`),
  CONSTRAINT `FKiun6etmiyteokvtgodb8n87w2` FOREIGN KEY (`user_profile_user_profile_id`) REFERENCES `user_profile` (`user_profile_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

/*Data for the table `confirmation_token` */

insert  into `confirmation_token`(`token_id`,`confirmation_token`,`creation_date`,`user_profile_user_profile_id`) values 
(24,'9fc51b7e-3569-4dd5-9d36-fd7735c5eccd','2019-08-30',41),
(25,'3696e6cc-f452-4750-a470-4f51008f1be3','2019-08-30',42),
(27,'20bcfbdd-d189-476f-9eb5-7c91b2c601a2','2019-09-10',48);

/*Table structure for table `hotel` */

DROP TABLE IF EXISTS `hotel`;

CREATE TABLE `hotel` (
  `hotel_id` int(11) NOT NULL AUTO_INCREMENT,
  `adress` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `city_city_id` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`hotel_id`),
  KEY `FKac12pwcjf1qwfn7g1ghyrsg0h` (`city_city_id`),
  CONSTRAINT `FKac12pwcjf1qwfn7g1ghyrsg0h` FOREIGN KEY (`city_city_id`) REFERENCES `city` (`city_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

/*Data for the table `hotel` */

insert  into `hotel`(`hotel_id`,`adress`,`email`,`name`,`phone_number`,`city_city_id`,`description`,`file_name`) values 
(2,'11 rue des Acacias','acaciasetoile@gmail.com','Acacias Etoile','+336532656',2,'This is our guests\' favorite part of Paris, according to independent reviews. In this area you can shop \'til you drop for popular brands like Cartier, H&M, Chanel, Burberry, Louis Vuitton. ','Acacias_Etoile_1567180310628.jpg'),
(3,'Sant Marti','cataloniaatenas@gmail.com','Catalonia Atenas','+34601558424',1,'Located on Barcelona’s Passeig de Gràcia, 500 m from Plaça de Catalunya. This well-equipped hostel offers breakfast, free WiFi in common areas and a guest kitchen.','Catalonia_Atenas_1566830579270.jpg'),
(9,'Chamartin 55','hotelviacastellana@gmail.com','Hotel Via Castellana','+34641312',3,'Located a 5-minute drive from Madrid Exhibition Centre IFEMA and a 8-minute drive from Barajas Airport, Hotel Hotel Via Castellana is set in attractive gardens, and features a seasonal outdoor swimming pool.','Hotel_Via_Castellana_1566830784550.jpg'),
(21,'97 Avenue des Ternes ','laviladesternes@gmail.com','La Villa des Ternes','+3356314655',2,'Located 10-minutes from Porte Maillot Congress Centre and the Arc de Triomphe. It offers air-conditioned rooms overlooking the patio.','La_Villa_des_Ternes_1566847546160.jpg'),
(23,'Navona','soleroma@gmail.com','Hotel Sole Roma','+397486322',4,'Set a 10-minute walk from the Vatican Museums in Rome, offers free WiFi throughout and air-conditioned rooms. St. Peter\'s Basilica and St Peter\'s Square are located 1.5 km away.','Hotel_Sole_Roma_1566847571929.jpg'),
(24,'Castello 30','metropole@gmail.com','Hotel Metropole','+39684135',4,' Couples in particular like the location – they rated it 8.5 for a two-person trip.\n\nThis property is also rated for the best value in Rome! Guests are getting more for their money when compared to other properties in this city. ','Hotel_Metropole_1566844616526.jpg'),
(29,'Torrent de l\'Olla Torrent de l\'Olla 28','bed&bcn@gmail.com','Bed&BCN Gracia II','+349865235',1,'In the Gràcia district of Barcelona, close to La Pedrera, Bed&BCN Gracia II features a terrace, free WiFi and a washing machine. Guests staying at this apartment have access to a balcony.','Bed&BCN_Gracia_II_1567257428300.jpg'),
(30,'La Rambla','hotel1@gmail.com','Hotel Barcelona','+348963265',1,'Description','La_Villa_des_Ternes_1568050469122.jpg');

/*Table structure for table `offer` */

DROP TABLE IF EXISTS `offer`;

CREATE TABLE `offer` (
  `offer_id` int(11) NOT NULL AUTO_INCREMENT,
  `date_from` date DEFAULT NULL,
  `date_to` date DEFAULT NULL,
  `city_city_id` int(11) DEFAULT NULL,
  `hotel_hotel_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`offer_id`),
  KEY `FKccasrsyxv2x8ogq91sea3txro` (`city_city_id`),
  KEY `FKb19cqs504mcuj2ycr7c0tthrt` (`hotel_hotel_id`),
  CONSTRAINT `FKb19cqs504mcuj2ycr7c0tthrt` FOREIGN KEY (`hotel_hotel_id`) REFERENCES `hotel` (`hotel_id`),
  CONSTRAINT `FKccasrsyxv2x8ogq91sea3txro` FOREIGN KEY (`city_city_id`) REFERENCES `city` (`city_id`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=latin1;

/*Data for the table `offer` */

insert  into `offer`(`offer_id`,`date_from`,`date_to`,`city_city_id`,`hotel_hotel_id`) values 
(73,'2019-09-03','2019-09-13',1,3),
(74,'2019-09-14','2019-09-24',1,3),
(75,'2019-09-02','2019-09-12',1,29),
(76,'2019-09-13','2019-09-23',1,29),
(77,'2019-09-11','2019-09-21',1,30),
(78,'2019-09-04','2019-09-05',2,2),
(79,'2019-09-04','2019-09-14',2,21);

/*Table structure for table `offer_item` */

DROP TABLE IF EXISTS `offer_item`;

CREATE TABLE `offer_item` (
  `number` int(11) NOT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  `offer_offer_id` int(11) NOT NULL,
  `room_type_rooom_type_id` int(11) DEFAULT NULL,
  `capacity` int(11) NOT NULL,
  PRIMARY KEY (`number`,`offer_offer_id`),
  KEY `FKadftv6nr1ray2smch2j27b1py` (`offer_offer_id`),
  KEY `FKkger36bf1pwf0sxu9q6ssowem` (`room_type_rooom_type_id`),
  CONSTRAINT `FKadftv6nr1ray2smch2j27b1py` FOREIGN KEY (`offer_offer_id`) REFERENCES `offer` (`offer_id`),
  CONSTRAINT `FKkger36bf1pwf0sxu9q6ssowem` FOREIGN KEY (`room_type_rooom_type_id`) REFERENCES `room_type` (`rooom_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `offer_item` */

insert  into `offer_item`(`number`,`price`,`offer_offer_id`,`room_type_rooom_type_id`,`capacity`) values 
(1,400.00,73,5,5),
(1,350.00,74,5,3),
(1,200.00,75,4,10),
(1,140.00,76,4,2),
(1,200.00,77,4,2),
(1,400.00,79,5,5),
(2,125.00,73,3,12),
(2,150.00,74,4,5),
(2,400.00,75,5,3),
(2,350.00,76,5,8),
(2,100.00,77,3,5),
(2,120.00,79,3,2),
(3,500.00,75,6,5),
(3,300.00,77,2,3);

/*Table structure for table `person` */

DROP TABLE IF EXISTS `person`;

CREATE TABLE `person` (
  `type` varchar(31) NOT NULL,
  `person_id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `jmbg` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `hire_date` date DEFAULT NULL,
  `work_book_number` int(11) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

/*Data for the table `person` */

insert  into `person`(`type`,`person_id`,`email`,`first_name`,`jmbg`,`last_name`,`hire_date`,`work_book_number`,`phone_number`) values 
('client',1,'jovana@gmail.com','Jovana','2707996123456','Mitrovic',NULL,NULL,'123456'),
('employee',2,'admin@gmail.com','Admin','321','Admin','2019-07-01',6323,NULL),
('client',12,'jovana_996@yahoo.com','Anastasija','7894561233216','Mitrovic',NULL,NULL,'336532656'),
('client',27,'jovana_996@yahoo.com','Anastasija','7894561233216','Mitrovic',NULL,NULL,'336532656'),
('client',30,'jovana_996@yahoo.com','ana','2707996123456','colovic',NULL,NULL,'23456');

/*Table structure for table `reservation` */

DROP TABLE IF EXISTS `reservation`;

CREATE TABLE `reservation` (
  `reservation_id` int(11) NOT NULL AUTO_INCREMENT,
  `creation_date` date DEFAULT NULL,
  `client_person_id` int(11) DEFAULT NULL,
  `offer_item_number` int(11) DEFAULT NULL,
  `offer_item_offer_offer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`reservation_id`),
  KEY `FK3e36yw36orivkm7ifhp0mly0p` (`client_person_id`),
  KEY `FKioeph2g989hx151n0ehbockck` (`offer_item_number`,`offer_item_offer_offer_id`),
  CONSTRAINT `FK3e36yw36orivkm7ifhp0mly0p` FOREIGN KEY (`client_person_id`) REFERENCES `person` (`person_id`),
  CONSTRAINT `FKioeph2g989hx151n0ehbockck` FOREIGN KEY (`offer_item_number`, `offer_item_offer_offer_id`) REFERENCES `offer_item` (`number`, `offer_offer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

/*Data for the table `reservation` */

insert  into `reservation`(`reservation_id`,`creation_date`,`client_person_id`,`offer_item_number`,`offer_item_offer_offer_id`) values 
(27,'2019-09-10',1,1,73);

/*Table structure for table `room_type` */

DROP TABLE IF EXISTS `room_type`;

CREATE TABLE `room_type` (
  `rooom_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rooom_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `room_type` */

insert  into `room_type`(`rooom_type_id`,`name`) values 
(1,'Twin Room'),
(2,'Triple Room'),
(3,'Single Room'),
(4,'Double Room'),
(5,'Quadruple Room'),
(6,'Suite');

/*Table structure for table `state` */

DROP TABLE IF EXISTS `state`;

CREATE TABLE `state` (
  `state_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`state_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `state` */

insert  into `state`(`state_id`,`name`) values 
(1,'Spain'),
(2,'France'),
(3,'Italy');

/*Table structure for table `user_profile` */

DROP TABLE IF EXISTS `user_profile`;

CREATE TABLE `user_profile` (
  `user_profile_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` int(11) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `roles` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `person_person_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_profile_id`),
  UNIQUE KEY `UK_9551piq2wp9kh4kket0wr65vt` (`username`),
  KEY `FKmxbexxc8y5vo93lrxflusy57b` (`person_person_id`),
  CONSTRAINT `FKmxbexxc8y5vo93lrxflusy57b` FOREIGN KEY (`person_person_id`) REFERENCES `person` (`person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=latin1;

/*Data for the table `user_profile` */

insert  into `user_profile`(`user_profile_id`,`active`,`password`,`roles`,`username`,`person_person_id`) values 
(41,1,'$2a$10$hgkf.mVaJg3bR8CilVQ5Z.OEQ3VEec0fAyCNg3MjN2RXPZcNh/A4e','CLIENT','anastasija',12),
(42,1,'$2a$10$VlaGj7COhy6Q.7aixNQTu.EtJXFLSkhb6eJYB4FkZhwS62ZN8y/ai','CLIENT','tralala',27),
(43,1,'$2a$10$fzREXCA7SwFMPpc7KgLRGubKmah0yJ5dsa1JhV1WB2rUG2emTdT7e','CLIENT','client',1),
(44,1,'$2a$10$rlhzkwQY6ChR5UEgMhMDHuJU1yLvtjb.iSgUSNBkxxZ4ORqvARsN.','ADMIN','admin',2),
(48,1,'$2a$10$mMCZOzcV9K/FUEBAfLq3HOAreNC7Yr5wq9msjRt05bGzImwXkPHsC','CLIENT','anac',30);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
