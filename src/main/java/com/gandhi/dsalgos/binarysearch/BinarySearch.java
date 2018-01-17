package com.gandhi.dsalgos.binarysearch;

public class BinarySearch {

	public static void main(String[] args) {
		System.out.println(searchByIteration(new int[] { 1, 2, 3, 3, 3, 5, 6 }, 4));
		System.out.println(searchByRecursion(new int[] { 1, 2, 3, 3, 3, 5, 6 }, 0, 6, 4));
	}

	static int searchByIteration(int[] array, int element) {
		if (element < array[0] || element > array[array.length - 1]) {
			return -1;
		}
		int start = 0, end = array.length - 1;
		while (start <= end) {
			// This expression can also be written as (start + end) / 2.
			// But in rare scenarios, (start + end) might overflow the capacity
			// of integer. Hence refactored the expression.
			int mid = start + (end - start) / 2;
			if (array[mid] == element) {
				return mid;
			} else if (element < array[mid]) {
				end = mid - 1;
			} else if (element > array[mid]) {
				start = mid + 1;
			}
		}
		return -1;
	}

	static int searchByRecursion(int[] array, int start, int end, int element) {
		if (start > end || element < array[0] || element > array[array.length - 1]) {
			return -1;
		}
		// This expression can also be written as (start + end) / 2.
		// But in rare scenarios, (start + end) might overflow the capacity
		// of integer. Hence refactored the expression.
		int mid = start + (end - start) / 2;
		if (array[mid] == element) {
			return mid;
		} else if (element < array[mid]) {
			return searchByRecursion(array, start, mid - 1, element);
		} else if (element > array[mid]) {
			return searchByRecursion(array, mid + 1, end, element);
		}
		return -1;
	}

}
