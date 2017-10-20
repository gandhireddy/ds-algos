package com.gandhi.dsalgos.codility;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * A string S consisting of N characters is considered to be properly nested if
 * any of the following conditions is true:
 * 
 * S is empty; S has the form "(U)" or "[U]" or "{U}" where U is a properly
 * nested string; S has the form "VW" where V and W are properly nested strings.
 * For example, the string "{[()()]}" is properly nested but "([)()]" is not.
 * 
 * Write a function:
 * 
 * int solution(char *S); that, given a string S consisting of N characters,
 * returns 1 if S is properly nested and 0 otherwise.
 * 
 * For example, given S = "{[()()]}", the function should return 1 and given S =
 * "([)()]", the function should return 0, as explained above.
 * 
 * Assume that:
 * 
 * N is an integer within the range [0..200,000]; string S consists only of the
 * following characters: "(", "{", "[", "]", "}" and/or ")". Complexity:
 * 
 * expected worst-case time complexity is O(N); expected worst-case space
 * complexity is O(N) (not counting the storage required for input arguments).
 *
 * 
 */
public class Brackets {
	
	private static Map<Character, Character> map = new HashMap<>();
	
	static{
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');
	}

	public static void main(String[] args) {
		String[] array = { "((((((", ")))))))", "{[()()]}", "([)()]", "", "(", ")" };

		for (String element : array) {
			System.out.println(element + "---->" + new Brackets().solution(element));
		}

	}

	public int solution(String S) {
		if (S.length() == 0) {
			return 1;
		}

		if (S.length() == 1) {
			return 0;
		}

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < S.length(); i++) {
			char ch = S.charAt(i);
			if (map.containsKey(ch)) {
				if (stack.isEmpty()) {
					return 0;
				}
				Character pop = stack.pop();
				if (!pop.equals(map.get(ch))) {
					return 0;
				}
			} else {
				stack.add(ch);
			}
		}

		if (stack.isEmpty()) {
			return 1;
		} else {
			return 0;
		}
	}

}
