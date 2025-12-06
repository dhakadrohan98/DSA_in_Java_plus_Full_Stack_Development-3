package payu.array;

public class SortColors_DutchFlag {

	// TC: O(n)
	// SC:O(1) - in place algo
	public void sortColors(int[] nums) {
		int n = nums.length;
		int i = 0, j = 0, k = n - 1;
		while (j <= k) {
			if (nums[j] == 0) {
				swap(nums, i, j);
				i++;
				j++;
			} else if (nums[j] == 1) {
				j++;
			} else if (nums[j] == 2) {
				swap(nums, j, k);
				k--;
			}
		}
		return;
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
