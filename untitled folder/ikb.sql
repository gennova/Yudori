DELIMITER $$

USE `yudori`$$

DROP PROCEDURE IF EXISTS `spInsertKasBesar`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spInsertKasBesar`(IN KODEKAS VARCHAR(50),IN KODEKASMANUAL VARCHAR(50))
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
    END$$

DELIMITER ;