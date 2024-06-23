import java.util.Scanner;

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
        System.out.println("Enter index: ");
        int index = sc.nextInt();
        if(Hotel.listOfHotels().get(index - 1).viewRooms().isEmpty()){
            System.out.println("\nThere are no rooms on this hotel!");
        }

        // continue fix reservation first
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
        System.out.println("Hotel succesfully removed!");
    }
    

}
