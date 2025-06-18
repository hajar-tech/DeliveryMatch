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
        Utilisateur utilisateur;

        switch (utilisateurDto.role()) {
            case "Conducteur" -> utilisateur = new Conducteur();
            case "Expediteur" -> utilisateur = new Expediteur();
            case "Admin" -> utilisateur = new Admin();
            default -> throw new IllegalArgumentException("Rôle non valide : " + utilisateurDto.role());
        }

        utilisateur.setNomComplet(utilisateurDto.nom());
        utilisateur.setEmail(utilisateurDto.email());
        utilisateur.setPassword(utilisateurDto.password());

        return utilisateurMapper.utilisateurToDto(userRepository.save(utilisateur));
    }

    @Override
    public UtilisateurDto modifierUtilisateur(Long id, UtilisateurDto utilisateurDto) {
        Utilisateur utilisateur = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La utilisateur n'existe pas"));
        System.out.println("Modifier utilisateur ID: " + id);
        utilisateur.setNomComplet(utilisateurDto.nom());
        utilisateur.setEmail(utilisateurDto.email());
        utilisateur.setPassword(utilisateurDto.password());

        return utilisateurMapper.utilisateurToDto(userRepository.save(utilisateur)) ;
    }
}
