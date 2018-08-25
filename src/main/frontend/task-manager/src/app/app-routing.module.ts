import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {PageNotFoundComponent} from "./page-not-found/page-not-found.component";
import {AddNewTaskComponent} from "./add-new-task/add-new-task.component";
import {ShowAllTasksComponent} from "./show-all-tasks/show-all-tasks.component";
import {RouterModule, Routes} from "@angular/router";

const routes: Routes = [
  {path: 'add', component: AddNewTaskComponent },
  {path: 'list', component: ShowAllTasksComponent},
  {path: '', redirectTo: 'list', pathMatch: 'full'},
  {path: '**', component: ShowAllTasksComponent}

];

@NgModule({
  exports: [RouterModule],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  declarations: []
})
export class AppRoutingModule { }
