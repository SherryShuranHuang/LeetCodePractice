package leetcode;
import java.util.ArrayList;
import java.util.List;


public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(numRows==0) return res;
        ArrayList<Integer> item = new ArrayList<Integer>(1);
        ArrayList<Integer> next = null;
        numRows--;
        res.add(item);
        while(numRows>0){
            next = new ArrayList<Integer>();
            for(int i=0;i<=item.size();i++){
                if(i==0 || i==item.size()){
                    next.add(1);
                }else{
                    next.add(item.get(i)+item.get(i-1));
                }
            }
            numRows--;
            item = next;
            res.add(item);
        }
    return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
