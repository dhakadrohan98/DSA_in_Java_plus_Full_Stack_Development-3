package org.codeship;

import java.util.*;

public class PartitionLabels {

	// TC: O(n)
	// SC: O(1)
	public List<Integer> partitionLabels(String s) {
		List<Integer> res = new ArrayList<>();
		int n = s.length();
		// store only last(right most) index of each character into char map
		int[] map = new int[26];
		for (int i = 0; i < n; i++) {
			int key = s.charAt(i) - 'a';
			map[key] = i;
		}
		int i = 0;
		while (i < n) {
			int j = i;
			int lastIndex = map[s.charAt(i) - 'a'];
			// how to break when first partition is met
			// [0, 8] [9, 15] [16, 23]
			// Step 2: Expand partition until we include all last occurrences of chars seen
			// so far
			while (j < lastIndex) {
				char ch = s.charAt(j);
				int key = ch - 'a';
				// updating last index for curr char in the partition so that we can increas the
				// size of curr partition
				lastIndex = Math.max(lastIndex, map[ch - 'a']);
				j++;
			}
			// calculate partition length
			res.add(lastIndex - i + 1);
			i = lastIndex + 1;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
