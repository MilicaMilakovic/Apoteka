package net.etfbl.main.patients;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import net.etfbl.dto.PacijentDTO;
import net.etfbl.mysql.PacijentDAO;

import java.net.URL;
import java.util.ResourceBundle;

public class PatientsController implements Initializable {

    @FXML
    private TableView<PacijentDTO> table;

    @FXML
    private TableColumn<PacijentDTO, Integer > idCol;

    @FXML
    private TableColumn<PacijentDTO ,String> jmbCol;

    @FXML
    private TableColumn<PacijentDTO ,String> imeCol;

    @FXML
    private TableColumn<PacijentDTO ,String> prezimeCol;

    @FXML
    private TableColumn<PacijentDTO ,String> datumRodjenjaCol;

    @FXML
    private TableColumn<PacijentDTO ,String> adresaCol;

    @FXML
    private TableColumn<PacijentDTO ,String> sifraBolestiCol;

    @FXML
    private TableColumn<PacijentDTO ,String> alergijeCol;

    @FXML
    private TableColumn<PacijentDTO ,String> osiguranjeCol;

    @FXML
    private TableColumn<PacijentDTO ,String> doktorIDCol;

    @FXML
    private TextField searchField;


    @FXML
    void search(ActionEvent event) {
        String name = searchField.getText();
        table.setItems(FXCollections.observableArrayList((new PacijentDAO()).pretragaPoImenu(name)));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        idCol.setCellValueFactory(new PropertyValueFactory<>("pacijentID"));
        jmbCol.setCellValueFactory(new PropertyValueFactory<>("jmb"));
        imeCol.setCellValueFactory(new PropertyValueFactory<>("ime"));
        prezimeCol.setCellValueFactory(new PropertyValueFactory<>("prezime"));
        datumRodjenjaCol.setCellValueFactory(new PropertyValueFactory<>("datumRodjenja"));
        adresaCol.setCellValueFactory(new PropertyValueFactory<>("adresa"));
        sifraBolestiCol.setCellValueFactory(new PropertyValueFactory<>("sifraBolesti"));
        alergijeCol.setCellValueFactory(new PropertyValueFactory<>("alergije"));
        osiguranjeCol.setCellValueFactory(new PropertyValueFactory<>("osiguranje"));
        doktorIDCol.setCellValueFactory(new PropertyValueFactory<>("doktorID"));

        getData();

    }

    private void getData(){
        table.setItems(FXCollections.observableArrayList((new PacijentDAO()).pacijenti()));
    }
}
