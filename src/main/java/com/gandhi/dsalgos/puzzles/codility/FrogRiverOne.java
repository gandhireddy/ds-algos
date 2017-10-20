package com.gandhi.dsalgos.puzzles.codility;

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {

	public static void main(String[] args) {
		int[] A = { 1 };
		System.out.println(new FrogRiverOne().solution(1, A));
	}

	public int solution(int X, int[] A) {
		int position = -1;
		int length = A.length;
		if (length == 0 || X == 0 | length < X) {
			return position;
		}

		Set<Integer> set = new HashSet<>();
		for (int i = 1; i <= X; i++) {
			set.add(i);
		}
		
		for (int i = 0; i < length; i++) {
			set.remove(A[i]);
			if (set.isEmpty()) {
				position = i;
				break;
			}
		}
		return position;
	}

}
