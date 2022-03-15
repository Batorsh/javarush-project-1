package ru.javarush.bator_shaibonov_javarush_project_1.consoleui;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;


public class CheckInputData {

    public static boolean isValidAddress(String address, boolean checkForExisting, boolean createIfNotExists) {
        if (!address.startsWith("C:\\test\\") || !address.endsWith(".txt")) {
            System.out.println("Формат адреса файла: " + address + " - не верный, введите ещё раз");
            return false;
        }
        if (checkForExisting && Files.notExists(Path.of(address))) {
            if (createIfNotExists) {
                try {
                    Files.createFile(Path.of(address));
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Файл с таким адресом " + address + " не существует, попробуйте ввести еще раз.");
            }
            return false;
        }
        return true;
    }

    public static boolean isValidKey(String key) {
            if (!Pattern.matches("[-]?[0-9]+", key)){
                System.out.println("Ключ должен быть целым числом");
                return false;
            }
            return true;
    }
}
