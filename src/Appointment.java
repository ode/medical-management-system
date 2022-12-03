import java.io.*;
import java.util.Scanner;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.sql.Timestamp;

public class Appointment {
    private String getAppointment;
    private int appointmentId;
//    private User user;
//    private datetime dateTime;
    private Doctor doctor;

    Appointment() {

    }

    public String getUserAppointmentDetails(String bitsId) throws Exception{
        try
        {
            String app = null;
            FileInputStream fis = new FileInputStream("appointmentList.txt");
            Scanner sc = new Scanner(fis);
            while(sc.hasNextLine())
            {

                String[] s = sc.nextLine().split(",");
                if(s[1] == bitsId) {
                    app = s.toString();
                    break;
                }
            }
            return app;
            sc.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void bookAppointment(String bitsId) throws Exception{
        System.out.println("With whom you want to book an appointment with? Please enter the Doctor_id.");

        // Timestamp: https://www.javatpoint.com/java-timestamp
        Timestamp instant = Timestamp.from(Instant.now());
        String appointment = instant.toString();
        appointment = appointment + "," + bitsId;

        Scanner sc = new Scanner(System.in);
        appointment = appointment + "," + sc.nextLine();

        // Display the doctor's available day and time - to be implemented
        System.out.println("Please enter the day and the time of the appointment in the given format");
        appointment = appointment + "," + sc.nextLine();
        appointment = appointment + "," + sc.nextLine();

        if(isDoctorAvailable(appointment)) {
            if(checkAppointment(appointment)) {
                System.out.println("Appointment booked");
                try {
                    BufferedWriter out = new BufferedWriter(new FileWriter("appointmentList.txt", true));
                    out.write(appointment + "\n");
                    out.close();
                }
                catch (IOException e) {
                    System.out.println("Appointment could not be booked" + e);
                }
            }
            else {
                System.out.println("Appointment could not be booked since there is " +
                        "an appointment at the given time slot");
            }
        }
        else {
            System.out.println("Sorry, Doctor is not available at the given time");
        }
    }

    private boolean checkAppointment(String appointment) {
        try
        {
            FileInputStream fis = new FileInputStream("appointmentList.txt");
            Scanner sc = new Scanner(fis);
            String[] updatedAppointment = appointment.split(",");

            String day = updatedAppointment[3];

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime dateTime = LocalTime.parse(updatedAppointment[4], formatter);

            int count = 0;
            int numberOfLines = 0;

            while(sc.hasNextLine())
            {
                String[] s = sc.nextLine().split(",");
                String dayForCheck = s[3];

                numberOfLines++;

                DateTimeFormatter formatterForFile = DateTimeFormatter.ofPattern("HH:mm");
                LocalTime dateTimeCheck = LocalTime.parse(updatedAppointment[4], formatterForFile);

                if(updatedAppointment[1].equals(s[1])) {
                    if(dayForCheck.equals(day)) {
                        if(dateTime.isAfter(dateTimeCheck.minusMinutes(10))
                                && dateTime.isBefore(dateTimeCheck.plusMinutes(10))) {
                            count++;
                        }
                        else {
                            return false;
                        }
                    }
                    else {
                        return false;
                    }
                }
            }
            if(count == numberOfLines) {
                return true;
            }
            sc.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    private boolean isDoctorAvailable (String appointment) {
        String[] updatedAppointment = appointment.split(",");
        String doctorId = updatedAppointment[2];
        // call Notice Board for doctor data
//        if() {
//
//        }
    }
    public void getTodayAppointments() throws Exception {
//        try
//        {
            String app = null;
            FileInputStream fis = new FileInputStream("appointmentList.txt");
            Scanner sc = new Scanner(fis);
//            while(sc.hasNextLine())
//            {
//                String[] s = sc.nextLine().split(",");
//                if() {
//                    app = s.toString();
//                    break;
//                }
//            }
//            sc.close();
//        }
//        catch(IOException e)
//        {
//            e.printStackTrace();
//        }
    }
}
