package EPIC;

import java.util.Arrays;
/*
RGB Compare
Given a string of RGB value (rr, gg, bb) which represents in hexadecimal. 
Compare if rr or gg or bb is the biggest, or two of those values are equal 
and larger than the third one, or three values are equal with each other.
*/

public class RGBCompare {
	public static void main(String[] args) {
		RGB("ac","AC","12");
	}
	private static void RGB(String rr, String gg, String bb){
//		int r = convert(rr.toLowerCase());
//		int g = convert(gg.toLowerCase());
//		int b = convert(bb.toLowerCase());
		
		int r = Integer.parseInt(rr,16);
		//System.out.println(r);
		int g = Integer.parseInt(gg,16);
		int b = Integer.parseInt(bb,16);
		int max = Math.max(Math.max(r,g),b);
		if(r==max&&g==max&&b==max){
			System.out.println("They are the same");
			return;
		}
		if(r==max&&g==max){
			System.out.println(rr+" and "+gg+" are the biggest");
			return;
		}
		if(r==max&&b==max){
			System.out.println(rr+" and "+bb+" are the biggest");
			return;
		}
		if(g==max&&b==max){
			System.out.println(gg+" and "+bb+" are the biggest");
			return;
		}
		if(r==max){
			System.out.println(rr+" is the biggest one");
			return;
		}
		if(g==max){
			System.out.println(gg+" is the biggest one");
			return;
		}
		if(b==max){
			System.out.println(bb+" is the biggest one");
			return;
		}
	}
//	private static int convert(String s){
//		int res = 0;
//		for(int i=0; i<s.length(); i++){
//			int temp = 0;
//			if(s.charAt(i)>='a'&& s.charAt(i)<='f'){
//				temp = s.charAt(i)-'a'+10;
//			}
//			else{
//				temp = s.charAt(i)-'0';
//			}
//			res = res + temp*(int)Math.pow((double)16, (double)(s.length()-1-i));
//		}
//		return res;
//	}
}
