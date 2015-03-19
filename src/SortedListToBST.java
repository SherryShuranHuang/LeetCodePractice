import java.util.ArrayList;
import datastructure.BinayTreePrinter;

import datastructure.TreeNode;
public class SortedListToBST {

	public static TreeNode sortedListToBST(ListNode head) {  
	    if(head == null)  
	        return null;  
	    ListNode cur = head;  
	    int count = 0;  
	    while(cur!=null)  
	    {  
	        cur = cur.next;  
	        count++;  
	    }  
	    ArrayList<ListNode> list = new ArrayList<ListNode>();  
	    list.add(head);  
	    return helper(list,0,count-1);  
	}  
	private static TreeNode helper(ArrayList<ListNode> list, int l, int r)  
	{  
	    if(l>r)  
	        return null;  
	    int m = (l+r)/2;  
	    
	    TreeNode left = helper(list,l,m-1);  
	    TreeNode root = new TreeNode(list.get(0).val);  
	    root.left = left;  
	    list.set(0,list.get(0).next);  
	    //BinayTreePrinter.printNode(root);
	    root.right = helper(list,m+1,r);  

	    //BinayTreePrinter.printNode(root);
	    return root;  
	}  

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
//		head.next = new ListNode(2);
//		head.next.next = new ListNod
		head.add(2).add(3).add(4).add(5);
		
		TreeNode root = sortedListToBST(head);
		BinayTreePrinter.printNode(root);
	}

}
