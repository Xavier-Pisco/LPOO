package com.aor.refactoring.example3;

public class FixedDiscount implements Discount {
    private final int discount;

    public FixedDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public double applyDiscount(double price) {
        return discount > price ? 0 : price - discount;
    }
}
