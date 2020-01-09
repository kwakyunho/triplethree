-- --------------------------------------------------------
-- 호스트:                          kwakyunho.cafe24.com
-- 서버 버전:                        10.1.13-MariaDB - MariaDB Server
-- 서버 OS:                        Linux
-- HeidiSQL 버전:                  10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 테이블 kwakyunho.SALGRADE 구조 내보내기
CREATE TABLE IF NOT EXISTS `SALGRADE` (
  `GRADE` tinyint(4) DEFAULT NULL COMMENT '등급',
  `LOSAL` smallint(6) DEFAULT NULL COMMENT '최저연봉',
  `HISAL` smallint(6) DEFAULT NULL COMMENT '최고연봉'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='연봉 등급';

-- 테이블 데이터 kwakyunho.SALGRADE:~5 rows (대략적) 내보내기
/*!40000 ALTER TABLE `SALGRADE` DISABLE KEYS */;
REPLACE INTO `SALGRADE` (`GRADE`, `LOSAL`, `HISAL`) VALUES
	(1, 700, 1200),
	(2, 1201, 1400),
	(3, 1401, 2000),
	(4, 2001, 3000),
	(5, 3001, 9999);
/*!40000 ALTER TABLE `SALGRADE` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
