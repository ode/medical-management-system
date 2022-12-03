import java.io.IOException;
import java.util.Scanner;

public class User {
    private int bitsID;
    private String email;
    private String mobileNum;
    private String name;
    private String password;
    User(int id, String n,String num, String mail) {
        bitsID = id;
        name = n;
        mobileNum=num;
        email = mail;
    }

    public int getID() { return bitsID; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String mobileNum(){ return mobileNum; }

    User() {
        String[] details = usersList.split(",");
        if (details[1].equals(bitsID) && details[2].equals(password)) {
            System.out.println("Welcome " + details[3]);
            while (true) {
                User user = new User(bitsID, password);
                System.out.println("-----To get Doctors list                    :  input 1");
                System.out.println("-----To view your appointments              :  input 2");
                System.out.println("-----To view Notice Board                   :  input 3");
                System.out.println("-----To buy medicine                        :  input 4");
                System.out.println("-----To view your due amount                :  input 5");
                System.out.println("-----To return to the Main Menu             :  input 6");
                int inpChoice = 0;
                while (true) {
                    boolean bool = false;
                    try {
                        Scanner sc = new Scanner(System.in);
                        inpChoice = Integer.parseInt(sc.nextLine());
                        if (inpChoice < 1 || inpChoice > 6) {
                            bool = false;
                            System.out.println("Please input appropriate value!");
                        } else {
                            bool = true;
                        }
                        sc.nextLine();
                    } catch (Exception e) {
                        System.out.println("Please input integer value!");
                        Scanner sc = new Scanner(System.in);
                        sc.nextLine();
                    }
                    if (bool) {
                        break;
                    }
                }
                if (inpChoice == 1) {
                    System.out.println();
                    System.out.println("Available Doctors: ");
                    Doctor doc=new DoctorsList();
                    doc.doctorsList();
                    System.out.println();
                } else if (inpChoice == 2) {
                    System.out.println();
                    System.out.println("Your Current Appointments: ");
                    myAppointments();
                    System.out.println();
                } else if (inpChoice == 3) {
                    System.out.println();
                    System.out.println("NOTICE BOARD");
                    NoticeBoard nub = new NoticeBoard();
                    // Displays the existing notice board
                    nub.showNoticeBoard();
                    System.out.println();
                } else if (inpChoice == 4) {
                    System.out.println();
                    System.out.println(": ");
                    Medicine med=new Medicine();
                    med.displayList();
                    //   buyMedicine();
                } else if (inpChoice == 5) {
                    String amntDue=;
                    System.out.println("Your total due amount:"+amntDue);
                    System.out.println();

                } else if (inpChoice == 6) {
                    break;
                }
            }
        }
    }
}

