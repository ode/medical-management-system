import java.io.*;
import java.util.Scanner;

public class Appointment {
    private int appointmentId;
    private User user;
    private datetime dateTime;
    private Doctor doctor;

    Appointment() {

    }

    public String getAppointmentDetails(String bitsId) {
        try
        {
            FileInputStream fis = new FileInputStream("userList.txt");
            Scanner sc = new Scanner(fis);
            while(sc.hasNextLine())
            {
                String[] s = sc.nextLine().split(";");
                if(s[1] == bitsId) {
                    return s.toString();
                }
            }
            sc.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void bookAppointment(String s) {
        if(checkAppointment(s)) {
            // append
        }
    }

    private boolean checkAppointment(String appointment) {
        try
        {
            FileInputStream fis = new FileInputStream("appointmentList.txt");
            Scanner sc = new Scanner(fis);
            String[] updatedAppointment = appointment.split(";");
            String[] time = updatedAppointment[1].split(":")
            while(sc.hasNextLine())
            {
//                String[] s = sc.nextLine().split(";");
//                if(s[1] == bitsId) {
//                    return s.toString();
//                }
            }
            sc.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
