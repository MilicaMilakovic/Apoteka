package net.etfbl.dao;

import net.etfbl.dto.LijekDTO;

import java.util.ArrayList;

public interface LijekDAOInterface {

    public LijekDTO lijek (int id);
    public ArrayList<LijekDTO> lijekovi();
    public boolean dodajLijek(LijekDTO lijek);
    public boolean azurirajLijek(LijekDTO lijek);
    public boolean obrisiLijek(int lijekID);
    public int count();
    public ArrayList<LijekDTO> pretragaPoNazivu(String naziv);



}
