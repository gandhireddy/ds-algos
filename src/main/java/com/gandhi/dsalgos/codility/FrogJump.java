package com.gandhi.dsalgos.codility;

public class FrogJump {

	public static void main(String[] args) {
		System.out.println(new FrogJump().solution(10, 85, 30));
	}

	public int solution(int X, int Y, int D) {
		if(D <= 0 || X > Y){
			return -1;
		}
		int numberOfSteps = 0;
		int difference = Y - X;
		numberOfSteps = difference / D;
		if((difference % D) > 0){
			numberOfSteps ++;
		}
		return numberOfSteps;
	}
}
