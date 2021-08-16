use bp_apoteka;

select * from lijek;

insert into lijek (GenerickiNaziv,Kategorija,ProdajnaCijena,NabavnaCijena,Kontraindikacije,DatumProizvodnje,RokUpotrebe,Kolicina,FarmaceutskiOblik,JacinaLijeka) values ('Ramipril 5mg','Antihipertenzivi',4.30, 3.12,'Pneumonija','2020-08-03','2022-08-03',5,'Tableta',5);


update lijek
set GenerickiNaziv='Ramipril'
where LijekID=1;

select * from lijek;

insert into lijek (GenerickiNaziv,Kategorija,ProdajnaCijena,NabavnaCijena,Kontraindikacije,DatumProizvodnje,RokUpotrebe,Kolicina,FarmaceutskiOblik,JacinaLijeka) values ('Amoksicilin','Antibiotici',2.7, 1.9,'Alergija na peniciline','2020-09-07','2022-07-03',5,'Kapsula',500);
select * from lijek;

select * from zaposleni;

select * from lijek where Kategorija like '%anti%';
insert into zaposleni (JMB,Ime,Prezime,KorisnickoIme,Lozinka,DatumRodjenja,Plata) values ('1209997105044','Milica','Milakovic','milica','milica','1997-09-12',1000);
insert into zaposleni (JMB,Ime,Prezime,KorisnickoIme,Lozinka,DatumRodjenja,Plata) values ('1001999105022','Sara','Serdar','sara','sara','1999-01-10',1000);
insert into zaposleni (JMB,Ime,Prezime,KorisnickoIme,Lozinka,DatumRodjenja,Plata) values ('2110997101011','Aleksandar','Knezevic','aco','aco','1997-10-21',1000);
insert into zaposleni (JMB,Ime,Prezime,KorisnickoIme,Lozinka,DatumRodjenja,Plata) values ('1234567891011','Test','Test','test','test','1997-11-11',1000);

select exists(select JMB,Ime,Prezime,KorisnickoIme,Lozinka,DatumRodjenja,Plata from zaposleni
where KorisnickoIme='milicaaazaposlenje' and Lozinka='milica');

select * from zaposleni natural join zaposlenje; 
select count(*) from lijek;

alter table zaposlenje modify DatumDo date;
insert into apoteka (Naziv,Adresa,Email) values ('B-pharm','Karadjordjeva 120','bpharm22@mail.com');
insert into zaposlenje (ZAPOSLENI_ZaposleniID, APOTEKA_ApotekaID,DatumOd) values (2,1,'2019-10-10');
select * from apoteka;

select * from zaposlenje;
select ApotekaID from apoteka;
insert into telefon_apoteke values ('051280060',1);
select * from telefon_apoteke;

select JMB,Ime,Prezime,KorisnickoIme,Lozinka,DatumRodjenja,Plata,DatumOd,DatumDo,ApotekaID,Naziv,Adresa,Email from zaposleni
inner join zaposlenje on ZaposleniID=ZAPOSLENI_ZaposleniID
inner join apoteka on ApotekaID=APOTEKA_ApotekaID;

UPDATE `bp_apoteka`.`zaposlenje` SET `DatumDo` = '2022-10-10' WHERE (`ZAPOSLENI_ZaposleniID` = '2') and (`APOTEKA_ApotekaID` = '1');



select * from izdavanje_lijeka;

alter table izdavanje_lijeka drop column SifraIzdatogLijeka;

