package Tripadvisor;

public class Sort {
	/**
	 * BUBBLE sort
	 * 
	 * @param num
	 */
	public static void bubbleSort(int[] num) {
		if (num == null || num.length == 0) {
			return;
		}
		int n = num.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (num[j] > num[j + 1])
					swapNum(j, j + 1, num);
			}
		}

	}

	private static void swapNum(int i, int j, int[] num) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

	/**
	 * Selection sort each time, search for the current minimum and swap
	 * 
	 * @param num
	 */
	public static void selectionSort(int[] num) {
		for (int i = 0; i < num.length; i++) {
			int index = i;
			for (int j = i + 1; j < num.length; j++) {
				if (num[j] < num[index])
					index = j;
			}
			int smaller = num[index];
			num[index] = num[i];
			num[i] = smaller;
			// swap(index,j,num);
		}
	}

	/**
	 * insertion sort : simple + stable(i.e., it does not change the relative
	 * order of elements with equal keys) 
	 * 
	 * very fast for small data sets, even
	 * faster than quick sort best O(n) worst+average O(n2)
	 * 
	 * @param num
	 */
	public static void insertionSort(int[] num) {
		int temp;
		for (int i = 1; i < num.length; i++) {
			for (int j = i; j > 0; j--) {
				if (num[j] < num[j - 1]) {
//					temp = num[j];
//					num[j] = num[j - 1];
//					num[j - 1] = temp;
					swapNum(j,j-1,num);
				}
				
			}
		}
	}
	/**
	 * quick sort in the average case is жи(n log(n)) and in the worst case is жи(n2).
	 * 
	 * @param num
	 */
	public static void quickSort(int[] num){
		if(num==null||num.length==0) return;
		
		helper(0,num.length-1,num);
	}
	private static void helper(int start, int end,int[] num){
		int l=start;
		int r= end;
		int m=l+(r-l)/2; //pivot  //this way of writing can prevent overflow
		while(l<=r){
			while(num[l]<num[m]) l++;
			while(num[r]>num[m]) r--;
			if(l<=r){
				swapNum(l,r,num);
				l++;
				r--;
			}
		}
		if(start<r)
			helper(start,r,num);
		if(l<end)
			helper(l,end,num);
	}
	/**
	 * merge sort
	 * divide and conquer  guaranteed O(n*log(n)) efficiency
	 * @param num
	 */
	public static void mergeSort(int[] num){
		if(num==null||num.length==0) return;
		helpermerge(0,num.length-1,num, new int[num.length]);
	}
	private static void helpermerge(int start, int end, int[] num, int[] helper){
		if(start<end){
			int m = start+(end-start)/2;
			helpermerge(start,m,num,helper);
			helpermerge(m+1,end,num,helper);
			mergepart(start, m,end, num, helper);
		}
	}
	private static void mergepart(int l,int m, int r, int[] num, int[] helper){
		for(int i=l;i<=r;i++){
			helper[i]=num[i];
		}
		
		int i=l,j=m+1,k=l;
		
		while(i<m && j<=r){
			if(helper[i]<=helper[j]){
				num[k]=helper[i];
				i++;
			}else{
				num[k]=helper[j];
				j++;
			}
			k++;
		}
		while(i<=m){
			num[k]=helper[i];
			k++;
			i++;
		}
	}
	public static void main(String[] args) {
		int[] input = { 4, 2, 9, 9, 23, 12, 34, 0, 1,36 };
		bubbleSort(input);
		mergeSort(input);
		for (int i : input) {
			System.out.print(i);
			System.out.print(", ");
		}

	}
}
