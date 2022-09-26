import { Component, OnInit } from '@angular/core';
import { BookService } from 'src/app/book.service';
import { Book } from '../entity/book';

@Component({
  selector: 'app-search-books',
  templateUrl: './search-books.component.html',
  styleUrls: ['./search-books.component.css']
})
export class SearchBooksComponent implements OnInit {

  book :Book = new Book(0,"","",new Date(""),0.00,"","","",true,"");
  books:any=[]
  constructor(private bookService:BookService) { }

  ngOnInit(): void {
  }

  getBooks(){

    if(this.book.category!="")
    {
    
      this.books= this.bookService.getBooksByCategory(this.book);
     console.log(this.books+"<--------------Books")
    }
    
    if(this.book.authorFirstName!="")
    {
      this.bookService.getBooksByAuthorName(this.book);
    }
    if(this.book.price!=0)
    {
      this.bookService.getBooksByPrice(this.book);
    }
    if(this.book.publisher!="")
    {
      this.bookService.getBooksByPublisher(this.book);
    }
   return this.books;
  }
  
}
