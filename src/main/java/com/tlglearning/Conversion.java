package com.tlglearning;

public class Conversion {

    public static int convertToDecimal(String binary) {
        int value = 0;
        for (char c : binary.toCharArray()) {
            value = (value << 1) + c - '0';
        }
        return value;
    }

    // 00 -> 01, 010 -> 010, 0100 -> 0101, 01010 -> 01010, 010100 -> 010101

    public static int parse(String representation, int radix) throws IllegalArgumentException {
        int value = 0;
        if (radix < 2 || radix > 10) {
            throw new IllegalArgumentException();
        }
        char[] chars = representation.toCharArray();
        int length = representation.length();
        if (length == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i = 0; i < length; i++) {
            if (chars[0] == '+' || chars[i] == '-' || chars[i] == ' ') {
                continue;
            }
//            value += (chars[i] - '0') * Math.pow(radix, length - i - 1);
            value = value * radix + chars[i] - '0';
        }
        if (chars[0] == '-') {
            value *= -1;
        }
        return value;
    }

    /* Nick's Solution
    public static int parse(String representation, int radix) throws IllegalArgumentException {
        if (radix < 2 || radix > 10) {
            throw new IllegalArgumentException();
        }
        char[] digits = representation.toCharArray();
        char firstDigit = digits[0];
        boolean hasSign = firstDigit == "+" || firstDigit == "-";
        int sign = (hasSign && firstDigit == '-') ? -1 : 1;
        int value = 0;
        for (int i = (hasSign ? 1 : 0); i < digits.length; i++) {
            char digitChar = digits[i];
            int digitValue = digitChar - '0';
            value = value * radix + digitValue;
        }
        return value * sign;
     */
}
