package br.com.academiadoflutter.pizzaDeliveryApi.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="cardapio_grupo_item")
@Getter
@Setter
public class MenuItemE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cardapio_grupo_item")
    private Long id;
    @Column(name = "nome")
    private String name;
    @Column(name = "valor")
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "id_cardapio_grupo")
    private MenuE menu;
}
