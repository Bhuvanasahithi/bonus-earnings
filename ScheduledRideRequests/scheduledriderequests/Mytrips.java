package pram.techvedika.com.scheduledriderequests;

public class Mytrips {
    private String[] timings=new String[5];
    private String[] startingpoint=new String[5];
    private String[] endingpoint=new String[5];

    public Mytrips(String[] timings, String[] startingpoint, String[] endingpoint) {
        this.timings = timings;
        this.startingpoint = startingpoint;
        this.endingpoint = endingpoint;
    }
    public Mytrips()
    {

    }

    public String getTimings(int i) {
        return timings[i];
    }

    public void setTimings(String timings,int i) {
        this.timings[i] = timings;
    }

    public String getStartingpoint(int i) {
        return startingpoint[i];
    }

    public void setStartingpoint(String startingpoint,int i) {
        this.startingpoint[i] = startingpoint;
    }

    public String getEndingpoint(int i) {
        return endingpoint[i];
    }

    public void setEndingpoint(String endingpoint,int i) {
        this.endingpoint[i] = endingpoint;
    }
}
