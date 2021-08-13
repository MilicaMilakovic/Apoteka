package net.etfbl.main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import net.etfbl.dao.LijekDAO;
import net.etfbl.dao.ZaposleniDAO;


import java.net.URL;
import java.util.ResourceBundle;

public class HomePageController implements Initializable {

    @FXML
    public Label username;

    @FXML
    public Label medCount;
    @FXML
    public Label usersCount;

    public  static String name;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LijekDAO lijekDAO = new LijekDAO();
        ZaposleniDAO zaposleniDAO = new ZaposleniDAO();
        medCount.setText(""+lijekDAO.count());
        usersCount.setText(""+zaposleniDAO.count());
        username.setText(name);
    }
}
