CREATE DATABASE laboratory;
USE laboratory;

CREATE TABLE lab
(
labRegID varchar(11) PRIMARY KEY,
labName varchar(50),
labAddress varchar(70),
labCity varchar(40),
labDestrict varchar(30),
labProvince varchar(40),
labEmail varchar(70),
labContactNum varchar(15),
labUsername varchar(15),
labPassword varchar(15),
OpenTime varchar(10),
CloseTime varchar(10)
);