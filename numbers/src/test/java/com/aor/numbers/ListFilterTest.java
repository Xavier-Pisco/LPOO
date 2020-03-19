package com.aor.numbers;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class ListFilterTest {
    List<Integer> list = new ArrayList<>();
    List<Integer> expected = new ArrayList<>();
    IListFilter mockPositiveFilter;

    @Before
    public void setup(){
        list.add(0);
        list.add(1);
        list.add(5);
        list.add(-1);
        list.add(-5);
    }

    @Test
    public void listFilterer(){
        expected.add(1);
        expected.add(5);

        mockPositiveFilter = Mockito.mock(IListFilter.class);
        Mockito.when(mockPositiveFilter.accept(Mockito.anyInt())).thenAnswer(i -> ((Integer) i.getArguments()[0] > 0));

        ListFilterer filter = new ListFilterer(list);
        List<Integer> res = filter.filter(mockPositiveFilter);

        assertEquals(res, expected);
    }

    @Test
    public void positiveFilter(){
        expected.add(1);
        expected.add(5);

        ListFilterer filter = new ListFilterer(list);
        List<Integer> res = filter.filter(new PositiveFilter());

        assertEquals(res, expected);
    }

    @Test
    public void divisibleByFilter(){
        expected.add(0);
        expected.add(5);
        expected.add(-5);

        ListFilterer filter = new ListFilterer(list);
        List<Integer> res = filter.filter(new DivisibleByFilter(5));

        assertEquals(res, expected);
    }
}
