package EPIC;

import java.util.ArrayList;
import java.util.List;

/*
Seeds Sum
Find the seed of a number. 
Eg : 256 = 245+2+4+5, 245 is the seed of 256. 
Find all possible seed for a given number.

Seed 这种题  一般都是可以缩小解的范围的  比如seed multiply 解一定是sqrt(N) 到 N/2 之间的因数 （N>4)
至于本题的 seed sum， 可以这么来分析假设 N=seed+seedSum，seedSum是seed各个位上的数字之和
（比如 2+4+5）那么seedSum是有范围的  比如三位数 seedSum <= 9+9+9=27以N=256为例, 
seedSum <= 27 ，而 seed = N-seedSum  也就是说 seed >= 256-27=229
也就是说  229以下的数就不用考虑了  因为不可能达到256  int最多只有10位  也就是说我们可以把iteration次数控制在90以内
*/

public class SeedSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findSeeds(256));
	}
	
	public static List<Integer> findSeeds(int num){
		List<Integer> seeds = new ArrayList<Integer>();
		if(num==0||num==1){
			seeds.add(num);
			return seeds;
		}
		String s = String.valueOf(num);
		int len = s.length();
		int range = 9*len;
		for(int i = num-range;i<=num;i++){
			int temp = i;
			int res = i;
			while(temp>0){
				res += temp%10;
				temp = temp/10;
			}
			if(res==num)
				seeds.add(i);
		}
		return seeds;
	}

}
