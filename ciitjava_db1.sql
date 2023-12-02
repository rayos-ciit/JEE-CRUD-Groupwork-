-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 30, 2023 at 04:09 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ciitjava_db1`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `id` int(11) NOT NULL,
  `em` varchar(255) NOT NULL,
  `fn` varchar(255) NOT NULL,
  `mn` varchar(255) NOT NULL,
  `ln` varchar(255) NOT NULL,
  `ucn` varchar(255) NOT NULL,
  `ua` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`id`, `em`, `fn`, `mn`, `ln`, `ucn`, `ua`) VALUES
(1, 'zach.nogueras@ciit.edu.ph', 'Zach Alexandre', 'Carreon', 'Nogueras', '09060585191', 'Earth'),
(4, 'janrein.rayos@ciit.edu.ph', 'Janrein', 'Sarabillo', 'Rayos', '123123', 'Earth'),
(5, 'nathan.alilam@ciit.edu.ph', 'Nathan Josh', 'Malto', 'Alilam', '456789', 'Earth'),
(9, 'stanley.buenaventura@ciit.edu.ph', 'Stanley Gabrielle', 'Cruz', 'Buenaventura', '222333', 'Earth');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
