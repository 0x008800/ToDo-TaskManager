package com.oxoo88oo.angularSpringBootH2.db;

import com.oxoo88oo.angularSpringBootH2.entities.Task;
import com.oxoo88oo.angularSpringBootH2.utils.ProjectUtils;

import java.sql.*;
import java.util.List;

public abstract class ConnectorToDB {
    private final static String createTaskTableQuery = "CREATE TABLE IF NOT EXISTS TASKS(id int auto_increment, start_of_task VARCHAR(255) , finish_of_task VARCHAR(255) , name varchar(255), contributors varchar(255))";
    private final static String dropTaskTableQuery ="DROP TABLE IF EXISTS TASKS";
    private final static String getAllQuery = "SELECT * FROM TASKS";
    private final static String insertQuery = "INSERT INTO TASKS (start_of_task, finish_of_task, name, contributors) values (?,?,?,?)";
    private final static String removeQuery = "DELETE FROM TASKS WHERE ID = ";
    private final static String changeQuery = "UPDATE TASKS SET START_OF_TASK = ?, FINISH_OF_TASK = ?, NAME = ?, CONTRIBUTORS = ? WHERE ID = ?";
    private static Connection connection = null;


    public static void init() throws SQLException {
        connection =  DriverManager.getConnection("jdbc:h2:~/todo", "sa", "");
    }
    public static void createTaskTable()throws Exception{
        init();
        PreparedStatement createPreparedStatement = connection.prepareStatement(createTaskTableQuery);
        createPreparedStatement.executeUpdate();
        createPreparedStatement.close();
        connection.close();
    }

    public static List<Task> getAll() throws Exception {
        init();
        PreparedStatement getAllPreparedStatement = connection.prepareStatement(getAllQuery);
        ResultSet resultSet = getAllPreparedStatement.executeQuery();
        List<Task> tasks = ProjectUtils.resultSetToJson(resultSet);
        getAllPreparedStatement.close();
        connection.close();
        return tasks;
    }

    public static void add(String startOfTask, String finishOfTask, String nameOfTask, String contributors) throws SQLException {
        init();
        PreparedStatement insertPreparedStatement = connection.prepareStatement(insertQuery);
        insertPreparedStatement.setString(1, startOfTask);
        insertPreparedStatement.setString(2, finishOfTask);
        insertPreparedStatement.setString(3, nameOfTask);
        insertPreparedStatement.setString(4, contributors);
        insertPreparedStatement.executeUpdate();
        insertPreparedStatement.close();
        connection.commit();
        connection.close();
    }

    public static void removeTask(int id) throws Exception {
        init();
        PreparedStatement insertPreparedStatement = connection.prepareStatement(removeQuery + id);
        insertPreparedStatement.executeUpdate();
        insertPreparedStatement.close();
        connection.commit();
        connection.close();
    }

    public static void changeTask(int id, String startOfTask, String finishOfTask, String nameOfTask, String contributors)throws Exception {
        init();
        PreparedStatement changePreparedStatement = connection.prepareStatement(changeQuery);
        changePreparedStatement.setString(1, startOfTask);
        changePreparedStatement.setString(2, finishOfTask);
        changePreparedStatement.setString(3, nameOfTask);
        changePreparedStatement.setString(4, contributors);
        changePreparedStatement.setInt(5, id);
        changePreparedStatement.executeUpdate();
        changePreparedStatement.close();
        connection.commit();
        connection.close();
    }

    public static void dropTaskTable()throws Exception {
        init();
        PreparedStatement dropPreparedStatement = connection.prepareStatement(dropTaskTableQuery);
        dropPreparedStatement.executeUpdate();
        dropPreparedStatement.close();
        connection.close();
    }
}
