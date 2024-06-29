package com.workflow.WorkFlowDEMO.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.workflow.WorkFlowDEMO.data.dto.employee.EmployeeDto;
import com.workflow.WorkFlowDEMO.data.service.employee.EmployeeService;
import com.workflow.WorkFlowDEMO.data.service.employee.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserAuthProvider {



        private final String secretKey;
        private final EmployeeService employeeService;

        public UserAuthProvider(@Value("${security.jwt.token.secret.key:secret-value}") String secretKey, EmployeeServiceImpl employeeService) {
            this.secretKey = secretKey;
            this.employeeService = employeeService;
        }

        public String createToken(String username) {
            // Set token expiration time, for example, 10 hours
            long expirationTime = 10 * 60 * 60 * 1000;
            return JWT.create()
                    .withIssuer(username)
                    .withIssuedAt(new Date())
                    .withExpiresAt(new Date(System.currentTimeMillis() + expirationTime))
                    .sign(Algorithm.HMAC256(secretKey));
        }

        public Authentication validateToken(String token) {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secretKey)).build();
            DecodedJWT decoded = verifier.verify(token);
            EmployeeDto user = employeeService.findByLogin(decoded.getIssuer());
            if (user == null) {
                throw new RuntimeException("User not found");
            }
            List<SimpleGrantedAuthority> authorities = user.getRoles().stream()
                    .map(role -> new SimpleGrantedAuthority(role.getName()))
                    .collect(Collectors.toList());
            return new UsernamePasswordAuthenticationToken(user, null, authorities);
        }
}
