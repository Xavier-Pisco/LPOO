package com.aor.refactoring.example1;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderLine> lines;
    private double total;

    public Order() {
        lines = new ArrayList<>();
    }

    public void add(Product product, int quantity) {
        lines.add(new OrderLine(product, quantity));

        total += product.getPrice() * quantity;
    }

    public boolean isElegibleForFreeDelivery() {
        return total > 100;
    }

    public String printOrder() {
        StringBuffer printBuffer = new StringBuffer();

        for (OrderLine line : lines) {
            printBuffer.append(line.stringBuffer());
        }

        printBuffer.append("Total: " + total);

        return printBuffer.toString();
    }


}