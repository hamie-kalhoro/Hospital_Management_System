package Hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    
    private static final String url = "jdbc:mysql://localhost:3306/Hospital_Management_System";
    private static final String username = "root";
    private static final String password = "hamid.2022";

    public static void main(String[] args) {
        try {
            Class.forName("com.jdbc.sql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Patient patient = new Patient(connection, scanner);
            Doctor doctor = new Doctor(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        while(true) {
            System.out.println("");
        }
    }
}
