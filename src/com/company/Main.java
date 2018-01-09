package com.company;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        BigDecimal one = BigDecimal.ONE;
        BigDecimal e = BigDecimal.ONE;
        BigInteger i = BigInteger.ONE;
        while(true) {
            System.out.println(e = e.add(one.divide(factorial(i))));
            System.out.println("Time Elapsed: " + (System.nanoTime() - startTime) / 1000000.0);
            i = i.add(BigInteger.ONE);
        }
    }

    public static BigDecimal factorial(BigInteger val) {
        BigInteger product = BigInteger.ONE;
        while (val.compareTo(BigInteger.ONE) >= 1){
            product = product.multiply(val);
            val = val.subtract(BigInteger.ONE);
        }
       return new BigDecimal(product);
    }
}
