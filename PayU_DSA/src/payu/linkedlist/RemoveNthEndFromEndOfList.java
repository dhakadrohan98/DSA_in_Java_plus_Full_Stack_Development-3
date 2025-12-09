package payu.linkedlist;

public class RemoveNthEndFromEndOfList {

	 //TC: O(2n)
    //SC: O(1)
    public int calculateLength(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while(temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //edge case
        if(head.next == null && n == 1) {
            return null;
        }
        ListNode temp = head;
        int i = 1;
        int length = calculateLength(head);
        //if nth element(from end) is equal to first element of LL, then move head one step ahead & return it
        if(length == n) {
            return head.next;
        }
        System.out.println(length);
        while(i < length - n) {
            temp = temp.next;
            i++;
        }
        if(temp != null && temp.next != null) {
            temp.next = temp.next.next;
        }
        return head;
        
    }

}
