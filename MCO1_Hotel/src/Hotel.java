import java.util.ArrayList;

public class Hotel {

    private String name;
    private ArrayList<Room> listOfRooms;
    private ArrayList<Reservation> listOfReservations;
    private double earnings;

    public Hotel (String name){
        this.name = name;
        this.listOfRooms = new ArrayList<>();
        this.listOfReservations = new ArrayList<>();
    }

    public void changeHotelName(String newName) {
        this.name = newName;
    }

    public void removeRoom(Room room) { // removes room 
        listOfRooms.remove(room);
        room = null;
    }

    public boolean checkRoom(String name){
        for (int i = 0; i < listOfRooms.size(); i++){
            if (listOfRooms.get(i).getRoomName().equals(name)){
                return true;
            }
        }

        return false;
    }

    public boolean addRoom(Room room) { // creates room for hotel

        if (listOfRooms.size() < 50){
            listOfRooms.add(room);
            return true;
        }

        return false;
    }

    public ArrayList<Reservation> viewReservations(){
        return listOfReservations; // view reservations
    }

    public ArrayList<Room> viewRooms(){
        return listOfRooms; // view rooms 
    }

    public String getHotelName(){
        return name; // gets hotel name 
    }

    public double getTotalEarnings(){
        for(int i = 0; i < listOfReservations.size(); i++){
            earnings += listOfReservations.get(i).TotalPrice();

        }
        
        return earnings;
    }

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
