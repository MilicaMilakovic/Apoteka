package net.etfbl.dto;

import java.util.Objects;

public class ReceptDTO {

    private int receptID;
    private String ime;
    private String prezime;
    private String brojZdravstvenogKartona;
    private String nazivZdravstveneUstanove;

    private String datumPropisivanjaRecepta;
    private String licniBrojOsiguranika;

    private boolean vazeci;
    private int pacijentID;
    private int doktorID;
    private int lijekID;

    public ReceptDTO(int receptID, String ime, String prezime, String brojZdravstvenogKartona, String nazivZdravstveneUstanove,
                     String datumPropisivanjaRecepta, String licniBrojOsiguranika,
                      boolean vazeci, int pacijentID, int doktorID, int lijekID) {
        this.receptID = receptID;
        this.ime = ime;
        this.prezime = prezime;
        this.brojZdravstvenogKartona = brojZdravstvenogKartona;
        this.nazivZdravstveneUstanove = nazivZdravstveneUstanove;
        this.datumPropisivanjaRecepta = datumPropisivanjaRecepta;
        this.licniBrojOsiguranika = licniBrojOsiguranika;
        this.vazeci = vazeci;
        this.pacijentID = pacijentID;
        this.doktorID = doktorID;
        this.lijekID = lijekID;
    }



    public ReceptDTO() {
    }

    public boolean isVazeci() {
        return vazeci;
    }

    public void setVazeci(boolean vazeci) {
        this.vazeci = vazeci;
    }

    public int getReceptID() {
        return receptID;
    }

    public void setReceptID(int receptID) {
        this.receptID = receptID;
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

    public String getBrojZdravstvenogKartona() {
        return brojZdravstvenogKartona;
    }

    public void setBrojZdravstvenogKartona(String brojZdravstvenogKartona) {
        this.brojZdravstvenogKartona = brojZdravstvenogKartona;
    }

    public String getNazivZdravstveneUstanove() {
        return nazivZdravstveneUstanove;
    }

    public void setNazivZdravstveneUstanove(String nazivZdravstveneUstanove) {
        this.nazivZdravstveneUstanove = nazivZdravstveneUstanove;
    }


    public String getDatumPropisivanjaRecepta() {
        return datumPropisivanjaRecepta;
    }

    public void setDatumPropisivanjaRecepta(String datumPropisivanjaRecepta) {
        this.datumPropisivanjaRecepta = datumPropisivanjaRecepta;
    }

    public String getLicniBrojOsiguranika() {
        return licniBrojOsiguranika;
    }

    public void setLicniBrojOsiguranika(String licniBrojOsiguranika) {
        this.licniBrojOsiguranika = licniBrojOsiguranika;
    }


    public int getPacijentID() {
        return pacijentID;
    }

    public void setPacijentID(int pacijentID) {
        this.pacijentID = pacijentID;
    }

    public int getDoktorID() {
        return doktorID;
    }

    public void setDoktorID(int doktorID) {
        this.doktorID = doktorID;
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
        ReceptDTO receptDTO = (ReceptDTO) o;
        return receptID == receptDTO.receptID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(receptID);
    }

    @Override
    public String toString() {
        return "ReceptDTO{" +
                "receptID=" + receptID +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", brojZdravstvenogKartona='" + brojZdravstvenogKartona + '\'' +
                ", nazivZdravstveneUstanove='" + nazivZdravstveneUstanove + '\'' +
                ", datumPropisivanjaRecepta='" + datumPropisivanjaRecepta + '\'' +
                ", licniBrojOsiguranika='" + licniBrojOsiguranika + '\'' +
                ", pacijentID=" + pacijentID +
                ", doktorID=" + doktorID +
                ", lijekID=" + lijekID +
                '}';
    }
}
