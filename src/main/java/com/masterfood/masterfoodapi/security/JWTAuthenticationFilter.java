package com.masterfood.masterfoodapi.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.masterfood.masterfoodapi.domain.dto.CredentialsDto;
import com.wirelabs.security.JWTUtil;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    private JWTUtil jwtUtil;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil) {
        setAuthenticationFailureHandler(new JWTAuthenticationFailureHandler());
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) {

        try {
            CredentialsDto creds = new ObjectMapper().readValue(req.getInputStream(), CredentialsDto.class);

            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(creds.getEmail(),
                    creds.getPassword(), new ArrayList<>());

            return authenticationManager.authenticate(authToken);
        } catch (IOException e) {
            throw new AuthenticationCredentialsNotFoundException("Error on authentication jwt", e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth)
            throws IOException, ServletException {
        UserSecurity user = ((UserSecurity) auth.getPrincipal());
        String token = "Bearer " + jwtUtil.generateToken(user.getUsername());
        user.setToken(token);
        res.addHeader("Authorization", token);
        res.addHeader("Content-Type", "application/json");
        res.addHeader("access-control-expose-headers", "Authorization");
        res.getWriter()
                .append(new ObjectMapper().writeValueAsString(user));
    }

    private class JWTAuthenticationFailureHandler implements AuthenticationFailureHandler {

        @Override
        public void onAuthenticationFailure(HttpServletRequest request,
                                            HttpServletResponse response,
                                            AuthenticationException exception)
                throws IOException, ServletException {
            response.setStatus(401);
            response.setContentType("application/json");
            response.getWriter()
                    .append(errorJson());
        }

        private String errorJson() {
            long date = new Date().getTime();
            return "{\"timestamp\": " + date + ", " + "\"status\": 401, " + "\"error\": \"Not authorized\", " +
                    "\"message\": \"Email or password invalid\", " + "\"path\": \"/login\"}";
        }

    }
}