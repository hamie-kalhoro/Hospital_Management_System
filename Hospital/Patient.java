package Hospital;

import java.sql.Connection;
import java.util.Scanner;

public class Patient {
    Connection connection;
    Scanner scanner;

    Patient(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }

    public void addPatient() {
        System.out.println("Add Patient");
        System.out.println("Enter patient Name: ");
        String name = scanner.next();
        System.out.println("Enter patient Age: ");
        int age = scanner.nextInt();
        System.out.println("Enter patient Gender: ");
        String gender = scanner.next();
    }
}
