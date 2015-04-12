package EPIC;

import java.util.ArrayList;
import java.util.List;
/*
Palindrome
Print all palindromes of size greater than or 
equal to 3 of a given string. (How to do it with DP)?
*/
		
public class Palindromes {
	public static void main(String[] args){
		String s = "abacolocxhooooh";
		System.out.println(findPalindrome(s));
	}
	public static List<String> findPalindrome(String str){
		List<String> res = new ArrayList<String>();
		if(str==null||str.length()<3) return res;
		int l =0;
		int r =0;
		
		for(int i=0;i<2*str.length()-1;i++){
			l = i/2;
			r = i/2;
			if(i%2!=0){
				r++;
			}
			String curPalindrome = isPalindrome(str,l,r);
			if(curPalindrome.length()>=3)
				res.add(curPalindrome);
		}
		return res;	
	}
	public static String isPalindrome(String str, int l, int r){
		while(l>=0 && r<=str.length()-1 && str.charAt(l)==str.charAt(r)){
			l--;
			r++;
		}
		return str.substring(l+1,r);
	}
}
