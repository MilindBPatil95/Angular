import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/user.service';
import { User } from '../entity/user';

@Component({
  selector: 'app-userform',
  templateUrl: './userform.component.html',
  styleUrls: ['./userform.component.css']
})
export class UserformComponent implements OnInit {

  constructor(public userService:UserService) { }


 user :User =new  User(1,'Milind',26,'milindpatil32@gmail.com');
 users:any=[];
 user1:any;
 deleteUserId:any;
 result:any;
 
  saveUser(){
     console.log("inside user form component")
    const observable= this.userService.saveUser(this.user); 
    observable.subscribe((response)=> console.log(response)
    
    )
  }

  getAllUsers()
  {
    const observable=this.userService.getAllUsers();
    observable.subscribe((users)=>{
      this.users=users;
    })
  }
  getUserById(){
   const observable= this.userService.getUserById(this.user);
   observable.subscribe((user)=>{
   this.user1=user;
  } )
  }


  deleteUserById()
  {
   const observable= this.userService.deleteUserById(this.deleteUserId);
   observable.subscribe((result)=>{
     this.result =result;
   })
  }

  ngOnInit(): void {
  }

}
