use bp_apoteka;

drop view if exists recept_info;

create view recept_info as
select r.ReceptID, concat(r.Ime,' ', r.prezime) as Pacijent, l.GenerickiNaziv, r.PropisanaKolicina, concat( d.Ime,' ', d.Prezime) as Doktor, r.DatumPropisivanjaLijeka, l.ProdajnaCijena, l.LijekID, r.Vazeci
from recept r natural join lijek l left outer join doktor d on d.DoktorID=r.DoktorID;

INSERT INTO `bp_apoteka`.`izdavanje_lijeka` (`ZaposleniID`, `LijekID`, `ReceptID`, `KolicinaIzdatogLijeka`, `DatumIzdavanja`) VALUES ('1', '1', '1', '1', now());

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

select * from fiskalni_racun;
select * from fiskalni_racun_stavka;

delimiter $$
create trigger ponisi_recept_trig after insert on izdavanje_lijeka 
for each row 
begin
	update recept set Vazeci=0 where ReceptID=new.ReceptID;
end $$
delimiter ;

select * from recept_info;

select * from izdavanje_lijeka;
SELECT * FROM fiskalni_racun;
select * from recept;
select * from recept_info;
select * from fiskalni_racun_stavka;
