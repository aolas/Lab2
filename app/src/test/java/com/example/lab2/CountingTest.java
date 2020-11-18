package com.example.lab2;

import junit.framework.TestCase;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountingTest extends TestCase {
    Counting textAnalyzis;

    public void testCounting() {
        String oneWord = "word",message;
        String  twoWords = "a b";
        String  twoWords1 = "awol boom";
        String emptyString = "";
        String numberOfWords = "Number of Words: %d";
        String numberOfChars = "Number of Chars: %d";


        assertEquals(1,1);
        message = textAnalyzis.counting(oneWord,0,numberOfWords,numberOfChars);
        assertEquals("Number of Words: 1",message);
        message = textAnalyzis.counting(twoWords,0,numberOfWords,numberOfChars);
        assertEquals("Number of Words: 2",message);
        message = textAnalyzis.counting(twoWords1,0,numberOfWords,numberOfChars);
        assertEquals("Number of Words: 2",message);
        assertEquals(1,1);
        message = textAnalyzis.counting(oneWord,1,numberOfWords,numberOfChars);
        assertEquals("Number of Chars: 4",message);
        message = textAnalyzis.counting(twoWords,2,numberOfWords,numberOfChars);
        assertEquals("Number of Chars: 3",message);
        message = textAnalyzis.counting(twoWords1,3,numberOfWords,numberOfChars);
        assertEquals("Number of Chars: 9",message);
        message = textAnalyzis.counting(oneWord,-1,numberOfWords,numberOfChars);
        assertEquals("Number of Chars: 4",message);
        message = textAnalyzis.counting(twoWords,-2,numberOfWords,numberOfChars);
        assertEquals("Number of Chars: 3",message);
        message = textAnalyzis.counting(twoWords1,-3,numberOfWords,numberOfChars);
        assertEquals("Number of Chars: 9",message);
        message = textAnalyzis.counting(emptyString,1,numberOfWords,numberOfChars);
        assertEquals("Number of Chars: 0",message);
        message = textAnalyzis.counting(emptyString,0,numberOfWords,numberOfChars);
        assertEquals("Number of Words: 1",message);
    }
}