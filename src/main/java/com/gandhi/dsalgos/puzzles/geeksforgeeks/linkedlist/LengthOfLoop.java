package com.gandhi.dsalgos.puzzles.geeksforgeeks.linkedlist;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * http://practice.geeksforgeeks.org/problems/find-length-of-loop/1
 */
public class LengthOfLoop {

    public static void main(String[] args) {

        List<String> list = new LinkedList<>();
        list.add("abc");

    }


    private static boolean checkForExistenceOfLoop(LinkedList<String> list) {
        boolean loopExists = false;
        if (list != null && !list.isEmpty()) {
            int position_1 = 0, position_2 = 0;
            ListIterator<String> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                listIterator.next();
                position_1 = position_1 + 1;
                position_2 = position_2 + 2;
                if (list.get(position_1) == list.get(position_2)) {
                    loopExists = true;
                    break;
                }
            }
        }
        return loopExists;
    }
}


