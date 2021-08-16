package net.etfbl.mysql;

import net.etfbl.dao.ReceptDAOInterface;
import net.etfbl.dao.ReceptInfoDAOInterface;
import net.etfbl.dto.ReceptInfoDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReceptInfoDAO implements ReceptInfoDAOInterface {

    public ArrayList<ReceptInfoDTO> informacije(){

        ArrayList<ReceptInfoDTO> retVal= new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps =null;
        ResultSet rs = null;

        String query = "SELECT * FROM recept_info";

        try{

            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();

            while(rs.next()){
                retVal.add(new ReceptInfoDTO(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getDouble(4),rs.getString(5),
                        rs.getString(6),rs.getDouble(7),rs.getInt(8),
                        rs.getBoolean(9)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
        }
        return  retVal;
    }
}
