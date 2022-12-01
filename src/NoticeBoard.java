import java.time.LocalDateTime;

public class NoticeBoard {
    private Doctor doctor;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    NoticeBoard(Doctor d, LocalDateTime start, LocalDateTime end) {
        doctor = d;
        startTime = start;
        endTime = end;
    }

    
}
