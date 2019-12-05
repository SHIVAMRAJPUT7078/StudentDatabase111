package main;

import connection.DatabaseConnection;
import databaseHelper.StudentEntry;
import databaseHelper.StudentFetch;
import student.Student;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DatabaseConnection db = new DatabaseConnection();
        db.attemptConnection();

        System.out.println("Enter student roll number : ");
        int rollNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter student name : ");
        String name = scanner.nextLine();
        System.out.println("Enter student year : ");
        int year = scanner.nextInt();
        System.out.println("Enter student CPI : ");
        double cpi = scanner.nextDouble();

        Connection connection = db.getConnection();
        Student student = new Student(rollNumber,name,year,cpi);

        StudentEntry st = new StudentEntry();
        System.out.println(st.createStudentEntry(connection,student));
        StudentFetch sf = new StudentFetch();
        sf.getAllStudentDetails(connection);

        scanner.close();
    }
}
