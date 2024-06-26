import java.util.ArrayList;

/**
 * Represents a hotel with rooms, reservations, and earnings management.
 */
public class Hotel {

    private String name;
    private ArrayList<Room> listOfRooms;
    private ArrayList<Reservation> listOfReservations;
    private double earnings;

    /**
     * Constructor to initialize a Hotel with a given name.
     * @param name The name of the hotel.
     */
    public Hotel (String name){
        this.name = name;
        this.listOfRooms = new ArrayList<>();
        this.listOfReservations = new ArrayList<>();
    }

    /**
     * Changes the name of the hotel.
     * @param newName The new name for the hotel.
     */
    public void changeHotelName(String newName) {
        this.name = newName;
    }

    /**
     * Removes a room from the hotel.
     * @param room The Room object to be removed.
     */
    public void removeRoom(Room room) { // removes room 
        listOfRooms.remove(room);
        room = null;
    }

    /**
     * Checks if a room exists in the hotel.
     * @param name The name of the room to check.
     * @return true if the room exists in the hotel, false otherwise.
     */
    public boolean checkRoom(String name){
        for (int i = 0; i < listOfRooms.size(); i++){
            if (listOfRooms.get(i).getRoomName().equals(name)){
                return true;
            }
        }

        return false;
    }

     /**
     * Adds a room to the hotel.
     * @param room The Room object to add.
     * @return true if the room was added successfully, false if the room limit (50 rooms) is reached.
     */
    public boolean addRoom(Room room) { // creates room for hotel

        if (listOfRooms.size() < 50){
            listOfRooms.add(room);
            return true;
        }

        return false;
    }

    /**
     * Retrieves the list of reservations in the hotel.
     * @return ArrayList of Reservation objects.
     */
    public ArrayList<Reservation> viewReservations(){
        return listOfReservations; // view reservations
    }

    /**
     * Retrieves the list of rooms in the hotel.
     * @return ArrayList of Room objects.
     */
    public ArrayList<Room> viewRooms(){
        return listOfRooms; // view rooms 
    }

    /**
     * Retrieves the name of the hotel.
     * @return The name of the hotel.
     */
    public String getHotelName(){
        return name; // gets hotel name 
    }

    /**
     * Calculates and retrieves the total earnings from reservations in the hotel.
     * @return The total earnings of the hotel.
     */
    public double getTotalEarnings(){
        for(int i = 0; i < listOfReservations.size(); i++){
            earnings += listOfReservations.get(i).TotalPrice();

        }
        
        return earnings;
    }

    /**
     * Calculates the number of rooms booked between specified check-in and check-out dates.
     * @param chosenHotel The Hotel object to check for booked rooms.
     * @param checkIn The check-in date.
     * @param checkOut The check-out date.
     * @return The number of rooms booked during the specified dates.
     */
    public int roomsOnDate(Hotel chosenHotel, Date checkIn, Date checkOut){

        int bookedRooms = 0;    

        ArrayList<Reservation> reserved = chosenHotel.viewReservations();

        for (Reservation reservation : reserved) {
            Date reservationCheckIn = reservation.checkInDate();
            Date reservationCheckOut = reservation.checkOutDate();

            if (!(checkOut.before(reservationCheckIn) || checkIn.after(reservationCheckOut))) {
                bookedRooms++;
            }
        }

        return bookedRooms;
    }   

    /**
     * Retrieves a list of available rooms in the hotel between specified check-in and check-out dates.
     * @param roomsOfChosenHotel The list of rooms in the chosen hotel.
     * @param reservations The list of reservations in the chosen hotel.
     * @param checkOut The check-out date.
     * @param checkIn The check-in date.
     * @return ArrayList of available Room objects.
     */
    public ArrayList<Room> roomAvailable(ArrayList<Room> roomsOfChosenHotel, ArrayList<Reservation> reservations, Date checkOut, Date checkIn) {
        ArrayList<Room> availableRooms = new ArrayList<>();

        for (Room room : roomsOfChosenHotel) {
            boolean isAvailable = true;

            for (Reservation reservation : reservations) {
                if (room.equals(reservation.room())) {
                    if (!(checkOut.before(reservation.checkInDate()) || checkIn.after(reservation.checkOutDate()))) {
                        isAvailable = false;
                    }
                }
            }

            room.changeAvailability(isAvailable);

            if (isAvailable) {
                availableRooms.add(room);
            }
        }

        return availableRooms;
    }
 
}
