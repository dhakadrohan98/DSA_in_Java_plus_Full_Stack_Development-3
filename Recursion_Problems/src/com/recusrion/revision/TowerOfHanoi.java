package com.recusrion.revision;

public class TowerOfHanoi {
	
	public int towerOfHanoi(int n, int from, int to, int aux) {
        //base case
        if(n == 1 || n == 0) {
            return n;
        }
        //move n-1 disks from "From" rod to "Aux" rod with the help of "To" rod
        int count = 0;
        count = towerOfHanoi(n-1, from, aux, to);
        // move last disk from "From" to "To" rod
        count += 1;
        //move n-1 disks from aux rod to "To" rod with the help of "From" rod
        count += towerOfHanoi(n-1, aux, to, from);
        return count; // x + 1 + y
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
