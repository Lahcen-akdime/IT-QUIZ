import { Component, OnDestroy, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';

interface HeroPerson {
  src: string;
  alt: string;
}

@Component({
  selector: 'app-landing',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './landing.html',
  styles: [`
    .carousel-container {
      position: relative;
      width: 100%;
      height: 100vh;
      overflow: hidden;
    }
    
    .carousel-item {
      position: absolute;
      inset: 0;
      width: 100%;
      height: 100%;
      opacity: 0;
      transition: opacity 1200ms cubic-bezier(0.4, 0, 0.2, 1);
      filter: blur(0px);
      object-fit: cover;
      object-position: center top;
    }
    
    .carousel-item.active {
      opacity: 1;
      z-index: 10;
      filter: blur(0px);
    }
  `]
})
export class LandingComponent implements OnInit, OnDestroy {

  people: HeroPerson[] = [
    { src: 'assets/images/dev-2.png', alt: 'Développeuse devant son environnement de code' },
    { src: 'assets/images/dev-1.png', alt: 'Développeur qui prend des notes devant son écran de code' },
    { src: 'assets/images/dev-3.png', alt: 'Développeur qui prend des notes devant son écran de code' }
  ];

  currentIndex = 0;

  private intervalId?: ReturnType<typeof setInterval>;
  private readonly ROTATION_MS = 5000;

  constructor(private cdr: ChangeDetectorRef) {}

  ngOnInit(): void {
    this.intervalId = setInterval(() => {
      this.currentIndex = (this.currentIndex + 1) % this.people.length;
      this.cdr.markForCheck();
    }, this.ROTATION_MS);
  }

  ngOnDestroy(): void {
    if (this.intervalId) {
      clearInterval(this.intervalId);
    }
  }
}