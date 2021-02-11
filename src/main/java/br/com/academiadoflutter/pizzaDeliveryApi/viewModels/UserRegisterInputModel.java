package br.com.academiadoflutter.pizzaDeliveryApi.viewModels;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserRegisterInputModel {
    private String name;
    private String email;
    private String password;
}
