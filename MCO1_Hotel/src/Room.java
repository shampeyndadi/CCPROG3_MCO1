import java.util.ArrayList;

public class Room {

    private String roomName;
    private double basePrice;
    private boolean availability;

    public Room (String roomName ) {
        this.roomName = roomName;
        this.basePrice = 1299.0;
        this.availability = true;
    }

    public void updateBasePrice (double newPrice) {
        this.basePrice = newPrice;
    }

    public void changeAvailability(boolean status){
        this.availability = status;
    }

    public double getRoomPrice(){
        return basePrice;
    }

    public String getRoomName(){
        return roomName;
    }

    public boolean getAvailability(){
        return availability;
    }

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
