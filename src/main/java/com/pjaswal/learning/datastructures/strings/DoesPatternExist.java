package com.pjaswal.learning.datastructures.strings;

/**
 * Created by Prashant on 28-01-2020.
 */
public class DoesPatternExist {

    /*
       It takes 2 arguments inputString and patternString.
       Approach-
       1 Create 2 count arrays of size 256 for inputString and patternString
       2 insert the character count of patternString into patternStringCount array and in inputStringCount insert from index=0 to
         patternStringCharArray.length
       3 Now run a loop from patternStringCharArray.length to inputStringCharArray.length
            a In each iteration check if the two array elements are same. If the count of each element of both pattern and input
              array matches, it means they are same, else false will be returned.
            b If false is returned then we will use the sliding window approach, means we will remove leftmost character's count
              from the array, and we will insert new character element from the inputString. This process will be continued
              until pattern matches or the inputArray has reached it's length.
     */
    private boolean doesPatternExist(String inputString,String patternString){
        if((inputString == null && patternString == null)||(inputString.length()==0 && patternString.length()==0))
            return true;

        boolean isMatched = false;
        int[] inputStringCount = new int[256];
        int[] patternStringCount = new int[256];
        char[] inputStringCharArray = inputString.toCharArray();
        char[] patternStringCharArray = patternString.toCharArray();

        for(int i=0; i< patternStringCharArray.length;i++){
            inputStringCount[inputStringCharArray[i]]++;
            patternStringCount[patternStringCharArray[i]]++;
        }

        for(int i=patternStringCharArray.length;i<inputStringCharArray.length;i++){
            if(areSame(inputStringCount, patternStringCount)){
                isMatched = true;
                break;
            }
            inputStringCount[inputStringCharArray[i]]++;
            inputStringCount[inputStringCharArray[i-patternStringCharArray.length]]--;
        }

        return isMatched;
    }

    /*
    This method checks whether the Pattern matches the string or not. It compares the patternStringCountArray elements count with
    inputStringCountArray. If each and every element of patternStringCount matches the inputStringCount, it means that pattern matches
    and return true else false.
     */
    private boolean areSame(int[] inputStringCount,int[] patternStringCount){
        boolean isAnagram = true;
        for(int i=0;i<patternStringCount.length;i++){
            if(patternStringCount[i] != inputStringCount[i]){
                isAnagram = false;
                break;
            }
        }
        return isAnagram;
    }

    public static void main(String[] args) {
        DoesPatternExist doesPatternExist = new DoesPatternExist();
        String inputString = "geeksforgeeks";
        String patternString = "egek";
        boolean isPatternMatched = doesPatternExist.doesPatternExist(inputString,patternString);
        System.out.println(isPatternMatched);
    }
}
