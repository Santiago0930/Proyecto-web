import { NgModule} from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TiponaveListComponent } from './tiponave/tiponave-list/tiponave-list.component';
import { TiponaveViewComponent } from './tiponave/tiponave-view/tiponave-view.component';
import { TiponaveViewComComponent } from './tiponave/tiponave-view-com/tiponave-view-com.component';
import { EstrellaListComponent } from './estrella/estrella-list/estrella-list.component';
import { PlanetaListComponent } from './planeta/planeta-list/planeta-list.component';
import { PlanetaxProductoListComponent } from './planetaxproducto/planetax-producto-list/planetax-producto-list.component';
import { ProductoListComponent } from './producto/producto-list/producto-list.component';
import { BodeganaveListComponent } from './bodeganave/bodeganave-list/bodeganave-list.component';
import { LoginComponent } from './security/login/login.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'tipoNave/view/:id', component: TiponaveViewComponent},
  { path: 'tipoNave/view/com/:id', component: TiponaveViewComComponent},
  { path: 'tipoNave/list', component: TiponaveListComponent},
  { path: 'estrella/list/cercanas/:id', component: EstrellaListComponent},
  { path: 'planeta/list/:id', component: PlanetaListComponent},
  { path: 'PxP/list/:id', component: PlanetaxProductoListComponent},
  { path: 'bodeganave/list/:id', component: BodeganaveListComponent},
  { path: 'producto/view/:id', component: ProductoListComponent},
  { path: '', pathMatch: 'full', redirectTo: 'login' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes, 
    {
      bindToComponentInputs: true, // Para poder usar @Input en rutas https://angular.io/guide/router
      onSameUrlNavigation: 'reload' // https://stackoverflow.com/a/52512361
    })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
