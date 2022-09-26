import { ChangeDetectionStrategy, ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { BookService } from 'src/app/book.service';

@Component({
  selector: 'app-purchased-book',
  templateUrl: './purchased-book.component.html',
  styleUrls: ['./purchased-book.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class PurchasedBookComponent implements OnInit {

  constructor(public bookService:BookService, private cd: ChangeDetectorRef) { }
  books:any=[];
  ngOnInit(): void {
  }

  getAllPurchasedBooks()
  {
    this.bookService.getAllPurchasedBooks().subscribe(data => { 
      this.books = data;
      this.cd.detectChanges();
      console.log('data', data)
    }) 
  }
  
}
