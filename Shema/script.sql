use bp_apoteka;

select * from lijek;

insert into lijek (GenerickiNaziv,Kategorija,ProdajnaCijena,NabavnaCijena,Kontraindikacije,DatumProizvodnje,RokUpotrebe,Kolicina,FarmaceutskiOblik,JacinaLijeka) values ('Ramipril 5mg','Antihipertenzivi',4.30, 3.12,'Pneumonija','2020-08-03','2022-08-03',5,'Tableta',5);

select * from lijek;

update lijek
set GenerickiNaziv='Ramipril'
where LijekID=1;

select * from lijek;
