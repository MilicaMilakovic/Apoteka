package net.etfbl.dto;

import java.util.Objects;

public class IzdavanjeLijekaDTO {

    private int zaposleniID;
    private int lijekID;
    private int receptID;
    private double kolicinaIzdatogLijeka;
    private String datumIzdavanja;

    public IzdavanjeLijekaDTO() {
    }

    public IzdavanjeLijekaDTO(int zaposleniID, int lijekID, int receptID, double kolicinaIzdatogLijeka, String datumIzdavanja) {
        this.zaposleniID = zaposleniID;
        this.lijekID = lijekID;
        this.receptID = receptID;
        this.kolicinaIzdatogLijeka = kolicinaIzdatogLijeka;
        this.datumIzdavanja = datumIzdavanja;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IzdavanjeLijekaDTO that = (IzdavanjeLijekaDTO) o;
        return zaposleniID == that.zaposleniID &&
                lijekID == that.lijekID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(zaposleniID, lijekID);
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
