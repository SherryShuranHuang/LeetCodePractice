
public class SearchInsertPos {
    public static int searchInsert(int[] A, int target) {
        if( A==null || A.length ==0) return 0;
        int l = 0;
        int r = A.length-1;
        
        return helper(A,l,r,target);
    }
    private static int helper(int[] A, int l, int r, int target){
        if(target < A[l])  return l;
        if(target > A[r])  return r+1;
        int m = (l+r)/2;

        if(target == A[m]) 
            return m;
        else if(target<A[m]) 
            return helper(A,l,m-1,target);
        else  return helper(A,m+1,r,target);
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] ={1,3};
		System.out.println(searchInsert(A, 2));
	}

}
