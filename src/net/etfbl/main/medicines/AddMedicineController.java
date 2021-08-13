package net.etfbl.main.medicines;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import net.etfbl.dao.LijekDAO;
import net.etfbl.dto.LijekDTO;

import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class AddMedicineController {

    @FXML
    public TextField nazivField;
    @FXML
    public TextField kategorijaField;
    @FXML
    public TextField prodajnaCijenaField;
    @FXML
    public TextField nabavnaCijenaField;
    @FXML
    public TextField kolicinaField;
    @FXML
    public DatePicker datumProizvodnjeField;
    @FXML
    public DatePicker rokUpotrebeField;
    @FXML
    public TextField jacinaField;
    @FXML
    public TextField oblikField;
    @FXML
    public TextArea kontraindikacijeField;
    @FXML
    public TextArea opisField;


    public void add(){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.US);

        String datumProizvodnje =(datumProizvodnjeField.getValue()).format(formatter);
        String rokUpotrebe = (rokUpotrebeField.getValue()).format(formatter);

        LijekDTO lijek = new LijekDTO(0,nazivField.getText(),kategorijaField.getText(),
                Double.parseDouble(prodajnaCijenaField.getText()),Double.parseDouble(nabavnaCijenaField.getText()),
                kontraindikacijeField.getText(), datumProizvodnje,
                rokUpotrebe,Double.parseDouble(kolicinaField.getText()),
                opisField.getText(),oblikField.getText(),Double.parseDouble(jacinaField.getText()));

        LijekDAO lijekDAO = new LijekDAO();
        lijekDAO.dodajLijek(lijek);

        clear();
    }

    public void clear(){
        nazivField.clear();
        kategorijaField.clear();
        prodajnaCijenaField.clear();
        nabavnaCijenaField.clear();
        kolicinaField.clear();
        datumProizvodnjeField.getEditor().clear();
        rokUpotrebeField.getEditor().clear();
        jacinaField.clear();
        oblikField.clear();
        kontraindikacijeField.clear();
        opisField.clear();
    }


}
