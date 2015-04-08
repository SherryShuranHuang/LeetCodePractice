package leetcode;

public class LinkedListNode {
	int val;
	char data;
	LinkedListNode next = null;
	//LinkedListNode previous = null;
	
	LinkedListNode(int value){
		val = value;
	}
	
	LinkedListNode(char value){
		data = value;
	}
	
//	public void append(int val){
//		LinkedListNode end = new LinkedListNode(val);
//		LinkedListNode n = this;
//		while(n.next != null){
//			n = n.next;
//		}
//		n.next = end;
//	}
	
	public LinkedListNode append(int val){
		LinkedListNode end = new LinkedListNode(val);
		LinkedListNode n = this;
		while(n.next != null){
			n = n.next;
		}
		n.next = end;
		return this;
	}
	
	public LinkedListNode deleteNode(int val){
		LinkedListNode n = this;
		
		if(n.data == val){
			return n.next;
		}
		
		while(n.next != null){
			if(n.next.data == val){
				n.next = n.next.next;
				return n;
			}
			n = n.next;
		}
		
		return n;
	}
	public LinkedListNode getNext(){
		LinkedListNode n = this;
		while(n.next != null){
			n = n.next;
		}
		return n;
	}
	public int size(){
		LinkedListNode n =this;
		int count = 0;
		while(n.next!= null){
			count++;
		}
		return count;
	}
	
//	public LinkedListNode deleteMidNode(){
//		LinkedListNode current = new LinkedListNode(0);
//		LinkedListNode runner = new LinkedListNode(0);
//		
//		current = this;
//		runner = this;
//
//		while(runner.next.next != null){
//			runner = runner.next.next;
//			if(runner.next != null)
//				current = current.next;
//		}
//		current.next = current.next.next;
//		
//		return this;
//	}


}
