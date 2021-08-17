package net.etfbl.main.doctors;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import net.etfbl.dto.DoktorDTO;
import net.etfbl.mysql.DoktorDAO;

import java.net.URL;
import java.util.ResourceBundle;

public class DoctorController implements Initializable {

    @FXML
    private TableView<DoktorDTO> table;

    @FXML
    private TableColumn<DoktorDTO, Integer> idCol;

    @FXML
    private TableColumn<DoktorDTO, String> jmbCol;

    @FXML
    private TableColumn<DoktorDTO, String> imeCol;

    @FXML
    private TableColumn<DoktorDTO, String> prezimeCol;

    @FXML
    private TableColumn<DoktorDTO, String> sifraCol;

    @FXML
    private TableColumn<DoktorDTO, String> ambulantaCol;

    @FXML
    private TableColumn<DoktorDTO, String> telCol;

    @FXML
    private TextField searchField;

    @FXML
    void search(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idCol.setCellValueFactory(new PropertyValueFactory<>("doktorID"));
        jmbCol.setCellValueFactory(new PropertyValueFactory<>("jmb"));
        imeCol.setCellValueFactory(new PropertyValueFactory<>("ime"));
        prezimeCol.setCellValueFactory(new PropertyValueFactory<>("prezime"));
        sifraCol.setCellValueFactory(new PropertyValueFactory<>("sifraTima"));
        ambulantaCol.setCellValueFactory(new PropertyValueFactory<>("ambulanta"));
        telCol.setCellValueFactory(new PropertyValueFactory<>("kontaktTelefon"));

        table.setItems(FXCollections.observableArrayList((new DoktorDAO()).doktori()));
    }
}
