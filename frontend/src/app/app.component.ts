import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {NavbareComponent} from './pages/shared/navbare/navbare.component';
import {HomeComponent} from './pages/home/home.component';
import {FooterComponent} from './pages/shared/footer/footer.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, NavbareComponent,  FooterComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'frontend';
}
