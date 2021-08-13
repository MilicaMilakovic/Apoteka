package net.etfbl.dao;

import net.etfbl.dto.ZaposleniDTO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public class ZaposleniDAO {

    public boolean logIn(String username, String password) {
        boolean retVal = false;
        ResultSet resultSet = null;
        Connection conn = null;
        PreparedStatement ps = null;

        String query = "SELECT EXISTS(SELECT JMB,Ime,Prezime,KorisnickoIme,Lozinka,DatumRodjenja,Plata "
                       + " from zaposleni"
                       + " WHERE KorisnickoIme=? and Lozinka=?)";

        try{
            conn  = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);

            ps.setString(1,username);
            ps.setString(2,password);

            resultSet = ps.executeQuery();

            resultSet.next();
            retVal = resultSet.getInt(1) == 1;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
        }

        return  retVal;
    }


    public ArrayList<ZaposleniDTO> zaposleni(){

        ArrayList<ZaposleniDTO> retVal = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM zaposleni";

        try{
            conn= ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()){
                retVal.add(new ZaposleniDTO(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getString(4),rs.getString(5),
                        rs.getString(6),rs.getDate(7).toString(),rs.getDouble(8)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
        }

        return  retVal;
    }

    public boolean dodajZaposlenog(ZaposleniDTO zaposleni){

        boolean retVal = false;

        Connection conn = null;
        PreparedStatement ps = null;

        String query = "INSERT INTO zaposleni (JMB,Ime,Prezime,KorisnickoIme,Lozinka,DatumRodjenja,Plata) values "
                + "(?,?,?,?,?,?,?)";

        try{
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);

            ps.setString(1,zaposleni.getJMB());
            ps.setString(2,zaposleni.getIme());
            ps.setString(3,zaposleni.getPrezime());
            ps.setString(4,zaposleni.getKorisnickoIme());
            ps.setString(5,zaposleni.getLozinka());
            ps.setString(6,zaposleni.getDatumRodjenja());
            ps.setBigDecimal(7, BigDecimal.valueOf(zaposleni.getPlata()));

            retVal = ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  retVal;
    }

    public boolean obrisiZaposlenog(int id){

        boolean retVal = false;

        Connection conn = null;
        PreparedStatement ps = null;

        String query = "DELETE FROM zaposleni WHERE ZaposleniID=?";

        try{
          conn = ConnectionPool.getInstance().checkOut();
          ps = conn.prepareStatement(query);
          ps.setInt(1,id);
          retVal = ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
        }

        return  retVal;
    }

    public boolean azuriraj(ZaposleniDTO zaposleni){
        boolean retVal = false;

        Connection conn = null;
        PreparedStatement ps = null;

        String query = "UPDATE zaposleni SET "
                +"JMB=?,"
                +"Ime=?,"
                +"Prezime=?,"
                +"KorisnickoIme=?,"
                +"Lozinka=?,"
                +"DatumRodjenja=?,"
                +"Plata=?"
                +"WHERE ZaposleniID=?";

        try{
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);

            ps.setString(1,zaposleni.getJMB());
            ps.setString(2,zaposleni.getIme());
            ps.setString(3,zaposleni.getPrezime());
            ps.setString(4,zaposleni.getKorisnickoIme());
            ps.setString(5,zaposleni.getLozinka());
            ps.setDate(6, Date.valueOf(zaposleni.getDatumRodjenja()));
            ps.setBigDecimal(7,BigDecimal.valueOf(zaposleni.getPlata()));
            ps.setInt(8,zaposleni.getId());

            retVal = ps.executeUpdate() == 1;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
        }

        return  retVal;
    }

    public ArrayList<ZaposleniDTO> pretragaPoImenu(String ime){
        ArrayList<ZaposleniDTO> retVal = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM zaposleni WHERE Ime like " + "'%"+ime+"%'";

        try{
            conn=ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()){
            retVal.add(new ZaposleniDTO(rs.getInt(1),rs.getString(2),
                    rs.getString(3),rs.getString(4),rs.getString(5),
                    rs.getString(6),rs.getDate(7).toString(),rs.getDouble(8)));
             }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionPool.getInstance().checkIn(conn);
        }
        return  retVal;

    }
}
