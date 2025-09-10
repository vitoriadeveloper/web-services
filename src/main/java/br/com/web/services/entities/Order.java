package br.com.web.services.entities;

import br.com.web.services.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "pedidos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order implements Serializable {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_pedido")
    @Temporal(TemporalType.TIMESTAMP)
    private Date moment;


    private Integer orderStatus;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnore
    private User client;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    public OrderStatus getOrderStatus(){
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus status){
        if(status != null){
            this.orderStatus = status.getCode();
        }
    }

}
