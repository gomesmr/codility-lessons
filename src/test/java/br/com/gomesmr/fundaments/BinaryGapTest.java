package br.com.gomesmr.fundaments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryGapTest {

    @Test
    void testSolutionWithBinaryGap() {
        assertEquals(5, BinaryGap.solution(1376796946)); // Binary: 1010010000100000100000100010010
        assertEquals(7, BinaryGap.solution(151552257)); // Binary: 1001000010001000000100000001
        assertEquals(7, BinaryGap.solution(151552246)); // Binary: 1001000010001000000011110110
        assertEquals(7, BinaryGap.solution(2368003));   // Binary: 1001000010001000000011
        assertEquals(5, BinaryGap.solution(336132));    // Binary: 1010010000100000100
    }

    @Test
    void testSolutionWithoutBinaryGap() {
        assertEquals(0, BinaryGap.solution(15)); // Binary: 1111
        assertEquals(0, BinaryGap.solution(1));  // Binary: 1
        assertEquals(0, BinaryGap.solution(0));  // Binary: 0
    }

    @Test
    void testSolutionWithEdgeCases() {
        assertEquals(0, BinaryGap.solution(-1)); // Binary: 11111111111111111111111111111111
        assertEquals(0, BinaryGap.solution(Integer.MAX_VALUE)); // Binary: 1111111111111111111111111111111
        assertEquals(0, BinaryGap.solution(Integer.MIN_VALUE)); // Binary: 10000000000000000000000000000000
    }

    @Test
    void testFormatBinaryRepresentation() {
        assertEquals("10_1011", BinaryGap.formatBinaryRepresentation("101011"));
        assertEquals("101_0010_0001_0000_0100_0001_0001_0010", BinaryGap.formatBinaryRepresentation("1010010000100000100000100010010"));
        assertEquals("1001_0000_1000_1000_0001_0000_0001", BinaryGap.formatBinaryRepresentation("1001000010001000000100000001"));
        assertEquals("1001_0000_1000_1000_0000_1111_0110", BinaryGap.formatBinaryRepresentation("1001000010001000000011110110"));
        assertEquals("10_0100_0010_0010_0000_0011", BinaryGap.formatBinaryRepresentation("1001000010001000000011"));
        assertEquals("101_0010_0001_0000_0100", BinaryGap.formatBinaryRepresentation("1010010000100000100"));
    }

    @Test
    void testFormatBinaryRepresentationWithShortBinary() {
        assertEquals("1", BinaryGap.formatBinaryRepresentation("1"));
        assertEquals("10", BinaryGap.formatBinaryRepresentation("10"));
        assertEquals("1010", BinaryGap.formatBinaryRepresentation("1010"));
    }

    @Test
    void testFinalLength() {
        assertEquals(39, BinaryGap.finalLength(32, 8, 0)); // Binary length: 32, Div: 8, Rest: 0
        assertEquals(41, BinaryGap.finalLength(33, 8, 1)); // Binary length: 33, Div: 8, Rest: 1
        assertEquals(43, BinaryGap.finalLength(35, 8, 3)); // Binary length: 35, Div: 8, Rest: 3
        assertEquals(34, BinaryGap.finalLength(28, 7, 0)); // Binary length: 28, Div: 7, Rest: 0
    }
}