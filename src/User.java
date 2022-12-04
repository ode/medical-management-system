import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class User {
    private String bitsId;
    private String emailAddress;
    private long mobileNumber;
    private String name;
    User(String email) {
        emailAddress = email;
        try {
            getUserdetails(emailAddress);
        }
        catch(Exception e) {
            System.out.println("Could not display user functions");
        }

        System.out.println("Hi User! Please select from the given options");
        System.out.println("1 - Display Notice Board");
        System.out.println("2 - View Appointments");
        System.out.println("3 - Book Appointment");
        System.out.println("4 - Purchase Medicine");

        Scanner sc = new Scanner(System.in);
        int choice = Integer.parseInt(sc.nextLine());
        if(choice == 1) {
            try {
                NoticeBoard nub = new NoticeBoard();
                nub.showNoticeBoard();
            }
            catch(IOException e) {
                e.printStackTrace();
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

    public void displayUsers() throws IOException {
        try
        {
            FileInputStream fis = new FileInputStream("usersList.txt");
            Scanner sc = new Scanner(fis);
            while(sc.hasNextLine())
            {
                System.out.println(sc.nextLine());
            }
            sc.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void getUserdetails(String email) throws IOException{
        try
        {
            FileInputStream fis = new FileInputStream("usersList.txt");
            Scanner sc = new Scanner(fis);
            while(sc.hasNextLine())
            {
                String[] user = email.split(",");
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
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}

