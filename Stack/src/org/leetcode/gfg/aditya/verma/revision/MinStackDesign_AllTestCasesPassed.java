package org.leetcode.gfg.aditya.verma.revision;

import java.util.Stack;

public class MinStackDesign_AllTestCasesPassed {
	Stack<Pair1> st = null;

    public MinStackDesign_AllTestCasesPassed() {
        st = new Stack<>();
    }

    public void push(int val) {
        int min = st.isEmpty() ? val : Math.min(val, st.peek().min);
        st.push(new Pair1(val, min));
    }

    public void pop() {
        st.pop();
    }

    public int top() {
        return st.peek().element;
    }

    public int getMin() {
        return st.peek().min;
    }
}
