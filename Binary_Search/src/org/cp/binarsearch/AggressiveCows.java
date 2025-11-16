package org.cp.binarsearch;

import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {

	static int N;
	static int cows;
	static long[] positions;

	public static boolean canCowsPlaced(long minDist) {
		int cows_cnt = cows;
		long last_pos = -1; // for first cow to be places at S[0] stall
		for (int i = 0; i < N; i++) {
			if (positions[i] - last_pos >= minDist || last_pos == -1) {
				cows_cnt--;
				last_pos = positions[i];
			}
			if (cows_cnt == 0)
				break;
		}
		return cows_cnt == 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			N = sc.nextInt();
			cows = sc.nextInt();
			positions = new long[N];
			long max = 0;
			for (int i = 0; i < N; i++) {
				positions[i] = sc.nextLong();
				max = Math.max(max, positions[i]);
			}
			//sort the given array to make it monotonic
			Arrays.sort(positions);
			// predicate functions - canCowsPlaced(x)
			// TTTTTTTFFFFFFF
			// apply bs
			long low = 0, high = max, mid;
			while (high - low > 1) {
				mid = (low + high) / 2;
				if (canCowsPlaced(mid)) {
					// TTT->TFFF
					low = mid;
				} else {
					// T<-FFF
					high = mid - 1;
				}
			}
			if (canCowsPlaced(high)) {
				System.out.println(high);
			} else {
				System.out.println(low);
			}
		}

	}

}
