package datastructure;



// Definition for singly-linked list.
 public class ListNode {
     public int val;
     public ListNode next;
     public ListNode(int x) {
         val = x;
         next = null;
     }
     
     public ListNode append(int val){
    	 ListNode end = new ListNode(val);
    	 ListNode n = this;
 		while(n.next != null){
 			n = n.next;
 		}
 		n.next = end;
 		return this;
 	}
 }
