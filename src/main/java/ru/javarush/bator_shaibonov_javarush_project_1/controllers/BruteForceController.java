package ru.javarush.bator_shaibonov_javarush_project_1.controllers;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ru.javarush.bator_shaibonov_javarush_project_1.consoleui.CheckInputData;
import ru.javarush.bator_shaibonov_javarush_project_1.cryptoboxes.BruteForceBox;

public class BruteForceController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField readCryptedFileField;

    @FXML
    private Button startBruteForceButton;

    @FXML
    private TextField writeUncryptedFileField;

    @FXML
    void initialize() {
        startBruteForceButton.setOnAction(event -> {
            System.out.println("Погнали");
            String addressOfFileForRead = readCryptedFileField.getText().trim();
            String addressOfFileForWrite = writeUncryptedFileField.getText().trim();
            if (CheckInputData.isValidAddress(addressOfFileForRead, true, false) &&
                    CheckInputData.isValidAddress(addressOfFileForWrite, true, true)) {
                System.out.println("Введенные данные валидны: " + addressOfFileForRead + ", " + addressOfFileForWrite);
                new BruteForceBox().startBruteForceMethod(addressOfFileForRead, addressOfFileForWrite);
            }
        });
    }

}

