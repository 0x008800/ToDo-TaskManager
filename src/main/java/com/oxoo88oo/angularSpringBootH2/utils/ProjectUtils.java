package com.oxoo88oo.angularSpringBootH2.utils;

import com.oxoo88oo.angularSpringBootH2.entities.Task;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public abstract class ProjectUtils {




    /**
     * makes file with contributors names to json
     *
     * @return
     * @throws Exception
     */
    //todo split to 2 methods by logic
    public static String fileToJson()throws Exception{
       ClassLoader classLoader = ProjectUtils.class.getClassLoader();
        File file = new File(classLoader.getResource("static/contributors.txt").getFile());
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null){
            lines.add("\"" + line + "\"");
        }
        bufferedReader.close();
        return lines.toString();
    }

    /**
     *
     * @param resultSet
     * @return
     * @throws Exception
     */
    public static List<Task> resultSetToJson(ResultSet resultSet)throws Exception{
        List<Task> tasks = new ArrayList<>();
        while (resultSet.next()) {
            tasks.add(new Task(resultSet.getInt("id"),
                               resultSet.getString("start_of_task"),
                               resultSet.getString("finish_of_task"),
                                resultSet.getString("name"),
                                resultSet.getString("contributors")));
        }

        return tasks;
    }

//    public static String resultSetToJson(ResultSet resultSet)throws Exception{
//        String temp = "[";
//        while (resultSet.next()){
//            temp += "{\"id\" : " + resultSet.getInt("id") + ", \"start_of_task\" : \"" + resultSet.getDate("start_of_task") +
//                    "\", \"finish_of_task\" : \"" + resultSet.getString("finish_of_task") + "\", \"nameOfTask\" : \"" + resultSet.getString("name") + "\", \"contributors\" : \"" + resultSet.getString("contributors") + "\"},";
//        }
//        temp = temp.substring(0, temp.length() - 1);
//        temp += "]";
//        return temp;
//    }
}
