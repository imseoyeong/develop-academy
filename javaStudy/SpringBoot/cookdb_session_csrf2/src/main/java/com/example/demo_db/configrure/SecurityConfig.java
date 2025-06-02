package com.example.demo_db.configrure;

import com.example.demo_db.exception.RoleAuthenticationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.cors.CorsConfiguration;

import java.io.IOException;
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
        return((request, response, authentication) -> {
            Map<String, Object> responseData = new HashMap<>();
            responseData.put("result", "로그인 성공");

            CsrfToken csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
            responseData.put("login-csrf-token", csrfToken.getToken());

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonmessage = objectMapper.writeValueAsString(responseData);

            response.setStatus(200); // HTTP 401 Unauthorized
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(jsonmessage);
        });

    };

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return((request, response, exception) -> {

            Map<String, Object> responseData = new HashMap<>();
            responseData.put("error", "로그인 실패 :" + exception.getMessage());

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonmessage = objectMapper.writeValueAsString(responseData);

            response.setStatus(401); // HTTP 401 Unauthorized
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(jsonmessage);

        });
    }



    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return((request, response, authentication) -> {
            response.setStatus(200); // 성공 응답 상태 코드
            response.getWriter().write("Logout successful");
        });
    }



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(csrf->csrf.disable())
//            http    .cors(cors->{})
               http.authorizeHttpRequests(authorize->
//                    authorize.requestMatchers("/**").permitAll()
//

                                authorize.requestMatchers("/csrf-token", "/").permitAll()
                                        .requestMatchers("/userinfo/join-userinfo", "/buyinfo/new").hasRole("ADMIN")
//                                        .requestMatchers("/user").hasAnyRole("USER", "ADMIN")
//                                        .requestMatchers("/normal").authenticated()
//                                        .requestMatchers("/master").denyAll()
                                        .anyRequest().authenticated()

                )
                .formLogin(form->
                        form.loginProcessingUrl("/login")
                                .successHandler(authenticationSuccessHandler())
                                .failureHandler(authenticationFailureHandler())
                )
                .logout(logout->
                        logout.logoutUrl("/logout")
                                .logoutSuccessHandler(logoutSuccessHandler())
                                .addLogoutHandler((request, response, authentication) -> {
                                    if(request.getSession()!=null) {
                                        request.getSession().invalidate();
                                    }
                                    SecurityContextHolder.clearContext();
                                })
                                .deleteCookies("JSESSIONID"))

                .cors(cors->cors.configurationSource(request -> {
                    CorsConfiguration config = new CorsConfiguration();
                    config.setAllowCredentials(true);
                    config.addAllowedOrigin("http://localhost:3000");
                    config.addAllowedHeader("*");
                    config.addAllowedMethod("*");
                    return config;
                }));

        return http.build();
    }
}

