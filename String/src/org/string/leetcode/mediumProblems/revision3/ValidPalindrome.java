package org.string.leetcode.mediumProblems.revision3;

public class ValidPalindrome {
	
	//TC: O(m*n) -> where m is the average length of string & n is the average length of characters in a word
	//SC: O(m*n)
	 public static boolean isPalindrome(String s) {
	        s = s.trim();
	        String[] words = s.split(" ");
	        StringBuilder temp = new StringBuilder();
	        //iterate through splitted string array & through each word & through each character of word
	        for(String str : words) {
	            if(str.equals("")) {
	                continue;
	            } else {
	            	for(char ch : str.toCharArray()) {
	            		if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
	            			temp.append(ch);
	            		}
	            	}
	            }
	        }
	        String s2 = temp.toString().toLowerCase();
	        //palindrome logic
	        int start = 0;
	        int end = s2.length() - 1;
	        while(start < end) {
	        	if(s2.charAt(start) != s2.charAt(end)) {
	        		return false;
	        	}
	        	start++;
	        	end--;
	        }
	        
	        return true;
	    }
	 
	public static void main(String[] args) {
//		String str = "java string  split method by TpointTech";
//		String[] words = str.split(" ");
//		System.out.println(words.length);
//		for(String s : words) {
//			if(s.equals("")) {
//				System.out.println("Empty string is splitted");
//			}
//		}
		
		String str2 = "A man, a plan, a canal: Panama";
		boolean palindrome = isPalindrome(str2);
		System.out.println(palindrome);

	}

}
