package org.xander.katas;

import java.util.ArrayList;
import java.util.List;

public class LetterDiamond {
    static final char A_LETTER = 'A';
    static final char B_LETTER = 'B';
    static final char WHITESPACE_SYMBOL = ' ';
    static final char NEXT_LINE_SYMBOL = '\n';

    public String buildADiamond(char symbol) {
        List<Character> listOfSymbols = new ArrayList<>();

        buildFirstAndLastRow(listOfSymbols, symbol);

        buildAscendingPart(symbol, listOfSymbols);

        buildDescendingPart(symbol, listOfSymbols);

        buildFirstAndLastRow(listOfSymbols, symbol);

//      uncomment for test generation
//        for (char ch : listOfSymbols) {
//            System.out.print(ch);
//        }

        StringBuilder finalResult = new StringBuilder();
        for (char ch : listOfSymbols)
            finalResult.append(String.valueOf(ch));

        return finalResult.toString();
    }

    private void buildDescendingPart(char symbol, List<Character> listOfSymbols) {
        int differenceWithStartingSymbol = (int) (String.valueOf(symbol).toUpperCase().charAt(0)) - (int) A_LETTER;
        int i;
        int a;
        for (i = differenceWithStartingSymbol, a = (char) (symbol - 1); i > 1; i--) {
            for (int w = differenceWithStartingSymbol - i + 1; w > 0; w--) {
                listOfSymbols.add(WHITESPACE_SYMBOL);
            }
            listOfSymbols.add((char) (a));
            for (int innerWhitespaceCounter = ((a - A_LETTER)) * 2 - 1; innerWhitespaceCounter > 0; innerWhitespaceCounter--) {
                listOfSymbols.add(WHITESPACE_SYMBOL);
            }
            listOfSymbols.add((char) (a--));
            listOfSymbols.add('\n');
        }
    }

    private void buildAscendingPart(char symbol, List<Character> listOfSymbols) {
        int differenceWithStartingSymbol = (int) (String.valueOf(symbol).toUpperCase().charAt(0)) - (int) A_LETTER;

        listOfSymbols.add(NEXT_LINE_SYMBOL);
        int number, letter;
        for (number = 1, letter = B_LETTER; number < differenceWithStartingSymbol; number++) {
            for (int w = differenceWithStartingSymbol - number; w > 0; w--) {
                listOfSymbols.add(WHITESPACE_SYMBOL);
            }
            listOfSymbols.add((char) (letter));
            for (int innerWhitespaceCounter = 0; innerWhitespaceCounter < ((letter - A_LETTER) - 1) * 2 + 1; innerWhitespaceCounter++) {
                listOfSymbols.add(WHITESPACE_SYMBOL);
            }
            listOfSymbols.add((char) (letter++));
            listOfSymbols.add(NEXT_LINE_SYMBOL);
        }
        listOfSymbols.add(symbol);
        for (int w = 0; w < (differenceWithStartingSymbol * 2) - 1; w++) {
            listOfSymbols.add(WHITESPACE_SYMBOL);
        }
        listOfSymbols.add(symbol);
        listOfSymbols.add(NEXT_LINE_SYMBOL);
    }

    private void buildFirstAndLastRow(List<Character> listOfSymbols, char symbol) {
        int differenceWithStartingSymbol = (int) (String.valueOf(symbol).toUpperCase().charAt(0)) - (int) A_LETTER;
        for (int i = differenceWithStartingSymbol; i > 0; i--) {
            listOfSymbols.add(WHITESPACE_SYMBOL);
        }
        listOfSymbols.add(A_LETTER);
    }
}
