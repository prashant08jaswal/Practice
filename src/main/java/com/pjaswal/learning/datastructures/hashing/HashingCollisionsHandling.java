package com.pjaswal.learning.datastructures.hashing;

import java.util.ArrayList;

/**
 * Created by Prashant on 25-06-2019.
 */
public class HashingCollisionsHandling {

    /*
    In separate chaining on collision, we just insert the element further in the list. as in below example
    we have taken as Arraylist of ArrayLists. Where each element of arraylist contains another arraylist(internal arraylist).
    If there is no case of collision, then in internal arraylist there will be only 1 element at index 0.
    In case of collision, then in internal arraylist there will be more than 1 element placed in insertion order.
     */
    public void separateChaining(int inputArray[],ArrayList<ArrayList<Integer>> hashTable,int hashSize )
    {
        int inputArrayLength = inputArray.length;
        for(int i =0 ; i < inputArrayLength ; i++){
            int item = inputArray[i];
            int itemIndex = item % hashSize;
            ArrayList<Integer> node = hashTable.get(itemIndex);
            node.add(item);
        }
    }

    /*
    In linear probing, in case of collision, the element will be inserted at the next available space.
    If there exists already an element, then we will just increment the value of the item by 1 , so that on mod operation
    the index that we will get will be incremented index. If the next index is where there is empty space, then item will be
    inserted there, else while loop will run until either it finds an empty space, or the counter reaches the max size.

    note :- here assumption is that empty space is denoted by -1
     */
    public void linearProbing(int hashTable[], int hashSize, int arr[], int array_size)
    {
        for(int i=0; i< array_size; i++){
            int item = arr[i];
            int index = item % hashSize;

            int hashNode = hashTable[index];

            if(hashNode == -1){
                hashTable[index] = item;
            }else{
                int counter = 0;
                int incrementedItem = 1+item;
                int incrementedItemIndex = incrementedItem % hashSize;
                while(counter < hashSize && hashTable[incrementedItemIndex] !=-1) {
                    incrementedItem = 1 + incrementedItem;
                    incrementedItemIndex = incrementedItem % hashSize;
                    counter++;
                }
                if(hashTable[incrementedItemIndex] == -1){
                    hashTable[incrementedItemIndex] = item;
                }
            }
        }
    }

}
