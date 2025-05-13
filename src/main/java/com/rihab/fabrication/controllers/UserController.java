package com.rihab.fabrication.controllers;

import com.rihab.fabrication.DTO.UserRequestDTO;
import com.rihab.fabrication.DTO.UserResponseDTO;
import com.rihab.fabrication.Services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;

    // Constructeur pour injecter le UserService
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Gestion des erreurs
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleException(Exception e) {
        Map<String, String> errorResponse = new HashMap<>();

        if (e instanceof IllegalArgumentException) {
            errorResponse.put("message", e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        } else if (e instanceof IllegalStateException) {
            errorResponse.put("message", e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
        } else {
            errorResponse.put("message", "Une erreur inattendue s'est produite");
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Inscription d'un utilisateur
    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO response = userService.registerUser(userRequestDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Connexion d'un utilisateur
    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> login(@RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO response = userService.loginUser(userRequestDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
