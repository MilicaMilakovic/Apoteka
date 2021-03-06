package net.etfbl.mysql;

import net.etfbl.dao.ZaposlenjeDAOInterface;
import net.etfbl.dto.ZaposlenjeDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ZaposlenjeDAO implements ZaposlenjeDAOInterface {

    public ZaposlenjeDTO zaposlenje(int zaposleniID, int apotekaID) {

        ZaposlenjeDTO retVal = null;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query= "SELECT ZaposleniID, ApotekaID,DatumOd,DatumDo FROM zaposlenje "
                        + "WHERE ZaposleniID=? and ApotekaID=?";

        try{
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);

            ps.setInt(1,zaposleniID);
            ps.setInt(2,apotekaID);

            rs = ps.executeQuery();

            if(rs.next())
                retVal = new ZaposlenjeDTO(rs.getInt(1),rs.getInt(2),
                                            rs.getDate(3).toString(),rs.getDate(4).toString());


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
        }
        return  retVal;
    }


}
