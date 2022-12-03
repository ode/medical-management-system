// username and password cant have spaces in them

import java.io.*;
import java.util.*;

public class Login implements Records { // have to create new clas records
    static BufferedReader br = null;
    private static HashSet<String> users = new HashSet<>();
    private static HashSet<String> doctors = new HashSet<>();
    private static HashMap<String, List<String>> appointments = new HashMap<>();


    public void initializeStudents() throws IOException {
        File file = new File(System.getProperty("users.dir") + "/src/user.txt");
        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] userDetails = line.split(":");
                users.add(userDetails[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }

    public void initializeTeachers() throws IOException {
        File file = new File(System.getProperty("users.dir") + "/src/doctor.txt");
        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] doctorDetails = line.split(":");
                doctor.add(doctorDetails[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }

    public void initializeAppointments() throws IOException {
        File file = new File(System.getProperty("user.dir") + "/src/appointments.txt");
        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] appointmentDetails = line.split(":");
                List<String> appointmentNames = new ArrayList<>();
                for (int i = 2; i < appointmentDetails.length; i++) {
                    appointments.add(appointmentDetails[i]);
                }
                appointments.put(appointmentDetails[1], appointmentNames);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }

    @Override
    public void populateHashmap() throws IOException {
        Scanner sc = null;
        File file = new File(System.getProperty("user.dir") + "/src/Teacher.txt");
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] lineArr = line.split(":");
            ArrayList<String> coursesList = new ArrayList<>();
            for (int i = 4; i < lineArr.length; i++) {
                coursesList.add(lineArr[i]);
            }
            teacherCourses.put(lineArr[1], coursesList);
        }
        this.coursesTeacher = teacherCourses;

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void populateAll() throws IOException {
//        initializeUsers();
//        initializeStudents();
//        initializeTeachers();
//        populateHashmap();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Login login = new Login();
        login.populateAll();

        Scanner sc = new Scanner(System.in);
        System.out.println("*************************************************************");
        System.out.println("***************  Medc Management System  ******************");
        System.out.println("*************************************************************");
        System.out.println();
        while (true) {
            System.out.println("*********************  Login Page  **************************");
            System.out.println("-----To login as Admin     : input 1");
            System.out.println("-----To login as a User : input 2");
            System.out.println("-----To login as a Doctor : input 3");
            System.out.println("-----To close the Window   : input 4");
            int choice = 0;
            while (true) {
                boolean bool = false;
                try {
                    choice = sc.nextInt();
                    if (choice < 1 || choice > 4) {
                        bool = false;
                        System.out.println("Please input appropriate value!");
                    } else {
                        bool = true;
                    }
                    sc.nextLine();
                } catch (Exception e) {
                    System.out.println("Please input integer value!");
                    sc.nextLine();
                }

                if (bool) {
                    break;
                }
            }
            if (choice == 1) {
                // Login.clearScreen();
                System.out.println("-----Enter Username:");
                String username = sc.next();
                sc.nextLine();
                System.out.println("-----Enter Password:");
                String password = sc.next();
                sc.nextLine();
                try {
                    File file = new File(System.getProperty("user.dir") + "/src/Admin.txt");
                    br = new BufferedReader(new FileReader(file));
                    String[] creds = br.readLine().split(" ");
                    if (creds[0].equals(username) && creds[1].equals(password)) {
                        System.out.println("Welcome " + username);
                        while (true) {
                            Admin admin = new Admin(username, password, students, teachers, courses);
                            System.out.println("-----To view all users                    : input 1");
                            System.out.println("-----To view all appointments                   : input 2");
                            System.out.println("-----To update notice board      : input 3");
                            System.out.println("-----To view revenue   : input 4");
                            System.out.println("-----To view amount owned : input 5");
                            System.out.println("-----To Logout                                : input 6");
                            int inpChoice = 0;
                            while (true) {
                                boolean bool = false;
                                try {
                                    inpChoice = sc.nextInt();
                                    if (inpChoice < 1 || inpChoice > 17) {
                                        bool = false;
                                        System.out.println("Please input appropriate value!");
                                    } else {
                                        bool = true;
                                    }
                                    sc.nextLine();
                                } catch (Exception e) {
                                    System.out.println("Please input integer value!");
                                    sc.nextLine();
                                }

                                if (bool) {
                                    break;
                                }
                            }
                            if (inpChoice == 1) {

                            } else if (inpChoice == 2) {

                            } else if (inpChoice == 3) {

                            } else if (inpChoice == 4) {

                            } else if (inpChoice == 5) {

                            } else if (inpChoice == 6) {
                                break;
                            }
                        }
                    } else {
                        System.out.println("The credentials entered seem incorrect, please cross-verify");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (br != null) {
                        try {
                            br.close();
                        } catch (Exception e) {

                        }
                        ;
                    }
                }
            } else if (choice == 2) {
                Login.clearScreen();
                System.out.println("-----Enter Username:");
                String username = sc.next();
                sc.nextLine();
                System.out.println("-----Enter Password:");
                String password = sc.next();
                sc.nextLine();
                try {
                    File file = new File(System.getProperty("user.dir") + "/src/Student.txt");
                    br = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] details = line.split(":");
                        if (details[1].equals(username) && details[2].equals(password)) {
                            System.out.println("Welcome " + details[3]);
                            while (true) {
                                Student student = new Student(username, password);
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
                                        inpChoice = sc.nextInt();
                                        if (inpChoice < 1 || inpChoice > 6) {
                                            bool = false;
                                            System.out.println("Please input appropriate value!");
                                        } else {
                                            bool = true;
                                        }
                                        sc.nextLine();
                                    } catch (Exception e) {
                                        System.out.println("Please input integer value!");
                                        sc.nextLine();
                                    }

                                    if (bool) {
                                        break;
                                    }
                                }
                                if (inpChoice == 2) {
                                    System.out.println();
                                    System.out.println("Your schduled appointments: ");
                                    student.myAppointments();
                                    System.out.println();
                                } else if (inpChoice == 3) {

                                } else if (inpChoice == 1) {
                                    System.out.println();
                                    System.out.println(" ");
                                    student.get();
                                    System.out.println();
                                } else if (inpChoice == 4) {
                                    System.out.println();
                                    System.out.println("");
                                    student.get();
                                    System.out.println();
                                } else if (inpChoice == 5) {

                                    System.out.println("");
                                    System.out.println();

                                } else if (inpChoice == 6) {
                                    break;
                                }
                            }
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else if (choice == 3) {
                System.out.println("-----Enter Username:");
                String username = sc.next();
                sc.nextLine();
                System.out.println("-----Enter Password");
                String password = sc.next();
                sc.nextLine();
                try {
                    File file = new File(System.getProperty("user.dir") + "/src/Teacher.txt");
                    br = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] details = line.split(":");
                        if (details[1].equals(username) && details[2].equals(password)) {
                            System.out.println();
                            System.out.println("Welcome " + details[3]);
                            while (true) {
                                Teacher teacher = new Teacher(username, password);
                                System.out.println("-----To get all appointments            : input 1");

                                System.out.println("-----To logout                         : input 2");
                                int inpChoice = 0;
                                while (true) {
                                    boolean bool = false;
                                    try {
                                        inpChoice = sc.nextInt();
                                        if (inpChoice < 1 || inpChoice > 5) {
                                            bool = false;
                                            System.out.println("Please input appropriate value!");
                                        } else {
                                            bool = true;
                                        }
                                        sc.nextLine();
                                    } catch (Exception e) {
                                        System.out.println("Please input integer value!");
                                        sc.nextLine();
                                    }

                                    if (bool) {
                                        break;
                                    }
                                }
                                if (inpChoice == 1) {
                                    System.out.println();
                                    System.out.println("Registered courses: ");
                                    teacher.getCourses();
                                    System.out.println();
                                }
                                else if (inpChoice == 5) {
                                    break;
                                }
                            }
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else if (choice == 4) {
                // Login.clearScreen();
                System.exit(0);
            }
        }
    }
}