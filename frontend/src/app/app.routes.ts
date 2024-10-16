import { Routes } from '@angular/router';
import { CarroslistComponent } from './components/carros/carroslist/carroslist.component';
import { LoginComponent } from './components/layout/login/login.component';
import { PrincipalComponent } from './components/layout/principal/principal.component';
import { CarrosdetailsComponent } from './components/carros/carrosdetails/carrosdetails.component';
import { MarcaslistComponent } from './components/marcas/marcaslist/marcaslist.component';
import { MarcasdetailsComponent } from './components/marcas/marcasdetails/marcasdetails.component';
import { AcessorioslistComponent } from './components/acessorio/acessorioslist/acessorioslist.component';
import { AcessoriosdetailsComponent } from './components/acessorio/acessoriosdetails/acessoriosdetails.component';
import { loginGuard } from './auth/login.guard';

export const routes: Routes = [
  { path: "", redirectTo: "login", pathMatch: 'full' },
  { path: "login", component: LoginComponent },
  {
    path: "admin", component: PrincipalComponent, canActivate: [loginGuard], children: [
      { path: "carros", component: CarroslistComponent },
      { path: "carros/new", component: CarrosdetailsComponent },
      { path: "carros/edit/:id", component: CarrosdetailsComponent },

      { path: "marcas", component: MarcaslistComponent },
      { path: "marcas/new", component: MarcasdetailsComponent },
      { path: "marcas/edit/:id", component: MarcasdetailsComponent },

      { path: "acessorios", component: AcessorioslistComponent },
      { path: "acessorios/new", component: AcessoriosdetailsComponent },
      { path: "acessorios/edit/:id", component: AcessoriosdetailsComponent }
    ]
  }
];
