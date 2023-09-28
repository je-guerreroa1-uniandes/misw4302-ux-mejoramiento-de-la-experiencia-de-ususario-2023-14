import { Component, OnInit } from '@angular/core';
import { FormsModule, ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms'; // Import necessary form-related classes
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit{
  public usuario: string;
  public password: string;
  public loginForm: FormGroup;

  constructor(private router: Router, private formBuilder: FormBuilder) {
    this.usuario = 'usuario';
    this.password = 'password';
    this.loginForm = this.formBuilder.group({
      usuario: ['usuario', Validators.required], // Define your form controls and validators
      password: ['password', Validators.required]
    });
  }

  ngOnInit(): void {
  }

  onSubmitLogin() {
    console.log('Yup, I was click')
    this.router.navigate(['/']);
  }
}
