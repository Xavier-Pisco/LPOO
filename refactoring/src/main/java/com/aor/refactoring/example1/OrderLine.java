package com.aor.refactoring.example1;

public class OrderLine {
    private Product product;
    private int quantity;

    public OrderLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public StringBuffer stringBuffer(){
        StringBuffer s = new StringBuffer();
        s.append(product.getName());
        s.append("(x");
        s.append(quantity);
        s.append("): ");
        s.append(product.getPrice() * quantity);
        s.append("\n");
        return s;
    }
}
