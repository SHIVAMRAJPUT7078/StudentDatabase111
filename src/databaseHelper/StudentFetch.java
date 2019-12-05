package databaseHelper;

import student.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentFetch {
    public boolean getAllStudentDetails(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet dataSet = statement.executeQuery("SELECT * FROM Student;");
        System.out.println(String.format("|%12s|%4s|%4s|%4s","Roll Number","Name","Year","CPI"));
        while(dataSet.next()){
            int roll = dataSet.getInt("rollNumber");
            String name = dataSet.getString("name");
            int year = dataSet.getInt("year");
            double cpi = dataSet.getDouble("cpi");
            Student student = new Student(roll,name,year,cpi);
            System.out.println(student);
        }
        return dataSet.next();
    }
}
