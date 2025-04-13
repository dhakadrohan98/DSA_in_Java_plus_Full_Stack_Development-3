package org.codeship;

import java.util.*;

public class GasStation {

	//TC: O(n)
	//SC: O(1)
	public int canCompleteCircuit_OptimalApproach(int[] gas, int[] cost) {
		int n = gas.length;
		int totalFuel = 0, totalCost = 0;
		for(int i = 0; i < n; i++) {
			totalFuel += gas[i];
			totalCost += cost[i];
		}
		//if sum of gas is less than sum of cost then it is not possible to travel in circular route 
		if(totalFuel < totalCost) return -1;
		
		int currentFuel = 0, startIndx = 0;
		for(int i = 0; i < n; i++) {
			currentFuel += gas[i] - cost[i];
			if(currentFuel < 0) {
				//reset the current fuel & set start index to next i
				currentFuel = 0;
				startIndx = i+1;
			}
		}
		return startIndx;
	}
	
	//34/39 Test Cases are Passed
	//TC: O(2n + n)
    //SC: O(n) due to stack

    private int findStartIndex(int[] gas, int[] cost, Set<Integer> usedIndx, int n) {
        for(int i=0; i<n; i++) {
            if(cost[i] <= gas[i] && !usedIndx.contains(i)) {
                //initially tank is filled with gas[i]
                usedIndx.add(i);
                return i;
            }
        }
        return -1;
    }

    public int canCompleteCircuit_34TestCasesPassed(int[] gas, int[] cost) {
        int n = gas.length;
        int start_index = -1;
        int tank = 0;
        Set<Integer> set = new HashSet<>();
        Set<Integer> usedIndx = new HashSet<>();
        int gasSum = 0;
        int costSum = 0;

        //if sum of gas is less than sum of cost then it is not possible to travel in circular route
        for(int i = 0; i < n; i++) {
            gasSum += gas[i];
            costSum += cost[i];
        }
        if(gasSum < costSum) {
            return -1;
        }
        //else possible to travel in circular route
        start_index = findStartIndex(gas, cost, usedIndx, n);
        tank = gas[start_index];
        int i = start_index;
        int j = start_index;
        // System.out.println(start_index);
        while(!set.contains(i)) {
            if(tank - cost[j%n] < 0) {
                start_index = findStartIndex(gas, cost, usedIndx, n);
                tank = gas[start_index];
                i = start_index;
                j = start_index;
            }
            tank = tank - cost[j%n] + gas[(i+1)%n];
            //add current index into set
            set.add(i);
            i = (i+1)%n;
            j = (j+1)%n; 
        }
        return start_index;
    }
    
	// 25/39 test cases are passed
	// TC: O(2n)
	// SC: O(n) due to stack
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int n = gas.length;
		int start_index = -1;
		int tank = 0;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			if (cost[i] <= gas[i]) {
				start_index = i;
				// initially tank is filled with gas[i]
				tank = gas[i];
				break;
			}
		}
		// if start index is not found
		if (start_index == -1)
			return -1;

		int i = start_index;
		int j = start_index;
		while (!set.contains(i)) {
			if (tank < cost[j % n]) {
				start_index = -1;
				break;
			}
			tank = tank - cost[j % n] + gas[(i + 1) % n];
			// add current index into set
			set.add(i);
			i = (i + 1) % n;
			j = (j + 1) % n;
		}
		return start_index;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
