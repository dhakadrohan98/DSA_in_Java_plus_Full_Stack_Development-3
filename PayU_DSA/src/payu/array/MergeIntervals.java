package payu.array;

import java.util.*;

//Note- careful observation required in logic building
//highly optimal sol
public class MergeIntervals {
	
	//TC: O(nlogn) + O(n*2)
	//SC: O(n*2)
	public static int[][] mergeOverlappingIntervals(int[][] arr) {
		int m = arr.length; // num of interval pair
		// edge case
		if (m == 1) {
			return arr;
		}

		List<List<Integer>> list = new ArrayList<>();
		List<List<Integer>> ans = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			List<Integer> temp = new ArrayList<>();
			temp.add(arr[i][0]);
			temp.add(arr[i][1]);
			list.add(temp);
		}

		// sort the list of list
		Collections.sort(list, (l1, l2) -> {
			if (l1.get(0) == l2.get(0)) { // if start are equal
				return l1.get(1) - l2.get(1); // compare end
			}
			return l1.get(0) - l2.get(0); // compare start
		});

		// core logic
		int x1 = -1;
		int x2 = -1;
		int y1 = -1;
		int y2 = -1;
		int i = 0, j = 1;

		while (j < m) {
//			System.out.println("i: " + i);
			List<Integer> list1 = list.get(i);
			List<Integer> list2 = list.get(j);
			x1 = list1.get(0);
			x2 = list1.get(1);
			y1 = list2.get(0);
			y2 = list2.get(1);
			while (j < m && y1 <= x2) {
				// update coordinates
				x1 = x1;
				x2 = Math.max(x2, y2);
//				System.out.println("j: " + j);
				j += 1;
				if (j < m) {
					list2 = list.get(j);
					y1 = list2.get(0);
					y2 = list2.get(1);
				}
			}
			// put that into ans list
			List<Integer> tempAns = new ArrayList<>();
			tempAns.add(x1);
			tempAns.add(x2);
			ans.add(tempAns);
			i = j;
			j += 1;
		}
		
		if(i < m) {
			List<Integer> list1 = list.get(i);
			List<Integer> tempAns = new ArrayList<>();
			tempAns.add(list1.get(0));
			tempAns.add(list1.get(1));
			ans.add(tempAns);
		}
//		System.out.println(ans);
		
		//copy ans list elements into new 2d array back to return the result
		//update the number of result set intervals
		int size = ans.size();
		int[][] result = new int[size][2];
		for(int k = 0; k < size; k++) {
			List<Integer> tempAns = ans.get(k);
			result[k][0] = tempAns.get(0);
			result[k][1] = tempAns.get(1);
		}
		return result;

	}

	public static void main(String[] args) {
		int[][] arr1 = {
				{1,3} , {2,6}, {8,9}, {9,11}, {8,10}, {2,4}, {15,18}, {16, 17}
		};
		int[][] arr2 = {
				{1,3}, {2,6}, {8,10}, { 15,18}
		};
		
		int[][] result = mergeOverlappingIntervals(arr2);
		for(int[] temp: result) {
			for(int val : temp) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
		
	}

}
