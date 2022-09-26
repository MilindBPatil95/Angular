import { Component, OnInit } from '@angular/core';
import { BookService } from 'src/app/book.service';
import { Book } from '../entity/book';

@Component({
  selector: 'app-createbook',
  templateUrl: './createbook.component.html',
  styleUrls: ['./createbook.component.css']
})
export class CreatebookComponent implements OnInit {
 
 
  book :Book = new Book(0,"","",new Date(""),0.00,"","","",true,"");

  constructor(public bookService:BookService) { }

  createBook(){

    console.log(this.book);
    const observable=this.bookService.createBook(this.book);
    observable.subscribe((response)=> console.log(response));
  }

  ngOnInit(): void {
  }

}
