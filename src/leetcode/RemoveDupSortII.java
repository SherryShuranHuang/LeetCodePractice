package leetcode;

public class RemoveDupSortII {
	public static int removeDuplicates(int[] A) {
		if(A == null || A.length ==0 ) return 0;
		if(A.length == 1) return 1;
		int index = 2;
		
		for(int i = 2;i<A.length;i++){
			if(A[i]!= A[index-2]){
				A[index] = A[i];
				index++;
			}
		}
		
//		int index = 1;
//		int count = 1;
//
//		for(int i=1; i<A.length; i++){
//			if(A[i-1] == A[i]){
//				count++;
//				if(count>2)
//					continue;
//			}
//			else{
//				count = 1;
//			}
//			A[index++] = A[i];
			
		
////			if(count<2){
////				if(A[i-1] == A[i]){
////					A[index] = A[i];
////					index++;
////					count++;
////				}else{
////					A[index] = A[i];
////					index++;
////					count = 1;
////				}
////			}
////			else{
////				if(A[i-1] == A[i]){
////					//A[index] = A[i];
////					//index++;
////					count++;
////				}else{
////					A[index] = A[i];
////					index++;
////					count = 1;
////				}
////			}
//
//		}
		return index; 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,1,1,2,2,2};
		int len = removeDuplicates(A);
		System.out.println(len);
	}

}
