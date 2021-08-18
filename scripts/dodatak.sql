-- korisnicki nalog
create user 'root'@'localhost' identified by 'root';
grant select, insert, update, delete on bp_apoteka.* to 'root'@'localhost';
grant execute on procedure generisi_racun to 'root'@'localhost';
grant execute on procedure umanji_kolicinu_proc to 'root'@'localhost';
flush privileges;