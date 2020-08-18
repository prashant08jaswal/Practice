package com.pjaswal.learning.datastructures.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Rabin karp algo depends on 2 factor, first is to compute the hash of pattern and permutations of input. if the pattern and input hash matches
 * then only we compare the characters, Worst case in this will be if every permutation matches with the hash, but the content does not match.
 */
public class PatternMatchingRabinKarp {
	
	private final static int primeNumber = 3;
	
	public static void main(String[] args) {
		String inputString = "GEEKS FOR GEEK";
		String pattern = "GEEK";
		List<Integer> occurrenceList = getPatterMatchingIndex(inputString, pattern.toCharArray());
		System.out.println(occurrenceList);
	}
	
	private static List<Integer> getPatterMatchingIndex(String inputString,char[] pattern){
		List<Integer> indexList = new ArrayList<>();
		int patternHashValue = hashcode(pattern);
		int hashValue = -1;
		int loopLength = (inputString.length() - pattern.length);
		for(int i=0;i<=loopLength;){
			String subString = inputString.substring(i,i+pattern.length);
			char[] subStringArray = subString.toCharArray();
			if(i == 0 ) {
				hashValue = hashcode(subStringArray);
				if(patternHashValue == hashValue) {
					insertIfMatched(subStringArray,pattern,i,indexList);
				}
			}else {
				hashValue = deriveHashcode(inputString.charAt(i-1), subStringArray[subStringArray.length-1], hashValue, pattern.length-1);
				if(patternHashValue == hashValue) {
					insertIfMatched(subStringArray,pattern,i,indexList);
				}
			}
			i++;
		}
		return indexList;
	}
	
	private static void insertIfMatched(char[] inputStringSub, char[] pattern,int index,List<Integer> indexList) {
		boolean isMatched = true;
		for(int i=0; i<inputStringSub.length;i++) {
			if(inputStringSub[i] != pattern[i]) {
				isMatched = false;
				break;
			}
		}
		if(isMatched) {
			indexList.add(index);
		}
	}
	
	/**
	 * This method is used only twice, once to calculate the pattern hashcode and another time to calculate the first substring of input
	 * The formula to calculate hash for this is :- 
	 *  given a char[a,b,c]
	 *  97 + 98*primeNumber(power -> 1) + 99*primeNumber(power ->2)
	 */
	private static int hashcode(char[] inputArray){
		int hashValue  = inputArray[0];
		for(int i=1;i<inputArray.length;i++){
			hashValue += inputArray[i]*Math.pow(primeNumber, i);
		}
		return hashValue;
	}
	
	/**
	 * This method is used to recalculate the hash of substring, by using following formula.This formula will be heavily used to compute hash.
	 * Given patter [a,b,e,d,a]
	 * possible hash calulation will be
	 * 1 abe
	 * 2 bed
	 * 3 eda 
	 * hash value for [a,b,e] using hashcode method will be 1300, taking primeNumber as 3
	 * 
	 * a.To compute [b,e,d] we will subtract a from 1300, it will be -> 1300-97 = 1203
	 * b.Now divide 1203 by prime number i.e 3 (1203/3) = 401
	 * c.Now 401 + 100 * 3 power 2 = 1301
	 * 1301 is the hash value for [b,e,d]
	 */
	private static int deriveHashcode(char charToBeRemoved,char charToBeAdded,int previousHashValue,int power){
		int derivedHashValue = previousHashValue-charToBeRemoved;
		derivedHashValue = derivedHashValue/primeNumber;
		derivedHashValue += charToBeAdded*Math.pow(primeNumber, power);
		return derivedHashValue;
	}
}
