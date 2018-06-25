import { Component, OnInit } from '@angular/core';
import { Task } from '../task';
import {TaskService} from "../task.service";
import {Observable} from "rxjs/internal/Observable";
import {T} from "@angular/core/src/render3";
@Component({
  selector: 'app-tasklist',
  templateUrl: './tasklist.component.html',
  styleUrls: ['./tasklist.component.css']
})
export class TasklistComponent implements OnInit {

  selectedTask: Task;
  tasks: Task[];
    // = [{id: 1, startOfTask: '3-3-323', finishOfTask: '44-34-23', nameOfTask: 'nameee', contributors: 'alex'},
    //                 {id: 2, startOfTask: '3-3-323', finishOfTask: '44-34-23', nameOfTask: 'nameee', contributors: 'alex'}
    //               ]

  constructor(private taskService: TaskService) { }

  ngOnInit() {
    this.getTasks();
  }

  getTasks(): void{
    this.taskService.getTasks().subscribe(tasks => this.tasks = tasks);
  }

  onSelect(task: Task): void{
    this.selectedTask = task;
  }
}
