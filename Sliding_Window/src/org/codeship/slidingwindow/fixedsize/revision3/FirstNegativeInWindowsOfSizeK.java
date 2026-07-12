package org.codeship.slidingwindow.fixedsize.revision3;

import java.util.*;

public class FirstNegativeInWindowsOfSizeK {

	//TC: O(n)
	//SC: O(n)
	public static List<Integer> firstNegInt(int arr[], int k) {
		List<Integer> negList = new ArrayList<>();
		List<Integer> ansList = new ArrayList<>();
		int i = 0, j = 0, n = arr.length;
		
		while(j < n) {
			//do some calculations
			if(arr[j] < 0) {
				negList.add(arr[j]);
			}
			if(j-i+1 < k) {
				j++;
			} else if(j-i+1 == k) {
				//calculate ans
				if(!negList.isEmpty()) {
					ansList.add(negList.get(0));
				} else {
					ansList.add(0);
				}
				//remove calculation for i
				if(negList.contains(arr[i])) {
					negList.remove(0);
				}
				//slide the window
				i++;
				j++;
				
			}
		}
		return ansList;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
		int k = 3;
		System.out.println(firstNegInt(arr, k));

	}

}
