import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Register {
    private String name;
    private String bitsId;
    private String emailAddress;
    private long phoneNumber;
    Register() {
        try {
            inputDetails();
            Login l = new Login();
        }
        catch(Exception e) {
            System.out.println("Could not register with the given details");
        }
    }

    public String getName() {
        return name;
    }
    public String getBitsId() {
        return bitsId;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public long getPhoneNumber() {
        return phoneNumber;
    }

    private void inputDetails() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the following details to register");
        System.out.println("Enter your Name");
        name = sc.nextLine();
        System.out.println("Enter your BITS ID");
        bitsId = sc.nextLine();
        System.out.println("Enter your BITS Email");
        emailAddress = sc.nextLine();
        while(!checkEmail(emailAddress)) {
            System.out.println("Please enter a valid email address");
            emailAddress = sc.nextLine();
        }
        System.out.println("Enter your phone number");
        phoneNumber = Long.parseLong(sc.nextLine());
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("usersList.txt", true));
            out.write(getName() + "," + getBitsId() + "," + getEmailAddress() + "," + getPhoneNumber() + "\n");
            out.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    private boolean checkEmail(String emailAddress) {
        try {
            String email[] = emailAddress.split("@");
            if(email[1] == "pilani.bits-pilani.ac.in") {
                return true;
            }
            else {
                return false;
            }
        }
        catch(Exception e) {
            return false;
        }
    }
}
