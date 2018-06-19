package com.oxoo88oo.angularSpringBootH2.controllers;

import com.oxoo88oo.angularSpringBootH2.db.ConnectorToDB;
import com.oxoo88oo.angularSpringBootH2.utils.ProjectUtils;
import com.oxoo88oo.angularSpringBootH2.entities.Task;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class RESTController {

// curl http://localhost:8080/getall
    @RequestMapping(value = "/getall", method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public  List<Task> getAll(){

        List<Task> tasks = new ArrayList<>();
        try {
            tasks = ConnectorToDB.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasks;
    }

//    @RequestMapping(value = "/getall", method = RequestMethod.GET , produces = "application/json")
//    public String getAll(){
//
//        String temp = "";
//        try {
//            temp = ConnectorToDB.getAll();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return temp;
//    }

// curl -d '{"startOfTask":8887777, "finishOfTask":5455344,"nameOfTask":"gogo", "contributors": "aaa"}' -H "Content-Type: application/json" -X POST http://localhost:8080/add
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
    public String add(@RequestBody Task task){
        try {
            ConnectorToDB.add(task.getStartOfTask(), task.getFinishOfTask(), task.getNameOfTask(), task.getContributors());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
// curl -X DELETE http://localhost:8080/remove/1
    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    public String remove(@PathVariable("id") int id){
        try {
            ConnectorToDB.removeTask(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

// curl -d '{"id": 25 ,"startOfTask":8887777, "finishOfTask":5455344,"nameOfTask":"wtf", "contributors": "25 id"}' -H "Content-Type: application/json" -X PUT http://localhost:8080/change
    @RequestMapping(value = "/change", method = RequestMethod.PUT)
    public  String change(@RequestBody Task task){
        try {
            ConnectorToDB.changeTask(task.getId(), task.getStartOfTask(), task.getFinishOfTask(), task.getNameOfTask(), task.getContributors());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
// curl http://localhost:8080/getcontributors
    @RequestMapping(value = "/getcontributors", method = RequestMethod.GET, produces = "application/json")
    public String getcontributors() throws Exception{
       return ProjectUtils.fileToJson();
    }

// curl http://localhost:8080/createtable
    @RequestMapping(value = "/createtable", method = RequestMethod.GET)
    public void createTable(){
        try {
            ConnectorToDB.createTaskTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/droptable", method = RequestMethod.GET)
    public void dropTable(){
        try {
            ConnectorToDB.dropTaskTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
