package net.etfbl.mysql;

import net.etfbl.dto.FiskalniRacunDTO;
import net.etfbl.dto.FiskalniRacunStavkaDTO;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FiskalniRacunStavkaDAO {

    public boolean dodajStavku(FiskalniRacunStavkaDTO stavka){
        boolean retVal = false;

        Connection conn = null;
        PreparedStatement ps = null;

        String query = "INSERT INTO fiskalni_racun_stavka (LijekID,RacunID,Kolicina,Cijena) values"+
                        "(?, ?, ?, ?)";

        try{
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);

            ps.setInt(1,stavka.getLijekID());
            ps.setInt(2,stavka.getRacunID());
            ps.setBigDecimal(3, BigDecimal.valueOf(stavka.getKolicina()));
            ps.setBigDecimal(4,BigDecimal.valueOf(stavka.getCijena()));

            retVal = ps.executeUpdate() == 1;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
        }

        return  retVal;
    }

    public ArrayList<FiskalniRacunStavkaDTO> stavkeNaRacunu(int id){
        ArrayList<FiskalniRacunStavkaDTO> retVal = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM fiskalni_racun_stavka WHERE RacunID=?";

        try{
          conn = ConnectionPool.getInstance().checkOut();
          ps = conn.prepareStatement(query);

          ps.setInt(1,id);

          rs = ps.executeQuery();

          while (rs.next())
              retVal.add(new FiskalniRacunStavkaDTO(rs.getInt(1),rs.getInt(2),
                      rs.getDouble(3),rs.getDouble(4)));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
        }

        return  retVal;
    }
}
