package net.etfbl.dao;

import net.etfbl.dto.DoktorDTO;

import java.util.ArrayList;

public interface DoktorDAOInterface {

    public int count();
    public ArrayList<DoktorDTO> doktori();
    public ArrayList<DoktorDTO> pretragaPoImenu(String ime);

}
