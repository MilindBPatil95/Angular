import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './MyComponent/entity/user';
const API_URL="http://localhost:8089/user/";
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) { 

  }


  saveUser( user:User){
       console.log("inside user service")
     return this.httpClient.post(API_URL+"saveUser",user);
      
  }

  getUserById(user:User){
   return this.httpClient.get(API_URL+user.userId)
  }

  getAllUsers()
  {
    return this.httpClient.get(API_URL+"getAllUsers");
  }


  deleteUserById(deleteUserId:any)
  {
    return this.httpClient.delete(API_URL+"deleteUser/"+deleteUserId,{responseType:'text' as 'json'});
  }
}
