package net.etfbl.dto;

import net.etfbl.mysql.LijekDAO;

public class FiskalniRacunStavkaDTO {

    private int lijekID;
    private int racunID;
    private double kolicina;
    private double cijena;
    private  String nazivLijeka;

    public FiskalniRacunStavkaDTO(int lijekID, int racunID, double kolicina, double cijena) {
        this.lijekID = lijekID;
        this.racunID = racunID;
        this.kolicina = kolicina;
        this.cijena = cijena;

    }

    public FiskalniRacunStavkaDTO() {
    }

    public int getLijekID() {
        return lijekID;
    }

    public void setLijekID(int lijekID) {
        this.lijekID = lijekID;
    }

    public int getRacunID() {
        return racunID;
    }

    public void setRacunID(int racunID) {
        this.racunID = racunID;
    }

    public double getKolicina() {
        return kolicina;
    }

    public void setKolicina(double kolicina) {
        this.kolicina = kolicina;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
    }

    public String getNazivLijeka() {
        return nazivLijeka;
    }

    public void setNazivLijeka(String nazivLijeka) {
        this.nazivLijeka = nazivLijeka;
    }

    @Override
    public String toString() {
        return    "Naziv lijeka: " + nazivLijeka+
                "\nLijekID: " + lijekID +
                "\nRacunID: " + racunID +
                "\nKolicina: " + kolicina +
                "\nCijena: " + cijena ;
    }
}
