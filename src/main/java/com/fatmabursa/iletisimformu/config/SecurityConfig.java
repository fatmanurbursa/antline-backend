package com.fatmabursa.iletisimformu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/api/iletisim").permitAll() // Form herkes tarafından gönderilebilir
                        .requestMatchers(HttpMethod.GET, "/api/iletisim").authenticated() // Ama verileri sadece admin görebilir
                        .anyRequest().permitAll()
                ).httpBasic();
        return http.build();
    }
}
