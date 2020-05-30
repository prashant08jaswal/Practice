package com.pshat.learning.datastructures.linkedlist;

public class SinglyNode {
	
	private SinglyNode next;
	
	private SinglyNode random;
	
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
	
	public SinglyNode getRandom() {
		return random;
	}

	public void setRandom(SinglyNode random) {
		this.random = random;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
	
}
