package com.gandhi.dsalgos.codility;

import java.util.HashSet;
import java.util.Set;

public class PermCheck {

	public static void main(String[] args) {
		int[] A = { 1, 1 };
		System.out.println(new PermCheck().solution(A));
	}

	public int solution(int[] A) {
		int length = A.length;
		if (length == 0) {
			return 0;
		}

		int max = A[0];
		for (int element : A) {
			if (element > max) {
				max = element;
			}
		}

		if (length != max) {
			return 0;
		}

		Set<Integer> set = new HashSet<>();
		for (int i = 1; i <= max; i++) {
			set.add(i);
		}

		for (int i = 0; i < length; i++) {
			set.remove(A[i]);
		}

		return set.isEmpty() ? 1 : 0;
	}

}
