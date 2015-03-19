

// Definition for singly-linked list.
 public class ListNode {
     int val;
     ListNode next; 

     
     ListNode(int x) {
         val = x;
         next = null;
     }
     
     public ListNode add(int x){
    	 ListNode end = new ListNode(x);
    	 ListNode n = this;
    	 while(n.next!=null){
    		 n=n.next;
    	 }
    	 n.next=end;
    	 return this;
     }
 }
