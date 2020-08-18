package com.pjaswal.learning.datastructures.recursion;


/**
 * TODO It can be reduced to O(n) using DP
 */
public class RopeCuttingUsingRecursion {
	/**
	 * In this we are given a rope of length ropeLength, and we are given a set i.e a,b,c , we have to find the maximum
	 * number of cuts that we can put in the rope . Rope can be cut in the given set, i.e the rope can be cut of size a,b or c
	 * 
	 * Approach :- we will cut the rope for a,b,c respectively in recursive manner, and we will keep on cutting the rope till either 
	 * ropeLength is 0 or ropeLength is in -1. As we will be cutting the rope for a,b,c we will find the max of these 3 results. 
	 * There can be case when the rope cannot be cut in the given set, in that case we will return -1 as result
	 * e.g (ropeLength = 5, a=4 ,b=2 ,c=6) no matter how me put a cut, there will be a piece that will not be in the set of a,b,c
	 * We will return result + 1 if result is greater than 0. this 1 signifies the first cut.
	 * 
	 * recursive complexity is 3^n
	 */
	private static int maxCut(int ropeLength,int a,int b,int c) {
		if(ropeLength == 0 ) //rope is finished
			return 0; 
		if(ropeLength < 0)  //rope cannot cater this cut, hence negative
			return -1;
		int result = Math.max(maxCut(ropeLength -a, a, b, c),Math.max(maxCut(ropeLength -b, a, b, c),maxCut(ropeLength -c, a, b, c)));
		if(result < 0)
			return -1;
		return result + 1; //1 here is the first cut.
	}
	
	public static void main(String[] args) {
		int ropeLength = 5;
		int a = 2;
		int b = 1;
		int c = 5;
		int result = maxCut(ropeLength, a, b, c);
		System.out.println(result);
	}

}
