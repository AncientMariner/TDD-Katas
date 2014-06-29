package org.xander.katas;

public class NumberChains {
    public String formAscendingOrder(int number) {
        char[] arrayOfSymbols = formAnArrayWithoutZeros(number);

        String result = bubbleSortAsc(arrayOfSymbols);

        String ascendingArray = result;
        return String.valueOf(ascendingArray);
    }

    public String formDescendingOrder(int number) {
        char[] arrayOfSymbols = formAnArrayWithoutZeros(number);

        String result = bubbleSortDesc(arrayOfSymbols);

        String descendingArray = result;
        return String.valueOf(descendingArray);
    }

    public int formSubstraction(int number) {
        char[] arrayOfSymbols = formAnArrayWithoutZeros(number);

        String resultAsc = bubbleSortAsc(arrayOfSymbols);
        String resultDesc = bubbleSortDesc(arrayOfSymbols);

        return Integer.parseInt(resultAsc) - Integer.parseInt(resultDesc);
    }

    public String formAChain(int number) {
        int substraction = formSubstraction(number);


        String desc = formDescendingOrder(substraction);
        String asc = formAscendingOrder(substraction);

        boolean chainActual = true;
        while (chainActual) {

        }

        return null;
    }

    private char[] formAnArrayWithoutZeros(int number) {
        StringBuilder resultString = new StringBuilder(String.valueOf(number));
        for (int i = 0; i < resultString.length(); i++) {
            if (resultString.charAt(i)== '0') {
                resultString.deleteCharAt(i);
            }
        }
        return resultString.toString().toCharArray();
    }

    private String bubbleSortAsc(char[] arrayOfSymbols) {
        boolean swapped = true;
        int j = 0;
        char temp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < arrayOfSymbols.length - j; i++) {
                if (arrayOfSymbols[i] > arrayOfSymbols[i + 1]) {
                    if (arrayOfSymbols[i] != '0' && arrayOfSymbols[i + 1] != '0') {
                        temp = arrayOfSymbols[i + 1];
                        arrayOfSymbols[i + 1] = arrayOfSymbols[i];
                        arrayOfSymbols[i] = temp;
                        swapped = true;
                    }
                }
            }
        }
        return returnAResult(arrayOfSymbols);
    }

    private String bubbleSortDesc(char[] arrayOfSymbols) {
        boolean swapped = true;
        int j = 0;
        char temp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < arrayOfSymbols.length - j; i++) {
                if (arrayOfSymbols[i] < arrayOfSymbols[i + 1]) {
                    if (arrayOfSymbols[i] != '0' && arrayOfSymbols[i + 1] != '0') {
                        temp = arrayOfSymbols[i + 1];
                        arrayOfSymbols[i + 1] = arrayOfSymbols[i];
                        arrayOfSymbols[i] = temp;
                        swapped = true;
                    }
                }
            }
        }
        return returnAResult(arrayOfSymbols);
    }

    private String returnAResult(char[] arrayOfSymbols) {
        StringBuilder secureCopyOfTheArray = new StringBuilder();

        for (char element : arrayOfSymbols) {
            secureCopyOfTheArray.append(element);
        }
        return secureCopyOfTheArray.toString();
    }
}
