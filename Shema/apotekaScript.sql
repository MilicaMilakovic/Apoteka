use bp_apoteka;

insert into zaposleni (JMB,Ime,Prezime,KorisnickoIme,Lozinka,DatumRodjenja,Plata) values ('1209997105044','Milica','Milakovic','milica','milica','1997-09-12',1000);
insert into zaposleni (JMB,Ime,Prezime,KorisnickoIme,Lozinka,DatumRodjenja,Plata) values ('1001999105022','Sara','Serdar','sara','sara','1999-01-10',1000);
insert into zaposleni (JMB,Ime,Prezime,KorisnickoIme,Lozinka,DatumRodjenja,Plata) values ('2110997101011','Aleksandar','Knezevic','aco','aco','1997-10-21',1000);
insert into zaposleni (JMB,Ime,Prezime,KorisnickoIme,Lozinka,DatumRodjenja,Plata) values ('1234567891011','Test','Test','test','test','1997-11-11',1000);
select * from zaposleni;


insert into lijek (GenerickiNaziv,Kategorija,ProdajnaCijena,NabavnaCijena,Kontraindikacije,DatumProizvodnje,RokUpotrebe,Kolicina,FarmaceutskiOblik,JacinaLijeka) values ('Ramipril 5mg','Antihipertenzivi',4.30, 3.12,'Pneumonija','2020-08-03','2022-08-03',5,'Tableta',5);
insert into lijek (GenerickiNaziv,Kategorija,ProdajnaCijena,NabavnaCijena,Kontraindikacije,DatumProizvodnje,RokUpotrebe,Kolicina,FarmaceutskiOblik,JacinaLijeka) values ('Amoksicilin','Antibiotici',2.7, 1.9,'Alergija na peniciline','2020-09-07','2022-07-03',5,'Kapsula',500);
insert into lijek (GenerickiNaziv,Kategorija,ProdajnaCijena,NabavnaCijena,Kontraindikacije,DatumProizvodnje,RokUpotrebe,Kolicina,FarmaceutskiOblik,JacinaLijeka) values ('Azitromicin','Antibiotici',7.7, 5.46,'Srcana insuficijencija','2021-05-07','2022-07-03',10,'Tableta',10);
insert into lijek (GenerickiNaziv,Kategorija,ProdajnaCijena,NabavnaCijena,Kontraindikacije,DatumProizvodnje,RokUpotrebe,Kolicina,FarmaceutskiOblik,JacinaLijeka) values ('Pantoprazol','Inhibitori protonske pumpe',6.7, 4.75,'Bolesti jetre','2021-05-07','2022-07-03',10,'Tableta',20);
select * from lijek;

insert into apoteka (Naziv,Adresa,Email) values ('B-pharm','Karadjordjeva 120','bpharm22@mail.com');
insert into zaposlenje (ZaposleniID, ApotekaID,DatumOd,DatumDo) values (2,1,'2019-10-10');
insert into telefon_apoteke values ('051280060',1);

alter table zaposlenje modify DatumDo date default 0;
select * from zaposlenje;

SELECT ZaposleniID, ApotekaID,DatumOd,DatumDo FROM zaposlenje where ZaposleniID=2 and ApotekaID=1;
alter table recept add Izdat tinyint default 0;
alter table recept drop column Napomena;
alter table recept drop column AdresaZdravstveneUstanove;
select * from doktor;


select * from pacijent;
alter table pacijent rename column Terapija to SifraBolesti;

select * from recept;

create view recept_info as
select r.ReceptID, r.Ime as pacijentIme, r.Prezime, l.GenerickiNaziv, d.Ime as doktorIme, r.DatumPropisivanjaLijeka, l.ProdajnaCijena
from (recept r natural join lijek l) natural join doktor d;

select * from recept_info;