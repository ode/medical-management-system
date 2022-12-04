import java.util.Scanner;

public abstract class Interaction {
    abstract void printInstructions();
    abstract void options(int i);
    public void loop() {
        printInstructions();
        System.out.println("Enter 0 to exit");
        Scanner sc = new Scanner(System.in);
        while (true) {
            int i = sc.nextInt();
            if (i==0) break;
            options(i);
        }
    }
}
