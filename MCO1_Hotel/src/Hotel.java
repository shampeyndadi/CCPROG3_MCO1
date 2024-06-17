import java.util.ArrayList;

class Hotel {

    private String name;
    private ArrayList<Room> listOfRooms;
    private ArrayList<Reservation> listOfReservations;

    public Hotel (String name) {
        this.name = name;
        this.listOfRooms = new ArrayList<>();
        this.listOfReservations = new ArrayList<>();
    }

    public void changeHotelName(String newName) {
        this.name = newName;
    }

    public void addRoom(Room room) { // creates room for hotel

        listOfRooms.add(room);
    }

    public void removeRoom(Room room) {
        listOfRooms.remove(room);
    }

    public boolean checkAvailability(Room room) {

        int i;

        for (i = 0; i < listOfReservations.size(); i++)
            if (listOfReservations.get(i).room().equals(room)){ // iterates over the array list
                return false;
            }

        return true;
    }

    public void removeReservation(Reservation reservation) {
        listOfReservations.remove(reservation); // removes reservation 
    }

    public ArrayList<Reservation> viewReservations(){
        return listOfReservations; // view reservations
    }

    public String getHotelName(){
        return name;
    }


}
