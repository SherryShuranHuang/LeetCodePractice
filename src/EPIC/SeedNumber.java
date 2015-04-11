package EPIC;

import java.util.ArrayList;
import java.util.List;
/*
Seeds Number
Find the seed of a number. 
Eg : 1716 = 143*1*4*3 =1716 so 143 is the seed of 1716. 
Find all possible seed for a given number.
*/

public class SeedNumber {
	public static void main(String[] args){
		System.out.println(findSeedNum(1716));
		System.out.println(findSeedNum(111));// should this count?
	
	}
	public static List<Integer> findSeedNum(int num){
		List<Integer> seeds = new ArrayList<Integer>();
		if (num == 0 || num == 1) {
			seeds.add(num);
			return seeds;
		}
		for(int i=(int)Math.sqrt(num);i<=num/2;i++){
			if(num%i==0){
				int temp = i;
				int res = i;
				while(temp>0){
					res *=temp%10;
					temp = temp/10;
				}
				if(res==num)
					seeds.add(i);
			}
		}
		return seeds;
	}
}
