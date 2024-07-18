package com.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int number;
    private List<Item> items;

    public Order(int number, List<Item> items) {
        setNumber(number);
        setItems(items);
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
        this.items = new ArrayList<>();

        items.forEach(item -> {
            int index = findIndexOfItem(item);

            if (index == -1) {
                this.items.add(item);
            } else {
                Item foundItem = this.items.get(index);

                foundItem.setQuantity(foundItem.getQuantity() + item.getQuantity());
            }
        });
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

    @Override
    public String toString() {
        return "Number: " + number + ", Items: " + items;
    }

    private int findIndexOfItem(Item item) {
        for (Item next : this.items) {
            if (next.equals(item)) {
                return this.items.indexOf(next);
            }
        }
        return -1;
    }
}
