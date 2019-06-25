package com.pshat.learning.datastructures.hashing;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created by Prashant on 25-06-2019.
 */
public class FindSubArraySumTest {
    private Logger logger = Logger.getLogger(getClass());
    private FindSubArraySum findSubArraySum = new FindSubArraySum();

    @Test
    public void  isSubArrayZero(){
        boolean isSubArrayZero = findSubArraySum.isSubArraySumZero();
        logger.info("Is Sub Array Contain Zero: " + isSubArrayZero);
    }

    @Test
    public void  isSubArraySumEqualToGivenValue(){
        boolean isSubArraySumEqualToGivenValue = findSubArraySum.isSubArraySumEqualToGivenValue();
        logger.info("Is Sub Array Contain given Value: " + isSubArraySumEqualToGivenValue);
    }

    @Test
    public void  findLargestSubArrayLengthWithEqualZeroAndOne(){
        int length = findSubArraySum.findLargestSubArrayLengthWithEqualZeroAndOne();
        logger.info("Length of largest sub array with equal zero and one is: " + length);
    }

    @Test
    public void  doesAPairExistForGivenSum(){
        boolean doesAPairExistForGivenSum = findSubArraySum.doesAPairExistForGivenSum();
        logger.info("Does a pair exists whose sum is equal to the given Value: " + doesAPairExistForGivenSum);
    }
}
