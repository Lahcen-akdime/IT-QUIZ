import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive } from '@angular/router';
import { NgIf } from '@angular/common';
import { AuthService } from '../../Services/auth.service';

@Component({
  selector: 'navbar',
  templateUrl: './navbar.html',
  imports: [RouterLink, RouterLinkActive, NgIf]
})
export class NavbarComponent {
  constructor(public authService: AuthService) {}

  logout(): void {
    this.authService.logout();
  }
}
