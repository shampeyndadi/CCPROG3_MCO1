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

    boolean checkRoom(String name){
        for (int i = 0; i < listOfRooms.size(); i++){
            if (listOfRooms.get(i).getRoomName().equals(name)){
                return true;
            }
        }

        return false;
    }

    public void addRoom(Room room) { // creates room for hotel

        listOfRooms.add(room);
    }

    public void removeRoom(Room room) { // removes room 
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

    public ArrayList<Room> viewRooms(){
        return listOfRooms; // view reservations
    }

    public String getHotelName(){
        return name;
    }


}
