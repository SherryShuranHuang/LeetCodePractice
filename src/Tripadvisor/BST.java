package Tripadvisor;
import datastructure.TreeNode;

public class BST {
	/**
	 * http://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
	 * 
	 */
	public static TreeNode<Integer> findLCA(TreeNode<Integer> root, int a, int b){
		if(root==null) return null;
		
//		TreeNode left = null;
//		TreeNode right = null;
		
		if(root.val<a&& root.val<b){
//			left= findLCA(root.right,a,b);
			return findLCA(root.right,a,b);
		}
		else if(root.val>a&&root.val>b){
//			right= findLCA(root.left,a,b);
			return findLCA(root.left,a,b);
		}
		else return root;
				
//		return left==null?right:left;
	}
	
	public static TreeNode<Integer> findLCA2(TreeNode<Integer> root, int a, int b){
		if(root==null) return null;
		
		while(root!=null){
			if(root.val<a&& root.val<b){
				root = root.right;
			}
			else if(root.val>a&&root.val>b){
				root = root.left;
			}
			else break;
		}
		return root;// return null if not found
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(22);
		root.left = new TreeNode(15);
		root.left.left = new TreeNode(12);
		root.left.right = new TreeNode(19);
		root.left.right.left = new TreeNode(18);
		root.left.right.right = new TreeNode(21);
		
		root.right = new TreeNode(25);
		root.right.right = new TreeNode(28);
		root.right.right.left = new TreeNode(26);
		root.right.right.right = new TreeNode(30);
		
		BinayTreePrinter.printNode(root);
		TreeNode res = findLCA(root,18,19);
		System.out.println(res.val);
		
	}

}
