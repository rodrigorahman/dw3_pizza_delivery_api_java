package br.com.academiadoflutter.pizzaDeliveryApi.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pedido")
@Getter
@Setter
public class OrderE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long id;
    @Column(name = "endereco_entrega")
    private String address;
    @Column(name = "forma_pagamento")
    private String paymentType;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UserE user;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderItemE> items;

}
