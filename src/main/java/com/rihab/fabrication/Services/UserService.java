package com.rihab.fabrication.Services;

import org.springframework.stereotype.Service;

import com.rihab.fabrication.DTO.UserRequestDTO;
import com.rihab.fabrication.DTO.UserResponseDTO;
import com.rihab.fabrication.models.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.util.List;

@Service  // Changez ici l'annotation pour @Service
public class UserService {

    @PersistenceContext
    private EntityManager entityManager;

    // Vérifier si un utilisateur existe déjà avec le même nom d'utilisateur
    public boolean userExists(String username) {
        TypedQuery<Long> query = entityManager.createQuery(
                "SELECT COUNT(u) FROM User u WHERE u.username = :username", Long.class);
        query.setParameter("username", username);
        return query.getSingleResult() > 0;
    }

    // Inscription d'un utilisateur sans hachage de mot de passe
    @Transactional
    public UserResponseDTO registerUser(UserRequestDTO dto) {
        // Vérifier si les champs obligatoires sont présents
        if (dto.getUsername() == null || dto.getUsername().trim().isEmpty() ||
            dto.getPassword() == null || dto.getPassword().trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom d'utilisateur et le mot de passe sont obligatoires");
        }

        // Vérifier si l'utilisateur existe déjà
        if (userExists(dto.getUsername())) {
            throw new IllegalStateException("Un utilisateur avec ce nom d'utilisateur existe déjà");
        }

        try {
            // Créer l'utilisateur
            User user = new User();
            user.setUsername(dto.getUsername());
            user.setPassword(dto.getPassword());  // Mot de passe en texte clair
            user.setEmail(dto.getEmail());

            entityManager.persist(user);
            entityManager.flush(); // Forcer la persistance immédiate

            // Réponse DTO
            UserResponseDTO responseDto = new UserResponseDTO();
            responseDto.setId(user.getId());
            responseDto.setUsername(user.getUsername());
            responseDto.setEmail(user.getEmail());

            return responseDto;
        } catch (Exception e) {
            // Log l'exception
            System.err.println("Erreur lors de l'inscription: " + e.getMessage());
            e.printStackTrace();
            throw e; // Relancer l'exception pour qu'elle soit gérée par le contrôleur
        }
    }

    // Connexion d'un utilisateur sans hachage de mot de passe
    public UserResponseDTO loginUser(UserRequestDTO dto) {
        // Vérifier si les champs obligatoires sont présents
        if (dto.getUsername() == null || dto.getUsername().trim().isEmpty() ||
            dto.getPassword() == null || dto.getPassword().trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom d'utilisateur et le mot de passe sont obligatoires");
        }

        try {
            // Récupérer l'utilisateur par son nom d'utilisateur
            TypedQuery<User> query = entityManager.createQuery(
                    "SELECT u FROM User u WHERE u.username = :username", User.class);
            query.setParameter("username", dto.getUsername());

            User user = null;
            try {
                user = query.getSingleResult();
            } catch (NoResultException e) {
                // Aucun utilisateur trouvé avec ce nom d'utilisateur
                throw new IllegalArgumentException("Nom d'utilisateur ou mot de passe incorrect");
            }

            // Vérifier si le mot de passe est correct (comparaison directe)
            if (user != null && dto.getPassword().equals(user.getPassword())) {
                UserResponseDTO responseDto = new UserResponseDTO();
                responseDto.setId(user.getId());
                responseDto.setUsername(user.getUsername());
                responseDto.setEmail(user.getEmail());
                return responseDto;
            } else {
                throw new IllegalArgumentException("Nom d'utilisateur ou mot de passe incorrect");
            }
        } catch (NoResultException e) {
            throw new IllegalArgumentException("Nom d'utilisateur ou mot de passe incorrect");
        } catch (Exception e) {
            // Log l'exception
            System.err.println("Erreur lors de la connexion: " + e.getMessage());
            e.printStackTrace();
            throw e; // Relancer l'exception pour qu'elle soit gérée par le contrôleur
        }
    }
}
