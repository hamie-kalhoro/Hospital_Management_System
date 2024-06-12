package Hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Patient {
    static Connection connection;
    static Scanner scanner;

    Patient(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }

    public void addPatient() {
        System.out.println("Add Patient/n");
        System.out.println("Enter patient Name: ");
        String name = scanner.next();
        System.out.println("Enter patient Age: ");
        int age = scanner.nextInt();
        System.out.println("Enter patient Gender: ");
        String gender = scanner.next();

        try {
            String query = "INSERT INTO patient (name, age, gender) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, gender);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null,
                "Patient added successfully :)", null, JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                "Failed to add Patient :(", null, JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null,"try again",null, JOptionPane.INFORMATION_MESSAGE);
            }

        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,
            "Failed to add Patient :(", null, JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void viewPatient() {
        
    }
}
