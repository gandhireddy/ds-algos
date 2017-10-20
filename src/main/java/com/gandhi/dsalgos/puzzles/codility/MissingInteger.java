package com.gandhi.dsalgos.puzzles.codility;

import java.util.HashSet;
import java.util.Set;

public class MissingInteger {

	public static void main(String[] args) {
		int[] A = { 1 };
		System.out.println(new MissingInteger().solution(A));
	}

	public int solution(int[] A) {
		int result = 1;
		int length = A.length;
		if (length == 0) {
			return result;
		}

		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < length; i++) {
			set.add(A[i]);
		}

		while (set.contains(result)) {
			result++;
		}
		return result;
	}

}
