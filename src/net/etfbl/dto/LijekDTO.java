package net.etfbl.dto;

import java.util.Objects;

public class LijekDTO {

    private int lijekID;
    private String generickiNaziv;
    private String kategorija;
    private double prodajnaCijena;
    private double nabavnaCijena;
    private String kontraindikacije;
    private String datumProizvodnje;
    private String rokUpotrebe;
    private Double kolicina;
    private String dodatniOpis;
    private String farmaceutskiOblik;
    private double jacinaLijeka;
    private boolean izdavanjeNaRecept;


    private String status;

    public LijekDTO(int lijekID, String generickiNaziv, String kategorija, double prodajnaCijena, double nabavnaCijena, String kontraindikacije, String datumProizvodnje,
                    String rokUpotrebe, Double kolicina, String dodatniOpis, String farmaceutskiOblik, double jacinaLijeka, boolean izdavanjeNaRecept) {
        this.lijekID = lijekID;
        this.generickiNaziv = generickiNaziv;
        this.kategorija = kategorija;
        this.prodajnaCijena = prodajnaCijena;
        this.nabavnaCijena = nabavnaCijena;
        this.kontraindikacije = kontraindikacije;
        this.datumProizvodnje = datumProizvodnje;
        this.rokUpotrebe = rokUpotrebe;
        this.kolicina = kolicina;
        this.dodatniOpis = dodatniOpis;
        this.farmaceutskiOblik = farmaceutskiOblik;
        this.jacinaLijeka = jacinaLijeka;
        this.izdavanjeNaRecept = izdavanjeNaRecept;

        status = izdavanjeNaRecept?"Da":"Ne";
    }

    public LijekDTO() {
    }

    public boolean isIzdavanjeNaRecept() {
        return izdavanjeNaRecept;
    }

    public void setIzdavanjeNaRecept(boolean izdavanjeNaRecept) {
        this.izdavanjeNaRecept = izdavanjeNaRecept;
        status = izdavanjeNaRecept?"Da":"Ne";

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getLijekID() {
        return lijekID;
    }

    public void setLijekID(int lijekID) {
        this.lijekID = lijekID;
    }

    public String getGenerickiNaziv() {
        return generickiNaziv;
    }

    public void setGenerickiNaziv(String generickiNaziv) {
        this.generickiNaziv = generickiNaziv;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public double getProdajnaCijena() {
        return prodajnaCijena;
    }

    public void setProdajnaCijena(double prodajnaCijena) {
        this.prodajnaCijena = prodajnaCijena;
    }

    public double getNabavnaCijena() {
        return nabavnaCijena;
    }

    public void setNabavnaCijena(double nabavnaCijena) {
        this.nabavnaCijena = nabavnaCijena;
    }

    public String getKontraindikacije() {
        return kontraindikacije;
    }

    public void setKontraindikacije(String kontraindikacije) {
        this.kontraindikacije = kontraindikacije;
    }

    public String getDatumProizvodnje() {
        return datumProizvodnje;
    }

    public void setDatumProizvodnje(String datumProizvodnje) {
        this.datumProizvodnje = datumProizvodnje;
    }

    public String getRokUpotrebe() {
        return rokUpotrebe;
    }

    public void setRokUpotrebe(String rokUpotrebe) {
        this.rokUpotrebe = rokUpotrebe;
    }

    public Double getKolicina() {
        return kolicina;
    }

    public void setKolicina(Double kolicina) {
        this.kolicina = kolicina;
    }

    public String getDodatniOpis() {
        return dodatniOpis;
    }

    public void setDodatniOpis(String dodatniOpis) {
        this.dodatniOpis = dodatniOpis;
    }

    public String getFarmaceutskiOblik() {
        return farmaceutskiOblik;
    }

    public void setFarmaceutskiOblik(String farmaceutskiOblik) {
        this.farmaceutskiOblik = farmaceutskiOblik;
    }

    public double getJacinaLijeka() {
        return jacinaLijeka;
    }

    public void setJacinaLijeka(double jacinaLijeka) {
        this.jacinaLijeka = jacinaLijeka;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LijekDTO lijekDTO = (LijekDTO) o;
        return lijekID == lijekDTO.lijekID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lijekID);
    }

    @Override
    public String toString() {
        return "LijekDTO{" +
                "lijekID=" + lijekID +
                ", generickiNaziv='" + generickiNaziv + '\'' +
                ", kategorija='" + kategorija + '\'' +
                ", prodajnaCijena=" + prodajnaCijena +
                ", nabavnaCijena=" + nabavnaCijena +
                ", kontraindikacije='" + kontraindikacije + '\'' +
                ", datumProizvodnje='" + datumProizvodnje + '\'' +
                ", rokUpotrebe='" + rokUpotrebe + '\'' +
                ", kolicina=" + kolicina +
                ", dodatniOpis='" + dodatniOpis + '\'' +
                ", farmaceutskiOblik='" + farmaceutskiOblik + '\'' +
                ", jacinaLijeka=" + jacinaLijeka +
                '}';
    }
}
