package EPIC;
/*
Octal and Decimal Palindrome

The decimal and octal values of some numbers are 
both palindromes sometimes. Find such numbers within a given range.
*/

public class OctalAndDecimalPalindrome {
	public static void main(String[] args){
		int start = 1;
		int end = 1000000;
		checkPalindrome(start, end);	
		
		System.out.println(decimal2octal(88));
	}
	public static void checkPalindrome(int start, int end){
		for(int i=start;i<=end;i++){
			if(isPalindrome(String.valueOf(i))){
				String oct = decimal2octal(i);
				if(isPalindrome(oct))
					System.out.println(i +"'s octal format is "+ oct);
			}
		}
	}
	public static boolean isPalindrome(String s){
		int start = 0;
		int end = s.length()-1;
		while(start<end){
			if(s.charAt(start)!=s.charAt(end))
				return false;
		}
		return true;		
	}
	public static String decimal2octal(int n) {
		StringBuilder sb = new StringBuilder();
		int remainder = 0;
		while (n != 0) {
			remainder = n % 8;
			n /= 8;
			sb.append(remainder);
		}
		return sb.reverse().toString();
	}
}
