package br.com.academiadoflutter.pizzaDeliveryApi.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="usuario")
@Getter
@Setter
public class UserE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_usuario")
    private Long id;
    @Column(name="nome")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name="senha")
    private String password;


}
