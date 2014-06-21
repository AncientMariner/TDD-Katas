package org.xander.katas;

import java.util.Arrays;

public class OneHundredDoors {
    private boolean[] listOfDoors = new boolean[100];

    public boolean[] checkAllDoors() {
        return Arrays.copyOf(listOfDoors, listOfDoors.length);
    }

    public void go(int j) {
        for (int i = 0 ; i < listOfDoors.length ; i = i + j ) {
            listOfDoors[i] = !listOfDoors[i];
        }
    }
}
