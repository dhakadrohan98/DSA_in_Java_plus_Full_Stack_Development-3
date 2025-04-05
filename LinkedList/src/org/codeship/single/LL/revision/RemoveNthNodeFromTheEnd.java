package org.codeship.single.LL.revision;

public class RemoveNthNodeFromTheEnd {
	
	//TC: O(n)
    //SC: O(1)
    private int size(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while(temp != null) {
            count += 1;
            temp = temp.next;
        }
        return count;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //edge case
        //if list has one node, it has to be removed.
        if(head != null && head.next == null && n == 1) {
            return null;
        }

        int length = size(head);
        // 0 based index
        int start_index = length - n;
        ListNode temp = head;
        int count = 0;
        //special case : [1->2] , n = 2
        if(start_index == 0) {
            return head.next;
        }
        while(count++ < start_index -1 && temp != null) {
            temp = temp.next;
        }
        if(temp != null & temp.next != null) {
            temp.next = temp.next.next;
        }
        return head;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
