package org.codeship.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AllocateBooksHard {

	//TC: O(log2 (sum - max + 1) * n) + O(n)
    //SC: O(1)
	
	public static int countStudents(ArrayList<Integer> list, int mid) {
		int count = 0, i = 0;
		
		while(i < list.size()) {
			int prefix = 0;
			prefix = prefix + list.get(i);
			
			if(prefix <= mid) {
				while(prefix <= mid && i < list.size()) {
					i++;
					if(i == list.size()) { //when i == 5
						break;
					}
					prefix = prefix + list.get(i);
				}
			} else {
				i++;
			}
			count++;
		}
		return count;
	}
	
	 public static int findPages(ArrayList<Integer> arr, int n, int m) {
	        // book allocation impossible
	        if (m > n)
	            return -1;

	        int low = Collections.max(arr);
	        int high = arr.stream().mapToInt(Integer::intValue).sum();
	        int ans = -1;
	        while (low <= high) {
	            int mid = (low + high) / 2;
	            int noOfStudents = countStudents(arr, mid);
	            if(noOfStudents == m) {
	            	ans = mid;
	            	high = mid - 1;
	            }
	            if (noOfStudents < m) {
	            	high = mid - 1;
	            } else {
	            	low = mid + 1;
	            }
	        }
	        return ans;
	    }  
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(25);
		list.add(46);
		list.add(28);
		list.add(49);
		list.add(24);
		int m = 4;
		int findPages = findPages(list, list.size(), m);
		System.out.println(findPages);
	}

}
