package net.etfbl.main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    public void login(){

        Stage primaryStage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
            primaryStage.setTitle("Hello World");
            primaryStage.setScene(new Scene(root, 1370, 708));
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
