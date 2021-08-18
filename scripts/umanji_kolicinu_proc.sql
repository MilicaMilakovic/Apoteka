CREATE PROCEDURE `umanji_kolicinu_proc` ()
BEGIN
	declare finished integer default 0;
    declare id integer;
    declare kol decimal(6,2);
    declare staraKolicina decimal(6,2);
	declare kursor cursor for select LijekID from fiskalni_racun_stavka where RacunID=new.RacunID;
    declare continue handler for not found set finished = 1;

    open kursor;
    umanji: LOOP 
		fetch kursor into id, kol;
        
        if finished=1 then 
			leave umanjiLoop;
        end if;     
        
        set staraKolicina =(select Kolicina from lijek where LijekID=id);
        update lijek set Kolicina=staraKolicina-kol where LijekID=id;
        
	end loop umanji;
    close kursor;
END
