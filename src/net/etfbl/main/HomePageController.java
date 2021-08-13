package net.etfbl.main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import net.etfbl.dao.LijekDAO;


import java.net.URL;
import java.util.ResourceBundle;

public class HomePageController implements Initializable {

    @FXML
    public Label medCount;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LijekDAO lijekDAO = new LijekDAO();
        medCount.setText(""+lijekDAO.count());
    }
}
