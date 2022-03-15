package ru.javarush.bator_shaibonov_javarush_project_1.cryptoboxes;

import ru.javarush.bator_shaibonov_javarush_project_1.fileinteractions.FileReaderWriter;

public class CryptoUncryptoBox {
    public static boolean uncryptoMode = false;

    public void start(String addressOfFile, String addressOfFileForWrite, int key) {
        String textFromFile = FileReaderWriter.readFromFile(addressOfFile);
        char[] inputCharacters = textFromFile.toCharArray();
        key = key % CypherBox.ALPHABET_LENGTH;
        key = uncryptoMode ? -1 * key : key;
        System.out.println("key = " + key);
        char[] outputCharacters = CypherBox.getShiftedArray(key, inputCharacters);
        FileReaderWriter.writeToFile(addressOfFileForWrite, outputCharacters);
    }
}
