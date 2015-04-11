package EPIC;
/*
There is one kind of numbers call Fibbonaci(Aditive) Number, which satisfy the following situation:
A. can be spilt into several numbers;
B. The first two numbers are the same, the next number is equal to the 
sum of previous two eg. 112 (2 = 1 + 1), 12,122,436(12 + 12 = 24,12 + 24 = 36)
If you are given a range by the user, find all numbers that are Fibbonaci(Aditive) numbers.
 */


public class AdditiveNumber {

	public static void main(String[] args) {
		addictiveNumberInRange(1, 1000000);
//		if(isAddictiveNumber(5151102+"")){
//			System.out.println("yes");
//		}
	}

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
				if(!s1.equals(s2)) 
					continue;
				int part1 = Integer.parseInt(s1);
				int part2 = Integer.parseInt(s2);
				int index = j;
				int rest = Integer.parseInt(s.substring(j, s.length()));
				while (part1 + part2 <= rest) {
					int part3 = part1 + part2;
					String str = String.valueOf(part3);
					int length = str.length();
					if (index + length > s.length()) {
						break;
					}
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
	
//	public static void generator(int start, int end) {
//
//		int halflength = (end + "").length() / 2;
//		int maxgenerator = (int) Math.pow(10, halflength);
//
//		for (int i = 1; i < maxgenerator; i++) {
//			for (int j = 1; j < maxgenerator; j++) {
//				fibonacci(start, end, i, j);
//			}
//		}
//	}
//
//	public static void fibonacci(int start, int end, int f, int s) {
//		String res = Integer.toString(f) + Integer.toString(s);
//
//		while (Integer.parseInt(res) < start) {
//			int temp = f + s;
//			res += temp;
//			f = s;
//			s = temp;
//		}
//
//		while (Integer.parseInt(res) < end) {
//			int temp = f + s;
//			res += temp;
//			if (Integer.parseInt(res) < end)
//				System.out.println(res);
//			f = s;
//			s = temp;
//		}
//	}
}
