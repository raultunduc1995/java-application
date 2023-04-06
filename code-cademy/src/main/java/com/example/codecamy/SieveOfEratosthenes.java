package com.example.codecamy;

import java.util.ArrayList;
import java.util.List;

// BigO: O(n*log(log n))
public class SieveOfEratosthenes {
    public static void main(String[] args) {
        int n = 70;
        SieveOfEratosthenes g = new SieveOfEratosthenes();
        g.sieveOfEratosthenes(n);
        // should return [2, 3, 5, 7]
    }

    void sieveOfEratosthenes(int limit) {
        List<Boolean> outputList = createIntermediateList(limit);
        markAllNonPrimeNumbers(limit, outputList);
        List<Integer> resultList = new ArrayList<>();
        findTrueIndices(outputList, resultList);
        System.out.println(resultList);
    }

    private List<Boolean> createIntermediateList(int limit) {
        List<Boolean> outputList = new ArrayList<>(limit + 1);
        outputList.add(false);
        outputList.add(false);
        outputList.add(true);
        for (int i = 3; i <= limit; i++)
            outputList.add(i % 2 != 0);
        return outputList;
    }

    private void markAllNonPrimeNumbers(int limit, List<Boolean> outputList) {
        int sqrtLimit = (int) Math.sqrt(limit);
        int i = 2;
        while (i <= sqrtLimit) {
            for (int j = i * i; j <= limit; j += i)
                outputList.set(j, false);
            i++;
            while (i <= sqrtLimit && !outputList.get(i)) i++;
        }
    }

    private void findTrueIndices(List<Boolean> outputList, List<Integer> resultList) {
        for (int i = 0; i < outputList.size(); i++)
            if (outputList.get(i))
                resultList.add(i);
    }
}
