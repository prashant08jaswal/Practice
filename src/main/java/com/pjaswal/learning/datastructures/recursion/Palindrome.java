package com.pjaswal.learning.datastructures.recursion;

public class Palindrome {
	
	private static boolean isPalindrome(String inputString,int leftIndex,int rightIndex) {
		if(leftIndex == rightIndex) // It means that they have both reached the mid of the string, and string is of odd size
			return true;
		if(inputString.charAt(leftIndex) != inputString.charAt(rightIndex)) //In case not matching, return false.
			return false;
		if(leftIndex > rightIndex )  // if leftIndex > rightIndex , it means all the characters have matched.
			return true;
		
		return isPalindrome(inputString, ++leftIndex , --rightIndex);
	}
	
	public static void main(String[] args) {
		String inputString = "aabbaa";
		System.out.println(isPalindrome(inputString,0,inputString.length()-1));
	}

}
