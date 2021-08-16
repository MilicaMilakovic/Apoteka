package net.etfbl.dao;

import net.etfbl.dto.ZaposleniDTO;

import java.util.ArrayList;

public interface ZaposleniDAOInterface {

    public boolean logIn(String username, String password);
    public ArrayList<ZaposleniDTO> zaposleni();
    public boolean dodajZaposlenog(ZaposleniDTO zaposleni);
    public boolean obrisiZaposlenog(int id);
    public boolean azuriraj(ZaposleniDTO zaposleni);
    public ArrayList<ZaposleniDTO> pretragaPoImenu(String ime);
    public int count();
    public ZaposleniDTO getByName(String ime);

}
