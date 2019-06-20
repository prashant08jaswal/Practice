package com.pshat.learning.datastructures.hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Prashant on 20-06-2019.
 */
public class FindSubArraySumZero {

    private int[] inputArray = {5,6,-4,-2,8,10};

    /*
    Approach here is :-
        1  we will take a hash based collection, here I have taken Hashset.
        2  We will add all the element prefixly , then we will check for sum.
        3  In our example input, when the prefix sum will calculate -2, our prefix sum will become 5.
        4  As we keep on inserting prefixSum in the set ,but before insertion we are checking whether this prefixSum already exists
           or not.
        5 If the prefix sum already exists, it means that there is a sub array with count 0, hence return true.
     */
    public boolean isSubArraySumZero(){


        int prefixSum = 0;
        Set<Integer> set = new HashSet<>();
        set.add(prefixSum); //0 is taken as a case if prefixSum results to 0, it means there is a subarray with sum zero.

        for (int i=0; i<inputArray.length;i++){
            prefixSum +=inputArray[i];
            if(set.contains(prefixSum)){
                return true;
            }
            set.add(prefixSum);
        }
        return false;
    }

    public static void main(String[] args) {
        FindSubArraySumZero findSubArraySumZero = new FindSubArraySumZero();
        boolean isSubArrayZero = findSubArraySumZero.isSubArraySumZero();
        System.out.println(isSubArrayZero);
    }
}
