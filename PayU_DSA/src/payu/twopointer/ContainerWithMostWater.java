package payu.twopointer;

public class ContainerWithMostWater {

	// TC: O(n)
	// SC: O(1)
	public int maxArea(int[] height) {
		int n = height.length;
		int maxWater = 0;
		int i = 0;
		int j = n - 1;
		while (i < j) {
			int length = Math.min(height[i], height[j]);
			int breadth = j - i;
			maxWater = Math.max(maxWater, length * breadth);
			if (height[i] <= height[j]) {
				i++;
			} else {
				j--;
			}
		}
		return maxWater;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
