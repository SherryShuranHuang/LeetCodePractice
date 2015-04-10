package EPIC;

import java.util.Scanner;
/*
Find Max/Min Number
Take a series of integers as input till a zero is entered. 
Among these given integers, find the maximum of the 
odd numbers and the minimum of the even integers 
(not including zero) and print them.
*/

public class FindMaxOrMin {

	public static void main(String[] args){
		//doTest();
		findMaxnMin();
	}
	
	public static int[] findMaxnMin(){
		int[] res = new int[2];
		int maxOdd = Integer.MIN_VALUE;
		int minEven = Integer.MAX_VALUE;
		Scanner in = new Scanner(System.in);
		while(true){
			int cur = in.nextInt();
			if(cur==0) 
				break;
			else if(cur%2==0){
				minEven = Math.min(cur, minEven);
			}
			else {
				maxOdd = Math.max(cur, maxOdd);
			}
		}
		
		if(maxOdd!=Integer.MIN_VALUE){
			System.out.println("The maximun odd number is "+ maxOdd);
		}else{
			System.out.println("The maximum odd number does not exist");
		}
		if(minEven!=Integer.MAX_VALUE){
			System.out.println("The minimum odd number is "+ minEven);
		}else{
			System.out.println("The minimum odd number does not exist");
		}
		res[0]=maxOdd;
		res[1]=minEven;
		return res;
	}

}
