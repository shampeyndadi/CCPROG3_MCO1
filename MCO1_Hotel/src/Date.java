public class Date {
    
    private int day;
    
    public Date(int day) {
        this.day = day;
    }

    public String getDayWithSuffix () {
        if (day >= 1 && day <= 31) { 
            if (day == 11 || day == 12 || day == 13) {
                return day + "th";
            }
    
            switch (day % 10) {
                case 1:
                    return day + "st";  
                case 2:
                    return day + "nd";
                case 3:
                    return day + "rd";
                default:
                    return day + "th";
            }
        }
        
        return "Invalid day";
    }
    
    public int getDay(){
        return day;
    }

    public boolean before(Date other) {
        return this.day < other.day;
        
    }
    

    public boolean after(Date other) {
        return this.day > other.day;
    }
    
}
