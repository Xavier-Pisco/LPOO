package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListSorterTest {
    List<Integer> expected = new ArrayList();
    List<Integer> list = new ArrayList();

    @Before
    public void setup(){
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);

        expected.add(1);
        expected.add(2);
        expected.add(2);
        expected.add(4);
    }

    @Test
    public void sort() {

        ListSorter sorter = new ListSorter(list);
        List<Integer> sorted = sorter.sort();

        assertEquals(expected, sorted);
    }
}