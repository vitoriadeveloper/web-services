package br.com.web.services.services;


import br.com.web.services.entities.Product;
import br.com.web.services.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return this.productRepository.findById(id);
    }
}
