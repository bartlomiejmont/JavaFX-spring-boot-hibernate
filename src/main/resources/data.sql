INSERT INTO user (login, email, password, type) VALUES
('kaczor', 'karol@wp.pl', 'haslo1','USER'),
('kaska', 'kasia@gmail.com', 'kasia123','USER'),
('admin','admin@admin.pl','admin','ADMIN'),
('user','user@user.pl','user','USER'),
('mod','mod@mod.pl','mod','MOD');

INSERT INTO adress (user_id, city, street, flat_number) VALUES
(1,'Gdansk','Gronwaldzka 57','21'),
(2,'Gdynia','Jana Pawla 25','12'),
(3,'Warszawa','Grodzka 2','11'),
(4,'Sopot','Wiejska 11','4'),
(5,'Gdansk','Gronwaldzka 21','3');

INSERT INTO HOUSING_ADS (user_id, title, description, price, area, type) VALUES
(1,'mieszkanie w sopocie','ciepłe przytulne mieszkanko w centrum sopotu', 1000,20,'RENT'),
(1,'Willa w osowej','Ogromna willa w osowej, duży metraż piękne widoki', 900000,300,'BUY'),
(2,'3 pokoje Warszawa','3-pokojewe mieszkanie w centrum Warszawy do wynajęcia', 3000,35,'RENT');

INSERT INTO ITEM_ADS (user_id, item_name, description, price) values
(1, 'wazon antyczny','antyczny wazon z XII wieku',200),
(2, 'rower','rower górski wygląda jak nowy', 700);

INSERT INTO JOB_POSTING (user_id, job_title, description, min_salary, max_salary) VALUES
(1,'Sprzedawca/Kasjer','Szukam sprzedawcy w sklepie żabka', 2000, 2500),
(2,'Junior Java Developer','Programista Java/JavaScript', 3000, 5000),
(2,'Senior HTML Developer','Wymagane 20 letnie doświadczenie programowania w języku HTML', 5000, 6000);

INSERT INTO message (user_sending_id, user_receiving_id, title, content) values
(2,1,'kupie wazon','Panie karolu kupie wazon, mam horom curke'),
(2,1,'kupie wazon','Halllo ?, Panie Karolu!!! Ile pan spóści ?');

INSERT INTO USER_OPINION (user_id, user_giving_opinion_id, description, rating) VALUES
(1,2,'NIE POLECAM TEGO UŻYTKOWNIKA',1),
(2,1,'Dięki, działa !!!',5);

INSERT INTO RENTAL_ADS (user_id, posting_title, description, cost_per_day) VALUES
(1,'pożyczę wiertarkę','Mam wiertarkę 400W do wypożyczenia najlepiej na terenie trójmiasta',20),
(3,'pożyczę serwerownie','Servery VPS po 3 latach zniżka 5%',10);