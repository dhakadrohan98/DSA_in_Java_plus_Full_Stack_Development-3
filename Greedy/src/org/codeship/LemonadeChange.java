package org.codeship;

import java.util.HashMap;
import java.util.Map;

public class LemonadeChange {
	
	//Approach - 1 using hashmap
	//TC: O(n)
    //SC: O(n)
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        Map<Integer, Integer> hmap = new HashMap<>();
        //initially put $5,$10 & $20 coins with 0 as its freq
        hmap.put(5, 0);
        hmap.put(10, 0);
        hmap.put(20, 0);
        for(int i = 0; i < n; i++) {
            if(bills[i] == 10)
            {
                int remaining = 10 - 5;
                if(hmap.get(remaining) >= 1) {
                    hmap.put(remaining, hmap.get(remaining) - 1);
                } else if(hmap.get(remaining) == 0) {
                    //we don't have $5 changes
                    return false;
                }
            } else if(bills[i] == 20) {
                int remaining = 20 - 5;
                if(hmap.get(5) >= 1 && hmap.get(10) >= 1) {
                    hmap.put(5, hmap.get(5) - 1);
                    hmap.put(10, hmap.get(10) - 1);
                } else if(hmap.get(5) >= 3) {
                    hmap.put(5, hmap.get(5) - 3);
                } 
                else {
                    //we don't have $5 or $10 or both changes
                    return false;
                }
            }
            //put current coin into map
            hmap.put(bills[i], hmap.get(bills[i]) + 1);
        }
        return true;
    }
    
  //Approach - 2 maintain the count for $5 & $10 through a variable
  	public boolean lemonadeChange_Approach2(int[] bills) {
  	    int five = 0, ten = 0;

  	    for (int bill : bills) {
  	        if (bill == 5) {
  	            five++;
  	        } else if (bill == 10) {
  	            if (five == 0) return false;
  	            five--;
  	            ten++;
  	        } else { // bill == 20
  	            if (ten > 0 && five > 0) {
  	                ten--;
  	                five--;
  	            } else if (five >= 3) {
  	                five -= 3;
  	            } else {
  	                return false;
  	            }
  	        }
  	    }

  	    return true;
  	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
