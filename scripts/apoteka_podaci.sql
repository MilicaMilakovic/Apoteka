use bp_apoteka;

insert into zaposleni (JMB,Ime,Prezime,KorisnickoIme,Lozinka,DatumRodjenja,Plata) values ('1209997105044','Milica','Milakovic','milica','milica','1997-09-12',1000);
insert into zaposleni (JMB,Ime,Prezime,KorisnickoIme,Lozinka,DatumRodjenja,Plata) values ('1001999105022','Sara','Serdar','sara','sara','1999-01-10',1000);
insert into zaposleni (JMB,Ime,Prezime,KorisnickoIme,Lozinka,DatumRodjenja,Plata) values ('2110997101011','Aleksandar','Knezevic','aco','aco','1997-10-21',1000);
insert into zaposleni (JMB,Ime,Prezime,KorisnickoIme,Lozinka,DatumRodjenja,Plata) values ('1234567891011','Test','Test','test','test','1997-11-11',1000);
select * from zaposleni;

insert into lijek (GenerickiNaziv,Kategorija,ProdajnaCijena,NabavnaCijena,Kontraindikacije,DatumProizvodnje,RokUpotrebe,Kolicina,FarmaceutskiOblik,JacinaLijeka,IzdavanjeNaRecept) values ('Ramipril 5mg','Antihipertenzivi',4.30, 3.12,'Pneumonija','2020-08-03','2022-08-03',125,'Tableta',5,1);
insert into lijek (GenerickiNaziv,Kategorija,ProdajnaCijena,NabavnaCijena,Kontraindikacije,DatumProizvodnje,RokUpotrebe,Kolicina,FarmaceutskiOblik,JacinaLijeka) values ('Amoksicilin','Antibiotici',2.7, 1.9,'Alergija na peniciline','2020-09-07','2022-07-03',215,'Kapsula',500);
insert into lijek (GenerickiNaziv,Kategorija,ProdajnaCijena,NabavnaCijena,Kontraindikacije,DatumProizvodnje,RokUpotrebe,Kolicina,FarmaceutskiOblik,JacinaLijeka) values ('Azitromicin','Antibiotici',7.7, 5.46,'Srcana insuficijencija','2021-05-07','2022-07-03',110,'Tableta',10);
insert into lijek (GenerickiNaziv,Kategorija,ProdajnaCijena,NabavnaCijena,Kontraindikacije,DatumProizvodnje,RokUpotrebe,Kolicina,FarmaceutskiOblik,JacinaLijeka,IzdavanjeNaRecept) values ('Pantoprazol','Inhibitori protonske pumpe',6.7, 4.75,'Bolesti jetre','2021-05-07','2022-07-03',150,'Tableta',20,1);
select * from lijek;

insert into apoteka (Naziv,Adresa,Email) values ('B-pharm','Karadjordjeva 120','bpharm22@mail.com');
insert into zaposlenje (ZaposleniID, ApotekaID,DatumOd,DatumDo) values (2,1,'2019-10-10','2022-10-10');
insert into telefon_apoteke values ('051280060',1);

INSERT INTO `bp_apoteka`.`doktor` (`JMB`, `Ime`, `Prezime`, `SifraTima`, `Ambulanta`, `KontaktTelefon`) VALUES ('1009978105622', 'Milka', 'Krmpot ', '19520', 'Laus', '051/288-840');
INSERT INTO `bp_apoteka`.`doktor` (`JMB`, `Ime`, `Prezime`, `SifraTima`, `Ambulanta`, `KontaktTelefon`) VALUES ('1210965452366', 'Renata', 'Stjepanovi?? ', '19524', 'Laus', '051/288-840');
INSERT INTO `bp_apoteka`.`doktor` (`JMB`, `Ime`, `Prezime`, `SifraTima`, `Ambulanta`, `KontaktTelefon`) VALUES ('0910978542366', 'Milanka', 'Vujinovi?? ', '19525', 'Laus', '051/288-840');
INSERT INTO `bp_apoteka`.`doktor` (`JMB`, `Ime`, `Prezime`, `SifraTima`, `Ambulanta`, `KontaktTelefon`) VALUES ('1206451023', 'Kosana', 'Staneti?? ', '19588', 'Poliklinika', '051/247-307');
INSERT INTO `bp_apoteka`.`doktor` (`JMB`, `Ime`, `Prezime`, `SifraTima`, `Ambulanta`, `KontaktTelefon`) VALUES ('1104978152045', 'Mladen', '??ukalo ', '19585', 'Poliklinika', '051/247-302');
INSERT INTO `bp_apoteka`.`doktor` (`JMB`, `Ime`, `Prezime`, `SifraTima`, `Ambulanta`, `KontaktTelefon`) VALUES ('0708982145233', 'Verica', 'Rupar ', '19568', 'Borik', '051/231-610');
INSERT INTO `bp_apoteka`.`doktor` (`JMB`, `Ime`, `Prezime`, `SifraTima`, `Ambulanta`, `KontaktTelefon`) VALUES ('1309981524511', 'Aleksandar', 'Ljubani?? ', '19622', 'Lazarevo', '051/344-683');

select * from doktor;

