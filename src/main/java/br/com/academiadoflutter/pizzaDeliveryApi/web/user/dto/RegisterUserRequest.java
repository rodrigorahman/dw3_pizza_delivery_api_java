package br.com.academiadoflutter.pizzaDeliveryApi.web.user.dto;

import lombok.Data;

@Data
public class RegisterUserRequest {
    private String name;
    private String email;
    private String password;
}
