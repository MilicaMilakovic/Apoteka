package net.etfbl.dto;

import java.util.Objects;

public class ZaposlenjeDTO {

    private int zaposleniID;
    private int apotekaID;
    private String datumOd="--";
    private String datumDo="--";

    public ZaposlenjeDTO(int zaposleniID, int apotekaID, String datumOd, String datumDo) {
        this.zaposleniID = zaposleniID;
        this.apotekaID = apotekaID;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
    }

    public ZaposlenjeDTO() {

    }

    public int getZaposleniID() {
        return zaposleniID;
    }

    public void setZaposleniID(int zaposleniID) {
        this.zaposleniID = zaposleniID;
    }

    public int getApotekaID() {
        return apotekaID;
    }

    public void setApotekaID(int apotekaID) {
        this.apotekaID = apotekaID;
    }

    public String getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(String datumOd) {
        this.datumOd = datumOd;
    }

    public String getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(String datumDo) {
        this.datumDo = datumDo;
    }

    @Override
    public String toString() {
        return "ZaposlenjeDTO{" +
                "zaposleniID=" + zaposleniID +
                ", apotekaID=" + apotekaID +
                ", datumOd='" + datumOd + '\'' +
                ", datumDo='" + datumDo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZaposlenjeDTO that = (ZaposlenjeDTO) o;
        return zaposleniID == that.zaposleniID &&
                apotekaID == that.apotekaID &&
                Objects.equals(datumOd, that.datumOd) &&
                Objects.equals(datumDo, that.datumDo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zaposleniID, apotekaID, datumOd, datumDo);
    }
}
