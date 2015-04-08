package leetcode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class SingleNum {
	/**
	 * each number shows up twice except for one
	 * @param A
	 * @return
	 */
	public static int singleNum2(int[] A){
		int res = 0;
		for(int i=0;i<A.length;i++){
			res^=A[i];
		}
		return res;
	}
	
	public int singleNumber2(int[] A) {  
	    int[] digits = new int[32];  
	    for(int i=0;i<32;i++)  
	    {  
	        for(int j=0;j<A.length;j++)  
	        {  
	            digits[i] += (A[j]>>i)&1;  
	        }  
	    }  
	    int res = 0;  
	    for(int i=0;i<32;i++)  
	    {  
	        res += (digits[i]%2)<<i;  
	    }  
	    return res;  
	}  
	
	/**
	 * each number shows up third times except for one
	 * @param A
	 * @return
	 */
	public int singleNumber(int[] A) {  
	    int[] digits = new int[32];  
	    for(int i=0;i<32;i++)  
	    {  
	        for(int j=0;j<A.length;j++)  
	        {  
	            digits[i] += (A[j]>>i)&1;  
	        }  
	    }  
	    int res = 0;  
	    for(int i=0;i<32;i++)  
	    {  
	        res += (digits[i]%3)<<i;  
	    }  
	    return res;  
	}  
	
	public int singleNum3(int[] A) {  
	    int res = 0;
	    HashMap<Integer, Integer> map  = new HashMap<Integer, Integer>();
	    for(int i=0;i<A.length;i++){
	    	if(map.containsKey(A[i])){
	    		map.put(A[i], map.get(A[i])+1);
	    		if(map.get(A[i])==3){
	    			map.remove(A[i]);
	    		}
	    	}else{
	    		map.put(A[i], 1);
	    	}
	    }
	   
	    Iterator<Integer> it = map.keySet().iterator();
	    while(it.hasNext()){
	    	res = (int) it.next();
	    }
	    return res;  
	}  
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2,3,7,2,3,1};
		int[] B = {-19,-46,-19,-46,-9,-9,-19,17,17,17,-13,-13,-9,-13,-46,-28};
		int res = singleNum2(A);
	}
	

}
