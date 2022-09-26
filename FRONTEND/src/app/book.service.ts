import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Book } from './MyComponent/entity/book';

const API_URL="http://localhost:8082/digitalBooks";

@Injectable({
  providedIn: 'root'
})
export class BookService {
books:any=[];

  constructor(private httpClient: HttpClient) { }

  createBook(book:Book){
       return this.httpClient.post(API_URL+"/book",book);
  }
  getBooksByCategory(book:Book){
    const observable= this.httpClient.get(API_URL+"/books/search/category/"+book.category);
    observable.subscribe((books)=>{
     this.books=books
     
    });
    return this.books;
  }
  getBooksByAuthorName(book:Book){
    const observable= this.httpClient.get(API_URL+"/books/search/author/"+book.authorFirstName);
    observable.subscribe((books)=>{
     this.books=books 
    });
    return this.books;   
  }
  getBooksByPrice(book:Book){
    const observable= this.httpClient.get(API_URL+"/books/search/price/"+book.price);
    observable.subscribe((books)=>{
     this.books=books 
    });
    return this.books;

  }

  getBooksByPublisher(book:Book){
     const observable= this.httpClient.get(API_URL+"/books/search/publisher/"+book.publisher);
    observable.subscribe((books)=>{
     this.books=books 
    });
    return this.books;
  }

getAllBooks(){
  const observable= this.httpClient.get(API_URL+"/books/search/getAllBooks");
  observable.subscribe((books)=>{
   this.books=books 
  });
  return this.books;
}
}
