package com.deliveryMatch.backend.services.securityService;

import com.deliveryMatch.backend.dtos.RegisterRequest;
import com.deliveryMatch.backend.modules.Admin;
import com.deliveryMatch.backend.modules.Conducteur;
import com.deliveryMatch.backend.modules.Expediteur;
import com.deliveryMatch.backend.modules.Utilisateur;
import com.deliveryMatch.backend.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(RegisterRequest registerRequest) {
        if (userRepository.findByEmail(registerRequest.email()).isPresent()){
            throw new RuntimeException("email déjà utilisé !");
        }

        Utilisateur utilisateur;

        //créer user dynamiquement selon le typeUtilisateur
        switch (registerRequest.typeUtilisateur().toLowerCase()){
            case "conducteur" -> utilisateur = new Conducteur();
            case "expediteur" -> utilisateur = new Expediteur();
            case "admin" -> utilisateur = new Admin();
            default -> throw new RuntimeException("Type d'utilisateur invalide");
        }

        utilisateur.setNomComplet(registerRequest.nom());
        utilisateur.setEmail(registerRequest.email());
        utilisateur.setPassword(passwordEncoder.encode(registerRequest.password()));

        userRepository.save(utilisateur);
    }

}
