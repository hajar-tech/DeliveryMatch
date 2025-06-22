import { Component } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {AuthService, LoginRequest} from '../../core/services/auth/auth.service';
import {Router} from '@angular/router';
import {NgIf} from '@angular/common';

@Component({
  selector: 'app-login',
  imports: [
    FormsModule,
    NgIf
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  loginRequest: LoginRequest = {
    email: '',
    password: ''
  };

  errorMessage: string = '';

  constructor(private authService: AuthService, private router: Router) {}

  onSubmit(): void {
    if (!this.loginRequest.email || !this.loginRequest.password) {
      this.errorMessage = "Veuillez remplir tous les champs.";
      return;
    }

    this.authService.login(this.loginRequest).subscribe({
      next: () => {
        this.errorMessage = '';
        const role = localStorage.getItem('role');

        // Redirection selon le rôle
        if (role === 'ADMIN') {
          this.router.navigate(['/admin/dashboard']);
        } else if (role === 'EXPEDITEUR') {
          this.router.navigate(['/list-trajet']);
        } else {
          this.router.navigate(['/trajrtId']);
        }
      },
      error: (error) => {
        console.error("Erreur de connexion complète:", error);
        this.errorMessage = error;
      }
    });
  }
}
