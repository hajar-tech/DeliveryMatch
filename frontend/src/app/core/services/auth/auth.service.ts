import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {Router} from '@angular/router';
import {catchError, Observable, tap, throwError} from 'rxjs';

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


  constructor(private http: HttpClient ) { }

  register(data: RegisterRequest): Observable<string> {
    return this.http.post(`${this.apiUrl}/register`, data, { responseType: 'text' }).pipe(
      catchError(this.manageErors)
    );
  }


  login(data: LoginRequest): Observable<LoginResponse> {
    return this.http.post<LoginResponse>(`${this.apiUrl}/login`, data).pipe(
      tap((response) => {
        localStorage.setItem('token', response.token);
        localStorage.setItem('id', response.id.toString());
        localStorage.setItem('role', response.role);
        localStorage.setItem('email', response.email);
      }),
      catchError(this.manageErors)
    );
  }



  private manageErors(error: HttpErrorResponse) {
    const message = error.error instanceof ErrorEvent
      ? error.error.message
      : error.error?.message || 'Erreur inconnue.';
    return throwError(() => message);
  }






}
