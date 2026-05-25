package com.auth.Auth_Service.Controller;

import com.auth.Auth_Service.Service.jwtTokenService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/auth")
    @RequiredArgsConstructor
    public class AuthController {

        private final jwtTokenService jwtService;

        @PostMapping("/login")
        public String getToken(@RequestParam("username") String username) {
            return jwtService.generateToken(username);
        }
    }
