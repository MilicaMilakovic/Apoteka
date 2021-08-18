use bp_apoteka;

-- pogled - prikazivanje odabranih informacija o receptu
drop view if exists recept_info;
create view recept_info as
select r.ReceptID, concat(r.Ime,' ', r.prezime) as Pacijent, l.GenerickiNaziv, r.PropisanaKolicina, concat( d.Ime,' ', d.Prezime) as Doktor, r.DatumPropisivanjaLijeka, l.ProdajnaCijena, l.LijekID, r.Vazeci
from recept r natural join lijek l left outer join doktor d on d.DoktorID=r.DoktorID;

-- select * from recept;

-- procedura koja generise i vraca novi racun
drop procedure if exists generisi_racun;
delimiter $$
CREATE PROCEDURE `generisi_racun` ()
BEGIN
	declare id int default 0;
	insert into fiskalni_racun (DatumIzdavanja,CijenaUkupno)values (now(),0);
    set id = last_insert_id();
    select * from fiskalni_racun where RacunID=id;
END$$
delimiter ;

-- triger kojim se ponistava recept ukoliko je propisani lijek vec izdat
drop trigger if exists ponisti_recept_trig;
delimiter $$
create trigger ponisi_recept_trig after insert on izdavanje_lijeka 
for each row 
begin
	declare cijena_sum decimal(6,2);
	update recept set Vazeci=0 where ReceptID=new.ReceptID;
end $$
delimiter ;

-- procedura koja umanjuje dostupnu kolicinu lijeka za izdatu kolicinu tog lijeka 
drop procedure if exists umanji_kolicinu_proc;
delimiter $$
CREATE PROCEDURE `umanji_kolicinu_proc` (in racID int)
BEGIN
	declare finished integer default 0;
    declare id integer;
    declare kol decimal(6,2);
    declare staraKolicina decimal(6,2);
    
	declare kursor cursor for select LijekID, Kolicina from fiskalni_racun_stavka where RacunID=racID;
    
    declare continue handler for not found set finished = 1;
    open kursor;
    
    umanji: LOOP 
		fetch kursor into id, kol;
        
        if finished=1 then 
			leave umanji;
        end if;     
        
        set staraKolicina =(select Kolicina from lijek where LijekID=id);
        update lijek set Kolicina=(staraKolicina-kol) where LijekID=id;
        
	end loop umanji;
    close kursor;
END$$
delimiter ;

-- triger koji poziva gorepomenutu proceduru u slucaju evidencije izdavanja lijeka
drop trigger if exists umanji_kolicinu_trig;
delimiter $$
create trigger umanji_kolicinu_trig after insert on izdavanje_lijeka
for each row
begin
	call umanji_kolicinu_proc(new.RacunID);
end $$
delimiter ;

-- triger kojim se racuna ukupna cijena na racunu, na osnovu cijena pojedinacnih stakvi
drop trigger if exists sracunaj_cijenu;
delimiter $$
create trigger sracunaj_cijenu after insert on fiskalni_racun_stavka 
for each row 
begin
	declare ukupno decimal (6,2);
    set ukupno = (select CijenaUkupno from fiskalni_racun where RacunID = new.RacunID);
    update fiskalni_racun set CijenaUkupno = ukupno + new.Cijena where RacunID= new.RacunID;
end $$
delimiter ;


select * from izdavanje_lijeka;
select * from fiskalni_racun_stavka;
SELECT * FROM fiskalni_racun;
select * from recept;
select * from recept_info;
select * from lijek;
select * from doktor;
select * from zaposleni;
select * from pacijent;
