import { Component } from '@angular/core';
import { NgIf } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { AuthService, LoginRequest } from '../../../Services/auth.service';
import { NavbarComponent } from '../../../Shared/Navbar/navbar';

@Component({
  selector: 'login-page',
  imports: [FormsModule, RouterLink, NgIf, NavbarComponent],
  templateUrl: './login.html',
})
export class LoginPage {
  credentials: LoginRequest = {
    email: '',
    password: ''
  };

  isLoading = false;
  errorMessage = '';
  successMessage = '';

  constructor(
    private authService: AuthService,
    private router: Router,
    route: ActivatedRoute
  ) {
    if (route.snapshot.queryParamMap.get('registered') === 'true') {
      this.successMessage = 'Account created. You can sign in now.';
    }
  }

  login(): void {
    this.errorMessage = '';
    this.successMessage = '';
    this.isLoading = true;

    this.authService.login(this.credentials).subscribe({
      next: () => {
        this.isLoading = false;
        this.router.navigateByUrl('/quizes');
      },
      error: () => {
        this.isLoading = false;
        this.errorMessage = 'Email or password is incorrect.';
      }
    });
  }
}
