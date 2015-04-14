package EPIC;
/*
Plus Equal Number
Given a number find whether the digits in the number can be 
used to form an equation with + and '='. That is if the number
is 123, we can have an equation of 1+2=3. But even the number 
17512 also forms the equation 12+5=17.
*/

public class PlusEqualNumber {

	public static void main(String[] args){
		findEquation("16182");
	}
	public static void findEquation(String s){
		if(s==null||s.length()<2) return;
		int n = s.length() / 2;
		boolean found = false;
		for (int i = 0; i < n; i++) {// former half range
			for (int j = i + 1; j < i + 1 + n; j++) {// later half range
				int n1 = Integer.parseInt(s.substring(0, i + 1));
				int n2 = Integer.parseInt(s.substring(i + 1, j + 1));
				if (j + 1 >= s.length()) {
					break;
				}
				int n3 = Integer.parseInt(s.substring(j + 1, s.length()));
				found = check(n1, n2, n3);
				if (found) {
					break;
				} else {
					continue;
				}
			}
		}
		if (!found) {
			System.out.println("Can't find such equation for the given string.");
		}
	}
	public static boolean check(int n1, int n2, int n3) {
		if (n1 + n2 == n3) {
			System.out.println(n1 + "+" + n2 + "=" + n3);
			return true;
		} else if (n2 + n3 == n1) {
			System.out.println(n2 + "+" + n3 + "=" + n1);
			return true;
		} else if (n1 + n3 == n2) {
			System.out.println(n1 + "+" + n3 + "=" + n2);
			return true;
		} else {
			return false;
		}
	}
}
