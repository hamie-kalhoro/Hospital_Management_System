package Hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        String query = "SELECT * FROM patient";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Patients: ");
            System.out.println("+----------+--------------------+--------+----------+");
            System.out.println("|  Pat:Id  |    Patient Name    |  Age   |  Gender  |");
            System.out.println("+----------+--------------------+--------+----------+");

            while(resultSet.next()) {

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                System.out.println("|%-10s|%-20s|%-8s|%-10s");
                System.out.println("+----------+--------------------+--------+----------+");

            }

        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,
            "Failed to view Patient :(", null, JOptionPane.INFORMATION_MESSAGE);    
        }
    }

    
}