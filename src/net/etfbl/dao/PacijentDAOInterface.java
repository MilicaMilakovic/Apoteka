package net.etfbl.dao;

import net.etfbl.dto.PacijentDTO;

import java.util.ArrayList;

public interface PacijentDAOInterface {
    public int count();
    public ArrayList<PacijentDTO> pacijenti();
    public ArrayList<PacijentDTO> pretragaPoImenu(String ime);
}
