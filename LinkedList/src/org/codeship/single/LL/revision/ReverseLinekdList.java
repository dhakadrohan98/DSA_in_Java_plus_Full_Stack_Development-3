package org.codeship.single.LL.revision;

public class ReverseLinekdList {
	//TC: O(n)
    //SC: O(3) = O(1)
    public ListNode reverseList(ListNode head) {
        //base case
        if(head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode nextt = head.next;
        while(nextt != null) {
            curr.next = prev;
            prev = curr;
            curr = nextt;
            nextt = nextt.next; 
        }
        curr.next = prev;
        return curr;
    }
}
