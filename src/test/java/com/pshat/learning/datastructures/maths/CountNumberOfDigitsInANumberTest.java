package com.pshat.learning.datastructures.maths;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created by Prashant on 18-06-2019.
 */
public class CountNumberOfDigitsInANumberTest {
    private Logger logger = Logger.getLogger(getClass());
    private static CountNumberOfDigitsInANumber countNumberOfDigitsInANumber = new CountNumberOfDigitsInANumber();

    @Test
    public void testCountNumberIteratively(){
       int count = countNumberOfDigitsInANumber.countNumberIteratively(14578965321L);
        logger.info("Count of Number fetched using iterative approach is " + count);
    }

    @Test
    public void testCountNumberRecursively(){
        int count = countNumberOfDigitsInANumber.countNumberRecursively(14578965321L);
        logger.info("Count of Number fetched using recursive approach is " + count);
    }

    @Test
    public void testCountNumberUsingLog(){
        int count = countNumberOfDigitsInANumber.countNumberUsingLog(14578965321L);
        logger.info("Count of Number fetched using Logarithmic approach is " + count);
    }
}
