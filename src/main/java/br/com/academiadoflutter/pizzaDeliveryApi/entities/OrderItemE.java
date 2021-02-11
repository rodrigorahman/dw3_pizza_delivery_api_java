package br.com.academiadoflutter.pizzaDeliveryApi.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="pedido_item")
@Getter
@Setter
public class OrderItemE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido_item")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_cardapio_grupo_item")
    private MenuItemE menu;
    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private OrderE order;
}
