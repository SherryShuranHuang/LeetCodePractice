package leetcode;
import java.util.ArrayList;
import java.util.List;


public class Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(n==0||k==0||k>n) return res;
        
        helper(n,k,res,new ArrayList<Integer>(),1);
        return res;
    }
    private static void helper(int n,int k,List<List<Integer>> res, ArrayList<Integer> item, int start ){
        //if(start>n+1) return;
        if(item.size()<=k){
            res.add(new ArrayList<Integer>(item));
            return;
        }
        
        for(int i=start;i<=n;i++){
            // if(!used[i-1]){
            //    used[i-1]=true;
                item.add(i);
                helper(n,k,res,item,i+1);
                item.remove(item.size()-1);
            //    used[i-1]=false;
            //}
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> res = combine(4,2);
	}

}
