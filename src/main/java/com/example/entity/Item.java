package com.example.entity;

public class Item {
    private int number;
    private int quantity;
    private double price;

    public Item(int number, int quantity, double price) {
        setNumber(number);
        setQuantity(quantity);
        setPrice(price);
    }

    public Item(int number, double price) {
        this(number, 1, price);
    }

    public long getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("The quantity must be greater than 0.");
        }
        this.quantity = quantity;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("The price must be greater than 0.");
        }
        this.price = price;
    }

    public double getTotalPrice() {
        return this.quantity * this.price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item other = (Item) o;

        return this.number == other.number;
    }

    @Override
    public int hashCode() {
        return this.number;
    }
}
