package com.gandhi.dsalgos.codility;

import java.util.HashSet;
import java.util.Set;

public class OddOccurrencesInArray {

	public static void main(String[] args) {
		int[] A = { 9, 3, 9, 3, 9, 7, 9 };
		System.out.println(new OddOccurrencesInArray().solution(A));
	}

	public int solution(int[] A) {
		int length = A.length;
		if (length == 0 || length % 2 == 0) {
			return -1;
		}

		Set<Integer> odd = new HashSet<>();
		for (int element : A) {
			if (odd.contains(element)) {
				odd.remove(element);
			} else {
				odd.add(element);
			}
		}

		return odd.iterator().next();
	}

}
