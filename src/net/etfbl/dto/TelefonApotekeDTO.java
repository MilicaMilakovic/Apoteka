package net.etfbl.dto;

import java.util.Objects;

public class TelefonApotekeDTO {

    private String telefon;
    private int apotekaID;


    public TelefonApotekeDTO( String telefon,int apotekaID) {
        this.apotekaID = apotekaID;
        this.telefon = telefon;
    }

    public TelefonApotekeDTO() {
    }

    public int getApotekaID() {
        return apotekaID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelefonApotekeDTO that = (TelefonApotekeDTO) o;
        return apotekaID == that.apotekaID &&
                Objects.equals(telefon, that.telefon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apotekaID, telefon);
    }

    public void setApotekaID(int apotekaID) {
        this.apotekaID = apotekaID;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return "TelefonApotekeDTO{" +
                "apotekaID=" + apotekaID +
                ", telefon='" + telefon + '\'' +
                '}';
    }
}
