package org.xander.katas;

import java.util.Comparator;
import java.util.List;

public class NaturalSort {
    private static NaturalSort naturalSort = new NaturalSort();

    public static NaturalSort getInstance() {
        return naturalSort;
    }

    public List<String> sortNaturally(List<String> listToSort) {
        Comparator<String> myNaturalSort = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };

        for (int numberOfPasses = 1; numberOfPasses < listToSort.size(); numberOfPasses++) {
            for (int i = 0; i < listToSort.size() - numberOfPasses; i++) {
                if (myNaturalSort.compare(listToSort.get(i), listToSort.get(i + 1)) > 0) {
                    String temp = listToSort.get(i);
                    listToSort.set(i, listToSort.get(i + 1));
                    listToSort.set(i + 1, temp);
                }
            }
        }
        return listToSort;
    }
}