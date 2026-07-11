import { Component } from '@angular/core';
import { NgIf } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { AuthService, RegisterRequest } from '../../../Services/auth.service';
import { NavbarComponent } from '../../../Shared/Navbar/navbar';

@Component({
  selector: 'register-page',
  imports: [FormsModule, RouterLink, NgIf, NavbarComponent],
  templateUrl: './register.html',
})
export class RegisterPage {
  account: RegisterRequest = {
    name: '',
    email: '',
    password: '',
    confirmedPassword: ''
  };

  isLoading = false;
  errorMessage = '';

  constructor(
    private authService: AuthService,
    private router: Router
  ) {}

  register(): void {
    this.errorMessage = '';

    if (this.account.password !== this.account.confirmedPassword) {
      this.errorMessage = 'Passwords do not match.';
      return;
    }

    this.isLoading = true;

    this.authService.register(this.account).subscribe({
      next: () => {
        this.isLoading = false;
        this.router.navigate(['/login'], { queryParams: { registered: true } });
      },
      error: () => {
        this.isLoading = false;
        this.errorMessage = 'Registration failed. Please verify your information.';
      }
    });
  }
}
