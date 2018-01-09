package com.company;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Fraction {
    private BigInteger numerator;
    private BigInteger denominator;

    public Fraction (BigInteger numerator, BigInteger denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public static Fraction valueOf(double val) {
        return valueOf(BigDecimal.valueOf(val));
    }

    public static Fraction valueOf(BigDecimal val) {
        String valString = val.stripTrailingZeros().toPlainString();

        valString.indexOf(".") < 0 ? 0 : valString.length() -1 valString.in
    }

    public Fraction reduce() {
        BigInteger gcd = numerator.gcd(denominator);
        numerator = numerator.divide(gcd);
        denominator = denominator.divide(gcd);
    }

    public String toString () {
        return numerator.toString() + "/" + denominator.toString();
    }
}
