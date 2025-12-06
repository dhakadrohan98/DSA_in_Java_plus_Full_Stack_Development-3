package payu.twopointer;

//Hard LC
public class TrappingRainWater_Hard {

	// TC: O(3n)
	// SC: O(2n)
	public int trap(int[] arr) {
		int n = arr.length;
		int[] leftMax = new int[n];
		int maxi = arr[0];
		leftMax[0] = arr[0];
		for (int i = 1; i < n; i++) {
			maxi = Math.max(maxi, arr[i]);
			leftMax[i] = maxi;
		}
		int[] rightMax = new int[n];
		maxi = arr[n - 1];
		rightMax[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			maxi = Math.max(maxi, arr[i]);
			rightMax[i] = maxi;
		}

		int totalWater = 0;
		// calculate amount of water
		// amout of water will be trapped in rectangle shaped area b/w two buildings
		for (int i = 0; i < n; i++) {
			int breadth = Math.min(leftMax[i], rightMax[i]);
			int amountOfWater = Math.abs(arr[i] - breadth);
			totalWater += amountOfWater;
		}
		return totalWater;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
