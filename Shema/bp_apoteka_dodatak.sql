use bp_apoteka;

drop view if exists recept_info;
create view recept_info as
select r.ReceptID, concat(r.Ime,' ', r.prezime) as Pacijent, l.GenerickiNaziv, r.PropisanaKolicina, concat( d.Ime,' ', d.Prezime) as Doktor, r.DatumPropisivanjaLijeka, l.ProdajnaCijena, l.LijekID, r.Vazeci
from recept r natural join lijek l left outer join doktor d on d.DoktorID=r.DoktorID;

select * from recept;

-- izdavanje lijeka na recept

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

call generisi_racun;

drop trigger if exists ponisti_recept_trig;
delimiter $$
create trigger ponisi_recept_trig after insert on izdavanje_lijeka 
for each row 
begin
	declare cijena_sum decimal(6,2);
	update recept set Vazeci=0 where ReceptID=new.ReceptID;
end $$
delimiter ;

drop trigger if exists izavanje_bez_recepta;
delimiter $$
create trigger izdavanje_bez_recepta before insert on izdavanje_lijeka
for each row
begin
	declare id int;
    set id = (select ReceptID from new.izdavanje_lijeka);
    if( id = 0) then
    set new.ReceptID = null;
    end if;
end$$
delimiter ; 

drop trigger izdavanje_bez_recepta;

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
SELECT * FROM fiskalni_racun;
select * from recept;
select * from recept_info;
select * from fiskalni_racun_stavka;
select * from lijek;
