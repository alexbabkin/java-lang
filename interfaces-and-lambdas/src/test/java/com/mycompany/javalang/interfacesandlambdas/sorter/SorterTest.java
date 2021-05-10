package com.mycompany.javalang.interfacesandlambdas.sorter;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Comparator;
import org.junit.Test;

public class SorterTest {
    @Test
    public void luckySortTest_SeveralElements() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("aaa");
        strings.add("a");
        strings.add("aaaaaa");
        strings.add("bb");
        Sorter.luckySort(strings, Comparator.comparingInt(String::length));

        ArrayList<String> expected = new ArrayList<>();
        expected.add("a");
        expected.add("bb");
        expected.add("aaa");
        expected.add("aaaaaa");

        assertEquals(expected, strings);
    }

    @Test
    public void luckySortTest_OneElement() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("aaa");
        Sorter.luckySort(strings, Comparator.comparingInt(String::length));

        ArrayList<String> expected = new ArrayList<>();
        expected.add("aaa");

        assertEquals(expected, strings);
    }

    @Test
    public void luckySortTest_NoElements() {
        ArrayList<String> strings = new ArrayList<>();

        Sorter.luckySort(strings, Comparator.comparingInt(String::length));

        ArrayList<String> expected = new ArrayList<>();

        assertEquals(expected, strings);
    }
}
