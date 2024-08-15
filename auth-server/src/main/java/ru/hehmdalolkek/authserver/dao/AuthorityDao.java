package ru.hehmdalolkek.authserver.dao;

import org.springframework.data.repository.CrudRepository;
import ru.hehmdalolkek.authserver.model.Authority;

public interface AuthorityDao extends CrudRepository<Authority, Long> {
}
