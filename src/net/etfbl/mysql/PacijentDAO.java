package net.etfbl.mysql;

import net.etfbl.dto.PacijentDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PacijentDAO {

    public int count(){

        int retVal = 0;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT COUNT(*) FROM pacijent";

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

    public ArrayList<PacijentDTO> pacijenti(){

        ArrayList<PacijentDTO> retVal = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM pacijent";

        try{
            conn= ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()){
                retVal.add(new PacijentDTO(rs.getInt(1),rs.getString(2), rs.getString(3),
                        rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),
                        rs.getString(8),rs.getString(9),rs.getInt(10)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
        }

        return  retVal;
    }
}
