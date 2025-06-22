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


  supprimerAnnonce(annonce: any): void {
    if (confirm('Êtes-vous sûr de vouloir supprimer cette annonce ?')) {
      this.annonceService.supprimerAnnonce(annonce.id).subscribe({
        next: () => {
          alert('Annonce supprimée avec succès');
          this.chargerAnnoncesConducteur(); // Recharge la liste
        },
        error: (err) => {
          console.error('Erreur lors de la suppression', err);
          alert('Erreur lors de la suppression');
        }
      });
    }
  }


}
