import { ChangeDetectionStrategy, ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { BookService } from 'src/app/book.service';
import { Book } from '../entity/book';

@Component({
  selector: 'app-buy-book',
  templateUrl: './buy-book.component.html',
  styleUrls: ['./buy-book.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class BuyBookComponent implements OnInit {
  book :Book = new Book(0,"","",new Date(""),0.00,"","","",true,"");
  books:any=[];
  bookId:any;
  constructor(public bookService:BookService, private cd: ChangeDetectorRef) { }

  ngOnInit(): void {
 
  }

  getAllBooks(){
    this.bookService.getAllBooks().subscribe(data => { 
      this.books = data;
      this.cd.detectChanges();
      console.log('data', data)
    }) 
  }
  
  buyBook(){
    console.log(this.bookId);
    this.bookService.buyBook(this.bookId).subscribe(data => { 
      this.cd.detectChanges();
      console.log('data', data)
    }) 
  }

}
