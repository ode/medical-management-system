import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class User extends Interaction implements FileOperator {
    private String bitsId;
    private String emailAddress;
    private long mobileNumber;
    private String name;

    void printInstructions() {
        System.out.println("Hi User! Please select from the given options");
            System.out.println("1 - Display Notice Board");
            System.out.println("2 - View Appointments");
            System.out.println("3 - Book Appointment");
            System.out.println("4 - Purchase Medicine");
    }
    User(String email) {
        emailAddress = email;
        try {
            getUserdetails(emailAddress);
        }
        catch(Exception e) {
            System.out.println("Could not display user functions");
        }
    }

    void options(int choice, Scanner sc) {
        if(choice == 1) {
            try {
                NoticeBoard n = NoticeBoard.getInstance();
                n.display();
            }
            catch(IOException e) {
                System.out.println("noticeboard file not found");
            }
        }
        else if(choice == 2) {
            try {
                Appointment app = new Appointment();
                String s = app.getUserAppointmentDetails(getBitsId());
                System.out.println(s);
                }
                catch(Exception e) {
                    System.out.println("Could not get appointment details");
                }
            }
        else if(choice == 3) {
            try {
                Appointment app = new Appointment();
                app.bookAppointment(bitsId);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
        else if(choice == 4) {
            System.out.println("Enter the Item Id, Quantity and the Payment Mode(Cash or Later)");
            int itemId = Integer.parseInt(sc.nextLine());
            int quantity = Integer.parseInt(sc.nextLine());
            String mode = sc.nextLine();
            Transaction t = new Transaction(bitsId, itemId, quantity, mode);
        }
        else {
            System.out.println("Enter correct input");
        }
    }

    User() {

    }

    public String getBitsId() { return bitsId; }
    public String getName() { return name; }
    public String getEmail() { return emailAddress; }
    public long mobileNum(){ return mobileNumber; }

    public void display() {
        try
        {
            FileInputStream fis = new FileInputStream("usersList.txt");
            Scanner sc = new Scanner(fis);
            while(sc.hasNextLine()) {
                String s = sc.nextLine();
                if (! (s.contains("admin") || s.contains("medical")))
                    System.out.println(s);
            }
            sc.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void getUserdetails(String email) {
        try
        {
            FileInputStream fis = new FileInputStream("usersList.txt");
            Scanner sc = new Scanner(fis);
            while(sc.hasNextLine())
            {
                String[] user = sc.nextLine().split(",");
                if(user[2].equals(email)) {
                    this.name = user[0];
                    this.bitsId = user[1];
                    this.emailAddress = email;
                    this.mobileNumber = Long.parseLong(user[3]);
                    break;
                }
            }
            sc.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}

