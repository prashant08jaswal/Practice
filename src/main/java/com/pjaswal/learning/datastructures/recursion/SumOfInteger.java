package com.pjaswal.learning.datastructures.recursion;

public class SumOfInteger {
	
	/*
	 * This method is implemented using tail recursion. here we could have avoided sum parameter and added in the program, but instead
	 * we implemented it using tail recursion, which has a better performance comparatively
	 */
	private static int sumNumber(int number,int sum) {
		if(number < 10)
			return sum + number;
		
		return sumNumber(number/10, sum + (number % 10));
	}
	
	public static void main(String[] args) {
		int number = 55555555;
		System.out.println(sumNumber(number, 0));
	}
}
