package com.example;

import com.example.entity.Item;
import com.example.entity.Order;
import com.example.service.OrderService;

import java.util.List;

public class Main1 {
    private static final OrderService orderService = new OrderService();

    public static void main(String[] args) {
        Order order1 = new Order(1000, List.of(
                new Item(2000, 12, 100.51),
                new Item(2001, 31, 200),
                new Item(2002, 22, 150.86),
                new Item(2003, 41, 250),
                new Item(2004, 55, 244)));
        Order order2 = new Order(1001, List.of(
                new Item(2001, 88, 44.531),
                new Item(2002, 14, 88.11),
                new Item(2004, 74, 211),
                new Item(2002, 121, 88.11)));
        Order order3 = new Order(1002, List.of(
                new Item(2003, 2, 12.1),
                new Item(2004, 3, 22.3),
                new Item(2003, 8, 12.1),
                new Item(2002, 16, 94),
                new Item(2005, 9, 44.1),
                new Item(2006, 19, 90)));

        List<Order> orders = List.of(order1, order2, order3);

        System.out.println("Answer for 1.a:");
        printTotalPriceByOrder(orders);
        System.out.println();
        System.out.println("Answer for 1.b:");
        printAverageTotalPrice(orders);
        System.out.println();
        System.out.println("Answer for 1.c:");
        printAveragePriceByItem(orders);
        System.out.println();
        System.out.println("Answer for 1.d:");
        printItemQuantityAndNumberByOrder(orders);
    }

    private static void printTotalPriceByOrder(List<Order> orders) {
        orderService.getTotalPriceByOrder(orders).forEach((key, value) -> System.out.println("Order Number: " + key.getNumber() + ", Total Price: " + key.getTotalPrice()));
    }

    private static void printAverageTotalPrice(List<Order> orders) {
        System.out.println(orderService.getAverageTotalPrice(orders));
    }

    private static void printAveragePriceByItem(List<Order> orders) {
        orderService.getAveragePriceByItem(orders).forEach((key, value) -> System.out.println("Item Number: " + key.getNumber() + ", Average Price in the Orders: " + value));
    }

    private static void printItemQuantityAndNumberByOrder(List<Order> orders) {
        orders.forEach(order -> order.getItems().forEach(item -> System.out.println("Number: " + item.getNumber() + ", Quantity: " + item.getQuantity() + ", Order Number: " + order.getNumber())));
    }
}
