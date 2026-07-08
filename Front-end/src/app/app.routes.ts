import { Routes } from '@angular/router';
import { HomePage } from './Shared/Home/Home';
import { LoginPage } from './Pages/Auth/Login/Login';
import { RegisterPage } from './Pages/Auth/Register/Register';
import { QuizPage } from './Pages/Quiz/Quiz';
import { LandingComponent } from './Pages/Landing/landing';
import { authGuard } from './Services/auth.guard';

export const routes: Routes = [ 
      { path: '', component: LandingComponent } ,
      { path: 'login', component: LoginPage } , 
      { path: 'signin', redirectTo: 'login', pathMatch: 'full' },
      { path: 'register', component: RegisterPage } , 
      { path: 'signup', redirectTo: 'register', pathMatch: 'full' },
      { path: 'quizes', component: QuizPage, canActivate: [authGuard] },
      { path: 'quiz', redirectTo: 'quizes', pathMatch: 'full' },
      { path: '**', redirectTo: '' }
];
