import { Component } from '@angular/core';
import { NavbarComponent } from '../Navbar/navbar';
import { RouterModule } from '@angular/router';

@Component({
  imports: [NavbarComponent],
  selector: 'home-page',
  templateUrl: './home.html',
})
export class HomePage {}