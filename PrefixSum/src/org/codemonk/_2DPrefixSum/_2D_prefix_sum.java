package org.codemonk._2DPrefixSum;

import java.util.Scanner;

/**

## **Problem Statement: 2D Prefix Sum Queries**

You are given a two-dimensional grid of integers consisting of ( n ) rows and ( n ) columns. Your task is to process ( q ) queries of the following type:

For each query, you are given four integers ( y_1, x_1, y_2, x_2 ), and you must calculate the sum of all elements inside the rectangle whose top-left corner is ((y_1, x_1)) and bottom-right corner is ((y_2, x_2)).

---

### **Input**

The first line contains three integers ( n ) and ( q ) — the height, width, and number of queries.
The next ( n ) lines each contain ( n ) integers, describing the grid values.
Finally, the next ( q ) lines each contain four integers ( y_1, x_1, y_2, x_2 ), describing a query.

---

### **Output**

For each query, print the sum of the elements in the given subrectangle.

### **Example**

**Input:**

```
4 5 3
1 2 3 4 5
3 4 5 6 7
7 8 9 10 11
11 12 13 14 15
2 3 3 4
1 1 4 5
3 2 3 2
```

**Output:**

```
30
120
8
```

---

Would you like me to include a short **“Explanation”** section (like how some CSES problems have one in their editorial) describing how prefix sums are used to solve it efficiently?

 */
public class _2D_prefix_sum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//take inputs
		int N = sc.nextInt();
		int[][] arr = new int[N+1][N+1];
		for(int i = 1; i < N+1; i++) {
			for(int j = 1; j < N+1; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int[][] pSum = new int[N+1][N+1]; 
		//calculate 2d prefix sum
		for(int i = 1; i < N+1; i++) {
			for(int j = 1; j < N+1; j++) {
				pSum[i][j] = arr[i][j] + pSum[i-1][j] + pSum[i][j-1] - pSum[i-1][j-1];
			}
		}
		int q = sc.nextInt();
		while(q-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			long res = pSum[c][d] - pSum[a-1][d] - pSum[c][b-1] + pSum[a-1][b-1];
			System.out.println(res);
		}

	}

}
