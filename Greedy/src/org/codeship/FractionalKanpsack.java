package org.codeship;

import java.util.Arrays;

class Item {
    int val , weight;
    public Item(int val, int weight) {
        this.val = val;
        this.weight = weight;
    }
}

public class FractionalKanpsack {
	
	//TC: O(n log n)
    //SC: O(n)
    double fractionalKnapsack(int[] val, int[] wt, int W) {
        int n = val.length;
        int m = wt.length;
        Item[] item = new Item[n];
        double totalVal = 0.0;
        for(int i = 0; i < n; i++) {
            item[i] = new Item(val[i], wt[i]);
        }
        
        //sort on the basis unit weight in decending order
        Arrays.sort(item, (a, b) -> {
            return Double.compare((double)b.val / b.weight, (double)a.val / a.weight);
        });
        
        for(int i = 0; i < n; i++) {
            if(item[i].weight <= W) {
                totalVal += item[i].val;
                W -= item[i].weight;
            } else {
                totalVal += ((double) item[i].val / item[i].weight) * W;
                break;
            }
        }
        return totalVal;
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
