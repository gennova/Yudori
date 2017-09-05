DELIMITER $$

USE `yudori`$$

DROP PROCEDURE IF EXISTS `spCetakLaporanKasBesar`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spCetakLaporanKasBesar`(IN tanggalnya VARCHAR(100))
BEGIN
	TRUNCATE kas_besar_detail_temp;
INSERT INTO kas_besar_detail_temp (kodekas,tanggal,total,jeniskas,uraian,kodeakun) SELECT angsuran.kodeangsuran,angsuran.tanggal,angsuran.jumlah,'Masuk',CONCAT('UM ',pelanggan.namapelanggan,' ',angsuran.kodebp),'1112' FROM angsuran JOIN buktipesanan ON angsuran.kodebp = buktipesanan.kodebp
JOIN pelanggan ON buktipesanan.idpelanggan = pelanggan.idpelanggan WHERE angsuran.tanggal=tanggalnya;
INSERT INTO kas_besar_detail_temp (kodekas,tanggal,total,jeniskas,uraian,kodeakun) SELECT detailangsuran.noans,detailangsuran.tgl,detailangsuran.jumlah,'Masuk',CONCAT(detailangsuran.angsuranke,' ',pelanggan.namapelanggan) AS uraian,'1112' FROM detailangsuran 
JOIN angsuran ON detailangsuran.noans=angsuran.kodeangsuran
JOIN buktipesanan ON detailangsuran.nobp = buktipesanan.kodebp
JOIN pelanggan ON buktipesanan.idpelanggan = pelanggan.idpelanggan WHERE detailangsuran.tgl=tanggalnya;
INSERT INTO kas_besar_detail_temp SELECT * FROM kas_besar_detail WHERE tanggal=tanggalnya;
	END$$

DELIMITER ;