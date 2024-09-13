package datamunging2;

public class WeatherLine implements Line {


    private String day;
    private String min;
    private String max;
    private int diff;

    public WeatherLine(String day, String max, String min) {
        this.day = day;
        this.min = min;
        this.max = max;
        this.diff = getDifference(max, min);
    }



    @Override
    public int getDiff() {
        return diff;//return Integer.parseInt(max) - Integer.parseInt(min);
    }

    @Override
    public String getLabel() {
        return day;
    }


    private int getDifference(String max, String min) {
        return Math.abs(Integer.parseInt(max) - Integer.parseInt(min));
    }

    public String getDay() {
        return day;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "day='" + day + '\'' +
                ", min='" + min + '\'' +
                ", max='" + max + '\'' +
                ", diff=" + diff +
                '}';
    }
}


