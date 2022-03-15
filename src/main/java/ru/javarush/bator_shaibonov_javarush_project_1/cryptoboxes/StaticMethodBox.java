package ru.javarush.bator_shaibonov_javarush_project_1.cryptoboxes;

import ru.javarush.bator_shaibonov_javarush_project_1.fileinteractions.FileReaderWriter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class StaticMethodBox {

    //private static final char[] ALPHABET = CypherBox.ALPHABET;

    public void startStaticMethod(String addressOfFile, String addressOfFileForWrite, String adressOfFileForExample) {
        String exampleText = FileReaderWriter.readFromFile(adressOfFileForExample);
        char[] exampleCharacters = exampleText.toCharArray();
        HashMap<Character, Integer> exampleMap = createMapOfStatistics(exampleCharacters);
        String textFromFile = FileReaderWriter.readFromFile(addressOfFile);
        char[] inputCharacters = textFromFile.toCharArray();
        int resultKey = 0;
        char[] outputCharacters;
        char[] resultOutputCharacters = new char[inputCharacters.length];
        double minDifference = Double.MAX_VALUE;
        for (int i = 0; i < CypherBox.ALPHABET_LENGTH; i++) {
            int keyForCheck = -1 * i;
            outputCharacters = CypherBox.getShiftedArray(keyForCheck, inputCharacters);
            HashMap<Character, Integer> tempMap = createMapOfStatistics(outputCharacters);
            double countDeviation = getSumOfSquaresOfDeviation(tempMap, exampleMap);
            System.out.println(countDeviation);
            if (minDifference > countDeviation) {
                minDifference = countDeviation;
                resultKey = keyForCheck;
                resultOutputCharacters = Arrays.copyOf(outputCharacters, outputCharacters.length);
            }
        }
        System.out.println("Минимальное отличие: " + minDifference + ". Ключ: " + resultKey);
        FileReaderWriter.writeToFile(addressOfFileForWrite, resultOutputCharacters);

    }

    public static HashMap<Character, Integer> createMapOfStatistics(char[] inputCharacters) {
        HashMap<Character, Integer> mapOfCharCoincidences = new HashMap<>();
        //char[] inputCharacters = text.toCharArray();
        for (int i = 0; i < CypherBox.ALPHABET_LENGTH; i++) {
            int count = 0;
            for (int j = 0; j < inputCharacters.length; j++) {
                if (CypherBox.ALPHABET[i] == inputCharacters[j]) {
                    count++;
                }
            }
            mapOfCharCoincidences.put(CypherBox.ALPHABET[i], count * 1000 / inputCharacters.length);
        }
        return mapOfCharCoincidences;
    }

    public static double getSumOfSquaresOfDeviation(HashMap<Character, Integer> mapForComparison, HashMap<Character, Integer> exampleMap) {
        double sumOfSquares = 0;
        for (Map.Entry<Character, Integer> pair : exampleMap.entrySet()) {
            sumOfSquares += Math.pow(pair.getValue() - mapForComparison.get(pair.getKey()), 2);
        }
        return sumOfSquares;
    }
}