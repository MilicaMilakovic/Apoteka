package net.etfbl.dto;

import java.util.Objects;

public class PacijentDTO {

    private int pacijentID;
    private String jmb;
    private String ime;
    private String prezime;
    private String datumRodjenja;
    private String adresa;
    private String sifraBolesti;
    private String alergije;
    private String osiguranje;
    private int doktorID;

    public PacijentDTO() {
    }

    public PacijentDTO(int pacijentID, String jmb, String ime, String prezime, String datumRodjenja,
                       String adresa, String sifraBolesti,  String alergije, String osiguranje, int doktorID) {
        this.pacijentID = pacijentID;
        this.jmb = jmb;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.adresa = adresa;
        this.sifraBolesti = sifraBolesti;
        this.alergije = alergije;
        this.osiguranje = osiguranje;
        this.doktorID = doktorID;
    }

    public int getPacijentID() {
        return pacijentID;
    }

    public void setPacijentID(int pacijentID) {
        this.pacijentID = pacijentID;
    }

    public String getJmb() {
        return jmb;
    }

    public void setJmb(String jmb) {
        this.jmb = jmb;
    }

    public void setSifraBolesti(String sifraBolesti) { this.sifraBolesti=sifraBolesti; }
    public String getSifraBolesti() { return  sifraBolesti; }

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

    public String getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(String datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }


    public String getAlergije() {
        return alergije;
    }

    public void setAlergije(String alergije) {
        this.alergije = alergije;
    }

    public String getOsiguranje() {
        return osiguranje;
    }

    public void setOsiguranje(String osiguranje) {
        this.osiguranje = osiguranje;
    }

    public int getDoktorID() {
        return doktorID;
    }

    public void setDoktorID(int doktorID) {
        this.doktorID = doktorID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PacijentDTO that = (PacijentDTO) o;
        return pacijentID == that.pacijentID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pacijentID);
    }

    @Override
    public String toString() {
        return "PacijentDTO{" +
                "pacijentID=" + pacijentID +
                ", jmb='" + jmb + '\'' +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", datumRodjenja='" + datumRodjenja + '\'' +
                ", adresa='" + adresa + '\'' +
                ", sifraBolesti='" + sifraBolesti + '\'' +
                ", alergije='" + alergije + '\'' +
                ", osiguranje='" + osiguranje + '\'' +
                ", doktorID=" + doktorID +
                '}';
    }
}
