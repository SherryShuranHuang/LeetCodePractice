package EPIC;

import java.util.ArrayList;
import java.util.List;

//你有三种篮子能装， 6，9，20。 给你一个数N, 找出所有正好装完N 的组合
// Similar to LeetCode---Combination Sum
public class BasketSplit {
	static int[] batteries = {6,9,20};
	public static void main(String[] args) {
		System.out.println(busketnumbers(47));

	}
	
	public static List<List<Integer>> busketnumbers(int num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(num<6) return res;		
		helper(res, num, new ArrayList<Integer>(),0);
		return res;
	}
	private static void helper(List<List<Integer>> res, int target, List<Integer> item, int start){
		if(target<0) return;
		if(target==0){
			res.add(new ArrayList<Integer>(item));
			return;
		}
		for(int i=start;i<batteries.length;i++){
			item.add(batteries[i]);
			helper(res, target-batteries[i],item,i);
			item.remove(item.size()-1);
		}

	}
}
