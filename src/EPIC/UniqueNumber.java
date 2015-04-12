package EPIC;
/*
Unique Number
Write efficient code for extracting unique 
elements from a sorted list of array. 
e.g. (1, 1, 3, 3, 3, 5, 5, 5, 9, 9, 9, 9)-> (1, 3, 5, 9).
*/
public class UniqueNumber {
	public static void main(String[] args){
		int[] a = {
			1, 1, 3, 3, 3, 5, 5, 5, 9, 9, 9, 9
		};
		removeDup(a);
	}
	
	public static int[] removeDup(int[] A){
		int[] res = new int[A.length];
		int count=0;
		res[count] = A[0];
		for(int i=1;i<A.length;i++){
			if(A[i]!=A[i-1]){
				res[++count]=A[i];
			}
		}
		return res;
	}	
}