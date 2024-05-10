package org.disjoint.sets;

import java.util.*;

//union by rank along with path compression by striver
public class DisjointSetUnionByRank {

	List<Integer> rank = new ArrayList<>();
	List<Integer> parent = new ArrayList<>();
	
	//will work for 0 & 1 based indexing for parent & rank ArrayList.
	public DisjointSetUnionByRank(int n) {
		for (int i = 0; i <= n; i++) {
			rank.add(0);
			parent.add(i);
		}
	}

	public int findUPar(int node) {
		if (node == parent.get(node)) {
			return node;
		}
		int ulp = findUPar(parent.get(node));
		//path compression is happenning here
		parent.set(node, ulp);
		return parent.get(node);
	}

	public void unionByRank(int u, int v) {
		int ulp_u = findUPar(u);
		int ulp_v = findUPar(v);
		if (ulp_u == ulp_v)
			return;
		if (rank.get(ulp_u) < rank.get(ulp_v)) {
			parent.set(ulp_u, ulp_v);
		} else if (rank.get(ulp_v) < rank.get(ulp_u)) {
			parent.set(ulp_v, ulp_u);
		} else {
			parent.set(ulp_v, ulp_u);
			int rankU = rank.get(ulp_u);
			rank.set(ulp_u, rankU + 1);
		}
	}

	public static void main(String[] args) {
		DisjointSetUnionByRank ds = new DisjointSetUnionByRank(7);
		ds.unionByRank(1, 2);
		ds.unionByRank(2, 3);
		ds.unionByRank(4, 5);
		ds.unionByRank(6, 7);
		ds.unionByRank(5, 6);

		// if 3 and 7 belong to the same component or not
		if (ds.findUPar(3) == ds.findUPar(7)) {
			System.out.println("Same");
		} else
			System.out.println("Not Same");

		ds.unionByRank(3, 7);
		if (ds.findUPar(3) == ds.findUPar(7)) {
			System.out.println("Same");
		} else
			System.out.println("Not Same");
	}
}
