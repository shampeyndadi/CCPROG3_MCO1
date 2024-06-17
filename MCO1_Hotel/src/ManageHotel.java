import java.util.Scanner;
import java.util.ArrayList;

public class ManageHotel {
    layout layout = new layout();
    Scanner sc = new Scanner(System.in);
    private ArrayList<Hotel> Hotel;

    public ManageHotel(){
        this.Hotel = new ArrayList<>();
    }

    public ArrayList<Hotel> listOfHotels(){
        return Hotel;
    }

    public void createHotel(){
        System.out.print("Enter Hotel name: ");
        String name = sc.nextLine();

        Hotel.add(new Hotel(name));

        System.out.println();
        System.out.println(name + " created succesfully");
        
    }

    public void createRoom(){
        if (Hotel.isEmpty()){
            System.out.println("No hotels to add rooms! Please create a hotel");
        }else{
            System.out.println();
            System.out.println("Available Hotels: ");
            System.out.println();

            for (int i = 0; i < Hotel.size(); i++){
                System.out.println(i + 1 + ". " + Hotel.get(i).getHotelName());
            }
            
            System.out.println();

            System.out.print("Enter Index: ");
            int HotelIndex = sc.nextInt();
            sc.nextLine();

            System.out.println();

            System.out.println("Add room to " + Hotel.get(HotelIndex - 1).getHotelName());
            System.out.print("Enter room name: ");
            String name = sc.nextLine();
            if(!(Hotel.get(HotelIndex - 1).checkRoom(name))){
                Hotel.get(HotelIndex - 1).addRoom(new Room(name));
                System.out.println("Room  " + name + " added to " + Hotel.get(HotelIndex - 1).getHotelName());
            }else{
                System.out.println("Sorry room already exists, please create a different room!");
            }
           
        }
    }

    public void changeName(String name){
        for (int i = 0; i < Hotel.size(); i++){
            System.out.println(i + 1 + ". " + Hotel.get(i).getHotelName());
        }

        int HotelIndex = sc.nextInt();
        sc.nextLine();

        Hotel.get(HotelIndex - 1).changeHotelName(name);

        System.out.println("Hotel successfully changed to " + name);

    }

}
