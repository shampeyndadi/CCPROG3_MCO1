import java.util.Scanner;
import java.util.ArrayList;

public class ManageHotel {
    private Scanner sc;
    private ArrayList<Hotel> Hotel;

    public ManageHotel(){
        this.Hotel = new ArrayList<>();
        this.sc = new Scanner(System.in);
    }

    public ArrayList<Hotel> listOfHotels(){
        return Hotel;
    }

    public boolean doesHotelExist(ArrayList<Hotel> Hotel, String name){
        
        for (int i = 0; i < Hotel.size(); i++){
            if (Hotel.get(i).getHotelName().equals(name)){
                return true;
            }
        }

        return false;
    }

    public void DisplayHotels(){
        for (int i = 0; i < listOfHotels().size(); i++){
            System.out.println(i + 1 + ". " + listOfHotels().get(i).getHotelName());
        }
    }

    public boolean doesRoomExist(ArrayList<Hotel> hotels, String roomName) {
        for (Hotel hotel : hotels) {
            for (Room room : hotel.viewRooms()) {
                if (room.getRoomName().equals(roomName)) {
                    return true;
                }
            }
        }
        return false;
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

    public void createRoom(){
        if (Hotel.isEmpty()){
            System.out.println("No hotels present! Please create a hotel first");
        }else{
            DisplayHotels();
            System.out.print("\n\nEnter index: ");
            int index = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter room name: ");
            String roomName = sc.nextLine();
            if (!(doesRoomExist(Hotel, roomName)) || Hotel.get(index - 1).viewRooms().isEmpty()){

                Hotel.get(index - 1).addRoom(new Room(roomName));
                System.out.println("\nRoom added succesfully to hotel!");

            }else{
                System.out.println("\nRoom already exists!");
            }  

        }
    }

    public void changeHotelName(){
        DisplayHotels();
        System.out.print("\n\nEnter index: ");
        int index = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter new name: ");
        String newName = sc.nextLine();
        if (doesHotelExist(Hotel, Hotel.get(index - 1).getHotelName())){
            Hotel.get(index - 1).changeHotelName(newName);
            System.out.print("Hotel name succesfully changed!");
        }
    }

}
