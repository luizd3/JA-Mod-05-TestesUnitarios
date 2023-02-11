package br.com.mentorama.Mod05TestesUnitarios.service;

import br.com.mentorama.Mod05TestesUnitarios.model.OrderItem;

import java.util.List;

public class OrderCalculator {

    public Double calculateOrder(final List<OrderItem> items) {
        return items.stream().mapToDouble(OrderItem::totalPrice)
                .sum();
    }
}
