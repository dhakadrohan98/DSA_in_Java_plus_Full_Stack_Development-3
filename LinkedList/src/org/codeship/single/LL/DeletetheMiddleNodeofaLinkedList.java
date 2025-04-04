package org.codeship.single.LL;

public class DeletetheMiddleNodeofaLinkedList {

	//TC: O(n/2)
	//SC: O(1)
	public ListNode deleteMiddle(ListNode head) {
        //base case
        if(head == null || head.next == null) {
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        fast = fast.next.next;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;   
        }
        slow.next = slow.next.next;
        return head;
    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//wrong algorithm by Rohan Dhakad
//public ListNode deleteMiddle(ListNode head) {
//    //base case-1
//    if(head.next == null) {
//        head = null;
//        return head;
//    }
//    //base case-II
//    if(head.next.next == null) {
//        head = head.next;
//        return head;
//    }
//    
//    ListNode slow = head;
//    ListNode fast = head.next.next;
//     
//    while(fast.next != null) {
//        slow = slow.next;
//        fast = fast.next.next;
//    }
//    
//    slow.next = slow.next.next;
//    return head;
//}
