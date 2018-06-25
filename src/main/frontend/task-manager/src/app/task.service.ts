import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';

import { Observable, of} from 'rxjs';
import {catchError, map, tap} from 'rxjs/operators';


import { Task } from './task';
// import { MessageService } from './message.service';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})

export class TaskService {
  private taskUrl = 'http://localhost:8080/getall';


  constructor(
    private http: HttpClient,
    // private  messageService: MessageService
  ){  }

    getTasks(): Observable<Task[]>{
    return this.http.get<Task[]>(this.taskUrl).pipe(
      tap(tasks => this.log('fetched tasks')),
      catchError(this.handleError('getTasks', []))
      );
    }


    private log(message: string){
      // this.messageService.add('TaskService: ' + message);
    }

    private handleError<T>(operation = 'operation', result?: T){

    return (error: any): Observable<T> => {
        console.error(error);

        this.log('{$operation} failed: ${error.message}');

        return of(result as T);
      };
    }
}
