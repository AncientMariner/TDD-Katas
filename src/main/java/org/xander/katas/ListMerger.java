package org.xander.katas;

import java.util.ArrayList;
import java.util.List;

public class ListMerger {
    public boolean checkListIsSorted(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> merge(List<Integer> listOne, List<Integer> listTwo) {
        List<Integer> mergedList = new ArrayList<>();
        int sizeOne = listOne.size();
        int sizeTwo = listTwo.size();
        int i = 0;
        int j = 0;

        while (i < sizeOne && j < sizeTwo) {
            if (listOne.get(i) < listTwo.get(j)) {
                mergedList.add(listOne.get(i++));
            } else {
                mergedList.add(listTwo.get(j++));
            }
        }

        finishingMerge(listOne, mergedList, sizeOne, i);
        finishingMerge(listTwo, mergedList, sizeTwo, j);

        return mergedList;
    }

    private void finishingMerge(List<Integer> list, List<Integer> mergedList, int sizeOfTheArray, int index) {
        while (index < sizeOfTheArray) {
            mergedList.add(list.get(index++));
        }
    }
}
