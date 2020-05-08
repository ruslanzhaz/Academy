-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Май 08 2020 г., 16:42
-- Версия сервера: 10.4.11-MariaDB
-- Версия PHP: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `animes_project`
--

-- --------------------------------------------------------

--
-- Структура таблицы `course`
--

CREATE TABLE `course` (
  `id` int(11) NOT NULL,
  `kind` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `year` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `course`
--

INSERT INTO `course` (`id`, `kind`, `name`, `year`) VALUES
(2, 'hard', 'chunin', 2),
(3, 'super hard', '90rk', 1);

-- --------------------------------------------------------

--
-- Структура таблицы `entry`
--

CREATE TABLE `entry` (
  `id` int(11) NOT NULL,
  `courseId` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `entry`
--

INSERT INTO `entry` (`id`, `courseId`, `name`, `surname`) VALUES
(1, 2, 'Ssa', 'www');

-- --------------------------------------------------------

--
-- Структура таблицы `studentdata`
--

CREATE TABLE `studentdata` (
  `id` int(11) NOT NULL,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `rank` varchar(255) NOT NULL,
  `clan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `studentdata`
--

INSERT INTO `studentdata` (`id`, `login`, `password`, `rank`, `clan`) VALUES
(5, 'sanzhar', '123', 'genin', 'uchiha');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `entry`
--
ALTER TABLE `entry`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `studentdata`
--
ALTER TABLE `studentdata`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `course`
--
ALTER TABLE `course`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `entry`
--
ALTER TABLE `entry`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT для таблицы `studentdata`
--
ALTER TABLE `studentdata`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
