package ru.javarush.bator_shaibonov_javarush_project_1.cryptoboxes;

import java.util.Set;

public class CounterOfCoincidenceSpaceAndDots {

    private static final Set<Character> SET_OF_PUNCTUATION_MARKS = Set.of('.', ',', ':', '!', '?', ';');

    public static int countOfCoincidenceSpaceAndDots(char[] charsForAnalyze) {
        int count = 0;
        for (int i = 0; i < charsForAnalyze.length - 1; i++) {
            if (SET_OF_PUNCTUATION_MARKS.contains(charsForAnalyze[i])) {
                if (charsForAnalyze[i + 1] == ' ' || charsForAnalyze[i + 1] == '\n' || charsForAnalyze[i + 1] == '\t') {
                    count++;
                }
            }
        }
        return count;
    }
}
