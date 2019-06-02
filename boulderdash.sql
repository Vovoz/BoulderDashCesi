-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 02 juin 2019 à 08:32
-- Version du serveur :  5.7.26
-- Version de PHP :  7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `boulderdash`
--

-- --------------------------------------------------------

--
-- Structure de la table `maps`
--

DROP TABLE IF EXISTS `maps`;
CREATE TABLE IF NOT EXISTS `maps` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `time` int(11) NOT NULL,
  `map` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `maps`
--

INSERT INTO `maps` (`id`, `nom`, `time`, `map`) VALUES
(1, 'map1', 200, '########################################$#XXXXX XXXXXXXXXXXXXXXXXXXXXXXXXXXdXXXX#$#XXXdXXXXXXXXXXXXXX XXXXXXXXXXXXXXXXXXX#$#XXXXXXXXXXXXXXXXXXXXXXXXXXXXX XXXXXXXX#$#XXXXXXXXXXXdXXXXXXXXXXXXXXXXXXXXXXXXXX#$#XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX#$#XXXXXXOOOXXXXXXXXXXXXXXXXXXXXXOOOXXXXX#$#XXXXXXXXXXXXXXXOOOXXXXXXXXXXXXXXXXXXXX#$#XXXXXXXXXXXXXXXXXXXXXXXXXXdXXXXXXXXXXX#$#XXXdXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX#$###### ###################X#######d#####$#XXXdXXXXXXXXXXXXXX XXXXXXXXXXXXXXXXXXX#$#XXXXXXXXXXXXXXXXXXXXXXXXXXXXX XXXXXXXX#$#XXXXXXXXXXXdXXXXXXXXXXXXXXXXXXXXXXXXXX#$#XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX#$#XXXXXXOOOXXXXXXXXXXXXXXXXXXXXXOOOXXXXX#$#XXXXXXXXXXXXXXXOOOXXXXXXXXXXXXXXXXXXXX#$#XXXXXXXXXXXXXXXXXXXXXXXXXXdXXXXXXXXXXX#$#XXXdXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX#$########################################'),
(2, 'map2', 200, '########################################$#OXOXOXXXXXXXXXXXX##XXXXXXXXXXXXXXOXOXO#$#XdXXXOXOXOXXXXXXX##XXXXXXXXXOXOXOXXXdX#$#XXXXXXXXXXOXOXOXX##XXXXOXOXOXXXXXXXXXX#$#XXXXXXXXXXXXXXXXX  XXXXXXXXXXXXXXXXXXX#$#XXXXXXXXXdXXXXXXX  XXXXXXXdXXXXXXXXXXX#$#XXXXXXXXXXOXOXOXX##XXXXOXOXOXXXXXXXXXX#$#XdXXXOXOXOXXXXXXX##XXXXXXXXXOXOXOXXXdX#$#OXOXOXXXXXXXXXXXX##XXXXXXXXXXXXXXOXOXO#$#XXXXXXXXXXXXXXXXX##XXXXXXXXXXXXXXXXXXX#$#########xx#######xx#######xx###########\r\n#OXOXOXXXXXXXXXXXX##XXXXXXXXXXXXXXOXOXO#$#XdXXXOXOXOXXXXXXX##XXXXXXXXXOXOXOXXXdX#$#XXXXXXXXXXOXOXOXX##XXXXOXOXOXXXXXXXXXX#$#XXXXXXXXXXXXXXXXX  XXXXXXXXXXXXXXXXXXX#$#XXXXXXXXXdXXXXXXX  XXXXXXXdXXXXXXXXXXX#$#XXXXXXXXXXOXOXOXX##XXXXOXOXOXXXXXXXXXX#$#XdXXXOXOXOXXXXXXX##XXXXXXXXXOXOXOXXXdX#$#OXOXOXXXXXXXXXXXX##XXXXXXXXXXXXXXOXOXO#$#XXXXXXXXXXXXXXXXX##XXXXXXXXXXXXXXXXXXX#'),
(3, 'map3', 200, '########################################$#OOOOOXXXXXXXXXXXX  XXXXXXXXXXXXXXOOOOO#$#XXXXOXXXXXXXXXXXX##XXXXXXXXXXXXXXOXXXX#$#XXXXOXXXXXXXXXXXX##XXXXXXXXXXXXXXOXXXX#$#XXXXOOOOOXXXXXXXX d XXXXXXXXXXOOOOOXXX#$#XXXXXXXXOXXXXXXXX##XXXXXXXXXXOXXXXXXXX#$#XXdXXXXXOXXXXXXXX##XXXXXXXXXXOXXXXXdXX#$#XXXXXXXXOOOOOXXXX##XXXXXOOOOXOXXXXXXXX#$#XXXXXXXXXXXXXXXXX  XXXXXXXXXXXXXXXXXXX#$#XXXXXdXXXXXXXXXXX##XXXXXXXXXXXXXdXXXXX#$############X###########X###############$#OOOOOXXXXXXXXXXXX##XXXXXXXXXXXXXXOOOOO#$#XXXXOXXXXXXXXXXXX  XXXXXXXXXXXXXXOXXXX#$#XXXXOXXXXXXXXXXXX##XXXXXXXXXXXXXXOXXXX#$#XXXXOOOOOXXXXXXXX d XXXXXXXXXXOOOOOXXX#$#XXXXXXXXOXXXXXXXX##XXXXXXXXXXOXXXXXXXX#$#XXdXXXXXOXXXXXXXX##XXXXXXXXXXOXXXXXdXX#$#XXXXXXXXOOOOOXXXX##XXXXXOOOOXOXXXXXXXX#$#XXXXXXXXXXXXXXXXX##XXXXXXXXXXXXXXXXXXX#$#XXXXXdXXXXXXXXXXX  XXXXXXXXXXXXXdXXXXX#$########################################'),
(4, 'map4', 200, '########################################$#XXXXXXXXOXXXXXXXXXXXXXXXOXXXXXXXXXXXXX#$#XXXXXXXOXOXXXXXXXXXXXXXOXOXXXXXXXXXXXX#$#XXdXXXOXXXOXXXXXdXXXXXOXXXOXXXXXXdXXXX#$#XXXXXOXXXXX XXXXXXXXXOXXXXXXOXXXXXXXXX#$#XXXXOXXXXXXXOXXXXXXXOXXXXXXXXOXXXXXXXO#$#XXXOXXXXXXXXXOXXXXXOXXXXXXXXXX XXXXXOX#$#XX XXXXXdXXXXXOXXXOXXXXXXXXXXXXOXXXOXX#$#XOXXXXXXXXXXXXXOXOXXXXXXdXXXXXXXOXOXXX#$#OXXXXXXXXXXXXXXX XXXXXXXXXXXXXXXXOXXXX#$#########X#######X#######X########X#####$#OXXXXXXXXXXXXXOXXXXXXXXXXXXXOXXXXXXXXX#$#XOXXXXdXXXXXXOXOXXXXXXXXXXXOXOXXXXXXXX#$#XXOXXXXXXXXXOXXXOXXXXdXXXXOXXXOXXXXXXX#$#XXX XXXXXXXOXXXXX XXXXXXXOXXXXXOXXXXXX#$#XXXXOXXXXXOXXXXXXXOXXXXXOXXXXXXXOXXXXX#$#XXdXXOXXX XXXXdXXXXOXXXOXXXXdXXXXOXXXO#$#XXXXXXOXOXXXXXXXXXXXOXOXXXXXXXXXXXOXOX#$#XXXXXXXOXXXXXXXXXXXXX XXXXXXXXXXXXXOXX#$##############################$#########'),
(5, 'map5', 200, '########################################$#XOXXXXXdXXXXXXXXXXXXXXXXXXXXXXOXXXXXXX#$#XOXXXXXXXXXXXXXXXXXXXXXXXXXXXXOXXXXXXX#$#XOXXXXXXOOOOOXOXXXXXXXOXOOOOOXOXXXXXXX#$#XOXXXXXXOXXXXXXOXXdXXOXXOXXXXXOXXXXdXX#$#XOXXXXXXOOOOXXXXOXXXOXXXOOOOXXOXXXXXXX#$#XOXXdXXXOXXXXXXXXOXOXXXXOXXXXXOXXXXXXX#$#XOOOOOOXOOOOOXXXXXOXXXXXOOOOOXXOOOOOOX#$#XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX#$#XXXXXXXXXXXXXXXXdXXXXXXXXXXXXXXXXXXXXX#$##### ##### #### ##### ##### ##### #####$#XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX#$#XXXdXXXXXXXXXXOOOOOOOXXXXXXXXXXXXXdXXX#$#XXXXXXXXXXXXXXOXXXXXXXXXXXXXXXXXXXXXXX#$#XXXXXXXXXXXXXXOXOXOXXXXXXXXXXXXXXXXXXX#$#XXXXXXXXXXXXXXOXXXXXOXXXXXXXXXXXXXXXXX#$#XXXXXXXXXXXXXXXXXdXXOXXXXXXXXXXXXXXXXX#$#XXXdXXXXXXXXXXOXOXOXXXXXXXXXXXXXXXdXXX#$#XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX#$########################################');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
