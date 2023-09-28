import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private router: Router) {}
  title = 'OptiTask';
  showDetailedComponent = false;

  showHomeView() {
    this.showDetailedComponent = false;
    this.router.navigate(['']);
  }

  showLoginView() {
    // Navigate to the /login route when the button is clicked
    this.showDetailedComponent = true;
    this.router.navigate(['/login']);
  }

  showUsersView() {

  }
}
