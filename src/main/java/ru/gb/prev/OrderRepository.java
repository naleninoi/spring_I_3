package ru.gb.prev;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class OrderRepository {

    private List<Order> orders = new ArrayList<>();

    public OrderRepository() {
    }

    public Optional<Order> findById(int orderId) {
        return this.orders.stream()
                .filter(o -> o.getId() == orderId)
                .findFirst();
    }

    public List<Order> findAll() {
        return orders;
    }

    public void add(Order order) {
        this.orders.add(order);
    }

    @Override
    public String toString() {
        return "OrderRepository{" +
                "orders=" + orders +
                '}';
    }
}
