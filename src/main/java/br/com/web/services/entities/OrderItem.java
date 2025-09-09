package br.com.web.services.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "pedido_item")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderItem implements Serializable {

    @EmbeddedId
    private OrderItemPk id = new OrderItemPk();

    @Column(name = "quantidade")
    private Integer quantity;

    @Column(name = "preco")
    private Double price;

    // --- Acesso direto ao pedido e produto, mapeados pelo id ---
    @ManyToOne
    @MapsId("order") // usa o campo "order" da PK
    @JoinColumn(name = "pedido_id")
    private Order order;

    @ManyToOne
    @MapsId("product") // usa o campo "product" da PK
    @JoinColumn(name = "produto_id")
    private Product product;
}
