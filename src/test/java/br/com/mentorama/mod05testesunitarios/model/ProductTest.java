package br.com.mentorama.mod05testesunitarios.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    public void shouldCalculateTotalPriceWithDiscount() {
        Product product = new Product(1l, "TESTE", 100.0, 0.10);
        Double result = product.getPriceWithDiscount(0.10);
        assertEquals(90.0, result);
    }

    @Test
    public void whenDiscountIsHigherThanMaxDiscountShouldUseMaxDiscountPercentage() {
        Product product = new Product(1l, "TESTE", 100.0, 0.10);
        Double result = product.getPriceWithDiscount(0.15);
        assertEquals(90.0, result);
    }

    @Test
    public void whenDiscountIsLowerThanMaxDiscountShouldUseProvidedDiscount() {
        Product product = new Product(1l, "TESTE", 100.0, 0.10);
        Double result = product.getPriceWithDiscount(0.05);
        assertEquals(95.0, result);
    }

}
