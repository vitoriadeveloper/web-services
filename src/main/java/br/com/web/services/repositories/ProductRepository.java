package br.com.web.services.repositories;

import br.com.web.services.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long > {
}
