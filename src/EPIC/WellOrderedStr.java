package EPIC;

import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

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
		
//		ArrayList<String> res = new ArrayList<String>();
//		getValidPassword(passLength,0,"",res);
//		for(int i = 0;i<res.size();i++){
//			System.out.println(res.get(i));
//		}
		
	}
	/**
	 * If we need to return all the results, use an arraylist to store
	 */
//	private void getValidPassword(int n, int start, String item, ArrayList<String> res){
//		if(n==0){
//			res.add(item);
//			return;
//		}
//		for(int i=start;i<26;i++){
//			getValidPassword(n-1, i+1,item+(char)('a'+i));
//			getValidPassword(n-1, i+1,item+(char)('A'+i));
//		}
//	}
	
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
