import { Component } from '@angular/core';
import {FormGroup, FormsModule, ReactiveFormsModule} from '@angular/forms';
import {AuthService, RegisterRequest} from '../../core/services/auth/auth.service';
import {Router} from '@angular/router';
import {NgIf} from '@angular/common';

@Component({
  selector: 'app-register',
  imports: [
    ReactiveFormsModule,
    FormsModule,
    NgIf
  ],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  registerRequest: RegisterRequest = {
    nom: '',
    email: '',
    password: '',
    typeUtilisateur: ''
  };

  errorMessage: string = '';
  successMessage: string = '';

  constructor(private authService: AuthService, private router : Router) {
  }


  onSubmit(): void {

    if (!this.registerRequest.nom || !this.registerRequest.email || !this.registerRequest.password || !this.registerRequest.typeUtilisateur) {
      this.errorMessage = "Tous les champs sont obligatoires.";
      return;
    }

    if (this.registerRequest.password.length < 6) {
      this.errorMessage = "Le mot de passe doit contenir au moins 6 caractères.";
      return;
    }

    this.authService.register(this.registerRequest).subscribe({
      next: (response) => {
        console.log(" Réponse du backend :", response);
        this.successMessage = response;
        this.errorMessage = '';
        setTimeout(() => this.router.navigate(['/login']), 2000);
      },
      error: (error) => {
        console.error("Erreur d'inscription:", error);
        this.errorMessage =  error;
        this.successMessage = '';
      }
    });
  }
}
