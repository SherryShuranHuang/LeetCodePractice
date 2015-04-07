package EPIC;
/*
 * Well-ordered String:
 * You know a password is well-ordered string. Well-ordered string means that the order 
 * of the characters is in an alphabetical increasing order. Like ¡°abEm¡± is a well-ordered number. 
 * However, ¡°abmE¡± is not a well-order number. Given an input# that tells you also how many digits 
 * are in the password, print all possible passwords.
 */
public class WellOrderedStr {
	public void getValidPassword(int passLength){
		if(passLength<1) {
			System.out.println("ERROR: invalid password length!");
			return;
		}
		getValidPassword(passLength,0,"");
	}
	private void getValidPassword(int n, int start, String pre){
		if(n==0){
			System.out.println(pre);
			return;
		}
		for(int i=start;i<26;i++){
			getValidPassword(n-1, i+1,pre+(char)('a'+i));
			getValidPassword(n-1, i+1,pre+(char)('A'+i));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WellOrderedStr test = new WellOrderedStr();
		test.getValidPassword(3);
	}

}
