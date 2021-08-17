package net.etfbl.dto;

import java.util.Objects;

public class IzdavanjeLijekaDTO {

    private int zaposleniID;
    private int lijekID;
    private Integer receptID;
    private double kolicinaIzdatogLijeka;
    private String datumIzdavanja;
    private int racunID;

    public IzdavanjeLijekaDTO() {
    }

    public IzdavanjeLijekaDTO( int zaposleniID, int lijekID, Integer receptID,
                              double kolicinaIzdatogLijeka, String datumIzdavanja, int racunID) {

        this.zaposleniID = zaposleniID;
        this.lijekID = lijekID;
        this.receptID = receptID;
        this.kolicinaIzdatogLijeka = kolicinaIzdatogLijeka;
        this.datumIzdavanja = datumIzdavanja;
        this.racunID = racunID;
    }

    public int getZaposleniID() {
        return zaposleniID;
    }

    public void setZaposleniID(int zaposleniID) {
        this.zaposleniID = zaposleniID;
    }

    public int getLijekID() {
        return lijekID;
    }

    public void setLijekID(int lijekID) {
        this.lijekID = lijekID;
    }

    public double getKolicinaIzdatogLijeka() {
        return kolicinaIzdatogLijeka;
    }

    public void setKolicinaIzdatogLijeka(int kolicinaIzdatogLijeka) {
        this.kolicinaIzdatogLijeka = kolicinaIzdatogLijeka;
    }

    public int getReceptID() {
        return receptID;
    }

    public void setReceptID(int receptID) {
        this.receptID = receptID;
    }

    public String getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(String datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public void setKolicinaIzdatogLijeka(double kolicinaIzdatogLijeka) {
        this.kolicinaIzdatogLijeka = kolicinaIzdatogLijeka;
    }

    public int getRacunID() {
        return racunID;
    }

    public void setRacunID(int racunID) {
        this.racunID = racunID;
    }

    @Override
    public String toString() {
        return "IzdavanjeLijekaDTO{" +
                "zaposleniID=" + zaposleniID +
                ", lijekID=" + lijekID +
                ", kolicinaIzdatogLijeka=" + kolicinaIzdatogLijeka +
                ", datumIzdavanja='" + datumIzdavanja + '\'' +
                '}';
    }
}
