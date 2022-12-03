import java.io.IOException;
import java.util.Scanner;

public class Admin {
    Admin() {
        System.out.println("Hi Admin! Please select from the given options");
        System.out.println("1 - Display list of users");
        System.out.println("2 - Update notice board");
        System.out.println("3 - Display appointments for the day");

        Scanner sc = new Scanner(System.in);
        int choice = Integer.parseInt(sc.nextLine());
        if(choice == 1) {
            User u = new User();
            u.displayUsers();
        }
        else if(choice == 2) {
            try {
                NoticeBoard nub = new NoticeBoard();
                // Displays the existing notice board
                nub.showNoticeBoard();

                // Update the notice board

            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
        else if(choice == 3) {
            try {
                Appointment app = new Appointment();
                app.getTodayAppointments();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Enter correct input");
        }
    }

}
