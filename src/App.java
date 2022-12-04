import java.util.*;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello, World! Welcome to MedC Management System");
        System.out.println("1 - Login");
        System.out.println("2 - Register");
        System.out.println("3 - Exit");

        Scanner sc = new Scanner(System.in);
        boolean done = false;
        while (!done) {
            int n = Integer.parseInt(sc.nextLine());
            if(n == 1) {
                Login l = new Login();
                done = true;
            } else if (n == 2) {
                Register r = new Register();
                done = true;
            } else if (n==3) {
                done = true;
            }
            else {
                System.out.println("Wrong input");
            }
        }
    }
}
