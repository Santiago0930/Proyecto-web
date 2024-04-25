import { NgModule } from '@angular/core';
import { BrowserModule} from '@angular/platform-browser';

import { HttpClientModule, provideHttpClient, withFetch } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { TiponaveViewComponent } from './tiponave/tiponave-view/tiponave-view.component';
import { TiponaveListComponent } from './tiponave/tiponave-list/tiponave-list.component';
import { EstrellaListComponent } from './estrella/estrella-list/estrella-list.component';
import { PlanetaListComponent } from './planeta/planeta-list/planeta-list.component';
import { PlanetaxProductoListComponent } from './planetaxproducto/planetax-producto-list/planetax-producto-list.component';
import { ProductoListComponent } from './producto/producto-list/producto-list.component';
import { BodeganaveListComponent } from './bodeganave/bodeganave-list/bodeganave-list.component';

@NgModule({
  declarations: [
    AppComponent,
    TiponaveViewComponent,
    TiponaveListComponent,
    EstrellaListComponent,
    PlanetaListComponent,
    PlanetaxProductoListComponent,
    ProductoListComponent,
    BodeganaveListComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [provideHttpClient(withFetch())],
  bootstrap: [AppComponent]
})
export class AppModule { }