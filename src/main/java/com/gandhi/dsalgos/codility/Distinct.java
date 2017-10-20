package com.gandhi.dsalgos.codility;

import java.util.HashSet;
import java.util.Set;

public class Distinct {

	public static void main(String[] args) {
		int[] A = { 2, 1, 1, 2, 3, 1, 1 };
		System.out.println(new Distinct().solution(A));
	}

	public int solution(int[] A) {
		Set<Integer> set = new HashSet<>();
		for (int element : A) {
			set.add(element);
		}
		return set.size();
	}

}
