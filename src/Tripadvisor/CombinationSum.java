package Tripadvisor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CombinationSum {
	public static List<List<Integer>> combinationSum(int[] num, int target){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(num==null||num.length==0){
			return res;
		}
		Arrays.sort(num);
		helper(num, 0, res, new ArrayList<Integer>(), target);
		return res;
	}
	
	private static void helper(int[] num, int start, List<List<Integer>> res, ArrayList<Integer>item, int target){
		if(target<0) return;
		
		if(target==0){
			//item.add(num[start]);
			res.add(new ArrayList<Integer>(item));
			return;
		}
		for(int i=start;i<num.length;i++){
//			if(i>0 && num[i]==num[i-1])  
//	            continue; 
			item.add(num[i]);
			helper(num,i+1,res,item,target-num[i]);
			item.remove(item.size()-1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A={1,2,3,4,5,6,7};
		List<List<Integer>> res = combinationSum(A,7);
		Iterator it = res.iterator();
		while(it.hasNext()){
			
		}
	}

}
