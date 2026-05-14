public class Athlete {

    private String name;
    private int age;
    private String sport;

    public Athlete(String name, int age, String sport) {

        this.name = name;
        this.age = age;
        this.sport = sport;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSport() {
        return sport;
    }
}