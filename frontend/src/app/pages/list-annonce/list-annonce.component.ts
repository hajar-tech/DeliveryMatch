import {Component, OnInit} from '@angular/core';
import {AnnonceService} from '../../core/services/annonce/annonce.service';
import {DatePipe, NgForOf} from '@angular/common';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-list-annonce',
  imports: [
    NgForOf,
    DatePipe,
    RouterLink
  ],
  templateUrl: './list-annonce.component.html',
  styleUrl: './list-annonce.component.css'
})
export class ListAnnonceComponent implements OnInit{

  constructor(private annonceService: AnnonceService ) {
  }
  annonces: any[] = [];
  ngOnInit(): void {
    this.chargerAnnonces();
  }

  chargerAnnonces(): void {
    this.annonceService.getAll().subscribe({
      next: (res) => this.annonces = res,
      error: (err) => console.error('Erreur chargement annonces', err)
    });
  }
}
