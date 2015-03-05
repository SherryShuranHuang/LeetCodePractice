

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Sum4 {
	public static List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(num == null||num.length<=2){
            return result;
        }
        
        Arrays.sort(num);
        for(int i=num.length-1;i>=2;i--){
            if(i<num.length-1 && num[i]==num[i+1])  //skip duplicates   but (0,0,0)
                continue; 
            ArrayList<List<Integer>> currentSum = twoSum(num, i-1, -num[i]);
            for(int j=0;j<currentSum.size();j++){
                currentSum.get(j).add(num[i]);
            }
            result.addAll(currentSum);
        }
        return result;
    }
    
    private static ArrayList<List<Integer>> twoSum(int[] num, int end, int target){
        ArrayList<List<Integer>> list = new ArrayList<List<Integer>>();
        // if(num.length<2){
        //     return null;
        // }
        int l = 0;
        int r = end;
        while(l<r){
            if(num[l]+num[r]==target){
                ArrayList<Integer> item = new ArrayList<Integer>();
                item.add(num[l]);
                item.add(num[r]);
                list.add(item);
                l++;
                r--;
                while(l<r && num[l]==num[l-1]) //skip duplicates
                    l++;
                while(l<r && num[r]==num[r+1]) //skip duplicates
                    r--;
                
            }else if(num[l]+num[r]<target){
                l++;
            }else 
                r--;
        }
        return list;
   
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {3,3,3,-6};
		ArrayList<List<Integer>> res = (ArrayList<List<Integer>>) threeSum(A);
		System.out.println(Math.pow(10, 2));
	}

}
