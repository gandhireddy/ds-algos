package com.gandhi.dsalgos.puzzles.codility;

public class BinaryGap {
	
	public static void main(String[] args) {
		System.out.println(new BinaryGap().solution(561892));
	}

	public int solution(int N) {
		
		if (N <= 0) {
			return 0;
		}

		int binaryGap = 0;
		int temp = N;
		int tempCount = 0;
		boolean startDetected = false;
		while (temp > 0) {
			int bit = temp % 2;
			if (bit == 0) {
				if (startDetected) {
					tempCount++;
				}
			} else {
				if (startDetected) {
					if (tempCount > binaryGap) {
						binaryGap = tempCount;
					}
					tempCount = 0;
				} else {
					startDetected = true;
				}
			}
			temp = temp / 2;
		}

		return binaryGap;
	}

}
