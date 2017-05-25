-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 02, 2016 at 07:23 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `javaproject`
--

-- --------------------------------------------------------

--
-- Table structure for table `lifeliners`
--

CREATE TABLE IF NOT EXISTS `lifeliners` (
  `p_id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `p_name` varchar(20) NOT NULL,
  `p_surname` varchar(20) NOT NULL,
  `p_date_of_birth` date NOT NULL,
  `p_blood_type` varchar(20) NOT NULL,
  `p_phone` varchar(20) NOT NULL,
  `p_email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `p_country` varchar(20) NOT NULL,
  PRIMARY KEY (`p_id`),
  UNIQUE KEY `p_id` (`p_id`),
  KEY `p_email` (`p_email`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Dumping data for table `lifeliners`
--

INSERT INTO `lifeliners` (`p_id`, `p_name`, `p_surname`, `p_date_of_birth`, `p_blood_type`, `p_phone`, `p_email`, `p_country`) VALUES
(1, 'Yasser', 'El Kabbout', '1995-01-07', 'O+', '+905428767876', 'admin@yasserkabbout.com', 'Cyprus'),
(3, 'Leena', 'Osman', '2013-02-01', 'AB+', 'NA', 'NA', 'Lebanon'),
(4, 'Sara', 'El Kabbout', '2005-01-02', 'O+', 'NA', 'NA', 'Lebanon'),
(5, 'Ayberk', 'tosun', '1990-01-15', 'AB-', '+905428653247', 'ayberk@hotmail.com', 'Turkey'),
(6, 'Ulus', 'bayram', '1985-09-12', 'B+', '+905332658741', 'ulus@gmail.com', 'Turkey'),
(7, 'Baris', 'bay', '1975-06-03', 'A+', '+90542789563', 'baris@gmail.com', 'Turkey'),
(8, 'Abdullah', 'jamil', '1985-02-03', 'O-', '+90542365478', 'asil@gmail.com', 'Turkey'),
(9, 'Meryem', 'Masri', '1998-12-31', 'B+', '+14528654856', 'Mariam@hotmail.com', 'USA'),
(10, 'Jafar', 'Mohtaseb', '1995-11-17', 'A-', '+905428142536', 'jafar@gmail.com', 'Palestine'),
(11, 'erkan', 'tosun', '1995-01-01', 'AB-', '+905482475869', 'erkan@gmail.com', 'Cyprus'),
(13, 'Ebru ', 'Dagli', '1996-01-05', 'AB-', '+905236478953', 'ebru@hotmail.com', 'Turkey'),
(14, 'Emre', 'Gultekin', '2000-02-05', 'O-', '+90563214785', 'Emre@gmail.com', 'Cyprus');

-- --------------------------------------------------------

--
-- Table structure for table `lifeliners_records`
--

CREATE TABLE IF NOT EXISTS `lifeliners_records` (
  `p_id` int(10) unsigned NOT NULL,
  `blood_pressure` int(10) unsigned NOT NULL,
  `body_temperature` int(10) unsigned NOT NULL,
  `blood_sugar_level` int(10) unsigned NOT NULL,
  `heart_rate` int(10) unsigned NOT NULL,
  `calories_burned` int(10) unsigned NOT NULL,
  `record_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`p_id`,`record_time`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lifeliners_records`
--

INSERT INTO `lifeliners_records` (`p_id`, `blood_pressure`, `body_temperature`, `blood_sugar_level`, `heart_rate`, `calories_burned`, `record_time`) VALUES
(1, 122, 38, 75, 59, 540, '2016-01-02 17:53:58'),
(1, 125, 38, 75, 60, 1500, '2016-01-02 17:55:18'),
(3, 120, 37, 85, 60, 2000, '2016-01-02 18:02:49'),
(4, 110, 38, 88, 70, 251, '2016-01-02 18:14:28'),
(13, 110, 37, 80, 58, 2500, '2016-01-02 18:05:18'),
(13, 110, 38, 86, 59, 151, '2016-01-02 18:10:19');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
