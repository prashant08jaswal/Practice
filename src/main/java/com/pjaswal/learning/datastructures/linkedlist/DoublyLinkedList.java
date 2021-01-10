package com.pjaswal.learning.datastructures.linkedlist;

public class DoublyLinkedList {
	private DoublyNode headNode;
	
	public void insertAtBeginning(int data) {
		DoublyNode node = new DoublyNode(data, null, null);
		node.setNext(this.headNode);
		this.headNode = node;
	}
	
	public void insertAtEnd(int data) {
		DoublyNode node = new DoublyNode(data,null,null);
		if(this.headNode == null) {
			this.headNode = node;
		}else {
			DoublyNode currentNode = this.headNode;
			while(currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(node);
			node.setPrevious(currentNode);
		}
	}
	
	public void reverseList() {
		if(this.headNode != null || this.headNode.getNext() != null) {
			DoublyNode current = this.headNode;
			DoublyNode previous = null;
			DoublyNode next = null;
			while(current != null) {
				previous = current.getPrevious();
				next = current.getNext();
				current.setPrevious(next);
				current.setNext(previous);
				current = next;
			}
			this.headNode = previous.getPrevious();
		}
	}
	
	public int reverseListRecursively(DoublyNode currentNode) {
		if(currentNode==null) {
			return -1;
		}
		DoublyNode next = currentNode.getNext();
		DoublyNode previous = currentNode.getPrevious();
		int result =  reverseListRecursively(next);
		currentNode.setNext(previous);
		currentNode.setPrevious(next);
		if(result < 0)
			this.headNode = currentNode;
		return 0;
	}
	
	public void printAll() {
		DoublyNode currentNode = this.headNode;
		while(currentNode != null) {
			System.out.println(currentNode.getData() + " , ");
			currentNode = currentNode.getNext();
		}
	}
	
	public void deleteLast() {
		if(this.headNode!= null) {
			DoublyNode currentNode = this.headNode;
			if(currentNode.getNext() == null)
				this.headNode = null;
			else {
				while(currentNode.getNext() != null) {
					currentNode = currentNode.getNext();
				}
				currentNode.getPrevious().setNext(null);
			}
		}
	}
	
	public DoublyNode getHeadNode() {
		return headNode;
	}
}
