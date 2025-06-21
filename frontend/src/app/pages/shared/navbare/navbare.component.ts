import {Component, Renderer2} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-navbare',
  imports: [CommonModule, RouterLink],
  templateUrl: './navbare.component.html',
  styleUrl: './navbare.component.css'
})
export class NavbareComponent {

  isMenuOpen = false;

  constructor(private renderer: Renderer2) {}

  toggleMenu() {
    this.isMenuOpen = !this.isMenuOpen;
  }

}
