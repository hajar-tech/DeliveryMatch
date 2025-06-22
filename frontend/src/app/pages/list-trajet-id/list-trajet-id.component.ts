import {Component, OnInit} from '@angular/core';
import {AnnonceService} from '../../core/services/annonce/annonce.service';
import {DatePipe, NgForOf} from '@angular/common';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-list-trajet-id',
  imports: [
    DatePipe,
    NgForOf,
    RouterLink
  ],
  templateUrl: './list-trajet-id.component.html',
  styleUrl: './list-trajet-id.component.css'
})
export class ListTrajetIdComponent implements OnInit{



  constructor(private annonceService : AnnonceService) {
  }
  annonces: any[] = [];
  ngOnInit(): void {
    this.chargerAnnoncesConducteur();
  }

  chargerAnnoncesConducteur(): void {
    const conducteurId = Number(localStorage.getItem('id'));

    if (!conducteurId) {
      console.warn("ID conducteur non trouvé dans le localStorage");
      return;
    }

    this.annonceService.getAnnoncesByConducteur(conducteurId).subscribe({
      next: (res) => {
        this.annonces = res;
      },
      error: (err) => {
        console.error('Erreur chargement annonces du conducteur', err);
      }
    });
  }

}
