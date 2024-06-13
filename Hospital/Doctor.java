package Hospital;

import java.sql.Connection;
import java.util.Scanner;

public class Doctor {

    Connection connection;
    Scanner scanner;

    public Doctor(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }
    
}
