package databaseHelper;

import student.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentEntry {
    public boolean createStudentEntry(Connection connection, Student student) throws SQLException {
        int rollNumber = student.getRollNumber();
        String name = student.getName();
        int year = student.getYear();
        double cpi = student.getCpi();
        PreparedStatement p = connection.prepareStatement("insert into student(rollNumber, name, year, cpi)" +
                " values(? ,? ,? ,?);");
        p.setInt(1,rollNumber);
        p.setString(2,name);
        p.setInt(3,year);
        p.setDouble(4,cpi);
        int rows = p.executeUpdate();

        return rows>=1;
    }
}
