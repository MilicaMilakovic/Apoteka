package net.etfbl.mysql;

import net.etfbl.dao.TelefonApotekeDAOInterface;
import net.etfbl.dto.TelefonApotekeDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TelefonApotekeDAO implements TelefonApotekeDAOInterface {

    public TelefonApotekeDTO telefonApoteke(int id){

        TelefonApotekeDTO retVal = null;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT Telefon, ApotekaID FROM telefon_apoteke WHERE ApotekaID=?";

        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);

            ps.setInt(1,id);
            rs = ps.executeQuery();

            if(rs.next())
                retVal = new TelefonApotekeDTO(rs.getString(1),rs.getInt(2));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
        }
        return retVal;
    }
}
