package me.sohamroy;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Tester {
    static long startTime = 0;
    public static void main(String[] args) {

    }

    private static void printTime(){
        System.out.println("Time Elapsed: " + (System.nanoTime() - startTime) / 1000000.0 + " seconds\r");
    }

    private static void startTiming(){
        startTime=System.nanoTime();
    }
}
