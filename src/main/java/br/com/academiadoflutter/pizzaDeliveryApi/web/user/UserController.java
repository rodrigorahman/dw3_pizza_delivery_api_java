package br.com.academiadoflutter.pizzaDeliveryApi.web.user;

import br.com.academiadoflutter.pizzaDeliveryApi.excetion.UserNotFoundException;
import br.com.academiadoflutter.pizzaDeliveryApi.services.UserService;
import br.com.academiadoflutter.pizzaDeliveryApi.viewModels.UserRegisterInputModel;
import br.com.academiadoflutter.pizzaDeliveryApi.web.user.dto.LoginRequest;
import br.com.academiadoflutter.pizzaDeliveryApi.web.user.dto.LoginResponse;
import br.com.academiadoflutter.pizzaDeliveryApi.web.user.dto.RegisterUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/auth")
    public ResponseEntity login(@RequestBody LoginRequest loginRequest) {
        try {
            final var user = userService.login(loginRequest.getEmail(), loginRequest.getPassword());
            return ResponseEntity.ok(LoginResponse.entityToResponse(user));
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @PostMapping("/")
    public void register(@RequestBody RegisterUserRequest request){
        final var inputModel = new UserRegisterInputModel(
                request.getName(),
                request.getEmail(),
                request.getPassword()
        );
        userService.register(inputModel);
    }
}
