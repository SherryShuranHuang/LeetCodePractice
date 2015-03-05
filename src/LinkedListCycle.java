//
//public class LinkedListCycle {
//	public ListNode detectCycle(ListNode head) {
//        if(head == null || head.next == null) return null;
//        
//        ListNode walker = head;
//        ListNode runner = head;
//        
//        while(runner != null || runner.next !=null){
//            walker = walker.next;
//            runner = runner.next.next;
//            if(walker == runner){
//                break;
//            } 
//        }
//        if(walker != runner) return null;
//        
//        walker = head;
//        while(walker != runner){
//            walker = walker.next;
//            runner = runner.next;
//        }
//        
//        return walker;
//        
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}
