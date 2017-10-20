package com.gandhi.dsalgos.puzzles.codility;

import java.util.Arrays;

public class CyclicRotation {

	public static void main(String[] args) {
		int[] A = { 3, 8, 9, 7, 6 };
		System.out.println(Arrays.asList(new CyclicRotation().solution(A, 3)));

	}

	public int[] solution(int[] A, int K) {
		int length = A.length;
		int[] result = new int[length];
		if(length == 0){
			return result;
		}

		int numberOfRotations = K % length;
		if (numberOfRotations == 0) {
			return A;
		}

		for (int i = 0; i < length; i++) {
			if (i + numberOfRotations < length) {
				result[i + numberOfRotations] = A[i];
			} else {
				result[(i + numberOfRotations) % length] = A[i];
			}
		}

		return result;
	}

}
