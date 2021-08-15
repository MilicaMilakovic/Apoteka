package net.etfbl.main.prescriptions;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class PrescriptionsController implements Initializable {

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> idCol;

    @FXML
    private TableColumn<?, ?> imeCol;

    @FXML
    private TableColumn<?, ?> prezimeCol;

    @FXML
    private TableColumn<?, ?> lijekCol;

    @FXML
    private TableColumn<?, ?> propisanaKolicinaCol;

    @FXML
    private TableColumn<?, ?> doktorCol;

    @FXML
    private TableColumn<?, ?> datumCol;

    @FXML
    private TableColumn<?, ?> cijenaCol;

    @FXML
    private TextField searchField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    @FXML
    void search(ActionEvent event) {

    }

}
