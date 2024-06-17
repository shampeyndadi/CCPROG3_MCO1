import java.util.ArrayList; 
import java.util.Arrays;

public class Date {
    
    private int  month ;
    private int year ;
    private int  day;
    
    public Date(int month, int year, int day) {
        this.month = month;
        this.year = year;
        this.day = day;
    }

    public String getDate(){
        ArrayList<String> months = new ArrayList<>(Arrays.asList("January", "February", "March", "April",
                                                               "May", "June", "July", "August", "September", 
                                                                "October", "November", "December"));

        return months.get(month - 1) + " | " + this.day +  " | " + this.year; 
    }

}
