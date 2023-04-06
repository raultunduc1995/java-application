package com.example.codecamy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTrueIndices {
    public static void main(String[] args) {
        FindTrueIndices myFindTrueIndices = new FindTrueIndices();
        boolean[] testValues = {false, false, true, true, false, true, false, true};
        myFindTrueIndices.findTrueIndices(testValues);
    }

    void findTrueIndices(boolean[] arr) {
        // create `result` ArrayList
        List<Integer> result = new ArrayList<>();

        // use for-loop to add index of `arr` elements to `result` that are `true` by calling `add()` method
        for (int i = 0; i < arr.length; i++) {
            if (arr[i])
                result.add(i);
        }

        // Print `result`
        System.out.println(Arrays.toString(result.toArray()));
    }
}
