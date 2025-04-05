package org.codeship.single.LL.revision;

public class PalidromeLinkedList {
	
	//TC: O(n/2) + O(n) + O(n/2) = O(2n)
    //SC: O(1)
    private ListNode getMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = null;
        if(slow.next != null) {
            fast = slow.next;
        }
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

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

    public boolean isPalindrome(ListNode head) {
        //edge cases
        //list size is 1
        if(head != null && head.next == null) {
            return true;
        }

        //list size is 2
        if(head != null && head.next != null && head.next.next == null) {
            if(head.val == head.next.val) {
                return true;
            }
            return false;
        }

        ListNode middleNode = getMiddleNode(head);
        ListNode nextNode = middleNode.next;
        middleNode.next = null;
        ListNode secondListHead = reverseList(nextNode);
        middleNode.next = secondListHead;
        ListNode temp1 = head;
        ListNode temp2 = secondListHead;
        while(temp2 != null) {
            if(temp1.val != temp2.val) {
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
