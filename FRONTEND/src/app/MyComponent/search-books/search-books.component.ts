import { ChangeDetectionStrategy, ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { take } from 'rxjs';
import { BookService } from 'src/app/book.service';
import { Book } from '../entity/book';

@Component({
  selector: 'app-search-books',
  templateUrl: './search-books.component.html',
  styleUrls: ['./search-books.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class SearchBooksComponent implements OnInit {

  book :Book = new Book(0,"","",new Date(""),0.00,"","","",true,"");
  books:any=[]
  constructor(private bookService:BookService, private cd: ChangeDetectorRef) { }

  ngOnInit(): void {
  }

  getBooks(){

    if(this.book.category!="")
    {
    
      this.bookService.getBooksByCategory(this.book).pipe(take(1)).subscribe(data => { 
        this.books = data;
        console.log('data', data)
      }) 
    }
    if(this.book.authorFirstName!="")
    {
      this.bookService.getBooksByAuthorName(this.book).pipe(take(1)).subscribe(data => { 
        this.books = data;
        this.cd.detectChanges();
        console.log('data', data)
      }) 
    }
    if(this.book.price!=0)
    {
      this.bookService.getBooksByPrice(this.book).pipe(take(1)).subscribe(data => { 
        this.books = data;
        this.cd.detectChanges();
        console.log('data', data)
      }) 
    }
    if(this.book.publisher!="")
    {
      this.bookService.getBooksByPublisher(this.book).pipe(take(1)).subscribe(data => { 
        this.books = data;
        this.cd.detectChanges();
        console.log('data', data)
      }) 
    }
    this.cd.detectChanges();
  }


  getAllBooks(){
    this.bookService.getAllBooks().pipe(take(1)).subscribe(data => { 
      this.books = data;
      this.cd.detectChanges();
      console.log('data', data)
    }) 
  }
  
}
