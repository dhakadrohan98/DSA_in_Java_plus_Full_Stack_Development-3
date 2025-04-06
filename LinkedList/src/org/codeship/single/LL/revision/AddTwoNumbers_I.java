package org.codeship.single.LL.revision;

public class AddTwoNumbers_I {
	
	 //TC: O(l1 + l2)
    //SC: O(l1 + l2 + 1(constant))
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode dummyNode = new ListNode(-1);
        ListNode prev = dummyNode;
        int carry = 0;
        ListNode head = dummyNode;
        while(temp1 != null && temp2 != null) {
            int sum = temp1.val + temp2.val + carry;
            ListNode curr = new ListNode(sum % 10);
            carry = sum / 10;
            //preserve the head of new list for first time
            if(prev.val == -1) {
                head = curr;
            }
            prev.next = curr;
            prev = curr;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        //if temp2 is exhausted
        while(temp1 != null) {
            int sum = temp1.val + carry;
            ListNode curr =  new ListNode(sum % 10);
            carry = sum / 10;
            prev.next = curr;
            prev = curr;
            temp1 = temp1.next;
        }
        //if temp1 is exhausted
        while(temp2 != null) {
            int sum = temp2.val + carry;
            ListNode curr =  new ListNode(sum % 10);
            carry = sum / 10;
            prev.next = curr;
            prev = curr;
            temp2 = temp2.next;
        }
        //if carry are remaining at the last
        if(carry != 0) {
            ListNode curr = new ListNode(carry);
            prev.next = curr;
            prev = curr;
            carry = 0;
        }
        return head;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
