package org.cp.bits;

import java.util.Scanner;

//Fruits types
//1. Grapes
	//2. Apple 
	//3. Papaya
	//4. Oranges
	//5. Lichi
	//6. Guava
    //7. Banana
    //So on & so forth.

//Find any two persons which has maximum no. of common fruits with them.

//i/p -
//5
//4
//1 4 7 9
//6
//2 9 1 7 25 29
//7
//1 23 4 7 9 11 29
//10
//2 28 8 7 9 10 30 21 18 19
//4
//1 11 29 7

//TC: O(n^2 * O(1) bit operations faster than arithmetic operations)
//SC: O(1)
public class MaximizeNumberOfCommonFruits_Hard_CodeforcesArticle {

	public static void printBinary(long num) {
		for (int i = 31; i >= 0; i--) {
			// num >> i - basically ith bit ko 0th position pr le jaa rha hn
			System.out.print(((num >> i) & 1) + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num_of_persons = sc.nextInt();
		long[] masks = new long[num_of_persons + 10];
		for (int i = 0; i < num_of_persons; i++) {
			// enter how many fruits i^th person has?
			int num_fruits = sc.nextInt();
			long mask = 0;
			for (int j = 0; j < num_fruits; j++) {
				int fruit_type = sc.nextInt();
				// set the bit for fruit type for i^th person
				mask = (mask | (1 << fruit_type));
			}
			masks[i] = mask;
			System.out.println();
			System.out.println(i + " th masks val-" + masks[i]);
			// binary value of that masks[i]
			printBinary(masks[i]);
		}

		int max_num_commonFruits = 0;
		int first_person = -1;
		int second_person = -1;
		// calculate intersection now
		for (int i = 0; i < num_of_persons; i++) {
			for (int j = i + 1; j < num_of_persons; j++) {
				int intersectionFruitTypes = Long.bitCount(masks[i] & masks[j]);
				if(max_num_commonFruits < intersectionFruitTypes) {
					max_num_commonFruits = intersectionFruitTypes;
					first_person = i;
					second_person = j;
				}
			}
		}
		System.out.println();
		System.out.println("i:" + first_person + " j:" + second_person);
		System.out.println("maximum no. of common fruits:" + max_num_commonFruits);
	}

}
