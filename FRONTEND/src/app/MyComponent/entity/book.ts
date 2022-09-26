import { Author } from "./author";

 export class Book
{

    constructor(
        public bookId :number,
        public title :String,
        public publisher :String,
        public date :  Date,
        public price : number,
        public category:String,
        public content:String,
        public image:String,
        public active :boolean,
        public authorFirstName :String

    ){}



}