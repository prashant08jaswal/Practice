package com.pshat.learning.datastructures.hashing;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Prashant on 25-06-2019.
 */
public class HashingCollisionsHandlingTest {
    private Logger logger = Logger.getLogger(getClass());
    private static HashingCollisionsHandling hashingCollisionsHandling = new HashingCollisionsHandling();

    @Test
    public void testSeparateChaining(){
        int inputArray[] = {92, 4, 14, 24, 44, 91};
        int hashSize = 10;
        ArrayList<ArrayList<Integer>> hashTable = new ArrayList<>(hashSize);
        for(int i=0; i<hashSize; i++){
            hashTable.add(new ArrayList<>());
        }
        hashingCollisionsHandling.separateChaining(inputArray,hashTable,hashSize);

        //for printing of hashtable
        for(int i=0;i<hashTable.size();i++) {
            if(hashTable.get(i).size()>0) {
                System.out.print(i + "->");
                for(int j=0; j<hashTable.get(i).size()-1; j++) {
                    System.out.print(hashTable.get(i).get(j) + "->");
                }
                System.out.print(hashTable.get(i).get(hashTable.get(i).size() - 1));
                System.out.println();
            }
        }
    }

    @Test
    public void testLinearProbing(){
        int inputArray[] = {12, 22, 32, 43, 52, 62, 72, 820};
        int hashSize = 10;
        int hashTable[] = new int[hashSize];
        for(int i = 0; i < hashSize; i++)
            hashTable[i] = -1;
        hashingCollisionsHandling.linearProbing(hashTable,hashSize,inputArray,inputArray.length);

        //for printing hashtable
        for(int i = 0; i <hashSize; i++)
            System.out.print(hashTable[i] + " ");
    }
}
