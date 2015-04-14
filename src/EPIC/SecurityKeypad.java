package EPIC;
/*
Security Keypad
There is a security keypad at the entrance of a building. 
It has 9 numbers 1 - 9 in a 3x3 matrix format. 
1 2 3 
4 5 6 
7 8 9 
The security has decided to allow one digit error 
for a person but that digit should be horizontal or vertical. 
Example: for 5 the user is allowed to enter2, 4, 6, 8 or 
for 4 the user is allowed to enter 1, 5, 7. IF the security 
code to enter is 1478 and if the user enters 1178 he 
should be allowed. Write a function to take security code 
from the user and print out if he should be allowed or not.
 */

public class SecurityKeypad {
	public static void main(String[] args){
		char[][] matrix = { 
				{ '1', '2', '3' },
				{ '4', '5', '6' }, 
				{ '7', '8', '9' } 
			};
			String expected = "1478";
			String actual = "1178";
			if (isValidKey(matrix, actual, expected)) {
				System.out.println("Allowed.");
			} else {
				System.out.println("Refused.");
			}
	}

	public static boolean isValidKey(char[][] mat, String actual, String expected){
		if(actual==null||actual.length()!=expected.length()) return false;

		for(int i=0;i<expected.length();i++){
			if(expected.charAt(i)!=actual.charAt(i)){
				if ((expected.charAt(i) == '1' && (actual.charAt(i) == '2' || actual.charAt(i) == '4'))
				|| (expected.charAt(i) == '2' && (actual.charAt(i) == '1' || actual.charAt(i) == '3' || actual.charAt(i) == '5'))
				|| (expected.charAt(i) == '3' && (actual.charAt(i) == '2' || actual.charAt(i) == '6'))
				|| (expected.charAt(i) == '4' && (actual.charAt(i) == '1' || actual.charAt(i) == '5' || actual.charAt(i) == '7'))
				|| (expected.charAt(i) == '5' && (actual.charAt(i) == '4' || actual.charAt(i) == '2' || actual.charAt(i) == '6' || actual.charAt(i) == '8'))
				|| (expected.charAt(i) == '6' && (actual.charAt(i) == '3' || actual.charAt(i) == '5' || actual.charAt(i) == '9'))
				|| (expected.charAt(i) == '7' && (actual.charAt(i) == '4' || actual.charAt(i) == '8'))
				|| (expected.charAt(i) == '8' && (actual.charAt(i) == '7' || actual.charAt(i) == '5' || actual.charAt(i) == '9'))
				|| (expected.charAt(i) == '9' && (actual.charAt(i) == '8' || actual.charAt(i) == '6'))) {
					continue;
				} else {
					return false;
				}
			}	
		}
		return true;
	}
}
