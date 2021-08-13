package net.etfbl.main;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import net.etfbl.dao.ZaposleniDAO;

import java.io.IOException;

public class LoginController {

    @FXML
    public Button btn;
    @FXML
    public TextField usernameField;
    @FXML
    public PasswordField passwordField;


    public void login(){

        String username = usernameField.getText();
        String password = passwordField.getText();

        if(username.equals("")||password.equals(""))
        {
            moveButton(btn);
            return;
        }

        ZaposleniDAO zaposleniDAO = new ZaposleniDAO();

        if(zaposleniDAO.logIn(username,password)) {

            Stage primaryStage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
                primaryStage.setTitle("Hello World");
                primaryStage.setScene(new Scene(root, 1370, 708));
                primaryStage.show();

                Stage stage = (Stage) btn.getScene().getWindow();
                stage.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else
            moveButton(btn);

    }
    private void moveButton(Button btn){

        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(200));
        translateTransition.setNode(btn);
        translateTransition.setFromX(-5);
        translateTransition.setToX(5);
        translateTransition.setAutoReverse(true);
        translateTransition.setCycleCount(3);
        translateTransition.setInterpolator(Interpolator.EASE_BOTH);
        translateTransition.play();
        translateTransition.setOnFinished(e -> {btn.setTranslateX(0);});
    }
}

