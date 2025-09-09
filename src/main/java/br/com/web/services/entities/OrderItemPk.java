package br.com.web.services.entities;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;


@Embeddable
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class OrderItemPk implements Serializable {
    @ManyToOne
    private Order order;

    @ManyToOne
    private Product product;

}
