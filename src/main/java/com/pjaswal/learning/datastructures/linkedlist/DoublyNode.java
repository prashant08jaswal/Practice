package com.pjaswal.learning.datastructures.linkedlist;

public class DoublyNode {
	
	private int data;
	private DoublyNode next;
	private DoublyNode previous;
	
	public DoublyNode(int data, DoublyNode next, DoublyNode previous) {
		super();
		this.data = data;
		this.next = next;
		this.previous = previous;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public DoublyNode getNext() {
		return next;
	}
	public void setNext(DoublyNode next) {
		this.next = next;
	}
	public DoublyNode getPrevious() {
		return previous;
	}
	public void setPrevious(DoublyNode previous) {
		this.previous = previous;
	}
}
