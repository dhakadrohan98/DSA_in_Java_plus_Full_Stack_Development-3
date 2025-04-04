package org.codeship.single.LL;

import java.util.HashMap;
import java.util.Map;

public class FindLengthOfLoop {

	public static int lengthOfLoop(ListNode head) {
		int timer = 1;
		Map<ListNode, Integer> hmap = new HashMap<>();
        ListNode temp = head;
		
        while(temp != null) {
        	if(hmap.containsKey(temp)) {
        		int value = hmap.get(temp);
        		return (timer-value);
        	} else {
        		hmap.put(temp, timer);
        		timer++;
        		temp = temp.next;
        	}
        }
        return 0;
        
    }

      public static int findLength(ListNode slow, ListNode fast) {
        int count = 1;
        slow = slow.next;

        while(slow != fast) {
            count++;
            slow = slow.next;
        }
        return count;
    }
      
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/*
  public static int lengthOfLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null || fast.next.next != null) {
            if(slow == fast) {
                return findLength(slow, fast);
            }
        }
        return 0;
    }

      public static int findLength(ListNode slow, ListNode fast) {
        int count = 1;
        slow = slow.next;

        while(slow != fast) {
            count++;
            slow = slow.next;
        }
        return count;
    }
    
 */
