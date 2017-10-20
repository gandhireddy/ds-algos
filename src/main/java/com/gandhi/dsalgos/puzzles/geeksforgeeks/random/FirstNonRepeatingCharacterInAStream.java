package com.gandhi.dsalgos.puzzles.geeksforgeeks.random;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * http://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream/0
 */
public class FirstNonRepeatingCharacterInAStream {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalTests = scanner.nextInt();
        for (int j = 0; j < totalTests; j++) {
            int numberOfChars = scanner.nextInt();
            Set<Character> existingCharSet = new HashSet<>();
            for (int i = 0; i < numberOfChars; i++) {
                char nextChar = scanner.next().charAt(0);
                if (existingCharSet.contains(nextChar)) {
                    System.out.print(-1 + " ");
                } else {
                    System.out.print(nextChar + " ");
                }
                existingCharSet.add(nextChar);
            }
            System.out.println();
        }
    }


    private static void printNonRepeatingCharacters(String input) {
        int size = input.length();
        System.out.println(size);
        char[] characters = input.toCharArray();

        Set<Character> existingCharSet = new HashSet<>();
        for (int i = 0; i < size; i++) {
            if (existingCharSet.contains(characters[i])) {
                System.out.println(-1);
            } else {
                System.out.println(characters[i]);
            }
            existingCharSet.add(characters[i]);
        }
    }
}
