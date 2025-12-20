package org.idfc.machinecodinground;

import java.util.*;

public class HttPLoggerAnalyzer {

	//Time & Space complexity
	// TC: O(logn * n)
	// SC: O(n)

	public static void solve(List<List<String>> arr) {
		int n = arr.size();
		//part1
		Map<String, Integer> hmap1 = new HashMap<>();
		// build the count map
		for (int i = 0; i < n; i++) {
			List<String> oneReq = arr.get(i);
			// 5 parts
			// endpoint - 2
			String endpoint = oneReq.get(2);
			hmap1.put(endpoint, hmap1.getOrDefault(endpoint, 0) + 1);
		}
		// sort hmap1 based on values
		List<Map.Entry<String, Integer>> list = new ArrayList<>(hmap1.entrySet());
		Collections.sort(list, (map1, map2) -> map2.getValue() - map1.getValue());
		// put sorted list element into lhmap
		Map<String, Integer> sortedMapBasedOnValues = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> map : list) {
			sortedMapBasedOnValues.put(map.getKey(), map.getValue());
		}
		hmap1 = sortedMapBasedOnValues;
		System.out.println("Request Count map op1");
		System.out.println(hmap1);
		System.out.println();
		

		//part-2
		// store total res time - endpoint(key)
		Map<String, Integer> hmap2 = new HashMap<>();
		for (int i = 0; i < n; i++) {
			List<String> oneReq = arr.get(i);
			// 5 parts
			// endpoint - 2
			String endpoint = oneReq.get(2);
			// 120ms - 4
			String respTime = oneReq.get(4);
			Integer resTime = Integer.valueOf(respTime);
			if (hmap2.containsKey(endpoint)) {
				hmap2.put(endpoint, resTime + (hmap2.get(endpoint)));
			} else {
				hmap2.put(endpoint, resTime);
			}
		}
//		System.out.println("Total response time for each endpoint");
//		System.out.println(hmap2);

		//part3
		// Build Map request count except for 0ms entry
		Map<String, Integer> hmap4 = new HashMap<>();
		// build the count map
		for (int i = 0; i < n; i++) {
			List<String> oneReq = arr.get(i);
			// 5 parts
			// endpoint - 2
			String endpoint = oneReq.get(2);
			Integer resTime = Integer.valueOf(oneReq.get(4));
			if (resTime == 0) {
				continue;
			}
			hmap4.put(endpoint, hmap4.getOrDefault(endpoint, 0) + 1);
		}
//		System.out.println("request count except for 0ms endpoint entry");
//		System.out.println(hmap4);

		//part4
		// Average calculations
		// average map
		Map<String, Integer> hmap3 = new HashMap<>();
		for (int i = 0; i < n; i++) {
			List<String> oneReq = arr.get(i);
			// 5 parts
			// endpoint - 2
			String endpoint = oneReq.get(2);
			// respone time - 4
			int requestCnt = hmap4.get(endpoint);
			int totalResponseTime = hmap2.get(endpoint);
			hmap3.put(endpoint, totalResponseTime / requestCnt);
		}
		System.out.println("average response time map op2");
		System.out.println(hmap3);
		System.out.println();

		//part5
		// Store url, responseTime
		int maxiResponseTime = -1;
		String slowestCallEndpoint = "";

		for (int i = 0; i < n; i++) {
			List<String> oneReq = arr.get(i);
			// 5 parts
			// endpoint - 2
			String endpoint = oneReq.get(2);
			Integer responseTime = Integer.valueOf(oneReq.get(4));
			if (maxiResponseTime < responseTime) {
				slowestCallEndpoint = endpoint;
				maxiResponseTime = responseTime;
			}
		}
		System.out.println("slowest API call - op3");
		System.out.println(slowestCallEndpoint + " - " + maxiResponseTime);
		System.out.println();

		//part6
		double count = 0;
		for (int i = 0; i < n; i++) {
			List<String> oneReq = arr.get(i);
			// 5 parts
			// endpoint - 2
			Integer statusCode = Integer.valueOf(oneReq.get(3));
			if (statusCode >= 400) {
				count += 1;
			}
		}
		double errorRate = (count / 7.0) * 100;
		// Forget syntax for formating upto 2 decimal places
//		System.out.printf("%2f", errorRate);
//		System.out.println();
		System.out.println("error rate op4- " + errorRate);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<String>> input = new ArrayList<List<String>>();
		input.add(Arrays.asList("info", "get", "/api/users", "200", "120"));
		input.add(Arrays.asList("info", "get", "/api/users", "500", "95"));
		input.add(Arrays.asList("info", "post", "/api/users", "201", "250"));
		input.add(Arrays.asList("info", "get", "/api/orders", "404", "60"));
		input.add(Arrays.asList("info", "get", "/api/orders", "200", "180"));
		input.add(Arrays.asList("info", "post", "/api/orders", "200", "310"));
		input.add(Arrays.asList("debug", "options", "/api/orders", "204", "0"));
		solve(input);

	}

}
