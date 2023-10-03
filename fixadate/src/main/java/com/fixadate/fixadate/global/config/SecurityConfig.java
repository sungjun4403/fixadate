package com.fixadate.fixadate.global.config;

import com.fixadate.fixadate.jwt.CustomAuthenticationEntryPoint;
import com.fixadate.fixadate.jwt.filter.JwtExceptionFilter;
import com.fixadate.fixadate.jwt.filter.JwtRequestFilter;
import com.fixadate.fixadate.jwt.service.JwtService;
import com.fixadate.fixadate.member.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends SecurityConfigurerAdapter {
    private final MemberRepository memberRepository;
    private final JwtService jwtService;

    private final String NO_CHECK_URL = "/login";

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors(); // deprecated for spring security 7.0 (available for now)
        http.authorizeHttpRequests().anyRequest().permitAll();
        http.headers(headers -> headers.frameOptions().disable());
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.formLogin().disable();
        http.httpBasic().disable();
        http.exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint());


        http.addFilterBefore(jwtRequestFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public JwtRequestFilter jwtRequestFilter() {
        JwtRequestFilter jwtRequestFilter = new JwtRequestFilter(memberRepository, jwtService);
        return  jwtRequestFilter;

    }

    @Bean
    public JwtExceptionFilter jwtExceptionFilter() {
        JwtExceptionFilter jwtExceptionFilter = new JwtExceptionFilter();
        return jwtExceptionFilter;
    }

}
