package br.com.web.services.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "usuarios")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "telefone")
    private String phone;

    @Column(name = "senha")
    private String password;

    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();
}
