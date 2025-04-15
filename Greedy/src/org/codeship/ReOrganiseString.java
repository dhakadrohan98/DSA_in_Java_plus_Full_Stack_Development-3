package org.codeship;

public class ReOrganiseString {
	
	//TC: O(n) + O(2*26)
    //SC: O(26)
    public String reorganizeString(String s) {
        int len = s.length();
        //store freq of lowercase characters
        int[] map = new int[26];
        for(char ch : s.toCharArray()) {
            map[ch - 'a']++;
        }
        int max = 0, letter = 0;
        for(int i = 0; i < map.length; i++) {
            if(max < map[i]) {
                //majority element
                max = map[i];
                //character position of majority element
                letter = i;
            }
        }

        //1st case
        if(max > (len + 1) / 2) {
            return "";
        }
        char[] res = new char[len];

        //fill all even places with majority character
        int idx = 0;
        while(map[letter] > 0) {
            // 3 + 65 = 68 -> d
            //res[0] = 'd';
            res[idx] = (char) (letter + 'a');
            idx += 2;
            map[letter] -= 1;
        }

        //fill all remaining characters
        for(int i = 0; i < map.length; i++) {
            while(map[i]-- > 0) {
                if(idx >= len) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
            }
        }

        return String.valueOf(res);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
