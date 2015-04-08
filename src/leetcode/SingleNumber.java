package leetcode;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;


public class SingleNumber {
    public static int singleNumber(int[] A) {
        Hashtable<Integer, Integer> map = new Hashtable<Integer, Integer>();
        int res = 0;
        for(int i =0; i<A.length;i++){
            if(map.containsKey(A[i])){
                map.remove(A[i]);
            }
            else{
            	map.put(A[i],1);
            }
            //LinkedList<Integer> test = new LinkedList<Integer>();
            
        }
        for (Iterator it2 = map.keySet().iterator(); it2.hasNext();) {
            int key =  (int) it2.next();
            System.out.println(key);
        }
                return res;       
        
    }

    
	public static void main(String[] args) {
		
		int[] a = {1,2,3,4,5,4,3,2,1};
		// TODO Auto-generated method stub
		singleNumber(a);
	}

}
