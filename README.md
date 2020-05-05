# LaboratoryService


**Name: G. B. O. Yashodhika**

**Batch: Y3S1.1.1**

**MicroService: Laboratory Service**

**IT Number: IT18120226**



DatabaseName: laboratory


----------------------------CREATE TABLE--------------------------------

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




------------------------SAMPLE VALUES---------------------------------

INSERT INTO lab VALUES ('0001', 'Hemas Laboratory', 'Waliwita', 'Kaduwela', 'Colombo', 'Western', 'osusal@gmail.com', '0713244631', 'OsuColombo', 'osu@123', '08:00', '17:00');


INSERT INTO lab VALUES ('0002', 'Durdans Laboratory', 'Waliwita', 'Rajagiriya', 'Colombo', 'Western', 'osusal@gmail.com', '0713244631', 'DurdansColombo', 'Durdans@123', '08:00', '17:00');


INSERT INTO lab VALUES ('0003', 'LHD Collection Centre', ' New Hospital Rd', 'Sri Jayawardenepura Kotte', 'Colombo', 'Western', 'LankaHospitals@gmail.com', '0719629800', 'LHDColombo', 'osu@123', '08:00', '19:00');






********************IMPORTANT: Open Time/ Close Time Format in the Registration Form.***************************


	HH: MM AM/PM
  

	example:   08:00 AM 
  
		   07:00 PM
