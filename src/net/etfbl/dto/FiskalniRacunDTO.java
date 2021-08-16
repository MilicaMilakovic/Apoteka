package net.etfbl.dto;

import java.util.Objects;

public class FiskalniRacunDTO {

    private int racunID;
    private String datumIzdavanja;
    private double cijenaUkupno;

    public FiskalniRacunDTO(int racunID, String datumIzdavanja, double cijenaUkupno) {
        this.racunID = racunID;
        this.datumIzdavanja = datumIzdavanja;
        this.cijenaUkupno = cijenaUkupno;
    }

    public FiskalniRacunDTO() {
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

    public double getCijenaUkupno() {
        return cijenaUkupno;
    }

    public void setCijenaUkupno(double cijenaUkupno) {
        this.cijenaUkupno = cijenaUkupno;
    }

    @Override
    public String toString() {
        return "FiskalniRacunDTO{" +
                "racunID=" + racunID +
                ", datumIzdavanja='" + datumIzdavanja + '\'' +
                ", cijenaUkupno=" + cijenaUkupno +
                '}';
    }
}
