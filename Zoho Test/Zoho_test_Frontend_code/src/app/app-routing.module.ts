import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {NavComponent} from './components/nav/nav.component'
import {LoginComponent} from './components/login/login.component'
import {RegisterComponent} from './components/register/register.component'
import {ForgotPasswordComponent} from './components/forgot-password/forgot-password.component'
import {HomepageComponent} from './components/homepage/homepage.component'

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  {path:"nav",component:NavComponent},
  {path:"login",component:LoginComponent},
  {path:"register",component:RegisterComponent},
  {path:"reset",component:ForgotPasswordComponent},
  {path:"hompage",component:HomepageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
