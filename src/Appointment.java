import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Appointment {
    Appointment() {

    }

    public String getUserAppointmentDetails(String bitsId) throws IOException {
        try
        {
            String app = null;
            FileInputStream fis = new FileInputStream("appointmentList.txt");
            Scanner sc = new Scanner(fis);
            while(sc.hasNextLine())
            {

                String[] s = sc.nextLine().split(",");
                if(s[1].equals(bitsId)) {
                    app = Arrays.toString(s);
                    break;
                }
            }
            sc.close();
            return app;
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public void bookAppointment(String bitsId) throws IOException{
        System.out.println("With whom you want to book an appointment with? Please enter the Doctor_id.");

        // Timestamp: https://www.javatpoint.com/java-timestamp
        long currentTimestamp = System.currentTimeMillis();
        String appointment = String.valueOf(currentTimestamp);
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

            boolean check = false;
            while(sc.hasNextLine())
            {
                String[] s = sc.nextLine().split(",");
                String dayForCheck = s[3];

                DateTimeFormatter formatterForFile = DateTimeFormatter.ofPattern("HH:mm");
                LocalTime dateTimeCheck = LocalTime.parse(s[4], formatterForFile);

                if(updatedAppointment[2].equals(s[2])) {
                    if(dayForCheck.equals(day)) {

                        // 16:26 - dateTimeCheck
                        // 16:15 - dateTime
                        System.out.println(dayForCheck);
                        System.out.println(dateTime);
                        System.out.println(dateTimeCheck.minusMinutes(10));
                        System.out.println(dateTimeCheck.plusMinutes(10));
                        System.out.println(dateTime.isAfter(dateTimeCheck.minusMinutes(10)));
                        System.out.println(dateTime.isBefore(dateTimeCheck.plusMinutes(10)));


                        if(dateTime.isAfter(dateTimeCheck.minusMinutes(10))
                                && dateTime.isBefore(dateTimeCheck.plusMinutes(10))) {
                            check = true;
                            break;
                        }
                        else {
                            check = false;
                        }
                    }
                    else {
                        check = false;
                    }
                }
            }
            sc.close();
            return !check;
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    private boolean isDoctorAvailable (String appointment) {
        String[] updatedAppointment = appointment.split(",");
        int id = Integer.parseInt(updatedAppointment[2]);
        LocalTime time = LocalTime.parse(updatedAppointment[4]);
        NoticeBoard noticeBoard;
        try {
            noticeBoard = new NoticeBoard();
        }
        catch (Exception e) {
            System.out.println("File not found: noticeboard.txt");
            System.exit(1);
            return false;
        }
        Day day = Day.parseDay(updatedAppointment[3]);
        for (Notice notice : noticeBoard.getNotices()) {
            if (id == notice.getDoctor().getID() && day == notice.getDay()) {
                if (time.compareTo(notice.startTime) >= 0 && time.compareTo(notice.endTime) <= 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public void getTodayAppointments() throws Exception {
        FileInputStream fis = new FileInputStream("appointmentList.txt");
        Scanner sc = new Scanner(fis);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            Day day = Day.parseDay(line.split(",")[3]);
            if (day.ordinal() == LocalDate.now().getDayOfWeek().getValue()) {
                System.out.println(line);
            }
        }

    }
}
