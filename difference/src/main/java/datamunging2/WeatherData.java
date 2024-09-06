package datamunging2;

public class WeatherData {


    private String day;
    private String min;
    private String max;
    private int diff;

    public WeatherData(String day, String max, String min) {
        this.day = day;
        this.min = min;
        this.max = max;
        this.diff = getDifference(max, min);
    }



    public int getDiff() {
        return diff;//return Integer.parseInt(max) - Integer.parseInt(min);
    }



    private int getDifference(String max, String min) {
        return Integer.parseInt(max) - Integer.parseInt(min);
    }

}


