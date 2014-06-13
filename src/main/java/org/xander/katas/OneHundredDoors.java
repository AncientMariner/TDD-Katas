package org.xander.katas;

import java.util.ArrayList;
import java.util.List;

public class OneHundredDoors {
    List<Boolean> listOfDoors = new ArrayList<>(100);

    {
        for (int i = 0; i < 100; i++) {
            listOfDoors.add(false);
        }
    }

    public List<Boolean> checkAllDoors() {
        return listOfDoors;
    }

    public void go(int j) {
        for (int i = 0 ; i < listOfDoors.size() ; i = i + j ) {
            listOfDoors.set(i, !listOfDoors.get(i));
        }
    }
}
