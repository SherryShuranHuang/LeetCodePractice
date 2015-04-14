package EPIC;

import java.util.ArrayList;
import java.util.List;
/*
There is one kind of numbers call Additive Number, which satisfy the following situation:
A. can be split into several numbers;
B. The first two numbers are the same, the next number is equal to the (Fibonacci condition)
sum of previous two eg. 112 (2 = 1 + 1), 12,122,436(12 + 12 = 24,12 + 24 = 36)
If you are given a range by the user, find all numbers that are Fibonacci(Additive) numbers.
 */


public class AdditiveNumber {

	public static void main(String[] args) {
		//generator(100,10000);
		addictiveNumberInRange(100, 10000);
		
//		if(isAddictiveNumber(5151102+"")){
//			System.out.println("yes");
//		}
	}
	
	/**Solution 1: preferred
	 * judge all the numbers in the range
	 * @param l
	 * @param r
	 */
	public static void addictiveNumberInRange(int l, int r) {
		for (int i = l; i <= r; i++) {
			if (isAddictiveNumber(String.valueOf(i))) {
				System.out.println(i);
			}
		}
	}
	
	public static boolean isAddictiveNumber(String s) {
		for (int i = 1; i < s.length(); i++) {
			for (int j = i + 1; j < s.length(); j++) {
				String s1 = s.substring(0, i);
				String s2 = s.substring(i, j);
				/* if there is rule saying: The first two numbers are the same*/
				if(!s1.equals(s2)) 
					continue;
				/*-------------------------*/
				int part1 = Integer.parseInt(s1);
				int part2 = Integer.parseInt(s2);
				int index = j;
				int rest = Integer.parseInt(s.substring(j, s.length()));
				
				while (part1 + part2 <=rest) {
					int part3 = part1 + part2;
					String str = String.valueOf(part3);
					int length = str.length();
//					if (index + length > s.length()) {
//						break;
//					}
					if (s.substring(index, index + length).equals(str)) {
						index = index + length;
						if (index == s.length()) {
							return true;
						}
						part1 = part2;
						part2 = part3;
						rest = Integer.parseInt(s.substring(index, s.length()));
					} else {
						break;
					}
				}
			}
		}
		return false;
	}
	/**Solution 2
	 * generate all the additive number instead of judge
	 * But this solution need to consider 1)if the generated number is >Integer.MAX_VALUE
	 * 									  2) the maxgenerator variable
	 * And seems like it only works for range below 10000
	 * @param start
	 * @param end
	 */
	public static void generator(int start, int end) {

		int halflength = (end + "").length() / 2;
		int maxgenerator = (int) Math.pow(10, halflength);

		for (int i = 1; i < maxgenerator; i++) {
			//fibonacci(start, end, i, i);
			
			for (int j = 1; j < maxgenerator; j++) {
				fibonacci(start, end, i, j);
			}
		}
	}

	public static void fibonacci(int start, int end, int f, int s) {
		int rest = f+s;
		String res = String.valueOf(f)+String.valueOf(s)+String.valueOf(rest);
		
		while (Integer.parseInt(res) < end) {
			if(Integer.parseInt(res) >= start)
				System.out.println(res);
			f = s;
			s = rest;
			rest = f+s;
			res = res + String.valueOf(rest);
			if(res.compareTo(Integer.MAX_VALUE+"")==1)
				break;
		}
	}
	
//	public static void find(int left, int right){
//		List<Integer> res = new ArrayList<Integer>();
//		int[] map = new int[3];
//		for(int i=1;i<=9;i++){
//			map[0] = i;
//			map[1] = i; 
//			map[2] = 2*i;
//			String sum = ""+map[0]+map[1]+map[2];
//			int sumI = Integer.valueOf(sum);
//			while(sumI<= right){
//				if(sumI>=left){
//					System.out.println(sumI);;
//				}
//				map[0] = map[1];
//				map[1] = map[2];
//				map[2] = map[0]+map[1];
//				sum = sum+map[2];
//				sumI = Integer.valueOf(sum);
//			}
//		}
//		System.out.println(res);
//	}
}
