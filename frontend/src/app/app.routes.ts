import { Routes } from '@angular/router';
import {HomeComponent} from './pages/home/home.component';
import {RegisterComponent} from './pages/register/register.component';
import {LoginComponent} from './pages/login/login.component';
import {ConducteurComponent} from './pages/conducteur/conducteur.component';
import {ListAnnonceComponent} from './pages/list-annonce/list-annonce.component';
import {ListTrajetIdComponent} from './pages/list-trajet-id/list-trajet-id.component';

export const routes: Routes = [
  {
    path : '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path : 'home' ,
    component: HomeComponent
  },
  {
    path : 'register',
    component : RegisterComponent
  },
  {
    path : 'login',
    component : LoginComponent
  },
  {
    path: 'conducteur',
    component : ConducteurComponent
  },
  {path : 'list-trajet',
  component :ListAnnonceComponent},
  {
    path : 'trajrtId',
    component : ListTrajetIdComponent
  }



];
