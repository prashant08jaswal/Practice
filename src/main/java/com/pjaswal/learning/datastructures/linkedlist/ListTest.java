package com.pjaswal.learning.datastructures.linkedlist;

public class ListTest {

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.insert(10);
		list.insert(20);
		list.insert(30);
		list.insert(40);
		list.insert(50);
		list.insert(60);
		list.rotate(3);
		list.printAll();
	}
	
}
