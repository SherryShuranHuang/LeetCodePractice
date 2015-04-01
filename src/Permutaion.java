
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;


public class Permutaion {
	public static ArrayList<ArrayList<Integer>> permute(int[] num) {  //iterative
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();  
	    if(num == null || num.length==0)  
	        return res;  
	    ArrayList<Integer> first = new ArrayList<Integer>();  
	    first.add(num[0]);  
	    res.add(first);  
	    for(int i=1;i<num.length;i++)  
	    {  
	        ArrayList<ArrayList<Integer>> newRes = new ArrayList<ArrayList<Integer>>();  
	        for(int j=0;j<res.size();j++)  
	        {  
	            ArrayList<Integer> cur = res.get(j);  
	            for(int k=0;k<=cur.size();k++)  
	            {  
	                ArrayList<Integer> item = new ArrayList<Integer>(cur);  
	                item.add(k,num[i]);  
	                newRes.add(item);  
	            }  
	        }  
	        res = newRes;  
	    }  
	    return res;     
	}  
	
    public static LinkedList<List<Integer>> permute2(int[] num) {//iterative+queue
  
        LinkedList<List<Integer>> que = new LinkedList<List<Integer>>();
        if(num==null||num.length==0) return que;
        List<Integer> item = new LinkedList<Integer>();
        item.add(num[0]);
        que.offer(new LinkedList(item));
        
        for(int i=1;i<num.length;i++){
           //LinkedList<Integer> item = que.poll();
        	
        	int size = que.size();
           for(int j=0;j<size;j++){
        	   item = que.poll();
               for(int k=0;k<item.size()+1;k++){
            	   ArrayList<Integer> cur = new ArrayList<Integer>(item);
                   cur.add(k,num[i]);
                   que.offer(cur);
               }
                
           }
            
        }
        return que;
    }
    
	public static ArrayList<String> permute(String str){//recursive
		ArrayList<String> res = new ArrayList<String>();
		if(str==null||str.length()==0) return res;
		
		helper(str,new boolean[str.length()],new StringBuilder(), res);
		
		return res;
	}
	private static void helper(String str, boolean[] used, StringBuilder item, ArrayList<String> res){
		if(item.toString().length()==str.length()){
			System.out.println(item.toString());
			res.add(item.toString());
			return;
			
		}
		for(int i=0;i<str.length();i++){
			if(!used[i]){
				used[i]=true;
				item.append(str.charAt(i));
				helper(str,used,item,res);
				item.deleteCharAt(item.length()-1);
				used[i]=false;
			}
		}
	}
	
//	public static void permute(String s, String r ){
//		
//		if(r.length()==0){
//			System.out.println(s);
//		}
//		for(int i=0;i<r.length();i++){
//			if(r.length()!=0){
//				permute(s+r.charAt(i),r.substring(i+1,r.length()));// if r.substring(i+1,r.length()) is a copy, then it should work
//			}
//		}
//	}
	/**
	 * Given a collection of numbers that might contain duplicates, 
	 * return all possible unique permutations.
	 * @param num
	 * @return
	 */
    public static List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(num==null||num.length==0){
            return res;
        }
        HashSet<ArrayList<Integer>> map = new HashSet<ArrayList<Integer>>();
        boolean[] used = new boolean[num.length];
        Arrays.sort(num);
        helper(num,used,new ArrayList<Integer>(),res,map);
        return res;
    }
    private static void helper(int[] num,boolean[] used,ArrayList<Integer> item, List<List<Integer>> res, HashSet<ArrayList<Integer>> map){
        if(item.size()==num.length) {
            if(!map.contains(item)){
                res.add(new ArrayList(item));
               // map.add(new ArrayList(item));
            }  
            return;
        }
        for(int i=0;i<num.length;i++){
            if(i>0 && !used[i-1] && num[i]==num[i-1]) continue; 
            if(!used[i]){
                used[i]=true;
                item.add(num[i]);
                helper(num,used,item,res,map);
                item.remove(item.size()-1);
                used[i]=false;
            }
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,2,3};
		//ArrayList<ArrayList<Integer>> res = permute(num);
		LinkedList<List<Integer>> res = permute2(num);
//		String str = "cat";
//		ArrayList<String> res = permute(str);
//		permute("",str);
		//List<List<Integer>> res = permuteUnique(num);
	}

}
