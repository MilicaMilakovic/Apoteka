package net.etfbl.mysql;

import net.etfbl.dao.IzdavanjeLijekaDAOInterface;
import net.etfbl.dto.IzdavanjeLijekaDTO;

import java.math.BigDecimal;
import java.sql.*;

public class IzdavanjeLijekaDAO implements IzdavanjeLijekaDAOInterface {

    public boolean evidentiraj(IzdavanjeLijekaDTO izdavanjeLijeka){

        boolean retVal = false;

        Connection conn = null;
        PreparedStatement ps = null;

        String query = "INSERT INTO izdavanje_lijeka (ZaposleniID, LijekID, ReceptID, " +
                "KolicinaIzdatogLijeka, DatumIzdavanja, RacunID ) VALUES "+
                "(?, ?, ?, ?, ?,?)";

        try{
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);

            ps.setInt(1, izdavanjeLijeka.getZaposleniID());
            ps.setInt(2,izdavanjeLijeka.getLijekID());
            if(izdavanjeLijeka.getReceptID()==0)
//                ps.setNull(3,);
                ps.setString(3, null);
            else
                ps.setInt(3,izdavanjeLijeka.getReceptID());
            ps.setBigDecimal(4, BigDecimal.valueOf(izdavanjeLijeka.getKolicinaIzdatogLijeka()));
            ps.setString(5,izdavanjeLijeka.getDatumIzdavanja());
            ps.setInt(6,izdavanjeLijeka.getRacunID());

            retVal =   ps.executeUpdate() == 1;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return  retVal;
    }
}
