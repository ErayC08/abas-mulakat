package com.example.service;

import com.example.entity.Item;
import com.example.entity.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {

    public Map<Order, Double> getTotalPriceByOrder(List<Order> orders) {
        Map<Order, Double> orderTotalPriceMap = new HashMap<>();

        orders.forEach(order -> orderTotalPriceMap.put(order, order.getTotalPrice()));

        return orderTotalPriceMap;
    }

    public double getAverageTotalPrice(List<Order> orders) {
        return orders.stream().mapToDouble(Order::getTotalPrice).average().getAsDouble();
    }

    public Map<Item, Double> getAveragePriceByItem(List<Order> orders) {
        Map<Item, Double> itemTotalPriceMap = new HashMap<>();
        Map<Item, Integer> itemCountMap = new HashMap<>();

        orders.forEach(order -> order.getItems().forEach(item -> {
            if (!itemCountMap.containsKey(item)) {
                itemCountMap.put(item, 1);
                itemTotalPriceMap.put(item, item.getPrice());
            } else {
                int currentCount = itemCountMap.get(item);
                double currentTotalPrice = itemTotalPriceMap.get(item);

                int newCount = ++currentCount;
                double newTotalPrice = currentTotalPrice + item.getPrice();

                itemCountMap.put(item, newCount);
                itemTotalPriceMap.put(item, newTotalPrice);
            }
        }));
        Map<Item, Double> itemAveragePriceMap = new HashMap<>();

        itemCountMap.forEach((item, count) -> {
            double totalPrice = itemTotalPriceMap.get(item);

            itemAveragePriceMap.put(item, (totalPrice / count));
        });
        return itemAveragePriceMap;
    }
}
