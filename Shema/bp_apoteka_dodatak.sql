use bp_apoteka;

drop view recept_info;

create view recept_info as
select r.ReceptID, concat(r.Ime,' ', r.prezime) as Pacijent, l.GenerickiNaziv, r.PropisanaKolicina, concat( d.Ime,' ', d.Prezime) as Doktor, r.DatumPropisivanjaLijeka, l.ProdajnaCijena
from recept r natural join lijek l left outer join doktor d on d.DoktorID=r.DoktorID;

select * from recept_info;