package me.sohamroy;

import java.math.BigDecimal;
import java.math.BigInteger;

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

	}

	public static void main(String[] args) {
		//BigFractionTest();
		UnionFindTest();
	}

	private static void printTime(){
		System.out.println("Time Elapsed: " + (System.nanoTime() - startTime) / 1000000.0 + " seconds\n");
	}

	private static void startTiming(){
		startTime=System.nanoTime();
	}
}
