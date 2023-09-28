
import { Component, OnInit} from '@angular/core';


export class LoginModule { }


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  public usuario: string;
  public password: string;

  constructor() {
    this.usuario = '';
    this.password = '';
  }

  ngOnInit() {
  }

  onSubmitLogin() {
    if (this.usuario === 'usuarioValido' && this.password === 'contrasenaValida') {
      // Credenciales válidas, abrir el mat-sidenav
      console.log('Credenciales correctas');
    } else {
      // Credenciales no válidas, mostrar un mensaje de error o realizar otra acción.
      console.log('Credenciales incorrectas');
    }
  }

}

