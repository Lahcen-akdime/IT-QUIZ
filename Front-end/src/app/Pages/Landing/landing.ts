import { Component, OnDestroy, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { NavbarComponent } from '../../Shared/Navbar/navbar';

interface HeroPerson {
  src: string;
  alt: string;
}

@Component({
  selector: 'app-landing',
  standalone: true,
  imports: [CommonModule, RouterLink, NavbarComponent],
  templateUrl: './landing.html',
  styles: [`
    .carousel-container {
      position: relative;
      width: 100%;
      min-height: 100vh;
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
    { src: 'assets/images/dev-2.png', alt: 'Developer preparing for an IT certification exam' },
    { src: 'assets/images/dev-1.png', alt: 'Engineer reviewing notes beside a code editor' },
    { src: 'assets/images/dev-3.png', alt: 'Developer practicing technical questions on a laptop' }
  ];

  stats = [
    { value: 'AI', label: 'question engine' },
    { value: '86%', label: 'readiness target' },
    { value: '24/7', label: 'practice access' }
  ];

  categories = ['Networking', 'Cybersecurity', 'Cloud', 'Databases', 'Java', 'DevOps'];

  features = [
    {
      title: 'Adaptive quiz flow',
      description: 'Questions adjust around the topics you miss, so every session has a purpose.'
    },
    {
      title: 'Exam-style practice',
      description: 'Train with focused prompts, answer choices, scoring, and instant correction.'
    },
    {
      title: 'Formation to quiz',
      description: 'Move from learning paths to generated quizzes without changing context.'
    }
  ];

  steps = [
    { value: '01', label: 'Choose a track' },
    { value: '02', label: 'Generate a quiz' },
    { value: '03', label: 'Review weak areas' }
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
