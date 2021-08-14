package net.etfbl.dao;

import net.etfbl.dto.ZaposlenjeDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ZaposlenjeDAO {

    public ZaposlenjeDTO zaposlenje(int zaposleniID, int apotekaID) {

        ZaposlenjeDTO retVal = null;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query= "SELECT ZAPOSLENI_ZaposleniID,APOTEKA_ApotekaID,DatumOd,DatumDo FROM zaposlenje "
                        + "WHERE ZAPOSLENI_ZaposleniID=? and APOTEKA_ApotekaID=?";

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
