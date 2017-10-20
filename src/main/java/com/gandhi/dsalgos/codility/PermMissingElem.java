package com.gandhi.dsalgos.codility;

public class PermMissingElem {

	public static void main(String[] args) {
		int[] A = { 2, 3, 1, 5 };
		System.out.println(new PermMissingElem().solution(A));
	}

	public int solution(int[] A) {
		int length = A.length;
		if (length == 0) {
			return 1;
		}

		int missingElement = 0;
		long actualSum = (((long) length + 1) * ((long) length + 2)) / 2;
		long sum = 0;
		for (int element : A) {
			sum = sum + element;
		}
		missingElement = (int) (actualSum - sum);
		return missingElement;
	}

}
