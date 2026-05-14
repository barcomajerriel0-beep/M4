public class TrainingSession {

    String athleteName;
    String date;
    String time;
    String location;
    String performance;
    boolean attended;

    public TrainingSession(
            String athleteName,
            String date,
            String time,
            String location
    ) {

        this.athleteName = athleteName;
        this.date = date;
        this.time = time;
        this.location = location;
        this.performance = "";
        this.attended = false;
    }
}

