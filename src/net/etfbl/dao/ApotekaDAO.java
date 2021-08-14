package net.etfbl.dao;

import net.etfbl.dto.ApotekaDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ApotekaDAO {

    public ApotekaDTO apoteka(int id ){
        ApotekaDTO retVal = null;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT ApotekaID,Naziv,Adresa,Email FROM apoteka WHERE ApotekaID=?";

        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);

            ps.setInt(1,id);
            rs = ps.executeQuery();

            if(rs.next())
                retVal = new ApotekaDTO(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getString(4));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
        }

        return retVal;
    }

    public ArrayList<Integer> apotekeIDs(){
        ArrayList<Integer> retVal = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT ApotekaID from apoteka";

        try{
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();

            while(rs.next())
                retVal.add(rs.getInt(1));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return retVal;

    }
}
