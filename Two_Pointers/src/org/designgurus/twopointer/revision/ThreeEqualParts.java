package org.designgurus.twopointer.revision;

public class ThreeEqualParts {

	// TC: O(n)
	// SC: O(1)
	// solution is very tricky
	public int[] threeEqualParts(int[] arr) {
		int[] ans = new int[] { -1, -1 };

		// count no. of 1s
		int numOf1s = 0;
		for (int c1 : arr) {
			numOf1s += c1;
		}

		if (numOf1s == 0) {
			return new int[] { 0, 2 };
		}
		// dividing into three equal parts is not possible
		if (numOf1s % 3 != 0) {
			return ans;
		}

		int noOfOnesInEachPart = numOf1s / 3;
		int indexOfFirst1InPart0 = -1;
		int indexOfFirst1InPart1 = -1;
		int indexOfFirst1InPart2 = -1;
		numOf1s = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1) {
				numOf1s++;
				if (numOf1s == 1) {
					indexOfFirst1InPart0 = i;
				} else if (numOf1s == noOfOnesInEachPart + 1) {
					indexOfFirst1InPart1 = i;
				} else if (numOf1s == (2 * noOfOnesInEachPart) + 1) {
					indexOfFirst1InPart2 = i;
				}
			}
		}
		int a = indexOfFirst1InPart0;
		int b = indexOfFirst1InPart1;
		int c = indexOfFirst1InPart2;

		while (c < arr.length) {
			if (arr[c] == arr[a] && arr[c] == arr[b]) {
				c++;
				a++;
				b++;
			} else {
				// dividing into three equal parts is not possible
				return ans;
			}
		}

		return new int[] { a - 1, b };
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
