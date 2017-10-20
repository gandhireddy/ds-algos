package com.gandhi.dsalgos.puzzles.codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenomicRangeQuery {

	public static void main(String[] args) {

		int[] P = { 0, 0, 1 };
		int[] Q = { 0, 1, 1 };
		int[] solution = new GenomicRangeQuery().solution("AC", P, Q);

		/*
		 * int[] P = { 2, 5, 0 }; int[] Q = { 4, 5, 6 }; int[] solution = new
		 * GenomicRangeQuery().solution("CAGCCTA", P, Q);
		 */

		for (int element : solution) {
			System.out.println(element);
		}
	}

	public int[] solution(String S, int[] P, int[] Q) {
		int[] result = new int[P.length];

		if (P.length == Q.length) {
			List<Integer> A = new ArrayList<>(Arrays.asList(0));
			List<Integer> C = new ArrayList<>(Arrays.asList(0));
			List<Integer> G = new ArrayList<>(Arrays.asList(0));

			for (int i = 0; i < S.length(); i++) {
				if (S.charAt(i) == 'A') {
					A.add(i + 1, A.get(i) + 1);
					C.add(i + 1, C.get(i));
					G.add(i + 1, G.get(i));
				} else if (S.charAt(i) == 'C') {
					A.add(i + 1, A.get(i));
					C.add(i + 1, C.get(i) + 1);
					G.add(i + 1, G.get(i));
				} else if (S.charAt(i) == 'G') {
					A.add(i + 1, A.get(i));
					C.add(i + 1, C.get(i));
					G.add(i + 1, G.get(i) + 1);
				} else {
					A.add(i + 1, A.get(i));
					C.add(i + 1, C.get(i));
					G.add(i + 1, G.get(i));
				}
			}

			for (int i = 0; i < P.length; i++) {
				if (P[i] == Q[i]) {
					if (S.charAt(P[i]) == 'A') {
						result[i] = 1;
					} else if (S.charAt(P[i]) == 'C') {
						result[i] = 2;
					} else if (S.charAt(P[i]) == 'G') {
						result[i] = 3;
					} else {
						result[i] = 4;
					}
					continue;
				}

				if ((A.get(Q[i] + 1) - A.get(P[i])) > 0) {
					result[i] = 1;
				} else if ((C.get(Q[i] + 1) - C.get(P[i])) > 0) {
					result[i] = 2;
				} else if ((G.get(Q[i] + 1) - G.get(P[i])) > 0) {
					result[i] = 3;
				} else {
					result[i] = 4;
				}
			}

		}
		return result;
	}

	/**
	 * The sums you need to keep are how many times each letter has appeared.
	 * You need to keep one sum sequence for each letter. (In actuality you
	 * don't need a prefix sum for T because if A, C, or G does not appear, you
	 * can assume T. Explained in more detail in the example below.)
	 * 
	 * So, for the example in the problem statement, CAGCCTA, you end up with
	 * three prefix sum arrays that have the following values:
	 * 
	 * A: 0 1 1 1 1 1 2
	 * 
	 * C: 1 1 1 2 3 3 3
	 * 
	 * G: 0 0 1 1 1 1 1
	 * 
	 * Look at the A prefix sum array. The value in each position corresponds to
	 * how many times that letter has appeared so far. So, for position 0, A has
	 * not appeared yet, C has appeared once, and G has not appeared yet. At
	 * position 5, A has appeared once (and we can see from the prefix sum for A
	 * that it first appeared at position 1), C has appeared three times, and G
	 * has appeared once.
	 * 
	 * With these arrays, we can now determine whether a given letter appeared
	 * or not between any two positions. So, we check A first, then C, and then
	 * G. If none of them appeared then we know that only T appeared, which is
	 * the reason we do not need a prefix sum to count the T occurrences.
	 * 
	 * For example, consider the range 2 to 4 as in the problem statement. We
	 * can see from the sums for A that a single A has already appeared when the
	 * range starts, and only a single A has appeared at the end of the range.
	 * Thus, there could not have been an A in 2 to 4. Now we check C. At the
	 * start of the range there has been a single C appear, but at the end of
	 * the range there have been three. Thus, there must have been at least one
	 * C from 2 to 4, and we can conclude that the minimal impact factor for 2
	 * to 4 is 2.
	 */

}
