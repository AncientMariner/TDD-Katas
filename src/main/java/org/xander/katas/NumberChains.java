package org.xander.katas;

public class NumberChains {
    private StringBuilder headLinkOfChain = new StringBuilder("Original number was ");
    private String tailLinkOfChain = "\nChain length is ";

    public int formAscOrder(int number) {
        if (thereIsNoNeedToSort(number)) {
            return number;
        }
        return Integer.parseInt(bubbleSortAsc(number));
    }

    public int formDescOrder(int number) {
        if (thereIsNoNeedToSort(number)) {
            return number;
        }
        return Integer.parseInt(bubbleSortDesc(number));
    }

    private boolean thereIsNoNeedToSort(int number) {
        return String.valueOf(number).length() == 1;
    }

    public int formASubstraction(int number) {
        if (thereIsNoNeedToSort(number)) {
            return 0;
        }
        return Integer.parseInt(bubbleSortDesc(number)) - Integer.parseInt(bubbleSortAsc(number));
    }

    public String formAChain(int number) {
        boolean chainHasLinks = true;
        int lengthOfChain = 0;
        headLinkOfChain.append(number);

        while (chainHasLinks) {
            if (number != formASubstraction(number)) {
                formALinkOfChain(number, headLinkOfChain);
                number = formASubstraction(number);
            } else {
                formALinkOfChain(number, headLinkOfChain);
                chainHasLinks = false;
            }
            lengthOfChain++;
        }
        headLinkOfChain.append(tailLinkOfChain + lengthOfChain);

        return headLinkOfChain.toString();
    }

    private void formALinkOfChain(int number, StringBuilder originalChain) {
        String linkOfChain = "\n" + formDescOrder(number) + " - " + formAscOrder(number) + " = " + formASubstraction(number);
        originalChain.append(linkOfChain);
    }

    private String bubbleSortDesc(int number) {
        char[] arrayOfSymbols = String.valueOf(number).toCharArray();
        boolean needToSwap = true;
        int j = 0;
        char temp;
        while (needToSwap) {
            needToSwap = false;
            j++;
            for (int i = 0; i < arrayOfSymbols.length - j; i++) {
                if (arrayOfSymbols[i] < arrayOfSymbols[i + 1]) {
                    temp = arrayOfSymbols[i + 1];
                    arrayOfSymbols[i + 1] = arrayOfSymbols[i];
                    arrayOfSymbols[i] = temp;
                    needToSwap = true;
                }
            }
        }
        return returnAResult(arrayOfSymbols);
    }

    private String bubbleSortAsc(int number) {
        char[] arrayOfSymbols = formAnAscArrayWithoutLeadingZeros(number);
        boolean needToSwap = true;
        int j = 0;
        char temp;
        while (needToSwap) {
            needToSwap = false;
            j++;
            for (int i = 0; i < arrayOfSymbols.length - j; i++) {
                if (arrayOfSymbols[i] > arrayOfSymbols[i + 1]) {
                    temp = arrayOfSymbols[i + 1];
                    arrayOfSymbols[i + 1] = arrayOfSymbols[i];
                    arrayOfSymbols[i] = temp;
                    needToSwap = true;
                }
            }
        }
        return returnAResult(arrayOfSymbols);
    }

    private char[] formAnAscArrayWithoutLeadingZeros(int number) {
        StringBuilder resultString = new StringBuilder(String.valueOf(number));
        for (int i = 0; i < resultString.length(); i++) {
            if (resultString.charAt(i) == '0') {
                resultString.deleteCharAt(i);
            }
        }
        return resultString.toString().toCharArray();
    }

    private String returnAResult(char[] arrayOfSymbols) {
        StringBuilder secureCopyOfTheArray = new StringBuilder();
        for (char element : arrayOfSymbols) {
            secureCopyOfTheArray.append(element);
        }
        return secureCopyOfTheArray.toString();
    }
}
