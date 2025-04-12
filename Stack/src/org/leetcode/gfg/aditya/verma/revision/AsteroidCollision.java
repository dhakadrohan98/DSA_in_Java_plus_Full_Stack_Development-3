package org.leetcode.gfg.aditya.verma.revision;

import java.util.Stack;

// 245/275 test cases are passed
public class AsteroidCollision {

	//All test cases are passed
	//TC: O(n)
    //SC: O(n)
    public int[] asteroidCollision1(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
    
        for (int curr : asteroids) {
            boolean exploded = false;
            
            while (!st.isEmpty() && curr < 0 && st.peek() > 0) {
                int top = st.peek();
                if (Math.abs(curr) > top) { // |-8| > 7
                    st.pop(); // top asteroid explodes
                    // current might still need to collide more
                } else if (top == Math.abs(curr)) {
                    st.pop(); // both explode
                    exploded = true;
                    break;
                } else {
                    exploded = true; // current asteroid explodes
                    break;
                }
            }
            if (!exploded) {
                st.push(curr);
            }
            // if(curr < 0 && st.peek() > 0) {
            //     while(!st.isEmpty() && st.peek() > 0 && Math.abs(st.peek()) <= curr) {
            //         if(curr == Math.abs(st.peek())) {
            //             exploded = true;
            //             st.pop();
            //             break;
            //         }
            //         st.pop();
            //     }
            //     if(!st.isEmpty()) {
            //         //larger value is present at the top & curr element is exploded till now
            //         exploded = true;
            //     }
            // }
            // if (!exploded) {
            //     st.push(curr);
            // }
        }
        //copy stack elements into res array
        int[] res = new int[st.size()];
        int k = st.size() - 1;
        while(!st.isEmpty()) {
            res[k--] = st.pop();
        }
        return res;
    }
	
	//-------------------------------------------------------------------------------------
	// My idea: Moving from right to left
	// Correct idea: Move from left to right
	// TC: O(n)
	// SC: O(n)
	public int[] asteroidCollision(int[] arr) {
		int n = arr.length;
		Stack<Integer> st = new Stack<>();
		st.push(arr[n - 1]);
		for (int i = n - 2; i >= 0; i--) {
			// taking absolute value of curr element & top of the stack if stack is not
			// empty
			int abs1 = Math.abs(arr[i]);
			int abs2 = 0;
			if (!st.isEmpty()) {
				abs2 = Math.abs(st.peek());
			}
			// collision case
			if (arr[i] > 0 && !st.isEmpty() && st.peek() < 0) {
				if (abs1 < abs2) {
					continue;
				} else if (abs1 > abs2) {
					st.pop();
					st.push(arr[i]);
				} else {
					// arr[i] = st.peek();
					// same size asteroid will explode
					st.pop();
				}
			} else {
				// not a collision case
				st.push(arr[i]);
			}
		}
		System.out.println(st);
		// copy stack elements into res array
		int[] res = new int[st.size()];
		int k = 0;
		while (!st.isEmpty()) {
			res[k++] = st.pop();
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
