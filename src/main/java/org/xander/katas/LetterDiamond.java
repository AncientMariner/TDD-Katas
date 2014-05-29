package org.xander.katas;

import java.util.ArrayList;
import java.util.List;

public class LetterDiamond {
    public String buildADiamond(char symbol) {
        int differenceWithStartingSymbol = (int) (String.valueOf(symbol).toUpperCase().charAt(0)) - (int) 'A';
        System.out.println(differenceWithStartingSymbol);
//        System.out.println("A" + 'A' + " " + (int) 'A');
//        System.out.println("B" + 'B' + " " + (int) 'B');

        List<Character> listOfSymbols = new ArrayList<>();
        for (int w = differenceWithStartingSymbol; w > 0; w--) {
            listOfSymbols.add(' ');
        }
        listOfSymbols.add('A');
        listOfSymbols.add('\n');
        int i, a;
        for (i = 1, a = 'B'; i < differenceWithStartingSymbol; i++) {
            for (int w = differenceWithStartingSymbol - i; w > 0; w--) {
                listOfSymbols.add(' ');
            }
            listOfSymbols.add((char)(a));
            for (int innerWhitespaceCounter = 0 ; innerWhitespaceCounter < ((a-'A') - 1)*2 + 1; innerWhitespaceCounter++) {
                listOfSymbols.add(' ');
            }
            listOfSymbols.add((char)(a++));
            listOfSymbols.add('\n');
        }

        listOfSymbols.add(symbol);
        for (int w = 0; w < (differenceWithStartingSymbol * 2) - 1; w++) {
            listOfSymbols.add(' ');
        }
        listOfSymbols.add(symbol);
                listOfSymbols.add('\n');


        for (i = differenceWithStartingSymbol, a = (char)(symbol-1); i > 1 ; i--) {
            for (int w = differenceWithStartingSymbol -i + 1; w > 0; w--) {
                listOfSymbols.add(' ');
            }
            listOfSymbols.add((char)(a));
            for (int innerWhitespaceCounter = ((a-'A'))*2 - 1 ; innerWhitespaceCounter > 0 ; innerWhitespaceCounter--) {
                listOfSymbols.add(' ');
            }
            listOfSymbols.add((char)(a--));
            listOfSymbols.add('\n');
        }

        for (int w = differenceWithStartingSymbol; w > 0; w--) {
            listOfSymbols.add(' ');
        }
        listOfSymbols.add('A');


        for (char ch : listOfSymbols) {
            System.out.print(ch);
        }

//        Collections.reverse(listOfSymbols);
//        for (char ch : listOfSymbols) {
//            System.out.print(ch);
//        }


        return String.valueOf(symbol).toUpperCase();
    }
}
