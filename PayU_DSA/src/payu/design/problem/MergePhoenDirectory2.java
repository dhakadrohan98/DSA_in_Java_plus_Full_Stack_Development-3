package payu.design.problem;

import java.util.*;

/*
class Person {
	
	String name;
	Set<Integer> set = new HashSet<>();
	
	public Person(String name, Set<Integer> set) {
		this.name = name;
		this.set = set;
	}
	
}
*/

public class MergePhoenDirectory2 {

	public static Map<String, Set<Integer>> mergePhoneDir(Map<String, Set<Integer>> phoneDir1,
			Map<String, Set<Integer>> phoneDir2) {

		Map<String, Set<Integer>> resultantDir = new HashMap<String, Set<Integer>>();
		for (Map.Entry<String, Set<Integer>> map1 : phoneDir1.entrySet()) {
			if (phoneDir2.containsKey(map1.getKey())) {
				String name = map1.getKey();
				Set<Integer> resultSet = new HashSet<>();
				// add list of numbers from first dir for a common person
				resultSet.addAll(map1.getValue());
				// add list of numbers from second dir for a common person
				resultSet.addAll(phoneDir2.get(name));
				resultantDir.put(name, resultSet);
			} else { // adding unmatched person from phoneDir1 into resultant directory
				resultantDir.put(map1.getKey(), map1.getValue());
			}
		}

		// Now add remaining keys from phoneDir2
		for (Map.Entry<String, Set<Integer>> map2 : phoneDir2.entrySet()) {
			//if this key is found common while iterating over dir1 then skip the adding here otherwise it will 
			//override the merged list
			if (!phoneDir1.containsKey(map2.getKey())) {
				resultantDir.put(map2.getKey(), map2.getValue());
			}
		}

		return resultantDir;
	}

	public static void main(String[] args) {
		Map<String, Set<Integer>> phoneDir1 = new HashMap<>();
		// prepare the i/p data for phone dir1 & dir2
		Set<Integer> set1 = new HashSet<>();
		set1.addAll(Arrays.asList(923, 463, 579, 625));
		phoneDir1.put("Rohan", set1);
		System.out.println(phoneDir1);

		Map<String, Set<Integer>> phoneDir2 = new HashMap<>();
		// prepare the i/p data
		Set<Integer> set2 = new HashSet<>();
		set2.addAll(Arrays.asList(945, 258, 463, 781, 579));
		phoneDir2.put("Rohan", set2);
		System.out.println(phoneDir2);

		Map<String, Set<Integer>> ans = mergePhoneDir(phoneDir1, phoneDir2);
		System.out.println("Merged directories");
		for (Map.Entry<String, Set<Integer>> map : ans.entrySet()) {
			System.out.println("person- " + map.getKey() + " : phoneNumbers=" + map.getValue());
		}

	}

}
