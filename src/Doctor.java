public class Doctor {
    private int doctorID;
    private String name;
    private String email;
    private String mobileNumber;

    Doctor(int id, String n, String mail, String number) {
        doctorID = id;
        name = n;
        email = mail;
        mobileNumber = number;
    }
    
    public int getID() { return doctorID; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getNumber() { return mobileNumber; }
}
