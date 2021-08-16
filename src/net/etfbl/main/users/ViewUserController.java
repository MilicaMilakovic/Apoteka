package net.etfbl.main.users;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import net.etfbl.mysql.ApotekaDAO;
import net.etfbl.mysql.TelefonApotekeDAO;
import net.etfbl.mysql.ZaposlenjeDAO;
import net.etfbl.dto.ApotekaDTO;
import net.etfbl.dto.TelefonApotekeDTO;
import net.etfbl.dto.ZaposleniDTO;
import net.etfbl.dto.ZaposlenjeDTO;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ViewUserController implements Initializable {

    public static ZaposleniDTO zaposleni;
    public static ZaposlenjeDTO zaposlenje;
    public static ApotekaDTO apoteka;
    public static TelefonApotekeDTO telefon;

    @FXML
    private Label jmbLabel;

    @FXML
    private Label imeLabel;

    @FXML
    private Label prezimeLabel;

    @FXML
    private Label korImeLabel;

    @FXML
    private Label datumRodjenjaLabel;

    @FXML
    private Label plataLabel;

    @FXML
    private Label nazivApotekeLabel;

    @FXML
    private Label adresaApotekeLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label telefonLabel;

    @FXML
    private Label datumOdLabel;

    @FXML
    private Label datumDoLabel;

    @FXML
    private ComboBox<Integer> idApoteke;
    @FXML
    private Label user;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        user.setText(zaposleni.getIme()+" "+ zaposleni.getPrezime());
        jmbLabel.setText("JMB: "+ zaposleni.getJMB());
        imeLabel.setText("Ime: " + zaposleni.getIme());
        prezimeLabel.setText("Prezime: " + zaposleni.getPrezime());
        korImeLabel.setText("Korisnicko ime: " + zaposleni.getKorisnickoIme());
        datumRodjenjaLabel.setText("Datum rodjenja: "+ zaposleni.getDatumRodjenja());
        plataLabel.setText("Plata: "+ zaposleni.getPlata()+" KM" );

        ApotekaDAO apotekaDAO = new ApotekaDAO();
        ArrayList<Integer> ids = apotekaDAO.apotekeIDs();

        idApoteke.setItems(FXCollections.observableArrayList(ids));

    }

    public void viewDetails(){
        ZaposlenjeDAO zaposlenjeDAO = new ZaposlenjeDAO();
        ApotekaDAO apotekaDAO = new ApotekaDAO();
        TelefonApotekeDAO telefonApotekeDAO = new TelefonApotekeDAO();

        int id = idApoteke.getValue();

        apoteka = apotekaDAO.apoteka(id);
        telefon = telefonApotekeDAO.telefonApoteke(id);
        
        nazivApotekeLabel.setText("Naziv apoteke: " + apoteka.getNaziv());
        adresaApotekeLabel.setText("Adresa: " + apoteka.getAdresa());
        emailLabel.setText("Email: " + apoteka.getEmail() );
        telefonLabel.setText("Broj telefona: " + telefon.getTelefon());

        zaposlenje = zaposlenjeDAO.zaposlenje(zaposleni.getId(),id);
        if(zaposlenje!=null)
        {
            datumOdLabel.setText("Zaposlen od: " + zaposlenje.getDatumOd());
            datumDoLabel.setText("Zaposlen do: " + zaposlenje.getDatumDo());
        }
        else {
            datumOdLabel.setText("Zaposlen od: -- " );
            datumDoLabel.setText("Zaposlen do: -- ");
        }



    }
}
