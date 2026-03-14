package org.heap.algorithms;

import java.util.Arrays;
import java.util.PriorityQueue;

// (32/39) test cases are passed
public class SingleThreadedCPU {

	class Pair {
		int process_time;
		int indx;

		Pair(int process_time, int indx) {
			this.process_time = process_time;
			this.indx = indx;
		}
	}

	public int[] getOrder(int[][] tasks) {
		int n = tasks.length;
		int[] ans_array = new int[n];
		int ans_indx = 0;
		int[][] third_arr = new int[n][3];

		// make new array for sorting {enqueue_t, process_t, indx}
		for (int i = 0; i < n; i++) {
			third_arr[i][0] = tasks[i][0];
			third_arr[i][1] = tasks[i][1];
			third_arr[i][2] = i;
		}
//	        a = third_arr[i]
//	        b = third_arr[j]
		// sort the new array based on enqueue time in asc order, if enqueue time is
		// same for 2 rows then sort on the basis of
		// their index.
		Arrays.sort(third_arr, (a, b) -> {
			if (a[0] == b[0]) {
				// sort on the basis of index
				return Integer.compare(a[2], b[2]);
			}
			return Integer.compare(a[0], b[0]);
		});
		// Pair -> {process_time, indx}
		PriorityQueue<Pair> pq = new PriorityQueue<>((a1, a2) -> {
			if (a1.process_time == a2.process_time) {
				return a1.indx - a2.indx;
			}
			return a1.process_time - a2.process_time;
		});

		// Initialize curr time with first element enqueue time
		int currTime = third_arr[0][0];
		// insert all the tasks at start time of first tasks
//	        pq.offer(new Pair(third_arr[0][1], third_arr[0][2]));
		int j = 0;

		while (!pq.isEmpty()) {
			while (j < n && third_arr[j][0] <= currTime) {
				pq.offer(new Pair(third_arr[j][1], third_arr[j][2]));
				j++;
			}
				Pair pair = pq.poll();
				int process_time = pair.process_time;
				int indx = pair.indx;
				ans_array[ans_indx++] = indx;
				currTime += process_time;
		}
		return ans_array;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] tasks1 = { { 1, 2 }, { 2, 4 }, { 3, 2 }, { 4, 1 } };
		SingleThreadedCPU obj = new SingleThreadedCPU();
		int[] ans1 = obj.getOrder(tasks1);
		for (int num : ans1) {
			System.out.print(num + " ");
		}
		System.out.println("\nTest case2:");

		int[][] tasks2 = { { 7, 10 }, { 7, 12 }, { 7, 5 }, { 7, 4 }, { 7, 2 } };
		int[] ans2 = obj.getOrder(tasks2);
		for (int num : ans2) {
			System.out.print(num + " ");
		}
		System.out.println("\nTest case3:");
//		
		int[][] tasks3 = {{5,2}, {7,2}, {9,4}, {6,3}, {5,10}, {1,1}};
		int[] ans3 = obj.getOrder(tasks3);
		for(int num: ans3) {
			System.out.print(num + " ");
		}

	}

}
