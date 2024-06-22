import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SimulateBooking {
    private Hotels HotelLists;
    private Date Date;
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
        String month = sc.nextLine();

        while (!verifyMonth(month)){
            System.out.print("Enter month: ");
            month = sc.nextLine();
        }

        System.out.println("Enter day: ");
        int day = sc.nextInt();

        while(!(day < 31)){
            System.out.println("Enter day: ");
            day = sc.nextInt();
        }

        System.out.println("Enter year: ");
        int year = sc.nextInt();

        while (!(year != 2004)){
            System.out.println("Enter year: ");
            year = sc.nextInt();    
        }

        Date checkIn = new Date(month, year, day);

        exe.clearConsole();

        System.out.print("*------------------------------------*\n\n");

        Hotel chosenHotel = HotelLists.listOfHotels().get(index-1);
        ArrayList<Room> roomsOfChosenHotel = chosenHotel.viewRooms();
        ArrayList<Reservation> reservations = chosenHotel.viewReservations();

        System.out.println(chosenHotel.getHotelName()+"'s available rooms\n");
        
        //loop to display rooms in the hotel that is not yet booked on the provided check in day
        
        System.out.println("Enter room index: ");
        int roomIndex = sc.nextInt();

        System.out.println("Enter customer name: ");
        String name = sc.nextLine();

        System.out.println();
        
    }


}
