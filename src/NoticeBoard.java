import java.time.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;

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
                Notice notice = new Notice(doc, Day.parseDay(day), start, end);
                noticeBoard.add(notice);
            }
        }
    }

    public ArrayList<Notice> getNotices() {
        return new ArrayList<Notice>(noticeBoard); // copy for safety
    }

    public void showNoticeBoard() throws FileNotFoundException {
        Scanner file = new Scanner(new File("noticeboard.txt"));
        while (file.hasNextLine()) {
            System.out.println(file.nextLine());
        }
    }

    public void updateNoticeBoard() throws FileNotFoundException, IOException {
        System.out.println("Enter ID of doctor to modify timings of");
        Scanner sc = new Scanner(System.in);
        String id = sc.next();

        System.out.println("Enter days, semi-colon separated");
        String days = sc.next();

        System.out.println("Enter start time, HH:mm");
        String start = sc.next();

        System.out.println("Enter end time, HH:mm");
        String end = sc.next();

        File newFile = new File("newticeboard.txt");
        newFile.createNewFile();

        FileWriter newf = new FileWriter("newticeboard.txt");
        Scanner old = new Scanner(new File("noticeboard.txt"));
        while (old.hasNextLine()) {
            String s = old.nextLine();
            if (s.startsWith(id)) {
                String[] ok = s.split(",");
                ok[3] = days;
                ok[4] = start + ";" + end;
                newf.write(String.join(",", ok) + '\n');
            } else {
                newf.write(s + '\n');
            }
        }

        Files.move(Paths.get("newticeboard.txt"), Paths.get("noticeboard.txt"), StandardCopyOption.REPLACE_EXISTING);
    }
}