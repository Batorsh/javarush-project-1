package ru.javarush.bator_shaibonov_javarush_project_1.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ru.javarush.bator_shaibonov_javarush_project_1.consoleui.CheckInputData;
import ru.javarush.bator_shaibonov_javarush_project_1.cryptoboxes.CryptoUncryptoBox;
import ru.javarush.bator_shaibonov_javarush_project_1.cryptoboxes.StaticMethodBox;

public class StaticMethodController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField readExampleStaticMethodFileField;

    @FXML
    private TextField readStaticMethodFileField;

    @FXML
    private Button startStaticMethodButton;

    @FXML
    private TextField writeStaticMethodFileField;

    @FXML
    void initialize() {
        startStaticMethodButton.setOnAction(event -> {
            System.out.println("Погнали");
            int typeOfOperation = 1;
            String addressOfFileForRead = readStaticMethodFileField.getText().trim();
            String addressOfFileForWrite = writeStaticMethodFileField.getText().trim();
            String addressOfFileForExample = readExampleStaticMethodFileField.getText().trim();
            //надо убрать проверку на создание файла, это есть в FileReaderWriter
            if (CheckInputData.isValidAddress(addressOfFileForRead, true, false) &&
                    CheckInputData.isValidAddress(addressOfFileForWrite, true, true) &&
                    CheckInputData.isValidAddress(addressOfFileForExample, true, false)) {
                System.out.println("Введенные данные валидны: " + addressOfFileForRead + ", " + addressOfFileForWrite + ", " + addressOfFileForExample);
                new StaticMethodBox().startStaticMethod(addressOfFileForRead, addressOfFileForWrite, addressOfFileForExample);
            }
        });
    }
}