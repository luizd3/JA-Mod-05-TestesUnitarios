package br.com.mentorama.mod05testesunitarios.model;

import java.util.List;

// DTO - Data Transfer Object - Serve para encapsular uma lista de produtos (neste caso)
public class ProductDTO {

    private List<Product> products;

    public ProductDTO(List<Product> products) {
        this.products = products;
    }

    public ProductDTO() {

    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}