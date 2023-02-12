package br.com.mentorama.Mod05TestesUnitarios.service;

import br.com.mentorama.Mod05TestesUnitarios.model.Order;
import br.com.mentorama.Mod05TestesUnitarios.model.OrderItem;
import br.com.mentorama.Mod05TestesUnitarios.model.Product;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderCalculatorTest {

    @Test
    public void shouldCalculateTotalOrderPrice() {
        final OrderCalculator orderCalculator = new OrderCalculator();
        final Order order = new Order(aListOfOrderItems());
        final Double result = orderCalculator.calculateOrder(order);
        assertEquals(30, result);
    }

    @Test
    public void shouldCalculateTotalOfMultipleOrders() {
        final OrderCalculator orderCalculator = new OrderCalculator();
        final List<Order> orders =
                Arrays.asList(
                        new Order(aListOfOrderItems()),
                        new Order(aListOfOrderItems())
                );
        final Double result = orderCalculator.calculateMultipleOrders(orders);
        assertEquals(60.0, result);
    }

    private List<OrderItem> aListOfOrderItems() {
        return Arrays.asList(
                aOderItem(2, 0.0, 10.0, 0.10),
                aOderItem(10, 0.0, 1.0, 0.10)
        );
    }

    private OrderItem aOderItem(final Integer quantity,
                                final Double discount,
                                final Double price,
                                final Double maxDiscountPercentage) {
        final Product product = new Product(1L, "TESTE", price, maxDiscountPercentage);
        return new OrderItem(product, quantity, discount);
    }
}