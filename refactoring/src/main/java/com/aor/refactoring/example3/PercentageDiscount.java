package com.aor.refactoring.example3;

public class PercentageDiscount implements Discount {
    private final double discount;

    public PercentageDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public double applyDiscount(double price) {
        return price - price * discount;
    }
}
