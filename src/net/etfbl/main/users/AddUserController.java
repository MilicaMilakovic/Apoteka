package net.etfbl.main.users;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import net.etfbl.mysql.ZaposleniDAO;
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
    private TextField lozinkaUnmasked;
    @FXML
    private CheckBox showPass;
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

    @FXML
    public void togglevisiblePassword(ActionEvent event) {
        if (showPass.isSelected()) {
            String pass = lozinkaField.getText();
            lozinkaUnmasked.setText(pass);
            lozinkaField.setVisible(false);
            lozinkaUnmasked.setVisible(true);
            return;
        }
        lozinkaUnmasked.setVisible(false);
        lozinkaField.setVisible(true);
        lozinkaField.setText(lozinkaUnmasked.getText());

    }
}
