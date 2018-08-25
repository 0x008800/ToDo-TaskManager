import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule} from "@angular/common/http";

import { AppComponent } from './app.component';
import { TasklistComponent } from './tasklist/tasklist.component';
import { AppRoutingModule } from './/app-routing.module';
import { AddNewTaskComponent } from './add-new-task/add-new-task.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { ShowAllTasksComponent } from './show-all-tasks/show-all-tasks.component';

@NgModule({
  declarations: [
    AppComponent,
    TasklistComponent,
    AddNewTaskComponent,
    PageNotFoundComponent,
    ShowAllTasksComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
