package net.etfbl.main.medicines;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import net.etfbl.mysql.LijekDAO;
import net.etfbl.dto.LijekDTO;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

public class UpdateMedicineController implements Initializable {

    @FXML
    public TextField nazivField;
    @FXML
    public TextField kategorijaField;
    @FXML
    public TextField prodajnaCijenaField;
    @FXML
    public TextField nabavnaCijenaField;
    @FXML
    public TextField kolicinaField;
    @FXML
    public DatePicker datumProizvodnjeField;
    @FXML
    public DatePicker rokUpotrebeField;
    @FXML
    public TextField jacinaField;
    @FXML
    public TextField oblikField;
    @FXML
    public TextArea kontraindikacijeField;
    @FXML
    public TextArea opisField;
    @FXML
    public Label medicine;

    public static LijekDTO medToUpdate;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        medicine.setText(medToUpdate.getGenerickiNaziv());
    }

    public void clear(){
        nazivField.clear();
        kategorijaField.clear();
        prodajnaCijenaField.clear();
        nabavnaCijenaField.clear();
        kolicinaField.clear();
        datumProizvodnjeField.getEditor().clear();
        rokUpotrebeField.getEditor().clear();
        jacinaField.clear();
        oblikField.clear();
        kontraindikacijeField.clear();
        opisField.clear();
    }

    public void update(){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.US);
        String datumProizvodnje="";
        String rokUpotrebe="";
        if(datumProizvodnjeField.getValue()!=null)
            datumProizvodnje =(datumProizvodnjeField.getValue()).format(formatter);
        if(rokUpotrebeField.getValue()!=null)
         rokUpotrebe= (rokUpotrebeField.getValue()).format(formatter);


        if(!nazivField.getText().equals("")){
            medToUpdate.setGenerickiNaziv(nazivField.getText());
        }
        if(!kategorijaField.getText().equals("")){
            medToUpdate.setKategorija(kategorijaField.getText());
        }
        if(!prodajnaCijenaField.getText().equals("")){
            medToUpdate.setProdajnaCijena(Double.parseDouble(prodajnaCijenaField.getText()));
        }
        if(!nabavnaCijenaField.getText().equals("")){
            medToUpdate.setNabavnaCijena(Double.parseDouble(nabavnaCijenaField.getText()));
        }
        if(!datumProizvodnje.equals("")){
            medToUpdate.setDatumProizvodnje(datumProizvodnje);
        }
        if(!rokUpotrebe.equals("")){
            medToUpdate.setRokUpotrebe(rokUpotrebe);
        }
        if(!kolicinaField.getText().equals("")){
            medToUpdate.setKolicina(Double.parseDouble(kolicinaField.getText()));
        }
        if(!opisField.getText().equals("")){
            medToUpdate.setDodatniOpis(opisField.getText());
        }
        if(!oblikField.getText().equals("")){
            medToUpdate.setFarmaceutskiOblik(oblikField.getText());
        }
        if(!jacinaField.getText().equals("")){
            medToUpdate.setJacinaLijeka(Double.parseDouble(jacinaField.getText()));
        }

//        LijekDTO lijek = new LijekDTO(0,nazivField.getText(),kategorijaField.getText(),
//                Double.parseDouble(prodajnaCijenaField.getText()),Double.parseDouble(nabavnaCijenaField.getText()),
//                kontraindikacijeField.getText(), datumProizvodnje,
//                rokUpotrebe,Double.parseDouble(kolicinaField.getText()),
//                opisField.getText(),oblikField.getText(),Double.parseDouble(jacinaField.getText()));

        LijekDAO lijekDAO = new LijekDAO();
        lijekDAO.azurirajLijek(medToUpdate);

        MedicinesController.refresh = true;
        clear();
    }
}
