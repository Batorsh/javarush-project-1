package ru.javarush.bator_shaibonov_javarush_project_1.controllers;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import ru.javarush.bator_shaibonov_javarush_project_1.HelloApplication;
import ru.javarush.bator_shaibonov_javarush_project_1.cryptoboxes.CryptoUncryptoBox;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button cryptoButton;

    @FXML
    private Button uncryptoBruteForceButton;

    @FXML
    private Button uncryptoButton;

    @FXML
    private Button uncryptoStaticMethodButton;

    @FXML
    void initialize() {
        cryptoButton.setOnAction(event -> {
            cryptoButton.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("crypto-view.fxml"));
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = fxmlLoader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

        uncryptoButton.setOnAction(event -> {
            CryptoUncryptoBox.uncryptoMode = true;//Меняем знак ключа, если выбран режим дешифровки
            uncryptoButton.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("crypto-view.fxml"));
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = fxmlLoader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

        uncryptoBruteForceButton.setOnAction(event -> {
            uncryptoBruteForceButton.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("bruteforce-view.fxml"));
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = fxmlLoader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

        uncryptoStaticMethodButton.setOnAction(event -> {
            uncryptoStaticMethodButton.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("staticmethod-view.fxml"));
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = fxmlLoader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }



}

