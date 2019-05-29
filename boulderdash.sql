-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 29 mai 2019 à 13:25
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

DELIMITER $$
--
-- Procédures
--
DROP PROCEDURE IF EXISTS `MapsByCode`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `MapsByCode` (IN `p_code` CHAR(2))  NO SQL
    SQL SECURITY INVOKER
SELECT * FROM maps where code=p_code$$

DROP PROCEDURE IF EXISTS `MapsById`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `MapsById` (IN `p_id` INT)  NO SQL
SELECT * FROM maps WHERE id = p_id$$

DELIMITER ;

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
(1, 'map1', 200, '\r\n\r\n########################################################################\r\n\r\n#XXXXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX XXXXXXXXXXXXXX#\r\n\r\n#XXXdXXXXXXXXXXXXXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX X#\r\n\r\n#XXXXXXXXXXXXXXXXXXXXXXXXXXXXX XXXXXXXXXXXXOOOXXXXXXXXXXXXXXXXXXXXXXXXX#\r\n\r\n#XXXXXXXXXXXdXXXXXXXXXXXXXXXXXXXXXXXXXXXXX XXXXXXXXXXXXXXXXXXXdXXXXXXXX#\r\n\r\n#XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX#\r\n\r\n#XXXXXXOOOXXXXXXXXXXXXXXXXXXXXXOOOXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX#\r\n\r\n#XXXXXXXXXXXXXXXOOOXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXOOOXXXXXXX#\r\n\r\n#XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXdXXXXXXXXXXXXXXXXXXXXXXXXXXXXX#\r\n\r\n#XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX#\r\n\r\n#XXXXXXXXXdXXXXXXXXXXXXXXXXXXXXXXXXXXOOOXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX#\r\n\r\n##############################################X#########################\r\n\r\n#XXXXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX XXXXXXXXXXXXXX#\r\n\r\n#XXXdXXXXXXXXXXXXXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX X#\r\n\r\n#XXXXXXXXXXXXXXXXXXXXXXXXXXXXX XXXXXXXXXXXXOOOXXXXXXXXXXXXXXXXXXXXXXXXX#\r\n\r\n#XXXXXXXXXXXdXXXXXXXXXXXXXXXXXXXXXXXXXXXXX XXXXXXXXXXXXXXXXXXXdXXXXXXXX#\r\n\r\n#XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX#\r\n\r\n#XXXXXXOOOXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX#\r\n\r\n#XXXXXXXXXXXXXXXOOOXXXXXXXXXXXXXXXXXXXXXXdXXXXXXXXXXXXXXXXXXXOOOXXXXXXX#\r\n\r\n#XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX#\r\n\r\n#XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXOOOXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX#\r\n\r\n#XXXXXXXXXdXXXXXXXXXXXXXXXXXXXXXXXXXXOOOXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX#\r\n\r\n########################################################################\r\n'),
(2, 'map2', 200, '####################################################################\r\n#XXOXOXOXXXXXXXXXXXXXXXXXXXXXXXXX  XXXXXXXXXXXXXXXXXXXXXXXXXOXOXOXX#\r\n#XXXXXXXXXOXOXOXXXXXXXXXXXXXXXXXX##XXXXXXXXXXXXXXXXXXOXOXOXXXXXXXXX#\r\n#XXXXXXXXXXXXXXXXOXOXOXXXXXXXXXXX  XXXXXXXXXXXOXOXOXXXXXXXXXXXXXXXX#\r\n#XXXXXXXXXXXXXXXXXXXXXXXOXOXOXXXX##XXXXOXOXOXXXXXXXXXXXXXXXXXXXXXXX#\r\n#XXXXXdXXXXXXXXXXXXXXXXXXXXXXXXXX  XXXXXXXXXXXXXXXXXXXXXXXXXXdXXXXX#\r\n#XXXXXXXXXXXXXXXXXXXXXXXOXOXOXXXX##XXXXOXOXOXXXXXXXXXXXXXXXXXXXXXXX#\r\n#XXXXXXXXXXXXXXXXOXOXOXXXXXXXXXXX  XXXXXXXXXXXOXOXOXXXXXXXXXXXXXXXX#\r\n#XXXXXXXXXOXOXOXXXXXXXXXXXXXXXXXX##XXXXXXXXXXXXXXXXXXOXOXOXXXXXXXXX#\r\n#XXOXOXOXXXXXXdXXXXXXXXXXXXXXXXXX  XXXXXXXXXXXdXXXXXXXXXXXXXOXOXOXX#\r\n#XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXd  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX#\r\n####################################################################\r\n#XXOXOXOXXXXXXXXXXXXXXXXXXXXXXXXX  XXXXXXXXXXXXXXXXXXXXXXXXXOXOXOXX#\r\n#XXXXXXXXXOXOXOXXXXXXXXXXXXXXXXXX##XXXXXXXXXXXXXXXXXXOXOXOXXXXXXXXX#\r\n#XXXXXXXXXXXXXXXXOXOXOXXXXXXXXXXX  XXXXXXXXXXXOXOXOXXXXXXXXXXXXXXXX#\r\n#XXXXXXXXXXXXXXXXXXXXXXXOXOXOXXXX##XXXXOXOXOXXXXXXXXXXXXXXXXXXXXXXX#\r\n#XXXXXdXXXXXXXXXXXXXXXXXXXXXXXXXX  XXXXXXXXXXXXXXXXXXXXXXXXXXdXXXXX#\r\n#XXXXXXXXXXXXXXXXXXXXXXXOXOXOXXXX##XXXXOXOXOXXXXXXXXXXXXXXXXXXXXXXX#\r\n#XXXXXXXXXXXXXXXXOXOXOXXXXXXXXXXX  XXXXXXXXXXXOXOXOXXXXXXXXXXXXXXXX#\r\n#XXXXXXXXXOXOXOXXXXXXXXXXXXXXXXXX##XXXXXXXXXXXXXXXXXXOXOXOXXXXXXXXX#\r\n#XXOXOXOXXXXXXdXXXXXXXXXXXXXXXXXX  XXXXXXXXXXXdXXXXXXXXXXXXXOXOXOXX#\r\n#XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXd  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX#\r\n####################################################################'),
(3, 'map3', 200, '################################################################\r\n#XXOOOOOOXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXOOOOOOXX#\r\n#XXXXXXXOXXXXXXXX XXXXXXXXXXXX##XXXXXXXXXXXX XXXXXXXXXXOXXXXXXX#\r\n#XXXdXXXOXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXOXXXdXXX#\r\n#XXXXXXXOXXXXXXXXXXXXXXXXXXXXX##XXXXXXXXXXXXXXXXXXXXXXXOXXXXXXX#\r\n#XXXXXXXOOOOOOXXXXXX XXXXXXXXXXXXXXXXXXXX XXXXXXXXOOOOOOXXXXXXX#\r\n#XXXXXXXXXXXXOXXXXXXXXXXXXXXXX##XXXXXXXXXXXXXXXXXXOXXXXXXXXXXXX#\r\n#XXXXXXXXXXXXOXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXOXXXXXXXXXXXX#\r\n#XXXXXXXXXdXXOXXXXXXXXXXXXXXXX##XXXXXXXXXXXXXXXXXXOXXdXXXXXXXXX#\r\n#XXXXXXXXXXXXOXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXOXXXXXXXXXXXX#\r\n#XXXXXXXXXXXXXXXXXXXXXXXXXXXXX d XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX#\r\n######  ##########################################  ############\r\n#XXOOOOOOXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXOOOOOOXX#\r\n#XXXXXXXOXXXXXXXX XXXXXXXXXXXX##XXXXXXXXXXXX XXXXXXXXXXOXXXXXXX#\r\n#XXXdXXXOXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXOXXXdXXX#\r\n#XXXXXXXOXXXXXXXXXXXXXXXXXXXXX##XXXXXXXXXXXXXXXXXXXXXXXOXXXXXXX#\r\n#XXXXXXXOOOOOOXXXXXX XXXXXXXXXXXXXXXXXXXX XXXXXXXXOOOOOOXXXXXXX#\r\n#XXXXXXXXXXXXOXXXXXXXXXXXXXXXX##XXXXXXXXXXXXXXXXXXOXXXXXXXXXXXX#\r\n#XXXXXXXXXXXXOXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXOXXXXXXXXXXXX#\r\n#XXXXXXXXXdXXOXXXXXXXXXXXXXXXX##XXXXXXXXXXXXXXXXXXOXXdXXXXXXXXX#\r\n#XXXXXXXXXXXXOXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXOXXXXXXXXXXXX#\r\n#XXXXXXXXXXXXXXXXXXXXXXXXXXXXX d XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX#\r\n################################################################'),
(4, 'map4', 200, '################################################################\r\n#OXXXXXXXXXXXXXXXXXXXOXOXXXXXXXXXXXXXXXXXXXOXOXXXXXXXXXXXXXXXXX#\r\n#XOXXXXXXXXXXXXXXXXXOXXXOXXXXXXXXXXXXXXXXXOXXXOXXXXXXXXXXXXXXXX#\r\n#XXOXXXXXXXXXXXXXXXOXXXXXOXXXXXXXXXXXXXXXOXXXXXOXXXXXXXXXXXXXXX#\r\n#XXXOXXXXXdXXXXXXXOXXXXXXXOXXXXXXdXXXXXX XXXXXXXOXXXXXXdXXXXXXO#\r\n#XXXXOXXXXXXXXXXXOXXXXXXXXXOXXXXXXXXXXXOXXXXXXXXXOXXXXXXXXXXXOX#\r\n#XXXXXOXXXXXXXXX XXXXXXXXXXXOXXXXXXXXXOXXXXXXXXXXXOXXXXXXXXXOXX#\r\n#XdXXXX XXXXXXXOXXXXXXdXXXXXXOXXXXXXXOXXXXXXdXXXXXXOXXXXXXXOXXX#\r\n#XXXXXXXOXXXXXOXXXXXXXXXXXXXXX XXXXXOXXXXXXXXXXXXXXXOXXXXX XXXX#\r\n#XXXXXXXXOXXXOXXXXXXXXXXXXXXXXXOXXXOXXXXXXXXXXXXXXXXXOXXXOXXXXX#\r\n#XXXXXXXXXOXOXXXXXXXXXXXXXXXXXXXOXOXXXXXXXXXXXXXXXXXXX XOXXXXXX#\r\n###########X#####################X####################X#########\r\n#OXXXXXXXXXXXXXXXXXXXOXOXXXXXXXXXXXXXXXXXXXOXOXXXXXXXXXXXXXXXXX#\r\n#XOXXXXXXXXXXXXXXXXXOXXXOXXXXXXXXXXXXXXXXXOXXXOXXXXXXXXXXXXXXXX#\r\n#XXOXXXXXXXXXXXXXXXOXXXXXOXXXXXXXXXXXXXXXOXXXXXOXXXXXXXXXXXXXXX#\r\n#XXXOXXXXXdXXXXXXXOXXXXXXXOXXXXXXdXXXXXX XXXXXXXOXXXXXXdXXXXXXO#\r\n#XXXXOXXXXXXXXXXXOXXXXXXXXXOXXXXXXXXXXXOXXXXXXXXXOXXXXXXXXXXXOX#\r\n#XXXXXOXXXXXXXXX XXXXXXXXXXXOXXXXXXXXXOXXXXXXXXXXXOXXXXXXXXXOXX#\r\n#XdXXXX XXXXXXXOXXXXXXdXXXXXXOXXXXXXXOXXXXXXdXXXXXXOXXXXXXXOXXX#\r\n#XXXXXXXOXXXXXOXXXXXXXXXXXXXXX XXXXXOXXXXXXXXXXXXXXXOXXXXX XXXX#\r\n#XXXXXXXXOXXXOXXXXXXXXXXXXXXXXXOXXXOXXXXXXXXXXXXXXXXXOXXXOXXXXX#\r\n#XXXXXXXXXOXOXXXXXXXXXXXXXXXXXXXOXOXXXXXXXXXXXXXXXXXXX XOXXXXXX#\r\n################################################################'),
(5, 'map5', 200, '################################################################\r\n#XOXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXOXXXXXXXXXXXXXXXXXX#\r\n#XOXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXOXXXXXXXXXXXXXXXXXX#\r\n#XOXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXOXXXXXXXXXXXXXXXXXX#\r\n#XOXXXXXXXXXXOOOOOOOXXOXXXXXXXXXOXXOOOOOOOXXOXXXXXXXXXXXXXXXXXX#\r\n#XOXXXXXXXXXXOXXXXXXXXXOXXXXXXXOXXXOXXXXXXXXOXXXXXXXXXXXXXXXXXX#\r\n#XOXXXXXXXXXXOOOOOXXXXXXOXXXXXOXXXXOOOOOXXXXOXXXXXXXXXXXXXXXXXX#\r\n#XOXXXXXXXXXXOXXXXXXXXXXXOXXXOXXXXXOXXXXXXXXOXXXXXXXXXXXXXXXXXX#\r\n#XOXXXXXXXXXXOXXXXXXXXXXXXOXOXXXXXXOXXXXXXXXOXXXXXXXXXXXXXXXXXX#\r\n#XOOOOOOOOOXXOOOOOOOXXXXXXXOXXXXXXXOOOOOOOXXOOOOOOOOOXXXXXXXXXX#\r\n#XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX#\r\n##############################################X#################\r\n#XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX#\r\n#XXXXXXXXXXXXXXXXXXXXXXXXOOOOOOOOOXXXXXXXXXXXXXXXXXXXXXXXXXXXXX#\r\n#XXXXXXXXXXXXXXXXXXXXXXXXOXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX#\r\n#XXXXXXXXXXXXXXXXXXXXXXXXOXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX#\r\n#XXXXXXXXXXXXXXXXXXXXXXXXOXOXOXOXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX#\r\n#XXXXXXXXXXXXXXXXXXXXXXXXOXXXXXXXOXXXXXXXXXXXXXXXXXXXXXXXXXXXXX#\r\n#XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXOXXXXXXXXXXXXXXXXXXXXXXXXXXXXX#\r\n#XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXOXXXXXXXXXXXXXXXXXXXXXXXXXXXXX#\r\n#XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXOXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX#\r\n#XXXXXXXXXXXXXXXXXXXXXXOOOOOOOOOXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX#\r\n##X#############################################################');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;