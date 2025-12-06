package payu.array;

public class ProductOfArrayExceptItself {
	
	//TC: O(3n)
	//SC: O(2n)
	public static int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int[] preArr = new int[n];
		preArr[0] = nums[0];
		for (int i = 1; i < n; i++) {
			preArr[i] = preArr[i - 1] * nums[i];
		}
		//print prefix array
		for(int num : preArr) {
			System.out.print(num + " ");
		}
		System.out.println("suffix array");
		
		int[] suffArr = new int[n];
		suffArr[n - 1] = nums[n-1];
		for (int i = n - 2; i >= 0; i--) {
			suffArr[i] = suffArr[i + 1] * nums[i];
		}
		for(int num : suffArr) {
			System.out.print(num + " ");
		}
		
		int[] ans = new int[n];
		ans[0] = 1 * suffArr[1];
		ans[n - 1] = 1 * preArr[n - 2];
		for (int i = 1; i < n - 1; i++) {
			ans[i] = preArr[i - 1] * suffArr[i + 1];
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5};
		int[] ans = productExceptSelf(nums);
		System.out.println("product array");
		for(int num : ans) {
			System.out.print(num + " ");
		}
	}

}
