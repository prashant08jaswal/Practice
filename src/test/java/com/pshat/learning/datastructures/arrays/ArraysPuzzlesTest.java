package com.pshat.learning.datastructures.arrays;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Prashant on 26-06-2019.
 */
public class ArraysPuzzlesTest {
    private Logger logger = Logger.getLogger(getClass());
    private ArraysPuzzles arraysPuzzles = new ArraysPuzzles();

    @Test
    public void  reverseAnArrayWithTwoPointerTest(){
        int[] inputArray = {1,2,3,4,5,6,7,8,9,10};
        arraysPuzzles.reverseAnArrayWithTwoPointer(inputArray);
        for(int element : inputArray){
            System.out.print(element + ",");
        }
    }

    @Test
    public void  rotateAnArrayByXRotationsTest(){
        int[] inputArray = {5,8,10,12,15};
        arraysPuzzles.rotateAnArrayByXRotations(2,inputArray);
        for(int element : inputArray){
            System.out.print(element + ",");
        }
    }
    @Test
    public void main()
    {
        int k=4;
        int[] array = {1, 3, 4, 1, 3, 8};
        int sum =0;
        for(int i=0;i<k;i++){
            for(int j=0;j<array.length-1;j++){
                int currentIndex = j;
                int nextIndex = j+1;
                int current = array[currentIndex];
                int next = array[nextIndex];
                if(current > next){
                    int temp = next;
                    array[nextIndex] = current;
                    array[currentIndex] = temp;
                }
            }
            sum+=array[i];
        }
        System.out.println(sum);
    }

    @Test
    public  void tescases() throws IOException {
        int inputArray[] = new int[10];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        while (test > 0)
        {
            String secondLine = br.readLine();
            String[] strs1 = secondLine.trim().split("\\s+");

            int n = Integer.parseInt(strs1[0]);
            int k =  Integer.parseInt(strs1[1]);

            String line = br.readLine();
            String[] strs2 = line.trim().split("\\s+");
            for (int i = 0; i < n; i++)
                inputArray[i] = Integer.parseInt(strs2[i]);

            sb.append(printK(inputArray, n, k)+"\n");

            test--;
        }
        System.out.print(sb);
    }

    static int printK(int[] array,int n,int k){
        int sum =0;
        for(int i=0;i<k;i++){
            for(int j=0;j<n-1;j++){
                int currentIndex = j;
                int nextIndex = j+1;
                int current = array[currentIndex];
                int next = array[nextIndex];
                if(current > next){
                    int temp = next;
                    array[nextIndex] = current;
                    array[currentIndex] = temp;
                }
            }
            sum+=array[i];
        }
        return sum;
    }

}
