import { Component, OnInit } from '@angular/core';
import { BookService } from 'src/app/book.service';
import { Book } from '../entity/book';

@Component({
  selector: 'app-buy-book',
  templateUrl: './buy-book.component.html',
  styleUrls: ['./buy-book.component.css']
})
export class BuyBookComponent implements OnInit {
  book :Book = new Book(0,"","",new Date(""),0.00,"","","",true,"");
  books:any=[];
  constructor(public bookService:BookService) { }

  ngOnInit(): void {
 
  }

  getAllBooks(){

   this.books= this.bookService.getAllBooks();
  }
}
