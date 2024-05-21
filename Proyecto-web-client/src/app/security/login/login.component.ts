import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginDto } from '../../dto/login-dto';
import { AuthService } from '../../shared/auth.service';
import { TripulanteService } from '../../shared/tripulante.service';
import { TipoNaveService } from '../../shared/tipo-nave.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  idNave: number = 0;
  idEstrella: number = 0;
  idTipoNave: number = 0;
  loginDto: LoginDto = new LoginDto("", "");

  constructor(
    private auth: AuthService,
    private router: Router,
    private tripulanteService: TripulanteService,
    private tipoNaveService: TipoNaveService
  ) { }

  ngOnInit(): void {
    this.auth.logout();
  }

  login() {
    this.auth.login(this.loginDto).subscribe({
      next: jwt => {
        console.log(jwt);
        this.tripulanteService.obtenerNaveTripulante(jwt.user).subscribe({
          next: idn => {
            this.idNave = idn;
            this.tipoNaveService.obtenerIdTipoNave(this.idNave).subscribe({
              next: idt => {
                this.idTipoNave = idt;
                this.tipoNaveService.setIdTipoNave(this.idTipoNave);
                this.tripulanteService.setRol(jwt.role);
                if(jwt.role == "PILOTO" || jwt.role == "CAPITAN"){
                this.router.navigate(["tipoNave/view", this.idTipoNave]);
                }
                else if (jwt.role == "COMERCIANTE"){
                this.router.navigate(["/tipoNave/view/com", this.idTipoNave]);
                }
              },
              error: err => { console.error("Error obtaining idTipoNave:", err); }
            });
          },
          error: err => { console.error("Error obtaining idNave:", err); }
        });
      },
      error: err => { console.error("Login failed:", err); }
    });
  }
}
