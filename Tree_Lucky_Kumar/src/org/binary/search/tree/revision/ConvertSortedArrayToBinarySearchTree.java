package org.binary.search.tree.revision;

public class ConvertSortedArrayToBinarySearchTree {
	//TC: O(n)
	//SC: O(n)
	public TreeNode sortedArrayToBST(int[] nums) {
		int low = 0, high = nums.length - 1;
		return buildTree(low, high, nums);
	}

	private TreeNode buildTree(int low, int high, int[] nums) {
		// base case
		if (low < 0 || high >= nums.length || low > high)
			return null;
		int mid = (low + high) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = buildTree(low, mid - 1, nums);
		root.right = buildTree(mid + 1, high, nums);
		return root;
	}
}
