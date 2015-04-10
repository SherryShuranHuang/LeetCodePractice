package EPIC;

import java.util.ArrayList;
import java.util.List;

/*
Largest Sum Sub Array
Find the largest sum contiguous sub array. 
The length of the returned sub array must beat least of length 2.
*/

public class LargestSumSubarray {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {
				-1,-1,-10,6,-10
				//-2, 1, -3, 4, -1, 2, 1, -5, 4
			};
		int[] res= largestSubarray(array);

		for(int k=0;k<res.length;k++)
			System.out.print(res[k]+",");

	}
	public static int[] largestSubarray(int[] A){
		if(A.length<2) return  null;
		if(A.length==2) return A;
		int maxstart=0;
		int maxend=1;
		int curMaxstart=0;
		int curMaxend=1;
		int max_ending_here = A[0] + A[1];
		int max_so_far = max_ending_here;
		for(int i=2;i<A.length;i++){
			if(A[i]+A[i-1]>(max_ending_here+A[i])){
				max_ending_here = A[i]+A[i-1];
				curMaxstart = i-1;
				curMaxend = i;
			}else{
				max_ending_here = max_ending_here+A[i];
				curMaxend = i;
			}
			if(max_ending_here>max_so_far){
				max_so_far = max_ending_here;
				maxstart = curMaxstart;
				maxend = curMaxend;
			}				
		}
		int[] res = new int[maxend-maxstart+1];
		for(int k=0;k<=maxend-maxstart;k++){
			res[k]=A[maxstart+k];
		}
		return res;
	}

}
