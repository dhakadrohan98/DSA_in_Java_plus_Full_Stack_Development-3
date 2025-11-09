package prefixsum_hashing;

import java.util.Scanner;

/**
 * problem statement:
You are given a string that contains lowercase alphabets. There are queries of the form 
.Your task is to determine if every character in the range can be arranged in such a manner that a palindromic substring for 
that range can be formed. If it is possible to create the palindrome substring in the provided interval, then print Possible. 
Otherwise, print Impossible.
Note: The original string is not changed in the process.
 */

public class LuffyCrew_PrefixHashing_Hard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int N = sc.nextInt();
			int Q = sc.nextInt();
			String s = sc.next();
			// s -> abcec
			int[][] hash = new int[N + 10][26];
			// store count for each character of string at its i^th index (a-1 | z-26)
			// a(1) -> {1,0,0,0,0,----,0}
			// b(2) -> {0,1,0,0,0,----,0}
			// c(3) -> {0,0,1,0,0,----,0}
			// e(4) -> {0,0,0,0,1,----,0}
			// c(5) -> {0,0,1,0,0,----,0}

			for (int i = 0; i < N; i++) {
				hash[i + 1][s.charAt(i) - 'a'] += 1; // understandable
			}
			// build prefix sum for each character -- not able to understand it completely
			// from code lines
			for (int i = 0; i < 26; i++) {
				for (int j = 1; j <= N; j++) {
					hash[j][i] += hash[j - 1][i];
				}
			}

			while (Q-- > 0) {
				int l = sc.nextInt();
				int r = sc.nextInt();
				int oddCnt = 0;
				for (int i = 0; i < 26; i++) {
					int charCt = hash[r][i] - hash[l - 1][i];
					if (charCt % 2 != 0) {
						oddCnt += 1;
					}
				}
				if (oddCnt > 1) {
					System.out.println("Impossible");
				} else {
					System.out.println("possible");
				}
			}

		}
	}

}

/**
input-
2
5 5
abcec
1 2
2 5
3 5
1 5
1 4
5 5
aabbc
1 2
2 5
3 5
1 5
1 4
*/
