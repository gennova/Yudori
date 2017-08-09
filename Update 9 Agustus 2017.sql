/*
SQLyog Ultimate v12.4.1 (64 bit)
MySQL - 10.1.21-MariaDB : Database - yudori
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
(1,'KA0908170001','BP0108170001',8,'Bu Mimin',129000,'Mifta','2017-08-09','','2017-08-09 12:22:57','11510201','K');

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
(1,'BP0108170001','KA0908170001','2017-08-09',129000,'     ','100000','     ','     ','     ','     ','     ','     ','     ','     ','belum','2017-08-09 12:22:57','     ','2017-08-09','     ','     ','     ','     ','     ','     ','     ','     ');

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
(1,'BP0108170001','009493','Bu Mimin','MA Al Ashor','081575098081',6,1,'DROP A1','2017-04-08','2017-05-17','2017-04-08',929000,129000,8,2,7,'2017-08-01 15:34:33','belum','100000',0,'belum');

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
(1,'KA0908170001','BP0108170001','2017-08-09','Angsuran 1',100000),
(2,'KA0908170001','BP0108170001','2017-08-09','Angsuran 2',100000);

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
(1,6,'Yudori Chopper 1.8 L',1,929000,929000,1,'BP0108170001',7);

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `kas` */

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `kasdetail` */

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
(1,'BP0108170001',6,1,929000,1.0764262648008611,1.6146393972012916,2.1528525296017222,0.1076426264800861,10000,15000,20000,999.9999999999999,'2017-08-09','2017-08-09','2017-08-09','2017-08-09','belum',46000);

/*Table structure for table `ordertemp` */

DROP TABLE IF EXISTS `ordertemp`;

CREATE TABLE `ordertemp` (
  `idorder` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `kodebarang` int(11) DEFAULT NULL,
  `namabarang` varchar(50) DEFAULT NULL,
  `unit` int(5) DEFAULT NULL,
  `harga` int(10) DEFAULT NULL,
  `total` int(10) DEFAULT NULL,
  `idpesanan` int(10) DEFAULT NULL,
  `kodebp` varchar(20) NOT NULL,
  PRIMARY KEY (`idorder`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `ordertemp` */

insert  into `ordertemp`(`idorder`,`kodebarang`,`namabarang`,`unit`,`harga`,`total`,`idpesanan`,`kodebp`) values 
(1,1,'Yudori Noodles Maker',1,2500000,NULL,NULL,'BP0908170001');

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `urutkas` */

/*Table structure for table `urutpesnan` */

DROP TABLE IF EXISTS `urutpesnan`;

CREATE TABLE `urutpesnan` (
  `idurut` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `nourutpesanan` varchar(20) NOT NULL,
  PRIMARY KEY (`idurut`,`nourutpesanan`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `urutpesnan` */

insert  into `urutpesnan`(`idurut`,`nourutpesanan`) values 
(1,'BP0108170001');

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
