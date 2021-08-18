package net.etfbl.dao;

import net.etfbl.dto.FiskalniRacunDTO;

public interface FiskalniRacunDAOInterface {

    public FiskalniRacunDTO kreirajRacun();
    public FiskalniRacunDTO getByID(int id);
    public int count();
}
