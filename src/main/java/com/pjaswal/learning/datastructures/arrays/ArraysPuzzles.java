package com.pjaswal.learning.datastructures.arrays;

/**
 * Created by Prashant on 26-06-2019.
 */
public class ArraysPuzzles {
    /*
        Reverse an array in single iteration, without using extra array
        Approach
        1 use two pointer, one initializing at 0th index, & one intitialising at n-1 index.
        2 run the loop till n/2 & swap i value with j .
    */
    public void reverseAnArrayWithTwoPointer(int[] array){
        int arrayLength = array.length;
        for (int i=0,j=arrayLength-1; i<arrayLength/2 ; i++,j--){
            int tempValue = array[i];
            array[i]=array[j];
            array[j]=tempValue;
        }
    }

    public void rotateAnArrayByXRotations(int rotationBy,int[] array){
        int arrayLength = array.length;
        for (int i=0,j=rotationBy-1; i<rotationBy/2 ; i++,j--){
            int tempValue = array[i];
            array[i]=array[j];
            array[j]=tempValue;
        }
        for (int i=rotationBy,j=arrayLength-1; i<arrayLength ; i++,j--){
            int tempValue = array[i];
            array[i]=array[j];
            array[j]=tempValue;
        }
        System.out.println(array);
    }
}
