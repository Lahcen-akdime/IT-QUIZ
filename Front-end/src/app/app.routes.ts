import { Routes } from '@angular/router';
import { HomePage } from './Shared/Home/Home';
import { LoginPage } from './Pages/Auth/Login/Login';
import { RegisterPage } from './Pages/Auth/Register/Register';
import { QuizPage } from './Pages/Quiz/Quiz';
import { LandingComponent } from './Pages/Landing/landing';

export const routes: Routes = [ 
      { path: '', component: LandingComponent } ,
      { path: 'login', component: LoginPage } , 
      { path: 'register', component: RegisterPage } , 
      { path: 'quizes', component: QuizPage } 
];
