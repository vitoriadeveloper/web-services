package br.com.web.services.repositories;

import br.com.web.services.entities.OrderItem;
import br.com.web.services.entities.OrderItemPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk> {
}
