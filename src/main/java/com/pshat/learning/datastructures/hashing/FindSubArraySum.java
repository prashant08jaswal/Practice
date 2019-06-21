package com.pshat.learning.datastructures.hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Prashant on 20-06-2019.
 */
public class FindSubArraySum {
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
        int[] inputArray = {5,6,-4,-2,8,10};
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

    /*
   Approach here is :-
       1  we will take a hash based collection, here I have taken Hashset.
       2  We will add all the element prefixly , then we will check for sum(checkSum).
       3  checkSum here is elements added prefixly(prefixSum) - the sum we want to match (valueToBeMatched)
       4  In our example following will happen :-
                inputArrayIndex     prefixSum   checkSum     set contains(not exact index just for demo)
                0                   5             -6            [5]
                1                   8             -3            [5,3]
                2                   16             5            As 5 already exists here, it means there is a subarray with given sum.
    */
    public boolean isSubArraySumEqualToGivenValue(){
        int[] inputArray = {5,3,8,-2,8,10};
        int valueToBeMatched = 11;
        int prefixSum = 0;
        Set<Integer> set = new HashSet<>();
        set.add(prefixSum); //0 is taken as a case if checkSum results to 0, it means there is a subarray with sum zero.

        for (int i=0; i<inputArray.length;i++){
            prefixSum +=inputArray[i];
            int checkSum = prefixSum - valueToBeMatched;
            if(set.contains(checkSum)){
                return true;
            }
            set.add(prefixSum);
        }
        return false;
    }

    /*
        Approach here is :-
        1 in case of binary array where we need to find the length of a sub array whose 0 and 1 are equal, we should make
          the 0 as -1.
        2 Now as previous example just keep on adding the array elements prefixly,till n.
        3 as soon as prefixSum sum is 0 , assign the subArrayLength to i+1(index + 1). It will keep on changing throughout the
          iteration only if further elements are balanced.
     */
    public int findLargestSubArrayLengthWithEqualZeroAndOne(){
        int[] inputArray = {0,1,1,0,1,0,1,0,1,0,0};
        int subArrayLength = 0;
        int prefixSum = 0;
        for(int i=0; i < inputArray.length; i++){
            if(inputArray[i] == 0){
                inputArray[i] = -1;
            }
        }
        for(int i=0; i < inputArray.length; i++){
            prefixSum +=inputArray[i];
            if (prefixSum == 0)
                subArrayLength = i+1;
        }
        return subArrayLength;
    }

    public static void main(String[] args) {
        FindSubArraySum findSubArraySum = new FindSubArraySum();

        boolean isSubArrayZero = findSubArraySum.isSubArraySumZero();
        System.out.println("Is Sub Array Contain Zero " + isSubArrayZero);

        boolean isSubArraySumEqualToGivenValue = findSubArraySum.isSubArraySumEqualToGivenValue();
        System.out.println("Is Sub Array Contain given Value " + isSubArraySumEqualToGivenValue);

        int length = findSubArraySum.findLargestSubArrayLengthWithEqualZeroAndOne();
        System.out.println("Length of largest sub array with equal zero and one is: " + length);

    }
}
