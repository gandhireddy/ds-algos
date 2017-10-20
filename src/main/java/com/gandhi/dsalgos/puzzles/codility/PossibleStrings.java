package com.gandhi.dsalgos.puzzles.codility;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PossibleStrings {
	
	public static void main(final String[] args) {

		final PossibleStrings possibleStrings = new PossibleStrings();
		final List<String> stringList = possibleStrings
				.getPossibleStrings("abcd");
		System.out.println(stringList.size());
		for (final String element : stringList) {
			System.out.println(element);
		}
	}

	public List<String> getPossibleStrings(final String input) {
		final List<String> stringList = new ArrayList<String>();
		final char[] inputCharArray = input.toCharArray();
		if (inputCharArray.length == 1) {
			stringList.add(input);
			return stringList;
		}
		if (inputCharArray.length == 2) {
			return reverseTwoLengthString(input);
		} else {
			for (int i = 0; i < inputCharArray.length; i++) {
				final Character startChar = input.charAt(i);
				final StringBuilder stringBuilder = new StringBuilder(input);
				final List<String> tempList = getPossibleStrings(stringBuilder
						.deleteCharAt(i).toString());
				for (final String element : tempList) {
					stringList.add(startChar + element);
				}
			}
		}
		return stringList;
	}

	public List<String> reverseTwoLengthString(final String input) {
		final List<String> strList = new ArrayList<String>();
		if (input != null && input.length() == 2) {
			strList.add(input);
			strList.add(new StringBuffer(input).reverse().toString());
		}
		return strList;
	}

}
