INSERT INTO public.fitgymuserrole (rolename)  VALUES 	('ROLE_ADMIN'),('ROLE_MANAGEMENT'),('ROLE_STAFF'),('ROLE_INSTRUCTOR'),('ROLE_MEMBER');

INSERT INTO public.fitgymuser (userimie, usernazwisko, useremail, fitgymid, password, adres, userroleid, enabled) VALUES 	('Ewa', 'Niemiec', 'user@fitgym.pl', '101', '101','Lublin',1, true), 	('Jan', 'Kowalski', 'user@fitgym.pl', '102', '102','Szczecin',1, true), 	('Adam', 'Nowak', 'user@fitgym.pl', '103', '103', 'Warszawa',1, true), 	('Anna', 'Misiek', 'user@fitgym.pl', '104', '104', 'Legionowo',2, true), 	('Tomasz', 'Nieznalski', 'user@fitgym.pl', '105', '105', 'Marki',2,true), 	('Anna','Wąsik','user@fitgym.pl','106','106','Warszawa',3,true), 	('Jan','Kowalewski','user@fitgym.pl','107','107','Warszawa',3,true), 	('Robert','Grabkowski','user@fitgym.pl','108','108','Warszawa',3,true), 	('Krzysztof','Dąbrowski','user@fitgym.pl','109','109','Warszawa',4,true), 	('Konrad','Kozłowski','user@fitgym.pl','110','110','Warszawa',4,true), 	('Izabela','Kot','user@fitgym.pl','111','111','Warszawa',5,true), 	('Paweł','Zawadzki','user@fitgym.pl','112','112','Warszawa',5,true), 	('Przemysław','Gieroj','user@fitgym.pl','113','113','Siedlce',5,true), 	('Jerzy','Wróblewski','user@fitgym.pl','114','114','Izabelin',5,true);

INSERT INTO public.fitgymworkouts (workoutend, workoutstart, userid) VALUES 	('2018-05-14 16:51:29', '2018-05-14 16:51:55', 1), 	('2018-02-14 15:51:29', '2018-02-14 16:59:55', 1);