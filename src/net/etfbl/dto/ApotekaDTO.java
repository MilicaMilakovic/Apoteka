package net.etfbl.dto;

import java.util.Objects;

public class ApotekaDTO {

    private int ApotekaID;
    private  String naziv;
    private String adresa;
    private String email;

    public ApotekaDTO(int apotekaID, String naziv, String adresa, String email) {
        ApotekaID = apotekaID;
        this.naziv = naziv;
        this.adresa = adresa;
        this.email = email;
    }

    public ApotekaDTO() {
    }

    public int getApotekaID() {
        return ApotekaID;
    }

    public void setApotekaID(int apotekaID) {
        ApotekaID = apotekaID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApotekaDTO that = (ApotekaDTO) o;
        return ApotekaID == that.ApotekaID &&
                Objects.equals(naziv, that.naziv) &&
                Objects.equals(adresa, that.adresa) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ApotekaID, naziv, adresa, email);
    }

    @Override
    public String toString() {
        return "ApotekaDTO{" +
                "ApotekaID=" + ApotekaID +
                ", naziv='" + naziv + '\'' +
                ", adresa='" + adresa + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


}
