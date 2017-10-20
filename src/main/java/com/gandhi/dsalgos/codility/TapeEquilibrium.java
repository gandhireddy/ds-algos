package com.gandhi.dsalgos.codility;

public class TapeEquilibrium {

	public static void main(String[] args) {
		int[] A = { 3, 1, 2, 4, 3 };
		System.out.println(new TapeEquilibrium().solution(A));
	}

	public int solution(int[] A) {
		int equilibrium = -1;
		int length = A.length;
		if (length == 0) {
			return equilibrium;
		}

		long[] sum = new long[length];
		sum[0] = A[0];
		for (int i = 1; i < length; i++) {
			sum[i] = sum[i - 1] + A[i];
		}

		// First assume the difference is minimum at index 1
		equilibrium = (int) (Math.abs(sum[0] - (sum[length - 1] - sum[0])));
		for (int i = 1; i < length - 1; i++) {
			long sumBeforeElement = sum[i];
			long sumAfterElement = sum[length - 1] - sum[i];
			long difference = Math.abs(sumBeforeElement - sumAfterElement);
			if (difference < equilibrium) {
				equilibrium = (int) difference;
			}
		}

		return equilibrium;

	}
}
