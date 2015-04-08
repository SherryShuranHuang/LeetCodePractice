package EPIC;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*Keypad Permutation
	Phone has letters on the number keys. for example, number 2 has ABC on it, 
	number 3 has DEF, 4 number has GHI,... , and number 9 has WXYZ. 
	Write a program that will print out all of the possible combination 
	of those letters depending on the input.
*/

public class KeypadPermutation {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KeypadPermutation test = new KeypadPermutation();
		List<String> res = test.keypadPrmut("23");
		System.out.println(res);
		
	}
	public List<String> keypadPrmut(String input){
		String[] keys = {
			"", "", "abc", "def", "ghi", "jkl", 
			"mno", "pqrs", "tuv", "wxyz"
			};
		List<String> res = new LinkedList<String>();
		res.add("");
		for(int i=0;i<input.length();i++){
			int digit = input.charAt(i)-'0';
			//int size = res.size();
			List<String> cur = new ArrayList();
			for(int j=0;j<res.size();j++){
				for(int k=0;k<keys[digit].length();k++){
					String item = res.get(j);
					cur.add(item+keys[digit].charAt(k));
				}
			}
			res = cur;
		}
		return res;
	}
//======================================== recursive ===========
//	private static String[] map = {
//		"", "", "abc", "def", "ghi", "jkl", 
//		"mno", "pqrs", "tuv", "wxyz"
//	};
//	
//	public static void main(String[] args) {
//		doTests();
//	}
//	
//	public static void helper(String digits, List<String> res, StringBuilder item, int pos) {
//		if (pos == digits.length()) {
//			res.add(item.toString());
//			return;
//		}
//		String select = map[digits.charAt(pos) - '0'];
//		for (int i = 0; i < select.length(); i++) {
//			item.append(select.charAt(i));
//			helper(digits, res, item, pos + 1);
//			item.deleteCharAt(item.length() - 1);
//		}
//	}
//	
//	public static void doTests() {
//		String digits = "23";
//		List<String> res = new ArrayList<String>();
//		helper(digits, res, new StringBuilder(), 0);
//		System.out.println(res);
//	}

}