INSERT INTO `bp_apoteka`.`pacijent` (`JMB`, `Ime`, `Prezime`, `DatumRodjenja`, `Adresa`, `SifraBolesti`, `DoktorID`) VALUES ('1203999741522', 'Marko', 'Markovic', '1999-03-12', 'Karadjordjeva 5', 'D53', '1');
INSERT INTO `bp_apoteka`.`pacijent` (`JMB`, `Ime`, `Prezime`, `DatumRodjenja`, `Adresa`, `SifraBolesti`, `DoktorID`) VALUES ('2109987451865', 'Pero', 'Peric', '1987-09-21', 'Ulica 5', 'D54', '1');
INSERT INTO `bp_apoteka`.`pacijent` (`JMB`, `Ime`, `Prezime`, `DatumRodjenja`, `Adresa`, `SifraBolesti`, `DoktorID`) VALUES ('1503978254136', 'Jovo', 'Jovic', '1978-03-15', 'Ulica ', 'K78', '3');
INSERT INTO `bp_apoteka`.`pacijent` (`JMB`, `Ime`, `Prezime`, `DatumRodjenja`, `Adresa`, `SifraBolesti`, `DoktorID`) VALUES ('0308983126116', 'Ana', 'Mirkovi??', '1983-08-03', 'Ulica 3', 'M56', '7');
INSERT INTO `bp_apoteka`.`pacijent` (`JMB`, `Ime`, `Prezime`, `DatumRodjenja`, `Adresa`, `SifraBolesti`, `DoktorID`) VALUES ('0512983100067', 'Slavko', 'Popovi??', '1983-12-05', 'Ulica 3', 'D21', '4');
INSERT INTO `bp_apoteka`.`pacijent` (`JMB`, `Ime`, `Prezime`, `DatumRodjenja`, `Adresa`, `SifraBolesti`, `DoktorID`) VALUES ('0607989100027', 'Danijel', 'Stojanovi??', '1989-07-06', 'Ulica 45', 'M76', '2');
INSERT INTO `bp_apoteka`.`pacijent` (`JMB`, `Ime`, `Prezime`, `DatumRodjenja`, `Adresa`, `SifraBolesti`, `DoktorID`) VALUES ('0702964105027', 'Mirjana', 'Gavri??', '1964-02-07', 'Ulica 74', 'Z54', '5');
INSERT INTO `bp_apoteka`.`pacijent` (`JMB`, `Ime`, `Prezime`, `DatumRodjenja`, `Adresa`, `SifraBolesti`, `DoktorID`) VALUES ('1002952100005', 'Nikola', 'Mitrovi??', '1952-02-10', 'Ulica 63', 'Y54', '5');
INSERT INTO `bp_apoteka`.`pacijent` (`JMB`, `Ime`, `Prezime`, `DatumRodjenja`, `Adresa`, `SifraBolesti`, `DoktorID`) VALUES ('1006949100067', 'Stanko', 'Soldat', '1949-06-10', 'Ulica 101', 'R11', '3');
INSERT INTO `bp_apoteka`.`pacijent` (`JMB`, `Ime`, `Prezime`, `DatumRodjenja`, `Adresa`, `SifraBolesti`, `DoktorID`) VALUES ('1010988101124', 'Dejan', 'Babi??', '1988-10-10', 'Ulica 5', 'P00', '6');

select * from pacijent;
INSERT INTO `bp_apoteka`.`recept` (`Ime`, `Prezime`, `BrojZdravstvenogKartona`, `NazivZdravstveneUstanove`, `DatumPropisivanjaLijeka`, `LicniBrojOsiguranika`,`PropisanaKolicina`, `PacijentID`, `DoktorID`, `LijekID`) VALUES ('Marko', 'Markovic', '3698521472', 'Ambulanta Laus', '2021-08-15', '1324','2', '1', '4', '1');
INSERT INTO `bp_apoteka`.`recept` (`Ime`, `Prezime`, `BrojZdravstvenogKartona`, `NazivZdravstveneUstanove`, `DatumPropisivanjaLijeka`, `LicniBrojOsiguranika`,`PropisanaKolicina`, `PacijentID`, `DoktorID`, `LijekID`) VALUES ('Pero', 'Peric', '1234567890', 'Ambulanta Laus', '2021-08-15', '1234','3', '2', '1', '4');
INSERT INTO `bp_apoteka`.`recept` (`Ime`, `Prezime`, `DatumPropisivanjaLijeka`,`PropisanaKolicina`, `PacijentID`, `DoktorID`, `LijekID`) VALUES ('Marko', 'Markovic', '2021-07-21','1', '1', '1', '1');
INSERT INTO `bp_apoteka`.`recept` (`Ime`, `Prezime`, `DatumPropisivanjaLijeka`,`PropisanaKolicina`, `PacijentID`, `DoktorID`, `LijekID`) VALUES ('Mirjana', 'Gavric', '2021-08-17','2', '7', '5', '4');

-- select * from recept;
-- select * from recept r natural join lijek left outer join doktor d on d.DoktorID=r.DoktorID;

-- select * from izdavanje_lijeka;
-- select * from fiskalni_racun;
