package br.com.academiadoflutter.pizzaDeliveryApi.repositories;

import br.com.academiadoflutter.pizzaDeliveryApi.entities.UserE;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserE, Long> {
    Optional<UserE> findByEmail(String email);
}
