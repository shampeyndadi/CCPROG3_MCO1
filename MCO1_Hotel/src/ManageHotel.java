import java.util.Scanner;
import java.util.ArrayList;

public class ManageHotel {
    private Scanner sc;
    private Hotels Hotel;

    public ManageHotel(Hotels Hotel){
        this.sc = new Scanner(System.in);
        this.Hotel = Hotel;
    }

    public void AddRooms(){
        if (Hotel.listOfHotels().isEmpty()){
            System.out.println("No hotels present! Please create a hotel first");
        }else{
            int i = 0;

            for (int j = 0; j < Hotel.listOfHotels().size(); j++){
                System.out.println(j + 1 + ". " + Hotel.listOfHotels().get(j).getHotelName());
            }

            System.out.print("\n\nEnter index: ");
            int index = sc.nextInt();
            sc.nextLine();

            System.out.print("\nEnter number of rooms you wish to add: ");
            int numRooms = sc.nextInt();
            sc.nextLine();
            while (i != numRooms){
                System.out.print("\nEnter room name: ");
                String roomName = sc.nextLine();
                if (!(Hotel.doesRoomExist(Hotel.listOfHotels(), roomName)) || Hotel.listOfHotels().get(index - 1).viewRooms().isEmpty()){

                    Hotel.listOfHotels().get(index - 1).addRoom(new Room(roomName));
                    System.out.println("\nRoom added succesfully to hotel!");
                    i++;
                }else{
                    System.out.println("\nError! Room already exists!");
                }  
            }

            System.out.println("\nRoom\\s created succesfully!");
        }
    }

    public void RemoveRooms(){
        Hotel.DisplayHotels();
        System.out.print("\nEnter index: ");
        int index = sc.nextInt();

        while (index <= 0 || index > Hotel.listOfHotels().size() || Hotel.listOfHotels().get(index - 1).viewRooms().isEmpty()) {
            if (index <= 0 || index > Hotel.listOfHotels().size()) {
                System.out.print("\nInvalid hotel index. Please enter a valid index: ");
            } else {
                System.out.print("\nThis hotel has no rooms yet. Please choose another hotel [Enter index]: ");
            }

            index = sc.nextInt();
            sc.nextLine();
        }

        Hotel chosenHotel = Hotel.listOfHotels().get(index-1);
        ArrayList<Room> removeRooms = getRemovableRooms(chosenHotel);

        if (removeRooms.isEmpty()){
            System.out.println("All rooms currently have a booking!");
        }else{
            System.out.println("Rooms that doesn't have an active reservation:\n");
            for (int i = 0; i < removeRooms.size(); i++){
                System.out.println(i+1 + ". " + removeRooms.get(i).getRoomName());
            }
            
            System.out.print("Enter room index you wish to remove: ");
            int roomIndex = sc.nextInt();

            while (index <= 0 || index > removeRooms.size()){
                System.out.print("Error! Room index does not exist. Enter index: ");
                roomIndex = sc.nextInt();
            }

            chosenHotel.removeRoom(removeRooms.get(roomIndex-1));

            System.out.println("Room successfully removed!");
        }

    }

    public void changeHotelName(){
        Hotel.DisplayHotels();
        System.out.print("\n\nEnter index: ");
        int index = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter new name: ");
        String newName = sc.nextLine();
        if (Hotel.doesHotelExist(Hotel.listOfHotels(), Hotel.listOfHotels().get(index - 1).getHotelName())){
            Hotel.listOfHotels().get(index - 1).changeHotelName(newName);
            System.out.print("Hotel name succesfully changed!");
        }
    }

    public void removeHotel(){
        Hotel.DisplayHotels();
        Hotel.DisplayHotels();
        System.out.print("\n\nEnter index: ");
        int index = sc.nextInt();
        sc.nextLine();
        Hotel.listOfHotels().remove(Hotel.listOfHotels().get(index - 1));
        System.out.println("Hotel succesfully removed!\n");
    }
    
    private ArrayList<Room> getRemovableRooms(Hotel chosenHotel) {
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
