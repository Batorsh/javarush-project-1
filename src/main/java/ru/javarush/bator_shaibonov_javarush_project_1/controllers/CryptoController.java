package ru.javarush.bator_shaibonov_javarush_project_1.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ru.javarush.bator_shaibonov_javarush_project_1.consoleui.CheckInputData;
import ru.javarush.bator_shaibonov_javarush_project_1.cryptoboxes.CryptoUncryptoBox;

public class CryptoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField cypherKeyField;

    @FXML
    private TextField readFileField;

    @FXML
    private Button startCryptoButton;

    @FXML
    private TextField writeFileField;

    @FXML
    void initialize() {
        startCryptoButton.setOnAction(event -> {
            System.out.println("Погнали");
            int typeOfOperation = 1;
            String addressOfFileForRead = readFileField.getText().trim();
            String addressOfFileForWrite = writeFileField.getText().trim();
            String cypherKey = cypherKeyField.getText().trim();
            //надо убрать проверку на создание файла, это есть в FileReaderWriter
            if (CheckInputData.isValidAddress(addressOfFileForRead, true, false) &&
                    CheckInputData.isValidAddress(addressOfFileForWrite, true, true) &&
                    CheckInputData.isValidKey(cypherKey)) {
                System.out.println("Введенные данные валидны: " + addressOfFileForRead + ", " + addressOfFileForWrite + ", " + cypherKey);
                new CryptoUncryptoBox().start(addressOfFileForRead, addressOfFileForWrite, Integer.parseInt(cypherKey));
            }
        });
    }

}


