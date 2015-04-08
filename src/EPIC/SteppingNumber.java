package EPIC;

import java.util.ArrayList;
import java.util.List;
/*
 * A number is called as a stepping number if the adjacent 
 * digits are having a difference of 1. For eg. 8,343,545 are 
 * stepping numbers. While 890, 098 are not. The difference 
 * between a ¡®9¡¯ and ¡®0¡¯ should not be considered as1. 
 * Given start number(s) and an end number (e) your function 
 * should list out all the stepping numbers in the range including 
 * both the numbers s & e.
 */

public class SteppingNumber {
	public void steppingNum(int s, int e){
		List<Integer> res  = new ArrayList<Integer>();
//		String ss = String.valueOf(s);
//		String ee = String.valueOf(e);
		for(int i=s;i<=e;i++){
			for(int j=1;j<10;j++){
				steppingNum(s,e,i,j,res);
			}
		}
	}
	private void steppingNum( int s, int e, int length, int num,List<Integer> res){
		if(length==0) return;
		if(length-1==0 && num>9){
			if(s<=num && num <=e)
				return;
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
