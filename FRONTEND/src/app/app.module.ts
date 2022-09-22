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
const appRoutes:Routes=[
  {path: 'createbook' , component :CreatebookComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    UserformComponent,
    CreatebookComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
