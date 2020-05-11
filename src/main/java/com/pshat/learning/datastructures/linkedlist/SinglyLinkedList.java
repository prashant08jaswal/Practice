package com.pshat.learning.datastructures.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * Following are the usescases or tricky interview questions has been implemented in this class
 * 1 Insertion - insert()
 * 2 print - printAll()
 * 3 delete - delete()
 * 4 print middle element - printMiddleElement()
 * 5 merge two sorted list - mergeTwoSortedList()
 * 6 delete an element from the list, in O(1) time. element won't be the last element(tricky question) - deleteNonLastElement()
 * 7 Assuming the list contains the integer data, print the list even and odd. even will comes first - printListEvenAndOdd()
 * 8 Print nth node from end of linked list - printNthNodeFromTheEnd()
 */
public class SinglyLinkedList {
	
	private SinglyNode headNode;
	
	/**
	 * Approach
	 * 1. If the headNode is null, means the list is empty, we will set the headNode.
	 * 2  else we will traverse the list, till we find the last element, and then we will  
	 */
	public void insert(int data) {
		if(this.headNode == null) {
			this.headNode = new SinglyNode(null,data);
		}else {
			SinglyNode insertAfter = this.headNode;
			while(insertAfter.getNext() != null) {
				insertAfter = insertAfter.getNext();
			}
			SinglyNode newNode = new SinglyNode(null,data);
			insertAfter.setNext(newNode);
		}
	}
	
	/**
	 * Print all the elements of the list.
	 */
	public void printAll() {
		if(this.headNode != null) {
			SinglyNode node = this.headNode;
			while(node != null) {
				System.out.println(node.getData());
				node = node.getNext();
			}
		}else {
			System.out.println("Empty List");
		}
	}
	
