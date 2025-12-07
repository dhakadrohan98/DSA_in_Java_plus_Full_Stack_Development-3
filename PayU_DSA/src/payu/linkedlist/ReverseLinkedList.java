package payu.linkedlist;

public class ReverseLinkedList {
	
	public ListNode reverseList(ListNode head) {
        //base 
        //list will have only one node
        if(head == null || head.next == null) {
            return head;
        }
        ListNode further = head.next;
        ListNode curr = head;
        ListNode prev = null;
        while(further != null) {
            curr.next = prev;
            prev = curr;
            curr = further;
            further = further.next;
        }
        curr.next = prev;
        return curr;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
