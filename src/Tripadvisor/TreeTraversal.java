package Tripadvisor;
import datastructure.TreeNode;

import java.util.LinkedList;
public class TreeTraversal {

//	public static LinkedList<Integer> in_order(TreeNode root){
//		LinkedList<Integer> res = new LinkedList<Integer>();
//		if(root==null) return res;
//		inorderhelper(root, res);
//		
//		return res;
//	}
//	private static void inorderhelper(TreeNode root, LinkedList<Integer> res){
//		if(root==null) return;
//		inorderhelper(root.left,res);
//		//res.add((Integer) root.val);
////		System.out.print(root.val + "  ");
//		inorderhelper(root.right,res);
//		System.out.print(root.val + "  ");
//	}
	
	public static LinkedList<Integer> in_order(TreeNode root){//iterative
		LinkedList<Integer> res = new LinkedList<Integer>();
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		if(root==null) return res;
		
		while(root!=null||!stack.isEmpty()){
			if(root!=null){
				stack.push(root);
				root = root.left;
			}else{
				root = stack.pop();
				res.add((Integer) root.val);
				System.out.print(root.val + "  ");
				root = root.right;
			}
		}
		return res;
	}
	
	public static LinkedList<Integer> pre_order(TreeNode root){//iterative
		LinkedList<Integer> res = new LinkedList<Integer>();
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		if(root==null) return res;
		
		while(root!=null||!stack.isEmpty()){
			if(root!=null){
				res.add((Integer) root.val);
				System.out.print(root.val + "  ");
				stack.push(root);		
				root = root.left;
			}else{
				root = stack.pop();
				root = root.right;
			}
		}
		return res;
	}
	
	public static LinkedList<Integer> post_order(TreeNode root){//iterative
		LinkedList<Integer> res = new LinkedList<Integer>();
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		if(root==null) return res;
		TreeNode pre=null;
		
		while(root!=null||!stack.isEmpty()){
			if(root!=null){
				stack.push(root);
				root=root.left;
			}
			else{// have to keep record of the previous node
				TreeNode peek = stack.peek();
				if(peek.right!=null && pre!=peek.right){
					root = peek.right;
				}else{
					stack.pop();
					res.add((Integer) peek.val);
					pre = peek;//pre is the visited node
				}
			}
		}
		return res;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(7);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(6);
		root.left.right.left = new TreeNode(5);
		root.left.right.right = new TreeNode(11);
		
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(9);
		root.right.right.left = new TreeNode(4);
		root.right.right.right = new TreeNode(8);
	
		BinayTreePrinter.printNode(root);
		LinkedList<Integer> res = pre_order(root);
	}

}
