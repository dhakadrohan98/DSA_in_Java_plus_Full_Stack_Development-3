package org.payU.test;

import java.util.Arrays;

public class BinarySearch {
//	Given a sorted array of integers, write a method to find the index of a target value.
//	 
//	If the target exists, return its index.
//	 
//	If it does not exist, return -1.
//	 
//	Implement this using the binary search algorithm
//	 
//	 
//	  nums = [5, 12, -3, 9, 0]
//
//			  target = 9
			 
	
	public static void main(String[] args) {
		int arr[]= {5, 12, -3, 9, 0};
		Arrays.sort(arr);
		int result=binarySearch(arr,9);
		System.out.println(result);

	}
	public static int binarySearch(int arr[],int target) {
		int low=0;
		int high=arr.length-1;
		while(low<=high) {
			int mid=low+(high-low)/2;
			if(arr[mid]==target) {
			return mid;
		}
		else if(arr[mid]<target) {
			low=mid+1;
		}
		else {
			high=mid-1;
		}
			
		}
			return -1;//Not found
	}
	//Quick Sort
//	
//	public static void quickSort(int arr[],,int low,int high) {
//		//partioning logic
//		
//		private static int partition(int arr[],int low,int high) {
//			int pivot=arr[high];//chosing laste element as pivot
//			int i=low-1;//Index of smaller element
//			for(int j=low;j<high;j++) {
//				i++;
//				swap(arr,i,j);
//			}
//			swap(arr,i+1,high);
//			return i+1;
//		}
//		private static void swap(int[] arr, int i, int j) {
//			
//			int temp=arr[i];
//			arr[i]=arr[j];
//			arr[j]=temp;
//		}
//		
//	}

}
