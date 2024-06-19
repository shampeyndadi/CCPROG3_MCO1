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

    public boolean addRoom(Room room) { // creates room for hotel

        if (listOfRooms.size() <= 50){
            listOfRooms.add(room);
            return true;
        }

        return false;
    }

    public void removeRoom(Room room) { // removes room 
        listOfRooms.remove(room);
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
        return name; // gets hotel name 
    }


}
