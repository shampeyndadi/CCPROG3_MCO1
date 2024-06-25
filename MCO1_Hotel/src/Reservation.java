public class Reservation {

    private String guestName;
    private Date  checkInDate;
    private Date checkOutDate;
    private double totalPrice;
    private int numberOfNights;
    private double pricePerNight;
    private Room room;
    
    public Reservation(String guestName, Date checkInDate, Date checkOutDate, Room room) {
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPrice = (checkOutDate.getDay() - checkInDate.getDay()) * room.getRoomPrice();
        this.room = room;
        this.numberOfNights = checkOutDate.getDay() - checkInDate.getDay();
        this.pricePerNight = room.getRoomPrice();
    }

    public double TotalPrice() {
        return totalPrice; // to be fixed
    }

    public String guestName(){
        return guestName; // customer name 
    }

    public Date checkInDate(){
        return checkInDate; // check in date 
    }

    public Date checkOutDate(){
        return checkOutDate; // check out date 
    }

    public Room room(){
        return room; // what room customer books
    }

    public int getNumberOfNights(){
        return numberOfNights;
    } 

    public double getPricePerNight(){
        return pricePerNight;
    } 

    public String displayConfirmation(Reservation reserved){
        return "Customer name: " + reserved.guestName()
            + "\nSuite: " + reserved.room().getRoomName()
            + "\nCheck in: " + reserved.checkInDate.getDayWithSuffix() + " of the month" 
            + "\nExpected check out: " + reserved.checkOutDate.getDayWithSuffix() + " of the month" 
            + "\n*-----------------------------------*\n"
            + "Price Breakdown: "
            + "\nNumber of nights: " + reserved.getNumberOfNights()
            + "\nPrice per night: " + reserved.getPricePerNight()
            + "\nTotal cost of stay: " + reserved.TotalPrice();

    }


}
