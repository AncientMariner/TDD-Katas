package org.xander.katas;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AnagramCalculation {
    public Set<String> getAnagramsFrom(String originalWord) {
        Set<String> listOfWords = new HashSet<>();

        if (originalWord.length() > 2) {
            for (int i = 0; i < originalWord.length(); i++) {
                StringBuilder word = new StringBuilder(originalWord);
                listOfWords.addAll(formWordsForAnyNumberOfLetters(String.valueOf(word.charAt(i)),
                                                                  String.valueOf(word.deleteCharAt(i))));
            }
        } else {
            listOfWords.add(new StringBuilder(originalWord).reverse().toString());
        }
        removeOriginalWordIfPresent(originalWord, listOfWords);

//      uncomment for tests generation
//        generateAssertsForTest(listOfWords);
        return listOfWords;
    }

    private Set<String> formWordsForAnyNumberOfLetters(String leftPart, String rightPart) {
        Set<String> listOfWords = new HashSet<>();
        if (rightPart.length() > 2) {
            formWordsForTwoAndMoreLetters(leftPart, rightPart, listOfWords);
        } else {
            formWordsForTwoAndLessLetters(leftPart, rightPart, listOfWords);
        }
        return listOfWords;
    }

    private void formWordsForTwoAndMoreLetters(String leftPart, String rightPart, Set<String> listOfWords) {
        Set<String> workOnWords = new HashSet<>();

        //need to move pointer not only from side to side, but also at specific index
        for (int pointer = 0; pointer < rightPart.length(); pointer++) {
            StringBuilder rightPartToWorkOn = new StringBuilder(rightPart);
            workOnWords.addAll(formWordsForAnyNumberOfLetters(String.valueOf(rightPartToWorkOn.charAt(pointer)),
                    String.valueOf(rightPartToWorkOn.deleteCharAt(pointer))));
        }
        // to save original symbol from the root of the recursion
        for (Iterator<String> iterator = workOnWords.iterator(); iterator.hasNext(); ) {
            listOfWords.add(leftPart + iterator.next());
        }
    }

    private void formWordsForTwoAndLessLetters(String leftPart, String rightPart, Set<String> listOfWords) {
        StringBuilder rightPartOfTheWord = new StringBuilder(rightPart);
        listOfWords.add(leftPart + rightPartOfTheWord.toString());
        listOfWords.add(leftPart + rightPartOfTheWord.reverse().toString());
    }

    private void removeOriginalWordIfPresent(String word, Set<String> listOfWords) {
        if (listOfWords.contains(word)) {
            for (Iterator<String> iterator = listOfWords.iterator(); iterator.hasNext(); ) {
                if (iterator.next().equals(word)) {
                    iterator.remove();
                }
            }
        }
    }

    public int numberOfWordsFrom(String word) {
        int length = word.length();
        int result = 1;

        while(length > 0) result *= length--;

        int originalWordShouldNotBeCount = result -  1;
        return originalWordShouldNotBeCount;
    }

    private void generateAssertsForTest(Set<String> listOfWords) {
        int counter = 0;
        for (Iterator<String> iterator = listOfWords.iterator(); iterator.hasNext(); ) {
            System.out.println("assertTrue(anagramsFromWord.contains(\"" + iterator.next() + "\"));");
            counter++;
        }
        System.out.println("\n" + counter + " asserts generated");
    }
}
