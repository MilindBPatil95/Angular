import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
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
  getBooksByCategory(book:Book): Observable<any> {
    return this.httpClient.get(API_URL+"/books/search/category/"+book.category);
    // observable.subscribe((books)=>{
    //  this.books=books
     
    // });
    // return this.books;
  }
  getBooksByAuthorName(book:Book){
  return  this.httpClient.get(API_URL+"/books/search/author/"+book.authorFirstName);
    
  }
  getBooksByPrice(book:Book){
    return this.httpClient.get(API_URL+"/books/search/price/"+book.price);
  }

  getBooksByPublisher(book:Book){
    return this.httpClient.get(API_URL+"/books/search/publisher/"+book.publisher);
   }

getAllBooks(){
  return this.httpClient.get(API_URL+"/books/search/getAllBooks");
  }


  buyBook(bookId:any){
    return this.httpClient.get(API_URL+"/books/search/buyBook/"+bookId);
  }


  getAllPurchasedBooks()
  {
    return this.httpClient.get(API_URL+"/books/search/getAllPurchasedBooks");
  }
}
