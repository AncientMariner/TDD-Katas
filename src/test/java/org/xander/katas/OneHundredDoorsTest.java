package org.xander.katas;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OneHundredDoorsTest {
    OneHundredDoors oneHundredDoors = new OneHundredDoors();

    @Test
    public void basic() {
        assertNotNull(oneHundredDoors);
    }

    @Test
    public void allAreClosedInitially() {
        for (Boolean door : oneHundredDoors.checkAllDoors()) {
            assertFalse(door);
        }
    }

    @Test
    public void firstGo() {
        oneHundredDoors.go(1);

        for (Boolean door : oneHundredDoors.checkAllDoors()) {
            assertTrue(door);
        }
    }

    @Test
    public void secondGo() {
        int second = 2;
        oneHundredDoors.go(second);
        boolean[] currentList = oneHundredDoors.checkAllDoors();

        for (int i = 0; i < currentList.length ; i = i + second) {
            assertTrue(currentList[i]);
        }
    }

    @Test
    public void thirdGo() {
        int third = 3;
        oneHundredDoors.go(third);
        boolean[] currentList = oneHundredDoors.checkAllDoors();

        for (int i = 0; i < currentList.length ; i = i + third) {
            assertTrue(currentList[i]);
        }
    }

    @Test
    public void allGoes() {
        for (int goNumber = 1; goNumber < 100; goNumber++) {
            oneHundredDoors.go(goNumber);
        }
        outputDoorsStates();
    }

    private void outputDoorsStates() {
        List<Boolean> positiveNumbers = new ArrayList<>();
        List<Boolean> negativeNumbers = new ArrayList<>();

        for (Boolean element : oneHundredDoors.checkAllDoors()) {
            if (element.booleanValue()) {
                positiveNumbers.add(element);
            } else {
                negativeNumbers.add(element);
            }
        }

        System.out.println("There are " + positiveNumbers.size() + " positive numbers ");
        System.out.print("and " + negativeNumbers.size() + " negative numbers ");
        System.out.println("\nHere are they respectively: ");


        System.out.println("\nPositive : ");
        boolean[] listOfDoors = oneHundredDoors.checkAllDoors();
        for (int i = 0 ; i < listOfDoors.length ; i++) {
            if (listOfDoors[i])
                System.out.print(i + ", ");

        }
        System.out.println("\nNegative : ");

        for (int i = 0 ; i < listOfDoors.length ; i++) {
            if (!listOfDoors[i])
                System.out.print(i + ", ");
        }
    }
}
