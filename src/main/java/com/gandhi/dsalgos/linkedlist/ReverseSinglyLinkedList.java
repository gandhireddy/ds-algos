package com.gandhi.dsalgos.linkedlist;

import com.gandhi.dsalgos.linkedlist.SinglyLinkedList.Node;

public class ReverseSinglyLinkedList {

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		for (int i = 0; i < list.getSize(); i++) {
			System.out.println(list.get(i));
		}

		/*
		 * System.out.
		 * println("------------------ List after reverse ----------------------------"
		 * ); reverse(list); for (int i = 0; i < list.getSize(); i++) {
		 * System.out.println(list.get(i)); }
		 */
		System.out.println("------------------ List after reverse ----------------------------");
		printInReverse(list.getHead());

	}

	private static void reverse(SinglyLinkedList list) {
		if (list.getSize() <= 1) {
			return;
		}
		Node prev = null, current = list.getHead(), next = null;
		while (current != null) {
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		list.setHead(prev);
	}

	private static void printInReverse(Node node) {
		if (node == null) {
			return;
		}
		printInReverse(node.getNext());
		System.out.println(node.getValue());
	}

}
