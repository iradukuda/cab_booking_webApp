-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 16, 2023 at 03:57 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bookings`
--

-- --------------------------------------------------------

--
-- Table structure for table `reg_car`
--

CREATE TABLE `reg_car` (
  `car_id` bigint(20) NOT NULL,
  `car_color` varchar(255) DEFAULT NULL,
  `car_make` varchar(255) DEFAULT NULL,
  `car_model` varchar(255) DEFAULT NULL,
  `car_year` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reg_car`
--

INSERT INTO `reg_car` (`car_id`, `car_color`, `car_make`, `car_model`, `car_year`, `status`) VALUES
(1, 'red', 'car make', 'car model', '2023-06-03', 'not available'),
(2, 'dark', 'car make', 'car model', '2023-05-04', 'available');

-- --------------------------------------------------------

--
-- Table structure for table `signup_user`
--

CREATE TABLE `signup_user` (
  `user_id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` int(11) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `signup_user`
--

INSERT INTO `signup_user` (`user_id`, `email`, `gender`, `password`, `phone`, `role`, `username`) VALUES
(1, 'peter@gmail.com', 'male', '123', 780694, 'normal', 'peter'),
(2, 'admin@gmail.com', 'female', 'admin', 78898, 'admin', 'admin'),
(3, 'jean@gamail.com', 'male', 'nana', 780694, 'normal', 'jaja'),
(4, NULL, NULL, NULL, 0, 'normal', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `reg_car`
--
ALTER TABLE `reg_car`
  ADD PRIMARY KEY (`car_id`);

--
-- Indexes for table `signup_user`
--
ALTER TABLE `signup_user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `reg_car`
--
ALTER TABLE `reg_car`
  MODIFY `car_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `signup_user`
--
ALTER TABLE `signup_user`
  MODIFY `user_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
