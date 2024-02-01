package BCA.drive;

import java.sql.*;
import java.util.Scanner;
import BCA.model.student;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//1.load and register
		Class.forName("com.mysql.cj.jdbc.Driver");
		//1
		String url = "jdbc:mysql://localhost:3306/keshav";
		String username = "root";
		String pwd = "gautam7488";
		Connection con = DriverManager.getConnection(url, username, pwd);
		Scanner sc = new Scanner(System.in);
		
		student stud = new student();
		
		
		while(true) {
			menu();
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
            case 1:
                stud.insertStudent(con, sc);
                break;
            case 2:
                stud.displaystudent(con);
                break;
            case 3:
                stud.updatestudentname(con, sc);
                break;
            case 4:
                stud.removeStudent(con, sc);
                break;
            case 5:
                System.out.println("Exiting program. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
        }
			
		}
		
		}
	public static void menu() {
		System.out.println("1. Add New Stiudent");
		System.out.println("2. Display All Students");
		System.out.println("3. Update Details");
		System.out.println("4. Delete a Student");
		System.out.println("5. Exit");
		System.out.println("Your Choice...");
		
		
	}

}
