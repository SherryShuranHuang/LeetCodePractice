package EPIC;
/*
Decimal Number
Let the user enter a decimal number. The range allowed is 0.0001 to 0.9999. 
Only four decimal places are allowed. The output should be an irreducible fraction. 
E.g.: If the user enters 0.35,the irreducible fraction will be 7/20.

*/
public class DecimalNumber {
	
	public static void main(String[] args) {
		double input = 1.35;
		fraction(input);
	}
	
	public static void fraction(double input) {
		if((input*100000)%10!=0) {
			throw new IllegalArgumentException("\n ERROR: Only four decimal places are allowed");
		}
		int x = (int) (input * 10000);
		int div = GCD(x, 10000);
		System.out.println(x / div + "/" + 10000 / div);
	}
	/*find Greatest common divisor using Euclid's algorithm*/
	public static int GCD(int m, int n) {
		if (m < n) {
			int t = m;
			m = n;
			n = t;
		}
		if (m % n == 0) {
			return n;
		} else {
			return GCD(n, m % n);
		}
	}
}
