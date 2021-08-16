CREATE PROCEDURE `generisi_racun` ()
BEGIN
	declare id int default 0;
	insert into fiskalni_racun (DatumIzdavanja,CijenaUkupno)values (now(),0);
    set id = last_insert_id();
    select * from fiskalni_racun where RacunID=id;
END
