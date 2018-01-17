package com.gandhi.dsalgos.binarysearch;

public class FirstAndLastOccurance {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3, 3, 3, 5, 6 };
		//System.out.println(occuranceIndex(array, 3, true));
		//System.out.println(occuranceIndex(array, 3, false));
		System.out.println(count(array, 3));
	}

	public static int count(int[] array, int element) {
		int firstOccurance = occuranceIndex(array, element, true);
		if (firstOccurance == -1) {
			return -1;
		}
		int lastOccurance = occuranceIndex(array, element, false);
		return (lastOccurance - firstOccurance + 1);

	}

	public static int occuranceIndex(int[] array, int element, boolean isFirstOccurance) {
		if (element < array[0] || element > array[array.length - 1]) {
			return -1;
		}
		int start = 0, end = array.length - 1, index = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (array[mid] == element) {
				index = mid;
				if (isFirstOccurance) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else if (element > array[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return index;
	}

}
