package com.uchenna.listassignment;

public class SinglyLinkedList {
	public Node head;
	
	public SinglyLinkedList() {
		this.head = null;
	}
	
	public void add(int value) {
		Node newNode = new Node(value);
		
		if (this.head == null) {
			this.head = newNode;
		}
		else {
			Node runner = this.head;
			while (runner.next != null) {
				runner = runner.next;
			}
			runner.next = newNode;
		}
	}
	
	public void removeFromBack() {
		Node currentNode = this.head;
		while (currentNode.next.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = null;
		
	}
	
	public void printValues() {
		Node currentNode = this.head;
		while (currentNode != null) {
			System.out.println(currentNode.value);
			currentNode = currentNode.next;
		}
		
	}

}
