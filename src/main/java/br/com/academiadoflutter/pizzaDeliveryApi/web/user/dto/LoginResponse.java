package br.com.academiadoflutter.pizzaDeliveryApi.web.user.dto;

import br.com.academiadoflutter.pizzaDeliveryApi.entities.UserE;
import lombok.Data;

@Data
public class LoginResponse {
    private Long id;
    private String name;
    private String email;

    public static LoginResponse entityToResponse(UserE user){
        final var resp = new LoginResponse();
        resp.setId(user.getId());
        resp.setName(user.getName());
        resp.setEmail(user.getEmail());
        return resp;
    }
}
