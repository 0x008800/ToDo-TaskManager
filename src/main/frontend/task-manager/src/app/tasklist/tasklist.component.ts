import { Component, OnInit } from '@angular/core';
import { Task } from '../task';
@Component({
  selector: 'app-tasklist',
  templateUrl: './tasklist.component.html',
  styleUrls: ['./tasklist.component.css']
})
export class TasklistComponent implements OnInit {

  tasks: Task[] = [{id: 1, startOfTask: '3-3-323', finishOfTask: '44-34-23', nameOfTask: 'nameee', contributors: 'alex'},
                    {id: 2, startOfTask: '3-3-323', finishOfTask: '44-34-23', nameOfTask: 'nameee', contributors: 'alex'}
                  ]

  constructor() { }

  ngOnInit() {
  }

}
