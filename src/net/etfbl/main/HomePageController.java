package net.etfbl.main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import net.etfbl.mysql.*;


import java.net.URL;
import java.util.ResourceBundle;

public class HomePageController implements Initializable {

    @FXML
    public Label username;

    @FXML
    public Label medCount;
    @FXML
    public Label usersCount;
    @FXML
    public Label prescriptionCount;
    @FXML
    public Label doktorCount;
    @FXML
    public Label pacijentCount;
    @FXML
    public Label racunCount;

    public  static String name;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LijekDAO lijekDAO = new LijekDAO();
        ZaposleniDAO zaposleniDAO = new ZaposleniDAO();
        ReceptDAO receptDAO = new ReceptDAO();

        medCount.setText(""+lijekDAO.count());
        usersCount.setText(""+zaposleniDAO.count());
        prescriptionCount.setText(""+receptDAO.count());
        doktorCount.setText(""+(new DoktorDAO()).count());
        pacijentCount.setText(""+(new PacijentDAO()).count());
        racunCount.setText(""+(new FiskalniRacunDAO()).count());

        username.setText(name);
    }
}
