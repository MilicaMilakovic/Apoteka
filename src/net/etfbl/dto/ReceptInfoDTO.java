package net.etfbl.dto;

public class ReceptInfoDTO {

    private int receptID;
    private String pacijent;
    private String generickiNaziv;
    private double propisanaKolicina;
    private String doktor;
    private String datumPropisivanjaLijeka;
    private double prodajnaCijena;
    private int lijekID;
    private boolean vazeci;

    private String status;

    public ReceptInfoDTO() {
    }

    public ReceptInfoDTO(int receptID, String pacijent, String generickiNaziv, double propisanaKolicina,
                         String doktor, String datumPropisivanjaLijeka,
                         double prodajnaCijena, int lijekID, boolean vazeci) {
        this.receptID = receptID;
        this.pacijent = pacijent;
        this.generickiNaziv = generickiNaziv;
        this.propisanaKolicina = propisanaKolicina;
        this.doktor = doktor;
        this.datumPropisivanjaLijeka = datumPropisivanjaLijeka;
        this.prodajnaCijena = prodajnaCijena;
        this.lijekID = lijekID;
        this.vazeci =vazeci;

        status = vazeci ? "Vazeci":"Nevazeci";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isVazeci() {
        return vazeci;
    }

    public void setVazeci(boolean vazeci) {
        this.vazeci = vazeci;
        status = vazeci ? "Vazeci":"Nevazeci";
    }

    public int getReceptID() {
        return receptID;
    }

    public void setReceptID(int receptID) {
        this.receptID = receptID;
    }

    public String getPacijent() {
        return pacijent;
    }

    public void setPacijent(String pacijent) {
        this.pacijent = pacijent;
    }

    public String getGenerickiNaziv() {
        return generickiNaziv;
    }

    public void setGenerickiNaziv(String generickiNaziv) {
        this.generickiNaziv = generickiNaziv;
    }

    public double getPropisanaKolicina() {
        return propisanaKolicina;
    }

    public void setPropisanaKolicina(double propisanaKolicina) {
        this.propisanaKolicina = propisanaKolicina;
    }

    public String getDoktor() {
        return doktor;
    }

    public void setDoktor(String doktor) {
        this.doktor = doktor;
    }

    public String getDatumPropisivanjaLijeka() {
        return datumPropisivanjaLijeka;
    }

    public void setDatumPropisivanjaLijeka(String datumPropisivanjaLijeka) {
        this.datumPropisivanjaLijeka = datumPropisivanjaLijeka;
    }

    public double getProdajnaCijena() {
        return prodajnaCijena;
    }

    public void setProdajnaCijena(double prodajnaCijena) {
        this.prodajnaCijena = prodajnaCijena;
    }

    public int getLijekID() {
        return lijekID;
    }

    public void setLijekID(int lijekID) {
        this.lijekID = lijekID;
    }


}
