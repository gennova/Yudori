/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.6.21 : Database - yudori
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`yudori` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `yudori`;

/*Table structure for table `barang` */

DROP TABLE IF EXISTS `barang`;

CREATE TABLE `barang` (
  `idbarang` int(3) NOT NULL AUTO_INCREMENT,
  `namabarang` varchar(100) NOT NULL,
  `hargatunai` int(15) NOT NULL,
  `hargadrop` int(15) NOT NULL,
  `UM` int(10) DEFAULT NULL,
  `hargapromositunai` int(10) NOT NULL,
  `sisa1` int(3) DEFAULT NULL,
  `sisa2` int(10) DEFAULT NULL,
  `transaction` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idbarang`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `barang` */

insert  into `barang`(`idbarang`,`namabarang`,`hargatunai`,`hargadrop`,`UM`,`hargapromositunai`,`sisa1`,`sisa2`,`transaction`,`time`) values (1,'Yudori Gridle 2 in 1',490000,553000,79000,460000,6,79000,'2016-01-26 23:27:56',NULL),(2,'Yudori Wok Streamer',775000,910000,130000,750000,6,130000,'2016-01-26 23:27:56',NULL),(3,'Yudori Fancy Set',1150000,1280000,160000,1100000,7,160000,'2016-01-26 23:27:56',NULL),(4,'Yudori Madame Wok',450000,490000,70000,390000,6,70000,'2016-01-26 23:27:56',NULL),(5,'Yoduri PressCook 8 LT',1600000,172000,172000,390000,9,172000,'2016-01-26 23:27:56',NULL);

/*Table structure for table `komisi` */

DROP TABLE IF EXISTS `komisi`;

CREATE TABLE `komisi` (
  `idkomisi` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `idpesanan` int(5) NOT NULL,
  `idsales` int(5) DEFAULT NULL,
  `komisi` int(5) DEFAULT NULL,
  PRIMARY KEY (`idkomisi`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `komisi` */

/*Table structure for table `pelanggan` */

DROP TABLE IF EXISTS `pelanggan`;

CREATE TABLE `pelanggan` (
  `idpelanggan` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `namapelanggan` varchar(20) NOT NULL,
  `alamat` text,
  `telepon` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idpelanggan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `pelanggan` */

/*Table structure for table `sales` */

DROP TABLE IF EXISTS `sales`;

CREATE TABLE `sales` (
  `idsales` int(5) NOT NULL AUTO_INCREMENT,
  `namasales` varchar(20) NOT NULL,
  `alamat` text,
  `telepon` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idsales`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `sales` */

insert  into `sales`(`idsales`,`namasales`,`alamat`,`telepon`) values (1,'Tendy Developer','Jl. Wotgandul Dalam 252\nSemarang 50137','085643221232 IM3');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `iduser` int(5) NOT NULL AUTO_INCREMENT,
  `namauser` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `level` varchar(10) NOT NULL,
  PRIMARY KEY (`iduser`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`iduser`,`namauser`,`username`,`password`,`level`) values (1,'admin','admin','admin','Admin'),(2,'Atanasius Tendy','tendy','tendy','Admin');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
