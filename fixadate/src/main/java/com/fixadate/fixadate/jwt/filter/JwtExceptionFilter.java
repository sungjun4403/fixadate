package com.fixadate.fixadate.jwt.filter;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.oauth2.sdk.ErrorObject;


import com.fixadate.fixadate.jwt.exception.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.web.filter.OncePerRequestFilter;


//public class JwtExceptionFilter {
//}

public class JwtExceptionFilter extends OncePerRequestFilter {

    ObjectMapper objectMapper;

    private final String NO_CHECK_URL = "/auth/github/callback";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getRequestURI().equals(NO_CHECK_URL)) {
            filterChain.doFilter(request, response);
            return;
        }

        try {
            filterChain.doFilter(request, response);
        }
        catch (JwtException e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setCharacterEncoding("UTF-8");
            ErrorObject errorObject = new ErrorObject(
                    "jwt_access_token", e.getMessage()
            );
            objectMapper.writeValue(response.getWriter(), errorObject);
        }



    }
}

