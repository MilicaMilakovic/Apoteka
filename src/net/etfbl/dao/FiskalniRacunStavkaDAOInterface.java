package net.etfbl.dao;

import net.etfbl.dto.FiskalniRacunStavkaDTO;

import java.util.ArrayList;

public interface FiskalniRacunStavkaDAOInterface {
    public boolean dodajStavku(FiskalniRacunStavkaDTO stavka);
    public ArrayList<FiskalniRacunStavkaDTO> stavkeNaRacunu(int id);

}
