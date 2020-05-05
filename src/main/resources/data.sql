INSERT INTO user (login, email, password, type) VALUES
('kaczor', 'karol@wp.pl', 'haslo1','USER'),
('kaska', 'kasia@gmail.com', 'kasia123','USER'),
('admin','admin@admin.pl','admin','ADMIN'),
('user','user@user.pl','user','USER'),
('mod','mod@mod.pl','mod','MOD');

INSERT INTO adress (user_id, city, street, flat_number) VALUES
(1,'Gdansk','Gronwaldzka 57','21');