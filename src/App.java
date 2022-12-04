import java.util.*;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello, World! Welcome to MedC Management System");
        System.out.println("1 - Login");
        System.out.println("2 - Register");

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        if(n == 1) {
            Login l = new Login();
        } else if (n == 2) {
            Register r = new Register();
        } else {
            System.out.println("Wrong input");
        }
    }
}
