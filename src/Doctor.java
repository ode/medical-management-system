public class Doctor {
    private int doctorID;
    private String consultationType;
    private String name;

    Doctor(int id, String n, String type) {
        doctorID = id;
        name = n;
        consultationType = type;
    }
    
    public int getID() { return doctorID; }
    public String getName() { return name; }
}
