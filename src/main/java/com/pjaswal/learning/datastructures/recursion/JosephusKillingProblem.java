package com.pjaswal.learning.datastructures.recursion;

//TODO
public class JosephusKillingProblem {	
/**
 * Recursive solution
 * In this solution, the recursion will go on till numberOfPeople = 1, it is the base case,
 * So once the count reaches 1, we return 1, to the caller, we have derived this forumla 
 * ((josephusRecursiveSolution(numberOfPeople-1, toBeSkipped) + toBeSkipped-1) % numberOfPeople + 1)
 * 		in this toBeSkipped-1 & % numberOfPeople + 1 is taken ,
 *  	and not the formula ((josephusRecursiveSolution(numberOfPeople-1, toBeSkipped) + toBeSkipped) % numberOfPeople)
 *  	coz there comes a point when the person to be killed becomes zero. eg 7%7 = 0
 *  	so in order to avoid that we use toBeSkipped - 1, and after performing the modulus operation we add 1
 */
	
	public static int josephusRecursiveSolution(int numberOfPeople, int toBeSkipped) {
		if(numberOfPeople == 1)
			return numberOfPeople;
		
		return (josephusRecursiveSolution(numberOfPeople-1, toBeSkipped) + toBeSkipped-1) % numberOfPeople + 1;
	}
	
/**
 * Iterative solution
 * TODO :- deep dive while DP	
 */
	
	public static int josephusIterativeSolution(int numberOfPeople, int toBeSkipped) {
		int result=0; //for n=1
		for(int i=2;i<=numberOfPeople;i++)
		{
			result=(toBeSkipped+result)%i;
		}
		return (result+1);  //adding 1 to change indexing;

	}
	
	public static void main(String[] args) {
		System.out.println(josephusIterativeSolution(7, 2));
		System.out.println(josephusRecursiveSolution(7, 2));
	}
}
