/**
 * Represents a hotel reservation with guest information, dates, and pricing.
 */
public class Reservation {

    private String guestName;
    private Date  checkInDate;
    private Date checkOutDate;
    private double totalPrice;
    private int numberOfNights;
    private double pricePerNight;
    private Room room;
    
    /**
     * Constructor to initialize a Reservation with guest details, check-in/out dates, and the booked room.
     * Calculates totalPrice, numberOfNights, and pricePerNight based on room price and duration of stay.
     * @param guestName The name of the guest making the reservation.
     * @param checkInDate The check-in Date object.
     * @param checkOutDate The check-out Date object.
     * @param room The Room object that is booked for this reservation.
     */
    public Reservation(String guestName, Date checkInDate, Date checkOutDate, Room room) {
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPrice = (checkOutDate.getDay() - checkInDate.getDay()) * room.getRoomPrice();
        this.room = room;
        this.numberOfNights = checkOutDate.getDay() - checkInDate.getDay();
        this.pricePerNight = room.getRoomPrice();
    }

    /**
     * Retrieves the total price of the reservation.
     * @return The total price of the reservation.
     */
    public double TotalPrice() {
        return totalPrice; // to be fixed
    }

    /**
     * Retrieves the name of the guest for this reservation.
     * @return The guest's name.
     */
    public String guestName(){
        return guestName; // customer name 
    }

     /**
     * Retrieves the check-in Date object for this reservation.
     * @return The check-in Date object.
     */
    public Date checkInDate(){
        return checkInDate; // check in date 
    }

    /**
     * Retrieves the check-out Date object for this reservation.
     * @return The check-out Date object.
     */
    public Date checkOutDate(){
        return checkOutDate; // check out date 
    }

    /**
     * Retrieves the Room object booked for this reservation.
     * @return The booked Room object.
     */
    public Room room(){
        return room; // what room customer books
    }   

    /**
     * Retrieves the number of nights for this reservation.
     * @return The number of nights.
     */
    public int getNumberOfNights(){
        return numberOfNights;
    } 

    /**
     * Retrieves the price per night for the booked room in this reservation.
     * @return The price per night.
     */
    public double getPricePerNight(){
        return pricePerNight;
    } 

    /**
     * Generates and returns a confirmation message detailing the reservation information.
     * @param reserved The Reservation object to generate confirmation for.
     * @return A confirmation message as a String.
     */
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
