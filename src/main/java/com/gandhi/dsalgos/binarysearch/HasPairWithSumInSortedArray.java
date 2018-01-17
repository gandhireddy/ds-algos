package com.gandhi.dsalgos.binarysearch;

public class HasPairWithSumInSortedArray {

	public static void main(String[] args) {

		boolean sumFound = false;
		int sumToFind = 6;
		int[] array = new int[] { 1, 2, 3, 3, 3, 6, 6 };
		int i = 0, j = array.length - 1;
		while (i < j) {
			int smallElement = array[i];
			int largeElement = array[j];
			int sum = smallElement + largeElement;
			if (sum == sumToFind) {
				sumFound = true;
				System.out.println(smallElement + "," + largeElement);
				break;
			} else if (sum > sumToFind) {
				j--;
			} else {
				i++;
			}
		}

		System.out.println(sumFound);
	}

}
