import { Component } from '@angular/core';
import {FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators} from '@angular/forms';
import {CommonModule, DatePipe, NgForOf} from '@angular/common';
import { AnnonceService, AnnonceTrajetDto } from '../../core/services/annonce/annonce.service';
import { AuthService } from '../../core/services/auth/auth.service';
import { HttpClient } from '@angular/common/http';
import {Router} from '@angular/router';

type TypeColis = 'PETIT' | 'MOYEN' | 'GRAND' | 'FRAGILE' | 'AUTRE';

@Component({
  selector: 'app-conducteur',
  standalone: true,
  imports: [FormsModule, NgForOf, CommonModule, ReactiveFormsModule],
  templateUrl: './conducteur.component.html',
  styleUrls: ['./conducteur.component.css']
})
export class ConducteurComponent {
  annonceForm: FormGroup;
  typeColisList: TypeColis[] = ['PETIT', 'MOYEN', 'GRAND', 'FRAGILE', 'AUTRE'];

  constructor(private fb: FormBuilder, private annonceService: AnnonceService , private router:Router) {
    this.annonceForm = this.fb.group({
      typeMarchandise: ['', Validators.required],
      dimensionMaximales: ['', Validators.required],
      capaciteDisponible: [null, Validators.required],
      lieuDepart: ['', Validators.required],
      etapeIntermediaire: [''],
      destinationFinale: ['', Validators.required],
      dateDepart: ['', Validators.required]
    });
  }

  onSubmit(): void {
    if (this.annonceForm.valid) {
      const conducteurId = Number(localStorage.getItem('id'));

      const formValue = this.annonceForm.value;
      const annonce = {
        ...formValue,
        etapeIntermediaire: formValue.etapeIntermediaire?.split(',').map((e: string) => e.trim()),
        conducteurId,
        dateAnance: new Date().toISOString()
      };

      this.annonceService.creerAnnonce(annonce).subscribe({
        next: (res) => {
          console.log(' Annonce créée avec succès', res);
          alert('Annonce créée avec succès !');
          this.annonceForm.reset();
          this.router.navigate(['/trajrtId']);

        },
        error: (err) => {
          console.error(' Erreur lors de la création de l\'annonce', err);
          alert('Erreur lors de la création.');
        }
      });
    }
  }
}
