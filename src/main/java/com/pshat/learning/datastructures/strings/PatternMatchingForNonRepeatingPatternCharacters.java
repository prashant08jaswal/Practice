package com.pshat.learning.datastructures.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * This algo is only workable if we know for sure that the pattern does not contains repeating characters.
 */
public class PatternMatchingForNonRepeatingPatternCharacters {
	
	public static void main(String[] args) {
		String inputString = "abcabcd";
		String patternString = "abcd";
		List<Integer> indexList = findPatterns(inputString.toCharArray(), patternString.toCharArray());
		System.out.println(indexList);
	}

	private static List<Integer> findPatterns(char[] input,char[] pattern){
		List<Integer> indexList = new ArrayList<>();
		int index = -1;
		int loopLength = input.length - pattern.length;
		for(int i=0;i<=loopLength;) {
			boolean isMatched = true;
			index = i;
			for(int j=0;j<pattern.length;j++) {
				if(input[i] != pattern[j]) {				
					isMatched = false;
					break;
				}
				i++;
			}
			if(isMatched) {
				indexList.add(index);
			}
		}
		return indexList;
	}
}