package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/security/", "/security/login", "/security/loginProc", "/security/join", "/security/joinProc").permitAll()
                        .requestMatchers("/security/admin").hasRole("ADMIN")
                        .requestMatchers("/security/my/**").hasAnyRole("ADMIN", "USER")
                        .anyRequest().authenticated()
                );

        http
                .formLogin((auth) -> auth
                        .loginPage("/security/login")
                        .loginProcessingUrl("/security/loginProc")
                        .defaultSuccessUrl("/security/")
                        .permitAll()
                );
                /*.httpBasic(Customizer.withDefaults());*/
        /*http
                .csrf((auth) -> auth.disable());*/

        http
                .sessionManagement((auth) -> auth
                        .maximumSessions(1)
                        .maxSessionsPreventsLogin(true)
                );
        http
                .sessionManagement((auth) -> auth
                        .sessionFixation().changeSessionId()
                );
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
