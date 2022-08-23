package com.tlglearning;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class ConversionTest {

    @Test
    void convertToDecimal() {
        assertEquals(173, Conversion.convertToDecimal("10101101"));
    }

    @Test
    void parse() {
        assertEquals(173, Conversion.parse("10101101", 2));
        assertEquals(-173, Conversion.parse("-10101101", 2));
        assertThrows(IllegalArgumentException.class, () -> Conversion.parse("101010101", 1));
        assertThrows(IllegalArgumentException.class, () -> Conversion.parse("101010101", 11));
        assertEquals(0, Conversion.parse(" ", 2));
        assertEquals(2, Conversion.parse("    10", 2));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> Conversion.parse("", 2));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "parse-valid.csv", numLinesToSkip = 1)
    void parse_valid(String representation, int radix, int expected) {
        assertEquals(expected, Conversion.parse(representation, radix));
    }
}