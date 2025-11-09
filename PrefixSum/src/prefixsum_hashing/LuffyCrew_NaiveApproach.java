package prefixsum_hashing;

import java.util.Scanner;

public class LuffyCrew_NaiveApproach {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int N = sc.nextInt();
			int Q = sc.nextInt();
			String s = sc.next();
			
			while(Q-- > 0) {
				int l = sc.nextInt();
				int r = sc.nextInt();
				int[] hash = new int[26];
				l--;
				r--;
				//make a freq map for a-z(0-25) characters
				for(int i = l; i <= r; i++) {
					char ch = s.charAt(i);
					hash[ch - 'a']++;
				}
				int oddCnt = 0;
				for(int i = 0; i < 26; i++) {
					if(hash[i] % 2 != 0) {
						oddCnt += 1;
					}
				}
				if(oddCnt > 1) {
					System.out.println("No");
				} else {
					System.out.println("Yes");
				}
			}
			
		}

	}

}
