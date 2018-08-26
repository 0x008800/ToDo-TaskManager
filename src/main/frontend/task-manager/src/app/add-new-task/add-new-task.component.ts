import { Component, OnInit } from '@angular/core';
import {TaskService} from "../task.service";

@Component({
  selector: 'app-add-new-task',
  templateUrl: './add-new-task.component.html',
  styleUrls: ['./add-new-task.component.css']
})
export class AddNewTaskComponent implements OnInit {

  contributors: string[] = ["andrew", "kevin"];

  constructor(private taskService: TaskService) { }

  getContributors(): void{
    this.taskService.getContributors().subscribe( contributors => this.contributors = contributors);
  }

  ngOnInit() {
    this.getContributors();
  }

}
