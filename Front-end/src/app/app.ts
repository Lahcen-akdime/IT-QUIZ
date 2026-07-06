import { Component, signal } from '@angular/core';
import { Router, RouterLink, RouterLinkActive, RouterModule, RouterOutlet } from '@angular/router';
import { NavbarComponent } from './Shared/Navbar/navbar';

@Component({
  selector: 'app-root',
  imports: [ NavbarComponent , RouterModule, RouterOutlet] ,
  standalone : true ,
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('Front-end');
}
