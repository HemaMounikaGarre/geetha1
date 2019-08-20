import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SearchbynameComponent } from './searchbyname/searchbyname.component';
import { SearchComponent } from './search/search.component';



const routes: Routes = [
  {path:'searchbyname',component:SearchbynameComponent},
  {
path:'searchbyid',component:SearchComponent
  },
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
