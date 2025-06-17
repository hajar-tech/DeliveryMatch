package com.deliveryMatch.backend.mappers;

import com.deliveryMatch.backend.dtos.UtilisateurDto;
import com.deliveryMatch.backend.modules.Admin;
import com.deliveryMatch.backend.modules.Conducteur;
import com.deliveryMatch.backend.modules.Expediteur;
import com.deliveryMatch.backend.modules.Utilisateur;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public class UtilisateurMapper {
    @Mapping(target = "role", expression = "java(getRole(utilisateur))")
   public UtilisateurDto utilisateurToDto(Utilisateur utilisateur) {
        return null;
    }
    public String getRole(Utilisateur utilisateur) {
        if (utilisateur instanceof Conducteur) return "Conducteur";
        if (utilisateur instanceof Expediteur) return "Expediteur";
        if (utilisateur instanceof Admin) return "Admin";
        return "Inconnu";
    }

   public List<UtilisateurDto> entityToList(List<Utilisateur> utilisateurs) {
        return List.of();
    }

}
