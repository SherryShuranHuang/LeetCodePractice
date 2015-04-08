package leetcode;
import java.util.LinkedList;


public class FindPeekElement {
	public static int findPeakElement(int[] num) {
        if(num==null||num.length==0) return -1;
//        LinkedList<Integer> queue = new LinkedList<Integer>();
//       
//        queue.offer(0);
//        queue.offer(1);
//        int index = 1;
//        while(index<num.length){
//        	++index;
//            int ind = queue.poll();
//            int ind2 = queue.peek();
//            if(num[ind]<num[ind2]){
//                queue.offer(index);
//                continue;
//            }else{
//                if(index>2){
//                	index++;
//                    return queue.peek();
//                }
//            }
//        }
        return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2,1};
		System.out.println(findPeakElement(A));
	}

}
