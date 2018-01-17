package com.gandhi.dsalgos.linkedlist;

public class SinglyLinkedList {

	private Node head;

	private int size;

	public SinglyLinkedList() {
		head = null;
		size = 0;
	}

	public int get(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("Invalid Index");
		}

		Node node = head;
		for (int i = 0; i < index; i++) {
			node = node.getNext();
		}
		return node.getValue();
	}

	public void add(int element) {
		Node newNode = new Node(element, null);
		if (head == null) {
			head = newNode;
		} else {
			Node lastNode = head;
			while (lastNode.next != null) {
				lastNode = lastNode.next;
			}
			lastNode.next = newNode;
		}
		size++;
	}

	public Node getHead() {
		return head;
	}

	public int getSize() {
		return size;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public static class Node {
		private int value;
		private Node next;

		public Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}

}
