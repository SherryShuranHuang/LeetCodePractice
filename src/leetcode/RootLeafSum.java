package leetcode;
import datastructure.TreeNode;
public class RootLeafSum {
	public int rootLeafSum(TreeNode root){
		return helper(root, 0);
	}
	private int helper( TreeNode root, int sum){
		if(root==null) return 0;
		if(root.right==null&&root.left==null)
			return sum*10+(int)root.val;
		return helper(root, sum*10+(int)root.val)+helper(root.right,sum*10+(int)root.val);
	}
}
