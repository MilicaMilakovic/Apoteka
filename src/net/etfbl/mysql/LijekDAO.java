package net.etfbl.mysql;

import net.etfbl.dao.LijekDAOInterface;
import net.etfbl.dto.LijekDTO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;


public class LijekDAO implements LijekDAOInterface {


    public LijekDTO lijek (int id){

        LijekDTO retVal = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT LijekID, GenerickiNaziv, Kategorija, ProdajnaCijena, NabavnaCijena" +
                ", Kontraindikacije, DatumProizvodnje, RokUpotrebe, Kolicina, DodatniOpis,FarmaceutskiOblik," +
                " JacinaLijeka, IzdavanjeNaRecept, Aktivan"
                + " FROM lijek"
                + " WHERE LijekID=?";

        try{
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if(rs.next()){
                retVal = new LijekDTO(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getBigDecimal(4).doubleValue(),
                        rs.getBigDecimal(5).doubleValue(),rs.getString(6),
                        rs.getDate(7).toString(), rs.getDate(8).toString(),
                        rs.getBigDecimal(9).doubleValue(), rs.getString(10),
                        rs.getString(11),rs.getBigDecimal(12).doubleValue(),
                        rs.getBoolean(13), rs.getBoolean(14));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
        }

        return retVal;
    }


    public ArrayList<LijekDTO> lijekovi(){

        ArrayList<LijekDTO> retVal = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM lijek where Aktivan=1";

        try{
//            conn = ConnectionPool.getInstance().checkOut();
//            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bp_apoteka?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false"
, "root", "root");
            ps = conn.prepareStatement(query);

            rs= ps.executeQuery();

            while(rs.next()){
                retVal.add( new LijekDTO(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getBigDecimal(4).doubleValue(),
                        rs.getBigDecimal(5).doubleValue(),rs.getString(6),
                        rs.getDate(7).toString(), rs.getDate(8).toString(),
                        rs.getBigDecimal(9).doubleValue(), rs.getString(10),
                        rs.getString(11),rs.getBigDecimal(12).doubleValue(),
                        rs.getBoolean(13),rs.getBoolean(14)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(conn!= null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            //ConnectionPool.getInstance().checkIn(conn);
        }

        return retVal;
    }

    public boolean dodajLijek(LijekDTO lijek){
        boolean retVal = false;
        Connection conn = null;
        PreparedStatement ps = null;

        String query = "INSERT INTO lijek (GenerickiNaziv,Kategorija,ProdajnaCijena,NabavnaCijena,Kontraindikacije," +
                "DatumProizvodnje,RokUpotrebe,Kolicina,DodatniOpis,FarmaceutskiOblik,JacinaLijeka,IzdavanjeNaRecept) VALUES "+
                "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

        try{
            conn = ConnectionPool.getInstance().checkOut();
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bp_apoteka?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false"
//                    , "root", "root");

            ps = conn.prepareStatement(query);
            ps.setString(1,lijek.getGenerickiNaziv());
            ps.setString(2,lijek.getKategorija());
            ps.setBigDecimal(3, BigDecimal.valueOf(lijek.getProdajnaCijena()));
            ps.setBigDecimal(4, BigDecimal.valueOf(lijek.getNabavnaCijena()));
            ps.setString(5,lijek.getKontraindikacije());
            ps.setDate(6, Date.valueOf(lijek.getDatumProizvodnje()));
            ps.setDate(7,Date.valueOf(lijek.getRokUpotrebe()));
            ps.setBigDecimal(8,BigDecimal.valueOf(lijek.getKolicina()));
            ps.setString(9,lijek.getDodatniOpis());
            ps.setString(10,lijek.getFarmaceutskiOblik());
            ps.setBigDecimal(11,BigDecimal.valueOf(lijek.getJacinaLijeka()));
            ps.setBoolean(12,lijek.isIzdavanjeNaRecept());

            retVal = ps.executeUpdate() == 1;

        } catch (SQLException  e ){
            e.printStackTrace();

        } finally {
            ConnectionPool.getInstance().checkIn(conn);
//            if(conn!= null) {
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }

        }

        return retVal;

    }

    public boolean azurirajLijek(LijekDTO lijek){

        boolean retVal = false;
        Connection conn = null;
        PreparedStatement ps = null;

        String query = "UPDATE lijek SET "
                + "GenerickiNaziv=?, "
                + "Kategorija=?, "
                + "ProdajnaCijena=?,"
                + "NabavnaCijena=?, "
                + "Kontraindikacije=?, "
                + "DatumProizvodnje=?, "
                + "RokUpotrebe=?, "
                + "Kolicina=?,"
                + "DodatniOpis=?,"
                + "FarmaceutskiOblik=?,"
                + "JacinaLijeka=?"
                //+ "IzdavanjeNaRecept=?"
                + "WHERE LijekID=?";

        try{
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            ps.setString(1,lijek.getGenerickiNaziv());
            ps.setString(2,lijek.getKategorija());
            ps.setBigDecimal(3, BigDecimal.valueOf(lijek.getProdajnaCijena()));
            ps.setBigDecimal(4, BigDecimal.valueOf(lijek.getNabavnaCijena()));
            ps.setString(5,lijek.getKontraindikacije());
            ps.setDate(6, Date.valueOf(lijek.getDatumProizvodnje()));
            ps.setDate(7,Date.valueOf(lijek.getRokUpotrebe()));
            ps.setBigDecimal(8,BigDecimal.valueOf(lijek.getKolicina()));
            ps.setString(9,lijek.getDodatniOpis());
            ps.setString(10,lijek.getFarmaceutskiOblik());
            ps.setBigDecimal(11,BigDecimal.valueOf(lijek.getJacinaLijeka()));
           // ps.setBoolean(12,lijek.isIzdavanjeNaRecept());
            ps.setInt(12, lijek.getLijekID());

            retVal = ps.executeUpdate() == 1;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
        }

        return  retVal;
    }

    public boolean obrisiLijek(int lijekID){
        boolean retVal = false;

        Connection conn = null;
        PreparedStatement ps = null;

        String query = "UPDATE lijek SET Aktivan=0 WHERE LijekID=?";

        //String query = "DELETE FROM lijek " +
          //      "WHERE LijekID=? ";
        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);

            ps.setInt(1, lijekID);

            retVal = ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
        }

        return retVal;
    }

    public int count(){

        int retVal = 0;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT COUNT(*) FROM lijek where Aktivan=1";

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

    public ArrayList<LijekDTO> pretragaPoNazivu(String naziv){
        ArrayList<LijekDTO> retVal = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM lijek WHERE GenerickiNaziv LIKE " +"'%"+naziv+"%'"+" and Aktivan=1";

        try{
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);


            rs = ps.executeQuery();

            while(rs.next()){
                retVal.add( new LijekDTO(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getBigDecimal(4).doubleValue(),
                        rs.getBigDecimal(5).doubleValue(),rs.getString(6),
                        rs.getDate(7).toString(), rs.getDate(8).toString(),
                        rs.getBigDecimal(9).doubleValue(), rs.getString(10),
                        rs.getString(11),rs.getBigDecimal(12).doubleValue(),
                        rs.getBoolean(13),rs.getBoolean(14)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
        }

        return retVal;
    }

    public ArrayList<LijekDTO> lijekoviBezRecepta(){
        ArrayList<LijekDTO> retVal = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM lijek WHERE IzdavanjeNaRecept=0 and Aktivan=1";

        try{
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();

            while(rs.next()){
                retVal.add( new LijekDTO(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getBigDecimal(4).doubleValue(),
                        rs.getBigDecimal(5).doubleValue(),rs.getString(6),
                        rs.getDate(7).toString(), rs.getDate(8).toString(),
                        rs.getBigDecimal(9).doubleValue(), rs.getString(10),
                        rs.getString(11),rs.getBigDecimal(12).doubleValue(),
                        rs.getBoolean(13),rs.getBoolean(14)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
        }

        return retVal;
    }
}
