package Tripadvisor;
import datastructure.TreeNode;
public class BinaryTree {

	/** 
	 * find the Lowest common ancestor of two nodes in a binary tree(not a BST necessarily)
	 * 
	 * With only findLCAinBT, it can not solve:
	 *## but does not work if there is duplicates, which will return the highest ancestor
	 *## can not deal with the situation if a or b is not in the tree
	 * http://www.fusu.us/2013/06/p2-lowest-common-ancestor-in-binary-tree.html
	 * http://stackoverflow.com/questions/3540622/lowest-common-ancestor-of-binary-treenot-binary-search-tree
	 */
	public static TreeNode findLCAinBT(TreeNode root, int a, int b){
		if(root == null) return null;
		
		if(root.val==a||root.val==b)
		{// if at least one matched, no need to continue
	        // this is the LCA for this root
			return root;
		}
		
		TreeNode l = findLCAinBT(root.left,a,b);
		TreeNode r = findLCAinBT(root.right,a,b);
		
		if(l!=null && r!=null){
			return root;// nodes are each on a seaparate branch
		}

		return l==null?r:l;
	}
//	public static boolean search(TreeNode root, int k){
//		boolean res = false;
//		if(root == null) return false;
//		if(root.val == k) return true;
//		if(k<root.val){
//			res = search(root.left,k);
//		}else if(k>root.val){
//			res = search(root.right,k);
//		}
//		return res;
//	}
	public static boolean find(TreeNode root, int k){
		if(root==null) return false;
		if(root.val==k||find(root.left,k)||find(root.right,k)) return true;
		
		return false;
	}

//	private static TreeNode findLCAutil(TreeNode root, int n1, int n2, boolean v1, boolean v2){
//		if(root == null) return null;
//		
//		if(root.val==n1){
//			v1=true;
//			return root;
//		}
//		if(root.val==n2){
//			v2=true;
//			return root;
//		}
//		TreeNode l = findLCAutil(root.left,n1,n2,v1,v2);
//		TreeNode r = findLCAutil(root.right,n1,n2,v1,v2);
//		
//		if(l!=null && r!= null) return root;
//		
//		return (l!=null)?l:r;
//	}
	/**
	 * find the Lowest common ancestor of two nodes in a binary tree(not a BST necessarily)
	 * 
	 * solve the problem if a or b is not in the tree, with the if statement!
	 */
	public static TreeNode findLCAinBT2(TreeNode root, int n1, int n2){
		TreeNode lca = findLCAinBT(root,n1,n2);
		if( find(lca,n2)&& find(lca,n1))//或者也可以一次遍历完
			return lca;		
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		                1
//		               /  \
//		              7     2
//		             / \     \
//		            2   6     9
//		               / \    /
//		              5  11  4
//		
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(7);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(6);
		root.left.right.left = new TreeNode(5);
		root.left.right.right = new TreeNode(11);
		
		root.right = new TreeNode(2);
		root.right.right = new TreeNode(9);
		root.right.right.left = new TreeNode(4);
	
		//TreeNode res = findLCAinBT(root,2,10);
		//System.out.println(res.val);
		
		TreeNode res = findLCAinBT2(root,2,6);
		if(res!=null)
			System.out.println(res.val);
		else
			System.out.println("it is null");
//		if(search(root,7)){
//			System.out.println("done");
//		}
	}

}
