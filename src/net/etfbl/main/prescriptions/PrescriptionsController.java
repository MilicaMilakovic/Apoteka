package net.etfbl.main.prescriptions;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import net.etfbl.mysql.ReceptInfoDAO;
import net.etfbl.dto.ReceptInfoDTO;

import java.io.IOException;
import java.net.URL;
import java.security.spec.ECField;
import java.util.ResourceBundle;

public class PrescriptionsController implements Initializable {

    @FXML
    public TableView<ReceptInfoDTO> table;

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
    private TableColumn<ReceptInfoDTO, String> statusCol;

    public static boolean refresh;

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
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        new Thread(()->{
            System.out.println("refresh thread");
            while (true){
                if(refresh){
                    getData();
                    refresh = false;

                }
                try{
                    Thread.sleep(100);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
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

        ReceptInfoDTO info = table.getSelectionModel().getSelectedItem();
        if(info!= null)
        {
            CheckOutController.info = info;

            if(!info.isVazeci()){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                stage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/logo.png")));

                alert.setTitle("Obavjestenje");
                alert.setHeaderText(null);
                String s ="Neuspjesno izdavanje lijeka na recept! Recept nije vazeci, propisani lijek je vec izdat.";
                alert.setContentText(s);
                alert.show();
            }
            else
            {
                try {
                    root = FXMLLoader.load(getClass().getResource("CheckOut.fxml"));

                    primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/logo.png")));
                    primaryStage.setTitle("Izdavanje lijeka na recept");
                    primaryStage.setScene(new Scene(root, 550  , 600));
                    primaryStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
