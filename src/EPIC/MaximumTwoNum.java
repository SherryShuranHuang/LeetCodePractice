package EPIC;

public class MaximumTwoNum {
	public static void findMaximunTwoNum(int[] A){
		if(A==null||A.length==0) return;
		int max1=Integer.MIN_VALUE;
		int max2 =max1;
		for(int i=0;i<A.length;i++){
			if(max1<A[i]){
				max2 = max1;
				max1 = A[i];
			}else if(max2<A[i]){
				max2 = A[i];
			}
		}
		System.out.println("The maximum two numbers in this array are "+ max1 +", "+max2);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = {-5,34,78,2,45,1,-80,23};
		findMaximunTwoNum(num);
	}

}
