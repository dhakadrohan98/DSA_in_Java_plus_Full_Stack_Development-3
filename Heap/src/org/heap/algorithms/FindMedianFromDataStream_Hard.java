package org.heap.algorithms;

import java.util.*;

public class FindMedianFromDataStream_Hard {

	Queue<Integer> left_max_heap;
	Queue<Integer> right_min_heap;

	public FindMedianFromDataStream_Hard() {
		left_max_heap = new PriorityQueue<>((a, b) -> b - a);
		right_min_heap = new PriorityQueue<>();
	}

	public void addNum(int num) {
		if (left_max_heap.size() == 0 || num < left_max_heap.peek()) {
			left_max_heap.offer(num);
		} else {
			right_min_heap.offer(num);
		}
		// always maintain max_left_heap's size equal or one greater than the size of
		// min_right_heap
		if (left_max_heap.size() > right_min_heap.size() + 1) {
			right_min_heap.offer(left_max_heap.poll());
		} else if (right_min_heap.size() > left_max_heap.size()) {
			left_max_heap.offer(right_min_heap.poll());
		}
	}

	public double findMedian() {
		// Total even number of elements
		if (left_max_heap.size() == right_min_heap.size()) {
			double mean = ((double) (left_max_heap.peek() + right_min_heap.peek())) / 2.0;
			return mean;
		}
		// Total odd number of elements
		return left_max_heap.peek();
	}

}
