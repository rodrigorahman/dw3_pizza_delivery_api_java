package br.com.academiadoflutter.pizzaDeliveryApi.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="cardapio_grupo")
@Getter
@Setter
public class MenuE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cardapio_grupo")
    private Long id;
    @Column(name="nome_grupo")
    private String name;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "menu")
    private List<MenuItemE> items;

}
