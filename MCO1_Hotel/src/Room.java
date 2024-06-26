import java.util.ArrayList;

/**
 * Represents a room in a hotel with attributes and availability management.
 */
public class Room {

    private String roomName;
    private double basePrice;
    private boolean availability;

    /**
     * Constructor to initialize a Room with a given room name.
     * Sets base price to a default value and initializes availability as true.
     * @param roomName The name of the room.
     */
    public Room (String roomName ) {
        this.roomName = roomName;
        this.basePrice = 1299.0;
        this.availability = true;
    }

    /**
     * Updates the base price of the room.
     * @param newPrice The new base price to set.
     */
    public void updateBasePrice (double newPrice) {
        this.basePrice = newPrice;
    }

    /**
     * Changes the availability status of the room.
     * @param status The new availability status (true if available, false otherwise).
     */
    public void changeAvailability(boolean status){
        this.availability = status;
    }

    /**
     * Retrieves the base price of the room.
     * @return The base price of the room.
     */
    public double getRoomPrice(){
        return basePrice;
    }

    /**
     * Retrieves the name of the room.
     * @return The name of the room.
     */
    public String getRoomName(){
        return roomName;
    }

    /**
     * Retrieves the availability status of the room.
     * @return true if the room is available, false otherwise.
     */
    public boolean getAvailability(){
        return availability;
    }

    /**
     * Retrieves a list of available dates for booking this room.
     * Checks reservations to determine dates when the room is not available.
     * @param room The Room object to check availability for.
     * @param reservations List of Reservation objects to check against.
     * @return ArrayList of available dates (days of the month).
     */
    public ArrayList<Integer> getDatesAvailable(Room room, ArrayList<Reservation> reservations) {
        ArrayList<Integer> availableDates = new ArrayList<>();

        for (int day = 1; day <= 31; day++) {
            boolean isAvailable = true;

            for (Reservation reservation : reservations) {
                if (reservation.room().equals(room)) {
                    int checkInDay = reservation.checkInDate().getDay(); 
                    int checkOutDay = reservation.checkOutDate().getDay(); 

                    if (day >= checkInDay && day <= checkOutDay) {
                        isAvailable = false;

                    }
                }
            }

            if (isAvailable) {
                availableDates.add(day);
            }
        }

        return availableDates;
    }
    
    

}
