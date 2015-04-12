package EPIC;

import java.util.ArrayList;
import java.util.List;
/*
Subtraction of two Arrays
Suppose you want to do the subtraction of two numbers. 
Each digit of the numbers is divided and put in an array. 
Like A=[1,2, 3, 4, 5], B=[4, 5, 3, 5]. You should output 
an array C=[7, 8, 1, 0].Remember that your machine can¡¯t hand numbers larger than 20.
*/

public class SubtractionOf2Array {

	public static void main(String[] args){
		int[] A = { 2,1, 2, 3, 4, 5};
		int[] B = {4, 5, 3, 5};
		System.out.println(sub2Arraies(A, B));
	}
	//Assumption:  A>B, A.length>=B.length; 
	public static List<Integer> sub2Arraies(int[] A, int[] B){// will there be negative?
		if(A==null || B==null) return null;
		List<Integer> res = new ArrayList<Integer>();
		int p1 = A.length-1;
		int p2 = B.length-1;
		int carry=0;
		int diff=0;
		while(p1>=0 && p2>=0){
			diff = 10+A[p1]-B[p2]-carry;
			carry = diff/10==1?0:1;
			res.add(0,diff%10);
			p1--;
			p2--;
		}
		while(p1>=0){
			diff = 10+A[p1]-carry;
			carry = diff/10==1?0:1;
			
			if(p1!=0 || diff%10!=0)// if there will be a 0 at beginning 
				res.add(0,diff%10);
			
			p1--;
		}
		return res;
		
	}

}