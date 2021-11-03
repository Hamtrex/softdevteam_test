package com.hmsoft.softdevteam_test.security.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hmsoft.softdevteam_test.model.request.UserRequest;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static com.hmsoft.softdevteam_test.security.constant.SecurityConstants.*;


/**
 * @author hasson_medrano
 */
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            UserRequest userRequest = new ObjectMapper().readValue(request.getInputStream(), UserRequest.class);

            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    userRequest.getName(), userRequest.getPassword(), new ArrayList<>()
            ));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication auth) throws IOException {
        String token = Jwts.builder().setIssuedAt(new Date()).setIssuer(ISSUER_INFO)
//                .setSubject(((User)auth.getPrincipal()).getName())
                .setSubject(auth.getName())
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, API_SECRET_KEY).compact();
        response.addHeader(HEADER_AUTHORIZATION_KEY, TOKEN_BEARER_PREFIX + " " + token);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(
                "{\"" + "token"  + "\":\"" + token + "\"}"
        );
    }
}
