package net.etfbl.main.prescriptions;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import net.etfbl.dto.*;
import net.etfbl.mysql.FiskalniRacunDAO;
import net.etfbl.mysql.FiskalniRacunStavkaDAO;
import net.etfbl.mysql.IzdavanjeLijekaDAO;
import net.etfbl.main.MainPageController;
import net.etfbl.mysql.LijekDAO;

import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class CheckOutController implements Initializable {

    @FXML
    private Label pacijentLabel;

    @FXML
    private Label datumLabel;

    @FXML
    private Label doktorLabel;

    @FXML
    private Label lijekLabel;

    public static ReceptInfoDTO info;

    @FXML
    private TextArea racunText;

    private IzdavanjeLijekaDTO izdavanjeLijekaDTO;
    private FiskalniRacunDTO racun;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            pacijentLabel.setText(info.getPacijent());
            datumLabel.setText(info.getDatumPropisivanjaLijeka());
            doktorLabel.setText(info.getDoktor());
            lijekLabel.setText(info.getGenerickiNaziv() + "   " + info.getPropisanaKolicina());


        LijekDAO lijekDAO = new LijekDAO();
        FiskalniRacunDAO fiskalniRacunDAO = new FiskalniRacunDAO();
        FiskalniRacunStavkaDAO fiskalniRacunStavkaDAO = new FiskalniRacunStavkaDAO();

        LijekDTO lijek = lijekDAO.lijek(info.getLijekID());
        FiskalniRacunDTO racun = fiskalniRacunDAO.kreirajRacun();

//        System.out.println(racun);

        FiskalniRacunStavkaDTO stavka = new FiskalniRacunStavkaDTO(lijek.getLijekID(),racun.getRacunID(),
                    info.getPropisanaKolicina(),lijek.getProdajnaCijena()*info.getPropisanaKolicina());

//        System.out.println(stavka);
        fiskalniRacunStavkaDAO.dodajStavku(stavka);

        stavka.setNazivLijeka(lijek.getGenerickiNaziv());
        racunText.appendText(stavka.toString());



        izdavanjeLijekaDTO = new IzdavanjeLijekaDTO(MainPageController.zaposleni.getId(),info.getLijekID(),
                info.getReceptID(),info.getPropisanaKolicina(),(new Timestamp(new Date().getTime())).toString(),racun.getRacunID());

    }

    public void checkOut(){

        IzdavanjeLijekaDAO izdavanjeLijekaDAO = new IzdavanjeLijekaDAO();
        if(izdavanjeLijekaDTO!=null)
        {
            izdavanjeLijekaDAO.evidentiraj(izdavanjeLijekaDTO);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/logo.png")));

            alert.setTitle("Obavjestenje");
            alert.setHeaderText(null);
            String s ="Evidentirano izdavanje lijeka na recept!";
            alert.setContentText(s);
            alert.show();
            PrescriptionsController.refresh=true;
        } else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/logo.png")));

            alert.setTitle("Obavjestenje");
            alert.setHeaderText(null);
            String s ="Neuspjesno izdavanje lijeka na recept!";
            alert.setContentText(s);
            alert.show();
        }

    }


}
