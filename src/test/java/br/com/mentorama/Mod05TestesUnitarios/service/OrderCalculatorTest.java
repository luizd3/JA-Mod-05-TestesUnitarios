package br.com.mentorama.Mod05TestesUnitarios.service;

import br.com.mentorama.Mod05TestesUnitarios.model.Order;
import br.com.mentorama.Mod05TestesUnitarios.model.OrderItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class OrderCalculatorTest {

    private final OrderCalculator orderCalculator;

    public OrderCalculatorTest() {
        this.orderCalculator = new OrderCalculator();
    }

//    @BeforeEach //Podemos utilizar um construtor vazio para usar a mesma instância em todos os testes.
//    void setUp() {
//        this.orderCalculator = new OrderCalculator();
//    }

    @Test
    public void shouldCalculateTotalOrderPrice() {
        final Order order = new Order(aListOfOrderItems());
        final Double result = orderCalculator.calculateOrder(order);
        assertEquals(30, result);
    }

    @Test
    public void shouldCalculateTotalOfMultipleOrders() {
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
                anOrderItem(20.0),
                anOrderItem(10.0)
        );
    }

    private OrderItem anOrderItem(final Double expectedValue) {
//        final Product product = mock(Product.class);
//        when(product.getPriceWithDiscount(Mockito.anyDouble())).thenReturn(expectedValue);
        // Não precisamos mockar Product, basta mockar OrderItem diretamente.
        OrderItem orderItem = mock(OrderItem.class);
        when(orderItem.totalPrice()).thenReturn(expectedValue);
        return orderItem;
    }
}