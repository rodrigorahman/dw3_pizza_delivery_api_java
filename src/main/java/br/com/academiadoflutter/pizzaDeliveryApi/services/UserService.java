package br.com.academiadoflutter.pizzaDeliveryApi.services;

import br.com.academiadoflutter.pizzaDeliveryApi.entities.UserE;
import br.com.academiadoflutter.pizzaDeliveryApi.excetion.UserNotFoundException;
import br.com.academiadoflutter.pizzaDeliveryApi.repositories.UserRepository;
import br.com.academiadoflutter.pizzaDeliveryApi.viewModels.UserRegisterInputModel;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserE login(String email, String password) throws UserNotFoundException {
        final var userOpt = userRepository.findByEmail(email);

        final var user = userOpt.orElseThrow(() -> new UserNotFoundException());
        final var isUserValid = new BCryptPasswordEncoder().matches(password, user.getPassword());

        if(!isUserValid){
            throw new UserNotFoundException();
        }

        return user;
    }

    public void register(UserRegisterInputModel model) {

        final var password = new BCryptPasswordEncoder().encode(model.getPassword());
        final var user = new UserE();
        user.setName(model.getName());
        user.setEmail(model.getEmail());
        user.setPassword(password);

        userRepository.save(user);
    }

}
