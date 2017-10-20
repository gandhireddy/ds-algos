package com.gandhi.dsalgos.sort;

public class SelectionSort {

    public int[] selectionSort(int[] input) {
        for (int i = 0; i < input.length; i++) {
            int indexOfMinElement = i;
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] < input[indexOfMinElement]) {
                    indexOfMinElement = j;
                }
            }

            if (i != indexOfMinElement) {
                //swap minimum value with the value at 'i'
                int temp = input[i];
                input[i] = input[indexOfMinElement];
                input[indexOfMinElement] = temp;
            }
        }
        return input;
    }
}
