package com.deliveryMatch.backend.controllers;

import com.deliveryMatch.backend.dtos.UtilisateurDto;
import com.deliveryMatch.backend.services.InterfaceServices.UserService;
import com.deliveryMatch.backend.services.implementationServices.Userimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/utilisateurs")
public class UserController {

    private final Userimpl userService;

    @Autowired
    public UserController(Userimpl userService) {
        this.userService = userService;
    }

    @PostMapping("/creer")
    public UtilisateurDto creerUtilisateur(@RequestBody UtilisateurDto utilisateurDto) {
        return userService.creerUtilisateur(utilisateurDto);
    }
}
