package net.etfbl.dto;

import java.util.Objects;

public class DoktorDTO {

    private int doktorID;
    private String jmb;
    private String ime;
    private String prezime;
    private String sifraTima;
    private String ambulanta;
    private String kontaktTelefon;

    public DoktorDTO(int doktorID, String jmb, String ime, String prezime,
                     String sifraTima, String ambulanta, String kontaktTelefon) {
        this.doktorID = doktorID;
        this.jmb = jmb;
        this.ime = ime;
        this.prezime = prezime;
        this.sifraTima = sifraTima;
        this.ambulanta = ambulanta;
        this.kontaktTelefon = kontaktTelefon;
    }

    public DoktorDTO() {
    }

    public int getDoktorID() {
        return doktorID;
    }

    public void setDoktorID(int doktorID) {
        this.doktorID = doktorID;
    }

    public String getJmb() {
        return jmb;
    }

    public void setJmb(String jmb) {
        this.jmb = jmb;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getSifraTima() {
        return sifraTima;
    }

    public void setSifraTima(String sifraTima) {
        this.sifraTima = sifraTima;
    }

    public String getAmbulanta() {
        return ambulanta;
    }

    public void setAmbulanta(String ambulanta) {
        this.ambulanta = ambulanta;
    }

    public String getKontaktTelefon() {
        return kontaktTelefon;
    }

    public void setKontaktTelefon(String kontaktTelefon) {
        this.kontaktTelefon = kontaktTelefon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoktorDTO doktorDTO = (DoktorDTO) o;
        return doktorID == doktorDTO.doktorID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(doktorID);
    }

    @Override
    public String toString() {
        return "DoktorDTO{" +
                "doktorID=" + doktorID +
                ", jmb='" + jmb + '\'' +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", sifraTima='" + sifraTima + '\'' +
                ", ambulanta='" + ambulanta + '\'' +
                ", kontaktTelefon='" + kontaktTelefon + '\'' +
                '}';
    }
}
