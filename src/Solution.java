import java.util.HashSet;
import java.util.LinkedList;


public class Solution {
	public static int findMin(int[] num) {

		int arraySize = num.length;
		int max = num[(arraySize-1)] - num[0];
		int index = 0;
		for(int ii=0;ii<arraySize-1;ii++){
			int sub = num[ii+1]- num[ii];

			//max = sub>=max?sub:max;
			if(Math.abs(sub)>Math.abs(max)){
				max = sub;
				if(max < 0){
					index = ii+1;
				}
				else index = ii;
			}

		}
		return num[index];

	}

	public static boolean uniqueChar1(String str){
		char[] chararray = new char[128];
		for(int i= 0;i<str.length();i++){
			if(chararray[str.charAt(i)] != 1)
				chararray[str.charAt(i)] = 1;
			else{
				return false;
			}
		}
		return true;

	}

	public static boolean uniqueChar2(String str){
		for(int i=0; i<str.length(); i++){
			//char val = str.charAt(i);
			for(int j=i+1;j<str.length();j++){
				if(str.charAt(i) == str.charAt(j))
					return false;
			}
		}
		return true;
}
	public static boolean uniqueChar3(String str){ // inplace
		if(str == null) return false;
		int check = 0;
		for(int i=0; i<str.length();i++){
			if((check & (1<<str.charAt(i)))>0 ){
				return false;
			}
			check = check | 1<<str.charAt(i);
		}
		return true;
	}
	


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] num = {4,5,6,7,0,1,2,3};
//		//int[] num = {0,1,2,3,4,5,6,7};
//		int result = findMin(num);
//		System.out.println(result);
		boolean[] array = new boolean[3];
		String str="asdfg";
		if(uniqueChar3(str)){
			int num=123;
			System.out.println("true" +array[2]);
		}
		else System.out.println("false");
	}

}
