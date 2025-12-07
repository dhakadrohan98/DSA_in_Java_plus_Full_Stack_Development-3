package payu.string;

import java.util.*;

public class GroupAnagrams {

	// TC: O(n * ( (k * logk) + (logm) ))
	// SC: O(n*k)
	public List<List<String>> groupAnagrams(String[] strs) {
		// key:sorted_string , value:list of correspond anagrams
		Map<String, List<String>> hmap = new HashMap<>();
		int n = strs.length;
		// O(n)
		for (int i = 0; i < n; i++) {
			char[] strArr = strs[i].toCharArray();
			// O(k * logk)
			Arrays.sort(strArr);
			String sortedStr = new String(strArr);
			// key:sorted_s[i] , value:list of correspond anagrams
			// O(logm)
			if (hmap.containsKey(sortedStr)) {
				List<String> list = hmap.get(sortedStr);
				list.add(strs[i]);
			} else {
				List<String> list = new ArrayList<>();
				list.add(strs[i]);
				hmap.put(sortedStr, list);
			}
		}

		List<List<String>> ans = new ArrayList<>();
		for (Map.Entry<String, List<String>> map : hmap.entrySet()) {
			ans.add(map.getValue());
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
