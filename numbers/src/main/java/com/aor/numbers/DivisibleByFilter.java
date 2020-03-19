package com.aor.numbers;

public class DivisibleByFilter implements IListFilter {
    private int n;

    public DivisibleByFilter(int n) {
        this.n = n;
    }

    @Override
    public boolean accept(Integer number) {
        return (number % n) == 0;
    }
}
