package org.fenwick;

public class BinaryLifting_FenwickTree {
	
	//TC: O(logn)
	//SC: O(1)
	public static int binaryLifting_LowerBound(int[] fen, int k) {
		int n = fen.length - 1; //fen[0] unused
		int pos = 0;
		int sum = 0;
//		int LOG = 31 - Integer.numberOfLeadingZeros(n);
		
		//i = 2^20 exceeds n = 10^6
		for(int i = (int)Math.log(n); i >= 0; i--) {
			int next = pos + (1 << i);
			if(next <= n && sum + fen[next] < k) {
				sum += fen[next];
				pos = next;
			}
		}
		return pos + 1;
	}
	
	//TC: O(logn)
		//SC: O(1)
		public static int binaryLifting_LowerBound_AnotherVersion(int[] fen, int k) {
			int n = fen.length - 1;
			int pos = 0;
			int sum = 0;
			int bit = Integer.highestOneBit(n);
			
			//i = 2^20 exceeds n = 10^6
			while(bit != 0) {
				int next = pos + bit;
				if(next <= n && sum + fen[next] < k) {
					sum += fen[next];
					pos = next;
				}
				bit = bit >> 1; //2^4 -> 2^8 -> (shifting all bits by one position to its right)
			}
			return pos + 1;
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
