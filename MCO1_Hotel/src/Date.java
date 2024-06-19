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

}
