package leetcode;

public class SearchInRotatedSortedArrayII {
    public static boolean search(int[] A, int target) {
        if(A==null || A.length ==0){
             return false;
         }
         
         int head = 0;
         int end = A.length-1;

         // if(A[head]<=A[end] && (target<A[head] || target >A[end]))
         //     return -1;
         while(head<=end){
             int mid = (head+end)/2;
             if(target == A[mid]){
                 return true;
             }
             if(A[mid]<=A[end]){
                 if(target > A[mid] && target <= A[end])
                     head = mid+1;
                 else
                     end = mid-1;
             }
             else if(A[mid]>=A[end]){
                 if(target > A[head] && target < A[mid])
                     end = mid-1;
                 else
                     head = mid+1;
             }
             // else{// this is the step which affects the time complexity to O(n) instead of O(logn), if there is lots of equal numbers
             //     head++;
             // }
         }
         return false; 
     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {3,5,1};
		//int[] num = {0,1,2,3,4,5,6,7};
		if(search(num, 3))
		System.out.println("yes");
		else
			System.out.println("no");
	}

}
