import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SimulateBooking {
    private Hotels HotelLists;
    private Scanner sc;
    Execute exe = new Execute();

    public SimulateBooking(Hotels HotelLists){
        this.HotelLists = HotelLists;
        this.sc = new Scanner(System.in);
    }

    private boolean verifyMonth(String month){
        ArrayList<String> Month = new ArrayList<>(Arrays.asList("January", "February", "March",
                                                                      "April", "May", "June", "July",
                                                                      "August", "September", "October",
                                                                      "November", "December"));

        for (int i = 0; i < Month.size(); i++)
            if (month.equalsIgnoreCase(Month.get(i))){
                return true;
            }
        
        return false;
    }

    public void bookHotel(){
        HotelLists.DisplayHotels();

        System.out.print("\nChoose hotel [Enter index]: ");
        int index = sc.nextInt();

        System.out.println("\nEnter preferred check in date: ");
        System.out.print("*------------------------------------*\n\n");
        System.out.print("Enter month: ");
        String checkInMonth = sc.nextLine();

        while (!verifyMonth(checkInMonth)){
            System.out.print("Enter month: ");
            checkInMonth = sc.nextLine();
        }

        System.out.println("Enter day: ");
        int checkInDay = sc.nextInt();

        while(!(checkInDay < 31)){
            System.out.println("Enter day: ");
            checkInDay = sc.nextInt();
        }

        System.out.println("Enter year: ");
        int checkInYear = sc.nextInt();

        while (!(checkInYear < 2024)){
            System.out.println("Enter year: ");
            checkInYear = sc.nextInt();    
        }

        exe.clearConsole();

        System.out.println("\nEnter preferred check out date: ");
        System.out.print("*------------------------------------*\n\n");
        System.out.print("Enter month: ");
        String checkOutMonth = sc.nextLine();

        while (!verifyMonth(checkOutMonth)){
            System.out.print("Enter month: ");
            checkOutMonth = sc.nextLine();
        }

        System.out.println("Enter day: ");
        int checkOutDay = sc.nextInt();

        while(!(checkOutDay < 31)){
            System.out.println("Enter day: ");
            checkOutDay = sc.nextInt();
        }

        System.out.println("Enter year: ");
        int checkOutYear = sc.nextInt();

        while (!(checkOutYear < 2024)){
            System.out.println("Enter year: ");
            checkOutYear = sc.nextInt();    
        }

        Date checkIn = new Date(checkInMonth, checkInYear, checkInDay);
        Date checkOut = new Date(checkOutMonth, checkOutYear, checkOutDay);

        exe.clearConsole();
        
        Hotel chosenHotel = HotelLists.listOfHotels().get(index-1);
        ArrayList<Room> roomsOfChosenHotel = chosenHotel.viewRooms();

        System.out.println(chosenHotel.getHotelName()+"'s available rooms on your specified dates\n");
 
        //loop to display rooms in the hotel that is not yet booked on the provided check in day

        for (int i = 0; i < roomsOfChosenHotel.size(); i++){
            if (roomsOfChosenHotel.get(i).getAvailability()){
                System.out.println(i+1 + roomsOfChosenHotel.get(i).getRoomName());
            }
        }
        
        System.out.println("Enter room index: ");
        int roomIndex = sc.nextInt();

        System.out.println("Enter customer name: ");
        String name = sc.nextLine();

        System.out.println();

        Room chosenRoom = roomsOfChosenHotel.get(roomIndex-1);

        chosenHotel.viewReservations().add(new Reservation(name, checkIn, checkOut, chosenRoom));
        chosenRoom.changeAvailability(false);

    }

}
