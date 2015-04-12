package EPIC;

import java.util.ArrayList;
import java.util.List;
/*
Continuous Alphabets
Print continuous alphabets from a sequence of arbitrary alphabets
For example: 
Input: abcdefljdflsjflmnopflsjflasjftuvwxyz 
Output: abcdef; mnop; tuvwxyz
Input: AbcDefljdflsjflmnopflsjflasjftuvWxYz 
Output: abcdef; mnop; tuvwxyz
*/

public class ContinuousAlphabets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(printContinuous("abcdefljdflsjflmnopflsjflasjftuvwxyz "));
		System.out.println(printContinuous("AbcDefljdflsjflmnopflsjflasjftuvWxYz"));
	}
	
	public static List<String> printContinuous(String str){
		List<String> res = new ArrayList<String>();
		if(str==null||str.length()==0) return res;
		int j=0;
		int i;
		for(i=1;i<str.length();i++){
			if(isValid(str.charAt(i-1),str.charAt(i))){
				continue;
			}else{
				if(i-j>=2)
					res.add(str.substring(j,i));
				j=i;
			}
		}
		if(i-j>=2)
			res.add(str.substring(j,i));
		return res;
	}
	
	public static boolean isValid(char c1, char c2){
		int range = 'a'-'A';//32
		//ab,AB,       Ab,               aB,
		if(c2-c1==1 || c2-c1==range+1 ||c1-c2==range-1)
			return true;
		return false;
	}

}
