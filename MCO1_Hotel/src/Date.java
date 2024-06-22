import java.util.ArrayList;
import java.util.Arrays;

public class Date {
    
    private String month;
    private int year;
    private int  day;
    
    public Date(String month, int year, int day) {
        this.month = month;
        this.year = year;
        this.day = day;
    }

    public String getDate(){
        return month + " " + day + " " + year;
    }

    public int getMonth(){
        ArrayList<String> Month = new ArrayList<>(Arrays.asList("January", "February", "March",
                                                                      "April", "May", "June", "July",
                                                                      "August", "September", "October",
                                                                      "November", "December"));

        int numMonth = Month.indexOf(month);

        return numMonth - 1;
    }

    public int getDay(){
        return day;
    }

    public int getYear(){
        return year;
    }

}
