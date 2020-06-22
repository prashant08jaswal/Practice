package com.pshat.learning.datastructures.linkedlist;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LRUCacheUsingDeque {
	
	private Deque<Integer> doubleEndedQueue = new LinkedList<>();
	
	private HashSet<Integer> set = new HashSet<>();
	
	private int cacheSize;
	
	public LRUCacheUsingDeque(int cacheSize) {
		super();
		this.cacheSize = cacheSize;
	}

	/**
	 * Approach :-
	 * 1 Here we will use 2 data structures namely Hashset and Deque.
	 * 2 For every element that has been added to the queue , it's subsequent entry will also be placed in the set,
	 * 	 It is done as we know hashing is O(1), we can quickly determine whether the element exist in the cache(doubleEndedQueue) or not.
	 * 	 If it exists,we will just make the element as the first node of the doubleEndedQueue.
	 * 3 However if the element does not exist in the cache, we will firstly check the size of the cache. If the cache is full we will remove
	 * 	 the last element from both Hashet and Deque, and then will put the element in hashset and as first in deque.
	 */
	public void refer(int element) {
		if(!set.contains(element)) {
			if(doubleEndedQueue.size() == cacheSize) {
				Integer lastElement = doubleEndedQueue.removeLast();
				set.remove(lastElement);
			}
			set.add(element);
		}else {
			doubleEndedQueue.remove(element);
		}
		doubleEndedQueue.addFirst(element);
	}
	
	public void display() 
    { 
        Iterator<Integer> itr = doubleEndedQueue.iterator(); 
        while (itr.hasNext()) { 
            System.out.print(itr.next() + " "); 
        } 
    } 
	
	public static void main(String[] args) {
		LRUCacheUsingDeque ca = new LRUCacheUsingDeque(4);
        ca.refer(1); 
        ca.refer(2); 
        ca.refer(3); 
        ca.refer(1); 
        ca.refer(4); 
        ca.refer(5); 
        ca.display(); 
	}
}
