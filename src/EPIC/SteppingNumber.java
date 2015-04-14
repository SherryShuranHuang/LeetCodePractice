package EPIC;

import java.util.ArrayList;
import java.util.List;
/*
 * A number is called as a stepping number if the adjacent 
 * digits are having a difference of 1. For eg. 8, 343, 545 are 
 * stepping numbers. While 890, 098 are not. The difference 
 * between a ¡®9¡¯ and ¡®0¡¯ should not be considered as 1. 
 * Given start number(s) and an end number (e) your function 
 * should list out all the stepping numbers in the range including 
 * both the numbers s & e.
 */

public class SteppingNumber {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SteppingNumber test = new SteppingNumber();
		test.steppingNum(100, 10000);
	}
	public void steppingNum(int s, int e){
		//List<Integer> res  = new ArrayList<Integer>();
		
		String ss = String.valueOf(s);
		String ee = String.valueOf(e);
		for(int i=ss.length();i<=ee.length();i++){
			for(int j=1;j<10;j++){ //no leading zero, so start from 1
				steppingNum(s,e,i,j);
			}
		}
	}
	private void steppingNum( int s, int e, int length, int num){
		if(length==1) {// because num already has one digit
			if(s<=num && num<=e)
				System.out.println(num);
			return;
		}
		int lastDigit = num%10;
		if(lastDigit==0){
			steppingNum(s,e,length-1,num*10+1);
		}
		else if(lastDigit==9){
			steppingNum(s,e,length-1,num*10+8);
		}
		else{
			steppingNum(s,e,length-1,num*10+lastDigit-1);
			steppingNum(s,e,length-1,num*10+lastDigit+1);
		}	
	}

}
