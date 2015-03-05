
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CombinationSum {
//    public static ArrayList<List<Integer>> combinationSum(int[] candidates, int target) {
//        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
//        if(candidates == null|| candidates.length==0) return res;
//        Arrays.sort(candidates);
//        helper(candidates,0,target,new ArrayList<Integer>(), res);
//        return res;
//    }
//    private static void helper(int[] candidates, int start, int target, ArrayList<Integer> item, ArrayList<List<Integer>> res){
//        if(target<0) return;
//        if(target==0){
//            res.add(new ArrayList(item));
//            return;
//        } 
//        
//        for(int i=start;i<candidates.length;i++){
//            if(i>0&&candidates[i]==candidates[i-1])
//                continue;
//            item.add(candidates[i]);
//            helper(candidates,i,target-candidates[i],item,res);
//            item.remove(item.size()-1);
//        }
//        
//    }
    public static ArrayList<List<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if(candidates == null|| candidates.length==0) return res;
        Arrays.sort(candidates);
        helper(candidates,new boolean[candidates.length],target,new ArrayList<Integer>(), res);
        return res;
    }
    private static void helper(int[] candidates, boolean[] used, int target, ArrayList<Integer> item, ArrayList<List<Integer>> res){
        
        if(target==0){
            res.add(new ArrayList(item));
            return;
        } 
        if(target<0) return;
        for(int i=0;i<candidates.length;i++){
            if(i>0&&candidates[i]==candidates[i-1])
                continue;
            if(!used[i]){
                used[i]=true;
                item.add(candidates[i]);
                helper(candidates,used,target-candidates[i],item,res);
                item.remove(item.size()-1);
                used[i]=false;
            }
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,1};
		ArrayList<List<Integer>> res = combinationSum2(A,2);
		System.out.println("done");
	}

}
