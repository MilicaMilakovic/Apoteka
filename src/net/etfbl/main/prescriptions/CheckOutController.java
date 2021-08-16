package net.etfbl.main.prescriptions;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import net.etfbl.mysql.IzdavanjeLijekaDAO;
import net.etfbl.dto.IzdavanjeLijekaDTO;
import net.etfbl.dto.ReceptInfoDTO;
import net.etfbl.main.MainPageController;

import java.net.URL;
import java.sql.Timestamp;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            pacijentLabel.setText(info.getPacijent());
            datumLabel.setText(info.getDatumPropisivanjaLijeka());
            doktorLabel.setText(info.getDoktor());
            lijekLabel.setText(info.getGenerickiNaziv() + "   " + info.getPropisanaKolicina());

        IzdavanjeLijekaDAO izdavanjeLijekaDAO = new IzdavanjeLijekaDAO();
        izdavanjeLijekaDAO.evidentiraj(new IzdavanjeLijekaDTO(MainPageController.zaposleni.getId(),info.getLijekID(),
                info.getReceptID(),info.getPropisanaKolicina(),(new Timestamp(new Date().getTime())).toString()));



    }


}
