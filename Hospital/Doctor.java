package Hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Doctor {

    Connection connection;

    public Doctor(Connection connection) {
        this.connection = connection;
    }
    
    public void viewDoctor() {
        String query = "SELECT * FROM Doctors";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Doctors:");
            System.out.println("+----------+--------------------+----------------+");
            System.out.println("|  Doc:Id  |    Doctor Name     | Specialization |");
            System.out.println("+----------+--------------------+----------------+");

            while(resultSet.next()) {

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String specialization = resultSet.getString("specialization");
                System.out.printf("|%-10s|%-20s|%-16s|", id, name, specialization);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
