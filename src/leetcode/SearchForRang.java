package leetcode;

public class SearchForRang {
	public static int[] searchRange(int[] A, int target) {
		int[] res = {-1,-1};  
		if(A==null || A.length==0)  
		{  
			return res;  
		}  
		int ll = 0;  
		int lr = A.length-1;  
		while(ll<=lr)  //这里有=号，说明一直到遇到左头后停止 ll == lr
		{  
			int m = (ll+lr)/2;  
			if(A[m]<target)  
			{  
				ll = m+1;  
			}  
			else  
			{  
				lr = m-1;  
			}  
		}  
		int rl = 0;  
		int rr = A.length-1;  
		while(rl<=rr)  //这里有=号，说明一直到遇到右头后停止 rl == rr
		{  
			int m = (rl+rr)/2;  
			if(A[m]<=target)  
			{  
				rl = m+1;  
			}  
			else  
			{  
				rr = m-1;  
			}  
		}  
		 if(ll<=rr)  
		{  
		res[0] = ll;  
		res[1] = rr;  
		}  
		return res;  
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] ={1};
		System.out.println(searchRange(A, 0));
	}


}
