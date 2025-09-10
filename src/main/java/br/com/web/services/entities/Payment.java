package br.com.web.services.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "pagamentos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "data_pagamento")
    private Date moment;

    @OneToOne
    @MapsId()
    @JoinColumn(name = "pedido_id")
    @JsonIgnore
    private Order order;
}
