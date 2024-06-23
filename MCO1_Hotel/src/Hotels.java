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
        System.out.println("[LIST OF HOTELS]\n\n");
        for (int i = 0; i < listOfHotels().size(); i++){
            System.out.println(i + 1 + ". " + listOfHotels().get(i).getHotelName());
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

}
