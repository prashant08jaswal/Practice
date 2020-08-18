package com.pjaswal.learning.datastructures.linkedlist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
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
 * 9 reversing a list iteratively - reverseListIteratively()
 * 10 detect a loop in a linkedlist using floyd technique - detectALoop()
 * 11 detect and remove loop using floyd technique - detectAndRemoveLoop()
 * 12 Print the intersection of 2 linked list, if it exists - printIntersectionOfList()
 * 13 Pair wise swap node - pairWiseSwapNode()
 * 14 Clone a linkedList with random pointer using hashmap - cloneLinkedListRandomPointerUsingHashMap()
 * 15 Clone a linkedList with random pointer using dummy references - cloneLinkedListRandomPointerUsingDummyReferences
 */
public class SinglyLinkedList {
	
	private SinglyNode headNode;
	
	/**
	 * Approach
	 * 1. If the headNode is null, means the list is empty, we will set the headNode.
	 * 2  else we will traverse the list, till we find the last element, and then we will  
	 */
	public SinglyNode insert(int data) {
		SinglyNode newNode = null;
		if(this.headNode == null) {
			newNode = new SinglyNode(null,data);
			this.headNode = newNode;
		}else {
			SinglyNode insertAfter = this.headNode;
			while(insertAfter.getNext() != null) {
				insertAfter = insertAfter.getNext();
			}
			newNode = new SinglyNode(null,data);
			insertAfter.setNext(newNode);
		}
		return newNode;
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
	/**
	 * Approach
	 * 1 we will just change the references or link .
	 * 2 we will just use 3 varaibles previous,current,next to change the links
	 * 3 we will mark the original head.setNext as null, and the original last element as head.
	 */
	
	public void reverseListIteratively() {
		SinglyNode currentNode = this.headNode;
		SinglyNode nextNode  = currentNode.getNext();
		currentNode.setNext(null);
		while(nextNode != null) {
			SinglyNode previousNode = currentNode;
			currentNode = nextNode;
			nextNode = nextNode.getNext();
			currentNode.setNext(previousNode);
		}
		this.headNode = currentNode;
		printAll();
	}
	
	
	/**
	 * Approach
	 * 1 we will take slow and fast pointer.slow will move 1 node at a time, while fast will move 2 node at a time.
	 * 2 If the fast pointer is encountered with null, it means that there is no loop
	 * 3 if slow and fast pointer meet at some point, it means there exists a loop. 
	 * 
	 * Alternate Approach 1
	 * If we are allowed to modify the structure of the linkedlist,we will add a reference variable isVisited, everytime we will visit a node
	 * we will mark it as true. and during the list traversal if we encounter a node marked isVisited = true, then there exists a loop.
	 * 
	 * Alternate Approach 2
	 * 	1 Modification to list references.but it will make the list useless.
	 * 	2 We will create a dummy node, while traversing every node, we will store it's next in some temporary node, so that we can continue from there
	 *    and we will mark the node.setNext() to be the dummy node, while traversing if we encounter some node already having a reference to the  dummyNode, means a loop exist.
	 *    
	 * Alternate Approach 3
	 * Hashing :- we will insert every node in a hashset, if in hashset there already exists a node which we are trying to insert, it means a loop exists.
	 */
	public void detectALoop(SinglyNode head) {
		SinglyNode fastPointer = head;
		SinglyNode slowPointer = head;
		boolean doesLoopExist = false;
		while(fastPointer != null && fastPointer.getNext() != null) {
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext().getNext();
			if(fastPointer == slowPointer) {
				doesLoopExist = true;
				break;
			}
		}
		System.out.println("Does loop exist? " + doesLoopExist);
	}
	/**
	 * Approach 
	 * We will detect the loop using same technique that we used above,
	 * but now to remove the loop whenever the slow and fast meet at a point,
	 * we will take the slow to head, and now both fast and slow will move at 1 pace
	 * now where they will meet will be the loop starting point, so we will just make the node before meeting point as null,
	 * hence ending the loop.
	 */
	public static void detectAndRemoveLoop(SinglyNode head) {
		SinglyNode fastPointer = head;
		SinglyNode slowPointer = head;
		boolean doesLoopExist = false;
		while(fastPointer != null && fastPointer.getNext() != null) {
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext().getNext();
			if(fastPointer == slowPointer) {
				doesLoopExist = true;
				break;
			}
		}
		if(doesLoopExist) {
			slowPointer = head;
			SinglyNode lastNode = null;
			while(slowPointer != fastPointer) {
				lastNode = fastPointer;
				slowPointer = slowPointer.getNext();
				fastPointer = fastPointer.getNext();
			}
			lastNode.setNext(null);
		}
	}
	
	/**
	 * Approach 1
	 * 1 Use hashset, insert all the elements of one list in it
	 * 2 Now check if the element of second list is present or not
	 * 3 if it does, it is the intersectionnode
	 * Apprach 2
	 * If the modification allows, insert a boolean flag of isVisited, while traversing if
	 * element is marked with true, it is an intersection node
	 * Approach3
	 * 1 Count the number of node in both list,
	 * 2 subtract the count , traverse both the list concurrently, but first for the bigger list
	 * firstly traverse till the count that we got from the subtraction, then once
	 * both the list are of equal size now, compare each and every element, if an element matches
	 * then it is the intersection point
	 */
	public static void printIntersectionOfList(SinglyNode headNode1,SinglyNode headNode2) {
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
	
	/**
	 * Approach 1
	 * 1 In this we will replace the links only, and will change the links only in pair
	 * 2 we have used 4 references here
	 * 	a. firstNode 
	 * 	b. secondNode
	 * 	c. secondNodeNext
	 * 	d. previousNode - It is very important , though with the above 3 we will be able to change the
	 * 		links, but remember if we are not keeping a tab on the previousNode before swap, then the link
	 * 		will be lost.
	 * 
	 * Approach 2
	 * Replace the data. but this approach is not recommended.
	 */
	public void pairWiseSwapNode() {
		SinglyNode firstNode = this.headNode;
		SinglyNode secondNode = firstNode.getNext();
		this.headNode = secondNode;
		SinglyNode previousNode = null;
		while(firstNode != null && firstNode.getNext() != null) {
			SinglyNode secondNodeNext = secondNode.getNext();
			secondNode.setNext(firstNode);
			firstNode.setNext(secondNodeNext);
			if(previousNode != null)
				previousNode.setNext(secondNode);
			
			previousNode = firstNode;
			firstNode = firstNode.getNext();
			if(firstNode != null)
				secondNode = firstNode.getNext();
		}
	}
	
/**
 * Approach
 * 1. Traverse the original linked list and make a copy in terms of data.
 * 2. Make a hash map of key value pair with original linked list node and copied linked list node.
 * 3. Traverse the original linked list again and using the hash map adjust the next and random reference of cloned linked list nodes.	
 */
	public void cloneLinkedListRandomPointerUsingHashMap() {
		SinglyNode currentNode = this.headNode;
		Map<SinglyNode,SinglyNode> map = new HashMap<>();
		while(currentNode != null) {
			SinglyNode node = new SinglyNode();
			node.setData(currentNode.getData());
			map.put(currentNode, node);
			currentNode = currentNode.getNext();
		}
		
		for(Entry<SinglyNode,SinglyNode> entry:map.entrySet()) {
			SinglyNode originalNode = entry.getKey();
			SinglyNode clonedNode = entry.getValue();
			SinglyNode clonedNodeNextNode = map.get(originalNode.getNext());
			SinglyNode clonedNodeRandomNode = map.get(originalNode.getRandom());
			clonedNode.setNext(clonedNodeNextNode);
			clonedNode.setRandom(clonedNodeRandomNode);
		}
	}

	/**
	 * Approach :-
	 * 1 We will modify the original list, for every node we will create an intermediate temporary node, and will change the link
	 * means originalNode1->cloneOfOriginalNode1->originalNode2->cloneOfOriginalNode2 like this, till originalNodeN next is null.
	 * In this we will only create the dummy node,set data and next.
	 * 2 Once we have all the nodes cloned, we will now add the random pointer, we will find the random pointer of originalNode1,
	 * the next of originalNode1 random node will be the random pointer for cloneOfOriginalNode1, this will be done for every node.
	 * 3 Now once we have made clone, we will now separate the two list into - original list and cloned list
	 */
	public void cloneLinkedListRandomPointerUsingDummyReferences() {
		SinglyNode currentNode = this.headNode;
		while(currentNode != null) {
			SinglyNode nextNode = currentNode.getNext();
			SinglyNode tempIntermediateNode = new SinglyNode();
			tempIntermediateNode.setNext(nextNode);
			tempIntermediateNode.setData(currentNode.getData());
			currentNode.setNext(tempIntermediateNode);
			currentNode = nextNode;
		}
		currentNode = this.headNode;
		while(currentNode != null) {
			SinglyNode tempNode = currentNode.getNext();
			SinglyNode randomNode = currentNode.getRandom();
			tempNode.setRandom(randomNode.getNext());
			currentNode = tempNode.getNext();
		}
		currentNode = this.headNode;
		SinglyNode cloneHead = currentNode.getNext();
		SinglyNode cloneCurrent = cloneHead;
		while(cloneCurrent.getNext() != null) {
			SinglyNode originalNext = cloneCurrent.getNext();
			SinglyNode cloneNext = originalNext.getNext();
			cloneCurrent.setNext(cloneNext);
			currentNode.setNext(originalNext);
			cloneCurrent = cloneNext;
			currentNode = originalNext;
		}
		currentNode.setNext(null);
		System.out.println("========Original List=========");
		printAllWithRandomNode(this.headNode);
		System.out.println("========Cloned List=========");
		printAllWithRandomNode(cloneHead);
	}
	
	/**
	 * Print all the elements of the list.
	 */
	public void printAllWithRandomNode(SinglyNode headNode) {
		if(headNode != null) {
			SinglyNode node = headNode;
			while(node != null) {
				int nextNodeData = node.getNext() != null ? node.getNext().getData():-1;
				int randomNodeData = node.getRandom() != null ? node.getRandom().getData():-1;
				System.out.println("Node is: " + node.getData() + " Node Next is :" + nextNodeData + " Node Random is " + randomNodeData + " Hashcode of node is : " + node.hashCode());
				node = node.getNext();
			}
		}else {
			System.out.println("Empty List");
		}
	}
	
	public SinglyNode getHeadNode() {
		return headNode;
	}
}
