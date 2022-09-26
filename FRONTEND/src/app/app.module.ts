import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserService } from './user.service';
import { HttpClientModule} from '@angular/common/http';
import { UserformComponent } from './MyComponent/userform/userform.component';

import { CreatebookComponent } from './MyComponent/createbook/createbook.component';
import {Routes, RouterModule } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SearchBooksComponent } from './MyComponent/search-books/search-books.component';
import { PurchasedBookComponent } from './MyComponent/purchased-book/purchased-book.component';
import { BuyBookComponent } from './MyComponent/buy-book/buy-book.component';
const appRoutes:Routes=[
    { path: 'createbook' , component :CreatebookComponent},
  { path:'searchbook', component :SearchBooksComponent},
  { path:'purchasedbook', component :PurchasedBookComponent},{ path:'buybook', component :BuyBookComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    UserformComponent,
    CreatebookComponent,
    SearchBooksComponent,
    PurchasedBookComponent,
    BuyBookComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    BrowserAnimationsModule,
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
