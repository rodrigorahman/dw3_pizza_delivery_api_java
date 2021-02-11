package br.com.academiadoflutter.pizzaDeliveryApi.web.user.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
