package net.etfbl.dao;

import net.etfbl.dto.ApotekaDTO;

import java.util.ArrayList;

public interface ApotekaDAOInterface {

    public ApotekaDTO apoteka(int id );
    public ArrayList<Integer> apotekeIDs();

}
