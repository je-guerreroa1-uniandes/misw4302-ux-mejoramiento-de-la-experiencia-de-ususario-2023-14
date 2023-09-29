
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
    // TODO: Implement login logic
  }

}

