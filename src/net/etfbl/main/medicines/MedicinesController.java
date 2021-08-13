package net.etfbl.main.medicines;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import net.etfbl.dao.LijekDAO;
import net.etfbl.dto.LijekDTO;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MedicinesController implements Initializable {

    @FXML
    public TableView<LijekDTO> table;
    @FXML
    public TableColumn<LijekDTO, Integer> idCol;
    @FXML
    public TableColumn<LijekDTO, String> generickiNazivCol;
    @FXML
    public TableColumn<LijekDTO, String> kategorijaCol;
    @FXML
    public TableColumn<LijekDTO, Double> prodajnaCijenaCol;
    @FXML
    public TableColumn<LijekDTO, Double> nabavnaCijenaCol;
    @FXML
    public TableColumn<LijekDTO, String> kontraindikacijeCol;
    @FXML
    public TableColumn<LijekDTO, String> datumProizvodnjeCol;
    @FXML
    public TableColumn<LijekDTO, String> rokUpotrebeCol;
    @FXML
    public TableColumn<LijekDTO, Double> kolicinaCol;
    @FXML
    public TableColumn<LijekDTO, String> dodatniOpisCol;
    @FXML
    public TableColumn<LijekDTO, String> farmaceutskiOblikCol;
    @FXML
    public TableColumn<LijekDTO, Double> jacinaCol;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idCol.setCellValueFactory(new PropertyValueFactory<LijekDTO,Integer>("lijekID"));
        generickiNazivCol.setCellValueFactory(new PropertyValueFactory<LijekDTO,String>("generickiNaziv"));
        kategorijaCol.setCellValueFactory(new PropertyValueFactory<LijekDTO,String>("kategorija"));
        prodajnaCijenaCol.setCellValueFactory(new PropertyValueFactory<LijekDTO,Double>("prodajnaCijena"));
        nabavnaCijenaCol.setCellValueFactory(new PropertyValueFactory<LijekDTO,Double>("nabavnaCijena"));
        kontraindikacijeCol.setCellValueFactory(new PropertyValueFactory<LijekDTO,String>("kontraindikacije"));
        datumProizvodnjeCol.setCellValueFactory(new PropertyValueFactory<LijekDTO,String>("datumProizvodnje"));
        rokUpotrebeCol.setCellValueFactory(new PropertyValueFactory<LijekDTO,String>("rokUpotrebe"));
        kolicinaCol.setCellValueFactory(new PropertyValueFactory<LijekDTO,Double>("kolicina"));
        dodatniOpisCol.setCellValueFactory(new PropertyValueFactory<LijekDTO,String>("dodatniOpis"));
        farmaceutskiOblikCol.setCellValueFactory(new PropertyValueFactory<LijekDTO,String>("farmaceutskiOblik"));
        jacinaCol.setCellValueFactory(new PropertyValueFactory<LijekDTO,Double>("jacinaLijeka"));

        getData();
    }

    private void getData(){
        LijekDAO lijekDAO = new LijekDAO();
        ArrayList<LijekDTO> lijekovi = lijekDAO.lijekovi();

//        lijekovi.stream().forEach(System.out::println);
        table.setItems(FXCollections.observableArrayList(lijekovi));
    }

    public void addMedicine(){
        Stage primaryStage = new Stage();
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("AddMedicine.fxml"));
            primaryStage.setTitle("Dodaj lijek");
            primaryStage.setScene(new Scene(root, 500  , 550));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void deleteMedicine(){
        LijekDTO selected = table.getSelectionModel().getSelectedItem();
        if(selected!=null){
            LijekDAO lijekDAO = new LijekDAO();
            lijekDAO.obrisiLijek(selected.getLijekID());
            getData();
        }
    }

    public void updateMedicine(){
        Stage primaryStage = new Stage();
        Parent root = null;
        UpdateMedicineController.medToUpdate = table.getSelectionModel().getSelectedItem();
        try {
            root = FXMLLoader.load(getClass().getResource("UpdateMedicine.fxml"));
            primaryStage.setTitle("Izmijeni lijek");

            primaryStage.setScene(new Scene(root, 500  , 550));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
