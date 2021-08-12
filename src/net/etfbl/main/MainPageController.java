package net.etfbl.main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {

    @FXML
    public AnchorPane pane;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Parent root = null;
        try {

            root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));

            pane.getChildren().removeAll();
            pane.getChildren().setAll(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void medicines(){
        Parent root = null;
        try {

            root = FXMLLoader.load(getClass().getResource("Medicines.fxml"));

            pane.getChildren().removeAll();
            pane.getChildren().setAll(root);

        } catch (IOException e) {
           e.printStackTrace();
        }
    }

    public void home(){
        Parent root = null;
        try {

            root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));

            pane.getChildren().removeAll();
            pane.getChildren().setAll(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}