import java.time.*;
import java.util.*;
import java.io.*;

class Notice {
    private Doctor doctor;
    private Day day;
    public LocalTime startTime; // public access is fine because immutable objects
    public LocalTime endTime;

    Notice(Doctor d, Day da, LocalTime start, LocalTime end) {
        doctor = d;
        day = da;
        startTime = start;
        endTime = end;
    }

    public Day getDay() {return day;}
    public Doctor getDoctor() {return doctor;}
}

public class NoticeBoard {
    private ArrayList<Notice> noticeBoard;

    NoticeBoard() throws FileNotFoundException {
        noticeBoard = new ArrayList<Notice>();
        File file = new File("noticeboard.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String[] s = sc.nextLine().split(",");
            int id = Integer.parseInt(s[0]);
            // 1001,Dr. Burnwal,OPD,M;T;W;Th;F,10:00;13:00
            String name = s[1], type = s[2];
            Doctor doc = new Doctor(id, name, type);

            for (String day: s[3].split(";")) {
                String[] times = s[4].split(";");
                LocalTime start = LocalTime.parse(times[0]);
                LocalTime end = LocalTime.parse(times[1]);
                Notice notice = new Notice(doc, parseDay(day), start, end);
                noticeBoard.add(notice);
            }
        }
    }

    public ArrayList<Notice> getNotices() {
        return new ArrayList<Notice>(noticeBoard); // copy for safety
    }

    public void showNoticeBoard() throws FileNotFoundException{
        Scanner file = new Scanner(new File("noticeboard.txt"));
        while (file.hasNextLine()) {
            System.out.println(file.nextLine());
        }
    }

    public Day parseDay(String s) {
        switch (s) {
            case "M" : return Day.MONDAY;
            case "T" : return Day.TUESDAY;
            case "W" : return Day.WEDNESDAY;
            case "Th": return Day.THURSDAY;
            case "F" : return Day.FRIDAY;
            case "S" : return Day.SATURDAY;
            default  : return Day.SUNDAY;
        }
    }
}