package com.deliveryMatch.backend.services.implementationServices;

import com.deliveryMatch.backend.dtos.UtilisateurDto;
import com.deliveryMatch.backend.mappers.UtilisateurMapper;
import com.deliveryMatch.backend.modules.Admin;
import com.deliveryMatch.backend.modules.Conducteur;
import com.deliveryMatch.backend.modules.Expediteur;
import com.deliveryMatch.backend.modules.Utilisateur;
import com.deliveryMatch.backend.repository.UserRepository;
import com.deliveryMatch.backend.services.InterfaceServices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Userimpl implements UserService {

    private final UserRepository userRepository;
    private final UtilisateurMapper utilisateurMapper;

    @Autowired
    public Userimpl(UserRepository userRepository, UtilisateurMapper utilisateurMapper) {
        this.userRepository = userRepository;
        this.utilisateurMapper = utilisateurMapper;
    }

    @Override
    public UtilisateurDto creerUtilisateur(UtilisateurDto utilisateurDto) {
        Utilisateur utilisateur = new Utilisateur();
        switch (utilisateurDto.role()){
            case "Admin" -> new Admin();
            case "Expediteur" -> new Expediteur();
            case "Conducteur" -> new Conducteur();
            default -> throw new RuntimeException("Rôle invalide");
        }
        utilisateur.setNomComplet(utilisateurDto.nom());
        utilisateur.setEmail(utilisateurDto.email());
        utilisateur.setPassword(utilisateurDto.password());

        return utilisateurMapper.utilisateurToDto(userRepository.save(utilisateur));
    }
}
