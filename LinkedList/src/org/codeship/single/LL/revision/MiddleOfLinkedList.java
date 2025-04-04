package org.codeship.single.LL.revision;

public class MiddleOfLinkedList {
	
	//TC: O(n)
    //SC: O(1)
    public ListNode middleNode(ListNode head) {
        int cnt = 0;
        ListNode temp = head;
        while(temp != null) {
            cnt += 1;
            temp = temp.next;
        }
        int mid = 0;
        //size of ll is odd
        if(cnt % 2 != 0) {
            mid = (cnt + 1) / 2;
        } else {
            mid = cnt / 2;
        }
        temp = head;
        mid -= 1;
        while(mid != 0) {
            temp = temp.next;
            mid -= 1;
        }
        //in case of even size of ll, has to return 2nd middle
        if(cnt % 2 == 0) {
            return temp.next;
        }
        return temp;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
