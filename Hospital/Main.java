package Hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Scanner;

import javax.swing.JOptionPane;

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
            
            while(true) {
                System.out.println("HOSPITAL MANAGEMENT SYSTEM ");
                System.out.println("1. Add Patient");
                System.out.println("2. View Patients");
                System.out.println("3. View Doctors ");
                System.out.println("4. Book Appointment");
                System.out.println("5. EXIT :)");
                System.out.println("Enter your choice: ");
    
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        patient.addPatient();
                        break;
                    case 2:
                        patient.viewPatient();
                        break;
                    case 3:
                        doctor.viewDoctor();
                        break;
                    case 4:
                        patient.bookAppointment();
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid Choice");
                }
    
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void bookAppointment(Patient patient, Doctor doctor, Connection connection, Scanner scanner) {
        System.out.println("Enter Patient's ID: ");
        int patientId = scanner.nextInt();
        System.out.println("Enter Doctor's ID: ");
        int doctorId = scanner.nextInt();
        System.out.println("Enter Appointment Date (YYYY-MM-DD): ");
        String appointmentDate = scanner.next();

        if(patient.getPatientbyId(patientId) && doctor.getDoctorbyId(doctorId)) {
            if(checkDoctorAvaliable(patient, appointmentDate) {
                String AppointmentQuery = "INSERT INTO appointment(patient_id, doctor_id, appointment_date) VALUES(?,?,?)";
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement(AppointmentQuery);
                    preparedStatement.setInt(1, patientId);
                    preparedStatement.setInt(2, doctorId);
                    preparedStatement.setString(3, appointmentDate);

                    int rowsAffected = preparedStatement.executeUpdate();

                    if(rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Appointment Booked!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error Occured!", null, JOptionPane.ERROR_MESSAGE);
                    }
                } catch(SQLException e) {
                    e.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Doctor is not Available", null, JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Either Doctor or Patient not Available!", null, JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
}
