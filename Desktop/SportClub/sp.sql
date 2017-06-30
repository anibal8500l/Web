DROP SCHEMA

IF EXISTS sportclub;
  CREATE SCHEMA sportclub COLLATE = utf8_general_ci;

USE sportclub;


CREATE TABLE IF NOT EXISTS `courts` (
  `court_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(50) NOT NULL,
  `image` varchar(255) NOT NULL,
  `price` decimal(5,2) NOT NULL,
  `score` bigint(20) NOT NULL,
  `sport_center_id` bigint(20) NOT NULL,
  PRIMARY KEY (`court_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

INSERT INTO `courts` (`court_id`, `type`, `image`, `price`, `score`, `sport_center_id`) VALUES
(1, 'football', '1-1.jpg', '100.00', 0, 1),
(2, 'football', '1-2.jpg', '130.00', 0, 1),
(3, 'football','1-3.jpg','80.00',0,1),
(4, 'futsal', '1-4.jpg','67.00',0,1)
;

CREATE TABLE IF NOT EXISTS `events` (
  `event_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_in` timestamp NULL DEFAULT NULL,
  `date_out` timestamp NULL DEFAULT NULL,
  `description` text NOT NULL,
  `team1_id` bigint(20) NOT NULL,
  `team2_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `court_id` bigint(20) NOT NULL,
  PRIMARY KEY (`event_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

INSERT INTO `events` (`event_id`, `date_in`, `date_out`, `description`, `team1_id`, `team2_id`, `user_id`, `court_id`) VALUES
(1, '2016-12-04 13:15:00', '2016-12-04 15:45:00', 'torneo relámpago', 1, 2, 1, 1),
(2,"2017/04/21 07:30:00","2016/05/23 09:30:00",'Evento deportivo de lujo',2,1,3,2),
(3,"2018/03/23 05:30:00","2016/05/24 09:30:00",'torneo de futbol y voley',3,3,1,3)
;

CREATE TABLE IF NOT EXISTS `event_scores` (
  `event_score_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `team1_score` int(5) NOT NULL,
  `team2_score` int(5) NOT NULL,
  PRIMARY KEY (`event_score_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

INSERT INTO `sportclub`.`event_scores`
(`event_score_id`,
`team1_score`,
`team2_score`)
VALUES
(1,2,1),
(2,3,1),
(3,5,4),
(4,2,2),
(5,1,1)
;

CREATE TABLE IF NOT EXISTS `news` (
  `new_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `short` text NOT NULL,
  `body` text NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `post_date` datetime NOT NULL,
  PRIMARY KEY (`new_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `sport_centers` (
  `sport_center_id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(250) NOT NULL,
  `address` varchar(250) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `image` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`sport_center_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

INSERT INTO `sport_centers` (`sport_center_id`, `name`, `address`, `phone`, `image`, `description`, `user_id`) VALUES
(1, 'La Lozita', 'Jr. Emilio Roseel670 Urb. La B Pueblo Libre, Lima.', 'Cel 954-678-456', 'la-lozita.jpg', 'Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. ', 8),
(2, 'La del barrio', 'Jr. Pablo Neruda N°110 – Surquillo / Referencia Alt.cdra 22 de Angamos', 'Cel 932-556-789', 'la-del-barrio.jpg', 'Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. ', 8),
(3, 'El Churrito', 'Av. Tomas Marsano N°1411 Surquillo', 'Cel 900-378-451', 'el-churrito.jpg', 'Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. ', 8),
(4, 'La Siete', 'Av. La Marina cdra. 35 S/N – San Miguel ', 'Cel 999-123-122', 'la-siete.jpg', 'Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. ', 8),
(5, 'La Diez', 'Av. Vargas Machuca 211- San Juan de Miraflores', 'Cel 993-165-354', 'la-diez.jpg', 'Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. ', 8),
(6, 'Kurasami', 'Jr. La Calera de La Merced N° 177 / Estadio Municipal Carlos Moscoso', 'Cel 969-757-467', 'kurasami.jpg', 'Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. ', 8),
(7, 'El Deportivo', 'Calle Doña Edelmira Mz. A2 Lt 1 Urb. Los Rosales-Surco', 'Cel 979-858-433', 'el-deportivo.jpg', 'Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. ', 8),
(8, 'El Palacio', 'Av. Venezuela cdra. 34 s/n - San Miguel, Lima', 'Cel 980-837-467', 'el-palacio.jpg', 'Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. ', 8);

CREATE TABLE IF NOT EXISTS `teams` (
  `team_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(250) NOT NULL,
  PRIMARY KEY (`team_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

INSERT INTO `teams` (`team_id`, `name`) VALUES
(1, 'Equipo A'),
(2, 'Los Naranjos'),
(3, 'Liverpool'),
(4, 'Las Palmas');

CREATE TABLE IF NOT EXISTS `team_players` (
  `team_player_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `team_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`team_player_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `users` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `user_name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `role` varchar(50) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

INSERT INTO `users` (`user_id`, `email`, `user_name`, `password`, `first_name`, `last_name`, `role`) VALUES
(1, 'darze@gmail.com', 'darze', '1bcb5ec0f3209527199a2c66cc2a08cc', 'Richard', 'Cerdan Diaz', 'admin'),
(2, 'jeremyandrey@yahoo.com', 'jeremyandrey', '5936442fd1dd38b200f1f69811f33b66', 'Jeremy', 'Fernández Jiménez', 'user'),
(3, 'emiliolb@gmail.com', 'emiliolb', 'c5a1a98649a7874de0def093eb136262', 'Emilio', 'López Barrera', 'user'),
(4, 'zafiro17@hotmail.com', 'zafiro17', '41483a7d8d6621c4fc23e816c0efe7ba', 'Yaneli', 'Valdes Mora', 'user'),
(5, '1120332@utp.edu.pe', '1120332', '190b8ce9ea14ae7066b2b4eb92635b43', 'Luis', 'Vilcayauri Quispe', 'user'),
(6, '1310319@utp.edu.pe', '1310319', '9a2a3ba925fdace5fda8c833c1f617c8', 'Kiara', 'Ruiz Solari', 'user'),
(7, 'joeruiz@gmail.com', 'joeruiz', '9a2a3ba925fdace5fda8c833c1f617c8', 'Joel', 'Ruiz Valdes', 'user'),
(8, '1021483@utp.edu.pe', '1021483', '2fc2db6085ca6a4e26cf34b6970c0722', 'Anibal', 'Chuco Abarca', 'owner');

CREATE TABLE IF NOT EXISTS `user_activities` (
  `activity_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `all_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `type` varchar(50) NOT NULL,
  PRIMARY KEY (`activity_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;