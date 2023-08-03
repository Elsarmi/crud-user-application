package org.nisum.controller;

import org.nisum.model.User;
import org.nisum.security.JwtUtil;
import org.nisum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<Object> registerUser(
            @Valid @RequestBody User user,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    "{\"mensaje\": \"Error en la validación\"}"
            );
        }

        if (userService.isEmailRegistered(user.getEmail())) {
            return ResponseEntity.status(
                    HttpStatus.BAD_REQUEST).body(
                            "{\"mensaje\": \"El correo ya registrado\"}"
            );
        }

        // Seteo de fecha y activación del usuario
        user.setCreated(LocalDateTime.now());
        user.setLastLogin(LocalDateTime.now());
        user.setModified(LocalDateTime.now());
        user.setActive(true);
        // Generación de Token
        user.setToken(jwtUtil.generateToken(String.valueOf(user)));

        User savedUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
        User user = userService.findByEmail(email).orElse(null);

        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            return ResponseEntity.badRequest().body("Credenciales incorrectas");
        }

        String token = jwtUtil.generateToken(email);
        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable UUID id) {
        return userService.findById(id).orElse(null);
    }
}
