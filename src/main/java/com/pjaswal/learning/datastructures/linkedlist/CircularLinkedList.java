package com.pjaswal.learning.datastructures.linkedlist;

public class CircularLinkedList {
	
	private SinglyNode head;
	
	public void insertAtTheEnd(int data) {
		SinglyNode node = new SinglyNode(null,data);
		if(this.head == null) {
			node.setNext(node);
			this.head = node;
		}else {
			node.setNext(head.getNext());
			head.setNext(node);
			int tempData = head.getData();
			head.setData(node.getData());
			node.setData(tempData);
			this.head = node;
		}
	}
	
	public void insertAtTheBeginning(int data) {
		SinglyNode node = new SinglyNode(null,data);
		if(this.head == null) {
			this.head = node;
			this.head.setNext(this.head);
		}else {
			node.setNext(this.head.getNext());
			this.head.setNext(node);
			int tempData = this.head.getData();
			head.setData(node.getData());
			node.setData(tempData);
		}
	}
	
	public void deleteHeadOfACircularNode() {
		if(this.head!= null) {
			if(head.getNext() == this.head) {
				this.head = null;
			}else {
				SinglyNode nextDode = this.head.getNext();
				this.head.setData(nextDode.getData());
				this.head.setNext(nextDode.getNext());
			}
		}
	}
	
	public void traverseCircularList() {
		if(this.head != null) {
			SinglyNode currentNode = this.head;
			System.out.println(currentNode.getData() + " , ");
			while(currentNode.getNext() != this.head) {
				System.out.println(currentNode.getNext() + " , ");
			}
		}
	}
	
	/**
	 * k = 1 means head node to be deleted.
	 * Loop will run from 0 to k-2 because before the loop begins we have already taken currentNode as head.
	 */
	public void deleteKthNode(int k) {
		SinglyNode currentNode = this.head;
		if(currentNode != null) {
			if(k==1) {
				deleteHead();
			}else {
				for(int i = 0; i<k-2;i++) {
					currentNode=currentNode.getNext();
				}
				currentNode.setNext(currentNode.getNext().getNext());
			}
		}
	}
	
	private void deleteHead() {
		if(this.head.getNext() != null) {
			this.head = this.head.getNext();
		}else {
			this.head = null;
		}
	}

}