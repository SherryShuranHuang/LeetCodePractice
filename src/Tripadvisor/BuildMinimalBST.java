package Tripadvisor;
import java.util.ArrayList;
import java.util.LinkedList;
import datastructure.TreeNode;
import datastructure.ListNode;


public class BuildMinimalBST {

	static TreeNode createMinimalBST(int arr[], int start, int end){
		if(end <start){
			return null;
		}
	
	int mid = (start + end)/2;
	TreeNode n = new TreeNode(arr[mid]);
	//System.out.println(n.data);   //pre-order traversal
	n.left = createMinimalBST(arr, start, mid -1);
	//System.out.println(n.data); //in-order traversal
	n.right = createMinimalBST(arr, mid+1, end);
	System.out.println(n.val); //post-order traversal
	return n;
	}
	
	static TreeNode createMinimalBST(int arr[]){
		return createMinimalBST(arr, 0, arr.length - 1);
	}
	
	
	/**
	 * Creat a BT from a sorted list
	 * @param head
	 * @return
	 */
	public static TreeNode ListcreateMinimalBST(ListNode head){
		//TreeNode root = null;
		if(head==null) return null;
		int count =0;
		while(head!=null){
			head = head.next;
			count++;
		}
		
		ArrayList<ListNode> list = new ArrayList<ListNode>();
		list.add(head);
		
		return helper(list,0,count-1);
		
	}
	public static TreeNode helper(ArrayList<ListNode> list, int l, int r){
		if(l>r) return null;
		int m = (l+r)/2;
		TreeNode left = helper(list,l,m-1);
		TreeNode root = new TreeNode(list.get(0).val);
		root.left = left;
		list.set(0, list.get(0).next);
		root.right = helper(list,m+1,r);
		return root;
	}
	
//	public static TreeNode ListcreateMinimalBST(LinkedList<Integer> head){
//		//TreeNode root = null;
//		if(head==null) return null;
//		int count =0;
//		
//		ArrayList<LinkedList<Integer>> list = new ArrayList<LinkedList<Integer>>();
//		list.add(head);
//		
//		return helper(head,0,head.size()-1);
//		
//	}
//	public static TreeNode helper(LinkedList<Integer> list, int l, int r){
//		if(l>r) return null;
//		int m = (l+r)/2;
//		TreeNode left = helper(list,l,m-1);
//		TreeNode root = new TreeNode(list.get(0));
//		root.left = left;
//		list.set(0, list.get(0));
//		root.right = helper(list,m+1,r);
//		return root;
//	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5,6,7,8,9};
		//createMinimalBST(arr);
		ListNode head = new ListNode(3);
		head = head.append(5).append(8);
		TreeNode root = ListcreateMinimalBST(head);
		BinayTreePrinter.printNode(root);
	}

}
