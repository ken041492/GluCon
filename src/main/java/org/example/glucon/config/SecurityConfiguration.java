package org.example.glucon.config;

import lombok.RequiredArgsConstructor;
import org.example.glucon.config.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;

    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable)  //禁止CSRF（跨站請求偽造）保護。
                .authorizeHttpRequests((authorize) -> authorize //對所有訪問HTTP端點的HttpServletRequest進行限制
                        .requestMatchers(
                                "/api/**",
                                "/api/auth",
                                "/api/register",
                                "/api/register/**",
                                "/api/verification/**",
                                "/api/password/forgot"
                        )
                        .permitAll()   //指定上述匹配規則中的路徑，允許所有用戶訪問，即不需要進行身份驗證。
                        .anyRequest()
                        .authenticated()   //其他尚未匹配到的路徑都需要身份驗證
                )
                .sessionManagement((session) -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)//配置無狀態身份驗證的持久性
                )
                .authenticationProvider(authenticationProvider)//配置了身份驗證提供者
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
