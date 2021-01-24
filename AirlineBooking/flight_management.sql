drop schema if exists `airlinedatabase`;
create schema if not exists `airlinedatabase` default character set utf8;
use airlinedatabase;

create table if not exists `airlinedatabase`.`user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(30) NOT NULL,
  `lname` varchar(10) NOT NULL,
  `userid` varchar(10) NOT NULL UNIQUE,
  `password` varchar(20) NOT NULL UNIQUE,
  `dob` varchar(50) NOT NULL,
  `city` varchar(100) NOT NULL,
  `mobile` varchar(30) NOT NULL,
  `gender` varchar(5) NOT NULL,
  `email` varchar(100) NOT NULL,
  `img` varchar(10),
  PRIMARY KEY (id)
);

create table if not exists `airlinedatabase`.`Admin` (
  `id` int(11) NOT NULL ,
  `name` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL UNIQUE
);
  
create table if not exists `airlinedatabase`.`domestic_airline` (
  `flightid` int(10) NOT NULL UNIQUE,
  `service_provider` varchar(30) NOT NULL,
  `ticket_cost` float NOT NULL,
  `source` varchar(20) NOT NULL,
  `destination` varchar(20) NOT NULL,
  `journey_date` varchar(10) NOT NULL,
  `departure_time` varchar(10) NOT NULL,
  `arrival_time` varchar(20) NOT NULL,
  `seat` int(11) NOT NULL
);

create table if not exists `airlinedatabase`.`international_airline` (
  `flightid` int(10) NOT NULL UNIQUE,
  `service_provider` varchar(30) NOT NULL,
  `ticket_cost` float NOT NULL,
  `source` varchar(20) NOT NULL,
  `destination` varchar(20) NOT NULL,
  `journey_date` varchar(10) NOT NULL,
  `departure_time` varchar(10) NOT NULL,
  `arrival_time` varchar(20) NOT NULL,
  `seat` int(11) NOT NULL
);


insert into `domestic_airline` (`flightid`,`service_provider`,`ticket_cost`,`source`,`destination`,`journey_date`,`departure_time`,`arrival_time`,`seat`) values
(7656, 'Indigo Air Boing 112', 4500, 'Kolkata', 'Delhi', '07-01-2021', '10:15', '12:15', 180),
(9812, 'Air India Boing 29', 5500, 'Delhi', 'Kolkata', '08-01-2021', '21:30', '23:40', 180),
(4688, 'Jet Airways', 6000, 'Mumbai', 'Delhi', '09-01-2021', '22:00', '12:30', 180),
(1509, 'Spice Jet', 6500, 'Mumbai', 'Chennai', '10-01-2021', '23:00', '01:30', 180),
(4682, 'Vistara', 7000, 'Chennai', 'Kolkata', '11-01-2021', '15:30', '17:30', 180),
(4699, 'Air Asia', 7500, 'Chennai', 'Delhi', '12-01-2021', '22:00', '12:30', 180);

insert into `international_airline` (`flightid`,`service_provider`,`ticket_cost`,`source`,`destination`,`journey_date`,`departure_time`,`arrival_time`,`seat`) values
(1235, 'Emirates', 25000, 'Kolkata', 'London', '07-01-2021', '10:15', '12:15', 450),
(4568, 'Vistara', 30000, 'Kolkata', 'Newyork', '08-01-2021', '21:30', '23:40', 300),
(4780, 'Spice Jet', 3500, 'Kolkata', 'Dhaka', '09-01-2021', '22:00', '12:30', 400);


insert into `Admin` (`id`,`name`,`password`) values
(101, 'Soumi', 'Admin');

