package br.com.mentorama.mod05testesunitarios.service;

import br.com.mentorama.mod05testesunitarios.model.Order;
import br.com.mentorama.mod05testesunitarios.model.OrderItem;

import java.util.List;

public class OrderCalculator {

    public Double calculateOrder(final Order order) {
        return order.getItems().stream().mapToDouble(OrderItem::totalPrice)
                .sum();
    }

    public Double calculateMultipleOrders(final List<Order> orders) {
        return orders.stream().mapToDouble(order -> calculateOrder(order)).sum();
    }
}