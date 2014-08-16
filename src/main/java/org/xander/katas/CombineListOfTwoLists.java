package org.xander.katas;

import java.util.ArrayList;
import java.util.List;

public class CombineListOfTwoLists {
    public boolean checkListIsSorted(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> merge(List<Integer> list1, List<Integer> list2) {

        int size1 = list1.size();
        int size2 = list2.size();

        List<Integer> mergedList = new ArrayList<>();
        for (int i = 0; i < size1 + size2; i++) {
            mergedList.add(0);
        }

        int firstPartOfSize;
        int secondPartOfSize;
        boolean firstListIsLargerThanSecond = false;

        if (size1 > size2) {
            firstPartOfSize = size2;
            secondPartOfSize = size1;
            firstListIsLargerThanSecond = true;
        } else if(size2 > size1) {
            firstPartOfSize = size1;
            secondPartOfSize = size2;
        } else {
            firstPartOfSize = secondPartOfSize = size1;
        }

        for (int i = 0, j = 0; i < firstPartOfSize; i++, j+=2) {
            if (list1.get(i) < list2.get(i)) {
                mergedList.set(j, list1.get(i));
                mergedList.set(j + 1, list2.get(i));
            } else if (list1.get(i) > list2.get(i)) {
                mergedList.set(j, list2.get(i));
                mergedList.set(j + 1, list1.get(i));
            } else {
                mergedList.set(j, list1.get(i));
                mergedList.set(j + 1, list2.get(i));

            }
        }

        for (int i = firstPartOfSize * 2, j = 0; i < firstPartOfSize + secondPartOfSize; i++, j++ ) {
            if (firstListIsLargerThanSecond) {
                mergedList.set(i, list1.get(secondPartOfSize + j));
            } else {
                mergedList.set(i, list2.get(firstPartOfSize + j));
            }
        }

        return mergedList;
    }
}
