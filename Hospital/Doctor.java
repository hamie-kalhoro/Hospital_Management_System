package Hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Doctor {

    Connection connection;
    Scanner scanner;

    public Doctor(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }
    
    public void viewDoctor() {
        String query = "SELECT * FROM Doctors";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
