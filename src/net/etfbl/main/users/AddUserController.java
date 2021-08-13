package net.etfbl.main.users;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import net.etfbl.dao.ZaposleniDAO;
import net.etfbl.dto.ZaposleniDTO;

import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class AddUserController {

    @FXML
    public TextField jmbField;
    @FXML
    public TextField imeField;
    @FXML
    public TextField prezimeField;
    @FXML
    public TextField korImeField;
    @FXML
    public PasswordField lozinkaField;
    @FXML
    public TextField plataField;
    @FXML
    public DatePicker datumRodjenjaField;

    public void add(){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.US);

        ZaposleniDTO zaposleniDTO = new ZaposleniDTO(0,jmbField.getText(),imeField.getText(),
                prezimeField.getText(),korImeField.getText(),lozinkaField.getText(),(datumRodjenjaField.getValue()).format(formatter),
                Double.parseDouble(plataField.getText()));

        ZaposleniDAO zaposleniDAO = new ZaposleniDAO();
        zaposleniDAO.dodajZaposlenog(zaposleniDTO);
    }

    public void clear(){
        imeField.clear();
        prezimeField.clear();
        jmbField.clear();
        lozinkaField.clear();
        plataField.clear();
        datumRodjenjaField.getEditor().clear();
        korImeField.clear();
    }

}
