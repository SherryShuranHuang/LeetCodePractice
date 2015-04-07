package EPIC;
/*
 * Well-ordered String:
 * You know a password is well-ordered string. Well-ordered string means that the order 
 * of the characters is in an alphabetical increasing order. Like ¡°abEm¡± is a well-ordered number. 
 * However, ¡°abmE¡± is not a well-order number. Given an input# that tells you also how many digits 
 * are in the password, print all possible passwords.
 */
public class WellOrderedStr {
	public void numOfValidPassword(String str, int passLength){
		if(str==null||str.length()<passLength) {
			System.out.println("ERROR: The length of the string is less than "+ passLength);
			return;
		}
		for(int i =0; i<str.length();i++){
			for(int j=i;j<=passLength;j++){
				
			}
		}
		
		
		
		
	}
	private boolean isBefore(char n1, char n2){
		int order1 = 0;
		int order2 = 0;
		if(n1>='a'&& n1<='z') order1 = n1-'a';
		else if(n1>='A'&&n1<='Z') order1 = n1-'A';
			
		if(n2>='a'&&n2<='z') order2 = n2-'a';
		else if(n2>='A'&&n2<='Z') order2 = n2-'A';
		
		if(order1<=order2){
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
