class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        Fraction fraction = new Fraction(numerator, denominator);
        return fraction.toDecimal();
    }
}

// Fraction Class
class Fraction {
    private long numerator;
    private long denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // Main public method
    public String toDecimal() {
        if (numerator == 0) 
            return "0";

        StringBuilder result = new StringBuilder();

        // edge case 1 sign
        if (isNegative()) {
            result.append("-");
        }

        // absolute values
        long n = Math.abs(numerator);
        long d = Math.abs(denominator);

        // integer part
        result.append(n / d);

        long remainder = n % d;

        // edge case 2 completely divisible
        if (remainder == 0) 
            return result.toString();

        // concat the decimal point
        result.append(".");

        // fractional part
        result.append(getFractionPart(remainder, d));

        return result.toString();
    }

    private boolean isNegative() {
        return (numerator < 0) ^ (denominator < 0);
    }

/**
 * Generates the fractional part of the decimal representation.
 * Uses a HashMap to detect repeating remainders and inserts 
 * parentheses around the repeating sequence if a cycle is found.
 */
    private String getFractionPart(long remainder, long denominator) {
        StringBuilder fractionPart = new StringBuilder();
        Map<Long, Integer> remainderMap = new HashMap<>();

        while (remainder != 0) {
            if (remainderMap.containsKey(remainder)) {
                int index = remainderMap.get(remainder);
                fractionPart.insert(index, "(");
                fractionPart.append(")");
                break;
            }
            remainderMap.put(remainder, fractionPart.length());

            remainder *= 10;
            fractionPart.append(remainder / denominator);
            remainder %= denominator;
        }

        return fractionPart.toString();
    }
}