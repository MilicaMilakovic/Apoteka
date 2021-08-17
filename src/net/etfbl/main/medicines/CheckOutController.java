package net.etfbl.main.medicines;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import net.etfbl.dto.FiskalniRacunDTO;
import net.etfbl.dto.FiskalniRacunStavkaDTO;
import net.etfbl.dto.IzdavanjeLijekaDTO;
import net.etfbl.dto.LijekDTO;
import net.etfbl.main.MainPageController;
import net.etfbl.mysql.FiskalniRacunDAO;
import net.etfbl.mysql.FiskalniRacunStavkaDAO;
import net.etfbl.mysql.IzdavanjeLijekaDAO;

import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class CheckOutController implements Initializable {
    @FXML
    private TextArea racunText;

    public static List<LijekDTO> lijekovi;

    @FXML
    public TextArea stavkeText;
    @FXML
    public TextField kolicina;
    @FXML
    public TextField idLijeka;
    @FXML
    public  TextField obrisiID;
    @FXML
    public Label ukupno;

    List<FiskalniRacunStavkaDTO> stavke = new ArrayList<>();

    private int racunID;
    private FiskalniRacunDTO racun;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        FiskalniRacunDAO fiskalniRacunDAO = new FiskalniRacunDAO();
        FiskalniRacunStavkaDAO fiskalniRacunStavkaDAO = new FiskalniRacunStavkaDAO();

        racun = fiskalniRacunDAO.kreirajRacun();
        racunID = racun.getRacunID();



        for(LijekDTO lijek : lijekovi){
            FiskalniRacunStavkaDTO stavka = new FiskalniRacunStavkaDTO(lijek.getLijekID(),racun.getRacunID(), 1,
                    lijek.getProdajnaCijena()*1);

            stavka.setNazivLijeka(lijek.getGenerickiNaziv());

            stavke.add(stavka);
        }


        prikaziStavke();
    }

    private void prikaziStavke(){
        stavkeText.clear();

        for(FiskalniRacunStavkaDTO s : stavke){
            stavkeText.appendText(s+"\n");
            stavkeText.appendText("====================\n");
        }
    }

    public void izmijeni(){

        double kol =  Double.parseDouble(kolicina.getText());
        int id = Integer.parseInt(idLijeka.getText());

        for(FiskalniRacunStavkaDTO s : stavke)
        {
            if(s.getLijekID()==id)
            {
                s.setKolicina(kol);
                s.setCijena(kol*s.getCijena());
                prikaziStavke();

            }
        }

        kolicina.clear();
        idLijeka.clear();

    }

    public void zavrsi(){

        FiskalniRacunStavkaDAO dao = new FiskalniRacunStavkaDAO();

        for(FiskalniRacunStavkaDTO s : stavke){
            dao.dodajStavku(s);
            racunText.appendText(s + "\n");
            racunText.appendText("------------------\n");
        }

    }

    @FXML
    void checkOut(ActionEvent event) {

        IzdavanjeLijekaDAO izdavanjeLijekaDAO = new IzdavanjeLijekaDAO();
        String time = (new Timestamp(new Date().getTime())).toString();

        for(FiskalniRacunStavkaDTO s : stavke){
            IzdavanjeLijekaDTO izdavanje = new IzdavanjeLijekaDTO(MainPageController.zaposleni.getId(),
                    s.getLijekID(),0,s.getKolicina(),time, racunID);

            izdavanjeLijekaDAO.evidentiraj(izdavanje);
        }

        ukupno.setText("Ukupno: " + (new FiskalniRacunDAO().getByID(racunID)).getCijenaUkupno()  + " KM" );
        MedicinesController.refresh = true;

    }

    public void obrisi(){
        int id = Integer.parseInt(obrisiID.getText());

        for (FiskalniRacunStavkaDTO s : stavke){
            if (s.getLijekID() == id){
                stavke.remove(s);
                prikaziStavke();
                obrisiID.clear();
            }
        }
    }
}
