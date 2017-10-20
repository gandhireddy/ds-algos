package com.gandhi.dsalgos.puzzles.codility;

public class Equilibrium {

	public int solution(int[] A) {
		int equilibriumIndex = -1;
		int length = A.length;
		if (length == 0) {
			return equilibriumIndex;
		}

		long[] sum = new long[length];
		sum[0] = A[0];
		for (int i = 1; i < length; i++) {
			sum[i] = sum[i - 1] + A[i];
		}

		for (int i = 0; i < length; i++) {
			long sumBefore = sum[i] - A[i];
			long sumAfter = sum[length - 1] - sum[i];
			if (sumBefore == sumAfter) {
				equilibriumIndex = i;
				break;
			}
		}

		return equilibriumIndex;
	}

}
