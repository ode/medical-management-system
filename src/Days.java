enum Day {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    static public Day parseDay(String s) {
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