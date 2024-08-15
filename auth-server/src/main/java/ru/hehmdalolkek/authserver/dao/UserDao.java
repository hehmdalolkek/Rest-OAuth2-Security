package ru.hehmdalolkek.authserver.dao;

import org.springframework.data.repository.CrudRepository;
import ru.hehmdalolkek.authserver.model.AuthUser;

import java.util.Optional;

public interface UserDao extends CrudRepository<AuthUser, Long> {

    Optional<AuthUser> findByUsername(String username);

}
