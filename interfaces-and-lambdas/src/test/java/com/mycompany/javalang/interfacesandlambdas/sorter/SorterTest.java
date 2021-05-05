package com.mycompany.javalang.interfacesandlambdas.sorter;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import org.junit.Test;

public class SorterTest {
    @Test
    public void luckySortTest_SeveralElements() {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("aaa");
        strings.add("a");
        strings.add("aaaaaa");
        strings.add("bb");
        Sorter.luckySort(strings, (str1, str2) -> str1.length() - str2.length());

        ArrayList<String> expected = new ArrayList<String>();
        expected.add("a");
        expected.add("bb");
        expected.add("aaa");
        expected.add("aaaaaa");

        assertEquals(expected, strings);
    }

    @Test
    public void luckySortTest_OneElement() {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("aaa");
        Sorter.luckySort(strings, (str1, str2) -> str1.length() - str2.length());

        ArrayList<String> expected = new ArrayList<String>();
        expected.add("aaa");

        assertEquals(expected, strings);
    }

    @Test
    public void luckySortTest_NoElements() {
        ArrayList<String> strings = new ArrayList<String>();

        Sorter.luckySort(strings, (str1, str2) -> str1.length() - str2.length());

        ArrayList<String> expected = new ArrayList<String>();

        assertEquals(expected, strings);
    }
}
