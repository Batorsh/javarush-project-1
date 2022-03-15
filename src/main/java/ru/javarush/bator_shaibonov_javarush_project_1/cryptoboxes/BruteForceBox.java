package ru.javarush.bator_shaibonov_javarush_project_1.cryptoboxes;

import ru.javarush.bator_shaibonov_javarush_project_1.fileinteractions.FileReaderWriter;


public class BruteForceBox {

    public void startBruteForceMethod(String addressOfFile, String addressOfFileForWrite) {
        String textFromFile = FileReaderWriter.readFromFile(addressOfFile);
        char[] inputCharacters = textFromFile.toCharArray();
        int resultKey = 0;
        char[] outputCharacters;
        char[] resultOutputCharacters;
        int maxOfCoincidence = 0;
        for (int i = 0; i < CypherBox.ALPHABET_LENGTH; i++) {
            int keyForCheck = -1 * i;
            outputCharacters = CypherBox.getShiftedArray(keyForCheck, inputCharacters);
            int count = CounterOfCoincidenceSpaceAndDots.countOfCoincidenceSpaceAndDots(outputCharacters);
            if (maxOfCoincidence < count) {
                maxOfCoincidence = count;
                resultKey = keyForCheck;
                //resultOutputCharacters = Arrays.copyOf(outputCharacters, outputCharacters.length); - здесь может быть слишком много перезаписей, поэтому вынес за скобки
            }
        }
        resultOutputCharacters = CypherBox.getShiftedArray(resultKey, inputCharacters);
        System.out.println("Максимальное совпадение: " + maxOfCoincidence + ". Ключ: " + resultKey);
        FileReaderWriter.writeToFile(addressOfFileForWrite, resultOutputCharacters);
    }
}