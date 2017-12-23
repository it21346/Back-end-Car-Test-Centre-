-- phpMyAdmin SQL Dump
-- version 3.4.11.1deb2+deb7u8
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 23, 2017 at 04:30 PM
-- Server version: 5.5.58
-- PHP Version: 5.4.45-0+deb7u11

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `it21346`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `surname` varchar(45) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=58 ;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`ID`, `name`, `surname`, `email`) VALUES
(52, 'Stelios', 'Bombai', 'steliosbombai@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `engineer`
--

CREATE TABLE IF NOT EXISTS `engineer` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `id_system` varchar(11) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `surname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `secretary`
--

CREATE TABLE IF NOT EXISTS `secretary` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `id_system` varchar(11) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `surname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `vehicle`
--

CREATE TABLE IF NOT EXISTS `vehicle` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `model` varchar(128) DEFAULT NULL,
  `registration_number` varchar(20) DEFAULT NULL,
  `type` enum('Fortigo','Epivatigo') DEFAULT NULL,
  `date` date DEFAULT NULL,
  `owner_name` varchar(128) DEFAULT NULL,
  `owner_surname` varchar(128) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_VEHICLE_OWNER` (`customer_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=29 ;

--
-- RELATIONS FOR TABLE `vehicle`:
--   `customer_id`
--       `customer` -> `ID`
--

--
-- Dumping data for table `vehicle`
--

INSERT INTO `vehicle` (`ID`, `model`, `registration_number`, `type`, `date`, `owner_name`, `owner_surname`, `customer_id`) VALUES
(26, 'Ford Fiesta', 'IMP 1001', 'Epivatigo', NULL, 'Stelios', 'Bombai', 52);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `vehicle`
--
ALTER TABLE `vehicle`
  ADD CONSTRAINT `FK_VEHICLE` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
