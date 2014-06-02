package org.xander.katas;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NaturalSort {
    public List<String> sortForNumbers(List<String> unsortedList) {

//        sortNaturally(unsortedList);
        Collections.sort(unsortedList);

        return unsortedList;
    }

    private void sortNaturally(List<String> unsortedList) {
        for (String element : unsortedList) {
//            Comparator
        }
    }


}

class Order implements Comparator<Order> {
    String value;


    @Override
    public int compare(Order o1, Order o2) {
//        return o1.value > o2.value;
        return 0;
    }
}
