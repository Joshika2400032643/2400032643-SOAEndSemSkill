
package com.example.jwttoken;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwttoken.util.JwtUtil;

@RestController
@RequestMapping("/api/jwt")
public class JwtController {

    private final JwtUtil jwtUtil;

    // Constructor Injection
    public JwtController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    // Generate JWT Token
    @GetMapping("/generate")
    public String generateToken(
            @RequestParam String username) {

        return jwtUtil.generateToken(username);
    }

    // Validate JWT Token
    @GetMapping("/validate")
    public String validateToken(
            @RequestParam String token,
            @RequestParam String username) {

        boolean isValid = jwtUtil.validateToken(token, username);

        if (isValid) {
            return "JWT Token is Valid!";
        } else {
            return "JWT Token is Invalid!";
        }
    }
}
