package ru.hehmdalolkek.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.SecurityFilterChain;
import ru.hehmdalolkek.client.service.RestCarService;

import static org.springframework.context.annotation.ScopedProxyMode.TARGET_CLASS;
import static org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(authorizeHttpRequests ->
                        authorizeHttpRequests.anyRequest().authenticated()
                )
                .oauth2Login(oauth2Login ->
                        oauth2Login.loginPage("/oauth2/authorization/car-client"))
                .oauth2Client(Customizer.withDefaults())
                .build();
    }

    @Bean
    @Scope(value = SCOPE_REQUEST, proxyMode = TARGET_CLASS)
    public RestCarService carService(OAuth2AuthorizedClientService clientService) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String accessToken = null;
        if (authentication.getClass().isAssignableFrom(OAuth2AuthenticationToken.class)) {
            OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
            String authorizedClientRegistrationId = token.getAuthorizedClientRegistrationId();
            if (authorizedClientRegistrationId.equals("car-client")) {
                OAuth2AuthorizedClient oAuth2AuthorizedClient =
                        clientService.loadAuthorizedClient(authorizedClientRegistrationId, token.getName());
                accessToken = oAuth2AuthorizedClient.getAccessToken().getTokenValue();
            }
        }
        return new RestCarService(accessToken);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
