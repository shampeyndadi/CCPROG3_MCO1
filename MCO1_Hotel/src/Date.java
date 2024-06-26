/**
 * Represents a Date with day value and comparison functionalities.
 */
public class Date {
    
    private int day;
    
    /**
     * Constructor to initialize a Date with a specific day.
     * @param day The day value of the Date.
     */
    public Date(int day) {
        this.day = day;
    }

    /**
     * Returns the day value of the Date.
     * @return The day value.
     */
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
    
    /**
     * Returns the day with its suffix (e.g., 1st, 2nd, 3rd, 4th).
     * @return The day with suffix as a String.
     */
    public int getDay(){
        return day;
    }

    /**
     * Checks if this Date is before another Date.
     * @param other The other Date to compare.
     * @return true if this Date is before the other Date, false otherwise.
     */
    public boolean before(Date other) {
        return this.day < other.day;
        
    }
    
    /**
     * Checks if this Date is after another Date.
     * @param other The other Date to compare.
     * @return true if this Date is after the other Date, false otherwise.
     */
    public boolean after(Date other) {
        return this.day > other.day;
    }
    
    /**
     * Checks if this Date is equal to another Date.
     * @param other The other Date to compare.
     * @return true if this Date is equal to the other Date, false otherwise.
     */
    public boolean equals(Date other) {
        return this.day == other.day;
    }
}