	/**
	 * Approach
	 * 1. Here we will take the data , that needs to be removed along with the removeAllOccurrence flag, if the flag is true, all the occurrences will be removed else the first node
	 * 		that matches the data will be removed.
	 * 2. We will iterate the list till we find the element that we wants to remove. After finding it, we will store the previousNode of nodeTobeDeleted in temp variable and we will just change
	 * 		the next of the previousNode to the nodeToBeDeleted.next.
	 */
	public void delete(int data,boolean removeAllOccurrence) {
		SinglyNode prevNode = null;
		SinglyNode currentNode = this.headNode;
		while(currentNode != null) {
			if(currentNode.getData() == data) {
				SinglyNode nextNode = currentNode.getNext();
				if(prevNode == null && nextNode != null) {
					this.headNode = nextNode;
				}else {
					prevNode.setNext(nextNode);
				}
				if(!removeAllOccurrence) {
					break;
				}
			}
				prevNode = currentNode;
				currentNode = currentNode.getNext();
		}
	}
	
	
	/**
	 * Approach
	 * In order to print the middle node in one traversal, we will take 2 pointer approach that is slow and fast, slow will move 1 node while fast will move 2 nodes concurrently.
	 * When the fast will reach the end of the list, slow will be at the middle.
	 */
	public void printMiddleElement() {
		SinglyNode slow = this.headNode;
		SinglyNode fast = this.headNode;
		while(fast!= null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		if(slow!= null)
			System.out.println(slow.getData());
		else
			System.out.println("Empty List");
	}
	
	/**
	 * Approach 
	 * 1. we will check for both lists, if they are null or not, if even 1 list is null, then we are not supposed to merge any list, hence we will return the other node.
	 * 2. we will compare the headnode of listA,listB. node whose value is smaller will be made head, we will also use a tail pointer,which will be used as a pointer,after which the next
	 * 	  element will come. tailpointer will be firstly initialized same as head.
	 * 3. Now we will run a while loop till both the listA and listB are not null. even if one is null, we will exit the loop.
	 * 		under loop we will compare the listA and listB current value, if a < b, a will be set as tail, and we will change reference of listA to listA.getNext(), same will be repeated
	 * 		for listB node, if it is smaller then a.
	 * 4. As a last corner case, we have to assume that there can be a possibility that when the loop was exited, one of the list was not null. so we will check if listA was null, we will 
	 * 		set the tailNode as listB else listA. 
	 */
	public static SinglyNode mergeTwoSortedList(SinglyNode listA,SinglyNode listB) {
		SinglyNode head = null;
		if(listA == null)
			head = listB;
		else if(listB == null)
			head = listA;
		else {
			SinglyNode tailNode = null;
			//Setting of head and tail pointer
			if(listA.getData() <= listB.getData()) {
				tailNode = listA;
				head = tailNode;
				listA = listA.getNext();
			}
			else {
				tailNode = listB;
				head = tailNode;
				listB = listB.getNext();
			}				
			while(listA != null && listB != null) {
				if(listA.getData() <= listB.getData()) {
					tailNode.setNext(listA);
					tailNode = listA;
					listA = listA.getNext();
				}else {
					tailNode.setNext(listB);
					tailNode = listB;
					listB = listB.getNext();
				}
			}
			if(listA == null) 
				tailNode.setNext(listB);
			else
				tailNode.setNext(listA);
			
		}
		return head;
	}
	
	/**
	 * Approach
	 * Assumption here is that the element that will be deleted should not be last.
	 * This operation will be performed in O(1) when the pointer is given.
	 * We will copy the data from nodeToBeDeleted + 1 to the nodeToBeDeleted.
	 */
	public static void deleteNonLastElement(SinglyNode nodeToBeDeleted) {
		SinglyNode nextNode = nodeToBeDeleted.getNext();
		nodeToBeDeleted.setData(nextNode.getData());
		nodeToBeDeleted.setNext(nextNode.getNext());
	}
	
	/**
	 * Approach
	 * 1 we will take 4 pointer here, evenStart,evenEnd,oddStart,oddNode.
	 * 2 when the data will be even for the first time, we will put it in the evenStartNode, and evenEndNode will refer to the evenStartNode, next time when the even data
	 * 	  will be there, we will take a temp previousNode where we will store the evenEndNode, now we will create a new node, and it will be referred by evenStartNode,
	 * 	  now previousNode next will be the evenEndNode,
	 * 3 we will repeat the step for odd like step 2, only we will be using the references of oddStartNode and oddEndNode.
	 * 4 once the list is traversed, we will set the evenEndNode next to be oddStartNode.
	 */
	public void printListEvenAndOdd() {
		SinglyNode evenStartNode = null;
		SinglyNode evenEndNode = null;
		SinglyNode oddStartNode = null;
		SinglyNode oddEndNode = null;
		
		SinglyNode currentNode = this.headNode;
		while(currentNode != null) {
			int data = currentNode.getData();
			if(data % 2 == 0) {
				if(evenStartNode == null) {
					evenStartNode = new SinglyNode();
					evenStartNode.setData(data);
					evenEndNode = evenStartNode;
				}else {
					SinglyNode previousNode = evenEndNode;
					evenEndNode = new SinglyNode();
					evenEndNode.setData(data);
					previousNode.setNext(evenEndNode);
				}
			}else {
				if(oddStartNode == null) {
					oddStartNode = new SinglyNode();
					oddStartNode.setData(data);
					oddEndNode = oddStartNode;
				}else {
					SinglyNode previousNode = oddEndNode;
					oddEndNode = new SinglyNode();
					oddEndNode.setData(data);
					previousNode.setNext(oddEndNode);
				}
			}
			currentNode = currentNode.getNext();
		}
		
		if(evenEndNode != null && oddStartNode != null) {
			evenEndNode.setNext(oddStartNode);
		}
		
		currentNode = evenStartNode;
		while(currentNode != null) {
			System.out.print(currentNode.getData() + ",");
			currentNode = currentNode.getNext();
		}
	}
	
	/**
	 * This method take n as an input parameter, we will print the nth element from the end
	 * Approach
	 * 1. we will take 2 pointers here - firstPointer,secondPointer.
	 * 2. we will put the firstPointer n position ahead of headNode, once our firstPointer is set, we will move both the firstPointer and secondPointer concurrently 1 node at a time.
	 * 3. when the firstPointer will reach the end, secondPointer will be at the nth node.
	 * 
	 * There is also another alternate to this approach, which is not optimized
	 * 1 we will traverse the whole linked list, and maintain a counter called length of the linkedList.
	 * 2 once we know the length of the linkedList, we will traverse the linkedList for (length - n + 1). it will point to the node which we want to print.
	 */
	public void printNthNodeFromTheEnd(int n) {
		SinglyNode firstPointer = this.headNode;
		SinglyNode secondPointer = this.headNode;
		boolean doesNthExist = true;
		for(int i=0;i < n ;i++) {
			if(firstPointer != null) {
				firstPointer = firstPointer.getNext();
			}else {
				doesNthExist = false;
				break;
			}
		}
		
		if(doesNthExist) {
			while(firstPointer != null) {
				firstPointer = firstPointer.getNext();
				secondPointer = secondPointer.getNext();
			}
			System.out.println("Nth element from the end is : " + secondPointer.getData());
		}else {
			System.out.println("Invalid n number");
		}
	}
	
	//TODO test it
	public static void printIntersectionOfListApproach1(SinglyNode headNode1,SinglyNode headNode2) {
		Set<SinglyNode> set = new HashSet<>();
		SinglyNode node = headNode1;
		SinglyNode interSectionNode = null;
		while(node != null) {
			set.add(node);
			node = node.getNext();
		}
		if(set.size() > 0) {
			node = headNode2;
			while(node != null) {
				if(set.contains(node)) {
					interSectionNode = node;
					break;
				}
				node = node.getNext();
			}
		}
		
		if(interSectionNode != null)
			System.out.println("interSectionNode is " + interSectionNode.getData());
		else
			System.out.println("No intersectionnode exists");
	}
	
	//TODO
	public void reverseListIteratively() {
		SinglyNode currentNode = this.headNode;
		while(currentNode != null) {
			
		}
	}

	public SinglyNode getHeadNode() {
		return headNode;
	}
}
