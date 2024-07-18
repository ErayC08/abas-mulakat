package com.example.entity;

import java.util.List;

public class Order {
    private int number;
    private List<Item> items;

    public Order(int number) {
        setNumber(number);
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Item> getItems() {
        return this.items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotalPrice() {
        return this.items.stream().mapToDouble(Item::getTotalPrice).sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order other = (Order) o;

        return this.number == other.number;
    }

    @Override
    public int hashCode() {
        return this.number;
    }
}
