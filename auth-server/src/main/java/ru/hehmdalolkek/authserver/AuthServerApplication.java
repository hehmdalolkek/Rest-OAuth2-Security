package ru.hehmdalolkek.authserver;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.hehmdalolkek.authserver.dao.AuthorityDao;
import ru.hehmdalolkek.authserver.dao.UserDao;
import ru.hehmdalolkek.authserver.model.AuthUser;
import ru.hehmdalolkek.authserver.model.Authority;

import java.util.Set;

@SpringBootApplication
public class AuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServerApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner(UserDao userDao, AuthorityDao authorityDao, PasswordEncoder passwordEncoder) {
        return args -> {
            Authority authority = authorityDao.save(new Authority(1L, "ROLE_ADMIN"));
            userDao.save(
                    new AuthUser(
                            1L,
                            "user1",
                            passwordEncoder.encode("user1"),
                            Set.of(authority)));
            userDao.save(
                    new AuthUser(
                            2L,
                            "user2",
                            passwordEncoder.encode("user2"),
                            Set.of(authority)));
        };
    }

}
