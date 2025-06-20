import { Component } from '@angular/core';
import {CommonModule, NgClass, NgStyle} from '@angular/common';

@Component({
  selector: 'app-home',
  imports: [
    NgClass,
    NgStyle,
    CommonModule
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

  features = [
    {
      icon: 'Truck',
      title: 'Pour les conducteurs',
      description: 'Rentabilisez vos trajets en transportant des colis',
      benefits: ['Revenus complémentaires', 'Optimisation des trajets', 'Communauté fiable'],
      color: 'blue'
    },
    {
      icon: 'Package',
      title: 'Pour les expéditeurs',
      description: 'Envoyez vos colis à prix réduit et en toute sécurité',
      benefits: ['Économies importantes', 'Livraison rapide', 'Suivi en temps réel'],
      color: 'orange'
    },
    {
      icon: 'Leaf',
      title: 'Impact environnemental',
      description: 'Réduisez votre empreinte carbone grâce au co-transport',
      benefits: ['Transport écologique', 'Moins de véhicules', 'Engagement durable'],
      color: 'green'
    }
  ];

  advantages = [
    {
      icon: 'Shield',
      title: 'Sécurité garantie',
      description: 'Conducteurs vérifiés et assurance incluse'
    },
    {
      icon: 'Star',
      title: 'Système de notation',
      description: 'Évaluations transparentes pour tous les utilisateurs'
    },
    {
      icon: 'Clock',
      title: 'Disponible 24/7',
      description: 'Trouvez un trajet à tout moment'
    }
  ];

  getColorClasses(color: string) {
    switch (color) {
      case 'blue':
        return {
          bg: 'bg-blue-50',
          icon: 'text-blue-600',
          border: 'border-blue-200'
        };
      case 'orange':
        return {
          bg: 'bg-orange-50',
          icon: 'text-orange-600',
          border: 'border-orange-200'
        };
      case 'green':
        return {
          bg: 'bg-green-50',
          icon: 'text-green-600',
          border: 'border-green-200'
        };
      default:
        return {
          bg: 'bg-gray-50',
          icon: 'text-gray-600',
          border: 'border-gray-200'
        };
    }
  }



  //statistics
  stats = [
    {
      icon: 'Package',
      value: '15,247',
      label: 'Colis transportés',
      growth: '+23%',
      color: 'blue'
    },
    {
      icon: 'Users',
      value: '8,542',
      label: 'Conducteurs actifs',
      growth: '+18%',
      color: 'green'
    },
    {
      icon: 'TrendingUp',
      value: '95%',
      label: 'Taux de satisfaction',
      growth: '+2%',
      color: 'orange'
    },
    {
      icon: 'Leaf',
      value: '2.5T',
      label: 'CO₂ économisé',
      growth: '+31%',
      color: 'green'
    }
  ];



}
