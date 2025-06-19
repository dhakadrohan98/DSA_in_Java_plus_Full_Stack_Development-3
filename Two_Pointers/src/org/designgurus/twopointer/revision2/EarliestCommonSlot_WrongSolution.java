package org.designgurus.twopointer.revision2;

import java.util.List;

public class EarliestCommonSlot_WrongSolution {

	//TC: O(n)
	//SC: O(1)
	public int[] commonSlot(List<int[]> a, List<int[]> b, int duration) {
		// code here
		int n = a.size();
		int m = b.size();
		int min = Math.min(n, m);
		int[] ans = new int[2];
		for (int i = 0; i < min; i++) {
			int s1 = a.get(i)[0];
			int e1 = a.get(i)[1];
			int s2 = b.get(i)[0];
			int e2 = b.get(i)[1];
			// overlapping conditions
			if (s2 < e1) {
				int diff = e1 - s2;
				if (diff >= duration) {
					ans[0] = s2;
					ans[1] = s2 + duration;
					break;
				}
			}

			if (s2 < s1) {
				int diff = e2 - s1;
				if (diff >= duration) {
					ans[0] = s1;
					ans[1] = s1 + duration;
					break;
				}
			}

			if (e2 < e1) {
				int diff = e2 - s2;
				if (diff >= duration) {
					ans[0] = s2;
					ans[1] = s2 + duration;
					break;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
