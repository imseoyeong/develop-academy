package com.example.demo_db.configrure;

import com.example.demo_db.component.CustomAuthenticationEntryPoint;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class SecurityConfig {
    private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

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

            CsrfToken token = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
            responseData.put("csrf-token", token.getToken());

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
        return (request, response, auth) -> {
            response.setStatus(200);
            response.setCharacterEncoding("UTF-8"); // 한글이 들어가면 유니코드 넣어줘야 함.
            response.getWriter().write("로그아웃 성공");
        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(csrf -> csrf.disable())
        http.authorizeHttpRequests(authorize -> {
                    authorize.requestMatchers("/", "/login", "/admin-join", "/csrf-token", "/password").permitAll();
                    authorize.requestMatchers("/buyinfo", "/buyinfo/**").hasRole("ADMIN");
                    authorize.requestMatchers("/userinfo").hasAnyRole("USER", "ADMIN");
                    authorize.requestMatchers("/userinfo/**").hasAnyRole("USER", "ADMIN");
                    authorize.anyRequest().authenticated();
                })

                .formLogin(form ->
                        form.loginProcessingUrl("/login")
                                .successHandler(authenticationSuccessHandler())
                                .failureHandler(authenticationFailureHandler())
                )

                .logout(logout ->
                        logout.logoutUrl("/logout")
                                .logoutSuccessHandler(logoutSuccessHandler())
                                .addLogoutHandler(((request, response, authentication) -> {
                                    if (request.getSession() != null) {
                                        request.getSession().invalidate();
                                    }
                                    SecurityContextHolder.clearContext();
                                }))
                                .deleteCookies("JSESSIONID")
                )

                .cors(cors -> cors.configurationSource(request -> {
                    CorsConfiguration corsConfiguration = new CorsConfiguration();
                    corsConfiguration.addAllowedOrigin("http://localhost:3000");
                    corsConfiguration.addAllowedHeader("*");
                    corsConfiguration.addAllowedMethod("*");
                    corsConfiguration.setAllowCredentials(true);
                    return corsConfiguration;
                }))

                .sessionManagement(session ->
                        session.maximumSessions(1)
                                .maxSessionsPreventsLogin(false)
                                .expiredSessionStrategy(event -> {
                                    HttpServletResponse response = event.getResponse();
                                    response.setCharacterEncoding("UTF-8");
                                    response.getWriter().write("다른 호스트에서 로그인하여 현재 세션이 만료되었습니다.");
                                })
                )

                .exceptionHandling(exception ->
                        exception.authenticationEntryPoint(this.customAuthenticationEntryPoint)
                );

        return http.build();
    }
}
