package br.com.mentorama.Mod05TestesUnitarios.service;

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
        final List<OrderItem> orderItems = anOrder();
        final Double result = orderCalculator.calculateOrder(orderItems);
        assertEquals(30, result);
    }

    @Test
    public void shouldCalculateTotalOfMultipleOrders() {
        final OrderCalculator orderCalculator = new OrderCalculator();
        final List<List<OrderItem>> orders = Arrays.asList(anOrder(), anOrder());
        final Double result = orderCalculator.calculateMultipleOrders(orders);
        assertEquals(60.0, result);
    }

    private List<OrderItem> anOrder() {
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