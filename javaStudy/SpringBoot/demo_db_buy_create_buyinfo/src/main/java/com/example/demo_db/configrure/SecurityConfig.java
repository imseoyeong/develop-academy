package com.example.demo_db.configrure;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.cors.CorsConfiguration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return (request, response, authentication) -> {
            Map<String, Object> responseData = new HashMap<>();
            responseData.put("result", "로그인 성공");

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            responseData.put("username", userDetails.getUsername());
            responseData.put("role", userDetails.getAuthorities());

//            CsrfToken token = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
//            responseData.put("csrf-token", token.getToken());

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonMessage = objectMapper.writeValueAsString(responseData);

            response.setStatus(200);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(jsonMessage);
        };
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return (request, response, authentication) -> {
            Map<String, String> responseData = new HashMap<>();
            responseData.put("result", "로그인 실패");

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonMessage = objectMapper.writeValueAsString(responseData);

            response.setStatus(401);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(jsonMessage);
        };
    }

    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return (request, response, authentication) -> {
            response.setStatus(200);
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("로그아웃 성공");
        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorize -> {
                    authorize.requestMatchers("/", "/admin-login", "/admin-join", "csrf-token").permitAll();
                    authorize.requestMatchers( "/buyinfo", "/buyinfo/**").hasRole("ADMIN");
                    authorize.requestMatchers("/userinfo").hasAnyRole("USER", "ADMIN");
                    authorize.requestMatchers("/userinfo/**").hasAnyRole("USER", "ADMIN");
                    authorize.anyRequest().authenticated();
                })

                .formLogin(formLogin ->
                        formLogin.loginProcessingUrl("/admin-login")
                                .successHandler(authenticationSuccessHandler())
                                .failureHandler(authenticationFailureHandler())
                )

                .logout(logout ->
                        logout.logoutUrl("/logout")
                                .logoutSuccessHandler(logoutSuccessHandler())
                                .addLogoutHandler((request, response, authentication) -> {
                                    if (request.getSession() != null) {
                                        request.getSession().invalidate();
                                    }
                                    SecurityContextHolder.clearContext();
                                })
                                .deleteCookies("JSESSIONID")
                )

                .cors(cors -> cors.configurationSource(request -> {
                    CorsConfiguration corsConfiguration = new CorsConfiguration();
                    corsConfiguration.addAllowedOrigin("http://localhost:3000");
                    corsConfiguration.addAllowedHeader("*");
                    corsConfiguration.addAllowedMethod("*");
                    corsConfiguration.setAllowCredentials(true);
                    return corsConfiguration;
                }));

        return http.build();
    }
}
