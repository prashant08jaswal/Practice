package com.pshat.learning.datastructures.maths;

/**
 * Created by Prashant on 18-06-2019.
 *
 * 2 methods defined 1 is iterative and another is recursive, to find number of digits present in
 * a number.
 * Condition - input should be  > 0
 */
public class CountNumberOfDigitsInANumber {

    public int countNumberIteratively(long number){
        int count = 0;
        while(number > 0){
            number = number/10;
            count++;
        }
        return count;
    }

    public int countNumberRecursively(long number){
        if(number > 0){
            return 1 + countNumberRecursively(number/10);
        }
            return 0;
    }

    public int countNumberUsingLog(long number){
        Double count = Math.floor(Math.log10(number)+1);
        return count.intValue();
    }
}
