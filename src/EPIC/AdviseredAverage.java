package EPIC;
/*
Advisered Average Number
Write a program to display the advisered average for the list of numbers 
my omitting the three largest number in the series.
E.g:3,6,12,55,289,600,534,900,172.  avg=(3+6+12+55+289+172) /6= 89.5=89 and eliminating534,900,600
*/
public class AdviseredAverage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {3,6,12,55,289,600,534,900,172};
		System.out.println(getAdviseredAve(A));
	}
	public static double getAdviseredAve(int[] A){
		double res =0.0;
		if(A==null||A.length<=3) return res;
		int max1=A[0];
		int max2=max1;
		int max3=max1;
		for(int i=0;i<A.length;i++){
			res+=A[i];
			if(max1<A[i]){
				max3=max2;
				max2=max1;
				max1=A[i];
			}else if(max2<A[i]){
				max3=max2;
				max2=A[i];
			}else if(max3<A[i]){
				max3=A[i];
			}
		}
//		for(int i=0;i<A.length;i++){
//			if(A[i]!=max1 && A[i]!=max2 && A[i]!=max3)
//				res += A[i];
//		}
		res = (res-max1-max2-max3)/(A.length-3);
		return res;
	}
}
