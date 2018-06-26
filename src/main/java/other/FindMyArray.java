package other;

public class FindMyArray implements FindArray {
    @Override
    public int findArray(int[] array, int[] subArray) {
        if (array == null
                || subArray == null
                || array.length < subArray.length) {
            return -1;
        }
        int startingIndex = -1;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < subArray.length; j++) {
                if (array[i] == subArray[j]) {
                    if (startingIndex == -1) {
                        startingIndex = i;
                        break;
                    }

                    //no need to check leftovers because starting index is not found going to the next i
//                    if (j > 0 && startingIndex == -1) {
//                        break;s such as 'printResu
//                    }s such as 'printResu



                    //element found and going to the last one
//                    if (array.length - i <= subArray.length
//                            && i - startingIndex > 1
//                            ) {
//                        startingIndex = i;
//                    }

                    //element found second time
                   // if (startingIndex >= 0) {
                        if (array.length - i >= subArray.length) {
                            if (i - startingIndex > 1 && j == 0) {
                                startingIndex = i;
                            }
                        }
                  //  }
                }


                //length is similar or leftover length is similar and we skip one element- no way to find
                if (array.length - i < j && array[i] != subArray[j]) {
                    return -1;
                }
//                if (startingIndex >= 0  // if j == 1 and index not found next i
//                        && array[i + j] == subArray[j]) {
//                    if (i + j - startingIndex >= 1) {
//                        startingIndex = i + j;
//                    }
//                }
            }
        }
        return startingIndex;
    }
}
