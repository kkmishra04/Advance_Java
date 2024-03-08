package BCA.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class student {
	public student() {
		super();
		
	}
	public void insertStudent(Connection con, Scanner sc) throws SQLException {
		
		// Create statement
		Statement st = con.createStatement();
		//read student details
		System.out.println("Enter the student Roll Number:");
		int Roll = sc.nextInt();
		System.out.println("Enter the Student Name:");
		String Sname = sc.next();
		System.out.println("Enter Student Age: ");
		String age = sc.next();
		System.out.println("Enter Student Gender: ");
		String Gender = sc.next();
		
		// create sql query string
		//create sql squery string
		String query = String.format("Insert Into student2 values(%d, '%s', %s, '%s') ", Roll, Sname, age, Gender);
		//excecute sql quesry
		int rows = st.executeUpdate(query);
		
		System.out.println(rows + " record inserted!!!");
		
	}
	public void displaystudent(Connection con) throws SQLException {
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("select * from student2");
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+ "\t"+rs.getString(2)+ "\t"+ rs.getString(3)+"\t"+rs.getString(4));
		}
		
	}
	public void updatestudentDetails(Connection con, Scanner sc) throws SQLException {
        Statement st = con.createStatement();

        System.out.println("Enter Student Roll: ");
        int roll = sc.nextInt();

        System.out.println("Enter Student New Name: ");
        String newName = sc.next();

        System.out.println("Enter Student New Age: ");
        String newAge = sc.next();

        

        String query = String.format("UPDATE student2 SET Sname='%s', Age='%s' WHERE Roll = %d", newName, newAge, roll);

        int rowsAffected = st.executeUpdate(query);

        System.out.println(rowsAffected + " records updated!!!");
    }
	
	public void removeStudent(Connection con, Scanner sc) throws SQLException {
		Statement st = con.createStatement();
		System.out.println("Enter Student Roll: ");
		int Roll = sc.nextInt();
		
		int rowAffected = st.executeUpdate("delete from student2 where Roll = "+Roll);
		System.out.println(rowAffected + " recored deleted!!!");
		
		
	}

}
