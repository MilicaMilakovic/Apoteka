package net.etfbl.main.prescriptions;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import net.etfbl.mysql.ReceptInfoDAO;
import net.etfbl.dto.ReceptInfoDTO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrescriptionsController implements Initializable {

    @FXML
    private TableView<ReceptInfoDTO> table;

    @FXML
    private TableColumn<ReceptInfoDTO, Integer> idCol;

    @FXML
    private TableColumn<ReceptInfoDTO, String> pacijentCol;

    @FXML
    private TableColumn<ReceptInfoDTO, String> lijekCol;

    @FXML
    private TableColumn<ReceptInfoDTO, Double> propisanaKolicinaCol;

    @FXML
    private TableColumn<ReceptInfoDTO, String> doktorCol;

    @FXML
    private TableColumn<ReceptInfoDTO, String> datumCol;

    @FXML
    private TableColumn<ReceptInfoDTO, Double> cijenaCol;

    @FXML
    private TextField searchField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idCol.setCellValueFactory(new PropertyValueFactory<ReceptInfoDTO, Integer>("receptID"));
        pacijentCol.setCellValueFactory(new PropertyValueFactory<>("pacijent"));
        lijekCol.setCellValueFactory(new PropertyValueFactory<>("generickiNaziv"));
        propisanaKolicinaCol.setCellValueFactory(new PropertyValueFactory<>("propisanaKolicina"));
        doktorCol.setCellValueFactory(new PropertyValueFactory<>("doktor"));
        datumCol.setCellValueFactory(new PropertyValueFactory<>("datumPropisivanjaLijeka"));
        cijenaCol.setCellValueFactory(new PropertyValueFactory<>("prodajnaCijena"));

        getData();
    }

    private void getData(){
        ReceptInfoDAO receptInfoDAO = new ReceptInfoDAO();

        table.setItems(FXCollections.observableArrayList(receptInfoDAO.informacije()));

    }

    @FXML
    void search(ActionEvent event) {

    }

    public void checkOut(){
        Stage primaryStage = new Stage();
        Parent root = null;

        if((CheckOutController.info = table.getSelectionModel().getSelectedItem()) != null)
        {
            try {
                root = FXMLLoader.load(getClass().getResource("CheckOut.fxml"));
                primaryStage.setTitle("Izdaj lijek na recept");
                primaryStage.setScene(new Scene(root, 550  , 600));
                primaryStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}