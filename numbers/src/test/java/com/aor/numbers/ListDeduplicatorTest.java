package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListDeduplicatorTest {
    List<Integer> list = new ArrayList<>();
    List<Integer> expected = new ArrayList<>();

    @Before
    public void setup(){
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);

        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(5);
    }

    @Test
    public void deduplicate() {
        ListDeduplicator deduplicator = new ListDeduplicator(list);
        ListSorter sorter = new ListSorter(list);
        List<Integer> distinct = deduplicator.deduplicate(sorter);

        assertEquals(expected, distinct);
    }

    @Test
    public void myDeduplicate(){
        expected.remove(3);
        list.remove(4);

        List<Integer> sorted = new ArrayList<>();
        sorted.add(1);
        sorted.add(2);
        sorted.add(4);

        IListSorter sorter = Mockito.mock(IListSorter.class);
        Mockito.when(sorter.sort()).thenReturn(sorted);

        ListDeduplicator deduplicator = new ListDeduplicator(list);

        List<Integer> distinct = deduplicator.deduplicate(new ListSorter(sorted));

        assertEquals(expected, distinct);

    }
}