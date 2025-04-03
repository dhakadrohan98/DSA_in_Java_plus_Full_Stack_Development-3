package org.codeship.binarysearch.revision;

import java.util.*;
public class PainterPartition_Hard_BS {
	
	//TC: O(log2 (sum - max + 1) * n) + O(n)
    //SC: O(1)
    private static int countStudent(ArrayList<Integer> arr, int n, int pages) {
        int student = 1;
        int page = 0;
        for(int itr : arr) {
            if(page + itr > pages) {
                student += 1;
                page = itr;
            } else {
                page += itr;
            }
        }
        return student;
    }

    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        //edge case
        //no. of student > no. of books
        if(m > n) {
            return -1;
        }

        int ans = 0;
        int max = 0;
        int sum = 0;
        //find maximum pages from book array
        for(int page : arr) {
            max = Math.max(max, page);
        }
        //find sum of all pages for a single student
        for(int page : arr) {
            sum += page;
        }
        int low = max;
        int high= sum;

        while(low <= high) {
            int mid = (low + high) / 2;
            int cntStudent = countStudent(arr, n, mid);
            if(cntStudent <= m) {
                ans = mid;
                high = mid - 1;
            }
            // } else if(cntStudent < m) {
            //     high = mid - 1;
            // }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        int n = boards.size();
        return findPages(boards, n, k);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
