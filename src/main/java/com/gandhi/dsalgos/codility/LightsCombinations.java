package com.gandhi.dsalgos.codility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LightsCombinations {

	List<String> validCombination = new ArrayList<>();

	Map<String, Boolean> verifiedMap = new HashMap<>();

	public static void main(final String[] args) {

		System.out.println(new LightsCombinations().solution("02002"));
		//System.out.println(new LightsCombinations().solution("02002345546"));
		/*
		 * LightsCombinations combinations = new LightsCombinations(); final
		 * List<String> stringList = combinations.getPossibleStrings("abcd");
		 * System.out.println(stringList.size()); for (final String element :
		 * stringList) { System.out.println(element); }
		 */
	}

	public int solution(String input) {
		for (int length = 1; length < input.length(); length++) {
			for (int startPoition = 0; startPoition + length <= input.length(); startPoition++) {
				String value = input.substring(startPoition, startPoition + length);
				//
				if (length == 1) {
					validCombination.add(value);
					continue;
				}

				// If a string is already verified, don't perform any
				// operations. just add
				if (validCombination.contains(value) || isPalindrome(value)) {
					validCombination.add(value);
					continue;
				}

				

				if (length >= 3) {
					for (String string : verifiedMap.keySet()) {
						if(getVerifiedKey(string, value) && verifiedMap.get(string)){
							validCombination.add(value);
						}
					}
					boolean valid = false;
					List<String> possibleStrings = getPossibleStrings(value);
					for (String string : possibleStrings) {
						if (isPalindrome(string)) {
							validCombination.add(value);
							valid = true;
							break;
						}
					}
					verifiedMap.put(value, valid);
				}

			}
		}

		List<String> possibleStrings = getPossibleStrings(input);
		for (String string : possibleStrings) {
			if (isPalindrome(string)) {
				validCombination.add(input);
				break;
			}
		}

		System.out.println(validCombination);
		return validCombination.size();
	}

	private boolean getVerifiedKey(String key, String input) {
		if (key.length() == input.length()) {
			return (key.replaceAll("[^1]", "").length() == key.replaceAll("[^1]", "").length())
					&& (key.replaceAll("[^2]", "").length() == key.replaceAll("[^2]", "").length())
					&& (key.replaceAll("[^3]", "").length() == key.replaceAll("[^3]", "").length())
					&& (key.replaceAll("[^4]", "").length() == key.replaceAll("[^4]", "").length())
					&& (key.replaceAll("[^5]", "").length() == key.replaceAll("[^5]", "").length())
					&& (key.replaceAll("[^6]", "").length() == key.replaceAll("[^6]", "").length())
					&& (key.replaceAll("[^7]", "").length() == key.replaceAll("[^7]", "").length())
					&& (key.replaceAll("[^8]", "").length() == key.replaceAll("[^8]", "").length())
					&& (key.replaceAll("[^9]", "").length() == key.replaceAll("[^9]", "").length())
					&& (key.replaceAll("[^0]", "").length() == key.replaceAll("[^0]", "").length());

		}

		return false;
	}

	private boolean isPalindrome(String input) {
		final StringBuilder reverseString = new StringBuilder();
		for (int i = input.length() - 1; i >= 0; i--) {
			reverseString.append(input.charAt(i));
		}
		return input.equals(reverseString.toString());
	}

	private List<String> getPossibleStrings(final String input) {
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
				final List<String> tempList = getPossibleStrings(stringBuilder.deleteCharAt(i).toString());
				for (final String element : tempList) {
					stringList.add(startChar + element);
				}
			}
		}
		return stringList;
	}

	private List<String> reverseTwoLengthString(final String input) {
		final List<String> strList = new ArrayList<String>();
		if (input != null && input.length() == 2) {
			strList.add(input);
			strList.add(new StringBuffer(input).reverse().toString());
		}
		return strList;
	}

}
