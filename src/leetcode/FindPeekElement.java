package leetcode;
import java.util.LinkedList;


public class FindPeekElement {
    public static int findPeakElement(int[] num) {//edge case clarification:[1] [1,2] [3,1] [1,2,3,4]
        if(num==null||num.length==0) return -1;
            for(int i=1;i<num.length;i++){
                if(num[i]<num[i-1])
                    return i-1;
            }
            return num.length-1;// time: O(n) FOLLOW UP: how to do it in O(lgn)?
        }
        
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2,1};
		System.out.println(findPeakElement(A));
	}

}
