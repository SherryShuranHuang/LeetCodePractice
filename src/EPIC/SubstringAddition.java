package EPIC;
/*
Substring Addition
Write a program to add the substring. eg :say you have a list {1 7 6 3 5 8 9 } 
and user is entering a sum 16. Output should display(2-4) that is {7 6 3} cause 7+6+3=16.
*/
public class SubstringAddition {
	public static void main(String[] args){
		int[] num = {1, 7 ,6 ,3 ,5 ,8 ,9 } ;
		subAddtion(num,16);
	}
	//recursion
	public static void subAddtion(int[] num, int target){
		if(num==null||num.length==0) return;
		
		for(int i=0;i<num.length;i++){
			helper(num, target, i,i);
		}
	}
	private static void helper(int[] num, int target, int i, int j){
		if(target<0) return;
		if(target==0){
			System.out.println("("+(++i)+"-"+j+")");
			return;
		}
		if(j<num.length){
			helper(num, target-num[j],i,j+1);
		}
	}
	
	//iterative
	public static void sumSub(int[] list, int target) {
		if (list == null || list.length == 0) {
			System.out.println("Failed.");
			return;
		}
		for (int i = 0; i < list.length; i++) {
			int sum = list[i];
			int j = i;
			while (++j < list.length && sum < target) {
				sum += list[j];
			}
			if (sum == target) {
				System.out.println("(" + (i + 1) + "-" + j + ")");
			}
		}
	}
}
