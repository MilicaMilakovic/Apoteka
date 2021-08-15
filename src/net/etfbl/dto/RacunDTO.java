package net.etfbl.dto;

import java.util.Objects;

public class RacunDTO {

    private int racunID;
    private String datumIzdavanja;
    private double cijena;

    private int zaposleniID;
    private int lijekID;

    public RacunDTO(int racunID, String datumIzdavanja, double cijena, int zaposleniID, int lijekID) {
        this.racunID = racunID;
        this.datumIzdavanja = datumIzdavanja;
        this.cijena = cijena;
        this.zaposleniID = zaposleniID;
        this.lijekID = lijekID;
    }

    public RacunDTO() {
    }

    public int getRacunID() {
        return racunID;
    }

    public void setRacunID(int racunID) {
        this.racunID = racunID;
    }

    public String getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(String datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacunDTO racunDTO = (RacunDTO) o;
        return racunID == racunDTO.racunID &&
                Double.compare(racunDTO.cijena, cijena) == 0 &&
                zaposleniID == racunDTO.zaposleniID &&
                lijekID == racunDTO.lijekID &&
                Objects.equals(datumIzdavanja, racunDTO.datumIzdavanja);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racunID, datumIzdavanja, cijena, zaposleniID, lijekID);
    }

    @Override
    public String toString() {
        return "RacunDTO{" +
                "racunID=" + racunID +
                ", datumIzdavanja='" + datumIzdavanja + '\'' +
                ", cijena=" + cijena +
                ", zaposleniID=" + zaposleniID +
                ", lijekID=" + lijekID +
                '}';
    }
}
