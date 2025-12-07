package payu.array;

public class FindDuplicateNumbers {

	public static int findDuplicate(int[] nums) {
		int n = nums.length;
		int slow = nums[0];
		int fast = nums[0];
		// initially move both pointers by 1 & 2 step otherwise slow == fast condition
		// will remain true from starting
		slow = nums[slow];
		fast = nums[nums[fast]];
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}
		// reset the fast to find the intersection point
		fast = nums[0];
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return fast;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, 4, 2, 2 };
		System.out.println(findDuplicate(nums));

	}

}
