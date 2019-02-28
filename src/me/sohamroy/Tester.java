package me.sohamroy;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;

public class Tester {
	static long startTime = 0;
	public static void BigFractionTest () {
		BigFraction testFraction1 = new BigFraction(BigInteger.valueOf(1),BigInteger.valueOf(2));
		BigFraction testFraction2 = new BigFraction(BigInteger.valueOf(1),BigInteger.valueOf(6));

		startTiming();
		System.out.println(testFraction1);
		printTime();

		startTiming();
		System.out.println(testFraction1.add(testFraction2));
		printTime();

		startTiming();
		System.out.println(testFraction1.negate());
		printTime();

		startTiming();
		System.out.println(testFraction1.negate().abs());
		printTime();

		startTiming();
		System.out.println(testFraction1.multiply(testFraction2));
		printTime();

		startTiming();
		System.out.println(testFraction1.reciprocal());
		printTime();

		startTiming();
		System.out.println(testFraction1.reciprocal().doubleValue());
		printTime();

		startTiming();
		System.out.println(testFraction1.divide(testFraction2));
		printTime();

		startTiming();
		System.out.println(new BigFraction(BigDecimal.valueOf(.75),BigDecimal.valueOf(.25)));
		printTime();
	}

	public static void UnionFindTest() {
		startTiming();
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < 1000; i++) {
			set.add(i);
		}
		HashMap<Integer,Integer> parentMap = UnionFind.createMap(set);
		HashMap<Integer,Integer> rankMap = UnionFind.createMap(set);
		System.out.println(UnionFind.size(parentMap));
		UnionFind.union(parentMap,rankMap,5,6);
		UnionFind.union(parentMap,rankMap,777,444);
		System.out.println(UnionFind.find(parentMap,777));
		System.out.println(UnionFind.find(parentMap,444));
		System.out.println(UnionFind.size(parentMap));
		printTime();
	}

	public static void main(String[] args) {
		BigFractionTest();
		UnionFindTest();
	}

	private static void printTime(){
		System.out.println("Time Elapsed: " + (System.nanoTime() - startTime) / 1000000000.0 + " seconds\n");
	}

	private static void startTiming(){
		startTime=System.nanoTime();
	}
}
