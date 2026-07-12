package org.slidingwindow.variablesize.revision3;

public class LargestSubarrayOfSumK {
	
	//TC: O(n)
	//SC: O(1)
	public static int largestSubarray(int[] arr, int k) {
		int n = arr.length;
		int maxLen = 0;
		int sum = 0;
		int i = 0, j = 0;
		while(j < n) {
			//some calc
			sum += arr[j];
			if(sum < k) {
				j++;
			}
			else if(sum == k) {
				maxLen = Math.max(maxLen, j-i+1);
				j++;
			}
			else if(sum > k) {
				while(i < n && sum > k) {
					sum -= arr[i];
					i++;
				}
				//potentially we might have found the ans again
				if(sum == k) {
					maxLen = Math.max(maxLen, j-i+1);
				}
				j++;
			}
		}
		return maxLen;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {4, 1, 1, 1, 2, 3, 5};
		int k = 5;
		System.out.println(largestSubarray(arr, k));

	}

}
