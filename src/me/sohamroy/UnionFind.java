package me.sohamroy;

import java.util.HashMap;
import java.util.HashSet;

public class UnionFind {
	public static <T> void union(HashMap<T, T> parentMap,HashMap<T,Integer> rankMap, T a, T b) {
		T aParent  = find(parentMap,a);
		T bParent = find(parentMap,b);
		int aRank = rankMap.get(aParent);
		int bRank = rankMap.get(bParent);
		if(aParent.equals(bParent))
			return;
		if(aRank > bRank) {
			parentMap.put(bParent, parentMap.get(aParent));
			rankMap.remove(bParent);
		}
		else {
			parentMap.put(aParent,parentMap.get(bParent));
			if(aRank == bRank)
				rankMap.put(bParent, bRank + 1);
			rankMap.remove(aParent);
		}
	}

	public static <T> T find(HashMap<T, T> parentMap, T val) {
		if(parentMap.get(val).equals(val))
			return parentMap.get(val);
		else {
			parentMap.put(val,find(parentMap,parentMap.get(val)));
			return parentMap.get(val);
		}
	}

	public static <T> int size(HashMap<T,T> parentMap) {
		HashSet<T> roots = new HashSet<>();
		for(T val:parentMap.keySet())
			roots.add(find(parentMap,val));
		return roots.size();
	}

	public static <T> HashMap<T,T> createMap(HashSet<T> items) {
		HashMap<T,T> parentMap = new HashMap<>();
		for(T val:items)
			parentMap.put(val,val);
		return parentMap;
	}

	public static <T> HashMap<T,Integer> createRankMap(HashSet<T> items) {
		HashMap<T,Integer> rankMap = new HashMap<>();
		for(T val:items)
			rankMap.put(val,1);
		return rankMap;
	}
}