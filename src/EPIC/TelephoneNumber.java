package EPIC;
/*
 * Telephone Number         
	Print all valid phone numbers of length n subject to following constraints:
	1.If a number contains a 4, it should start with 4
	2.No two consecutive digits can be same 
	3.Three digits: 7,2,9 will be entirely disallowed, take as input
 */

public class TelephoneNumber {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TelephoneNumber test = new TelephoneNumber();
		test.printValidPhoneNum(4);
	}
	public static void printValidPhoneNum(int len) {

		printValidPhoneNum(len,"");
	}
	private static void printValidPhoneNum(int len, String item){
		if(len==0){
			System.out.println(item);
			return;
		}
		for(int i=0;i<10;i++){
			if(item.length()>0 && i == item.charAt(item.length()-1)-'0')
				continue;//rule 2
			if(item.length()>0 && i==4 && item.charAt(0)!='4')
				continue;//rule 1
			if(i==7||i==2||i==9)
				continue;//rule 3
			printValidPhoneNum(len-1,item+(char)(i+'0'));
		}
	}
//	private static String digits = "0134568";//valid characters
//	private static int numLength;
//	
//	public static void main(String[] args) {
//		printPhoneNum(4);
//	}
//	
//	public static void printPhoneNum(int len) {
//		numLength = len;
//		printPhoneNum("");
//	}
//	
//	public static void printPhoneNum(String prefix) {
//		if (prefix.length() == numLength) {
//			System.out.println(prefix);
//			return;
//		}
//		for (int i = 0; i < digits.length(); i++) {
//			if (prefix.length() > 0) {
//				// Skip two consecutive digits.
//				if (prefix.charAt(prefix.length() - 1) == digits.charAt(i)) {
//					continue;
//				}
//				// Skip if '4' appears but our phone num is not starting with '4'.
//				if (prefix.length() > 0 && digits.charAt(i) == '4' 
//				 && prefix.charAt(0) != '4') {
//					continue;
//				}
//			}
//			printPhoneNum(prefix + digits.charAt(i));
//		}
//	}
}
