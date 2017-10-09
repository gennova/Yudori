/*
SQLyog Community v12.4.3 (64 bit)
MySQL - 10.1.25-MariaDB : Database - yudori
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

/*Table structure for table `akunutama` */

DROP TABLE IF EXISTS `akunutama`;

CREATE TABLE `akunutama` (
  `idakun` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `kodeakun` varchar(20) NOT NULL,
  `namaakun` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idakun`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `akunutama` */

/*Table structure for table `angsuran` */

DROP TABLE IF EXISTS `angsuran`;

CREATE TABLE `angsuran` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `kodeangsuran` varchar(20) NOT NULL,
  `kodebp` varchar(20) NOT NULL,
  `idpelanggan` int(5) DEFAULT NULL,
  `pembayar` varchar(30) DEFAULT NULL,
  `jumlah` int(10) NOT NULL,
  `penerima` varchar(20) DEFAULT NULL,
  `tanggal` varchar(20) DEFAULT NULL,
  `keterangan` text,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `akun` varchar(20) DEFAULT '11510201',
  `dk` varchar(2) DEFAULT 'K',
  PRIMARY KEY (`id`,`kodeangsuran`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `angsuran` */

insert  into `angsuran`(`id`,`kodeangsuran`,`kodebp`,`idpelanggan`,`pembayar`,`jumlah`,`penerima`,`tanggal`,`keterangan`,`timestamp`,`akun`,`dk`) values 
(1,'KA0908170001','BP010817001',8,'Bu Mimin',129000,'Ayu Admin','2017-04-08','','2017-08-09 15:26:47','11510201','K');

/*Table structure for table `bantucetakand` */

DROP TABLE IF EXISTS `bantucetakand`;

CREATE TABLE `bantucetakand` (
  `id` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `kodebp` varchar(30) NOT NULL,
  `kodeans` varchar(30) NOT NULL,
  `tanggal` varchar(30) NOT NULL,
  `jumlah` int(10) NOT NULL,
  `angsuran1` varchar(30) DEFAULT NULL,
  `angsuran2` varchar(30) DEFAULT NULL,
  `angsuran3` varchar(30) DEFAULT NULL,
  `angsuran4` varchar(30) DEFAULT NULL,
  `angsuran5` varchar(30) DEFAULT NULL,
  `angsuran6` varchar(30) DEFAULT NULL,
  `angsuran7` varchar(30) DEFAULT NULL,
  `angsuran8` varchar(30) DEFAULT NULL,
  `angsuran9` varchar(30) DEFAULT NULL,
  `angsuran10` varchar(30) DEFAULT NULL,
  `lunas` varchar(10) NOT NULL DEFAULT 'belum',
  `trace` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `tglangsuran1` varchar(30) DEFAULT NULL,
  `tglangsuran2` varchar(30) DEFAULT NULL,
  `tglangsuran3` varchar(30) DEFAULT NULL,
  `tglangsuran4` varchar(30) DEFAULT NULL,
  `tglangsuran5` varchar(30) DEFAULT NULL,
  `tglangsuran6` varchar(30) DEFAULT NULL,
  `tglangsuran7` varchar(30) DEFAULT NULL,
  `tglangsuran8` varchar(30) DEFAULT NULL,
  `tglangsuran9` varchar(30) DEFAULT NULL,
  `tglangsuran10` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `bantucetakand` */

insert  into `bantucetakand`(`id`,`kodebp`,`kodeans`,`tanggal`,`jumlah`,`angsuran1`,`angsuran2`,`angsuran3`,`angsuran4`,`angsuran5`,`angsuran6`,`angsuran7`,`angsuran8`,`angsuran9`,`angsuran10`,`lunas`,`trace`,`tglangsuran1`,`tglangsuran2`,`tglangsuran3`,`tglangsuran4`,`tglangsuran5`,`tglangsuran6`,`tglangsuran7`,`tglangsuran8`,`tglangsuran9`,`tglangsuran10`) values 
(1,'BP010817001','KA0908170001','2017-04-08',129000,'     ','100000','     ','     ','     ','     ','     ','     ','     ','     ','belum','2017-08-09 15:26:47','     ','2017-06-07','     ','     ','     ','     ','     ','     ','     ','     ');

/*Table structure for table `barang` */

DROP TABLE IF EXISTS `barang`;

CREATE TABLE `barang` (
  `idbarang` int(3) NOT NULL AUTO_INCREMENT,
  `namabarang` varchar(100) NOT NULL,
  `idharga` int(10) NOT NULL,
  PRIMARY KEY (`idbarang`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

/*Data for the table `barang` */

insert  into `barang`(`idbarang`,`namabarang`,`idharga`) values 
(1,'Yudori Noodles Maker',1),
(2,'Yudori Alsyva',2),
(3,'Yudori 8 Pcs Fancy Set',3),
(4,'Yudori 8 Pcs Tulip Set',4),
(5,'Yudori Blender Ez Blend',5),
(6,'Yudori Chopper 1.8 L',6),
(7,'Yudori Griddle 2 in 1',7),
(8,'Yudori Chopper 1.8 L + Yudori Noodle Maker',8),
(9,'Yudori Chopper 1.8 L + Yudori 8 Pcs Fancy set',9),
(10,'Yudori Chopper 1.8 L + Yudori 8 Pcs Tulip set',10),
(11,'Yudori Ez Blender + Yudori Gridle 2 in 1',11),
(12,'Yudori Chopper 1.8 L + Yudori Griddle 2 in 1',12),
(14,'Yudori Griddle 2 in 1 + Alsyva',14),
(15,'Yudori Chopper 1.8 L + Alsyva',15);

/*Table structure for table `bkmb` */

DROP TABLE IF EXISTS `bkmb`;

CREATE TABLE `bkmb` (
  `id` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `kodekmb` varchar(20) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `alamat` text,
  `keterangan` text,
  `detailketerangan` text,
  `tanggal` varchar(20) DEFAULT NULL,
  `idbarang` int(5) NOT NULL,
  `jumlah` int(10) DEFAULT NULL,
  `statusbarang` varchar(20) NOT NULL,
  `trace` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`,`kodekmb`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `bkmb` */

/*Table structure for table `bstu` */

DROP TABLE IF EXISTS `bstu`;

CREATE TABLE `bstu` (
  `id` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `kodebstu` varchar(30) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `uraian` text,
  `jumlah` int(10) NOT NULL,
  `keterangan` text,
  `trace` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` varchar(10) NOT NULL,
  `jenisbstu` varchar(30) NOT NULL,
  `diserahkan` varchar(30) NOT NULL,
  `kodeakun` varchar(30) DEFAULT NULL,
  `tanggal` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`,`kodebstu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `bstu` */

/*Table structure for table `buktipesanan` */

DROP TABLE IF EXISTS `buktipesanan`;

CREATE TABLE `buktipesanan` (
  `idpesanan` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `kodebp` varchar(15) NOT NULL,
  `idpesananfaktur` varchar(15) DEFAULT NULL,
  `namapelanggan` varchar(100) DEFAULT NULL,
  `alamatpelanggan` text,
  `telepon` varchar(20) DEFAULT NULL,
  `idsales` int(5) NOT NULL,
  `komisisales` int(10) DEFAULT NULL,
  `jenisorder` varchar(20) DEFAULT NULL,
  `tglpesanan` varchar(15) DEFAULT NULL,
  `tglpenagihan` varchar(15) DEFAULT NULL,
  `tglpengiriman` varchar(15) DEFAULT NULL,
  `total` int(10) NOT NULL,
  `UM` int(10) NOT NULL,
  `sisa` int(10) DEFAULT NULL,
  `sisaberjalan` int(5) DEFAULT NULL,
  `idpelanggan` int(10) NOT NULL,
  `timestamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `statusbp` varchar(10) DEFAULT 'belum',
  `angsuran` varchar(10) NOT NULL,
  `hargatunai` int(10) NOT NULL DEFAULT '0',
  `statuskirim` varchar(15) NOT NULL DEFAULT 'belum',
  PRIMARY KEY (`idpesanan`,`kodebp`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `buktipesanan` */

insert  into `buktipesanan`(`idpesanan`,`kodebp`,`idpesananfaktur`,`namapelanggan`,`alamatpelanggan`,`telepon`,`idsales`,`komisisales`,`jenisorder`,`tglpesanan`,`tglpenagihan`,`tglpengiriman`,`total`,`UM`,`sisa`,`sisaberjalan`,`idpelanggan`,`timestamp`,`statusbp`,`angsuran`,`hargatunai`,`statuskirim`) values 
(1,'BP010817001','009493','Bu Mimin','MA Al Ashor','081575098081',6,1,'DROP A1','2017-04-08','2017-05-17','2017-04-08',929000,129000,8,2,7,'2017-08-01 15:34:33','belum','100000',0,'belum');

/*Table structure for table `detailangsuran` */

DROP TABLE IF EXISTS `detailangsuran`;

CREATE TABLE `detailangsuran` (
  `id` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `noans` varchar(30) NOT NULL,
  `nobp` varchar(30) NOT NULL,
  `tgl` varchar(30) NOT NULL,
  `angsuranke` varchar(30) DEFAULT '1',
  `jumlah` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `detailangsuran` */

insert  into `detailangsuran`(`id`,`noans`,`nobp`,`tgl`,`angsuranke`,`jumlah`) values 
(1,'KA0908170001','BP010817001','2017-05-17','Angsuran 1',100000),
(2,'KA0908170001','BP010817001','2017-06-07','Angsuran 2',100000);

/*Table structure for table `detailbstu` */

DROP TABLE IF EXISTS `detailbstu`;

CREATE TABLE `detailbstu` (
  `id` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `nama` varchar(30) NOT NULL,
  `uraian` text,
  `keterangan` text,
  `jumlah` int(10) NOT NULL,
  `kodebstu` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `detailbstu` */

/*Table structure for table `detailpesanan` */

DROP TABLE IF EXISTS `detailpesanan`;

CREATE TABLE `detailpesanan` (
  `idorder` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `kodebarang` int(11) DEFAULT NULL,
  `namabarang` varchar(50) DEFAULT NULL,
  `unit` int(5) DEFAULT NULL,
  `harga` int(10) DEFAULT NULL,
  `total` int(10) DEFAULT NULL,
  `idpesanan` int(10) DEFAULT NULL,
  `kodebp` varchar(20) NOT NULL,
  `idpelanggan` int(10) DEFAULT NULL,
  PRIMARY KEY (`idorder`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `detailpesanan` */

insert  into `detailpesanan`(`idorder`,`kodebarang`,`namabarang`,`unit`,`harga`,`total`,`idpesanan`,`kodebp`,`idpelanggan`) values 
(1,6,'Yudori Chopper 1.8 L',1,929000,929000,1,'BP010817001',7);

/*Table structure for table `hargabarang` */

DROP TABLE IF EXISTS `hargabarang`;

CREATE TABLE `hargabarang` (
  `idharga` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idbarang` int(10) NOT NULL,
  `hargatunai` int(10) NOT NULL,
  `hargadrop` int(10) NOT NULL,
  `hargaindent` int(10) NOT NULL,
  `UM` int(10) NOT NULL,
  `hargapromositunai` int(10) NOT NULL,
  `tanggal` varchar(20) NOT NULL,
  `sisa` int(10) DEFAULT '0',
  `sisa1` int(10) NOT NULL,
  `sisa2` int(10) NOT NULL,
  `tglberlakumulai` varchar(100) DEFAULT NULL,
  `tglberlakuakhir` varchar(100) DEFAULT NULL,
  `aktif` char(1) DEFAULT 'Y',
  PRIMARY KEY (`idharga`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

/*Data for the table `hargabarang` */

insert  into `hargabarang`(`idharga`,`idbarang`,`hargatunai`,`hargadrop`,`hargaindent`,`UM`,`hargapromositunai`,`tanggal`,`sisa`,`sisa1`,`sisa2`,`tglberlakumulai`,`tglberlakuakhir`,`aktif`) values 
(1,1,2500000,2939000,2760000,329000,2500000,'',0,9,290000,'2017-04-25','2017-10-31','Y'),
(2,2,1580000,1584000,1580000,189000,1580000,'',0,9,155000,'2017-04-25','2017-10-31','Y'),
(3,3,1050000,1239000,1125000,159000,1050000,'',0,9,120000,'2017-04-25','2017-10-31','Y'),
(4,4,1250000,1429000,1300000,169000,1250000,'',0,9,140000,'2017-04-25','2017-10-31','Y'),
(5,5,990000,1099000,1050000,139000,990000,'',0,8,120000,'2017-04-25','2017-10-31','Y'),
(6,6,750000,929000,825000,129000,750000,'',0,8,100000,'2017-04-25','2017-10-31','Y'),
(7,7,490000,579000,540000,139000,490000,'',0,4,110000,'2017-04-25','2017-10-31','Y'),
(8,8,3150000,3539000,3300000,389000,3150000,'',0,9,350000,'2017-04-25','2017-10-31','Y'),
(9,9,1690000,1839000,1770000,219000,1690000,'',0,9,180000,'2017-04-25','2017-10-31','Y'),
(10,10,1890000,1980000,2069000,269000,1890000,'',0,9,200000,'2017-04-25','2017-10-31','Y'),
(11,11,1400000,1584000,1500000,189000,1400000,'',0,9,155000,'2017-04-25','2017-10-31','Y'),
(12,12,1200000,1200000,1200000,150000,1200000,'',0,7,150000,'2017-04-25','2017-10-31','Y'),
(13,13,1950000,2010000,2010000,249000,1950000,'',0,9,200000,'2017-04-25','2017-10-31','Y'),
(14,14,1800000,1939000,1845000,229000,1800000,'',0,9,190000,'2017-04-25','2017-10-31','Y'),
(15,15,1950000,2049000,2010000,249000,1950000,'',0,9,200000,'2017-04-25','2017-10-31','Y');

/*Table structure for table `kas` */

DROP TABLE IF EXISTS `kas`;

CREATE TABLE `kas` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `kodekas` varchar(30) NOT NULL,
  `kodekasmanual` varchar(50) NOT NULL DEFAULT '-',
  `tanggal` varchar(30) NOT NULL,
  `total` int(10) NOT NULL,
  PRIMARY KEY (`id`,`kodekas`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `kas` */

insert  into `kas`(`id`,`kodekas`,`kodekasmanual`,`tanggal`,`total`) values 
(1,'KO2908170001','-','2017-08-29',450000),
(2,'KO0609170002','','2017-09-06',350500),
(3,'KO0609170003','','2017-09-06',430000),
(4,'KO0609170004','','2017-09-06',800000),
(5,'KO0609170005','','2017-09-06',345000);

/*Table structure for table `kas_besar` */

DROP TABLE IF EXISTS `kas_besar`;

CREATE TABLE `kas_besar` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `kodekas` varchar(30) NOT NULL,
  `kodekasmanual` varchar(50) NOT NULL DEFAULT '-',
  `tanggal` varchar(30) NOT NULL,
  `total` int(10) NOT NULL,
  PRIMARY KEY (`id`,`kodekas`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `kas_besar` */

insert  into `kas_besar`(`id`,`kodekas`,`kodekasmanual`,`tanggal`,`total`) values 
(1,'KO1809170001','-','2017-09-19',0),
(2,'KO1809170002','-','2017-09-19',0);

/*Table structure for table `kas_besar_detail` */

DROP TABLE IF EXISTS `kas_besar_detail`;

CREATE TABLE `kas_besar_detail` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `kodekas` varchar(30) NOT NULL,
  `kodekasmanual` varchar(50) NOT NULL DEFAULT '-',
  `tanggal` varchar(30) NOT NULL,
  `total` int(10) NOT NULL,
  `jeniskas` varchar(20) NOT NULL,
  `uraian` text,
  `kodeakun` varchar(15) NOT NULL,
  PRIMARY KEY (`id`,`kodekas`)
) ENGINE=InnoDB AUTO_INCREMENT=1241 DEFAULT CHARSET=latin1;

/*Data for the table `kas_besar_detail` */

insert  into `kas_besar_detail`(`id`,`kodekas`,`kodekasmanual`,`tanggal`,`total`,`jeniskas`,`uraian`,`kodeakun`) values 
(1,'KO1809170001','-','2017-07-01',2681800,'Masuk','Saldo Pindahan',''),
(2,'KO1809170001','-','2017-07-01',160000,'Keluar','BSTUK 005172/Bbm Imam 18-22 / 29-30 Jun',''),
(3,'KO1809170001','-','2017-07-01',2450000,'Keluar','Setoran Bank',''),
(4,'KO1809170001','-','2017-07-03',800000,'Masuk','Supply Kas Pusat Ke Kas Operasional',''),
(5,'KO1809170001','-','2017-07-03',800000,'Keluar','Supply Kas Pusat Ke Kas Operasional',''),
(6,'KO1809170001','-','2017-07-03',750000,'Masuk','BSTUM 005173/Imam 7 K',''),
(7,'KO1809170001','-','2017-07-03',200000,'Masuk','BSTUM 005174/Imam 2 K',''),
(8,'KO1809170001','-','2017-07-03',250000,'Masuk','BSTUM 005175/Heri 2 K',''),
(9,'KO1809170001','-','2017-07-04',900000,'Keluar','Setoran Bank',''),
(10,'KO1809170001','-','2017-07-04',169000,'Masuk','BP 009592/Dian/Indri/Angsuran Presto 8 lt',''),
(11,'KO1809170001','-','2017-07-04',300000,'Masuk','BP 009590/Nanik/Indri/Indent Ez Blend',''),
(12,'KO1809170001','-','2017-07-04',269000,'Masuk','BP 005731/Guntoro/Lenny/Ansguran chopper + tulip 8 set',''),
(13,'KO1809170001','-','2017-07-04',150000,'Masuk','BP 007705/Lia/Yayuk/Angsuran chopper + gridle',''),
(14,'KO1809170001','-','2017-07-04',820000,'Masuk','BSTUM 005176/Imam 8 K',''),
(15,'KO1809170001','-','2017-07-04',100000,'Masuk','BP 008243/Supriyati/Ari/Tunai chopper',''),
(16,'KO1809170001','-','2017-07-04',100000,'Masuk','BP 008241/Ratno/Anik/Tunai chopper',''),
(17,'KO1809170001','-','2017-07-04',100000,'Masuk','BP 008244/Nur H/Anik/Tunai chopper',''),
(18,'KO1809170001','-','2017-07-05',200000,'Keluar','BSTUK 005177/Komisi mingguan ning 20 order',''),
(19,'KO1809170001','-','2017-07-05',30000,'Keluar','BSTUK 005178/Komisi mingguan tresye 3 order',''),
(20,'KO1809170001','-','2017-07-05',800000,'Keluar','Supply Ke Kas Operasional',''),
(21,'KO1809170001','-','2017-07-05',999800,'Keluar','Setoran Bank',''),
(22,'KO1809170001','-','2017-07-05',129000,'Masuk','BP 005732/Edy/Lenny/Angsuran chopper',''),
(23,'KO1809170001','-','2017-07-05',170000,'Masuk','BP 007448/Sigit/Tressye/Angsuran Alsyva',''),
(24,'KO1809170001','-','2017-07-05',200000,'Masuk','BSTUM 005178-9/Angsuran 2 K',''),
(25,'KO1809170001','-','2017-07-05',1065000,'Masuk','BSTUM 005197/Imam 10 K',''),
(26,'KO1809170001','-','2017-07-05',23000000,'Masuk','Supply Pusat ( Salary staff dan sales Jun\'17 )',''),
(27,'KO1809170001','-','2017-07-05',15700000,'Keluar','Salary Staff Jun \'17',''),
(28,'KO1809170001','-','2017-07-05',8255200,'Keluar','Komisi Sales ( Uang hadir dan Insentif )',''),
(29,'KO1809170001','-','2017-07-05',480000,'Keluar','Pembayaran paket barang 31 koli ( Panca Kobra )',''),
(30,'KO1809170001','-','2017-07-05',1000000,'Masuk','BSTUM 005198/Pelunasan order tressye',''),
(31,'KO1809170001','-','2017-07-05',500000,'Keluar','BSTUK 005199/Komisi 20 % tresye',''),
(32,'KO1809170001','-','2017-07-05',300000,'Masuk','BSTUM 005200/Angsuran agung ( mobil )',''),
(33,'KO1809170001','-','2017-07-05',245000,'Keluar','Service kampas rem GM B 1873 UKL',''),
(34,'KO1809170001','-','2017-07-05',980000,'Keluar','Setoran Bank',''),
(35,'KO1809170001','-','2017-07-05',1000000,'Masuk','BSTUM 005199/Heri 3 K',''),
(36,'KO1809170001','-','2017-07-05',2150000,'Masuk','BSTUM 004201/Pelunasan Order Tresye',''),
(37,'KO1809170001','-','2017-07-05',630000,'Keluar','BSTUK 004202/Komisi 20 % tresye',''),
(38,'KO1809170001','-','2017-07-05',1350000,'Masuk','BSTUM 004203/Pelunasan order wiwid dan ari',''),
(39,'KO1809170001','-','2017-07-05',300000,'Keluar','BSTUK 004204/Komisi 20 % ari dan wiwid',''),
(40,'KO1809170001','-','2017-07-06',3073800,'Keluar','Setoran Bank',''),
(41,'KO1809170001','-','2017-07-06',1556000,'Masuk','BSTUM 005200/Heri 9 K',''),
(42,'KO1809170001','-','2017-07-06',500000,'Masuk','BP 008501/Wulan/Tresye/Tunai alsyva',''),
(43,'KO1809170001','-','2017-07-06',1960000,'Masuk','BSTUM 003601/Pelunasan Order Tresye',''),
(44,'KO1809170001','-','2017-07-06',632000,'Keluar','BSTUK 003602/Komisi 20 % tresye',''),
(45,'KO1809170001','-','2017-07-06',200000,'Keluar','BSTUK 003602/Komisi tambahan alsyva',''),
(46,'KO1809170001','-','2017-07-06',985000,'Masuk','BSTUM 003501/Imam 8 K',''),
(47,'KO1809170001','-','2017-07-06',4150000,'Keluar','Setoran Bank',''),
(48,'KO1809170001','-','2017-07-06',1800000,'Masuk','BSTUM 003603/Pelunasan Order ( ari , yayuk . Wiwid )',''),
(49,'KO1809170001','-','2017-07-07',500000,'Masuk','BP 007447/Wulan/Tresye/Tunai noodle',''),
(50,'KO1809170001','-','2017-07-07',300000,'Masuk','Supply Kas Pusat Ke Kas Operasional',''),
(51,'KO1809170001','-','2017-07-07',300000,'Keluar','Supply Kas Pusat Ke Kas Operasional',''),
(52,'KO1809170001','-','2017-07-07',600000,'Masuk','BSTUM 003604/Pelunasan Order Tresye',''),
(53,'KO1809170001','-','2017-07-07',6000000,'Masuk','BP 008601/Roni//Ning/Tunai chopper 8 unit',''),
(54,'KO1809170001','-','2017-07-07',1200000,'Masuk','BP 008601/Roni//Ning/Tunai chopper + gridle',''),
(55,'KO1809170001','-','2017-07-07',1440000,'Keluar','BSTUK 003605/Komisi 20 % ning',''),
(56,'KO1809170001','-','2017-07-07',1000000,'Keluar','BSTUK 003606/Komisi OR P\'Gito  ( Bu Wiwid )',''),
(57,'KO1809170001','-','2017-07-07',1295000,'Masuk','BSTUM 003502/Heri 8 K',''),
(58,'KO1809170001','-','2017-07-07',900000,'Masuk','BSTUM 003503/Imam 9 K',''),
(59,'KO1809170001','-','2017-07-07',432000,'Keluar','Dinas Perjalanan Pak Sodikin dan Pak Gito ( Jogja )',''),
(60,'KO1809170001','-','2017-07-07',9931000,'Keluar','Setoran Bank',''),
(61,'KO1809170001','-','2017-07-07',2000000,'Masuk','BSTUM 003607/Pelunasan order ari dan yayuk',''),
(62,'KO1809170001','-','2017-07-07',600000,'Keluar','BSTUK 003608/Komisi 20 % ari dan yayuk',''),
(63,'KO1809170001','-','2017-07-07',700000,'Masuk','BSTUM 003609/Pelunasan order tyas',''),
(64,'KO1809170001','-','2017-07-07',300000,'Keluar','BSTUK 003610/Komisi 20 % tyas',''),
(65,'KO1809170001','-','2017-07-08',330000,'Keluar','BSTUK 003611/Komisi mingguan yayuk 33 order',''),
(66,'KO1809170001','-','2017-07-08',50000,'Keluar','BSTUK 003612/Komisi mingguan wiwid 5 order',''),
(67,'KO1809170001','-','2017-07-08',880000,'Keluar','Halal Biahal Kantor ( Sales dan staff )',''),
(68,'KO1809170001','-','2017-07-08',140000,'Masuk','BP 005734/Palupi/Tuti/Angsuran gridle',''),
(69,'KO1809170001','-','2017-07-08',130000,'Masuk','BP 007559/Dodi/Tuti/Tunai chopper',''),
(70,'KO1809170001','-','2017-07-08',130000,'Masuk','BP 007560/Suyuti/Tuti/Tunai chopper',''),
(71,'KO1809170001','-','2017-07-08',130000,'Masuk','BP 007561/Didi/Tuti/Tunai chopper',''),
(72,'KO1809170001','-','2017-07-08',1775000,'Masuk','BSTUM 003504/Imam 11 K',''),
(73,'KO1809170001','-','2017-07-08',150000,'Keluar','BSTUK 003615/Komisi 20 % yayuk',''),
(74,'KO1809170001','-','2017-07-08',80000,'Keluar','BSTUK 003613/Uang makan driver tarjo',''),
(75,'KO1809170001','-','2017-07-08',80000,'Keluar','BSTUK 003614/Uang makan driver nano',''),
(76,'KO1809170001','-','2017-07-10',1000000,'Masuk','Supply Kas Pusat Ke Kas Operasional',''),
(77,'KO1809170001','-','2017-07-10',1000000,'Keluar','Supply Kas Pusat Ke Kas Operasional',''),
(78,'KO1809170001','-','2017-07-10',9800000,'Masuk','Supply Kas Pusat ( Komisi sales dan Staff Jun\'17 )',''),
(79,'KO1809170001','-','2017-07-10',2546000,'Keluar','Setoran Bank',''),
(80,'KO1809170001','-','2017-07-10',1371000,'Masuk','BSTUM 003506/Imam 12 K',''),
(81,'KO1809170001','-','2017-07-10',200000,'Masuk','BSTUM 003505/Angsuran 2 k',''),
(82,'KO1809170001','-','2017-07-10',4545200,'Keluar','Komisi sales ( sawulan dan A1 )',''),
(83,'KO1809170001','-','2017-07-10',5326353,'Keluar','Komisi staff ( instentif )',''),
(84,'KO1809170001','-','2017-07-10',150000,'Masuk','BP 007566/Rina/Lenny/Angsuran chopper + gridle',''),
(85,'KO1809170001','-','2017-07-10',150000,'Masuk','BP 007565/Sunu/Lenny/Angsuran chopper + gridle',''),
(86,'KO1809170001','-','2017-07-10',150000,'Masuk','BP 007564/Dina/Lenny/Angsuran chopper + gridle',''),
(87,'KO1809170001','-','2017-07-10',150000,'Masuk','BP 007563/Marjono/Tuti/Angsuran chopper + gridle',''),
(88,'KO1809170001','-','2017-07-10',150000,'Masuk','BP 007562/Suparmi/Tuti/Angsuran chopper + gridle',''),
(89,'KO1809170001','-','2017-07-10',200000,'Masuk','BP 007303/Marsini/yayuk/Tunai chopper',''),
(90,'KO1809170001','-','2017-07-10',100000,'Masuk','BP 007302/Sukirno/Wiwid/Tunai chopper',''),
(91,'KO1809170001','-','2017-07-10',329000,'Masuk','BP 008551/Budi/Indri/Angsuran noodle',''),
(92,'KO1809170001','-','2017-07-10',100000,'Masuk','BP 008503/Retno/Tyas/Tunai chopper',''),
(93,'KO1809170001','-','2017-07-10',250000,'Masuk','BP 008506/Irma/Tresye/Tunai tulip 8 set',''),
(94,'KO1809170001','-','2017-07-10',189000,'Masuk','BP 007625/Rusmawati/Tyas/Angsuran Alsyva',''),
(95,'KO1809170001','-','2017-07-10',189000,'Masuk','BP 008505/Kristin/Tresye/Angsuran Alsyva',''),
(96,'KO1809170001','-','2017-07-10',200000,'Masuk','BSTUM 003633/Pelunasan wiwid',''),
(97,'KO1809170001','-','2017-07-10',200000,'Masuk','BSTUM 003634/Pelunasan tresye',''),
(98,'KO1809170001','-','2017-07-10',100000,'Keluar','BSTUK 003631/Komisi mingguan tyas 10 order',''),
(99,'KO1809170001','-','2017-07-10',3800000,'Keluar','Setoran Bank',''),
(100,'KO1809170001','-','2017-07-11',189000,'Masuk','BP 007624/Siti/Tyas/Angsuran alsyva',''),
(101,'KO1809170001','-','2017-07-11',300000,'Masuk','BP 008508/Sumiyati/Tresye/Tunai chopper + tulip 8 set',''),
(102,'KO1809170001','-','2017-07-11',2470000,'Masuk','BSTUM 003507/Heri 12 K',''),
(103,'KO1809170001','-','2017-07-11',1325000,'Masuk','BSTUM 003508/Imam 10 K',''),
(104,'KO1809170001','-','2017-07-11',1750000,'Masuk','BSTUM 003636/Pelunasan tyas dan tresye',''),
(105,'KO1809170001','-','2017-07-11',650000,'Keluar','BSTUK 003639/Komisi 20 % tyas dan tresye',''),
(106,'KO1809170001','-','2017-07-11',130000,'Keluar','BSTUK 003637/Bbm kolektor imam 3 - 8 jul',''),
(107,'KO1809170001','-','2017-07-11',250000,'Masuk','BSTUM 003638/Angsuran kit alsyva',''),
(108,'KO1809170001','-','2017-07-11',5600000,'Keluar','Setoran Bank',''),
(109,'KO1809170001','-','2017-07-11',1250000,'Masuk','BSTUM 003640/Pelunasan order wiwid dan anik',''),
(110,'KO1809170001','-','2017-07-11',250000,'Masuk','BP 007305/Eni/Anik/Angsuran chopper + tulip 8 set',''),
(111,'KO1809170001','-','2017-07-11',250000,'Masuk','BP 007304/Wahyu/Anik/Angsuran chopper + tulip 8 set',''),
(112,'KO1809170001','-','2017-07-11',100000,'Masuk','BP 007524/Yohan/Ari/Tunai chopper',''),
(113,'KO1809170001','-','2017-07-11',150000,'Masuk','BP 007568/Sigit/Tuti/Angsuran chopper + gridle',''),
(114,'KO1809170001','-','2017-07-11',150000,'Masuk','BP 007569/Agus/Lenny/Angsuran chopper + gridle',''),
(115,'KO1809170001','-','2017-07-12',2160447,'Keluar','Setoran Bank',''),
(116,'KO1809170001','-','2017-07-12',1000000,'Masuk','Supply Kas Pusat Ke Kas Operasional',''),
(117,'KO1809170001','-','2017-07-12',1000000,'Keluar','Supply Kas Pusat Ke Kas Operasional',''),
(118,'KO1809170001','-','2017-07-12',2660000,'Masuk','BSTUM 003509/Heri 13 K',''),
(119,'KO1809170001','-','2017-07-12',1230000,'Masuk','BSTUM 003510/Imam 13 K',''),
(120,'KO1809170001','-','2017-07-12',3850000,'Keluar','Setoran Bank',''),
(121,'KO1809170001','-','2017-07-12',329000,'Masuk','BP 008553/Esty/Lenny/Angsuran noodle',''),
(122,'KO1809170001','-','2017-07-12',3150000,'Masuk','BP 008554/Oky/Indri/Tunai chopper + noodle',''),
(123,'KO1809170001','-','2017-07-12',100000,'Masuk','BP 007309/Evi/Anik/Tunai chopper',''),
(124,'KO1809170001','-','2017-07-12',200000,'Masuk','BP 007312/Puput/Wiwid/Tunai tulip 8 set',''),
(125,'KO1809170001','-','2017-07-12',200000,'Masuk','BP 007526/Handayani/Ari/Tunai chopper',''),
(126,'KO1809170001','-','2017-07-12',200000,'Masuk','BP 007525/Wasilatul/Ari/Tunai chopper',''),
(127,'KO1809170001','-','2017-07-12',200000,'Masuk','BP 007527/Zulaikah/Ari/Tunai chopper',''),
(128,'KO1809170001','-','2017-07-12',100000,'Masuk','BP 008155/Sinta/Anik/Tunai chopper',''),
(129,'KO1809170001','-','2017-07-12',100000,'Masuk','BP 008156/Ismainiwati/Wiwid/Tunai chopper',''),
(130,'KO1809170001','-','2017-07-12',189000,'Masuk','BP 007630/Tria/Tyas/Ansguran alsyva',''),
(131,'KO1809170001','-','2017-07-12',150000,'Masuk','BP 008511/Tutik/Tressye/Angsuran chopper + gridle',''),
(132,'KO1809170001','-','2017-07-12',150000,'Masuk','BP 008510/Norma/Tyas/Ansguran chopper + gridle',''),
(133,'KO1809170001','-','2017-07-12',630000,'Keluar','BSTUK 003644/Komisi 20 % indri',''),
(134,'KO1809170001','-','2017-07-12',200000,'Masuk','BSTUM 003641/Penambahan Dp BP 007524 a.n Johan / chopper',''),
(135,'KO1809170001','-','2017-07-12',1220000,'Masuk','BSTUM 003642/Pelunasan order tresye',''),
(136,'KO1809170001','-','2017-07-12',790000,'Masuk','BSTUM 003643/Pelunasan order anik',''),
(137,'KO1809170001','-','2017-07-12',616000,'Keluar','BSTUK 003644/Komisi 20 % tresye',''),
(138,'KO1809170001','-','2017-07-12',150000,'Keluar','BSTUK 003644/Komisi 20 % anik',''),
(139,'KO1809170001','-','2017-07-12',5922000,'Keluar','Setoran Bank',''),
(140,'KO1809170001','-','2017-07-13',1000000,'Masuk','BSTUM 003512/Imam 8 K',''),
(141,'KO1809170001','-','2017-07-13',1000000,'Masuk','BP 008555/Erwin/Indri/Tunai chopper + noodle',''),
(142,'KO1809170001','-','2017-07-13',150000,'Masuk','BP 008556/Inul/Indri/Angsuran chopper + gridle',''),
(143,'KO1809170001','-','2017-07-13',150000,'Masuk','BP 008602/Yulinda/Ning/Angsuran chopper + gridle',''),
(144,'KO1809170001','-','2017-07-13',150000,'Masuk','BP 008603/Darno/Ning/Angsuran chopper + gridle',''),
(145,'KO1809170001','-','2017-07-13',100000,'Masuk','BSTUM 003511/Angsuran 1 K',''),
(146,'KO1809170001','-','2017-07-13',2550000,'Keluar','Setoran Bank',''),
(147,'KO1809170001','-','2017-07-13',710000,'Masuk','BSTUM 003513/Imam 5 K',''),
(148,'KO1809170001','-','2017-07-13',1635000,'Masuk','BSTUM 003514/Heri 16 K',''),
(149,'KO1809170001','-','2017-07-13',150000,'Masuk','BP 008521/Indah/Tyas/Angsuran chopper + gridle',''),
(150,'KO1809170001','-','2017-07-13',150000,'Masuk','BP 008522/Juriyah/Tyas/Angsuran chopper + gridle',''),
(151,'KO1809170001','-','2017-07-13',150000,'Masuk','BP 008515/Sri R/Tressye/Angsuran chopper + gridle',''),
(152,'KO1809170001','-','2017-07-13',159000,'Masuk','BP 008513/Sri R/Tressye/Angsuran suggo cook',''),
(153,'KO1809170001','-','2017-07-13',1250000,'Masuk','BSTUM 003645/Pelunasan order anik dan wiwid',''),
(154,'KO1809170001','-','2017-07-13',50000,'Keluar','BSTUK 003646/Komisi mingguan 5 order',''),
(155,'KO1809170001','-','2017-07-14',3754000,'Keluar','Setoran Bank',''),
(156,'KO1809170001','-','2017-07-14',250000,'Masuk','BP 008607/Nia/Ning/Tunai noodle',''),
(157,'KO1809170001','-','2017-07-14',250000,'Masuk','BP 008608/Nuri/Ning/Tunai noodle',''),
(158,'KO1809170001','-','2017-07-14',189000,'Masuk','BP 008604/Griyadi/Ning/Angsuran chopper + fancy suggo',''),
(159,'KO1809170001','-','2017-07-14',1120000,'Masuk','BSTUM 003516/Imam 9 K',''),
(160,'KO1809170001','-','2017-07-14',1800000,'Keluar','Setoran Bank',''),
(161,'KO1809170001','-','2017-07-14',1350000,'Masuk','BSTUM 003649/Pelunasan order wiwid',''),
(162,'KO1809170001','-','2017-07-14',300000,'Keluar','BSTUK 003650/Komisi 20 % wiwid',''),
(163,'KO1809170001','-','2017-07-14',130000,'Keluar','BSTUK 003648/Um driver Agung 3 - 15 Jul',''),
(164,'KO1809170001','-','2017-07-14',1160000,'Masuk','BSTUM 003517/Heri 9 K',''),
(165,'KO1809170001','-','2017-07-14',400000,'Masuk','BSTUM 003301/Tambahan DP tulip BP 007527 dan BP 007525',''),
(166,'KO1809170001','-','2017-07-15',1120000,'Masuk','BSTUM 003518/Imam 10 K',''),
(167,'KO1809170001','-','2017-07-15',60000,'Keluar','BSTUK 003519/Komisi mingguan indri 6 order',''),
(168,'KO1809170001','-','2017-07-15',50000,'Keluar','BSTUK 003520/Komisi mingguan lenny 5 order',''),
(169,'KO1809170001','-','2017-07-15',200000,'Masuk','Supply Kas Pusat Ke Kas Operasional',''),
(170,'KO1809170001','-','2017-07-15',200000,'Keluar','Supply Kas Pusat Ke Kas Operasional',''),
(171,'KO1809170001','-','2017-07-15',3450000,'Keluar','Setoran Bank',''),
(172,'KO1809170001','-','2017-07-15',965000,'Masuk','BSTUM 003519/Heri 8 K',''),
(173,'KO1809170001','-','2017-07-15',471000,'Keluar','Dinas Perjalanan Pak Sodikin Pekalongan',''),
(174,'KO1809170001','-','2017-07-15',180000,'Keluar','Oli B 1139 FFA Shell Helix Hx 5 15/50',''),
(175,'KO1809170001','-','2017-07-15',150000,'Masuk','BP 007573/Yani/Tuti/Angsuran chopper + gridle',''),
(176,'KO1809170001','-','2017-07-15',150000,'Masuk','BP 007574/Susi/Tuti/Angsuran chopper + gridle',''),
(177,'KO1809170001','-','2017-07-15',150000,'Masuk','BP 007572/Sadiyah/lenny/Angsuran chopper + gridle',''),
(178,'KO1809170001','-','2017-07-15',150000,'Masuk','BP 007571/Kuswanti/Lenny/Angsuran chopper + gridle',''),
(179,'KO1809170001','-','2017-07-15',60000,'Keluar','BSTUK 003301/Um driver nano 10 - 15 jul',''),
(180,'KO1809170001','-','2017-07-15',300000,'Masuk','BP 008516/Supriyanto/Tresye/Tunai chopper + gridle',''),
(181,'KO1809170001','-','2017-07-15',329000,'Masuk','BP 008515/Nita/Tresye/Angsuran noodle',''),
(182,'KO1809170001','-','2017-07-15',500000,'Masuk','BP 008517/Supriyanto/Tyas/Tunai noodle',''),
(183,'KO1809170001','-','2017-07-15',150000,'Masuk','BP 008523/Pujiningsih/Tyas/Angsuran chopper + noodle',''),
(184,'KO1809170001','-','2017-07-15',150000,'Masuk','BP 008524/Kumaeroh/Tyas/Tunai chopper',''),
(185,'KO1809170001','-','2017-07-17',1300000,'Masuk','Supply Kas Pusat Ke Kas Operasional',''),
(186,'KO1809170001','-','2017-07-17',1300000,'Keluar','Supply Kas Pusat Ke Kas Operasional',''),
(187,'KO1809170001','-','2017-07-17',80000,'Keluar','BSTUK 003302/Komisi mingguan indri 8 order',''),
(188,'KO1809170001','-','2017-07-17',1550000,'Masuk','BSTUM 003303/Pelunasan order tyas',''),
(189,'KO1809170001','-','2017-07-17',450000,'Keluar','BSTUK 003304/Komisi 20 % tyas',''),
(190,'KO1809170001','-','2017-07-17',1015000,'Masuk','BSTUM 003520/Heri 11 K',''),
(191,'KO1809170001','-','2017-07-17',1810000,'Masuk','BSTUM 003521/Imam 17 K',''),
(192,'KO1809170001','-','2017-07-17',6100000,'Keluar','Setoran Bank',''),
(193,'KO1809170001','-','2017-07-17',200000,'Masuk','BSTUM 003307/Tambahan DP BP 008508 Sumiyati',''),
(194,'KO1809170001','-','2017-07-17',130000,'Keluar','BSTUK 003305/Bbm Imam 10-17 Jul',''),
(195,'KO1809170001','-','2017-07-17',80000,'Keluar','BSTUK 003306/Komisi mingguan Tressye 8 order',''),
(196,'KO1809170001','-','2017-07-17',389000,'Masuk','BP 007628/Heny/Tyas/Angsuran chopper + noodle',''),
(197,'KO1809170001','-','2017-07-17',159000,'Masuk','BP 008159/Agung/Anik/Angsuran fancy suggo',''),
(198,'KO1809170001','-','2017-07-18',3500000,'Masuk','BSTUM 003309/Pelunasan order Ning 6',''),
(199,'KO1809170001','-','2017-07-18',900000,'Keluar','BSTUK 003310/Komisi 20 % ning',''),
(200,'KO1809170001','-','2017-07-18',1880000,'Masuk','BSTUM 003523-24/Imam 16 K',''),
(201,'KO1809170001','-','2017-07-18',169000,'Masuk','BP 008605/Giyadi/Ning/Angsuran Tulip 8 set',''),
(202,'KO1809170001','-','2017-07-18',250000,'Masuk','BP 008606/Herni/Ning/Tunai noodle',''),
(203,'KO1809170001','-','2017-07-18',500000,'Masuk','BP 008618/Saripah/Ning/Tunai noodle + chopper',''),
(204,'KO1809170001','-','2017-07-18',500000,'Masuk','BP 008616/Pratiwi/Ning/Tunai noodle + chopper',''),
(205,'KO1809170001','-','2017-07-18',500000,'Masuk','BP 008619/Ida/Ning/Tunai noodle',''),
(206,'KO1809170001','-','2017-07-18',500000,'Masuk','BP 008617/Yuly/ning/Tunai noodle',''),
(207,'KO1809170001','-','2017-07-18',269000,'Masuk','BP 008557/Yoen/Indri/Angsuran chopper + tulip 8 set',''),
(208,'KO1809170001','-','2017-07-18',5690000,'Masuk','BSTUM 003525-27/Heri 40 K',''),
(209,'KO1809170001','-','2017-07-18',20000,'Keluar','BSTUK 003311/Komisi mingguan tuti 2 order',''),
(210,'KO1809170001','-','2017-07-18',13400000,'Keluar','Setoran Bank',''),
(211,'KO1809170001','-','2017-07-18',389000,'Masuk','BP 008519/Yayuk/Tyas/Angsuran chopper + noodle',''),
(212,'KO1809170001','-','2017-07-18',150000,'Masuk','BP 007626/Supriyanto/Tyas/Angsuran chopper + gridle',''),
(213,'KO1809170001','-','2017-07-18',169000,'Masuk','BP 008518/Nita/Tressye/Angsuran tulip 8 set',''),
(214,'KO1809170001','-','2017-07-18',150000,'Masuk','BP 008525/Nita/Tresye/Tunai chopper',''),
(215,'KO1809170001','-','2017-07-19',434500,'Keluar','Perjalanan Dinas P\'Sodikin dan P\'Gito Jogja',''),
(216,'KO1809170001','-','2017-07-19',100000,'Masuk','BP 008620/Aminah/Ning/Tunai chopper',''),
(217,'KO1809170001','-','2017-07-19',990000,'Masuk','BSTUM 003528/Imam 9 K',''),
(218,'KO1809170001','-','2017-07-19',2790000,'Masuk','BSTUM 003531-32/Heri 22 K',''),
(219,'KO1809170001','-','2017-07-19',3600000,'Masuk','BSTUM 003312/Pelunasan order ning',''),
(220,'KO1809170001','-','2017-07-19',1050000,'Keluar','BSTUK 003313/Komisi 20 % ning',''),
(221,'KO1809170001','-','2017-07-19',345000,'Keluar','Service Van mobil + denso GM B 1873 UKL',''),
(222,'KO1809170001','-','2017-07-19',159000,'Masuk','BP 007629/Deny/Tressye/Angsuran Fancy 8 set',''),
(223,'KO1809170001','-','2017-07-19',6350000,'Keluar','Setoran Bank',''),
(224,'KO1809170001','-','2017-07-19',150000,'Masuk','BP 008161/Retno/Anik/Tunai chopper',''),
(225,'KO1809170001','-','2017-07-19',300000,'Masuk','BP 008162/Retno/Yayuk/Tunai noodle',''),
(226,'KO1809170001','-','2017-07-20',1000000,'Masuk','BP 008558/Yami/Indri/Indent noodle',''),
(227,'KO1809170001','-','2017-07-20',1560000,'Masuk','BSTUM 003535/Heri 13 K',''),
(228,'KO1809170001','-','2017-07-20',3545000,'Masuk','BSTUM 003533/Imam 26 K',''),
(229,'KO1809170001','-','2017-07-20',150000,'Masuk','BP 007580/Hanny/Lenny/Angsur chopper + gridle',''),
(230,'KO1809170001','-','2017-07-20',150000,'Masuk','BP 007576/Anis/Lenny/Angsur chopper + gridle',''),
(231,'KO1809170001','-','2017-07-20',150000,'Masuk','BP 007579/Ana/Lenny/Angsur chopper + gridle',''),
(232,'KO1809170001','-','2017-07-20',150000,'Masuk','BP 007578/Rina/Tuti/Angsur chopper + gridle',''),
(233,'KO1809170001','-','2017-07-20',150000,'Masuk','BP 007577/Harni/Tuti/Angsur chopper + gridle',''),
(234,'KO1809170001','-','2017-07-20',1000000,'Masuk','Supply Kas Pusat Ke Kas Operasional',''),
(235,'KO1809170001','-','2017-07-20',1000000,'Keluar','Supply Kas Pusat Ke Kas Operasional',''),
(236,'KO1809170001','-','2017-07-21',7305000,'Keluar','Setoran Bank',''),
(237,'KO1809170001','-','2017-07-21',1725000,'Masuk','BSTUM 003536/Heri 12 K',''),
(238,'KO1809170001','-','2017-07-21',75000,'Masuk','BSTUM 003539/Angsuran 1 K',''),
(239,'KO1809170001','-','2017-07-21',2490000,'Masuk','BSTUM 003537/Imam 19 K',''),
(240,'KO1809170001','-','2017-07-21',250000,'Masuk','BP 008520/Sampen/Tyas/Tunai chopper + gridle',''),
(241,'KO1809170001','-','2017-07-21',100000,'Masuk','BP 007320/Fatiyah/Totok/Tunai chopper',''),
(242,'KO1809170001','-','2017-07-21',129000,'Masuk','BP 007323/Tutik/Totok/Angsuran chopper',''),
(243,'KO1809170001','-','2017-07-21',129000,'Masuk','BP 007321/Izatul/Wiwid/Angsuran chopper',''),
(244,'KO1809170001','-','2017-07-21',159000,'Masuk','BP 007322/Siti N/Wiwid/Angsuran fancy 8 set',''),
(245,'KO1809170001','-','2017-07-21',200000,'Masuk','BP 007585/Woro/Lenny/Tunai chopper',''),
(246,'KO1809170001','-','2017-07-21',200000,'Masuk','BP 007582/Purwanti/Lenny/Tunai chopper',''),
(247,'KO1809170001','-','2017-07-21',200000,'Masuk','BP 007586/Irianti/Lenny/Tunai chopper',''),
(248,'KO1809170001','-','2017-07-21',200000,'Masuk','BP 007581/Yayuk/Tuti/Tunai chopper',''),
(249,'KO1809170001','-','2017-07-21',200000,'Masuk','BP 007583/Purwanti/Tuti/Tunai chopper',''),
(250,'KO1809170001','-','2017-07-21',200000,'Masuk','BP 007587/Cahyaning/Tuti/Tunai tulip 8 set',''),
(251,'KO1809170001','-','2017-07-21',400000,'Masuk','BSTUM 003314/Tambahan DP BP 007447 Wulan',''),
(252,'KO1809170001','-','2017-07-21',784500,'Keluar','Perjalanan Dinas P\'Sodikin dan P\'Gito Pekalongan',''),
(253,'KO1809170001','-','2017-07-21',1900000,'Masuk','BSTUM 003315/Pelunasan order yayuk dan wiwid',''),
(254,'KO1809170001','-','2017-07-21',450000,'Keluar','BSTUK 003316/Komisi 20 % yayuk dan wiwid',''),
(255,'KO1809170001','-','2017-07-21',17000,'Keluar','Biaya Adm Bank',''),
(256,'KO1809170001','-','2017-07-22',8033000,'Keluar','Setoran Bank',''),
(257,'KO1809170001','-','2017-07-22',159000,'Masuk','BP 008624/Eko/Ning/Angsuran fancy 8 set',''),
(258,'KO1809170001','-','2017-07-22',150000,'Masuk','BP 008623/Mira/Ning/Angsuran chopper + gridle',''),
(259,'KO1809170001','-','2017-07-22',1100000,'Masuk','BSTUM 003542/Heri 9 K',''),
(260,'KO1809170001','-','2017-07-22',1915000,'Masuk','BSTUM 003540/Imam 17 K',''),
(261,'KO1809170001','-','2017-07-22',150000,'Keluar','BSTUK 003317/Bbm Imam 17-22 Jul',''),
(262,'KO1809170001','-','2017-07-22',42500,'Keluar','BSTUK 003318/Perjalanan Dinas Pak gito ( tiket kreta Pkg )',''),
(263,'KO1809170001','-','2017-07-22',3150000,'Keluar','Setoran Bank',''),
(264,'KO1809170001','-','2017-07-22',219000,'Masuk','BP 008559/Anik/Indri/Angsuran chopper + fancy 8 set',''),
(265,'KO1809170001','-','2017-07-22',150000,'Masuk','BP 005736/Dini/Lenny/Angsuran chopper + gridle',''),
(266,'KO1809170001','-','2017-07-22',150000,'Masuk','BP 007570/Solichin/Lenny/Angsuran chopper + gridle',''),
(267,'KO1809170001','-','2017-07-22',129000,'Masuk','BP 007575/Joko/Lenny/Angsuran chopper',''),
(268,'KO1809170001','-','2017-07-22',150000,'Masuk','BP 007590/Siti/Tuti/Angsuran chopper + gridle',''),
(269,'KO1809170001','-','2017-07-22',150000,'Masuk','BP 007591/Eni/Tuti/Angsuran chopper + gridle',''),
(270,'KO1809170001','-','2017-07-22',150000,'Masuk','BP 007637/Wahyu/Tyas/Angsuran chopper + gridle',''),
(271,'KO1809170001','-','2017-07-22',150000,'Masuk','BP 007636/Umi/Tyas/Angsuran chopper + gridle',''),
(272,'KO1809170001','-','2017-07-22',150000,'Masuk','BP 007621/Firma/Tyas/Angsuran chopper + gridle',''),
(273,'KO1809170001','-','2017-07-22',129000,'Masuk','BP 007620/Anik/Tyas/Angsuran chopper',''),
(274,'KO1809170001','-','2017-07-22',60000,'Keluar','BSTUK 003319/Um driver Nano 17 - 22 Jul',''),
(275,'KO1809170001','-','2017-07-22',80000,'Keluar','BSTUK 003320/Um driver Agung 16 - 23 Jul',''),
(276,'KO1809170001','-','2017-07-22',130000,'Keluar','BSTUK 003321/Um driver Tarjo 9-21 / 23 Jul',''),
(277,'KO1809170001','-','2017-07-24',1000000,'Masuk','Supply Kas Pusat Ke Kas Operasional',''),
(278,'KO1809170001','-','2017-07-24',1000000,'Keluar','Supply Kas Pusat Ke Kas Operasional',''),
(279,'KO1809170001','-','2017-07-24',129000,'Masuk','BP 007595/Istiono/Tuti/Angsuran chopper',''),
(280,'KO1809170001','-','2017-07-24',129000,'Masuk','BP 007594/Rochimin/Tuti/Angsuran chopper',''),
(281,'KO1809170001','-','2017-07-24',150000,'Masuk','BP 007592/Subiyanti/Tuti/Angsuran chopper + gridle',''),
(282,'KO1809170001','-','2017-07-24',150000,'Masuk','BP 007593/Anik/Tuti/Angsuran chopper + gridle',''),
(283,'KO1809170001','-','2017-07-24',1950000,'Masuk','BSTUM 003322/Pelunasan order chopper Lenny',''),
(284,'KO1809170001','-','2017-07-24',450000,'Keluar','BSTUK 003323/Komisi 20 % lenny',''),
(285,'KO1809170001','-','2017-07-24',1360000,'Masuk','BSTUM 003543/Imam 11 K',''),
(286,'KO1809170001','-','2017-07-24',3790000,'Masuk','BSTUM 003544/Heri 28 K',''),
(287,'KO1809170001','-','2017-07-24',150000,'Masuk','BP 007640/Jiyarti/Tyas/Angsuran chopper + gridle',''),
(288,'KO1809170001','-','2017-07-24',150000,'Masuk','BP 007639/Paula/Tyas/Angsuran chopper + gridle',''),
(289,'KO1809170001','-','2017-07-24',250000,'Keluar','BSTUK 003324/Um P\'Gito Dinas Pkg 25-29 Jul',''),
(290,'KO1809170001','-','2017-07-24',8400000,'Keluar','Setoran Bank',''),
(291,'KO1809170001','-','2017-07-24',45000,'Keluar','Paket Barang Baraka Ke Pkg',''),
(292,'KO1809170001','-','2017-07-24',100000,'Masuk','BP 007532/Wahyu/Ari/Tunai chopper',''),
(293,'KO1809170001','-','2017-07-24',200000,'Masuk','BP 007531/Tri Puji/Ari/Tunai chopper',''),
(294,'KO1809170001','-','2017-07-24',200000,'Masuk','BP 007530/Sri/Ari/Tunai chopper',''),
(295,'KO1809170001','-','2017-07-24',100000,'Masuk','BP 008166/Nur/Anik/Tunai chopper',''),
(296,'KO1809170001','-','2017-07-24',100000,'Masuk','BP 008167/Ferry/Yayuk/Tunai gridle',''),
(297,'KO1809170001','-','2017-07-25',200000,'Masuk','BP 008626/Siswanto/Ning/Tunai chopper',''),
(298,'KO1809170001','-','2017-07-25',150000,'Masuk','BP 008651/Rifai/Lenny/Angsuran chopper + gridle',''),
(299,'KO1809170001','-','2017-07-25',500000,'Masuk','BSTUM 003326/Pelunasan Order Tyas',''),
(300,'KO1809170001','-','2017-07-25',60000,'Keluar','BSTUK 003325/Komisi mingguan tuti 6 order',''),
(301,'KO1809170001','-','2017-07-25',1900000,'Masuk','BSTUM 003548-49/Imam 16 K',''),
(302,'KO1809170001','-','2017-07-25',2280000,'Masuk','BSTUM 003546-47/Heri 19 K',''),
(303,'KO1809170001','-','2017-07-25',5370000,'Keluar','Setoran Bank',''),
(304,'KO1809170001','-','2017-07-25',180000,'Keluar','Oli Shell B 1700 PFI Helix Hx 5 15/50',''),
(305,'KO1809170001','-','2017-07-25',200000,'Masuk','BSTUM 003327/Tambahan DP Tulip BP 007526 Handayani',''),
(306,'KO1809170001','-','2017-07-25',1050000,'Masuk','BSTUM 003328/Pelunasan order tresye',''),
(307,'KO1809170001','-','2017-07-25',450000,'Keluar','BSTUK 003329/Komisi 20 % tresye',''),
(308,'KO1809170001','-','2017-07-25',2050000,'Masuk','BSTUM 003330/Pelunasan order anik , ari dan yayuk',''),
(309,'KO1809170001','-','2017-07-25',2375000,'Masuk','BSTUM 003331/Pelunasan Order Ari dan yayuk',''),
(310,'KO1809170001','-','2017-07-25',750000,'Keluar','BSTUK 003332/Komisi 20 % yayuk dan ari',''),
(311,'KO1809170001','-','2017-07-26',4689500,'Keluar','Setoran Bank',''),
(312,'KO1809170001','-','2017-07-26',2500000,'Masuk','BP 008561/Agustien/Indri/Tunai noodle',''),
(313,'KO1809170001','-','2017-07-26',200000,'Masuk','BP 008560/Harmini/Indri/Tunai tulip 8 set',''),
(314,'KO1809170001','-','2017-07-26',500000,'Keluar','BSTUK 003335/Komisi 20 % indri',''),
(315,'KO1809170001','-','2017-07-26',3460000,'Masuk','BSTUM 003550/002801/Heri 22 K',''),
(316,'KO1809170001','-','2017-07-26',1690000,'Masuk','BSTUM 002802-03/Imam 16 K',''),
(317,'KO1809170001','-','2017-07-26',150000,'Masuk','BSTUM 002804/Angsuran 1 K',''),
(318,'KO1809170001','-','2017-07-26',159000,'Masuk','BP 008529/Wiwik/Tresye/Angsuran fancy 8 set',''),
(319,'KO1809170001','-','2017-07-26',159000,'Masuk','BP 008528/Reni/Tresye/Angsuran fancy 8 set',''),
(320,'KO1809170001','-','2017-07-26',300000,'Masuk','BP 008527/Ririn/Tresye/Tunai chopper',''),
(321,'KO1809170001','-','2017-07-26',8118000,'Keluar','Setoran Bank',''),
(322,'KO1809170001','-','2017-07-26',159000,'Masuk','BP 008535/Tina/Yayuk/Angsuran fancy 8 set',''),
(323,'KO1809170001','-','2017-07-27',1100000,'Masuk','Supply Kas Pusat Ke Kas Operasional',''),
(324,'KO1809170001','-','2017-07-27',1100000,'Keluar','Supply Kas Pusat Ke Kas Operasional',''),
(325,'KO1809170001','-','2017-07-27',169000,'Masuk','BP 008563/Wiyanti/Indri/Tunai tulip 8 set',''),
(326,'KO1809170001','-','2017-07-27',169000,'Masuk','BP 008562/Wiyantii/Indri/Angsuran tulip 8 set',''),
(327,'KO1809170001','-','2017-07-27',1050000,'Masuk','BSTUM 003336/Pelunasan indri tulip',''),
(328,'KO1809170001','-','2017-07-27',250000,'Keluar','BSTUK 003337/Komisi 20 % indri',''),
(329,'KO1809170001','-','2017-07-27',2535000,'Masuk','BSTUM 002807-08/Heri 24 K',''),
(330,'KO1809170001','-','2017-07-27',2940000,'Masuk','BSTUM 002805-06/Imam 23 K',''),
(331,'KO1809170001','-','2017-07-27',129000,'Masuk','BP 008630/Nur/Tuti/Angsuran chopper',''),
(332,'KO1809170001','-','2017-07-27',129000,'Masuk','BP 008631/Agnes/Tuti/Angsuran chopper',''),
(333,'KO1809170001','-','2017-07-27',129000,'Masuk','BP 008632/Niken/Lenny/Angsuran chopper',''),
(334,'KO1809170001','-','2017-07-27',129000,'Masuk','BP 008633/Neni/Lenny/Angsuran chopper',''),
(335,'KO1809170001','-','2017-07-27',129000,'Masuk','BP 008634/Tri/Ning/Angsuran chopper',''),
(336,'KO1809170001','-','2017-07-27',129000,'Masuk','BP 008635/Mujinem/Ning/Angsuran chopper',''),
(337,'KO1809170001','-','2017-07-27',129000,'Masuk','BP 008636/Sutarti/Ning/Angsuran chopper',''),
(338,'KO1809170001','-','2017-07-27',200000,'Keluar','BSTUK 003338/Dinas Perjalanan P\'Iik Jogja',''),
(339,'KO1809170001','-','2017-07-27',7460000,'Keluar','Setoran Bank',''),
(340,'KO1809170001','-','2017-07-27',129000,'Masuk','BP 008530/Peni/Tressye/Angsuran chopper',''),
(341,'KO1809170001','-','2017-07-27',129000,'Masuk','BP 008530/Peni/Tressye/Angsuran chopper',''),
(342,'KO1809170001','-','2017-07-28',1250000,'Masuk','BSTUM 002811/Imam 15 K',''),
(343,'KO1809170001','-','2017-07-28',2325000,'Masuk','BSTUM 002809-10/Heri 17 K',''),
(344,'KO1809170001','-','2017-07-28',150000,'Masuk','BP 010179/Giyati/Tyas/Angsuran chopper + griddle',''),
(345,'KO1809170001','-','2017-07-28',150000,'Masuk','BP 010180/Wiwik/Tyas/Angsuran chopper + griddle',''),
(346,'KO1809170001','-','2017-07-28',8000000,'Masuk','Supply Kas Pusat ( Komisi Lunas Dan OR Bu Tuti )',''),
(347,'KO1809170001','-','2017-07-28',329000,'Masuk','BP 008564/Rini/Indri/Angsuran noodle',''),
(348,'KO1809170001','-','2017-07-28',1081000,'Masuk','BSTUM 003339/Pelunasan order indri tulip',''),
(349,'KO1809170001','-','2017-07-28',250000,'Keluar','BSTUK 003340/Komisi 20 % indri',''),
(350,'KO1809170001','-','2017-07-28',1000000,'Keluar','BSTUK 003341/Komisi OR Bu Tuti ( Bu tyas )',''),
(351,'KO1809170001','-','2017-07-28',7080250,'Keluar','Komisi Lunas Smr Mei - Jun\'17',''),
(352,'KO1809170001','-','2017-07-28',50000,'Keluar','BSTUK 003342/Cuci Kolong Mobil D 1176 MP',''),
(353,'KO1809170001','-','2017-07-28',5150000,'Keluar','Setoran Bank',''),
(354,'KO1809170001','-','2017-07-28',129000,'Masuk','BP 007325/Utami/Lenny/Angsuran chopper ',''),
(355,'KO1809170001','-','2017-07-28',169000,'Masuk','BP 007326/Andi/Lenny/Angsuran tulip 8 set',''),
(356,'KO1809170001','-','2017-07-28',329000,'Masuk','BP 007333/Sulis/Wiwid/Angsuran noodle',''),
(357,'KO1809170001','-','2017-07-28',129000,'Masuk','BP 007328/Dian/Wiwid/Angsuran chopper',''),
(358,'KO1809170001','-','2017-07-28',329000,'Masuk','BP 007331/Desi/Wiwid/Angsuran noodle',''),
(359,'KO1809170001','-','2017-07-28',129000,'Masuk','BP 007324/Endang/Anik/Angsuran chopper',''),
(360,'KO1809170001','-','2017-07-29',90000,'Keluar','BSTUK 003343/Komisi mingguan wiwid 9 order',''),
(361,'KO1809170001','-','2017-07-29',100000,'Masuk','Supply Kas Pusat Ke Kas Operasional',''),
(362,'KO1809170001','-','2017-07-29',100000,'Keluar','Supply Kas Pusat Ke Kas Operasional',''),
(363,'KO1809170001','-','2017-07-29',150000,'Masuk','BP 007635/Kristina/Tyas/Angsuran chopper + gridle',''),
(364,'KO1809170001','-','2017-07-29',300000,'Masuk','BP 008534/Handayani/Tresye/Tunai chopper + noodle',''),
(365,'KO1809170001','-','2017-07-29',129000,'Masuk','BP 008533/Tiwi/Tresye/Angsuran chopper ',''),
(366,'KO1809170001','-','2017-07-29',129000,'Masuk','BP 008532/Nanik/Tresye/Angsuran chopper',''),
(367,'KO1809170001','-','2017-07-29',129000,'Masuk','BP 008531/Badi/Tresye/Angsuran chopper',''),
(368,'KO1809170001','-','2017-07-29',160000,'Keluar','BSTUK 003344/Bbm kolektor Imam 24 - 29 Jul',''),
(369,'KO1809170001','-','2017-07-29',230000,'Keluar','BSTUK 003345/Komisi mingguan tyas 23 order',''),
(370,'KO1809170001','-','2017-07-29',80000,'Keluar','BSTUK 003347/Komisi mingguan tuti 8 order',''),
(371,'KO1809170001','-','2017-07-29',1150000,'Masuk','BSTUM 002812/Imam 9 K',''),
(372,'KO1809170001','-','2017-07-29',60000,'Keluar','BSTUK 003346/Um driver nano 24-29 Jul',''),
(373,'KO1809170001','-','2017-07-29',2600000,'Keluar','Setoran Bank',''),
(374,'KO1809170001','-','2017-07-29',100000,'Masuk','BP 007714/Harman/Yayuk/Tunai gridle',''),
(375,'KO1809170001','-','2017-07-29',30000,'Keluar','BSTUK 003349/Komisi mingguan ari 3 order',''),
(376,'KO1809170001','-','2017-07-29',70000,'Keluar','BSTUK 003348/Um driver Tarjo 24-28/30-31 Jul',''),
(377,'KO1809170001','-','2017-07-29',1259000,'Masuk','BSTUM 002814/Angsuran 15 K',''),
(378,'KO1809170001','-','2017-07-29',935000,'Masuk','BSTUM 002813/Heri 9 K',''),
(379,'KO1809170001','-','2017-07-31',1000000,'Masuk','Supply Kas Pusat Ke Kas Operasional',''),
(380,'KO1809170001','-','2017-07-31',1000000,'Keluar','Supply Kas Pusat Ke Kas Operasional',''),
(381,'KO1809170001','-','2017-07-31',2202750,'Keluar','Setoran Bank',''),
(382,'KO1809170001','-','2017-07-31',129000,'Masuk','BP 007567/Sri/Tuti/Angsuran chopper',''),
(383,'KO1809170001','-','2017-07-31',100000,'Masuk','BP 008452/Asih/Tuti/Tunai chopper',''),
(384,'KO1809170001','-','2017-07-31',100000,'Masuk','BP 008453/Nurul/Tuti/Tunai chopper',''),
(385,'KO1809170001','-','2017-07-31',100000,'Masuk','BP 008454/Neta/Tuti/Tunai chopper',''),
(386,'KO1809170001','-','2017-07-31',750000,'Masuk','BP 008638/Galuh/Ning/Tunai chopper',''),
(387,'KO1809170001','-','2017-07-31',150000,'Masuk','BP 008622/Emy/Ning/Angsuran chopper + gridle',''),
(388,'KO1809170001','-','2017-07-31',100000,'Masuk','BP 008451/Suyem/Ning/Tunai chopper',''),
(389,'KO1809170001','-','2017-07-31',100000,'Masuk','BP 007598/Ristiyanti/Lenny/Tunai chopper',''),
(390,'KO1809170001','-','2017-07-31',300000,'Masuk','BP 008401/Narno/Tresye/Tunai gridle',''),
(391,'KO1809170001','-','2017-07-31',129000,'Masuk','BP 007645/Rini/Tyas/Angsuran chopper',''),
(392,'KO1809170001','-','2017-07-31',129000,'Masuk','BP 007643/Kiki/Tyas/Angsuran chopper',''),
(393,'KO1809170001','-','2017-07-31',150000,'Masuk','BP 007644/Sri/Tyas/Angsuran chopper+gridle',''),
(394,'KO1809170001','-','2017-07-31',800000,'Masuk','BSTUM 002853/Penambahan DP BP 008161 dan 008162',''),
(395,'KO1809170001','-','2017-07-31',300000,'Keluar','BSTUK 002858/Komisi mingguan ning 30 order',''),
(396,'KO1809170001','-','2017-07-31',250000,'Keluar','BSTUK 002861/Um Pak gito Dinas Pkg 01 - 05 Ags',''),
(397,'KO1809170001','-','2017-07-31',42500,'Keluar','BSTUK 002861/Tiket Kreta Pkg Pak Gito',''),
(398,'KO1809170001','-','2017-07-31',150000,'Keluar','BSTUK 002855/Komisi tunai 20 % bu ning',''),
(399,'KO1809170001','-','2017-07-31',560000,'Keluar','BSTUK -00433107 Biaya Paket Baraka',''),
(400,'KO1809170001','-','2017-07-31',2240000,'Masuk','BSTUM 002815-16/Imam 19 K',''),
(401,'KO1809170001','-','2017-07-31',1950000,'Masuk','BSTUM 002817-18-Heri 16 K',''),
(402,'KO1809170001','-','2017-07-31',350000,'Masuk','BSTUM 002819/Angsuran 4 K',''),
(403,'KO1809170001','-','2017-07-31',6250000,'Keluar','Setoran Bank',''),
(404,'KO1809170001','-','2017-07-31',2138000,'Masuk','BSTUM 002821/Heri 14 K',''),
(405,'KO1809170001','-','2017-07-31',690000,'Masuk','BSTUM 002822/Angsuran 3 K',''),
(406,'KO1809170001','-','2017-07-31',600000,'Masuk','BSTUM 002820/Imam 7 K',''),
(407,'KO1809170001','-','2017-07-31',269000,'Masuk','BP 007332/Cipta/Wiwid/Angsuran chopper + tulip 8 set',''),
(408,'KO1809170001','-','2017-07-31',129000,'Masuk','BP 007330/Farida/Wiwid/Angsuran chopper',''),
(409,'KO1809170001','-','2017-07-31',129000,'Masuk','BP 007329/Ari/Wiwid/Angsuran chopper',''),
(410,'KO1809170001','-','2017-07-31',294000,'Keluar','BSTUK 002862/Komisi 15 % lenny',''),
(890,'KO1809170002','-','2017-08-10',6750000,'Masuk','BSTUM 002918/Pelunasan order ning',''),
(891,'KO1809170002','-','2017-08-10',1500000,'Keluar','BSTUK 002919/Komisi 20 % ning',''),
(892,'KO1809170002','-','2017-08-10',3775000,'Masuk','BSTUM 002839-40/Heri 16 K',''),
(893,'KO1809170002','-','2017-08-10',240000,'Keluar','BSTUK 002920/Komisi 20 % lenny',''),
(894,'KO1809170002','-','2017-08-10',9200000,'Keluar','Setoran Bank',''),
(895,'KO1809170002','-','2017-08-10',100000,'Masuk','BP 008411/Afri/Tyas/Tunai chopper 2 in 1',''),
(896,'KO1809170002','-','2017-08-10',199000,'Masuk','BP 007649/Ricco/Tyas/Angsuran fancy stove',''),
(897,'KO1809170002','-','2017-08-10',199000,'Masuk','BP 008412/Betty/Tyas/Tunai Fancy stove',''),
(898,'KO1809170002','-','2017-08-10',200000,'Masuk','BP 008407/Ratna/Tyas/Tunai presto elektrik',''),
(899,'KO1809170002','-','2017-08-11',300000,'Keluar','BSTUK 002921/Santunan Kematian ( keluarga sales )',''),
(900,'KO1809170002','-','2017-08-11',229000,'Masuk','BP 008413/Narti/Tyas/Angsuran elektrik presto',''),
(901,'KO1809170002','-','2017-08-11',1400000,'Masuk','BSTUM 002841/Imam 12 K',''),
(902,'KO1809170002','-','2017-08-11',1155000,'Masuk','BSTUM 002842/Heri 10 K',''),
(903,'KO1809170002','-','2017-08-11',229000,'Masuk','BP 008571/Agustin/Indri/Tunai Presto Elektrik',''),
(904,'KO1809170002','-','2017-08-11',199000,'Masuk','BP 008570/Retno/Indri/Tuai Fancy Stove',''),
(905,'KO1809170002','-','2017-08-11',4900000,'Masuk','Supply Pusat ( Komisi Staff )',''),
(906,'KO1809170002','-','2017-08-11',4930905,'Keluar','Komisi Staff Smr',''),
(907,'KO1809170002','-','2017-08-11',3650000,'Keluar','Setoran Bank',''),
(908,'KO1809170002','-','2017-08-11',400000,'Masuk','BP 008351/Lany/Tressye/Tunai Noodle',''),
(909,'KO1809170002','-','2017-08-11',150000,'Masuk','BP 008707/Sorutun/Tuti/Angsuran chopper',''),
(910,'KO1809170002','-','2017-08-11',129000,'Masuk','BP 008663/Ainun/Lenny/Angsuran chopper',''),
(911,'KO1809170002','-','2017-08-11',150000,'Masuk','BP 008671/Narni/Lenny/Angsuran chopper + gridle',''),
(912,'KO1809170002','-','2017-08-11',150000,'Masuk','BP 008706/Putri/Tuti/Angsuran chopper + gridle',''),
(913,'KO1809170002','-','2017-08-11',750000,'Masuk','BP 008702/Ari/Tuti/Tunai chopper',''),
(914,'KO1809170002','-','2017-08-11',750000,'Masuk','BP 008701/Endah/Tuti/Tunai chopper',''),
(915,'KO1809170002','-','2017-08-11',750000,'Masuk','BP 008703/Sari/Tuti/Tunai chopper',''),
(916,'KO1809170002','-','2017-08-11',750000,'Masuk','BP 008704/Rini/Tuti/Tunai chopper',''),
(917,'KO1809170002','-','2017-08-11',750000,'Masuk','BP 008705/Atik/Tuti/Tunai chopper',''),
(918,'KO1809170002','-','2017-08-11',750000,'Masuk','BP 008665/Widya/Lenny/Tunai chopper',''),
(919,'KO1809170002','-','2017-08-11',750000,'Masuk','BP 008666/Arum/Lenny/Tunai chopper',''),
(920,'KO1809170002','-','2017-08-11',750000,'Masuk','BP 008667/Oky/Lenny/Tunai chopper',''),
(921,'KO1809170002','-','2017-08-11',750000,'Masuk','BP 008668/Tuti/Lenny/Tunai chopper',''),
(922,'KO1809170002','-','2017-08-11',750000,'Masuk','BP 008669/Mus/Lenny/Tunai chopper',''),
(923,'KO1809170002','-','2017-08-11',750000,'Masuk','BP 008665/Widya/Lenny/Tunai chopper',''),
(924,'KO1809170002','-','2017-08-11',1650000,'Keluar','BSTUK 002924/Komisi 20 % lenny dan tuti',''),
(925,'KO1809170002','-','2017-08-11',150000,'Keluar','BSTUK 002925/Dinas Perj Agung ( ambil chopper Pkg )',''),
(926,'KO1809170002','-','2017-08-11',621000,'Masuk','BSTUM 002922/Pelunasan order tui ( jogja )',''),
(927,'KO1809170002','-','2017-08-11',150000,'Keluar','BSTUK 002923/Komisi 20 % chopper',''),
(928,'KO1809170002','-','2017-08-11',100000,'Keluar','BSTUK 002926/Dinas Perjalanan P\'Sodikin Pkg',''),
(929,'KO1809170002','-','2017-08-11',50000,'Masuk','BSTUM 002927/Sisa Dinas Perj P\'Gito',''),
(930,'KO1809170002','-','2017-08-11',7950000,'Keluar','Setoran Bank',''),
(931,'KO1809170002','-','2017-08-12',1795000,'Masuk','BSTUM 002843-44/Imam 17 K',''),
(932,'KO1809170002','-','2017-08-12',8000000,'Masuk','Supply Pusat ( Komisi A1 dan Sawulan Sales )',''),
(933,'KO1809170002','-','2017-08-12',6535500,'Keluar','Komisi A1 Sales',''),
(934,'KO1809170002','-','2017-08-12',2176300,'Keluar','Komisi Sawulan Sales',''),
(935,'KO1809170002','-','2017-08-12',1100000,'Keluar','Setoran Bank',''),
(936,'KO1809170002','-','2017-08-12',650000,'Masuk','BSTUM 002936/Pelunasan order lenny',''),
(937,'KO1809170002','-','2017-08-12',150000,'Keluar','BSTUK 002937/Komisi 20 % lenny',''),
(938,'KO1809170002','-','2017-08-12',1860000,'Masuk','BSTUM 002938/Pelunasan order tuti',''),
(939,'KO1809170002','-','2017-08-12',450000,'Keluar','BSTUK 002939/Komisi 20 % tuti',''),
(940,'KO1809170002','-','2017-08-14',1000000,'Masuk','Supply Kas Pusat Ke Kas Operasional',''),
(941,'KO1809170002','-','2017-08-14',1000000,'Keluar','Supply Kas Pusat Ke Kas Operasional',''),
(942,'KO1809170002','-','2017-08-14',300000,'Masuk','BSTUM 002940/Angsuran mobil ( agung ) lunas',''),
(943,'KO1809170002','-','2017-08-14',1110000,'Keluar','Setoran Bank',''),
(944,'KO1809170002','-','2017-08-14',159000,'Masuk','BP 008572/Indri/Indri/Angsuran fancy 8 set',''),
(945,'KO1809170002','-','2017-08-14',1105000,'Masuk','BSTUM 002845/Imam 9 K',''),
(946,'KO1809170002','-','2017-08-14',1235000,'Masuk','BSTUM 002846/Heri 10 K',''),
(947,'KO1809170002','-','2017-08-14',1271000,'Masuk','BSTUM 002941/Pelunasan order indri',''),
(948,'KO1809170002','-','2017-08-14',300000,'Keluar','BSTUK 002942/Komisi 20 % indri',''),
(949,'KO1809170002','-','2017-08-14',135000,'Keluar','BSTUK 002944/Bbm kolektor Imam 7-12 Ags',''),
(950,'KO1809170002','-','2017-08-14',1075000,'Keluar','BSTUK 002945/Biaya Paket TNT ( spare part )',''),
(951,'KO1809170002','-','2017-08-14',550000,'Masuk','BSTUM 002946/Pelunasan order Tyas',''),
(952,'KO1809170002','-','2017-08-14',150000,'Keluar','BSTUK 002947/Komisi 20 % tyas',''),
(953,'KO1809170002','-','2017-08-14',392000,'Masuk','BP 008708/Agung/Gridle ( Lunas )',''),
(954,'KO1809170002','-','2017-08-14',1600000,'Masuk','BSTUM 002950/Pelunasan order tuti',''),
(955,'KO1809170002','-','2017-08-14',400000,'Keluar','BSTUK 002951/Komisi 20 % tuti',''),
(956,'KO1809170002','-','2017-08-14',139000,'Masuk','BP 008462/Agustina/Tuti/Angsuran chopper 2 in 1',''),
(957,'KO1809170002','-','2017-08-14',139000,'Masuk','BP 008464/Umi/Lenny/Angsuran Chopper 2 in 1',''),
(958,'KO1809170002','-','2017-08-14',400000,'Masuk','BP 008465/Amin/Tuti/Tunai chopper',''),
(959,'KO1809170002','-','2017-08-14',5925000,'Keluar','Setoran Bank',''),
(960,'KO1809170002','-','2017-08-14',1700000,'Masuk','BSTUM 002952/Pelunasan order lenny',''),
(961,'KO1809170002','-','2017-08-14',300000,'Keluar','BSTUK 002953/Komisi 20 % lenny',''),
(962,'KO1809170002','-','2017-08-15',2940000,'Masuk','BSTUM 002955/Pelunasan order Tressye',''),
(963,'KO1809170002','-','2017-08-15',768000,'Keluar','BSTUK 002957/Komisi 20 % tressye',''),
(964,'KO1809170002','-','2017-08-15',3577000,'Keluar','Setoran Bank',''),
(965,'KO1809170002','-','2017-08-15',5050000,'Masuk','BSTUM 002847-48/Heri 25 K',''),
(966,'KO1809170002','-','2017-08-15',500000,'Keluar','BSTUK 002959/Komisi 20 % Indri',''),
(967,'KO1809170002','-','2017-08-15',820000,'Keluar','BSTUK 002960/Pembelian ban B 1320 KMT ( 2 baru , 1 bekas )',''),
(968,'KO1809170002','-','2017-08-15',2250000,'Keluar','Komisi / Bonus Staff ( driver dan kolektor )',''),
(969,'KO1809170002','-','2017-08-15',3275000,'Masuk','BSTUM 002849-50/Imam 25 K',''),
(970,'KO1809170002','-','2017-08-15',60000,'Keluar','BSTUK 002962/Um driver Nano 7-12 Ags',''),
(971,'KO1809170002','-','2017-08-15',4650000,'Keluar','Setoran Bank',''),
(972,'KO1809170002','-','2017-08-15',150000,'Masuk','BP 008463/Asih/Tuti/Tunai chopper 2 in 1',''),
(973,'KO1809170002','-','2017-08-15',150000,'Masuk','BP 008672/Puji/Lenny/Tunai chopper 2 in 1',''),
(974,'KO1809170002','-','2017-08-16',329000,'Masuk','BP 008415/Yayuk/Tressye/Angsuran nodle',''),
(975,'KO1809170002','-','2017-08-16',150000,'Masuk','BP 008538/Ana/Tyas/Tunai gridle',''),
(976,'KO1809170002','-','2017-08-16',169000,'Masuk','BP 008539/Ton/Tressye/Angsuran tulip set',''),
(977,'KO1809170002','-','2017-08-16',169000,'Masuk','BP 008540/Mila/Tyas/Angsuran tulip set',''),
(978,'KO1809170002','-','2017-08-16',139000,'Masuk','BP 008675/Musnah/Tuti/Angsuran chopper 2 in 1',''),
(979,'KO1809170002','-','2017-08-16',139000,'Masuk','BP 008676/Dul/Lenny/Angsuran chopper 2 In 1',''),
(980,'KO1809170002','-','2017-08-16',139000,'Masuk','BP 008674/Kunardi/Lenny/Angsuran chopper 2 in 1',''),
(981,'KO1809170002','-','2017-08-16',139000,'Masuk','BP 008673/Yen/Tuti/Angsuran chopper 2 In 1',''),
(982,'KO1809170002','-','2017-08-16',1720000,'Masuk','BSTUM 003001/Imam 10 K',''),
(983,'KO1809170002','-','2017-08-16',3280000,'Masuk','BSTUM 003002-03/Heri 28 K',''),
(984,'KO1809170002','-','2017-08-16',200000,'Keluar','BSTUK 002967/Uang Tali kasih ( Bu yayuk )',''),
(985,'KO1809170002','-','2017-08-16',6518000,'Keluar','Setoran Bank',''),
(986,'KO1809170002','-','2017-08-16',800000,'Masuk','BSTUM 003004/Imam 8 K',''),
(987,'KO1809170002','-','2017-08-18',650000,'Keluar','BSTUK 002968/Service Mobil Agung ( radiator bocor )',''),
(988,'KO1809170002','-','2017-08-18',700000,'Masuk','Supply Kas Pusat Ke Kas Operasional',''),
(989,'KO1809170002','-','2017-08-18',700000,'Keluar','Supply Kas Pusat Ke Kas Operasional',''),
(990,'KO1809170002','-','2017-08-18',1380000,'Masuk','BSTUM 003005/Imam 13 K',''),
(991,'KO1809170002','-','2017-08-18',520000,'Keluar','Paket Baraka ( 20 presto , 36 gridle , kompor 10 )',''),
(992,'KO1809170002','-','2017-08-18',985000,'Keluar','Setoran Bank',''),
(993,'KO1809170002','-','2017-08-18',17000,'Keluar','Adm BCA',''),
(994,'KO1809170002','-','2017-08-18',850000,'Masuk','BSTUM 002969/Pelunasan order ari',''),
(995,'KO1809170002','-','2017-08-18',2200000,'Masuk','BSTUM 002972/Pelunasan order anik',''),
(996,'KO1809170002','-','2017-08-18',1900000,'Masuk','BSTUM 002973/Pelunasan order tresye',''),
(997,'KO1809170002','-','2017-08-18',300000,'Keluar','BSTUK 002974/Komisi 20 % tyas',''),
(998,'KO1809170002','-','2017-08-18',600000,'Keluar','BSTUK 002974/Komisi 20 % anik',''),
(999,'KO1809170002','-','2017-08-18',300000,'Keluar','BSTUK 002974/Komisi 20 % ari',''),
(1000,'KO1809170002','-','2017-08-18',1000000,'Masuk','BSTUM 002975/Pelunasan order tressye',''),
(1001,'KO1809170002','-','2017-08-18',300000,'Keluar','BSTUK 002976/Komisi 20 % tressye',''),
(1002,'KO1809170002','-','2017-08-18',1900000,'Masuk','BSTUM 0030006/Heri 13 K',''),
(1003,'KO1809170002','-','2017-08-19',50000,'Keluar','BSTUK 002971/Um driver Nano 14-19 Ags',''),
(1004,'KO1809170002','-','2017-08-19',60000,'Keluar','BSTUK 002970/Um driver tarjo 13-19 Ags',''),
(1005,'KO1809170002','-','2017-08-19',6240000,'Keluar','Setoran Bank',''),
(1006,'KO1809170002','-','2017-08-19',490000,'Masuk','BP 008576/Mia/Indri/Tunai griddle',''),
(1007,'KO1809170002','-','2017-08-19',159000,'Masuk','BP 008573/Lis/Indri/Angsuran fancy 8 set',''),
(1008,'KO1809170002','-','2017-08-19',139000,'Masuk','BP 008574/Nanik/Indri/Angsuran griddle',''),
(1009,'KO1809170002','-','2017-08-19',1420000,'Masuk','BSTUM 003007/Imam 11 K',''),
(1010,'KO1809170002','-','2017-08-19',160000,'Keluar','BSTUK 002977/Um driver agung 1-19 ags',''),
(1011,'KO1809170002','-','2017-08-19',150000,'Keluar','BSTUK 002978/Bbm kolektor imam 14-19 ags',''),
(1012,'KO1809170002','-','2017-08-19',98000,'Keluar','BSTUK 002979/Komisi 20 % indri',''),
(1013,'KO1809170002','-','2017-08-19',150000,'Masuk','BP 008417/Santi/Tyas/Tunai chopper',''),
(1014,'KO1809170002','-','2017-08-19',1950000,'Keluar','Setoran Bank',''),
(1015,'KO1809170002','-','2017-08-19',199000,'Masuk','BP 008416/Sumiyati/Tressye/Angsuran fancy stove',''),
(1016,'KO1809170002','-','2017-08-19',229000,'Masuk','BP 008541/Anik/Tressye/Angsuran presto elektrik',''),
(1017,'KO1809170002','-','2017-08-19',1800000,'Masuk','BSTUM 002980/Pelunasan Order Wiwid',''),
(1018,'KO1809170002','-','2017-08-21',2236000,'Keluar','Setoran Bank',''),
(1019,'KO1809170002','-','2017-08-21',1500000,'Masuk','Supply Kas Pusat Ke Kas Operasional',''),
(1020,'KO1809170002','-','2017-08-21',1500000,'Keluar','Supply Kas Pusat Ke Kas Operasional',''),
(1021,'KO1809170002','-','2017-08-21',100000,'Masuk','BP 008677/Heru/Tuti/Tunai chopper',''),
(1022,'KO1809170002','-','2017-08-21',200000,'Masuk','BP 008678/Sufi/Lenny/Tunai tulip 8 set',''),
(1023,'KO1809170002','-','2017-08-21',1410000,'Masuk','BSTUM 003008/Imam 10 K',''),
(1024,'KO1809170002','-','2017-08-21',1560000,'Masuk','BSTUM 002982/Pelunasan order lenny',''),
(1025,'KO1809170002','-','2017-08-21',3250000,'Keluar','Setoran Bank',''),
(1026,'KO1809170002','-','2017-08-21',200000,'Masuk','BP 008543/Novi/Tyas/Tunai presto elektrik',''),
(1027,'KO1809170002','-','2017-08-21',200000,'Masuk','BP 008542/Meilia/Tressye/Tunai presto elektrik',''),
(1028,'KO1809170002','-','2017-08-21',1250000,'Masuk','BSTUM 003009/Heri 10 K',''),
(1029,'KO1809170002','-','2017-08-21',100000,'Keluar','BSTUK 002983/Dinas Perj P\'Dikin Kudus',''),
(1030,'KO1809170002','-','2017-08-22',1570000,'Keluar','Setoran Bank',''),
(1031,'KO1809170002','-','2017-08-22',3840000,'Masuk','BSTUM 003010-003011/Heri 28 K',''),
(1032,'KO1809170002','-','2017-08-22',2060000,'Masuk','BSTUM 003012/Imam 15 K',''),
(1033,'KO1809170002','-','2017-08-22',130000,'Keluar','BSTUK 002984/Komisi mingguan tyas 13 order',''),
(1034,'KO1809170002','-','2017-08-22',5750000,'Keluar','Setoran Bank',''),
(1035,'KO1809170002','-','2017-08-22',199000,'Masuk','BP 008679/Dwi/Lenny/Angsuran Fancy stove',''),
(1036,'KO1809170002','-','2017-08-23',2210000,'Masuk','BSTUM 003013-14/Imam 17 K',''),
(1037,'KO1809170002','-','2017-08-23',139000,'Masuk','BP 008577/Navi/Indri/Angsuran Ez Blend',''),
(1038,'KO1809170002','-','2017-08-23',80000,'Keluar','BSTUK 002985/Komisi mingguan indri 8 order',''),
(1039,'KO1809170002','-','2017-08-23',1550000,'Keluar','Setoran Bank',''),
(1040,'KO1809170002','-','2017-08-23',139000,'Masuk','BP 008680/Yanti/Lenny/Angsuran gridle',''),
(1041,'KO1809170002','-','2017-08-23',100000,'Masuk','BP 008681/Shendy/Lenny/Tunai griddle',''),
(1042,'KO1809170002','-','2017-08-23',139000,'Masuk','BP 008468/Mulyana/Lenny/Angsuran chopper 2 in 1',''),
(1043,'KO1809170002','-','2017-08-23',2500000,'Masuk','BSTUM 002986/Pelunasan order Ari',''),
(1044,'KO1809170002','-','2017-08-23',600000,'Keluar','BSTUK 002987/Komisi 20 % ari',''),
(1045,'KO1809170002','-','2017-08-24',2316000,'Keluar','Setoran Bank',''),
(1046,'KO1809170002','-','2017-08-24',1500000,'Masuk','BSTUM 003015/Imam 13 K',''),
(1047,'KO1809170002','-','2017-08-24',2995000,'Masuk','BSTUM 003016-14/Heri 24 K',''),
(1048,'KO1809170002','-','2017-08-24',200000,'Masuk','BP 010802/Marni/Tyas/Tunai chopper',''),
(1049,'KO1809170002','-','2017-08-24',200000,'Masuk','BP 0010801/Ruri/Tyas/Tunai chopper',''),
(1050,'KO1809170002','-','2017-08-24',200000,'Masuk','BP 010803/Darmi/Tyas/Tunai chopper',''),
(1051,'KO1809170002','-','2017-08-24',100000,'Masuk','BP 010805/Rina/Tressye/Tunai chopper',''),
(1052,'KO1809170002','-','2017-08-24',100000,'Masuk','BP 010804/Nanik/Tressye/Tunai chopper',''),
(1053,'KO1809170002','-','2017-08-24',150000,'Masuk','BP 008683/Aniati/Lenny/Tunai chopper 2 in 1',''),
(1054,'KO1809170002','-','2017-08-24',80000,'Keluar','BSTUK 002988/Komisi mingguan tuti 8 order',''),
(1055,'KO1809170002','-','2017-08-24',5350000,'Keluar','Setoran Bank',''),
(1056,'KO1809170002','-','2017-08-24',250000,'Masuk','BSTUM 002989/Penambahan DP chopper 10805 & 10804',''),
(1057,'KO1809170002','-','2017-08-24',229000,'Masuk','BP 008467/Siti/Tuti/Angsuran Presto elektrik',''),
(1058,'KO1809170002','-','2017-08-24',100000,'Masuk','BP 008682/Suyati/Tuti/Tunai chopper 2 in 1',''),
(1059,'KO1809170002','-','2017-08-24',290000,'Masuk','BP 008578/Wahyu/Indri/Angsuran noodle',''),
(1060,'KO1809170002','-','2017-08-24',700000,'Masuk','BSTUM 002990/Pelunasan order Ari',''),
(1061,'KO1809170002','-','2017-08-25',800000,'Masuk','Supply Kas Pusat Ke Kas Operasional',''),
(1062,'KO1809170002','-','2017-08-25',800000,'Keluar','Supply Kas Pusat Ke Kas Operasional',''),
(1063,'KO1809170002','-','2017-08-25',1584000,'Keluar','Setoran Bank',''),
(1064,'KO1809170002','-','2017-08-25',1200000,'Masuk','BSTUM 002991/Pelunasan order Ning',''),
(1065,'KO1809170002','-','2017-08-25',229000,'Masuk','BP 008424/Pin/Tressye/Angsuran Presto elektrik',''),
(1066,'KO1809170002','-','2017-08-25',150000,'Masuk','BP 008423/Wahyu/Tressye/Angsuran chopper + gridle',''),
(1067,'KO1809170002','-','2017-08-25',150000,'Masuk','BP 008422/Umi/Tyas/Angsuran chopper + gridle',''),
(1068,'KO1809170002','-','2017-08-25',400000,'Masuk','BP 010811/Lastri/Tyas/Tunai presto elektrik',''),
(1069,'KO1809170002','-','2017-08-25',100000,'Masuk','BP 008684/Yuni/Lenny/Tunai chopper 2 in 1',''),
(1070,'KO1809170002','-','2017-08-25',100000,'Masuk','BP 008685/Halim/Tuti/Tunai chopper 2 in 1',''),
(1071,'KO1809170002','-','2017-08-25',100000,'Masuk','BP 005048/Asih/Tuti/Tunai chopper 2 in 2',''),
(1072,'KO1809170002','-','2017-08-25',2495000,'Masuk','BSTUM 003018-19/Heri 14 K',''),
(1073,'KO1809170002','-','2017-08-25',2740000,'Masuk','BSTUM 003020-21/Imam 21 K',''),
(1074,'KO1809170002','-','2017-08-25',7650000,'Keluar','Setoran Bank',''),
(1075,'KO1809170002','-','2017-08-25',750000,'Masuk','BSTUM 002995/Pelunasan order ari',''),
(1076,'KO1809170002','-','2017-08-25',120000,'Keluar','BSTUK 002993/Komisi mingguan indri 12 order',''),
(1077,'KO1809170002','-','2017-08-25',60000,'Keluar','BSTUK 002994/Um driver nano 21-26 ags',''),
(1078,'KO1809170002','-','2017-08-26',1960000,'Masuk','BSTUM 003022-23/Heri19 K',''),
(1079,'KO1809170002','-','2017-08-26',2000000,'Masuk','BSTUM 003024/Imam 15 K',''),
(1080,'KO1809170002','-','2017-08-26',150000,'Keluar','BSTUK 002995/Bbm Imam 21-26 ags',''),
(1081,'KO1809170002','-','2017-08-26',4360000,'Keluar','Setoran Bank',''),
(1082,'KO1809170002','-','2017-08-26',100000,'Masuk','BP 008686/Wahyu/Lenny/Tunai chopper 2 in 1',''),
(1083,'KO1809170002','-','2017-08-26',100000,'Masuk','BP 008687/Imed/Lenny/Tunai chopper 2 in 1',''),
(1084,'KO1809170002','-','2017-08-28',70000,'Keluar','BSTUK 002996/Um driver agung 21-27 Ags',''),
(1085,'KO1809170002','-','2017-08-28',500000,'Masuk','Supply Kas Pusat Ke Kas Operasional',''),
(1086,'KO1809170002','-','2017-08-28',500000,'Keluar','Supply Kas Pusat Ke Kas Operasional',''),
(1087,'KO1809170002','-','2017-08-28',159000,'Masuk','BP 08582/Irma/Indri/Angsuran fancy 8 set',''),
(1088,'KO1809170002','-','2017-08-28',329000,'Masuk','BP 008580/Asti/Indri/Angsuran noodle',''),
(1089,'KO1809170002','-','2017-08-28',329000,'Masuk','BP 008581/Candra/Indri/Angsuran noodle',''),
(1090,'KO1809170002','-','2017-08-28',329000,'Masuk','BP 008579/Eny/Indri/Angsuran chopper',''),
(1091,'KO1809170002','-','2017-08-28',129000,'Masuk','BP 010809/Endah/Tyas/Angsuran chopper',''),
(1092,'KO1809170002','-','2017-08-28',950500,'Keluar','BSTUK 002997/Dinas Perjalanan Pak Sodikin',''),
(1093,'KO1809170002','-','2017-08-28',329000,'Masuk','BP 008575/Cusiah/Indri/Angsuran noodle',''),
(1094,'KO1809170002','-','2017-08-28',800000,'Masuk','BSTUM 002997/Pelunasan order ning',''),
(1095,'KO1809170002','-','2017-08-28',300000,'Keluar','BSTUK 002998/Komisi 20 % ning',''),
(1096,'KO1809170002','-','2017-08-28',100000,'Masuk','BP 005050/Siti/Tuti/Tunai chopper 2 in 1',''),
(1097,'KO1809170002','-','2017-08-28',1505000,'Masuk','BSTUM 003027/Imam 12 K',''),
(1098,'KO1809170002','-','2017-08-28',2630000,'Masuk','BSTUM 003025-26/Heri 20 K',''),
(1099,'KO1809170002','-','2017-08-28',6450000,'Keluar','Setoran Bank',''),
(1100,'KO1809170002','-','2017-08-28',150000,'Masuk','BP 008425/Susila/Tressye/Angsuran chopper + gridle',''),
(1101,'KO1809170002','-','2017-08-28',2600000,'Masuk','BSTUM 003000/Pelunasan order Ari',''),
(1102,'KO1809170002','-','2017-08-28',290000,'Keluar','BSTUK 002999/Komisi mingguan lenny 29 order',''),
(1103,'KO1809170002','-','2017-08-28',90000,'Keluar','BSTUK 002999/bonus tambahan chopper 2 in 1 ( 9 order )',''),
(1104,'KO1809170002','-','2017-08-29',2372500,'Keluar','Setoran Bank',''),
(1105,'KO1809170002','-','2017-08-29',4200000,'Masuk','Supply Pusat ( Komisi Sawulan Ketupat )',''),
(1106,'KO1809170002','-','2017-08-29',2700000,'Masuk','Supply Pusat ( Komisi Lunas )',''),
(1107,'KO1809170002','-','2017-08-29',2700000,'Masuk','BSTUM 003029-30/Imam 20 K',''),
(1108,'KO1809170002','-','2017-08-29',1925000,'Masuk','BSTUM 003028/Heri 17 K',''),
(1109,'KO1809170002','-','2017-08-29',650000,'Masuk','BSTUM 003051/Pelunasan Order lenny',''),
(1110,'KO1809170002','-','2017-08-29',1290000,'Masuk','BSTUM 003055/Pelunasan Order tresye',''),
(1111,'KO1809170002','-','2017-08-29',150000,'Keluar','BSTUK 003054/Komisi 20 % lenny',''),
(1112,'KO1809170002','-','2017-08-29',630000,'Keluar','BSTUK 003056/Komisi 20 % tressye',''),
(1113,'KO1809170002','-','2017-08-29',4200000,'Keluar','Komisi sawulan ketupat sales',''),
(1114,'KO1809170002','-','2017-08-29',4522500,'Keluar','Komisi Lunas Sales Ags',''),
(1115,'KO1809170002','-','2017-08-29',52500,'Keluar','BSTUM 86281385/Pulsa paket XL',''),
(1116,'KO1809170002','-','2017-08-29',3900000,'Keluar','Setoran Bank',''),
(1117,'KO1809170002','-','2017-08-29',229000,'Masuk','BP 008585/Siti/Indri/Angsuran presto elektrik',''),
(1118,'KO1809170002','-','2017-08-29',229000,'Masuk','BP 008583/Dina/Indri/Angsuran presto elektrik',''),
(1119,'KO1809170002','-','2017-08-30',100000,'Masuk','BP 008689/Siti/Lenny/Tunai chopper 2 in 1',''),
(1120,'KO1809170002','-','2017-08-30',100000,'Masuk','BP 008688/Umi/Lenny/Tunai chopper 2 in 1',''),
(1121,'KO1809170002','-','2017-08-30',100000,'Masuk','BP 008691/Tuti/Lastri/Tunai chopper 2 in 1',''),
(1122,'KO1809170002','-','2017-08-30',3500000,'Masuk','BSTUM 003031-3032/Imam 28 K',''),
(1123,'KO1809170002','-','2017-08-30',2880000,'Masuk','BSTUM 0030033-3034/Heri 22 K',''),
(1124,'KO1809170002','-','2017-08-30',650000,'Masuk','BSTUM 003058/Pelunasan order lenny',''),
(1125,'KO1809170002','-','2017-08-30',150000,'Keluar','BSTUK 003059/Komisi 20 % lenny',''),
(1126,'KO1809170002','-','2017-08-30',850000,'Keluar','BSTUK 003060/Pembayaran paket UPS',''),
(1127,'KO1809170002','-','2017-08-30',6790000,'Keluar','Setoran Bank',''),
(1128,'KO1809170002','-','2017-08-01',3735500,'Masuk','Saldo Pindahan',''),
(1129,'KO1809170002','-','2017-08-01',3685500,'Keluar','Setoran Bank',''),
(1130,'KO1809170002','-','2017-08-01',2150000,'Masuk','BSTUM 002863/Pelunasan order indri',''),
(1131,'KO1809170002','-','2017-08-01',630000,'Keluar','BSTUK 002864/Komisi 20 % indri',''),
(1132,'KO1809170002','-','2017-08-01',1800000,'Masuk','BSTUM 002865/Pelunasan order Tuti',''),
(1133,'KO1809170002','-','2017-08-01',1050000,'Masuk','BSTUM 002867/Pelunasan orer lenny',''),
(1134,'KO1809170002','-','2017-08-01',550000,'Keluar','BSTUK 002866/Komisi 20 % tuti dan lenny',''),
(1135,'KO1809170002','-','2017-08-01',3780000,'Keluar','Setoran Bank',''),
(1136,'KO1809170002','-','2017-08-01',100000,'Masuk','BP 008652/Tumini/Lenny/Tunai chopper',''),
(1137,'KO1809170002','-','2017-08-01',159000,'Masuk','BP 008654/Ida/Lenny/Angsuran fancy 8 set',''),
(1138,'KO1809170002','-','2017-08-01',380000,'Masuk','BSTUM 002824/Imam 3 K',''),
(1139,'KO1809170002','-','2017-08-02',250000,'Masuk','BSTUM 002825/Imam 2 K',''),
(1140,'KO1809170002','-','2017-08-02',90000,'Keluar','BSTUK 54013-0208 Paket Baraka Jogja',''),
(1141,'KO1809170002','-','2017-08-02',80000,'Keluar','BSTUK 002868/Um driver agung 24-31 Jul',''),
(1142,'KO1809170002','-','2017-08-02',700000,'Keluar','Setoran Bank',''),
(1143,'KO1809170002','-','2017-08-02',500000,'Masuk','BP 008455/Hayati/Tuti/Tunai chopper ( Herpus )',''),
(1144,'KO1809170002','-','2017-08-02',100000,'Masuk','BP 008456/Herni/Tuti/Tunai chopper',''),
(1145,'KO1809170002','-','2017-08-02',100000,'Masuk','BP 008457/Kus/Tuti/Tunai chopper',''),
(1146,'KO1809170002','-','2017-08-02',150000,'Masuk','BP 008402/Sumiyati/Tyas/Angsuran chopper + gridle',''),
(1147,'KO1809170002','-','2017-08-02',550000,'Masuk','BSTUM 002869/Pelunasan order tuti',''),
(1148,'KO1809170002','-','2017-08-02',150000,'Keluar','BSTUK 002870/Komisi 20 % tuti',''),
(1149,'KO1809170002','-','2017-08-02',485000,'Keluar','BSTUK 002871/Bbm kolektor Heri 21 hari',''),
(1150,'KO1809170002','-','2017-08-02',65000,'Keluar','BSTUK 002871/Komisi mingguan heri',''),
(1151,'KO1809170002','-','2017-08-03',1100000,'Masuk','Supply Kas Pusat Ke Kas Operasional',''),
(1152,'KO1809170002','-','2017-08-03',1100000,'Keluar','Supply Kas Pusat Ke Kas Operasional',''),
(1153,'KO1809170002','-','2017-08-03',950000,'Masuk','BSTUM 002826/Imam 8 K',''),
(1154,'KO1809170002','-','2017-08-03',509000,'Keluar','Biaya Reimbursment Pak Sodikin',''),
(1155,'KO1809170002','-','2017-08-03',1200000,'Keluar','Setoran Bank',''),
(1156,'KO1809170002','-','2017-08-03',100000,'Masuk','BP 007716/Iwan/Yayuk/Tunai chopper',''),
(1157,'KO1809170002','-','2017-08-03',100000,'Masuk','BP 007715/Gatot/Yayuk/Tunai griddle',''),
(1158,'KO1809170002','-','2017-08-03',100000,'Masuk','BP 008658/Retno/Lenny/Tunai chopper',''),
(1159,'KO1809170002','-','2017-08-03',100000,'Masuk','BP 008657/Dwi Budi/Lenny/Tunai chopper',''),
(1160,'KO1809170002','-','2017-08-03',100000,'Masuk','BP 008655/Inaya/Lenny/Tunai chopper',''),
(1161,'KO1809170002','-','2017-08-03',219000,'Masuk','BP 008408/Rona Yuli/Tressye/Angsuran Fancy 8 set + chopper',''),
(1162,'KO1809170002','-','2017-08-03',219000,'Masuk','BP 008409/Isaman/Tresye/Angsuran Fancy 8 set + chopper',''),
(1163,'KO1809170002','-','2017-08-03',219000,'Masuk','BP 008405/Tatik/Tyas/Fancy 8 set + chopper',''),
(1164,'KO1809170002','-','2017-08-03',129000,'Masuk','BP 008404/Yuli/Tyas/Angsuran chopper',''),
(1165,'KO1809170002','-','2017-08-03',1450000,'Masuk','BSTUM 002872/Pelunasan Order lenny',''),
(1166,'KO1809170002','-','2017-08-03',450000,'Keluar','BSTUK 002873/Komisi 20 % lenny',''),
(1167,'KO1809170002','-','2017-08-04',2286000,'Keluar','Setoran Bank',''),
(1168,'KO1809170002','-','2017-08-04',330000,'Masuk','BSTUM 002827/Imam 2 K',''),
(1169,'KO1809170002','-','2017-08-04',100000,'Masuk','BP 007720/Suep/Yayuk/Tunai chopper',''),
(1170,'KO1809170002','-','2017-08-04',189000,'Masuk','BP 007719/Ita/Totok/Angsuran gridle + fancy 8 set',''),
(1171,'KO1809170002','-','2017-08-04',100000,'Masuk','BP 007721/Fitri/Yayuk/Tunai gridle',''),
(1172,'KO1809170002','-','2017-08-04',650000,'Masuk','BSTUM 002876/Pelunasan order tuti',''),
(1173,'KO1809170002','-','2017-08-04',150000,'Keluar','BSTUK 002878/Komisi 20 % tuti',''),
(1174,'KO1809170002','-','2017-08-04',240000,'Keluar','BSTUK 002877/Komisi mingguan lenny 24 order',''),
(1175,'KO1809170002','-','2017-08-04',50000,'Keluar','BSTUK 002875/Um driver Tarjo 1-5 Ags',''),
(1176,'KO1809170002','-','2017-08-04',70000,'Keluar','BSTUK 002874/Komisi mingguan yayuk 7 Order',''),
(1177,'KO1809170002','-','2017-08-04',20000,'Keluar','BSTUK 002874/Komisi mingguan totok 2 order',''),
(1178,'KO1809170002','-','2017-08-04',70000,'Keluar','BSTUK 002874/Komisi mingguan anik 7 order',''),
(1179,'KO1809170002','-','2017-08-04',140000,'Keluar','BSTUK 002879/Komisi mingguan indri 14 order',''),
(1180,'KO1809170002','-','2017-08-05',705000,'Masuk','BSTUM 002828/Imam 6 K',''),
(1181,'KO1809170002','-','2017-08-05',25000000,'Masuk','Supply Pusat ( Salary staff dan Komisi Sales )',''),
(1182,'KO1809170002','-','2017-08-05',16600000,'Keluar','Salary Staff Smr',''),
(1183,'KO1809170002','-','2017-08-05',9070100,'Keluar','Salary Sales ',''),
(1184,'KO1809170002','-','2017-08-05',60000,'Keluar','BSTUK 002879/Um driver Nano 31 Jul - 5 Ags',''),
(1185,'KO1809170002','-','2017-08-05',300000,'Masuk','BSTUM 002882/Angsuran KIT Chopper',''),
(1186,'KO1809170002','-','2017-08-05',100000,'Keluar','BSTUK 002884/Komisi mingguan tuti 10 Order',''),
(1187,'KO1809170002','-','2017-08-05',129000,'Masuk','BP 008458/Suraniningsih/Tuti/Angsuran chopper',''),
(1188,'KO1809170002','-','2017-08-05',129000,'Masuk','BP 008459/Sri Suwarti/Tuti/Angsuran chopper',''),
(1189,'KO1809170002','-','2017-08-05',129000,'Masuk','BP 008460/Sri Lestari/Tuti/Angsuran chopper',''),
(1190,'KO1809170002','-','2017-08-05',750000,'Masuk','BP 007599/Ristiyanti/Lenny/Tunai chopper',''),
(1191,'KO1809170002','-','2017-08-05',1300000,'Masuk','BSTUM 002883/Pelunasan order lenny',''),
(1192,'KO1809170002','-','2017-08-05',450000,'Keluar','BSTUK 002889/Komisi 20 % lenny',''),
(1193,'KO1809170002','-','2017-08-05',200000,'Masuk','BSTUM 002888/Penjualan Hp Inv Jogja ( Irpan )',''),
(1194,'KO1809170002','-','2017-08-05',200000,'Masuk','BSTUM 002888/Penjualan Hp Inv Smr ( Gito )',''),
(1195,'KO1809170002','-','2017-08-05',1350000,'Masuk','BSTUM 002887/Pelunasan order Ning',''),
(1196,'KO1809170002','-','2017-08-05',338000,'Keluar','BSTUK 002890/Komisi 20 % ning',''),
(1197,'KO1809170002','-','2017-08-05',4200000,'Keluar','Setoran Bank',''),
(1198,'KO1809170002','-','2017-08-05',2680000,'Masuk','BSTUM 002892/Pelunasan Order Tresye',''),
(1199,'KO1809170002','-','2017-08-05',700000,'Masuk','BSTUM 002895/Pelunasan order wiwid',''),
(1200,'KO1809170002','-','2017-08-05',816000,'Keluar','BSTUK 002893/Komisi 20 % tresye',''),
(1201,'KO1809170002','-','2017-08-05',100000,'Keluar','BSTUK 002893/Komisi tambahan alsyva',''),
(1202,'KO1809170002','-','2017-08-05',300000,'Keluar','BSTUK 002896/Komisi 20 % wiwid',''),
(1203,'KO1809170002','-','2017-08-05',200000,'Masuk','BSTUM 002829/Imam 2 K',''),
(1204,'KO1809170002','-','2017-08-07',1916900,'Keluar','Setoran Bank',''),
(1205,'KO1809170002','-','2017-08-07',1000000,'Masuk','Supply Kas Pusat Ke Kas Operasional',''),
(1206,'KO1809170002','-','2017-08-07',1000000,'Keluar','Supply Kas Pusat Ke Kas Operasional',''),
(1207,'KO1809170002','-','2017-08-07',329000,'Masuk','BP 008410/Lis/Tyas/Angsuran noodle',''),
(1208,'KO1809170002','-','2017-08-07',1185000,'Masuk','BSTUM 002830/Imam 10 K',''),
(1209,'KO1809170002','-','2017-08-07',350000,'Masuk','BSTUK 002831/Angsuran 3 K',''),
(1210,'KO1809170002','-','2017-08-07',200000,'Masuk','BSTUM 002898/Tambahan DP 007611 a,n Suwarni',''),
(1211,'KO1809170002','-','2017-08-07',60000,'Keluar','BSTUK 002897/Bbm Imam 3Ags/5-7 Ags',''),
(1212,'KO1809170002','-','2017-08-07',300000,'Keluar','BSTUK 002899/Iuran Warga 17 Agustus',''),
(1213,'KO1809170002','-','2017-08-07',150000,'Keluar','BSTUK 002898/Komisi mingguan tresye 15 order',''),
(1214,'KO1809170002','-','2017-08-07',1500000,'Keluar','Setoran Bank',''),
(1215,'KO1809170002','-','2017-08-07',390000,'Masuk','BSTUM 002832/Heri 3 K',''),
(1216,'KO1809170002','-','2017-08-07',150000,'Masuk','BSTUM 002833/Imam 1 K',''),
(1217,'KO1809170002','-','2017-08-08',1135000,'Masuk','BSTUM 002834/Imam 8 K',''),
(1218,'KO1809170002','-','2017-08-08',1650000,'Masuk','BSTUM 002835/Heri 10 K',''),
(1219,'KO1809170002','-','2017-08-08',242500,'Keluar','BSTUK 002910/Per Dinas P\'Gito Pkg 9-12 Ags',''),
(1220,'KO1809170002','-','2017-08-08',3100000,'Keluar','Setoran Bank',''),
(1221,'KO1809170002','-','2017-08-08',1000000,'Masuk','BSTUM 002912/Pelunasan order tresye',''),
(1222,'KO1809170002','-','2017-08-08',250000,'Keluar','BSTUK 002913/Komisi 20 % tresye',''),
(1223,'KO1809170002','-','2017-08-09',436500,'Keluar','BSTUK 002914/Dinas Perj Pak Sodikin Jogja 7-8 Ags',''),
(1224,'KO1809170002','-','2017-08-09',1000000,'Masuk','Supply Kas Pusat Ke Kas Operasional',''),
(1225,'KO1809170002','-','2017-08-09',1000000,'Keluar','Supply Kas Pusat Ke Kas Operasional',''),
(1226,'KO1809170002','-','2017-08-09',229000,'Masuk','BP 008568/Rini/Indri/Angsuran Presto elektrik',''),
(1227,'KO1809170002','-','2017-08-09',229000,'Masuk','BP 008566/Aneng/Indri/Angsuran Presto elektrik',''),
(1228,'KO1809170002','-','2017-08-09',329000,'Masuk','BP 008567/Edy/Indri/Angsuran Noodle',''),
(1229,'KO1809170002','-','2017-08-09',199000,'Masuk','BP 008565/Tien/Indri/Angsuran Fancy Stove',''),
(1230,'KO1809170002','-','2017-08-09',87500,'Keluar','BSTUK-840710175317 Pembelian Tiket KA PP Smr-Pkg P\'Sodikin',''),
(1231,'KO1809170002','-','2017-08-09',4590000,'Masuk','BSTUM 002836-37/Heri 25 K',''),
(1232,'KO1809170002','-','2017-08-09',1145000,'Masuk','BSTUM 002838/Imam 9 K',''),
(1233,'KO1809170002','-','2017-08-09',94500,'Keluar','BSTUK 002915/Pembeliak Atk kantor',''),
(1234,'KO1809170002','-','2017-08-09',300000,'Masuk','BP 008169/Tyas/Anik/Tunai chopper',''),
(1235,'KO1809170002','-','2017-08-09',50000,'Keluar','BSTUK 002916/Service Mobil ( Las Knalpot Mobil Agung )',''),
(1236,'KO1809170002','-','2017-08-09',7350000,'Keluar','Setoran Bank',''),
(1237,'KO1809170002','-','2017-08-09',150000,'Masuk','BP 005737/Diah/Tuti/Angsuran chopper + gridle',''),
(1238,'KO1809170002','-','2017-08-09',139000,'Masuk','BP 005739/Saum/Lenny/Angsuran gridle',''),
(1239,'KO1809170002','-','2017-08-09',150000,'Masuk','BP 005738/Yuni/Lenny/Angsuran chopper + gridle',''),
(1240,'KO1809170002','-','2017-08-09',50000,'Keluar','BSTUK 002917/Um driver Tarjo 6-10 Ags','');

/*Table structure for table `kas_besar_detail_temp` */

DROP TABLE IF EXISTS `kas_besar_detail_temp`;

CREATE TABLE `kas_besar_detail_temp` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `kodekas` varchar(30) NOT NULL,
  `kodekasmanual` varchar(50) NOT NULL DEFAULT '-',
  `tanggal` varchar(30) NOT NULL,
  `total` int(10) NOT NULL,
  `jeniskas` varchar(20) NOT NULL,
  `uraian` text,
  `kodeakun` varchar(15) NOT NULL,
  PRIMARY KEY (`id`,`kodekas`)
) ENGINE=InnoDB AUTO_INCREMENT=1241 DEFAULT CHARSET=latin1;

/*Data for the table `kas_besar_detail_temp` */

insert  into `kas_besar_detail_temp`(`id`,`kodekas`,`kodekasmanual`,`tanggal`,`total`,`jeniskas`,`uraian`,`kodeakun`) values 
(890,'KO1809170002','-','2017-08-10',6750000,'Masuk','BSTUM 002918/Pelunasan order ning',''),
(891,'KO1809170002','-','2017-08-10',1500000,'Keluar','BSTUK 002919/Komisi 20 % ning',''),
(892,'KO1809170002','-','2017-08-10',3775000,'Masuk','BSTUM 002839-40/Heri 16 K',''),
(893,'KO1809170002','-','2017-08-10',240000,'Keluar','BSTUK 002920/Komisi 20 % lenny',''),
(894,'KO1809170002','-','2017-08-10',9200000,'Keluar','Setoran Bank',''),
(895,'KO1809170002','-','2017-08-10',100000,'Masuk','BP 008411/Afri/Tyas/Tunai chopper 2 in 1',''),
(896,'KO1809170002','-','2017-08-10',199000,'Masuk','BP 007649/Ricco/Tyas/Angsuran fancy stove',''),
(897,'KO1809170002','-','2017-08-10',199000,'Masuk','BP 008412/Betty/Tyas/Tunai Fancy stove',''),
(898,'KO1809170002','-','2017-08-10',200000,'Masuk','BP 008407/Ratna/Tyas/Tunai presto elektrik',''),
(899,'KO1809170002','-','2017-08-11',300000,'Keluar','BSTUK 002921/Santunan Kematian ( keluarga sales )',''),
(900,'KO1809170002','-','2017-08-11',229000,'Masuk','BP 008413/Narti/Tyas/Angsuran elektrik presto',''),
(901,'KO1809170002','-','2017-08-11',1400000,'Masuk','BSTUM 002841/Imam 12 K',''),
(902,'KO1809170002','-','2017-08-11',1155000,'Masuk','BSTUM 002842/Heri 10 K',''),
(903,'KO1809170002','-','2017-08-11',229000,'Masuk','BP 008571/Agustin/Indri/Tunai Presto Elektrik',''),
(904,'KO1809170002','-','2017-08-11',199000,'Masuk','BP 008570/Retno/Indri/Tuai Fancy Stove',''),
(905,'KO1809170002','-','2017-08-11',4900000,'Masuk','Supply Pusat ( Komisi Staff )',''),
(906,'KO1809170002','-','2017-08-11',4930905,'Keluar','Komisi Staff Smr',''),
(907,'KO1809170002','-','2017-08-11',3650000,'Keluar','Setoran Bank',''),
(908,'KO1809170002','-','2017-08-11',400000,'Masuk','BP 008351/Lany/Tressye/Tunai Noodle',''),
(909,'KO1809170002','-','2017-08-11',150000,'Masuk','BP 008707/Sorutun/Tuti/Angsuran chopper',''),
(910,'KO1809170002','-','2017-08-11',129000,'Masuk','BP 008663/Ainun/Lenny/Angsuran chopper',''),
(911,'KO1809170002','-','2017-08-11',150000,'Masuk','BP 008671/Narni/Lenny/Angsuran chopper + gridle',''),
(912,'KO1809170002','-','2017-08-11',150000,'Masuk','BP 008706/Putri/Tuti/Angsuran chopper + gridle',''),
(913,'KO1809170002','-','2017-08-11',750000,'Masuk','BP 008702/Ari/Tuti/Tunai chopper',''),
(914,'KO1809170002','-','2017-08-11',750000,'Masuk','BP 008701/Endah/Tuti/Tunai chopper',''),
(915,'KO1809170002','-','2017-08-11',750000,'Masuk','BP 008703/Sari/Tuti/Tunai chopper',''),
(916,'KO1809170002','-','2017-08-11',750000,'Masuk','BP 008704/Rini/Tuti/Tunai chopper',''),
(917,'KO1809170002','-','2017-08-11',750000,'Masuk','BP 008705/Atik/Tuti/Tunai chopper',''),
(918,'KO1809170002','-','2017-08-11',750000,'Masuk','BP 008665/Widya/Lenny/Tunai chopper',''),
(919,'KO1809170002','-','2017-08-11',750000,'Masuk','BP 008666/Arum/Lenny/Tunai chopper',''),
(920,'KO1809170002','-','2017-08-11',750000,'Masuk','BP 008667/Oky/Lenny/Tunai chopper',''),
(921,'KO1809170002','-','2017-08-11',750000,'Masuk','BP 008668/Tuti/Lenny/Tunai chopper',''),
(922,'KO1809170002','-','2017-08-11',750000,'Masuk','BP 008669/Mus/Lenny/Tunai chopper',''),
(923,'KO1809170002','-','2017-08-11',750000,'Masuk','BP 008665/Widya/Lenny/Tunai chopper',''),
(924,'KO1809170002','-','2017-08-11',1650000,'Keluar','BSTUK 002924/Komisi 20 % lenny dan tuti',''),
(925,'KO1809170002','-','2017-08-11',150000,'Keluar','BSTUK 002925/Dinas Perj Agung ( ambil chopper Pkg )',''),
(926,'KO1809170002','-','2017-08-11',621000,'Masuk','BSTUM 002922/Pelunasan order tui ( jogja )',''),
(927,'KO1809170002','-','2017-08-11',150000,'Keluar','BSTUK 002923/Komisi 20 % chopper',''),
(928,'KO1809170002','-','2017-08-11',100000,'Keluar','BSTUK 002926/Dinas Perjalanan P\'Sodikin Pkg',''),
(929,'KO1809170002','-','2017-08-11',50000,'Masuk','BSTUM 002927/Sisa Dinas Perj P\'Gito',''),
(930,'KO1809170002','-','2017-08-11',7950000,'Keluar','Setoran Bank',''),
(931,'KO1809170002','-','2017-08-12',1795000,'Masuk','BSTUM 002843-44/Imam 17 K',''),
(932,'KO1809170002','-','2017-08-12',8000000,'Masuk','Supply Pusat ( Komisi A1 dan Sawulan Sales )',''),
(933,'KO1809170002','-','2017-08-12',6535500,'Keluar','Komisi A1 Sales',''),
(934,'KO1809170002','-','2017-08-12',2176300,'Keluar','Komisi Sawulan Sales',''),
(935,'KO1809170002','-','2017-08-12',1100000,'Keluar','Setoran Bank',''),
(936,'KO1809170002','-','2017-08-12',650000,'Masuk','BSTUM 002936/Pelunasan order lenny',''),
(937,'KO1809170002','-','2017-08-12',150000,'Keluar','BSTUK 002937/Komisi 20 % lenny',''),
(938,'KO1809170002','-','2017-08-12',1860000,'Masuk','BSTUM 002938/Pelunasan order tuti',''),
(939,'KO1809170002','-','2017-08-12',450000,'Keluar','BSTUK 002939/Komisi 20 % tuti',''),
(940,'KO1809170002','-','2017-08-14',1000000,'Masuk','Supply Kas Pusat Ke Kas Operasional',''),
(941,'KO1809170002','-','2017-08-14',1000000,'Keluar','Supply Kas Pusat Ke Kas Operasional',''),
(942,'KO1809170002','-','2017-08-14',300000,'Masuk','BSTUM 002940/Angsuran mobil ( agung ) lunas',''),
(943,'KO1809170002','-','2017-08-14',1110000,'Keluar','Setoran Bank',''),
(944,'KO1809170002','-','2017-08-14',159000,'Masuk','BP 008572/Indri/Indri/Angsuran fancy 8 set',''),
(945,'KO1809170002','-','2017-08-14',1105000,'Masuk','BSTUM 002845/Imam 9 K',''),
(946,'KO1809170002','-','2017-08-14',1235000,'Masuk','BSTUM 002846/Heri 10 K',''),
(947,'KO1809170002','-','2017-08-14',1271000,'Masuk','BSTUM 002941/Pelunasan order indri',''),
(948,'KO1809170002','-','2017-08-14',300000,'Keluar','BSTUK 002942/Komisi 20 % indri',''),
(949,'KO1809170002','-','2017-08-14',135000,'Keluar','BSTUK 002944/Bbm kolektor Imam 7-12 Ags',''),
(950,'KO1809170002','-','2017-08-14',1075000,'Keluar','BSTUK 002945/Biaya Paket TNT ( spare part )',''),
(951,'KO1809170002','-','2017-08-14',550000,'Masuk','BSTUM 002946/Pelunasan order Tyas',''),
(952,'KO1809170002','-','2017-08-14',150000,'Keluar','BSTUK 002947/Komisi 20 % tyas',''),
(953,'KO1809170002','-','2017-08-14',392000,'Masuk','BP 008708/Agung/Gridle ( Lunas )',''),
(954,'KO1809170002','-','2017-08-14',1600000,'Masuk','BSTUM 002950/Pelunasan order tuti',''),
(955,'KO1809170002','-','2017-08-14',400000,'Keluar','BSTUK 002951/Komisi 20 % tuti',''),
(956,'KO1809170002','-','2017-08-14',139000,'Masuk','BP 008462/Agustina/Tuti/Angsuran chopper 2 in 1',''),
(957,'KO1809170002','-','2017-08-14',139000,'Masuk','BP 008464/Umi/Lenny/Angsuran Chopper 2 in 1',''),
(958,'KO1809170002','-','2017-08-14',400000,'Masuk','BP 008465/Amin/Tuti/Tunai chopper',''),
(959,'KO1809170002','-','2017-08-14',5925000,'Keluar','Setoran Bank',''),
(960,'KO1809170002','-','2017-08-14',1700000,'Masuk','BSTUM 002952/Pelunasan order lenny',''),
(961,'KO1809170002','-','2017-08-14',300000,'Keluar','BSTUK 002953/Komisi 20 % lenny',''),
(962,'KO1809170002','-','2017-08-15',2940000,'Masuk','BSTUM 002955/Pelunasan order Tressye',''),
(963,'KO1809170002','-','2017-08-15',768000,'Keluar','BSTUK 002957/Komisi 20 % tressye',''),
(964,'KO1809170002','-','2017-08-15',3577000,'Keluar','Setoran Bank',''),
(965,'KO1809170002','-','2017-08-15',5050000,'Masuk','BSTUM 002847-48/Heri 25 K',''),
(966,'KO1809170002','-','2017-08-15',500000,'Keluar','BSTUK 002959/Komisi 20 % Indri',''),
(967,'KO1809170002','-','2017-08-15',820000,'Keluar','BSTUK 002960/Pembelian ban B 1320 KMT ( 2 baru , 1 bekas )',''),
(968,'KO1809170002','-','2017-08-15',2250000,'Keluar','Komisi / Bonus Staff ( driver dan kolektor )',''),
(969,'KO1809170002','-','2017-08-15',3275000,'Masuk','BSTUM 002849-50/Imam 25 K',''),
(970,'KO1809170002','-','2017-08-15',60000,'Keluar','BSTUK 002962/Um driver Nano 7-12 Ags',''),
(971,'KO1809170002','-','2017-08-15',4650000,'Keluar','Setoran Bank',''),
(972,'KO1809170002','-','2017-08-15',150000,'Masuk','BP 008463/Asih/Tuti/Tunai chopper 2 in 1',''),
(973,'KO1809170002','-','2017-08-15',150000,'Masuk','BP 008672/Puji/Lenny/Tunai chopper 2 in 1',''),
(974,'KO1809170002','-','2017-08-16',329000,'Masuk','BP 008415/Yayuk/Tressye/Angsuran nodle',''),
(975,'KO1809170002','-','2017-08-16',150000,'Masuk','BP 008538/Ana/Tyas/Tunai gridle',''),
(976,'KO1809170002','-','2017-08-16',169000,'Masuk','BP 008539/Ton/Tressye/Angsuran tulip set',''),
(977,'KO1809170002','-','2017-08-16',169000,'Masuk','BP 008540/Mila/Tyas/Angsuran tulip set',''),
(978,'KO1809170002','-','2017-08-16',139000,'Masuk','BP 008675/Musnah/Tuti/Angsuran chopper 2 in 1',''),
(979,'KO1809170002','-','2017-08-16',139000,'Masuk','BP 008676/Dul/Lenny/Angsuran chopper 2 In 1',''),
(980,'KO1809170002','-','2017-08-16',139000,'Masuk','BP 008674/Kunardi/Lenny/Angsuran chopper 2 in 1',''),
(981,'KO1809170002','-','2017-08-16',139000,'Masuk','BP 008673/Yen/Tuti/Angsuran chopper 2 In 1',''),
(982,'KO1809170002','-','2017-08-16',1720000,'Masuk','BSTUM 003001/Imam 10 K',''),
(983,'KO1809170002','-','2017-08-16',3280000,'Masuk','BSTUM 003002-03/Heri 28 K',''),
(984,'KO1809170002','-','2017-08-16',200000,'Keluar','BSTUK 002967/Uang Tali kasih ( Bu yayuk )',''),
(985,'KO1809170002','-','2017-08-16',6518000,'Keluar','Setoran Bank',''),
(986,'KO1809170002','-','2017-08-16',800000,'Masuk','BSTUM 003004/Imam 8 K',''),
(987,'KO1809170002','-','2017-08-18',650000,'Keluar','BSTUK 002968/Service Mobil Agung ( radiator bocor )',''),
(988,'KO1809170002','-','2017-08-18',700000,'Masuk','Supply Kas Pusat Ke Kas Operasional',''),
(989,'KO1809170002','-','2017-08-18',700000,'Keluar','Supply Kas Pusat Ke Kas Operasional',''),
(990,'KO1809170002','-','2017-08-18',1380000,'Masuk','BSTUM 003005/Imam 13 K',''),
(991,'KO1809170002','-','2017-08-18',520000,'Keluar','Paket Baraka ( 20 presto , 36 gridle , kompor 10 )',''),
(992,'KO1809170002','-','2017-08-18',985000,'Keluar','Setoran Bank',''),
(993,'KO1809170002','-','2017-08-18',17000,'Keluar','Adm BCA',''),
(994,'KO1809170002','-','2017-08-18',850000,'Masuk','BSTUM 002969/Pelunasan order ari',''),
(995,'KO1809170002','-','2017-08-18',2200000,'Masuk','BSTUM 002972/Pelunasan order anik',''),
(996,'KO1809170002','-','2017-08-18',1900000,'Masuk','BSTUM 002973/Pelunasan order tresye',''),
(997,'KO1809170002','-','2017-08-18',300000,'Keluar','BSTUK 002974/Komisi 20 % tyas',''),
(998,'KO1809170002','-','2017-08-18',600000,'Keluar','BSTUK 002974/Komisi 20 % anik',''),
(999,'KO1809170002','-','2017-08-18',300000,'Keluar','BSTUK 002974/Komisi 20 % ari',''),
(1000,'KO1809170002','-','2017-08-18',1000000,'Masuk','BSTUM 002975/Pelunasan order tressye',''),
(1001,'KO1809170002','-','2017-08-18',300000,'Keluar','BSTUK 002976/Komisi 20 % tressye',''),
(1002,'KO1809170002','-','2017-08-18',1900000,'Masuk','BSTUM 0030006/Heri 13 K',''),
(1003,'KO1809170002','-','2017-08-19',50000,'Keluar','BSTUK 002971/Um driver Nano 14-19 Ags',''),
(1004,'KO1809170002','-','2017-08-19',60000,'Keluar','BSTUK 002970/Um driver tarjo 13-19 Ags',''),
(1005,'KO1809170002','-','2017-08-19',6240000,'Keluar','Setoran Bank',''),
(1006,'KO1809170002','-','2017-08-19',490000,'Masuk','BP 008576/Mia/Indri/Tunai griddle',''),
(1007,'KO1809170002','-','2017-08-19',159000,'Masuk','BP 008573/Lis/Indri/Angsuran fancy 8 set',''),
(1008,'KO1809170002','-','2017-08-19',139000,'Masuk','BP 008574/Nanik/Indri/Angsuran griddle',''),
(1009,'KO1809170002','-','2017-08-19',1420000,'Masuk','BSTUM 003007/Imam 11 K',''),
(1010,'KO1809170002','-','2017-08-19',160000,'Keluar','BSTUK 002977/Um driver agung 1-19 ags',''),
(1011,'KO1809170002','-','2017-08-19',150000,'Keluar','BSTUK 002978/Bbm kolektor imam 14-19 ags',''),
(1012,'KO1809170002','-','2017-08-19',98000,'Keluar','BSTUK 002979/Komisi 20 % indri',''),
(1013,'KO1809170002','-','2017-08-19',150000,'Masuk','BP 008417/Santi/Tyas/Tunai chopper',''),
(1014,'KO1809170002','-','2017-08-19',1950000,'Keluar','Setoran Bank',''),
(1015,'KO1809170002','-','2017-08-19',199000,'Masuk','BP 008416/Sumiyati/Tressye/Angsuran fancy stove',''),
(1016,'KO1809170002','-','2017-08-19',229000,'Masuk','BP 008541/Anik/Tressye/Angsuran presto elektrik',''),
(1017,'KO1809170002','-','2017-08-19',1800000,'Masuk','BSTUM 002980/Pelunasan Order Wiwid',''),
(1018,'KO1809170002','-','2017-08-21',2236000,'Keluar','Setoran Bank',''),
(1019,'KO1809170002','-','2017-08-21',1500000,'Masuk','Supply Kas Pusat Ke Kas Operasional',''),
(1020,'KO1809170002','-','2017-08-21',1500000,'Keluar','Supply Kas Pusat Ke Kas Operasional',''),
(1021,'KO1809170002','-','2017-08-21',100000,'Masuk','BP 008677/Heru/Tuti/Tunai chopper',''),
(1022,'KO1809170002','-','2017-08-21',200000,'Masuk','BP 008678/Sufi/Lenny/Tunai tulip 8 set',''),
(1023,'KO1809170002','-','2017-08-21',1410000,'Masuk','BSTUM 003008/Imam 10 K',''),
(1024,'KO1809170002','-','2017-08-21',1560000,'Masuk','BSTUM 002982/Pelunasan order lenny',''),
(1025,'KO1809170002','-','2017-08-21',3250000,'Keluar','Setoran Bank',''),
(1026,'KO1809170002','-','2017-08-21',200000,'Masuk','BP 008543/Novi/Tyas/Tunai presto elektrik',''),
(1027,'KO1809170002','-','2017-08-21',200000,'Masuk','BP 008542/Meilia/Tressye/Tunai presto elektrik',''),
(1028,'KO1809170002','-','2017-08-21',1250000,'Masuk','BSTUM 003009/Heri 10 K',''),
(1029,'KO1809170002','-','2017-08-21',100000,'Keluar','BSTUK 002983/Dinas Perj P\'Dikin Kudus',''),
(1030,'KO1809170002','-','2017-08-22',1570000,'Keluar','Setoran Bank',''),
(1031,'KO1809170002','-','2017-08-22',3840000,'Masuk','BSTUM 003010-003011/Heri 28 K',''),
(1032,'KO1809170002','-','2017-08-22',2060000,'Masuk','BSTUM 003012/Imam 15 K',''),
(1033,'KO1809170002','-','2017-08-22',130000,'Keluar','BSTUK 002984/Komisi mingguan tyas 13 order',''),
(1034,'KO1809170002','-','2017-08-22',5750000,'Keluar','Setoran Bank',''),
(1035,'KO1809170002','-','2017-08-22',199000,'Masuk','BP 008679/Dwi/Lenny/Angsuran Fancy stove',''),
(1036,'KO1809170002','-','2017-08-23',2210000,'Masuk','BSTUM 003013-14/Imam 17 K',''),
(1037,'KO1809170002','-','2017-08-23',139000,'Masuk','BP 008577/Navi/Indri/Angsuran Ez Blend',''),
(1038,'KO1809170002','-','2017-08-23',80000,'Keluar','BSTUK 002985/Komisi mingguan indri 8 order',''),
(1039,'KO1809170002','-','2017-08-23',1550000,'Keluar','Setoran Bank',''),
(1040,'KO1809170002','-','2017-08-23',139000,'Masuk','BP 008680/Yanti/Lenny/Angsuran gridle',''),
(1041,'KO1809170002','-','2017-08-23',100000,'Masuk','BP 008681/Shendy/Lenny/Tunai griddle',''),
(1042,'KO1809170002','-','2017-08-23',139000,'Masuk','BP 008468/Mulyana/Lenny/Angsuran chopper 2 in 1',''),
(1043,'KO1809170002','-','2017-08-23',2500000,'Masuk','BSTUM 002986/Pelunasan order Ari',''),
(1044,'KO1809170002','-','2017-08-23',600000,'Keluar','BSTUK 002987/Komisi 20 % ari',''),
(1045,'KO1809170002','-','2017-08-24',2316000,'Keluar','Setoran Bank',''),
(1046,'KO1809170002','-','2017-08-24',1500000,'Masuk','BSTUM 003015/Imam 13 K',''),
(1047,'KO1809170002','-','2017-08-24',2995000,'Masuk','BSTUM 003016-14/Heri 24 K',''),
(1048,'KO1809170002','-','2017-08-24',200000,'Masuk','BP 010802/Marni/Tyas/Tunai chopper',''),
(1049,'KO1809170002','-','2017-08-24',200000,'Masuk','BP 0010801/Ruri/Tyas/Tunai chopper',''),
(1050,'KO1809170002','-','2017-08-24',200000,'Masuk','BP 010803/Darmi/Tyas/Tunai chopper',''),
(1051,'KO1809170002','-','2017-08-24',100000,'Masuk','BP 010805/Rina/Tressye/Tunai chopper',''),
(1052,'KO1809170002','-','2017-08-24',100000,'Masuk','BP 010804/Nanik/Tressye/Tunai chopper',''),
(1053,'KO1809170002','-','2017-08-24',150000,'Masuk','BP 008683/Aniati/Lenny/Tunai chopper 2 in 1',''),
(1054,'KO1809170002','-','2017-08-24',80000,'Keluar','BSTUK 002988/Komisi mingguan tuti 8 order',''),
(1055,'KO1809170002','-','2017-08-24',5350000,'Keluar','Setoran Bank',''),
(1056,'KO1809170002','-','2017-08-24',250000,'Masuk','BSTUM 002989/Penambahan DP chopper 10805 & 10804',''),
(1057,'KO1809170002','-','2017-08-24',229000,'Masuk','BP 008467/Siti/Tuti/Angsuran Presto elektrik',''),
(1058,'KO1809170002','-','2017-08-24',100000,'Masuk','BP 008682/Suyati/Tuti/Tunai chopper 2 in 1',''),
(1059,'KO1809170002','-','2017-08-24',290000,'Masuk','BP 008578/Wahyu/Indri/Angsuran noodle',''),
(1060,'KO1809170002','-','2017-08-24',700000,'Masuk','BSTUM 002990/Pelunasan order Ari',''),
(1061,'KO1809170002','-','2017-08-25',800000,'Masuk','Supply Kas Pusat Ke Kas Operasional',''),
(1062,'KO1809170002','-','2017-08-25',800000,'Keluar','Supply Kas Pusat Ke Kas Operasional',''),
(1063,'KO1809170002','-','2017-08-25',1584000,'Keluar','Setoran Bank',''),
(1064,'KO1809170002','-','2017-08-25',1200000,'Masuk','BSTUM 002991/Pelunasan order Ning',''),
(1065,'KO1809170002','-','2017-08-25',229000,'Masuk','BP 008424/Pin/Tressye/Angsuran Presto elektrik',''),
(1066,'KO1809170002','-','2017-08-25',150000,'Masuk','BP 008423/Wahyu/Tressye/Angsuran chopper + gridle',''),
(1067,'KO1809170002','-','2017-08-25',150000,'Masuk','BP 008422/Umi/Tyas/Angsuran chopper + gridle',''),
(1068,'KO1809170002','-','2017-08-25',400000,'Masuk','BP 010811/Lastri/Tyas/Tunai presto elektrik',''),
(1069,'KO1809170002','-','2017-08-25',100000,'Masuk','BP 008684/Yuni/Lenny/Tunai chopper 2 in 1',''),
(1070,'KO1809170002','-','2017-08-25',100000,'Masuk','BP 008685/Halim/Tuti/Tunai chopper 2 in 1',''),
(1071,'KO1809170002','-','2017-08-25',100000,'Masuk','BP 005048/Asih/Tuti/Tunai chopper 2 in 2',''),
(1072,'KO1809170002','-','2017-08-25',2495000,'Masuk','BSTUM 003018-19/Heri 14 K',''),
(1073,'KO1809170002','-','2017-08-25',2740000,'Masuk','BSTUM 003020-21/Imam 21 K',''),
(1074,'KO1809170002','-','2017-08-25',7650000,'Keluar','Setoran Bank',''),
(1075,'KO1809170002','-','2017-08-25',750000,'Masuk','BSTUM 002995/Pelunasan order ari',''),
(1076,'KO1809170002','-','2017-08-25',120000,'Keluar','BSTUK 002993/Komisi mingguan indri 12 order',''),
(1077,'KO1809170002','-','2017-08-25',60000,'Keluar','BSTUK 002994/Um driver nano 21-26 ags',''),
(1078,'KO1809170002','-','2017-08-26',1960000,'Masuk','BSTUM 003022-23/Heri19 K',''),
(1079,'KO1809170002','-','2017-08-26',2000000,'Masuk','BSTUM 003024/Imam 15 K',''),
(1080,'KO1809170002','-','2017-08-26',150000,'Keluar','BSTUK 002995/Bbm Imam 21-26 ags',''),
(1081,'KO1809170002','-','2017-08-26',4360000,'Keluar','Setoran Bank',''),
(1082,'KO1809170002','-','2017-08-26',100000,'Masuk','BP 008686/Wahyu/Lenny/Tunai chopper 2 in 1',''),
(1083,'KO1809170002','-','2017-08-26',100000,'Masuk','BP 008687/Imed/Lenny/Tunai chopper 2 in 1',''),
(1084,'KO1809170002','-','2017-08-28',70000,'Keluar','BSTUK 002996/Um driver agung 21-27 Ags',''),
(1085,'KO1809170002','-','2017-08-28',500000,'Masuk','Supply Kas Pusat Ke Kas Operasional',''),
(1086,'KO1809170002','-','2017-08-28',500000,'Keluar','Supply Kas Pusat Ke Kas Operasional',''),
(1087,'KO1809170002','-','2017-08-28',159000,'Masuk','BP 08582/Irma/Indri/Angsuran fancy 8 set',''),
(1088,'KO1809170002','-','2017-08-28',329000,'Masuk','BP 008580/Asti/Indri/Angsuran noodle',''),
(1089,'KO1809170002','-','2017-08-28',329000,'Masuk','BP 008581/Candra/Indri/Angsuran noodle',''),
(1090,'KO1809170002','-','2017-08-28',329000,'Masuk','BP 008579/Eny/Indri/Angsuran chopper',''),
(1091,'KO1809170002','-','2017-08-28',129000,'Masuk','BP 010809/Endah/Tyas/Angsuran chopper',''),
(1092,'KO1809170002','-','2017-08-28',950500,'Keluar','BSTUK 002997/Dinas Perjalanan Pak Sodikin',''),
(1093,'KO1809170002','-','2017-08-28',329000,'Masuk','BP 008575/Cusiah/Indri/Angsuran noodle',''),
(1094,'KO1809170002','-','2017-08-28',800000,'Masuk','BSTUM 002997/Pelunasan order ning',''),
(1095,'KO1809170002','-','2017-08-28',300000,'Keluar','BSTUK 002998/Komisi 20 % ning',''),
(1096,'KO1809170002','-','2017-08-28',100000,'Masuk','BP 005050/Siti/Tuti/Tunai chopper 2 in 1',''),
(1097,'KO1809170002','-','2017-08-28',1505000,'Masuk','BSTUM 003027/Imam 12 K',''),
(1098,'KO1809170002','-','2017-08-28',2630000,'Masuk','BSTUM 003025-26/Heri 20 K',''),
(1099,'KO1809170002','-','2017-08-28',6450000,'Keluar','Setoran Bank',''),
(1100,'KO1809170002','-','2017-08-28',150000,'Masuk','BP 008425/Susila/Tressye/Angsuran chopper + gridle',''),
(1101,'KO1809170002','-','2017-08-28',2600000,'Masuk','BSTUM 003000/Pelunasan order Ari',''),
(1102,'KO1809170002','-','2017-08-28',290000,'Keluar','BSTUK 002999/Komisi mingguan lenny 29 order',''),
(1103,'KO1809170002','-','2017-08-28',90000,'Keluar','BSTUK 002999/bonus tambahan chopper 2 in 1 ( 9 order )',''),
(1104,'KO1809170002','-','2017-08-29',2372500,'Keluar','Setoran Bank',''),
(1105,'KO1809170002','-','2017-08-29',4200000,'Masuk','Supply Pusat ( Komisi Sawulan Ketupat )',''),
(1106,'KO1809170002','-','2017-08-29',2700000,'Masuk','Supply Pusat ( Komisi Lunas )',''),
(1107,'KO1809170002','-','2017-08-29',2700000,'Masuk','BSTUM 003029-30/Imam 20 K',''),
(1108,'KO1809170002','-','2017-08-29',1925000,'Masuk','BSTUM 003028/Heri 17 K',''),
(1109,'KO1809170002','-','2017-08-29',650000,'Masuk','BSTUM 003051/Pelunasan Order lenny',''),
(1110,'KO1809170002','-','2017-08-29',1290000,'Masuk','BSTUM 003055/Pelunasan Order tresye',''),
(1111,'KO1809170002','-','2017-08-29',150000,'Keluar','BSTUK 003054/Komisi 20 % lenny',''),
(1112,'KO1809170002','-','2017-08-29',630000,'Keluar','BSTUK 003056/Komisi 20 % tressye',''),
(1113,'KO1809170002','-','2017-08-29',4200000,'Keluar','Komisi sawulan ketupat sales',''),
(1114,'KO1809170002','-','2017-08-29',4522500,'Keluar','Komisi Lunas Sales Ags',''),
(1115,'KO1809170002','-','2017-08-29',52500,'Keluar','BSTUM 86281385/Pulsa paket XL',''),
(1116,'KO1809170002','-','2017-08-29',3900000,'Keluar','Setoran Bank',''),
(1117,'KO1809170002','-','2017-08-29',229000,'Masuk','BP 008585/Siti/Indri/Angsuran presto elektrik',''),
(1118,'KO1809170002','-','2017-08-29',229000,'Masuk','BP 008583/Dina/Indri/Angsuran presto elektrik',''),
(1119,'KO1809170002','-','2017-08-30',100000,'Masuk','BP 008689/Siti/Lenny/Tunai chopper 2 in 1',''),
(1120,'KO1809170002','-','2017-08-30',100000,'Masuk','BP 008688/Umi/Lenny/Tunai chopper 2 in 1',''),
(1121,'KO1809170002','-','2017-08-30',100000,'Masuk','BP 008691/Tuti/Lastri/Tunai chopper 2 in 1',''),
(1122,'KO1809170002','-','2017-08-30',3500000,'Masuk','BSTUM 003031-3032/Imam 28 K',''),
(1123,'KO1809170002','-','2017-08-30',2880000,'Masuk','BSTUM 0030033-3034/Heri 22 K',''),
(1124,'KO1809170002','-','2017-08-30',650000,'Masuk','BSTUM 003058/Pelunasan order lenny',''),
(1125,'KO1809170002','-','2017-08-30',150000,'Keluar','BSTUK 003059/Komisi 20 % lenny',''),
(1126,'KO1809170002','-','2017-08-30',850000,'Keluar','BSTUK 003060/Pembayaran paket UPS',''),
(1127,'KO1809170002','-','2017-08-30',6790000,'Keluar','Setoran Bank',''),
(1128,'KO1809170002','-','2017-08-01',3735500,'Masuk','Saldo Pindahan',''),
(1129,'KO1809170002','-','2017-08-01',3685500,'Keluar','Setoran Bank',''),
(1130,'KO1809170002','-','2017-08-01',2150000,'Masuk','BSTUM 002863/Pelunasan order indri',''),
(1131,'KO1809170002','-','2017-08-01',630000,'Keluar','BSTUK 002864/Komisi 20 % indri',''),
(1132,'KO1809170002','-','2017-08-01',1800000,'Masuk','BSTUM 002865/Pelunasan order Tuti',''),
(1133,'KO1809170002','-','2017-08-01',1050000,'Masuk','BSTUM 002867/Pelunasan orer lenny',''),
(1134,'KO1809170002','-','2017-08-01',550000,'Keluar','BSTUK 002866/Komisi 20 % tuti dan lenny',''),
(1135,'KO1809170002','-','2017-08-01',3780000,'Keluar','Setoran Bank',''),
(1136,'KO1809170002','-','2017-08-01',100000,'Masuk','BP 008652/Tumini/Lenny/Tunai chopper',''),
(1137,'KO1809170002','-','2017-08-01',159000,'Masuk','BP 008654/Ida/Lenny/Angsuran fancy 8 set',''),
(1138,'KO1809170002','-','2017-08-01',380000,'Masuk','BSTUM 002824/Imam 3 K',''),
(1139,'KO1809170002','-','2017-08-02',250000,'Masuk','BSTUM 002825/Imam 2 K',''),
(1140,'KO1809170002','-','2017-08-02',90000,'Keluar','BSTUK 54013-0208 Paket Baraka Jogja',''),
(1141,'KO1809170002','-','2017-08-02',80000,'Keluar','BSTUK 002868/Um driver agung 24-31 Jul',''),
(1142,'KO1809170002','-','2017-08-02',700000,'Keluar','Setoran Bank',''),
(1143,'KO1809170002','-','2017-08-02',500000,'Masuk','BP 008455/Hayati/Tuti/Tunai chopper ( Herpus )',''),
(1144,'KO1809170002','-','2017-08-02',100000,'Masuk','BP 008456/Herni/Tuti/Tunai chopper',''),
(1145,'KO1809170002','-','2017-08-02',100000,'Masuk','BP 008457/Kus/Tuti/Tunai chopper',''),
(1146,'KO1809170002','-','2017-08-02',150000,'Masuk','BP 008402/Sumiyati/Tyas/Angsuran chopper + gridle',''),
(1147,'KO1809170002','-','2017-08-02',550000,'Masuk','BSTUM 002869/Pelunasan order tuti',''),
(1148,'KO1809170002','-','2017-08-02',150000,'Keluar','BSTUK 002870/Komisi 20 % tuti',''),
(1149,'KO1809170002','-','2017-08-02',485000,'Keluar','BSTUK 002871/Bbm kolektor Heri 21 hari',''),
(1150,'KO1809170002','-','2017-08-02',65000,'Keluar','BSTUK 002871/Komisi mingguan heri',''),
(1151,'KO1809170002','-','2017-08-03',1100000,'Masuk','Supply Kas Pusat Ke Kas Operasional',''),
(1152,'KO1809170002','-','2017-08-03',1100000,'Keluar','Supply Kas Pusat Ke Kas Operasional',''),
(1153,'KO1809170002','-','2017-08-03',950000,'Masuk','BSTUM 002826/Imam 8 K',''),
(1154,'KO1809170002','-','2017-08-03',509000,'Keluar','Biaya Reimbursment Pak Sodikin',''),
(1155,'KO1809170002','-','2017-08-03',1200000,'Keluar','Setoran Bank',''),
(1156,'KO1809170002','-','2017-08-03',100000,'Masuk','BP 007716/Iwan/Yayuk/Tunai chopper',''),
(1157,'KO1809170002','-','2017-08-03',100000,'Masuk','BP 007715/Gatot/Yayuk/Tunai griddle',''),
(1158,'KO1809170002','-','2017-08-03',100000,'Masuk','BP 008658/Retno/Lenny/Tunai chopper',''),
(1159,'KO1809170002','-','2017-08-03',100000,'Masuk','BP 008657/Dwi Budi/Lenny/Tunai chopper',''),
(1160,'KO1809170002','-','2017-08-03',100000,'Masuk','BP 008655/Inaya/Lenny/Tunai chopper',''),
(1161,'KO1809170002','-','2017-08-03',219000,'Masuk','BP 008408/Rona Yuli/Tressye/Angsuran Fancy 8 set + chopper',''),
(1162,'KO1809170002','-','2017-08-03',219000,'Masuk','BP 008409/Isaman/Tresye/Angsuran Fancy 8 set + chopper',''),
(1163,'KO1809170002','-','2017-08-03',219000,'Masuk','BP 008405/Tatik/Tyas/Fancy 8 set + chopper',''),
(1164,'KO1809170002','-','2017-08-03',129000,'Masuk','BP 008404/Yuli/Tyas/Angsuran chopper',''),
(1165,'KO1809170002','-','2017-08-03',1450000,'Masuk','BSTUM 002872/Pelunasan Order lenny',''),
(1166,'KO1809170002','-','2017-08-03',450000,'Keluar','BSTUK 002873/Komisi 20 % lenny',''),
(1167,'KO1809170002','-','2017-08-04',2286000,'Keluar','Setoran Bank',''),
(1168,'KO1809170002','-','2017-08-04',330000,'Masuk','BSTUM 002827/Imam 2 K',''),
(1169,'KO1809170002','-','2017-08-04',100000,'Masuk','BP 007720/Suep/Yayuk/Tunai chopper',''),
(1170,'KO1809170002','-','2017-08-04',189000,'Masuk','BP 007719/Ita/Totok/Angsuran gridle + fancy 8 set',''),
(1171,'KO1809170002','-','2017-08-04',100000,'Masuk','BP 007721/Fitri/Yayuk/Tunai gridle',''),
(1172,'KO1809170002','-','2017-08-04',650000,'Masuk','BSTUM 002876/Pelunasan order tuti',''),
(1173,'KO1809170002','-','2017-08-04',150000,'Keluar','BSTUK 002878/Komisi 20 % tuti',''),
(1174,'KO1809170002','-','2017-08-04',240000,'Keluar','BSTUK 002877/Komisi mingguan lenny 24 order',''),
(1175,'KO1809170002','-','2017-08-04',50000,'Keluar','BSTUK 002875/Um driver Tarjo 1-5 Ags',''),
(1176,'KO1809170002','-','2017-08-04',70000,'Keluar','BSTUK 002874/Komisi mingguan yayuk 7 Order',''),
(1177,'KO1809170002','-','2017-08-04',20000,'Keluar','BSTUK 002874/Komisi mingguan totok 2 order',''),
(1178,'KO1809170002','-','2017-08-04',70000,'Keluar','BSTUK 002874/Komisi mingguan anik 7 order',''),
(1179,'KO1809170002','-','2017-08-04',140000,'Keluar','BSTUK 002879/Komisi mingguan indri 14 order',''),
(1180,'KO1809170002','-','2017-08-05',705000,'Masuk','BSTUM 002828/Imam 6 K',''),
(1181,'KO1809170002','-','2017-08-05',25000000,'Masuk','Supply Pusat ( Salary staff dan Komisi Sales )',''),
(1182,'KO1809170002','-','2017-08-05',16600000,'Keluar','Salary Staff Smr',''),
(1183,'KO1809170002','-','2017-08-05',9070100,'Keluar','Salary Sales ',''),
(1184,'KO1809170002','-','2017-08-05',60000,'Keluar','BSTUK 002879/Um driver Nano 31 Jul - 5 Ags',''),
(1185,'KO1809170002','-','2017-08-05',300000,'Masuk','BSTUM 002882/Angsuran KIT Chopper',''),
(1186,'KO1809170002','-','2017-08-05',100000,'Keluar','BSTUK 002884/Komisi mingguan tuti 10 Order',''),
(1187,'KO1809170002','-','2017-08-05',129000,'Masuk','BP 008458/Suraniningsih/Tuti/Angsuran chopper',''),
(1188,'KO1809170002','-','2017-08-05',129000,'Masuk','BP 008459/Sri Suwarti/Tuti/Angsuran chopper',''),
(1189,'KO1809170002','-','2017-08-05',129000,'Masuk','BP 008460/Sri Lestari/Tuti/Angsuran chopper',''),
(1190,'KO1809170002','-','2017-08-05',750000,'Masuk','BP 007599/Ristiyanti/Lenny/Tunai chopper',''),
(1191,'KO1809170002','-','2017-08-05',1300000,'Masuk','BSTUM 002883/Pelunasan order lenny',''),
(1192,'KO1809170002','-','2017-08-05',450000,'Keluar','BSTUK 002889/Komisi 20 % lenny',''),
(1193,'KO1809170002','-','2017-08-05',200000,'Masuk','BSTUM 002888/Penjualan Hp Inv Jogja ( Irpan )',''),
(1194,'KO1809170002','-','2017-08-05',200000,'Masuk','BSTUM 002888/Penjualan Hp Inv Smr ( Gito )',''),
(1195,'KO1809170002','-','2017-08-05',1350000,'Masuk','BSTUM 002887/Pelunasan order Ning',''),
(1196,'KO1809170002','-','2017-08-05',338000,'Keluar','BSTUK 002890/Komisi 20 % ning',''),
(1197,'KO1809170002','-','2017-08-05',4200000,'Keluar','Setoran Bank',''),
(1198,'KO1809170002','-','2017-08-05',2680000,'Masuk','BSTUM 002892/Pelunasan Order Tresye',''),
(1199,'KO1809170002','-','2017-08-05',700000,'Masuk','BSTUM 002895/Pelunasan order wiwid',''),
(1200,'KO1809170002','-','2017-08-05',816000,'Keluar','BSTUK 002893/Komisi 20 % tresye',''),
(1201,'KO1809170002','-','2017-08-05',100000,'Keluar','BSTUK 002893/Komisi tambahan alsyva',''),
(1202,'KO1809170002','-','2017-08-05',300000,'Keluar','BSTUK 002896/Komisi 20 % wiwid',''),
(1203,'KO1809170002','-','2017-08-05',200000,'Masuk','BSTUM 002829/Imam 2 K',''),
(1204,'KO1809170002','-','2017-08-07',1916900,'Keluar','Setoran Bank',''),
(1205,'KO1809170002','-','2017-08-07',1000000,'Masuk','Supply Kas Pusat Ke Kas Operasional',''),
(1206,'KO1809170002','-','2017-08-07',1000000,'Keluar','Supply Kas Pusat Ke Kas Operasional',''),
(1207,'KO1809170002','-','2017-08-07',329000,'Masuk','BP 008410/Lis/Tyas/Angsuran noodle',''),
(1208,'KO1809170002','-','2017-08-07',1185000,'Masuk','BSTUM 002830/Imam 10 K',''),
(1209,'KO1809170002','-','2017-08-07',350000,'Masuk','BSTUK 002831/Angsuran 3 K',''),
(1210,'KO1809170002','-','2017-08-07',200000,'Masuk','BSTUM 002898/Tambahan DP 007611 a,n Suwarni',''),
(1211,'KO1809170002','-','2017-08-07',60000,'Keluar','BSTUK 002897/Bbm Imam 3Ags/5-7 Ags',''),
(1212,'KO1809170002','-','2017-08-07',300000,'Keluar','BSTUK 002899/Iuran Warga 17 Agustus',''),
(1213,'KO1809170002','-','2017-08-07',150000,'Keluar','BSTUK 002898/Komisi mingguan tresye 15 order',''),
(1214,'KO1809170002','-','2017-08-07',1500000,'Keluar','Setoran Bank',''),
(1215,'KO1809170002','-','2017-08-07',390000,'Masuk','BSTUM 002832/Heri 3 K',''),
(1216,'KO1809170002','-','2017-08-07',150000,'Masuk','BSTUM 002833/Imam 1 K',''),
(1217,'KO1809170002','-','2017-08-08',1135000,'Masuk','BSTUM 002834/Imam 8 K',''),
(1218,'KO1809170002','-','2017-08-08',1650000,'Masuk','BSTUM 002835/Heri 10 K',''),
(1219,'KO1809170002','-','2017-08-08',242500,'Keluar','BSTUK 002910/Per Dinas P\'Gito Pkg 9-12 Ags',''),
(1220,'KO1809170002','-','2017-08-08',3100000,'Keluar','Setoran Bank',''),
(1221,'KO1809170002','-','2017-08-08',1000000,'Masuk','BSTUM 002912/Pelunasan order tresye',''),
(1222,'KO1809170002','-','2017-08-08',250000,'Keluar','BSTUK 002913/Komisi 20 % tresye',''),
(1223,'KO1809170002','-','2017-08-09',436500,'Keluar','BSTUK 002914/Dinas Perj Pak Sodikin Jogja 7-8 Ags',''),
(1224,'KO1809170002','-','2017-08-09',1000000,'Masuk','Supply Kas Pusat Ke Kas Operasional',''),
(1225,'KO1809170002','-','2017-08-09',1000000,'Keluar','Supply Kas Pusat Ke Kas Operasional',''),
(1226,'KO1809170002','-','2017-08-09',229000,'Masuk','BP 008568/Rini/Indri/Angsuran Presto elektrik',''),
(1227,'KO1809170002','-','2017-08-09',229000,'Masuk','BP 008566/Aneng/Indri/Angsuran Presto elektrik',''),
(1228,'KO1809170002','-','2017-08-09',329000,'Masuk','BP 008567/Edy/Indri/Angsuran Noodle',''),
(1229,'KO1809170002','-','2017-08-09',199000,'Masuk','BP 008565/Tien/Indri/Angsuran Fancy Stove',''),
(1230,'KO1809170002','-','2017-08-09',87500,'Keluar','BSTUK-840710175317 Pembelian Tiket KA PP Smr-Pkg P\'Sodikin',''),
(1231,'KO1809170002','-','2017-08-09',4590000,'Masuk','BSTUM 002836-37/Heri 25 K',''),
(1232,'KO1809170002','-','2017-08-09',1145000,'Masuk','BSTUM 002838/Imam 9 K',''),
(1233,'KO1809170002','-','2017-08-09',94500,'Keluar','BSTUK 002915/Pembeliak Atk kantor',''),
(1234,'KO1809170002','-','2017-08-09',300000,'Masuk','BP 008169/Tyas/Anik/Tunai chopper',''),
(1235,'KO1809170002','-','2017-08-09',50000,'Keluar','BSTUK 002916/Service Mobil ( Las Knalpot Mobil Agung )',''),
(1236,'KO1809170002','-','2017-08-09',7350000,'Keluar','Setoran Bank',''),
(1237,'KO1809170002','-','2017-08-09',150000,'Masuk','BP 005737/Diah/Tuti/Angsuran chopper + gridle',''),
(1238,'KO1809170002','-','2017-08-09',139000,'Masuk','BP 005739/Saum/Lenny/Angsuran gridle',''),
(1239,'KO1809170002','-','2017-08-09',150000,'Masuk','BP 005738/Yuni/Lenny/Angsuran chopper + gridle',''),
(1240,'KO1809170002','-','2017-08-09',50000,'Keluar','BSTUK 002917/Um driver Tarjo 6-10 Ags','');

/*Table structure for table `kasdetail` */

DROP TABLE IF EXISTS `kasdetail`;

CREATE TABLE `kasdetail` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `kodekas` varchar(30) NOT NULL,
  `kodekasmanual` varchar(50) NOT NULL DEFAULT '-',
  `tanggal` varchar(30) NOT NULL,
  `total` int(10) NOT NULL,
  `jeniskas` varchar(20) NOT NULL,
  `uraian` text,
  `kodeakun` varchar(15) NOT NULL,
  PRIMARY KEY (`id`,`kodekas`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `kasdetail` */

insert  into `kasdetail`(`id`,`kodekas`,`kodekasmanual`,`tanggal`,`total`,`jeniskas`,`uraian`,`kodeakun`) values 
(1,'KO0609170002','','2017-07-03',105000,'Keluar','Bbm ( Mobil Agung )','1112'),
(1,'KO0609170003','','2017-07-04',105000,'Keluar','Bbm ( Mobil Tarjo )','1112'),
(1,'KO0609170004','','2017-07-05',800000,'Masuk','Supply Kas Besar','1112'),
(1,'KO0609170005','','2017-07-05',105000,'Masuk','Bbm ( mobil agung )','1112'),
(1,'KO2908170001','-','2017-07-01',450000,'Masuk','Supply Kas Pusat ke Kas Opr','1112'),
(2,'KO0609170002','','2017-07-03',105000,'Keluar','Bbm ( Mobil Nano )','1112'),
(2,'KO0609170003','','2017-07-04',20000,'Keluar','Transportasi Operasional','1112'),
(2,'KO0609170005','','2017-07-05',105000,'Masuk','Bbm ( Mobil Nano )','1112'),
(3,'KO0609170002','','2017-07-03',140500,'Keluar','Bahan Demo dan Ayam ','1112'),
(3,'KO0609170003','','2017-07-04',98000,'Keluar','Ayam ( Demo )','1112'),
(3,'KO0609170005','','2017-07-05',135000,'Masuk','Ayam ( Demo )','1112'),
(4,'KO0609170003','','2017-07-04',12000,'Keluar','Isi Ulang Galon','1112'),
(5,'KO0609170003','','2017-07-04',195000,'Keluar','Bahan Demo Harian','1112');

/*Table structure for table `kasdetail_temp` */

DROP TABLE IF EXISTS `kasdetail_temp`;

CREATE TABLE `kasdetail_temp` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `kodekas` varchar(30) NOT NULL,
  `kodekasmanual` varchar(50) NOT NULL DEFAULT '-',
  `tanggal` varchar(30) NOT NULL,
  `total` int(10) NOT NULL,
  `jeniskas` varchar(20) NOT NULL,
  `uraian` text,
  `kodeakun` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `kasdetail_temp` */

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

/*Table structure for table `komisisales` */

DROP TABLE IF EXISTS `komisisales`;

CREATE TABLE `komisisales` (
  `id` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `kodebp` varchar(30) NOT NULL,
  `idsales` int(5) NOT NULL,
  `idpesanan` int(5) NOT NULL,
  `totaljual` double DEFAULT NULL,
  `komisibp` double DEFAULT '0' COMMENT '1 % bp',
  `komisia1` double DEFAULT '0' COMMENT '5 % tgl 10',
  `komisilunas` double DEFAULT '0' COMMENT '5 % tgl 20',
  `komisitunai` double DEFAULT '0' COMMENT '20 % pelunasan',
  `komisibprupiah` double DEFAULT '0',
  `komisia1rupiah` double DEFAULT '0',
  `komisilunasrupiah` double DEFAULT '0',
  `komisitunasirupiah` double DEFAULT '0',
  `statuskomisibp` varchar(40) DEFAULT NULL,
  `statuskomisia1` varchar(40) DEFAULT NULL,
  `statuskomisilunas` varchar(40) DEFAULT NULL,
  `statuskomisitunasi` varchar(40) DEFAULT NULL,
  `statusbereskomisi` varchar(10) DEFAULT 'belum',
  `totalkomisi` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `komisisales` */

insert  into `komisisales`(`id`,`kodebp`,`idsales`,`idpesanan`,`totaljual`,`komisibp`,`komisia1`,`komisilunas`,`komisitunai`,`komisibprupiah`,`komisia1rupiah`,`komisilunasrupiah`,`komisitunasirupiah`,`statuskomisibp`,`statuskomisia1`,`statuskomisilunas`,`statuskomisitunasi`,`statusbereskomisi`,`totalkomisi`) values 
(1,'BP010817001',6,1,929000,1.0764262648008611,0,0,0,10000,0,0,0,'2017-08-09',NULL,NULL,NULL,'belum',10000);

/*Table structure for table `pelanggan` */

DROP TABLE IF EXISTS `pelanggan`;

CREATE TABLE `pelanggan` (
  `idpelanggan` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `mankodepelanggan` varchar(30) NOT NULL,
  `namapelanggan` varchar(100) NOT NULL,
  `alamat` text,
  `telepon` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idpelanggan`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `pelanggan` */

insert  into `pelanggan`(`idpelanggan`,`mankodepelanggan`,`namapelanggan`,`alamat`,`telepon`) values 
(1,'','Bu Supriyati','Jl Wonodri Kopen Barat III RT 4 / 11 Semarang',''),
(2,'','Pak Ratno','Jl Wonodri Kopen Barat III Rt 4 / 11 Semarang','085715173117'),
(3,'','Bu Nur Hidayat','Jl Wonodri Kopen Barat III Rt 4 / 11 Semarang',''),
(4,'','Bu Lia','Asrama Brimob lantai II / 5 Banyumanik','082227116380'),
(5,'','Bu Guntoro','Perum Bukit Jatisari blok A10	','081325668326'),
(6,'','Bu Dian','Borobudur V Rt 3 Rw 12 Kembang arum','085290817702'),
(7,'','Bu Mimin','MA Al Ashor','081575098081'),
(8,'','Bu Mimin','MA Al Ashor','081575098081');

/*Table structure for table `pelunasan` */

DROP TABLE IF EXISTS `pelunasan`;

CREATE TABLE `pelunasan` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `kodebp` varchar(30) NOT NULL,
  `tanggal` varchar(30) NOT NULL,
  `keterangan` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `pelunasan` */

/*Table structure for table `sales` */

DROP TABLE IF EXISTS `sales`;

CREATE TABLE `sales` (
  `idsales` int(5) NOT NULL AUTO_INCREMENT,
  `namasales` varchar(20) NOT NULL,
  `alamat` text,
  `telepon` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idsales`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `sales` */

insert  into `sales`(`idsales`,`namasales`,`alamat`,`telepon`) values 
(1,'Ning','Semarang','085727682969'),
(2,'Lenny','Semarang	','085701272252'),
(3,'Tuti','Semarang','082133288862'),
(4,'Indri','Semarang','081329231998'),
(5,'Tressye','Semarang','081326072429'),
(6,'Tyas','Semarang','081329648896'),
(7,'Ari','Semarang','081327748587'),
(8,'Yayuk','Semarang','085866299171'),
(9,'Anik','Semarang','081805880599'),
(10,'Wiwid','Semarang','');

/*Table structure for table `stokbarang` */

DROP TABLE IF EXISTS `stokbarang`;

CREATE TABLE `stokbarang` (
  `id` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `idbarang` int(5) NOT NULL,
  `stok` int(10) NOT NULL,
  `tanggal` varchar(30) NOT NULL DEFAULT 'CURDATE()',
  `keterangan` varchar(30) NOT NULL,
  `kategori` varchar(30) NOT NULL,
  `trace` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `stokbarang` */

/*Table structure for table `subakun` */

DROP TABLE IF EXISTS `subakun`;

CREATE TABLE `subakun` (
  `idsubakun` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `kodesubakun` varchar(20) NOT NULL,
  `namasubakun` varchar(30) NOT NULL,
  `idakun` int(5) NOT NULL,
  PRIMARY KEY (`idsubakun`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `subakun` */

/*Table structure for table `subakun3` */

DROP TABLE IF EXISTS `subakun3`;

CREATE TABLE `subakun3` (
  `idsubakun3` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `kodesubakun3` varchar(20) NOT NULL,
  `namasubakun3` varchar(30) NOT NULL,
  `idsubakun` int(5) NOT NULL,
  `idakun` int(5) NOT NULL,
  PRIMARY KEY (`idsubakun3`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `subakun3` */

/*Table structure for table `tempbstu` */

DROP TABLE IF EXISTS `tempbstu`;

CREATE TABLE `tempbstu` (
  `id` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `nama` varchar(30) NOT NULL,
  `uraian` text,
  `keterangan` text,
  `jumlah` int(10) NOT NULL,
  `kodebstu` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tempbstu` */

/*Table structure for table `test` */

DROP TABLE IF EXISTS `test`;

CREATE TABLE `test` (
  `iduser` int(5) NOT NULL AUTO_INCREMENT,
  `namauser` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `level` int(10) NOT NULL,
  PRIMARY KEY (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `test` */

/*Table structure for table `urutangsuran` */

DROP TABLE IF EXISTS `urutangsuran`;

CREATE TABLE `urutangsuran` (
  `idurut` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `nourutangsuran` varchar(20) NOT NULL,
  PRIMARY KEY (`idurut`,`nourutangsuran`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `urutangsuran` */

insert  into `urutangsuran`(`idurut`,`nourutangsuran`) values 
(1,'KA0908170001');

/*Table structure for table `urutbkm` */

DROP TABLE IF EXISTS `urutbkm`;

CREATE TABLE `urutbkm` (
  `idurut` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `nourutbkm` varchar(20) NOT NULL,
  PRIMARY KEY (`idurut`,`nourutbkm`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `urutbkm` */

/*Table structure for table `urutbstu` */

DROP TABLE IF EXISTS `urutbstu`;

CREATE TABLE `urutbstu` (
  `idurut` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `nourutbstu` varchar(20) NOT NULL,
  PRIMARY KEY (`idurut`,`nourutbstu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `urutbstu` */

/*Table structure for table `urutkas` */

DROP TABLE IF EXISTS `urutkas`;

CREATE TABLE `urutkas` (
  `idurut` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `nourutkas` varchar(20) NOT NULL,
  PRIMARY KEY (`idurut`,`nourutkas`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

/*Data for the table `urutkas` */

insert  into `urutkas`(`idurut`,`nourutkas`) values 
(6,'KO2908170001'),
(7,'KO0609170001'),
(8,'KO0609170002'),
(9,'KO0609170003'),
(10,'KO0609170004'),
(11,'KO0609170005');

/*Table structure for table `urutkasbesar` */

DROP TABLE IF EXISTS `urutkasbesar`;

CREATE TABLE `urutkasbesar` (
  `idurut` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `nourutkas` varchar(20) NOT NULL,
  PRIMARY KEY (`idurut`,`nourutkas`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `urutkasbesar` */

insert  into `urutkasbesar`(`idurut`,`nourutkas`) values 
(1,'KO1809170002');

/*Table structure for table `urutpesnan` */

DROP TABLE IF EXISTS `urutpesnan`;

CREATE TABLE `urutpesnan` (
  `idurut` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `nourutpesanan` varchar(20) NOT NULL,
  PRIMARY KEY (`idurut`,`nourutpesanan`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `urutpesnan` */

insert  into `urutpesnan`(`idurut`,`nourutpesanan`) values 
(1,'BP010817001');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `iduser` int(5) NOT NULL AUTO_INCREMENT,
  `namauser` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `level` varchar(10) NOT NULL,
  PRIMARY KEY (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user` */

/* Procedure structure for procedure `displayKasBesar` */

/*!50003 DROP PROCEDURE IF EXISTS  `displayKasBesar` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`yudori`@`%` PROCEDURE `displayKasBesar`(in tgl_awal varchar(50),in tgl_akhir varchar(50))
BEGIN
	declare init int(5);
	SELECT @s:=0 into init;
	SELECT *,@d:=IF(jeniskas="Masuk",total,0) AS Debit,@k:=IF(jeniskas="Keluar",total,0) AS Kredit,@s:=@s+@d-@k AS Saldo 
	FROM kas_besar_detail WHERE tanggal BETWEEN tgl_awal AND tgl_akhir ORDER BY tanggal ASC;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `displayKasOperasional` */

/*!50003 DROP PROCEDURE IF EXISTS  `displayKasOperasional` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`yudori`@`%` PROCEDURE `displayKasOperasional`(IN tgl_awal VARCHAR(50),IN tgl_akhir VARCHAR(50))
BEGIN
		DECLARE init INT(5);
	SELECT @s:=0 INTO init;
	SELECT *,@d:=IF(jeniskas="Masuk",total,0) AS Debit,@k:=IF(jeniskas="Keluar",total,0) AS Kredit,@s:=@s+@d-@k AS Saldo 
	FROM kasdetail WHERE tanggal BETWEEN tgl_awal AND tgl_akhir ORDER BY tanggal ASC;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spCetakLaporanKasBesar` */

/*!50003 DROP PROCEDURE IF EXISTS  `spCetakLaporanKasBesar` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `spCetakLaporanKasBesar`(IN tanggalnya VARCHAR(100))
BEGIN
	TRUNCATE kas_besar_detail_temp;
INSERT INTO kas_besar_detail_temp (kodekas,tanggal,total,jeniskas,uraian,kodeakun) SELECT angsuran.kodeangsuran,angsuran.tanggal,angsuran.jumlah,'Masuk',CONCAT('UM ',pelanggan.namapelanggan,' ',angsuran.kodebp),'1112' FROM angsuran JOIN buktipesanan ON angsuran.kodebp = buktipesanan.kodebp
JOIN pelanggan ON buktipesanan.idpelanggan = pelanggan.idpelanggan WHERE angsuran.tanggal=tanggalnya;
INSERT INTO kas_besar_detail_temp (kodekas,tanggal,total,jeniskas,uraian,kodeakun) SELECT detailangsuran.noans,detailangsuran.tgl,detailangsuran.jumlah,'Masuk',CONCAT(detailangsuran.angsuranke,' ',pelanggan.namapelanggan) AS uraian,'1112' FROM detailangsuran 
JOIN angsuran ON detailangsuran.noans=angsuran.kodeangsuran
JOIN buktipesanan ON detailangsuran.nobp = buktipesanan.kodebp
JOIN pelanggan ON buktipesanan.idpelanggan = pelanggan.idpelanggan WHERE detailangsuran.tgl=tanggalnya;
INSERT INTO kas_besar_detail_temp SELECT * FROM kas_besar_detail WHERE tanggal=tanggalnya;
	END */$$
DELIMITER ;

/* Procedure structure for procedure `spCetakLaporanKasBesarBulanan2` */

/*!50003 DROP PROCEDURE IF EXISTS  `spCetakLaporanKasBesarBulanan2` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `spCetakLaporanKasBesarBulanan2`(IN tanggalnya VARCHAR(100), IN tanggalnyaakhir VARCHAR(100))
BEGIN
TRUNCATE kas_besar_detail_temp;
INSERT INTO kas_besar_detail_temp (kodekas,tanggal,total,jeniskas,uraian,kodeakun) SELECT angsuran.kodeangsuran,angsuran.tanggal,angsuran.jumlah,'Masuk',CONCAT('UM ',pelanggan.namapelanggan,' ',angsuran.kodebp),'1112' FROM angsuran JOIN buktipesanan ON angsuran.kodebp = buktipesanan.kodebp
JOIN pelanggan ON buktipesanan.idpelanggan = pelanggan.idpelanggan WHERE angsuran.tanggal BETWEEN tanggalnya AND tanggalnyaakhir;
INSERT INTO kas_besar_detail_temp (kodekas,tanggal,total,jeniskas,uraian,kodeakun) SELECT detailangsuran.noans,detailangsuran.tgl,detailangsuran.jumlah,'Masuk',CONCAT(detailangsuran.angsuranke,' ',pelanggan.namapelanggan) AS uraian,'1112' FROM detailangsuran 
JOIN angsuran ON detailangsuran.noans=angsuran.kodeangsuran
JOIN buktipesanan ON detailangsuran.nobp = buktipesanan.kodebp
JOIN pelanggan ON buktipesanan.idpelanggan = pelanggan.idpelanggan WHERE detailangsuran.tgl BETWEEN tanggalnya AND tanggalnyaakhir;
INSERT INTO kas_besar_detail_temp SELECT * FROM kas_besar_detail WHERE tanggal BETWEEN tanggalnya AND tanggalnyaakhir;
	END */$$
DELIMITER ;

/* Procedure structure for procedure `spDeleteBp` */

/*!50003 DROP PROCEDURE IF EXISTS  `spDeleteBp` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `spDeleteBp`(IN KODENYA VARCHAR(30))
BEGIN
DECLARE `_rollback` BOOL DEFAULT 0;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `_rollback` = 1;
	START TRANSACTION;
	DELETE FROM buktipesanan WHERE kodebp = KODENYA;
	DELETE FROM detailpesanan WHERE kodebp = KODENYA;
	IF `_rollback` THEN
        ROLLBACK;
    ELSE
        COMMIT;
    END IF;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spInsertBarang` */

/*!50003 DROP PROCEDURE IF EXISTS  `spInsertBarang` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `spInsertBarang`(
IN NAMA VARCHAR(100),
IN TUNAI INT(10),
IN HDROP INT(10),
IN INDEN INT(10),
IN UM INT(10),
IN SISA INT(10),
IN HPROMO INT(10),
IN SISA1 INT(10),
IN SISA2 INT(10),
IN TGLMULAI VARCHAR(30),
IN TGLAKHIR VARCHAR(30),
IN AKTIF VARCHAR(2))
BEGIN
    DECLARE TEMPIDHARGA INT(10);
    DECLARE IDBARANGTEMP INT(10);    
    DECLARE `_rollback` BOOL DEFAULT 0;
    INSERT INTO barang(namabarang) VALUES (NAMA);
    SELECT idbarang FROM barang WHERE namabarang=NAMA INTO IDBARANGTEMP; 
    INSERT INTO HARGABARANG(`idbarang`,`hargatunai`,`hargadrop`,`hargaindent`,`UM`,sisa,`hargapromositunai`,`sisa1`,`sisa2`,`tglberlakumulai`,`tglberlakuakhir`,`aktif`)  
    VALUES(IDBARANGTEMP,TUNAI,HDROP,INDEN,UM,SISA,HPROMO,SISA1,SISA2,TGLMULAI,TGLAKHIR,AKTIF);
    SELECT MAX(IDHARGA) AS IDH FROM HARGABARANG WHERE idbarang=IDBARANGTEMP LIMIT 1 INTO TEMPIDHARGA;
    UPDATE BARANG SET idharga=IDBARANGTEMP WHERE idbarang=IDBARANGTEMP;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spInsertBSTU` */

/*!50003 DROP PROCEDURE IF EXISTS  `spInsertBSTU` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `spInsertBSTU`(IN KODENYA VARCHAR(30),IN NAMANYA VARCHAR(30),IN JUMLAHNYA INT(10),
    IN STATUSNYA VARCHAR(30),IN JENISNYA VARCHAR(20), IN SERAHNYA VARCHAR(20),IN TANGGALNYA VARCHAR(30))
BEGIN
DECLARE `_rollback` BOOL DEFAULT 0;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `_rollback` = 1;
START TRANSACTION;
	INSERT INTO bstu (`kodebstu`,`nama`,`jumlah`,`status`,`jenisbstu`,`diserahkan`,tanggal) VALUES
	(KODENYA,NAMANYA,JUMLAHNYA,STATUSNYA,JENISNYA,SERAHNYA,TANGGALNYA);
	INSERT INTO detailbstu (nama,uraian,keterangan,jumlah,kodebstu)  SELECT nama,uraian,keterangan,jumlah,kodebstu FROM tempbstu;
	TRUNCATE tempbstu;
	IF `_rollback` THEN
        ROLLBACK;
    ELSE
        COMMIT;
    END IF;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spInsertKas` */

/*!50003 DROP PROCEDURE IF EXISTS  `spInsertKas` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `spInsertKas`(IN KODEKAS VARCHAR(50),IN KODEKASMANUAL VARCHAR(50))
BEGIN    
    DECLARE totalkeluaran INT(10);
    DECLARE tglsekarang VARCHAR(30);
    DECLARE `_rollback` BOOL DEFAULT 0;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `_rollback` = 1;
    START TRANSACTION;
    SELECT SUM(total) FROM kasdetail_temp INTO totalkeluaran;
    SELECT CURDATE() INTO tglsekarang;
    INSERT INTO kasdetail SELECT * FROM kasdetail_temp;
    INSERT INTO kas (`kodekas`,`kodekasmanual`,`tanggal`,`total`) VALUES (KODEKAS,KODEKASMANUAL,tglsekarang,totalkeluaran);
    TRUNCATE kasdetail_temp;
    IF `_rollback` THEN
        ROLLBACK;
    ELSE
        COMMIT;
    END IF;    
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spInsertKasBesarTemp` */

/*!50003 DROP PROCEDURE IF EXISTS  `spInsertKasBesarTemp` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `spInsertKasBesarTemp`(IN KODEKAS VARCHAR(50),IN KODEKASMANUAL VARCHAR(50),IN TANGGALNYA VARCHAR(50),IN TOTAL INT(10),
    IN JENISNYA VARCHAR(30),IN URAIAN TEXT,IN KODEAKUNNYA VARCHAR(20))
BEGIN    
    DECLARE `_rollback` BOOL DEFAULT 0;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `_rollback` = 1;
    START TRANSACTION;
    INSERT INTO kas_besar_detail_temp(`kodekas`,`kodekasmanual`,`tanggal`,`total`,`jeniskas`,`uraian`,`kodeakun`) VALUES (KODEKAS,KODEKASMANUAL,TANGGALNYA,TOTAL,JENISNYA,URAIAN,KODEAKUNNYA);    
IF `_rollback` THEN
        ROLLBACK;
    ELSE
        COMMIT;
    END IF;    
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spInsertKasTemp` */

/*!50003 DROP PROCEDURE IF EXISTS  `spInsertKasTemp` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `spInsertKasTemp`(IN KODEKAS VARCHAR(50),IN KODEKASMANUAL VARCHAR(50),IN TANGGALNYA VARCHAR(50),IN TOTAL INT(10),
    IN JENISNYA VARCHAR(30),IN URAIAN TEXT,IN KODEAKUNNYA VARCHAR(20))
BEGIN    
    DECLARE `_rollback` BOOL DEFAULT 0;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `_rollback` = 1;
    START TRANSACTION;
    INSERT INTO kasdetail_temp(`kodekas`,`kodekasmanual`,`tanggal`,`total`,`jeniskas`,`uraian`,`kodeakun`) VALUES (KODEKAS,KODEKASMANUAL,TANGGALNYA,TOTAL,JENISNYA,URAIAN,KODEAKUNNYA);    
IF `_rollback` THEN
        ROLLBACK;
    ELSE
        COMMIT;
    END IF;    
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spInsertHargaBarang` */

/*!50003 DROP PROCEDURE IF EXISTS  `spInsertHargaBarang` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `spInsertHargaBarang`(
IN NAMA VARCHAR(20),
IN HT INT(10),
IN HD INT(10),
IN UM INT(10),
IN HPI INT(10),
IN HI INT(10),
IN SISA1 INT(10),
IN SISA2 INT(10),
IN HAKTIF INT(10),
IN TGLBERLAKU VARCHAR(20),
IN TGLBERLAKUAKHIR VARCHAR(20),
IN KODEBARANGS INT(10))
BEGIN
    DECLARE kodeaktif INT(10);
    DECLARE `_rollback` BOOL DEFAULT 0;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `_rollback` = 1;
    START TRANSACTION;
    UPDATE hargabarang SET aktif='N' WHERE idbarang = KODEBARANGS;
    INSERT INTO hargabarang(`idbarang`,`hargatunai`,`hargadrop`,`hargaindent`,`UM`,`hargapromositunai`,`tglberlakumulai`,`tglberlakuakhir`,`sisa1`,`sisa2`)
    VALUES (KODEBARANGS,HT,HD,HI,UM,HPI,TGLBERLAKU,TGLBERLAKUAKHIR,SISA1,SISA2);
    SELECT MAX(idharga) AS latest FROM hargabarang WHERE idbarang=KODEBARANGS INTO kodeaktif;
    UPDATE barang SET idharga = kodeaktif WHERE idbarang=KODEBARANGS;
    UPDATE hargabarang SET aktif='Y' WHERE idharga = kodeaktif;
    IF `_rollback` THEN
        ROLLBACK;
    ELSE
        COMMIT;
    END IF;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spInsertKasBesar` */

/*!50003 DROP PROCEDURE IF EXISTS  `spInsertKasBesar` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `spInsertKasBesar`(IN KODEKAS VARCHAR(50),IN KODEKASMANUAL VARCHAR(50))
BEGIN    
    DECLARE totalkeluaran INT(10);
    DECLARE tglsekarang VARCHAR(30);
    DECLARE `_rollback` BOOL DEFAULT 0;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `_rollback` = 1;
    START TRANSACTION;
    SELECT SUM(total) FROM kas_besar_detail_temp INTO totalkeluaran;
    SELECT CURDATE() INTO tglsekarang;
    INSERT INTO kas_besar_detail SELECT * FROM kas_besar_detail_temp;
    INSERT INTO kas_besar (`kodekas`,`kodekasmanual`,`tanggal`,`total`) VALUES (KODEKAS,KODEKASMANUAL,tglsekarang,totalkeluaran);
    TRUNCATE kas_besar_detail_temp;
    IF `_rollback` THEN
        ROLLBACK;
    ELSE
        COMMIT;
    END IF;    
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spInsertKMB` */

/*!50003 DROP PROCEDURE IF EXISTS  `spInsertKMB` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `spInsertKMB`(IN KODE VARCHAR(30),IN NAMA VARCHAR(30),IN ALAMATNYA VARCHAR(30),IN KET TEXT, IN KET2 TEXT,IN TGL VARCHAR(29),
    IN IDBARANG INT(5), IN JUMLAH INT(5),IN STATUSBARANG VARCHAR(20))
BEGIN
DECLARE `_rollback` BOOL DEFAULT 0;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `_rollback` = 1;
START TRANSACTION;
	INSERT INTO BKMB (`kodekmb`,`nama`,`alamat`,`keterangan`,`detailketerangan`,`tanggal`,`idbarang`,`jumlah`,`statusbarang`)
	VALUES (KODE,NAMA,ALAMATNYA,KET,KET2,TGL,IDBARANG,JUMLAH,STATUSBARANG);
	INSERT INTO stokbarang(idbarang,stok,tanggal,keterangan,kategori) SELECT IDBARANG,0-JUMLAH,TGL,KODE,'KM' FROM BKMB WHERE statusbarang='keluar' AND kodekmb=KODE;
	INSERT INTO stokbarang(idbarang,stok,tanggal,keterangan,kategori) SELECT IDBARANG,JUMLAH,TGL,KODE,'KM' FROM BKMB WHERE statusbarang='masuk' AND kodekmb=KODE;
	IF `_rollback` THEN
        ROLLBACK;
    ELSE
        COMMIT;
    END IF;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spInsertPelunasan` */

/*!50003 DROP PROCEDURE IF EXISTS  `spInsertPelunasan` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `spInsertPelunasan`(IN KODENYA VARCHAR(30),IN TANGGALNYA VARCHAR(30),IN KETERANGANNYA TEXT)
BEGIN
DECLARE `_rollback` BOOL DEFAULT 0;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `_rollback` = 1;
	START TRANSACTION;
	INSERT INTO pelunasan (kodebp,tanggal,keterangan) VALUES (KODENYA,TANGGALNYA,KETERANGANNYA);
	UPDATE buktipesanan SET statusbp ="LUNAS" WHERE kodebp = KODENYA;
	IF `_rollback` THEN
        ROLLBACK;
    ELSE
        COMMIT;
    END IF;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spInsertPesanan` */

/*!50003 DROP PROCEDURE IF EXISTS  `spInsertPesanan` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `spInsertPesanan`(IN KODE VARCHAR(25),IN KODEMANUALBP VARCHAR(20),IN KODEMANUALPEL VARCHAR(20),IN NAMA VARCHAR(25) , IN ALAMAT TEXT ,IN TELP VARCHAR(20) ,
    IN IDSALES INT(5) , IN KOMSALES INT(5) ,IN JENISORDER VARCHAR(15) , IN TGLPESANAN VARCHAR(20) ,IN TGLTAGIH VARCHAR(20) ,
    IN TGLKIRIM VARCHAR(20) ,IN ANGSURANNYA INT(10),IN TOTAL INT(10) ,IN UM INT(10) ,IN SISA INT(10),IN TUNAI INT(10),IN STATUSKIRIM VARCHAR(10))
BEGIN    
    DECLARE idpesanannya INT(10);
    DECLARE idpelanggannya INT(10);
    DECLARE `_rollback` BOOL DEFAULT 0;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `_rollback` = 1;
    START TRANSACTION;
	INSERT INTO buktipesanan(`kodebp`,`idpesananfaktur`,`namapelanggan`,`alamatpelanggan`,`telepon`,
	`idsales`,`komisisales`,`jenisorder`,`tglpesanan`,`tglpenagihan`,`tglpengiriman`,
	`total`,`UM`,`sisa`,`angsuran`,sisaberjalan,hargatunai) VALUES (KODE,KODEMANUALBP,NAMA,ALAMAT,TELP,IDSALES,KOMSALES,JENISORDER,TGLPESANAN,TGLTAGIH,TGLKIRIM,
	TOTAL,UM,SISA,ANGSURANNYA,0,TUNAI);
	INSERT INTO detailpesanan (kodebarang,namabarang,unit,harga,total,idpesanan,kodebp) 
	SELECT kodebarang,namabarang,unit,harga,total,idpesanan,kodebp FROM ordertemp;	
	SELECT idpesanan FROM buktipesanan WHERE kodebp=KODE INTO idpesanannya;
	INSERT INTO pelanggan (mankodepelanggan,namapelanggan,alamat,telepon) VALUES (KODEMANUALPEL,NAMA,ALAMAT,TELP);
	SELECT idpelanggan FROM pelanggan WHERE namapelanggan=NAMA AND alamat=ALAMAT INTO idpelanggannya;
	UPDATE buktipesanan SET idpelanggan = idpelanggannya WHERE kodebp=KODE;
	UPDATE detailpesanan SET idpesanan=idpesanannya, idpelanggan=idpelanggannya WHERE kodebp = KODE;
	INSERT INTO komisisales (kodebp,idsales,idpesanan,komisibp,komisibprupiah,totaljual,statuskomisibp,totalkomisi) VALUES (KODE,IDSALES,idpesanannya,1,((1/100)*TUNAI),TOTAL,TGLPESANAN,((1/100)*TUNAI));
        /* Simpan ke daftar stok, status kirim belum 
	INSERT INTO stokbarang(idbarang,stok,tanggal,keterangan,kategori) SELECT detailpesanan.kodebarang,0-detailpesanan.unit,buktipesanan.tglpesanan,buktipesanan.kodebp,'BP' FROM detailpesanan JOIN buktipesanan ON detailpesanan.kodebp=buktipesanan.kodebp WHERE detailpesanan.kodebp=KODE;
	*/
	TRUNCATE TABLE `ordertemp`;
	IF `_rollback` THEN
        ROLLBACK;
    ELSE
        COMMIT;
    END IF;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spTest` */

/*!50003 DROP PROCEDURE IF EXISTS  `spTest` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `spTest`()
BEGIN
    DECLARE `_rollback` BOOL DEFAULT 0;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `_rollback` = 1;
    START TRANSACTION;
	INSERT INTO test (`namauser`,`level`) VALUES ('ppopo',1);
	INSERT INTO test (`namauser`,`level`) VALUES ('ppopo',2);
	INSERT INTO test (`namauser`,`level`) VALUES ('ppopo',3);
	INSERT INTO test (`namauser`,`level`) VALUES ('ppopo',4);
	INSERT INTO test (`namauser`,`level`) VALUES ('ppopo',5);
	INSERT INTO test (`namauser`,`level`) VALUES ('ppopo');
	IF `_rollback` THEN
        ROLLBACK;
    ELSE
        COMMIT;
    END IF;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spUpdateAngsuran` */

/*!50003 DROP PROCEDURE IF EXISTS  `spUpdateAngsuran` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `spUpdateAngsuran`(IN kodebpnya VARCHAR(20))
BEGIN
DECLARE `_rollback` BOOL DEFAULT 0;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `_rollback` = 1;
START TRANSACTION;
	UPDATE buktipesanan SET sisaberjalan = (sisaberjalan + 1) WHERE kodebp=kodebpnya;
	IF `_rollback` THEN
        ROLLBACK;
    ELSE
        COMMIT;
    END IF;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spUpdatePesanan` */

/*!50003 DROP PROCEDURE IF EXISTS  `spUpdatePesanan` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `spUpdatePesanan`(
IN KODE VARCHAR(25),
IN KODEMANUALBP VARCHAR(20),
IN KODEMANUALPEL VARCHAR(20),
IN NAMA VARCHAR(25), 
IN ALAMAT TEXT,
IN TELP VARCHAR(20),
IN IDSALES INT(5), 
IN KOMSALES INT(5) ,
IN JENISORDER VARCHAR(15) , 
IN TGLPESANAN VARCHAR(20) ,
IN TGLTAGIH VARCHAR(20),
IN TGLKIRIM VARCHAR(20),
IN ANGSURANS INT(10),
IN TOTALS INT(10),
IN UMS INT(10),
IN SISAS INT(10),
IN HARGATUNAIS INT(10))
BEGIN
    DECLARE idpesanannya INT(10);
    DECLARE idpelanggannya INT(10);
    DECLARE `_rollback` BOOL DEFAULT 0;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `_rollback` = 1;
    START TRANSACTION;
    UPDATE buktipesanan SET 
    `idpesananfaktur`=KODEMANUALBP,
    `namapelanggan`=NAMA,
    `alamatpelanggan`=ALAMAT,
    `telepon`=TELP,
    `idsales`=IDSALES,
    `komisisales`=KOMSALES,
    `jenisorder`=JENISORDER,
    `tglpesanan`=TGLPESANAN,
    `tglpenagihan`=TGLTAGIH,
    `tglpengiriman`=TGLKIRIM
    /*
    Update Jenis Order, tidak usah merubah
    --------------------------------------
     `angsuran`=ANGSURANS,
     `total`=TOTALS,
     `UM`=UMS,
     `sisa`=SISAS,
     `hargatunai`=HARGATUNAIS */ WHERE kodebp=KODE;
    TRUNCATE TABLE `ordertemp`;
    IF `_rollback` THEN
        ROLLBACK;
    ELSE
        COMMIT;
    END IF;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `spUpdatetunai` */

/*!50003 DROP PROCEDURE IF EXISTS  `spUpdatetunai` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `spUpdatetunai`()
BEGIN    
    DECLARE v_finished INTEGER DEFAULT 0;
	DECLARE kodebpnya VARCHAR(30);
	DECLARE tunainya INT(10) DEFAULT 0; 
	DECLARE cur1 CURSOR FOR SELECT barang.hargatunai FROM barang JOIN detailpesanan ON barang.idbarang=detailpesanan.kodebarang 
	JOIN buktipesanan ON detailpesanan.kodebp=buktipesanan.kodebp;  
	DECLARE cur2 CURSOR FOR SELECT kodebp FROM buktipesanan;
	DECLARE CONTINUE HANDLER 
        FOR NOT FOUND SET v_finished = 1;
        OPEN cur1;
        OPEN cur2;
        get_email: LOOP
        FETCH cur1 INTO tunainya;
        FETCH cur2 INTO kodebpnya;
         IF v_finished = 1 THEN 
	LEAVE get_email;
	END IF;
	UPDATE buktipesanan SET hargatunai=tunainya WHERE kodebp=kodebpnya;
	END LOOP get_email;
	CLOSE cur1;
	CLOSE cur2;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sqlInsertKMBBuktiPesanan` */

/*!50003 DROP PROCEDURE IF EXISTS  `sqlInsertKMBBuktiPesanan` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sqlInsertKMBBuktiPesanan`(IN KODE VARCHAR(30),IN NAMA VARCHAR(30),IN ALAMATNYA VARCHAR(30),IN KET TEXT, IN KET2 TEXT,IN TGL VARCHAR(29),
    IN IDBARANG INT(5), IN JUMLAH INT(5),IN STATUSBARANG VARCHAR(20))
BEGIN
DECLARE `_rollback` BOOL DEFAULT 0;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `_rollback` = 1;
START TRANSACTION;
	INSERT INTO BKMB (`kodekmb`,`nama`,`alamat`,`keterangan`,`detailketerangan`,`tanggal`,`idbarang`,`jumlah`,`statusbarang`)
	VALUES (KODE,NAMA,ALAMATNYA,KET,KET2,TGL,IDBARANG,JUMLAH,STATUSBARANG);
	INSERT INTO stokbarang(idbarang,stok,tanggal,keterangan,kategori) SELECT IDBARANG,0-JUMLAH,TGL,KODE,'BP' FROM BKMB WHERE statusbarang='keluar' AND kodekmb=KODE;
	INSERT INTO stokbarang(idbarang,stok,tanggal,keterangan,kategori) SELECT IDBARANG,JUMLAH,TGL,KODE,'BP' FROM BKMB WHERE statusbarang='masuk' AND kodekmb=KODE;
	UPDATE buktipesanan SET statuskirim='sudah' WHERE kodebp=KODE;
	IF `_rollback` THEN
        ROLLBACK;
    ELSE
        COMMIT;
    END IF;
    END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
