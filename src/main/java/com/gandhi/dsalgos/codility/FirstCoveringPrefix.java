package com.gandhi.dsalgos.codility;

import java.util.HashMap;
import java.util.Map;

public class FirstCoveringPrefix {

	public static void main(String[] args) {
		int[] A = {  };
		System.out.println(new FirstCoveringPrefix().solution(A));
	}

	public int solution(int[] A) {
		Map<Integer, Integer> map = new HashMap<>();
		int index = 0;
		for (int i = 0; i < A.length; i++) {
			Integer existingIndex = map.get(A[i]);
			if (existingIndex == null) {
				map.put(A[i], i);
				index = i;
			}
		}
		return index;
	}

}
