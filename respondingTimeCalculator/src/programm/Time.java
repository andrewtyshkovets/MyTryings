package programm;

public class Time {
    private int timeInMinutes;

    public Time(String str) {
        this.timeInMinutes = Integer.parseInt(str);
    }

    public int getTimeInMinutes() {
        return timeInMinutes;
    }

    @Override
    public String toString() {
        return "Time{" +
                "timeInMinutes=" + timeInMinutes +
                '}';
    }
}
