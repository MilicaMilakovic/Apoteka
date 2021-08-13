package net.etfbl.main.users;

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
import net.etfbl.dao.ZaposleniDAO;
import net.etfbl.dto.ZaposleniDTO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UsersController implements Initializable {

    @FXML
    public TableView<ZaposleniDTO> table;
    @FXML
    public TableColumn<ZaposleniDTO,Integer> idCol;
    @FXML
    public TableColumn<ZaposleniDTO,String> jmbCol;
    @FXML
    public TableColumn<ZaposleniDTO,String> imeCol;
    @FXML
    public TableColumn<ZaposleniDTO,String> prezimeCol;
    @FXML
    public TableColumn<ZaposleniDTO,String> korisnickoImeCol;
    @FXML
    public TableColumn<ZaposleniDTO,String> datumRodjenjaCol;
    @FXML
    public TableColumn<ZaposleniDTO,Double> plataCol;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idCol.setCellValueFactory(new PropertyValueFactory<ZaposleniDTO,Integer>("id"));
        jmbCol.setCellValueFactory(new PropertyValueFactory<ZaposleniDTO,String>("JMB"));
        imeCol.setCellValueFactory(new PropertyValueFactory<ZaposleniDTO,String>("ime"));
        prezimeCol.setCellValueFactory(new PropertyValueFactory<ZaposleniDTO,String>("prezime"));
        korisnickoImeCol.setCellValueFactory(new PropertyValueFactory<ZaposleniDTO,String>("korisnickoIme"));
        datumRodjenjaCol.setCellValueFactory(new PropertyValueFactory<ZaposleniDTO,String>("datumRodjenja"));
        plataCol.setCellValueFactory(new PropertyValueFactory<ZaposleniDTO,Double>("plata"));

        getData();
    }

    private void getData(){
        ZaposleniDAO zaposleniDAO = new ZaposleniDAO();
        table.setItems(FXCollections.observableArrayList(zaposleniDAO.zaposleni()));
    }

    public void delete(){
        ZaposleniDAO zaposleniDAO = new ZaposleniDAO();
        ZaposleniDTO zaposleni = table.getSelectionModel().getSelectedItem();
        if(zaposleni!=null){
            zaposleniDAO.obrisiZaposlenog(zaposleni.getId());
            getData();
        }
    }

    public void add(){
        Stage primaryStage = new Stage();
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("AddUser.fxml"));
            primaryStage.setTitle("Dodaj novog zaposlenog");
            primaryStage.setScene(new Scene(root, 500  , 550));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
