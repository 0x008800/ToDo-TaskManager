package com.oxoo88oo.angularSpringBootH2.entities;

public class Task {

    public int id;
    public String startOfTask;
    public String finishOfTask;
    public String nameOfTask;
    public String contributors;

    public Task(){}

    public Task(int id, String startOfTask, String finishOfTask, String nameOfTask, String contributors){
        this.id = id;
        this.startOfTask = startOfTask;
        this.finishOfTask = finishOfTask;
        this.nameOfTask = nameOfTask;
        this.contributors = contributors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartOfTask() {
        return startOfTask;
    }

    public void setStartOfTask(String startOfTask) {
        this.startOfTask = startOfTask;
    }

    public String getFinishOfTask() {
        return finishOfTask;
    }

    public void setFinishOfTask(String finishOfTask) {
        this.finishOfTask = finishOfTask;
    }

    public String getNameOfTask() {
        return nameOfTask;
    }

    public void setNameOfTask(String nameOfTask) {
        this.nameOfTask = nameOfTask;
    }

    public String getContributors() {
        return contributors;
    }

    public void setContributors(String contributors) {
        this.contributors = contributors;
    }
}
