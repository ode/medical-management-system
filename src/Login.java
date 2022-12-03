import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Login {
    private String emailAddress;
    Login() {
        try {
            loginDetails();
        }
        catch(Exception e) {
            System.out.println("Could not login with the given details");
        }
    }

    private void loginDetails() throws Exception {
        System.out.println("Enter login details");
        Scanner sc = new Scanner(System.in);
        emailAddress = sc.nextLine();
        String[] email = emailAddress.split("@");
        while(!checkEmail(emailAddress)) {
            System.out.println("Please enter a valid email address");
            emailAddress = sc.nextLine();
        }
        if(checkUser(emailAddress)) {
            System.out.println("Successfully logged in");
            if(email[0].equals("admin")) {
                Admin a = new Admin();
            }
            else if(email[0].equals("medicalStoreOwner")) {
                MedicalStoreOwner owner = new MedicalStoreOwner();
            }
            else {
                User u = new User(emailAddress);
            }
        }
        else {
            System.out.println("User with the given credentials does not exist");
            System.out.println("1 - Try again");
            System.out.println("2 - Register");
            int choice = Integer.parseInt(sc.nextLine());
            if (choice == 1) {
                loginDetails();
            }
            else if(choice == 2){
                Register r = new Register();
            }
            else {
                System.out.println("Wrong choice");
            }
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
    private boolean checkUser(String emailAddress) throws Exception{
        try
        {
            FileInputStream fis = new FileInputStream("usersList.txt");
            Scanner sc = new Scanner(fis);
            boolean userFound = false;
            while(sc.hasNextLine())
            {
                String[] s = sc.nextLine().split(",");
                if(s[2].equals(emailAddress)) {
                    userFound = true;
                    break;
                }
                else {
                    userFound = false;
                }
            }
            if(userFound) {
                return true;
            }
            else {
                return false;
            }
            sc.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
