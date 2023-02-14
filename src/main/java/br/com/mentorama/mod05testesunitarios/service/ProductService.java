package br.com.mentorama.mod05testesunitarios.service;

import br.com.mentorama.mod05testesunitarios.clients.ProductClientAPI;
import br.com.mentorama.mod05testesunitarios.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductClientAPI client;

    public List<Product> findAll() {
        return client.findAll();
    }

}