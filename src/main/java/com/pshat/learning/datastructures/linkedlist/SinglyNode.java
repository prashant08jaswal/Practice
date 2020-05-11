package com.pshat.learning.datastructures.linkedlist;

public class SinglyNode {
	
	private SinglyNode next;
	
	public SinglyNode() {}
		
	public SinglyNode(SinglyNode next, int data) {
		super();
		this.next = next;
		this.data = data;
	}

	private int data;

	public SinglyNode getNext() {
		return next;
	}

	public void setNext(SinglyNode next) {
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
	
}
