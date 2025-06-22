import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import {catchError, Observable, throwError} from 'rxjs';

export interface AnnonceTrajetDto {
  id: number;
  conducteurId: number;
  lieuDepart: string;
  etapeIntermediaire: string;
  destinationFinale: string;
  typeMarchandise: string;
  dimensionMaximales: string;
  capaciteDisponible: number;
  dateDepart: string;
  dateAnance: string;
}

@Injectable({
  providedIn: 'root'
})
export class AnnonceService {
  private apiUrl = 'http://localhost:8080/api/annonces';

  constructor(private http: HttpClient) {}

  creerAnnonce(data: any): Observable<any> {
    const token = localStorage.getItem('token');

    const headers = new HttpHeaders({
      Authorization: `Bearer ${token}`,
      'Content-Type': 'application/json'
    });

    return this.http.post(`${this.apiUrl}/creer`, data, { headers }).pipe(
      catchError((err) => {
        console.error('Erreur backend:', err);
        return throwError(() => err);
      })
    );
  }

  getAll(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/all`);
  }


  getAnnoncesByConducteur(idConducteur: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/conducteur/${idConducteur}`);
  }


  supprimerAnnonce(id: number): Observable<any> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders({
      Authorization: `Bearer ${token}`
    });
    return this.http.delete(`${this.apiUrl}/${id}`, { headers });
  }

  modifierAnnonce(id: number, data: any): Observable<any> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders({
      Authorization: `Bearer ${token}`
    });
    return this.http.put(`${this.apiUrl}/${id}`, data, { headers });
  }


}
