-- --------------------------------------------------------
-- Host:                         localhost
-- Server version:               8.0.36 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.8.0.6908
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for library_db
CREATE DATABASE IF NOT EXISTS `library_db` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `library_db`;

-- Dumping structure for table library_db.age
CREATE TABLE IF NOT EXISTS `age` (
  `id` int NOT NULL AUTO_INCREMENT,
  `age` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table library_db.age: ~4 rows (approximately)
INSERT IGNORE INTO `age` (`id`, `age`) VALUES
	(1, 'Kids'),
	(2, 'Adults'),
	(3, 'Teens'),
	(4, 'Young Adults');

-- Dumping structure for table library_db.author
CREATE TABLE IF NOT EXISTS `author` (
  `id` int NOT NULL AUTO_INCREMENT,
  `author` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table library_db.author: ~8 rows (approximately)
INSERT IGNORE INTO `author` (`id`, `author`) VALUES
	(1, 'Trevor Willis'),
	(2, 'J. K. Rowling'),
	(3, 'Charles Dickens'),
	(4, 'Williams Shakespeare'),
	(5, 'Martin Wickramasinghe'),
	(6, 'Leonard Woolf'),
	(7, 'BBC Books'),
	(8, 'Brad Huddleston'),
	(9, 'Tony Robbins'),
	(10, 'Dale Carnegie');

-- Dumping structure for table library_db.book
CREATE TABLE IF NOT EXISTS `book` (
  `id` int NOT NULL AUTO_INCREMENT,
  `isbn` varchar(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `author_id` int NOT NULL,
  `language_id` int NOT NULL,
  `category_id` int NOT NULL,
  `age_id` int NOT NULL,
  `status_id` int NOT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `isbn_UNIQUE` (`isbn`),
  KEY `fk_book_language1_idx` (`language_id`),
  KEY `fk_book_category1_idx` (`category_id`),
  KEY `fk_book_status1_idx` (`status_id`),
  KEY `fk_book_age1_idx` (`age_id`),
  KEY `fk_book_author1_idx` (`author_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table library_db.book: ~10 rows (approximately)
INSERT IGNORE INTO `book` (`id`, `isbn`, `name`, `author_id`, `language_id`, `category_id`, `age_id`, `status_id`, `createdAt`, `updatedAt`) VALUES
	(1, '9781474815314', 'Complete Encyclopedia of Formula 1', 1, 1, 1, 2, 1, '2024-11-13 07:19:36', '2024-11-13 07:19:38'),
	(2, '9781849902984', 'TopGear portfolio', 7, 1, 1, 2, 1, '2024-11-13 07:21:17', '2024-11-13 07:21:18'),
	(3, '9789550201341', 'Miriguwa', 5, 2, 2, 2, 1, '2024-11-13 07:23:00', '2024-11-13 07:23:01'),
	(4, '9789550201372', 'Yuganthaya', 5, 2, 2, 1, 1, '2024-11-13 07:24:32', '2024-11-13 07:24:33'),
	(5, '9789558415436', 'Gamperaliya', 5, 2, 2, 1, 1, '2024-11-13 07:24:56', '2024-11-13 07:24:57'),
	(6, '9781432115265', 'Digital Cocaine', 8, 1, 3, 1, 1, '2024-11-13 07:30:22', '2024-11-13 07:30:23'),
	(7, '9781471167508', 'Money Master The Game', 9, 1, 4, 1, 1, '2024-11-13 07:33:26', '2024-11-13 07:33:27'),
	(8, '9788129140197', 'How to stop worrying and start living', 10, 1, 3, 2, 1, '2024-11-13 07:47:46', '2024-11-13 07:47:47'),
	(9, '9780749307844', 'How to Win Friends and Influence People', 10, 1, 3, 1, 1, '2024-11-13 07:49:51', '2024-11-13 07:49:52'),
	(10, '9780883867051', 'The Village in the Jungle', 6, 1, 5, 2, 1, '2024-11-13 07:54:38', '2024-11-13 07:54:39');

-- Dumping structure for table library_db.category
CREATE TABLE IF NOT EXISTS `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `category` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table library_db.category: ~9 rows (approximately)
INSERT IGNORE INTO `category` (`id`, `category`) VALUES
	(1, 'Sports'),
	(2, 'Fiction'),
	(3, 'Self Help'),
	(4, 'Business'),
	(5, 'Non-Fiction'),
	(6, 'Sci-Fi'),
	(7, 'Romance'),
	(8, 'Drama'),
	(9, 'Thriller'),
	(10, 'Mystery'),
	(11, 'Trivia');

-- Dumping structure for table library_db.contest
CREATE TABLE IF NOT EXISTS `contest` (
  `id` int NOT NULL AUTO_INCREMENT,
  `contest_type_id` int NOT NULL,
  `name` varchar(80) NOT NULL,
  `start_datetime` datetime NOT NULL,
  `end_datetime` datetime NOT NULL,
  `age_id` int NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_contest_contest_type1_idx` (`contest_type_id`),
  KEY `fk_contest_age1_idx` (`age_id`),
  KEY `fk_contest_user1_idx` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table library_db.contest: ~0 rows (approximately)
INSERT IGNORE INTO `contest` (`id`, `contest_type_id`, `name`, `start_datetime`, `end_datetime`, `age_id`, `user_id`) VALUES
	(1, 1, 'Triv', '2024-11-07 17:00:19', '2024-11-27 17:00:21', 1, 1),
	(2, 2, 'Dramarama', '2024-11-09 12:24:00', '2024-12-31 10:30:00', 2, 1),
	(3, 4, 'Bookmaster', '2024-11-09 21:26:00', '2024-11-29 00:00:00', 1, 1),
	(4, 6, 'Shakespeare\'s 6 Tales', '2024-11-10 00:00:00', '2024-12-22 00:00:00', 4, 1);

-- Dumping structure for table library_db.contest_has_member
CREATE TABLE IF NOT EXISTS `contest_has_member` (
  `contest_id` int NOT NULL,
  `membercard_id` int NOT NULL,
  `progress` varchar(45) NOT NULL,
  `finishing_place` int NOT NULL,
  PRIMARY KEY (`contest_id`,`membercard_id`),
  KEY `fk_customer_has_contest_contest1_idx` (`contest_id`),
  KEY `fk_customer_has_contest_customer1_idx` (`membercard_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table library_db.contest_has_member: ~3 rows (approximately)
INSERT IGNORE INTO `contest_has_member` (`contest_id`, `membercard_id`, `progress`, `finishing_place`) VALUES
	(1, 1, '84', 2),
	(1, 2, '90', 1),
	(2, 1, '78', 2),
	(2, 2, '90', 1);

-- Dumping structure for table library_db.contest_type
CREATE TABLE IF NOT EXISTS `contest_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table library_db.contest_type: ~4 rows (approximately)
INSERT IGNORE INTO `contest_type` (`id`, `type`) VALUES
	(1, 'Quizzes'),
	(2, 'Oratory'),
	(3, 'Writing'),
	(4, 'Reading Books'),
	(5, 'Toastmasters'),
	(6, 'Drama');

-- Dumping structure for table library_db.language
CREATE TABLE IF NOT EXISTS `language` (
  `id` int NOT NULL AUTO_INCREMENT,
  `language` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table library_db.language: ~7 rows (approximately)
INSERT IGNORE INTO `language` (`id`, `language`) VALUES
	(1, 'English'),
	(2, 'Sinhala'),
	(3, 'Tamil'),
	(4, 'Chinese'),
	(5, 'Russian'),
	(6, 'Hindi'),
	(7, 'German'),
	(8, 'Italian');

-- Dumping structure for table library_db.log
CREATE TABLE IF NOT EXISTS `log` (
  `id` int NOT NULL AUTO_INCREMENT,
  `book_id` int NOT NULL,
  `member_id` int NOT NULL,
  `user_id` int NOT NULL,
  `date_time` datetime NOT NULL,
  `return_status` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_log_book1_idx` (`book_id`),
  KEY `fk_log_customer1_idx` (`member_id`),
  KEY `fk_log_user1_idx` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table library_db.log: ~2 rows (approximately)
INSERT IGNORE INTO `log` (`id`, `book_id`, `member_id`, `user_id`, `date_time`, `return_status`) VALUES
	(1, 1, 2, 1, '2024-11-13 08:41:20', 1),
	(3, 2, 1, 2, '2024-11-17 12:23:30', 1),
	(4, 3, 1, 2, '2024-11-17 12:25:18', 1);

-- Dumping structure for table library_db.member
CREATE TABLE IF NOT EXISTS `member` (
  `membercard_id` int NOT NULL AUTO_INCREMENT,
  `fname` varchar(45) NOT NULL,
  `lname` varchar(45) NOT NULL,
  `dob` date NOT NULL,
  `nic` varchar(12) NOT NULL,
  `mobile` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `membership_id` int NOT NULL,
  `status_id` int NOT NULL,
  PRIMARY KEY (`membercard_id`),
  KEY `fk_customer_status1_idx` (`status_id`),
  KEY `fk_member_membership1_idx` (`membership_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table library_db.member: ~3 rows (approximately)
INSERT IGNORE INTO `member` (`membercard_id`, `fname`, `lname`, `dob`, `nic`, `mobile`, `email`, `membership_id`, `status_id`) VALUES
	(1, 'Shevaan', 'Delpitiya', '2008-05-30', '200820501962', '0767661234', 'shevaandelpitiya@gmail.com', 1, 1),
	(2, 'Shamil', 'Kayil', '2001-10-02', '200101231392', '0771234567', 'shamilkay@gmail.com', 3, 1),
	(3, 'Ashan', 'Jayawardena', '2002-10-26', '200213231284', '0777712345', 'ashanimantha2610@gmail.com', 2, 1),
	(4, 'Sahasra', 'Pamujitha', '2002-05-23', '200221370913', '0770012345', 'shsrapmu235@gmail.com', 1, 1);

-- Dumping structure for table library_db.membership
CREATE TABLE IF NOT EXISTS `membership` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tier` varchar(45) NOT NULL,
  `books_borrowable` int NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table library_db.membership: ~3 rows (approximately)
INSERT IGNORE INTO `membership` (`id`, `tier`, `books_borrowable`, `price`) VALUES
	(1, 'Gold', 7, 600),
	(2, 'Silver', 5, 400),
	(3, 'Bronze', 3, 300);

-- Dumping structure for table library_db.membership_payments
CREATE TABLE IF NOT EXISTS `membership_payments` (
  `id` int NOT NULL AUTO_INCREMENT,
  `membercard_id` int NOT NULL,
  `month` varchar(45) NOT NULL,
  `payment_method_id` int NOT NULL,
  `date_time` datetime NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_subscription_payments_customer1_idx` (`membercard_id`),
  KEY `fk_subscription_payments_payment_method1_idx` (`payment_method_id`),
  KEY `fk_subscription_payments_user1_idx` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table library_db.membership_payments: ~0 rows (approximately)
INSERT IGNORE INTO `membership_payments` (`id`, `membercard_id`, `month`, `payment_method_id`, `date_time`, `user_id`) VALUES
	(1, 4, 'NOVEMBER', 1, '2024-11-15 09:31:33', 1);

-- Dumping structure for table library_db.member_address
CREATE TABLE IF NOT EXISTS `member_address` (
  `id` int NOT NULL AUTO_INCREMENT,
  `member_membership_id` int NOT NULL,
  `no` varchar(10) NOT NULL,
  `line1` varchar(45) NOT NULL,
  `line2` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_member_address_member1_idx` (`member_membership_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table library_db.member_address: ~0 rows (approximately)
INSERT IGNORE INTO `member_address` (`id`, `member_membership_id`, `no`, `line1`, `line2`, `city`) VALUES
	(1, 4, '4', 'Udayana Mawatha', 'Armor St', 'Colombo 14');

-- Dumping structure for table library_db.payment_method
CREATE TABLE IF NOT EXISTS `payment_method` (
  `id` int NOT NULL AUTO_INCREMENT,
  `method` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table library_db.payment_method: ~2 rows (approximately)
INSERT IGNORE INTO `payment_method` (`id`, `method`) VALUES
	(1, 'Cash'),
	(2, 'Card');

-- Dumping structure for table library_db.penalty_payments
CREATE TABLE IF NOT EXISTS `penalty_payments` (
  `id` int NOT NULL AUTO_INCREMENT,
  `log_id` int NOT NULL,
  `penalty_reasons_id` int NOT NULL,
  `payment_method_id` int NOT NULL,
  `date_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_penalty_log1_idx` (`log_id`),
  KEY `fk_penalty_payment_method1_idx` (`payment_method_id`),
  KEY `fk_penalty_reason1_idx` (`penalty_reasons_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table library_db.penalty_payments: ~1 rows (approximately)
INSERT IGNORE INTO `penalty_payments` (`id`, `log_id`, `penalty_reasons_id`, `payment_method_id`, `date_time`) VALUES
	(2, 1, 1, 1, '2024-11-17 11:25:59'),
	(11, 3, 2, 1, '2024-10-17 13:20:29');

-- Dumping structure for table library_db.penalty_reasons
CREATE TABLE IF NOT EXISTS `penalty_reasons` (
  `id` int NOT NULL AUTO_INCREMENT,
  `reason` varchar(100) NOT NULL,
  `fee` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table library_db.penalty_reasons: ~5 rows (approximately)
INSERT IGNORE INTO `penalty_reasons` (`id`, `reason`, `fee`) VALUES
	(1, 'Overdue', 300),
	(2, 'Minor Damage', 300),
	(3, 'Moderate Damage', 300),
	(4, 'Major Damage', 300),
	(5, 'Lost Book', 300);

-- Dumping structure for table library_db.reservation
CREATE TABLE IF NOT EXISTS `reservation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `membercard_id` int NOT NULL,
  `date_time` date NOT NULL,
  `book_id` int NOT NULL,
  `user_id` int NOT NULL,
  `status_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_reservation_user1_idx` (`user_id`),
  KEY `fk_reservation_customer1_idx` (`membercard_id`),
  KEY `fk_reservation_book1_idx` (`book_id`),
  KEY `fk_reservation_status1_idx` (`status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table library_db.reservation: ~2 rows (approximately)
INSERT IGNORE INTO `reservation` (`id`, `membercard_id`, `date_time`, `book_id`, `user_id`, `status_id`) VALUES
	(1, 1, '2024-11-01', 7, 1, 1),
	(2, 2, '2024-11-04', 10, 2, 1);

-- Dumping structure for table library_db.status
CREATE TABLE IF NOT EXISTS `status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table library_db.status: ~2 rows (approximately)
INSERT IGNORE INTO `status` (`id`, `status`) VALUES
	(1, 'Active'),
	(2, 'Inactive');

-- Dumping structure for table library_db.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fname` varchar(45) NOT NULL,
  `lname` varchar(45) NOT NULL,
  `mobile` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `user_type_id` int NOT NULL,
  `status_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_status1_idx` (`status_id`),
  KEY `fk_user_user_types1_idx` (`user_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table library_db.user: ~2 rows (approximately)
INSERT IGNORE INTO `user` (`id`, `fname`, `lname`, `mobile`, `username`, `password`, `user_type_id`, `status_id`) VALUES
	(1, 'Adrien Sanjuna', 'Delpitiya', '0720243878', 'adrsd38', 'Sanju@038', 2, 1),
	(2, 'Ashen', 'Lalantha', '0711231233', 'ashenpola', 'pola321', 1, 1);

-- Dumping structure for table library_db.user_type
CREATE TABLE IF NOT EXISTS `user_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table library_db.user_type: ~2 rows (approximately)
INSERT IGNORE INTO `user_type` (`id`, `type`) VALUES
	(1, 'User'),
	(2, 'Admin');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
