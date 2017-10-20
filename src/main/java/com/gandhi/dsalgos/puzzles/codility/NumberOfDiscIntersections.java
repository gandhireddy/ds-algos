package com.gandhi.dsalgos.puzzles.codility;

public class NumberOfDiscIntersections {

	public static void main(String[] args) {
		int[] A = { 1, 5, 2, 1, 4, 0 };
		System.out.println(new NumberOfDiscIntersections().solution(A));
	}

	public int solution(int[] A) {
		int numberOfIntersections = 0;
		int length = A.length;
		if(length == 0){
			return numberOfIntersections;
		}

		long[] min = new long[length];
		long[] max = new long[length];
		min[0] = 0 - (long) A[0];
		max[0] = 0 + (long) A[0];
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				if (i == 0) {
					min[j] = j - (long) A[j];
					max[j] = j + (long) A[j];
				}
				if (!((min[i] > min[j] && min[i] > max[j]) || (max[i] < min[j] && max[i] < max[j]))) {
					numberOfIntersections++;
					if(numberOfIntersections > 10E6){
						return -1;
					}
				}
			}
		}

		return numberOfIntersections;
	}
}
