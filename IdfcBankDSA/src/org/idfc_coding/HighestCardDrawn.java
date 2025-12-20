package org.idfc_coding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HighestCardDrawn {

	private static Map<String, Integer> number = new HashMap<>();
	private static Map<Character, Integer> suit = new HashMap<>();

	static {
		number.put("1", -1);
		number.put("2", 0);
		number.put("3", 1);
		number.put("4", 2);
		number.put("5", 3);
		number.put("6", 4);
		number.put("7", 5);
		number.put("8", 6);
		number.put("9", 7);
		number.put("10", 8);
		number.put("J", 9);
		number.put("Q", 10);
		number.put("K", 11);
		number.put("A", 12);

		// build the suit map
		suit.put('H', 0);
		suit.put('D', 1);
		suit.put('C', 2);
		suit.put('S', 3);
	}

	// TC: O(n) where n = 5(always) ~ O(1)
	// SC: O(1+1) ~` O(2) constant space
	public static String highestCards(List<String> cards) {
		int n = cards.size();
		String ans = cards.get(n - 1);
		for (int i = n - 2; i >= 0; i--) {
			String curr = cards.get(i);
			int numberAns = -1;
			int numberCurr = -1;
			int suitAns = -1;
			int suitCurr = -1;
			if (ans.length() > 3) {
				numberAns = number.get(ans.substring(0, 2));
				suitAns = suit.get(ans.charAt(3));
			} else {
				numberAns = number.get(ans.charAt(0) + "");
				suitAns = suit.get(ans.charAt(2));
			}
			if (curr.length() > 3) {
				numberCurr = number.get(curr.substring(0, 2));
				suitCurr = suit.get(curr.charAt(3));
			} else {
				numberCurr = number.get(curr.charAt(0) + "");
				suitCurr = suit.get(curr.charAt(2));
			}

			// comparing based on rank first
			if (numberAns != numberCurr) {
				if (numberAns > numberCurr) {
					// do nothing
				} else if (numberAns < numberCurr) {
					ans = curr;
				}
			} else { // numberPrev == numberCurr. If ranks are same then compare based on suit
						// ranking
				if (suitAns > suitCurr) {
					// do nothing
				} else { // suitPrev <= suitCurr
					ans = curr;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> cards1 = Arrays.asList("2-H", "3-D", "4-C", "5-S", "6-H");
		List<String> cards2 = Arrays.asList("A-H", "A-D", "K-C", "Q-S", "J-H");
		List<String> cards3 = Arrays.asList("10-H", "J-D", "Q-C", "K-S", "A-H");
		List<String> cards4 = Arrays.asList("5-H", "A-S", "K-D", "10-C", "J-H");
		System.out.println(highestCards(cards1));
		System.out.println(highestCards(cards2));
		System.out.println(highestCards(cards3));
		System.out.println(highestCards(cards4));
	}

}
