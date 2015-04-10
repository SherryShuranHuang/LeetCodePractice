package EPIC;

import java.util.ArrayList;
import java.util.List;

/*
An additive sequence is 1,2,3,5,8,13 where T(n) = T(n -1) + T(n - 2). 
A number range is given to you. Find the additive sequence number in that range.
Given the start and an ending integer as user input, generate all integers with the following property.
*/
public class AdditiveSequence {
	public static void main(String[] args){
		List<Integer> res = findAdditiveSequence(21,50);
		System.out.println(res);
	}
	public static List<Integer> findAdditiveSequence(int start, int end){
		List<Integer> res = new ArrayList<Integer>();
		if(end<start) return res;
		
		int f1 =1;
		int f2 =2;
		int f3= f1+f2;
		
//		if(f1==start)
//			res.add(f1);
		
		while(f2<start){
			f1=f2;
			f2=f3;
			f3=f1+f2;
		}
		
		while(f2<=end){
			res.add(f2);
			f1 = f2;
			f2 = f3;
			f3 = f1+f2;
		}
		return res;
	}

}
