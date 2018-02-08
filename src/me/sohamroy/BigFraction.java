package me.sohamroy;

import java.math.BigDecimal;
import java.math.BigInteger;

public final class BigFraction extends Number implements Comparable<BigFraction>{
    private final BigInteger numerator;
    private final BigInteger denominator;

    //Constructor with BigIntegers
    public BigFraction(BigInteger numerator, BigInteger denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    //Copy constructor
    public BigFraction(BigFraction fraction) { this(fraction.numerator,fraction.denominator);}

    //Constructor with BigDecimals
    //Converts to integers and reduces
    public BigFraction(BigDecimal numerator, BigDecimal denominator) {
        int numeratorScale = numerator.scale();
        int denominatorScale = denominator.scale();
        BigInteger num;
        BigInteger den;
        if(numeratorScale > denominatorScale) {
            num = numerator.movePointRight(numeratorScale).toBigInteger();
            den = denominator.movePointRight(numeratorScale).toBigInteger();
        } else {
            num = numerator.movePointRight(denominatorScale).toBigInteger();
            den = denominator.movePointRight(denominatorScale).toBigInteger();
        }
        BigInteger gcd = num.gcd(den);
        this.numerator=num.divide(gcd);
        this.denominator=den.divide(gcd);
    }

    //valueOf methods
    public static BigFraction valueOf(int val) { return valueOf(BigInteger.valueOf(val));}

    public static BigFraction valueOf(BigInteger val) { return new BigFraction(val, BigInteger.ONE);}

    public static BigFraction valueOf(double val) {
        return valueOf(BigDecimal.valueOf(val));
    }

    public static BigFraction valueOf(BigDecimal val) { return new BigFraction(val, BigDecimal.ONE);}

    //Operators
    public BigFraction abs() {
        return reduce(numerator.abs(),denominator.abs());
    }

    public BigFraction reciprocal() {
        return reduce(numerator, denominator);
    }

    public BigFraction add(BigFraction val) {
        return reduce(numerator.multiply(val.denominator).add(val.numerator.multiply(denominator)),denominator.multiply(val.denominator));
    }

    public BigFraction subtract(BigFraction val) {
        return add(val.negate());
    }

    private BigFraction negate() {
        return reduce(numerator.negate(),denominator);
    }

    public BigFraction divide(BigFraction val) {
        return multiply(val.reciprocal());
    }

    private BigFraction multiply(BigFraction val) {
        return reduce(numerator.multiply(val.numerator),denominator.multiply(val.denominator));
    }

    public BigFraction reduce() {
        return reduce(numerator, denominator);
    }

    private static BigFraction negate(BigFraction val) {
        return reduce(val.numerator.negate(),val.denominator);
    }

    public static BigFraction reciprocal(BigFraction val) {
        return reduce(val.denominator, val.denominator);
    }

    public static BigFraction reduce(BigInteger numerator, BigInteger denominator) {
        BigInteger gcd = numerator.gcd(denominator);
        return new BigFraction(numerator.divide(gcd), denominator.divide(gcd));
    }

    public String toString () {
        return numerator.toString() + "/" + denominator.toString();
    }

    //get methods
    public BigInteger getDenominator() {
        return denominator;
    }

    public BigInteger getNumerator() {
        return numerator;
    }

    //Inherited abstract methods from Number
    @Override
    public int intValue() {
        return numerator.divide(denominator).intValue();
    }

    @Override
    public long longValue() {
        return numerator.divide(denominator).longValue();
    }

    @Override
    public float floatValue() {
        return (new BigDecimal(numerator)).divide(new BigDecimal(denominator)).floatValue();
    }

    @Override
    public double doubleValue() {
        return (new BigDecimal(numerator)).divide(new BigDecimal(denominator)).doubleValue();
    }

    //returns 1 if greater than val, -1 if less than val, and 0 if equal
    @Override
    public int compareTo(BigFraction val) {
        return numerator.multiply(val.denominator).compareTo(val.numerator.multiply(denominator));
    }
}
