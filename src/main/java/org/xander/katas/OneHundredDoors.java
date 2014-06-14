package org.xander.katas;

public class OneHundredDoors {
    boolean[] listOfDoors = new boolean[100];

    public boolean[] checkAllDoors() {
        return listOfDoors;
    }

    public void go(int j) {
        for (int i = 0 ; i < listOfDoors.length ; i = i + j ) {
            listOfDoors[i] = !listOfDoors[i];
        }
    }
}
