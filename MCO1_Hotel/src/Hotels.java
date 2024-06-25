import java.util.Scanner;
import java.util.ArrayList;

public class Hotels {
    private Scanner sc;
    private ArrayList<Hotel> Hotel;

    public Hotels(){
        this.Hotel = new ArrayList<>();
        this.sc = new Scanner(System.in);
    }

    public ArrayList<Hotel> listOfHotels(){
        return Hotel;
    }

    public void createHotel(){
        System.out.print("Enter Hotel name: ");
        String name = sc.nextLine();
        if (!doesHotelExist(Hotel, name)){
            Hotel.add(new Hotel(name));
            System.out.println("\n" + name + " created succesfully\n");
        }else{
            System.out.println("Creation unsuccessful, hotel already exists");
        }

    }

    public void DisplayHotels(){
        System.out.println("[LIST OF HOTELS]\n");
        for (int i = 0; i < listOfHotels().size(); i++){
            if (!(listOfHotels().get(i).viewRooms().isEmpty()))
                System.out.println(i + 1 + ". " + listOfHotels().get(i).getHotelName());
            else
                System.out.println(i + 1 + ". " + listOfHotels().get(i).getHotelName() + " [No rooms available yet]");
        }
    }

    public boolean doesHotelExist(ArrayList<Hotel> Hotel, String name){
        
        for (int i = 0; i < Hotel.size(); i++){
            if (Hotel.get(i).getHotelName().equals(name)){
                return true;
            }
        }

        return false;
    }

    public boolean doesRoomExist(ArrayList<Hotel> Hotel, String roomName) {
        for (Hotel hotel : Hotel) {
            for (Room room : hotel.viewRooms()) {
                if (room.getRoomName().equals(roomName)) {
                    return true;
                }
            }
        }
        
        return false;
    }

    public boolean checkHotels(Hotels hotelLists) {
        for (Hotel hotel : hotelLists.listOfHotels()) {
            if (!(hotel.viewRooms().isEmpty())) {
                return true; 
            }
        }
        return false;
    }

    public boolean checkReservation(Hotels hotelLists) {
        for (Hotel hotel : hotelLists.listOfHotels()) {
            if (!(hotel.viewReservations().isEmpty())) {
                return true; 
            }
        }
        return false;
    }

    public ArrayList<Room> getRemovableRooms(Hotel chosenHotel) {
        ArrayList<Room> removableRooms = new ArrayList<>();
        ArrayList<Reservation> reservations = chosenHotel.viewReservations();
    
        for (Room room : chosenHotel.viewRooms()) {
            boolean hasReservation = false;
    
            for (Reservation reservation : reservations) {
                if (reservation.room().equals(room)) {
                    hasReservation = true;
                }
            }
    
            if (!hasReservation) {
                removableRooms.add(room);
            }
        }
    
        return removableRooms;
    }

}
