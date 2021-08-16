use bp_apoteka;

drop view recept_info;

create view recept_info as
select r.ReceptID, concat(r.Ime,' ', r.prezime) as Pacijent, l.GenerickiNaziv, r.PropisanaKolicina, concat( d.Ime,' ', d.Prezime) as Doktor, r.DatumPropisivanjaLijeka, l.ProdajnaCijena
from recept r natural join lijek l left outer join doktor d on d.DoktorID=r.DoktorID;

select * from recept_info;

delimiter $$
create trigger generisi_racun_trig after insert on izdavanje_lijeka 
for each row 
begin 
	declare cijena decimal(6,2);
    set cijena = (select ProdajnaCijena from lijek where LijekID = new.LijekID);
	insert into fiskalni_racun (DatumIzdavanja,Cijena,ZaposleniID,LijekID,ReceptID) values (now(),cijena,new.ZaposleniID,new.LijekID,new.ReceptID);
end $$
delimiter ;


select * from izdavanje_lijeka;
SELECT * FROM fiskalni_racun;

