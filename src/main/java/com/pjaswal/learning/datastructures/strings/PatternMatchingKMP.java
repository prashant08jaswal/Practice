package com.pjaswal.learning.datastructures.strings;

import java.util.ArrayList;
import java.util.List;

public class PatternMatchingKMP {

    public static void main(String []args){
    	String inputString = "ababcabcabababd";
    	String patternString = "aba";
        int[] lps = prepareLPS(patternString);
        for(int i=0;i<lps.length;i++){
            System.out.print(lps[i]+",");
        }
        List<Integer> indexArray = getPatternMatchIndex(inputString.toCharArray(), patternString.toCharArray(), lps);
        System.out.println();
        System.out.println("Repeated at indexes : " + indexArray);
     }
     
    private static int[] prepareLPS(String pattern){
        char[] arr = pattern.toCharArray();
        int[] lps = new int[arr.length];
        lps[0] = 0; //we will always put first element of lps as 0.coz at 0th index there is no possibility of a char appearing.
        int j =0;
        for(int i=1; i < arr.length;){
        	//if arr[j]& arr[i] matches put the lps[i] = j+1. j is the count of no. of character that matches as prefix and suffix.
            if(arr[j] == arr[i]){
           	 lps[i] = j+1;
                j++;
                i++;
            }else{
                if(j==0){ // It means that the character not matches. So move the i to next character & put 0 is the lps, indicating not matched.
               	 lps[i] = 0;
                    i++;
                }else{
                	/*when arr[i] != arr[j],while j is not 0, go one index back in the lps array & it will repeat till either i & j index of Arr
                	value matches or j reaches 0.If j reaches 0,then it means match not found.*/
                   j = lps[j-1];
                }
            }
            
        }
        return lps;
    }
     
     private static List<Integer> getPatternMatchIndex(char[] inputStringCharArray,char[] patternArray,int[] lps){
    	 List<Integer> indexList = new ArrayList<>();
    	 for(int i=0,lpsIndex=0; i < inputStringCharArray.length;){
    		 if(inputStringCharArray[i] == patternArray[lpsIndex]){
    			 i++;
    			 lpsIndex++;
    			 if(lpsIndex == lps.length){
            		 indexList.add(i-lps.length);
            		//It is a sliding window patern. Once a pattern matches, we go to the lpsIndex-1 to check if the last matched character can be
            		//the matching beginning charcter of the next slide.
            		 lpsIndex = lps[lpsIndex - 1];
            	 }
    		 }else{
    			 if(lpsIndex == 0 ){
    				 i++;
    			 }else{
    				 lpsIndex = lps[lpsIndex-1];
    			 }
    		 }
    	 }
    	 return indexList;
     }
}
