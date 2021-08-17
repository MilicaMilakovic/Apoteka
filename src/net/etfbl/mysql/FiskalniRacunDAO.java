package net.etfbl.mysql;

import net.etfbl.dto.FiskalniRacunDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FiskalniRacunDAO {

    public FiskalniRacunDTO kreirajRacun(){

        FiskalniRacunDTO retVal = null;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "call generisi_racun ";

        try{
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();
            if(rs.next())
                retVal = new FiskalniRacunDTO(rs.getInt(1),rs.getString(2),rs.getDouble(3));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
        }

        return retVal;
    }

    public void izdajNaRecept(){

    }

    public FiskalniRacunDTO getByID(int id){
        FiskalniRacunDTO retVal = null;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM fiskalni_racun where RacunID=?";

        try{
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);

            ps.setInt(1,id);

            rs = ps.executeQuery();

            if(rs.next())
                retVal = new FiskalniRacunDTO(rs.getInt(1),rs.getString(2),rs.getDouble(3));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
        }

        return  retVal;
    }
}
