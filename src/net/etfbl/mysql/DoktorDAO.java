package net.etfbl.mysql;

import net.etfbl.dao.DoktorDAOInterface;
import net.etfbl.dto.DoktorDTO;
import net.etfbl.dto.PacijentDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DoktorDAO implements DoktorDAOInterface {

    public int count(){

        int retVal = 0;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT COUNT(*) FROM doktor";

        try{
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            rs.next();
            retVal = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
        }

        return retVal;
    }

    public ArrayList<DoktorDTO> doktori(){

        ArrayList<DoktorDTO> retVal = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM doktor";

        try{
            conn= ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()){
                retVal.add(new DoktorDTO(rs.getInt(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
        }

        return  retVal;
    }


    public ArrayList<DoktorDTO> pretragaPoImenu(String ime){

        ArrayList<DoktorDTO> retVal = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM doktor WHERE Ime like " + "'%"+ime+"%'";

        try{
            conn= ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()){
                retVal.add(new DoktorDTO(rs.getInt(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
        }

        return  retVal;
    }

}
