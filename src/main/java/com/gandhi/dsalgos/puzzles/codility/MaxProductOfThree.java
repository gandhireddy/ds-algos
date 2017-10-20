package com.gandhi.dsalgos.puzzles.codility;

import java.util.Arrays;

/**
 * A non-empty zero-indexed array A consisting of N integers is given. The
 * product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R <
 * N).
 * 
 * For example, array A such that:
 * 
 * A[0] = -3 A[1] = 1 A[2] = 2 A[3] = -2 A[4] = 5 A[5] = 6
 * 
 * contains the following example triplets:
 * 
 * (0, 1, 2), product is −3 * 1 * 2 = −6
 * 
 * (1, 2, 4), product is 1 * 2 * 5 = 10
 * 
 * (2, 4, 5), product is 2 * 5 * 6 = 60
 * 
 * Your goal is to find the maximal product of any triplet.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); } that, given a non-empty
 * zero-indexed array A, returns the value of the maximal product of any
 * triplet.
 * 
 * For example, given array A such that:
 * 
 * A[0] = -3 A[1] = 1 A[2] = 2 A[3] = -2 A[4] = 5 A[5] = 6 the function should
 * return 60, as the product of triplet (2, 4, 5) is maximal.
 * 
 * Assume that:
 * 
 * N is an integer within the range [3..100,000]; each element of array A is an
 * integer within the range [−1,000..1,000]. Complexity:
 * 
 * expected worst-case time complexity is O(N*log(N)); expected worst-case space
 * complexity is O(1), beyond input storage (not counting the storage required
 * for input arguments). Elements of input arrays can be modified.
 * 
 * 
 *
 */
public class MaxProductOfThree {

	public static void main(String[] args) {
		int[] A = { -2, -1, 0, 100, 50 };
		// -3, 1, 2, -2, 5, 6
		// -1000, -1000, 0, 1, 1000
		// -1000, -99, -1, 0
		// -2, -1, 0, 100, 50
		System.out.println(new MaxProductOfThree().solution(A));
	}

	public int solution(int[] A) {

		int length = A.length;
		Arrays.sort(A);

		if (A[length - 1] == 0) { // All Negative number with '0' as highest
			return 0;
		}

		if (A[0] >= 0 || A[length - 1] < 0) { // All negative or all positive
			return A[length - 1] * A[length - 2] * A[length - 3];
		}

		if (A[0] * A[1] >= 0) {
			if (A[length - 3] <= 0) {
				return A[0] * A[1] * A[length - 1];
			} else {
				return Math.max(A[0] * A[1] * A[length - 1], A[length - 1] * A[length - 2] * A[length - 3]);
			}
		} else {
			return A[length - 1] * A[length - 2] * A[length - 3];
		}
	}

}
