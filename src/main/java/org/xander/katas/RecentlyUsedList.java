package org.xander.katas;

import java.util.ArrayList;
import java.util.List;

public class RecentlyUsedList {
    private static final String LIST_IS_EMPTY = "list is empty";
    private List<String> stringContainer = new ArrayList<>();
    private int capacity;

    public void pushAString(String stringToHold) {
        if (stringToHold == null || stringToHold.isEmpty()) {
            throw new UnsupportedOperationException("it is not possible to add a null or emty size string");
        }

        if (getCapacity() == stringContainer.size() && itIsPossibleToGetAnElement()) {
            stringContainer.remove(0);
        }

        if (elementIsUnique(stringToHold)) {

            stringContainer.add(stringToHold);
        }
    }

    private boolean elementIsUnique(String elementToCheckForUniqueness) {
            if (itIsPossibleToGetAnElement()) {
                for (String element : stringContainer) {
                    if (element.equals(elementToCheckForUniqueness)) {
                        return false;
                    }
                }
            }
        return true;
    }

    public String getLastString() {
        int lastElement = 0;
        if (itIsPossibleToGetAnElement())
            return getReversedStringContainer().get(lastElement);
        throw new UnsupportedOperationException("list is empty");
    }

    public String getFirstString() {
        int firstElement = stringContainer.size() - 1;
        if (itIsPossibleToGetAnElement())
            return getReversedStringContainer().get(firstElement);
        throw new UnsupportedOperationException(LIST_IS_EMPTY);
    }

    private boolean itIsPossibleToGetAnElement() {
        if (!stringContainer.isEmpty()) {
            return true;
        }
        return false;
    }

    private List<String> getReversedStringContainer() {
        List<String> reversedStringContainer = new ArrayList<>(stringContainer.size());
        for (int i = stringContainer.size(); i > 0; i--) {
            reversedStringContainer.add(stringContainer.get(i - 1));
        }
        return reversedStringContainer;
    }

    public int getSizeOfList() {
        return stringContainer.size();
    }

    public String getElementNumber(int index) {
        String elementToGet = "";
        for (int i = 0; i < stringContainer.size(); i++) {
            if (i == index)
                elementToGet = stringContainer.get(i);
        }
        return elementToGet;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
