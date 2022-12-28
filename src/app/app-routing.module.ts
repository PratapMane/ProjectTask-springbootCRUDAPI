import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { GetproductComponent } from './getproduct/getproduct.component';
import { HeaderComponent } from './header/header.component';
import { ProductlistComponent } from './productlist/productlist.component';
import { ProductregisterComponent } from './productregister/productregister.component';

const routes: Routes = [
  {path:'registerproduct',component:ProductregisterComponent},
  {path:'listofproducts',component:ProductlistComponent},
  {path:'getproduct',component:GetproductComponent},
  {path:'Home',component:HeaderComponent,pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
