package net.etfbl.main.users;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import net.etfbl.mysql.ZaposleniDAO;
import net.etfbl.dto.ZaposleniDTO;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;


public class UpdateUserController implements Initializable {

    @FXML
    private TextField jmbField;
    @FXML
    private TextField imeField;
    @FXML
    private TextField prezimeField;
    @FXML
    private TextField korImeField;
    @FXML
    private PasswordField lozinkaField;
    @FXML
    private TextField lozinkaUnmasked;
    @FXML
    private CheckBox showPass;
    @FXML
    private DatePicker datumRodjenjaField;
    @FXML
    private TextField plataField;
    @FXML
    private Label name;

    static ZaposleniDTO userToUpdate;

    @FXML
    void clear() {
        imeField.clear();
        prezimeField.clear();
        jmbField.clear();
        lozinkaField.clear();
        plataField.clear();
        datumRodjenjaField.getEditor().clear();
        korImeField.clear();
        lozinkaUnmasked.clear();
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setText(userToUpdate.getKorisnickoIme());
    }

    public void update(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.US);

        if(!jmbField.getText().equals("")){
            userToUpdate.setJMB(jmbField.getText());
        }
        if(!imeField.getText().equals("")){
            userToUpdate.setIme(imeField.getText());
        }
        if(!prezimeField.getText().equals("")){
            userToUpdate.setPrezime(prezimeField.getText());
        }
        if(!korImeField.getText().equals("")){
            userToUpdate.setKorisnickoIme(korImeField.getText());
        }
        if(!lozinkaField.getText().equals("")){
            userToUpdate.setLozinka(lozinkaField.getText());
        }
        if(datumRodjenjaField.getValue()!=null){
            userToUpdate.setDatumRodjenja((datumRodjenjaField.getValue()).format(formatter));
        }
        if(!plataField.getText().equals("")){
            userToUpdate.setPlata(Double.parseDouble(plataField.getText()));
        }

        ZaposleniDAO zaposleniDAO = new ZaposleniDAO();
        System.out.println(userToUpdate);
        zaposleniDAO.azuriraj(userToUpdate);

    }
}
