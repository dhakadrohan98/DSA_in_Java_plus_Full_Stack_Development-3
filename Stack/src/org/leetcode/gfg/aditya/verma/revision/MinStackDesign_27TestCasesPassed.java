package org.leetcode.gfg.aditya.verma.revision;

import java.util.*;

// 27/31 test cases are passed
class Pair1 {
    int element;
    int min;

    public Pair1(int element, int min) {
        this.element = element;
        this.min = min;
    }
}

//TC: O(1)
//SC: O(n)
public class MinStackDesign_27TestCasesPassed {
	
	Stack<Pair1> st = null;
    List<Integer> mini = null;

    public MinStackDesign_27TestCasesPassed() {
        st = new Stack<>();
        mini = new ArrayList<>();
        //currently add Integer.MAX_VALUE
        mini.add(Integer.MAX_VALUE);
    }
    
    public void push(int val) {
        int lastElement = mini.get(mini.size() - 1);
        if(val <= lastElement) {
            mini.add(val);
        }
        st.push(new Pair1(val, mini.get(mini.size() - 1)));
    }
    
    public void pop() {
        //remove last element from the stack if & only if st.top.min == mini.last
        if(st.peek().element == st.peek().min) {
            mini.remove(mini.size() - 1);
        }
        st.pop();
    }
    
    public int top() {
        return st.peek().element;
    }
    
    public int getMin() {
        System.out.println(mini);
        if(mini.get(mini.size() - 1) == Integer.MAX_VALUE) {
            return 0;
        }

        return mini.get(mini.size() - 1);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
