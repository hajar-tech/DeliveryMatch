import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {Observable, tap} from 'rxjs';

export interface LoginRequest {
  email: string;
  password: string;
}

export interface LoginResponse {
  token: string;
  id: number;
  role: string;
  email: string;
}

export interface RegisterRequest{
  nom : string;
  email : string;
  password : string;
  typeUtilisateur: string;
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8080/api/auth';


  constructor(private http: HttpClient , private router: Router) { }

  register(data: RegisterRequest):Observable<string> {
    return this.http.post<string>(`${this.apiUrl}/register`, data);
  }

  login(request: LoginRequest): Observable<LoginResponse> {
    return this.http.post<LoginResponse>(`${this.apiUrl}/login`, request).pipe(
      tap(response => {
        this.setToken(response.token);
        this.setLoggedInUser(response);
      })
    );
  }


  logout(): void {
    localStorage.clear(); // Clear all user-related data (token, user info)
    this.router.navigate(['/login']);
  }

  setToken(token: string): void {
    localStorage.setItem('jwt_token', token);
  }

  getToken(): string | null {
    return localStorage.getItem('jwt_token');
  }

  setLoggedInUser(response: LoginResponse): void {
    localStorage.setItem('user_id', response.id.toString());
    localStorage.setItem('user_role', response.role);
    localStorage.setItem('user_email', response.email);
  }
  getUserId(): string | null {
    return localStorage.getItem('user_id');
  }

  getUserRole(): string | null {
    return localStorage.getItem('user_role');
  }

  getUserEmail(): string | null {
    return localStorage.getItem('user_email');
  }

  isLoggedIn(): boolean {
    const token = this.getToken();
    // Basic check: is token present? (You might add token validation/expiration check here)
    return !!token;
  }

}
