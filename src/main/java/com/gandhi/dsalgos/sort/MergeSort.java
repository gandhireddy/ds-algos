package com.gandhi.dsalgos.sort;

public class MergeSort {
	
	public static void main(String[] args) {
		int[] input = new int[] { 2, 5, 7, 4, 3, 10, 15, 5, 6, };
		new MergeSort().sort(input);
		for(int value : input){
			System.out.println(value);
		}
	}

	public void sort(int[] input) {
		int length = input.length;
		if (length < 2) {
			return;
		}
		int mid = length / 2;
		int[] left = new int[mid];
		int[] right = new int[length - mid];

		for (int i = 0; i < mid; i++) {
			left[i] = input[i];
		}

		for (int i = mid; i < length; i++) {
			right[i-mid] = input[i];
		}
		
		sort(left);
		sort(right);
		merge(input, left, right);
	}

	private void merge(int[] array, int[] left, int[] right) {
		int i = 0, j = 0, k = 0;
		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				array[k] = left[i];
				i++;
			} else {
				array[k] = right[j];
				j++;
			}
			k++;
		}

		while (i < left.length) {
			array[k] = left[i];
			i++;
			k++;
		}
		while (j < right.length) {
			array[k] = right[j];
			j++;
			k++;
		}
	}

}
