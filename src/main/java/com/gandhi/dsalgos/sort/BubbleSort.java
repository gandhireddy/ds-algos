package com.gandhi.dsalgos.sort;

public class BubbleSort {

    public int[] sort(int[] input) {
        for (int i = 1; i < input.length; i++) {
            // If there are no swaps in one iteration, it means the list is already sorted.
            // No need to iterate over from there.
            boolean sorted = true;
            for (int j = 0; j < input.length - i; j++) {
                if (input[j] > input[j + 1]) {
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                    sorted = false;
                }
            }
            if(sorted){
                return  input;
            }
        }
        return input;
    }
}
