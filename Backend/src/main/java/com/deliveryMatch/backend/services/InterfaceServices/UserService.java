package com.deliveryMatch.backend.services.InterfaceServices;

import com.deliveryMatch.backend.dtos.UtilisateurDto;

public interface UserService {
    public UtilisateurDto creerUtilisateur (UtilisateurDto utilisateurDto);

    public UtilisateurDto modifierUtilisateur (Long id ,UtilisateurDto utilisateurDto);
}
